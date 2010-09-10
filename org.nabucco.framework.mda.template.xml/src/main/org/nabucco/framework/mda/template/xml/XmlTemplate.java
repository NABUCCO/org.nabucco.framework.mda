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
package org.nabucco.framework.mda.template.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.nabucco.framework.mda.model.xml.XmlModel;
import org.nabucco.framework.mda.model.xml.XmlModelException;
import org.nabucco.framework.mda.template.MdaTemplate;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * XmlTemplate
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class XmlTemplate extends MdaTemplate<XmlModel> {

    public XmlTemplate(XmlModel model) {
        this.model = model;
    }

    public XmlModel getModel() {
        return model;
    }

    /**
     * Copies an element by an XPath expression.
     * 
     * @param xPath
     *            the XPath expression
     * 
     * @return the copied node list
     * 
     * @throws XmlTemplateException
     */
    public List<Node> copyNodesByXPath(String xPath) throws XmlTemplateException {

        try {
            XPathExpression expression = XPathFactory.newInstance().newXPath().compile(xPath);

            NodeList nodes = (NodeList) expression.evaluate(this.model.getDocuments().get(0)
                    .getDocument(), XPathConstants.NODESET);

            List<Node> nodeList = new ArrayList<Node>();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i).cloneNode(true);
                nodeList.add(node);
            }

            return nodeList;

        } catch (XPathExpressionException e) {
            throw new XmlTemplateException("Error evaluating XPath.", e);
        }
    }

    @Override
    public XmlModel extractModel() throws XmlTemplateException {
        try {
            return this.model.copyModel();
        } catch (XmlModelException e) {
            throw new XmlTemplateException("Error copying xml model.", e);
        }
    }

    @Override
    public XmlTemplate copyTemplate() throws XmlTemplateException {
        return new XmlTemplate(this.extractModel());
    }

}
