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
package org.nabucco.framework.mda.model;

/**
 * MdaModel
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class MdaModel<M extends ModelImplementation> {

    private M model;

    /**
     * Creates a new {@link MdaModel} instance.
     * 
     * @param model
     *            the contained model implementation
     */
    public MdaModel(M model) throws ModelException {
        if (model == null) {
            throw new ModelException("Model implementation must be defined.");
        }

        this.model = model;
    }

    public M getModel() {
        return model;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.model == null) ? 0 : this.model.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MdaModel)) {
            return false;
        }
        @SuppressWarnings("unchecked")
        MdaModel<M> other = (MdaModel<M>) obj;
        if (this.model == null) {
            if (other.model != null) {
                return false;
            }
        } else if (!this.model.equals(other.model)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MdaModel [model=");
        builder.append(this.model);
        builder.append("]");
        return builder.toString();
    }

}
