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
package org.nabucco.framework.mda.model.xml.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.xml.XmlModelException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * XmlModelToolkit
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public abstract class XmlModelToolkit {

    private static final MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            XmlModelToolkit.class);

    /**
     * Returns the child elements of an root element by ist tag name.
     * 
     * @param element
     *            The root element.
     * @param name
     *            The name of the cild element.
     * @return List of matching elements.
     * 
     * @throws XmlModelException. Thrown
     *             id root element or name is null or empty.
     */
    public static List<Element> getElementsByTagName(Element element, String name)
            throws XmlModelException {

        if (element == null) {
            throw new XmlModelException("Root element is null");
        }
        if (name == null || name.isEmpty()) {
            throw new XmlModelException("Given element name is null or empty");
        }

        NodeList nodeList = element.getElementsByTagName(name);
        List<Element> elementList = new ArrayList<Element>();
        int size = nodeList.getLength();
        for (int i = 0; i < size; i++) {

            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                elementList.add((Element) node);
            }
        }
        return elementList;

    }

    /**
     * Returns the child elements of an root element by ist tag name and attribute name.
     * 
     * @param root
     *            the root element
     * @param name
     *            the element name
     * @param attribute
     *            the attribute name
     * @param attributeValue
     *            the attribute value
     * 
     * @return the found element
     * 
     * @throws XmlModelException
     *             if the element is not found
     */
    public static Element getElementbyTagNameAndAttribute(Element root, String name,
            String attribute, String attributeValue) throws XmlModelException {

        if (root == null) {
            throw new XmlModelException("Root element is null");
        }
        if (name == null || name.isEmpty()) {
            throw new XmlModelException("Given element name is null or empty");
        }
        if (attribute == null || attribute.isEmpty()) {
            throw new XmlModelException("Given attribute name is null or empty");
        }
        if (attributeValue == null) {
            throw new XmlModelException("Given attribute value is null");
        }
        NodeList nodeList = root.getElementsByTagName(name);

        int size = nodeList.getLength();
        for (int i = 0; i < size; i++) {

            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                if (element.hasAttribute(attribute)) {
                    if (element.getAttribute(attribute).equals(attributeValue)) {
                        return element;
                    }
                }
            }
        }

        logger.error("No Element found with name='", name, "' attribute='", attribute, "' value='",
                attributeValue, "'");

        throw new XmlModelException("No Element found with name='"
                + name + "' attribute='" + attribute + "' value='" + attributeValue + "'");
    }

    /**
     * Imports an Element into another Document.
     * 
     * @param targetDocument
     *            The target document.
     * @param sourceElement
     *            The source Element (from a source document).
     * @param deep
     *            if true the complete hierachy is imported.
     * 
     * @return A new element with target Document as owning document
     * 
     * @throws XmlModelException
     *             if sourceElement or targetDocument ist null or the source elements document is
     *             the same as the target document.
     */
    public static Element importElement(Document targetDocument, Element sourceElement, boolean deep)
            throws XmlModelException {

        if (targetDocument == null) {
            throw new XmlModelException("Target document is null");
        }
        if (sourceElement == null) {
            throw new XmlModelException("Source element is null");
        }
        if (targetDocument == sourceElement.getOwnerDocument()) {
            throw new XmlModelException("Cannot import sourceElement into same Document");
        }
        Node importedNode = targetDocument.importNode(sourceElement, deep);
        return (Element) importedNode;

    }

    /**
     * Gets all {@link Element} of an root element by an XPath expression.
     * 
     * @param root
     *            the root element
     * @param xPath
     *            the xpath
     * 
     * @return the list of found elements
     * 
     * @throws XmlModelException
     */
    public static List<Node> getElementsByXPath(Node root, String xPath) throws XmlModelException {

        try {
            XPathExpression expression = XPathFactory.newInstance().newXPath().compile(xPath);
            NodeList nodes = (NodeList) expression.evaluate(root, XPathConstants.NODESET);

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
}
