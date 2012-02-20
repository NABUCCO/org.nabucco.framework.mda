/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.mda.model.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.MdaModel;
import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.ModelImplementation;

/**
 * MdaFileCreator
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public abstract class MdaFileCreator<T extends ModelImplementation> {

    private MdaModel<T> model;

    private String rootDir;

    private List<File> fileList;

    private MdaFileComparator fileComparator;

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            MdaFileCreator.class);

    /**
     * Constructs a new {@link MdaFileCreator} instance.
     * 
     * @param model
     *            the model to create files for.
     * @param rootDir
     *            the root directory
     */
    public MdaFileCreator(MdaModel<T> model, String rootDir) {
        if (model == null) {
            throw new IllegalArgumentException("Model must be defined.");
        }

        if (rootDir == null) {
            throw new IllegalArgumentException("Root directory must be defined.");
        }

        this.model = model;
        this.rootDir = rootDir;
        this.fileList = new ArrayList<File>();
    }

    /**
     * Create all necessary {@link File} files for the model implementation.
     * 
     * @throws ModelException
     */
    public void createFiles() throws ModelException {

        T modelImplementation = this.model.getModel();

        if (modelImplementation == null) {
            logger.error("Model implementation is null.");
            throw new ModelException("Cannot create file(s) for model [null].");
        }

        try {
            this.createConcreteFiles();
        } catch (ModelException me) {
            logger.error(me, "Error creating " + modelImplementation.getType() + " files.");
            throw me;
        } catch (Exception e) {
            logger.error(e, "Error creating " + modelImplementation.getType() + " files.");
            throw new ModelException("Error creating " + modelImplementation.getType() + " files.",
                    e);
        }
    }

    /**
     * Returns the model implementation.
     * 
     * @return the model implementation
     * 
     * @throws ModelException
     */
    protected T getModel() {
        return this.model.getModel();
    }

    /**
     * Returns the root directory.
     * 
     * @return the root directory
     */
    protected String getRootDir() {
        return this.rootDir;
    }

    /**
     * Creates {@link ModelImplementation} dependend files.
     * 
     * @throws ModelException
     */
    protected abstract void createConcreteFiles() throws ModelException;

    /**
     * Compares a string with a file for content equalty.
     * 
     * @param pathName
     *            path of the old file
     * @param content
     *            the new content
     * 
     * @return <b>true</b> if the file contains exactly the content, <b>false</b> if not.
     * 
     * @throws ModelException
     */
    protected boolean compareFileContent(String pathName, String content) throws ModelException {
        if (this.fileComparator == null) {
            this.fileComparator = new MdaFileComparator();
        }
        return this.fileComparator.compare(new File(pathName), content);
    }

    /**
     * Returns the list of files.
     * 
     * @return the file list.
     */
    protected List<File> getFileList() {
        return this.fileList;
    }

}
