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

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.nabucco.framework.mda.model.MdaModelType;
import org.nabucco.framework.mda.model.ModelImplementation;
import org.nabucco.framework.mda.model.xml.util.XmlModelToolkit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * XmlModel
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class XmlModel extends ModelImplementation {

    private static final long serialVersionUID = 1L;

    private List<XmlDocument> documentList = new ArrayList<XmlDocument>();

    /**
     * Creates an {@link XmlModel} with an empty document list.
     */
    public XmlModel() {
        super(MdaModelType.XML);
    }

    /**
     * Creates an {@link XmlModel} with one document.
     * 
     * @param document
     *            the XML document
     */
    public XmlModel(XmlDocument document) {
        super(MdaModelType.XML);
        this.documentList.add(document);
    }

    /**
     * Creates an {@link XmlModel} with a document list.
     * 
     * @param documentList
     *            the list of XML documents
     */
    public XmlModel(List<XmlDocument> documentList) {
        super(MdaModelType.XML);
        this.documentList.addAll(documentList);
    }

    /**
     * Getter for the list of XML documents.
     * 
     * @return the XML documents
     */
    public List<XmlDocument> getDocuments() {
        return this.documentList;
    }

    /**
     * Copies an existing XML model.
     * 
     * @return the copied XML model
     * 
     * @throws XmlModelException
     */
    public XmlModel copyModel() throws XmlModelException {
        try {
            List<XmlDocument> clonedDocumentList = new ArrayList<XmlDocument>();

            for (XmlDocument oldDocument : this.documentList) {
                Document clonedDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        .newDocument();

                Element contentClone = XmlModelToolkit.importElement(clonedDoc, oldDocument
                        .getDocument().getDocumentElement(), true);

                clonedDoc.appendChild(contentClone);
                clonedDocumentList.add(new XmlDocument(clonedDoc));
            }
            XmlModel clone = new XmlModel(clonedDocumentList);

            return clone;
        } catch (Exception e) {
            throw new XmlModelException(e);
        }
    }

}
