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
package org.nabucco.framework.mda.model.java.ast.extension.method;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Javadoc;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.extension.javadoc.JavadocParameter;
import org.nabucco.framework.mda.model.java.ast.extension.javadoc.JavadocSupport;
import org.nabucco.framework.mda.model.java.ast.produce.JavaAstModelProducer;

/**
 * Extension for java AST class {@link ConstructorDeclaration}. Allows printing of annotation in
 * correct order.
 * <p/>
 * The programming structure is oriented towards the original {@link ConstructorDeclaration} class.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ConstructorDeclarationExtension extends ConstructorDeclaration {

    /**
     * Creates a new {@link ConstructorDeclarationExtension} instance.
     * 
     * @param compilationResult
     *            the compilation result (may be null).
     */
    public ConstructorDeclarationExtension(CompilationResult compilationResult) {
        super(compilationResult);
    }

    @Override
    public StringBuffer print(int tab, StringBuffer output) {

        if (this.javadoc != null) {
            this.javadoc.print(tab, output);
        } else {
            this.printDefaultJavadoc(tab, output);
        }
        printIndent(tab, output);
        if (this.annotations != null)
            printAnnotations(this.annotations, output);
        printModifiers(this.modifiers, output);

        TypeParameter[] typeParams = typeParameters();
        if (typeParams != null) {
            output.append('<');
            int max = typeParams.length - 1;
            for (int j = 0; j < max; j++) {
                typeParams[j].print(0, output);
                output.append(", ");//$NON-NLS-1$
            }
            typeParams[max].print(0, output);
            output.append('>');
        }

        printReturnType(0, output).append(this.selector).append('(');
        if (this.arguments != null) {
            for (int i = 0; i < this.arguments.length; i++) {
                if (i > 0)
                    output.append(", "); //$NON-NLS-1$
                this.arguments[i].print(0, output);
            }
        }
        output.append(')');
        if (this.thrownExceptions != null) {
            output.append(" throws "); //$NON-NLS-1$
            for (int i = 0; i < this.thrownExceptions.length; i++) {
                if (i > 0)
                    output.append(", "); //$NON-NLS-1$
                this.thrownExceptions[i].print(0, output);
            }
        }
        printBody(tab + 1, output);
        return output;
    }

    /**
     * Creates a default javadoc for a given method declaration
     * 
     * @param tab
     *            the indent
     * @param output
     *            the output string builder
     * 
     * @throws JavaModelException
     */
    private void printDefaultJavadoc(int tab, StringBuffer output) {

        StringBuilder description = new StringBuilder();
        description.append("Constructs a new ");
        description.append(this.selector);
        description.append(" instance.");

        // creates automatically @param, @return and @throws
        List<JavadocParameter> parameterList = new ArrayList<JavadocParameter>();
        List<JavadocParameter> result = JavadocSupport.defaultArgumentsJavadocParameter(this);
        if (result != null) {
            parameterList.addAll(result);
        }
        JavadocParameter returnValue = JavadocSupport.defaultReturnJavadocParameter(this);
        if (returnValue != null) {
            parameterList.add(returnValue);
        }
        result = JavadocSupport.defaultExceptionsJavadocParameter(this);
        if (result != null) {
            parameterList.addAll(result);
        }

        try {
            Javadoc javadoc = JavaAstModelProducer.getInstance().createJavadoc(
                    description.toString(), parameterList);
            this.javadoc = javadoc;
        } catch (JavaModelException e) {
            return;
        }

        this.javadoc.print(tab, output);
    }

}
