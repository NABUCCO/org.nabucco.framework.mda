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
import org.nabucco.framework.mda.model.java.JavaModelException;

/**
 * Encapsulates ECJ Argument (java parameter).
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstParameter {

    /**
     * Delivers parameter name.
     * 
     * @param argument
     * @return
     * @throws JavaModelException
     */
    String getParameterName(Argument argument) throws JavaModelException;

    /**
     * Updates parameter name.
     * 
     * @param argument
     * @param parameterName
     * @throws JavaModelException
     */
    void setParameterName(Argument argument, String parameterName) throws JavaModelException;
}
