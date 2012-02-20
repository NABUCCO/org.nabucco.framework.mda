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
package org.nabucco.framework.mda.model.java.ast;

import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/**
 * JavaAstArgument
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstArgument {

    /**
     * Delivers argument name.
     * 
     * @param argument
     *            the {@link Argument}
     * 
     * @return the argument's name
     */
    String getName(Argument argument);

    /**
     * Updates the arguments name.
     * 
     * @param argument
     *            the {@link Argument}
     * @param name
     *            the name to set
     */
    void setName(Argument argument, String name);

    /**
     * Delivers the argument type as {@link TypeReference}.
     * 
     * @param argument
     *            the {@link Argument}
     * 
     * @return the argument's type
     */
    TypeReference getType(Argument argument);

    /**
     * Updates the argument type.
     * 
     * @param argument
     *            the argument
     * @param type
     *            the {@link TypeReference} to set.
     */
    void setType(Argument argument, TypeReference type);

}
