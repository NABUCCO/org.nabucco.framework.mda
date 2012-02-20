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
package org.nabucco.framework.mda.template.uml;

import org.nabucco.framework.mda.model.uml.UmlModel;
import org.nabucco.framework.mda.template.MdaTemplate;
import org.nabucco.framework.mda.template.MdaTemplateException;

/**
 * 
 * UmlTemplate
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class UmlTemplate extends MdaTemplate<UmlModel> {

    /**
     * Creates a new {@link UmlTemplate} instance.
     * 
     * @param model
     *            the UML model
     */
    public UmlTemplate(UmlModel model) {
        super(model);
    }

    @Override
    public UmlModel extractModel() throws MdaTemplateException {
        // TODO Not yet implemented
        throw new UnsupportedOperationException(
                "cloneModel() is not yet implemented for UmlTemplate.");
    }

    @Override
    public UmlTemplate copyTemplate() throws MdaTemplateException {
        return new UmlTemplate(this.extractModel());
    }
}
