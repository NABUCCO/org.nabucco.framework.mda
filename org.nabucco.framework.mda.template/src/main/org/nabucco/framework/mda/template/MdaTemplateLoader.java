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
package org.nabucco.framework.mda.template;

import org.nabucco.framework.mda.model.MdaModelType;
import org.nabucco.framework.mda.model.ModelImplementation;
import org.nabucco.framework.mda.model.ModelLoader;

/**
 * MdaTemplateLoader
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public abstract class MdaTemplateLoader<M extends ModelImplementation> {

    private MdaModelType type;

    /**
     * Creates a new {@link MdaTemplateLoader} instance for the given type.
     * 
     * @param modelType
     *            the model type
     */
    public MdaTemplateLoader(MdaModelType modelType) {
        this.type = modelType;
    }

    /**
     * Loads a template from the template directory.
     * 
     * @param name
     *            name of the template
     * 
     * @return the loaded template
     * 
     * @see ModelLoader
     * @see MdaTemplateConstants
     * 
     * @throws MdaTemplateException
     */
    public abstract MdaTemplate<M> loadTemplate(String name) throws MdaTemplateException;

    /**
     * Getter for the model type.
     * 
     * @return Returns the type.
     */
    public MdaModelType getType() {
        return this.type;
    }

}
