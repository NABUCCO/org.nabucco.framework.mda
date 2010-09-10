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
package org.nabucco.framework.mda.model.file;

import java.io.Serializable;

import org.nabucco.framework.mda.model.ModelException;

/**
 * MdaFile
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface MdaFile extends Serializable {

    /**
     * Getter for the name of the file.
     * 
     * @return the file name
     * 
     * @throws ModelException
     *             if the model is not valid
     */
    public abstract String getFileName() throws ModelException;

}
