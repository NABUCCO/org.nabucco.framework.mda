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

import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.JavaAstMethod;

/**
 * Encapsulates ECJ AbstractMethodDeclaration (java method).
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
class JavaAstMethodImpl implements JavaAstMethod {

    /**
     * Singleton instance.
     */
    private static JavaAstMethod instance = new JavaAstMethodImpl();

    /**
     * Private constructor.
     */
    private JavaAstMethodImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstMethod instance.
     */
    public static JavaAstMethod getInstance() {
        return instance;
    }

    @Override
    public void setMethodName(AbstractMethodDeclaration method, String methodName)
            throws JavaModelException {
        method.selector = methodName.toCharArray();
    }

    @Override
    public String getMethodName(AbstractMethodDeclaration method) throws JavaModelException {
        return new String(method.selector);
    }

    @Override
    public List<Argument> getAllArguments(AbstractMethodDeclaration method)
            throws JavaModelException {
        // Unmodifiable list.
        return Arrays.asList(method.arguments);
    }

    @Override
    public void addArgument(MethodDeclaration method, Argument argument) {
        Argument[] newArguments;
        if (method.arguments == null) {
            newArguments = new Argument[] { argument };
        } else {
            newArguments = Arrays.copyOf(method.arguments, method.arguments.length + 1);
            newArguments[newArguments.length - 1] = argument;
        }
        method.arguments = newArguments;
    }

    @Override
    public void addAnnotation(MethodDeclaration method, Annotation annotation) {
        Annotation[] newAnnotations;
        if (method.annotations == null) {
            newAnnotations = new Annotation[] { annotation };
        } else {
            newAnnotations = Arrays.copyOf(method.annotations, method.annotations.length + 1);
            newAnnotations[newAnnotations.length - 1] = annotation;
        }
        method.annotations = newAnnotations;
    }

    @Override
    public int getModifier(MethodDeclaration method) throws JavaModelException {
        return method.modifiers;
    }

    @Override
    public void setModifier(MethodDeclaration method, int modifier) throws JavaModelException {
        method.modifiers = modifier;
    }

    @Override
    public TypeReference getReturnType(MethodDeclaration method) {
        return method.returnType;
    }

    @Override
    public void setReturnType(MethodDeclaration method, TypeReference type) {
        method.returnType = type;
    }

    @Override
    public void addException(MethodDeclaration method, TypeReference exception) {
        TypeReference[] newExceptions;
        if (method.thrownExceptions == null) {
            newExceptions = new TypeReference[] { exception };
        } else {
            newExceptions = Arrays.copyOf(method.thrownExceptions,
                    method.thrownExceptions.length + 1);
            newExceptions[newExceptions.length - 1] = exception;
        }
        method.thrownExceptions = newExceptions;
    }

    @Override
    public void setException(MethodDeclaration method, TypeReference exception) {
        method.thrownExceptions = new TypeReference[] { exception };
    }

    @Override
    public void addStatement(AbstractMethodDeclaration method, Statement statement) {
        Statement[] newStatements;
        if (method.statements == null) {
            newStatements = new Statement[] { statement };
        } else {
            newStatements = Arrays.copyOf(method.statements, method.statements.length + 1);
            newStatements[newStatements.length - 1] = statement;
        }
        method.statements = newStatements;
    }

    @Override
    public void addModifier(MethodDeclaration method, int modifierFlag) throws JavaModelException {
        method.modifiers = method.modifiers | modifierFlag;

    }

    @Override
    public void removeModifier(MethodDeclaration method, int modifierFlag)
            throws JavaModelException {
        method.modifiers &= ~modifierFlag;

    }
}
