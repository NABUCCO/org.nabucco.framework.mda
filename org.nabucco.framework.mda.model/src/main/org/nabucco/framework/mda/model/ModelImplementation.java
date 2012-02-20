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

import java.io.Serializable;

/**
 * ModelImplementation
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public abstract class ModelImplementation implements Serializable {

    private static final long serialVersionUID = 1L;

    private MdaModelType type;

    /**
     * Constructor
     * 
     * @param type
     *            the model type
     */
    public ModelImplementation(MdaModelType type) {
        this.type = type;
    }

    /**
     * Getter for the {@link MdaModelType} type.
     * 
     * @return Returns the type.
     */
    public MdaModelType getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ModelImplementation))
            return false;
        ModelImplementation other = (ModelImplementation) obj;
        if (this.type == null) {
            if (other.type != null)
                return false;
        } else if (!this.type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.type);
        return builder.toString();
    }

}
