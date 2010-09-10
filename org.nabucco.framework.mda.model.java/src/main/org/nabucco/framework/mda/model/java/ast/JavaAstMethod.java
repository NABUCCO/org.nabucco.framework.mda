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

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.nabucco.framework.mda.model.java.JavaModelException;

/**
 * Encapsulates ECJ AbstractMethodDeclaration (java method).
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstMethod {

    /**
     * Updates method name.
     * 
     * @param method
     *            the method
     * @param methodName
     *            the name to set
     * 
     * @throws JavaModelException
     */
    void setMethodName(AbstractMethodDeclaration method, String methodName)
            throws JavaModelException;

    /**
     * Delivers the method name.
     * 
     * @param method
     *            the {@link MethodDeclaration}
     * 
     * @return the method's name
     * 
     * @throws JavaModelException
     */
    String getMethodName(AbstractMethodDeclaration method) throws JavaModelException;

    /**
     * Delivers all arguments (in and return) of method.
     * 
     * @param method
     *            the {@link MethodDeclaration}
     * 
     * @return all method arguments
     * 
     * @throws JavaModelException
     */
    List<Argument> getAllArguments(AbstractMethodDeclaration method) throws JavaModelException;

    /**
     * Delivers modifier of method.
     * 
     * @param method
     *            the {@link MethodDeclaration}
     * 
     * @return the method's modifier
     * 
     * @throws JavaModelException
     */
    int getModifier(MethodDeclaration method) throws JavaModelException;

    /**
     * Updates modifier of method.
     * 
     * @param method
     *            the {@link MethodDeclaration} to modify
     * @param modifier
     *            the modifier
     * 
     * @throws JavaModelException
     */
    void setModifier(MethodDeclaration method, int modifier) throws JavaModelException;

    /**
     * Delivers return type of method
     * 
     * @param method
     *            the {@link MethodDeclaration}
     * 
     * @return the method's return type
     */

    /**
     * Adds the given modifier flag to the current modifier.
     * 
     * @param method
     *            the method to modify
     * @param modifierFlag
     *            an accessModifierFlag defined in {@link ClassFileConstants}
     * @throws JavaModelException
     */
    void addModifier(MethodDeclaration method, int modifierFlag) throws JavaModelException;

    /**
     * Removes the given modifier flag to the current modifier.
     * 
     * @param method
     *            the method to modify
     * @param modifierFlag
     *            an accessModifierFlag defined in {@link ClassFileConstants}
     * @throws JavaModelException
     */
    void removeModifier(MethodDeclaration method, int modifierFlag) throws JavaModelException;

    /**
     * Delivers the methods return type.
     * 
     * @param method
     *            the method
     * 
     * @return the methods return type
     * 
     * @throws JavaModelException
     */
    TypeReference getReturnType(MethodDeclaration method) throws JavaModelException;

    /**
     * Updates return type of method.
     * 
     * @param method
     *            the {@link MethodDeclaration} to modify
     * @param type
     *            the {@link TypeReference} to set
     */
    void setReturnType(MethodDeclaration method, TypeReference type);

    /**
     * Adds an argument to the method declaration
     * 
     * @param method
     *            the {@link MethodDeclaration}
     * @param argument
     *            the {@link Argument}
     */
    void addArgument(MethodDeclaration method, Argument argument);

    /**
     * Adds an annotation to the method declaration
     * 
     * @param method
     *            the {@link MethodDeclaration}
     * @param annotation
     *            the {@link Annotation}
     */
    void addAnnotation(MethodDeclaration method, Annotation annotation);

    /**
     * Adds an exception to the method declaration
     * 
     * @param method
     *            the {@link MethodDeclaration}
     * @param exception
     *            the exception {@link TypeReference}
     */
    void addException(MethodDeclaration method, TypeReference exception);

    /**
     * Overrides all existing exceptions with the current one.
     * 
     * @param method
     *            the {@link MethodDeclaration}
     * @param exception
     *            the exception {@link TypeReference}
     */
    void setException(MethodDeclaration method, TypeReference exception);

    /**
     * Adds a statement to the end of the methods statement list.
     * 
     * @param method
     *            the {@link MethodDeclaration}
     * @param astNode
     *            the {@link Statement}
     */
    void addStatement(AbstractMethodDeclaration method, Statement astNode);
}
