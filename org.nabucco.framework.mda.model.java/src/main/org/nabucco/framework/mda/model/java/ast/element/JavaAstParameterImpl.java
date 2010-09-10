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
package org.nabucco.framework.mda.model.java.ast.element;

import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.JavaAstParameter;

/**
 * Encapsulates ECJ Argument (java parameter).
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstParameterImpl implements JavaAstParameter {

    /**
     * Singleton instance.
     */
    private static JavaAstParameter instance = new JavaAstParameterImpl();

    /**
     * Private constructor.
     */
    private JavaAstParameterImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstParameter instance.
     */
    public static JavaAstParameter getInstance() {
        return instance;
    }

    @Override
    public String getParameterName(Argument argument) throws JavaModelException {
        return new String(argument.name);
    }

    @Override
    public void setParameterName(Argument argument, String parameterName) throws JavaModelException {
        argument.name = parameterName.toCharArray();
    }
}
