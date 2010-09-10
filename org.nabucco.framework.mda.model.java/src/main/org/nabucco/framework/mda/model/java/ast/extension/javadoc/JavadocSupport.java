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
package org.nabucco.framework.mda.model.java.ast.extension.javadoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;

/**
 * JavadocSupport
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavadocSupport {

    private static final String DOT = ".";

    private static final String QUALIFIER = "the ";

    private static final char[] RETURN = { 'r', 'e', 't', 'u', 'r', 'n' };

    private static final char[] VOID = { 'v', 'o', 'i', 'd' };

    /**
     * Private constructor must not be invoked.
     */
    private JavadocSupport() {
    }

    /**
     * Craetes javadoc method arguments
     * 
     * @param method
     *            the method containing the arguments
     * 
     * @return the list of javadoc parameters
     */
    public static List<JavadocParameter> defaultArgumentsJavadocParameter(
            AbstractMethodDeclaration method) {
        if (method.arguments == null) {
            return null;
        }
        List<JavadocParameter> parameterList = new ArrayList<JavadocParameter>();
        JavadocParameter javadocParam;
        for (int i = method.arguments.length - 1; i >= 0; i--) {
            String param = String.valueOf(method.arguments[i].name)
                    + " the " + method.arguments[i].type + DOT;
            javadocParam = new JavadocParameter("param".toCharArray(), param.toCharArray());
            parameterList.add(javadocParam);
        }
        return parameterList;
    }

    /**
     * Creates the default javadoc return type.
     * 
     * @param method
     *            the method containing the return type
     * 
     * @return the javadoc parameter
     */
    public static JavadocParameter defaultReturnJavadocParameter(AbstractMethodDeclaration method) {
        if (method instanceof MethodDeclaration) {
            MethodDeclaration methodDeclaration = (MethodDeclaration) method;

            if (methodDeclaration.returnType == null) {
                return null;
            }
            if (Arrays.equals(methodDeclaration.returnType.getLastToken(), VOID)) {
                return null;
            }
            String returnValue = QUALIFIER + methodDeclaration.returnType + DOT;
            return new JavadocParameter(RETURN, returnValue.toCharArray());
        }
        return null;
    }

    /**
     * Creates the default exception javadoc parameter.
     * 
     * @param method
     *            the method raising the exception
     * 
     * @return the list javadoc parameters
     */
    public static List<JavadocParameter> defaultExceptionsJavadocParameter(
            AbstractMethodDeclaration method) {
        if (method.thrownExceptions == null) {
            return null;
        }
        List<JavadocParameter> parameterList = new ArrayList<JavadocParameter>();
        JavadocParameter javadocParam;
        for (int i = method.thrownExceptions.length - 1; i >= 0; i--) {
            String exception = String.valueOf(method.thrownExceptions[i]);
            javadocParam = new JavadocParameter("throws".toCharArray(), exception.toCharArray());
            parameterList.add(javadocParam);
        }
        return parameterList;
    }

}
