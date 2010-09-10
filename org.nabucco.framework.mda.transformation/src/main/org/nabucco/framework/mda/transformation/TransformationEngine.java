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
package org.nabucco.framework.mda.transformation;

import java.util.List;

import org.nabucco.framework.mda.model.MdaModel;
import org.nabucco.framework.mda.model.ModelImplementation;

/**
 * TransformationEngine
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface TransformationEngine<T extends ModelImplementation> {

    /**
     * Processes the transformation of the appropriate source model and its references.
     * 
     * @param sourceModel
     *            the source model
     * 
     * @throws TransformationException
     */
    void process(MdaModel<T> sourceModel) throws TransformationException;

    /**
     * Processes the transformation of the appropriate source models and their references.
     * 
     * @param sourceModels
     *            the root models
     * 
     * @return the generated models
     * 
     * @throws TransformationException
     */
    void process(List<MdaModel<T>> sourceModels) throws TransformationException;
}
