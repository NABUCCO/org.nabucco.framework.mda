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
package org.nabucco.framework.mda.model.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.nabucco.framework.mda.model.file.MdaFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * XmlDocument
 * <p/>
 * Wrapper for one XML DOM {@link Document}. Holds extra information like project, folder, name,
 * etc.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class XmlDocument implements MdaFile {

    private static final long serialVersionUID = 1L;

    private static final String XML_SUFFIX = ".xml";

    private Document document;

    private String projectName;

    private String folder;

    private String version;

    /**
     * Creates a new {@link XmlDocument} instance.
     * 
     * @param document
     *            the xml document
     */
    public XmlDocument(Document document) {
        if (document == null) {
            throw new IllegalArgumentException("XML document must be defined.");
        }
        this.document = document;
    }

    /**
     * Getter for the XML {@link Document} instance.
     * 
     * @return Returns the document.
     */
    public Document getDocument() {
        return this.document;
    }

    /**
     * Getter for the project name.
     * 
     * @return the project name
     */
    public String getProjectName() {
        if (this.projectName == null) {
            return "undefined";
        }
        return this.projectName;
    }

    /**
     * Setter for the project name.
     * 
     * @param projectName
     *            the name to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Getter for the source folder (src/main/gen, src/test/gen, etc.).
     * 
     * @return the source folder.
     */
    public String getConfFolder() {
        return this.folder;
    }

    /**
     * Setter for the source folder conf/ejb.
     * 
     * @param folder
     *            the source folder to set
     */
    public void setConfFolder(String folder) {
        this.folder = folder;
    }

    /**
     * Getter for the simple name of the compilation units' file (*.java).
     * 
     * @return the simple java file name
     */
    @Override
    public String getFileName() throws XmlModelException {

        StringBuilder fileName = new StringBuilder();

        Element element = document.getDocumentElement();

        // TODO: Externalize!

        if (element != null) {
            String tagName = element.getTagName();
            if (tagName.equals("project")) {
                fileName.append("build");
            } else if (tagName.equals("entity-mappings")) {
                fileName.append(this.getProjectName().toLowerCase() + "_orm");
            } else if (tagName.equals("fragment")) {
                fileName.append(element.getAttribute("type"));
                fileName.append("_");
                fileName.append("fragment");
                fileName.append("_");
                fileName.append(element.getAttribute("name"));
            } else {
                fileName.append(tagName);
            }
        } else {
            fileName.append("undefined");
        }

        fileName.append(XML_SUFFIX);

        return fileName.toString();
    }

    /**
     * Gets all {@link Element} of this XML document by an XPath.
     * 
     * @param xPath
     *            the xpath
     * 
     * @return the list of found elements
     * 
     * @throws XmlModelException
     */
    public List<Node> getElementsByXPath(String xPath) throws XmlModelException {

        try {
            XPathExpression expression = XPathFactory.newInstance().newXPath().compile(xPath);
            NodeList nodes = (NodeList) expression.evaluate(this.document, XPathConstants.NODESET);

            List<Node> nodeList = new ArrayList<Node>();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                nodeList.add(node);
            }

            return nodeList;

        } catch (XPathExpressionException e) {
            throw new XmlModelException("Error evaluating XPath.", e);
        }
    }

    /**
     * Converts an {@link XmlDocument} to an XML string.
     * 
     * @return the XML document as string
     * 
     * @throws XmlModelException
     */
    public String toXml() throws XmlModelException {
        try {

            StringWriter stringWriter = new StringWriter();

            OutputFormat xmlFormat = new OutputFormat();
            xmlFormat.setEncoding("ISO-8859-1");
            xmlFormat.setLineSeparator("\n");
            xmlFormat.setIndent(2);
            xmlFormat.setIndenting(true);

            XMLSerializer xmlSerializer = new XMLSerializer(stringWriter, xmlFormat);

            xmlSerializer.serialize(document);

            return stringWriter.toString();

        } catch (IOException e) {

            throw new XmlModelException(e);
        }
    }

    /**
     * Creates an empty {@link XmlDocument} instance.
     * 
     * @return the empty XML document
     * 
     * @throws XmlModelException
     */
    public static XmlDocument createEmptyXmlDocument() throws XmlModelException {
        try {
            return new XmlDocument(DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .newDocument());
        } catch (ParserConfigurationException e) {
            throw new XmlModelException("Error creating empty XML document.", e);
        }
    }

    @Override
    public String getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

}
