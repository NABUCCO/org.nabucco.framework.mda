/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.mda.model.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.ModelLoader;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * XmlModelLoader
 * 
 * @author Frank Ratschinski, PRODYNA AG
 * @author Nicolas Moser, PRODYNA AG
 */
public class XmlModelLoader extends ModelLoader<XmlModel, InputStream> {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            XmlModelLoader.class);

    @Override
    public XmlModel loadModel(InputStream xmlStream) throws ModelException {

        if (xmlStream == null) {
            throw new ModelException("XML model is not valid [null].");
        }

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlStream);

            return new XmlModel(new XmlDocument(doc));

        } catch (IOException ioe) {
            logger.error(ioe, "Cannot load XML model.");
            throw new XmlModelException("Cannot load XML model", ioe);
        } catch (ParserConfigurationException pce) {
            logger.error(pce, "Cannot parse XML file model.");
            throw new XmlModelException("Cannot parse XML model", pce);
        } catch (SAXException se) {
            logger.error(se, "Cannot parse XML file model.");
            throw new XmlModelException("Cannot parse XML model.", se);
        }
    }

}
