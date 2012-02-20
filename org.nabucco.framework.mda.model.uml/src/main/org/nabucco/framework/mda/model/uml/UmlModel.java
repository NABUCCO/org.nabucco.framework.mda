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
package org.nabucco.framework.mda.model.uml;

import org.eclipse.uml2.uml.Model;
import org.nabucco.framework.mda.model.MdaModelType;
import org.nabucco.framework.mda.model.ModelImplementation;

/**
 * 
 * UmlModel
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class UmlModel extends ModelImplementation {

    private static final long serialVersionUID = 1L;

    private Model model;

    public UmlModel(Model model) {
        super(MdaModelType.UML);
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

}
