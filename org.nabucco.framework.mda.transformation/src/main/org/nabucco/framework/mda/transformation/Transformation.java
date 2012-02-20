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
package org.nabucco.framework.mda.transformation;

import org.nabucco.framework.mda.model.MdaModel;
import org.nabucco.framework.mda.model.ModelImplementation;

/**
 * Transformation
 * 
 * Interface to define model transformation composites. Each Transformation specifies a particular
 * conversion from one model to another.
 * 
 * @author Frank Ratschinski, PRODYNA AG
 * @author Nicolas Moser, PRODYNA AG
 */
public interface Transformation<S extends ModelImplementation, T extends ModelImplementation, C extends TransformationContext> {

    /**
     * Transforms one model to another.
     * 
     * @param source
     *            the source model
     * @param target
     *            the target model
     * @param context
     *            the transformation context
     * 
     * @throws TransformationException
     *             when the transformation failed
     */
    void transformModel(MdaModel<S> source, MdaModel<T> target, C context)
            throws TransformationException;

}
