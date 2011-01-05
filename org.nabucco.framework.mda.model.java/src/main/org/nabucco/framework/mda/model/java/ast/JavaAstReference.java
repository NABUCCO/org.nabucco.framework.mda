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
package org.nabucco.framework.mda.model.java.ast;

import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.nabucco.framework.mda.model.java.JavaModelException;

/**
 * JavaAstReference
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstReference {

    /**
     * Checks whether a {@link TypeReference} is a primitive type or not.
     * 
     * @param reference
     *            the {@link TypeReference} to check
     * 
     * @return <b>true</b> if it is a primitive type, <b>false</b> if not.
     */
    Boolean isPrimitive(TypeReference reference) throws JavaModelException;

    /**
     * Returns a new instance of {@link ParameterizedSingleTypeReference} for a given
     * {@link TypeReference} and set of Parameters.
     * 
     * @param reference
     *            initial {@link TypeReference}
     * @param parameters
     *            set of parameters
     * @return new instance of {@link ParameterizedSingleTypeReference} with the given type
     *         parameterized to the given {@link TypeReference}'s
     */
    ParameterizedSingleTypeReference getAsParameterized(TypeReference reference,
            TypeReference[] parameters);

    /**
     * Updates the field reference name.
     * 
     * @param name
     *            name to set
     * @param reference
     *            the reference to update
     * 
     * @throws JavaModelException
     */
    void setName(String name, FieldReference reference) throws JavaModelException;

    /**
     * Delivers the field reference name.
     * 
     * @param reference
     *            the reference to update
     * 
     * @return the field reference name
     * 
     * @throws JavaModelException
     */
    String getName(FieldReference reference) throws JavaModelException;
}
