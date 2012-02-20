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
package org.nabucco.framework.mda.model.text.confluence.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.MdaModel;
import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.file.MdaFileCreator;
import org.nabucco.framework.mda.model.file.path.MdaPathTypes;
import org.nabucco.framework.mda.model.file.path.PathLocator;
import org.nabucco.framework.mda.model.file.path.PathLocatorFactory;
import org.nabucco.framework.mda.model.text.confluence.ConfluenceModel;
import org.nabucco.framework.mda.model.text.confluence.ConfluenceModelException;
import org.nabucco.framework.mda.model.text.confluence.ast.page.ConfluencePage;
import org.nabucco.framework.mda.model.text.confluence.ast.util.ConfluencePrintVisitor;

/**
 * ConfluenceFileCreator
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class ConfluenceFileCreator extends MdaFileCreator<ConfluenceModel> {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(ConfluenceFileCreator.class);

    private PathLocator<ConfluenceModel> pathLocator;

    private final static String NABUCCO_EXT = ".nbcdoc";

    /**
     * Creates a new {@link ConfluenceFileCreator} instance.
     * 
     * @param model
     * @param rootDir
     */
    public ConfluenceFileCreator(MdaModel<ConfluenceModel> model, String rootDir) {
        super(model, rootDir);
        
        this.pathLocator = new PathLocatorFactory<ConfluenceModel>().getPathLocator(MdaPathTypes.Confluence, rootDir);
    }

    @Override
    protected synchronized void createConcreteFiles() throws ConfluenceModelException {

        ConfluenceModel model = super.getModel();

        for (ConfluencePage page : model.getPages()) {

            String path = this.pathLocator.getPath(model,page.getProjectName()) + page.getPageType() + File.separatorChar;
            String name = page.getName() + NABUCCO_EXT;

            ConfluencePrintVisitor printVisitor = new ConfluencePrintVisitor();
            StringBuilder pageStringBuilder = new StringBuilder();
            page.accept(printVisitor, pageStringBuilder);

            try {
                boolean noChange = super.compareFileContent(path + name, pageStringBuilder.toString());

                if (!noChange) {
                    this.createFile(name, path, pageStringBuilder.toString());
                } else {
                    logger.debug("Java file already exists: ", path, name);
                }
            } catch (ConfluenceModelException jme) {
                logger.error("Java file ", name, " cannot be created.");
                throw jme;
            } catch (ModelException me) {
                logger.error("Java file ", name, " cannot be created.");
                throw new ConfluenceModelException("Error creating Java file '" + name + "'.", me);
            } catch (Exception e) {
                logger.error("Java file ", name, " cannot be created.");
                throw new ConfluenceModelException("Error creating Java file '" + name + "'.", e);
            }

        }
    }

    /**
     * Creates or updates the java file.
     * 
     * @param fileName
     *            the file name
     * @param path
     *            the file path
     * @param content
     *            the file content
     * 
     * @throws JavaModelException
     *             when the file cannot be saved
     */
    private void createFile(String fileName, String path, String content) throws ConfluenceModelException {

        PrintWriter writer;

        File file = new File(path);
        file.mkdirs();
        file = new File(path + fileName);

        boolean exists = file.exists();

        try {
            writer = new PrintWriter(file);
        } catch (IOException e) {
            logger.error("Confluence file ", fileName, " cannot be created.");
            throw new ConfluenceModelException("Error creating Confluence file '" + fileName + "'.", e);
        }

        writer.print(content);
        writer.flush();
        writer.close();

        if (!exists) {
            logger.info("Confluence file created: ", fileName);
        } else {
            logger.info("Confluence file updated: ", fileName);
        }
        super.getFileList().add(file);
    }

}
