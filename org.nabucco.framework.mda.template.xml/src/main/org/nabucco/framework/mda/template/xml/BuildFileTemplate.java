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
package org.nabucco.framework.mda.template.xml;

import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.xml.XmlModel;
import org.nabucco.framework.mda.model.xml.util.XmlModelToolkit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * BuildFileTemplate
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
@Deprecated
public class BuildFileTemplate extends XmlTemplate {

    public BuildFileTemplate(XmlModel model) {
        super(model);
    }

    public Element cloneFetchTarget(Document modelDocument) throws ModelException {

        Element fetchTarget = XmlModelToolkit.getElementbyTagNameAndAttribute(getModel()
                .getDocuments().get(0).getDocument().getDocumentElement(), "target", "name",
                "fetch.org.nabucco.framework.mda.jar");

        Element importedFetchTarget = XmlModelToolkit.importElement(modelDocument, fetchTarget,
                true);

        return importedFetchTarget;
    }

}
