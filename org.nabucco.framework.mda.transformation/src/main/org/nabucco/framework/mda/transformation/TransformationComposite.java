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

import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.mda.model.MdaModel;
import org.nabucco.framework.mda.model.ModelImplementation;

/**
 * TransformationComposite
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public abstract class TransformationComposite<S extends ModelImplementation, T extends ModelImplementation, C extends TransformationContext>
        implements Transformation<S, T, C> {

    private List<Transformation<S, T, C>> transformationList;

    /**
     * Creates a new {@link TransformationComposite} instance.
     */
    public TransformationComposite() {
        this.transformationList = new ArrayList<Transformation<S, T, C>>();
    }

    /**
     * Getter for the list of transformations.
     * 
     * @return the list of transformations.
     */
    public List<Transformation<S, T, C>> getTransformationList() {
        return this.transformationList;
    }

    @Override
    public void transformModel(MdaModel<S> source, MdaModel<T> target, C context)
            throws TransformationException {

        for (Transformation<S, T, C> t : transformationList) {
            t.transformModel(source, target, context);
        }

    }

}
