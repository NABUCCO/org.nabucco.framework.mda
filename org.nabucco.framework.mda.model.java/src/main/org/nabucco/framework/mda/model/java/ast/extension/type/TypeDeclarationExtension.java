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
package org.nabucco.framework.mda.model.java.ast.extension.type;

import java.util.Arrays;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.model.java.ast.comparator.AbstractMethodDeclarationComparator;

/**
 * Extension for java AST class {@link TypeDeclaration}. Allows parsing and printing of comment
 * blocks.
 * <p/>
 * The programming structure is oriented towards the original {@link TypeDeclaration} class.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class TypeDeclarationExtension extends TypeDeclaration {

    private static final String SEMICOLON = ";";

    /**
     * Creates a new {@link TypeDeclarationExtension} instance.
     * 
     * @param compilationResult
     *            the compilation result
     */
    public TypeDeclarationExtension(CompilationResult compilationResult) {
        super(compilationResult);
    }

    public StringBuffer printBody(int indent, StringBuffer output) {
        output.append(" {"); //$NON-NLS-1$

        // Inner classes are not supported

        if (this.memberTypes != null) {

            throw new IllegalArgumentException("Inner classes are not supported! Found in '"
                    + new String(this.name) + ".java'.");

            // for (int i = 0; i < this.memberTypes.length; i++) {
            // if (this.memberTypes[i] != null) {
            // output.append('\n');
            // this.memberTypes[i].print(indent + 1, output);
            // } }
        }

        if (this.fields != null) {
            for (int i = 0; i < this.fields.length; i++) {

                FieldDeclaration field = this.fields[i];

                if (field != null) {
                    output.append('\n');
                    field.print(indent + 1, output);

                    if (field.getKind() == AbstractVariableDeclaration.ENUM_CONSTANT) {

                        if (i == this.fields.length - 1) {
                            output.append(SEMICOLON);
                        } else {

                            FieldDeclaration nextField = fields[i + 1];

                            if (nextField == null
                                    || nextField.getKind() != AbstractVariableDeclaration.ENUM_CONSTANT) {
                                output.append(SEMICOLON);
                            }
                        }
                    }
                }
            }
        }
        if (this.methods != null) {

            Arrays.sort(this.methods, AbstractMethodDeclarationComparator.getInstance());

            for (int i = 0; i < this.methods.length; i++) {
                if (this.methods[i] != null) {
                    output.append('\n');
                    this.methods[i].print(indent + 1, output);
                }
            }
        }
        output.append('\n');
        return printIndent(indent, output).append('}');
    }
}
