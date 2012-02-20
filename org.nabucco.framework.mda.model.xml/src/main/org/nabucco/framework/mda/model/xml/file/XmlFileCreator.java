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
package org.nabucco.framework.mda.model.xml.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.MdaModel;
import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.file.MdaFileCreator;
import org.nabucco.framework.mda.model.xml.XmlDocument;
import org.nabucco.framework.mda.model.xml.XmlModel;
import org.nabucco.framework.mda.model.xml.XmlModelException;

/**
 * XmlFileCreator
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class XmlFileCreator extends MdaFileCreator<XmlModel> {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            XmlFileCreator.class);

    /**
     * Creates a new {@link XmlFileCreator} instance.
     * 
     * @param model
     *            the XML model
     * @param rootDir
     *            the root directory
     */
    public XmlFileCreator(MdaModel<XmlModel> model, String rootDir) {
        super(model, rootDir);
    }

    @Override
    protected synchronized void createConcreteFiles() throws XmlModelException {

        XmlModel model = super.getModel();

        for (XmlDocument document : model.getDocuments()) {

            String name = document.getFileName();
            String path = this.getPath(document);

            String xml = document.toXml().replaceAll("\n", "\r\n");

            try {
                boolean noChange = super.compareFileContent(path + name, xml);

                if (!noChange) {
                    this.createFile(name, path, xml);
                } else {
                    logger.debug("XML file already exists: ", path, name);
                }
            } catch (XmlModelException xme) {
                logger.error("XML file ", name, " cannot be created.");
                throw xme;
            } catch (ModelException me) {
                logger.error("XML file ", name, " cannot be created.");
                throw new XmlModelException("Error during XML file creation.", me);
            } catch (Exception e) {
                logger.error("XML file ", name, " cannot be created.");
                throw new XmlModelException("Error during XML file creation.", e);
            }

        }

    }

    private String getPath(XmlDocument document) {
        StringBuilder path = new StringBuilder();
        path.append(super.getRootDir());
        path.append(File.separatorChar);
        path.append(document.getProjectName());
        path.append(File.separatorChar);
        path.append(document.getConfFolder());
        return path.toString();
    }

    private void createFile(String fileName, String path, String content) throws XmlModelException {

        PrintWriter writer;

        File file = new File(path);
        file.mkdirs();
        file = new File(path + fileName);

        boolean exists = file.exists();
        
        try {
            writer = new PrintWriter(file);
        } catch (IOException e) {
            logger.error("XML file ", fileName, " cannot be created.");
            throw new XmlModelException("Error creating XML file '" + fileName + "'.", e);
        }

        writer.print(content);
        writer.flush();
        writer.close();

        if (!exists) {
            logger.info("XML file created: ", fileName);
        } else {
            logger.info("XML file updated: ", fileName);
        }
        super.getFileList().add(file);
    }

}
