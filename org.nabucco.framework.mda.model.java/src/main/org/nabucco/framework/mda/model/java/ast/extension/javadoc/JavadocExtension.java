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

import org.eclipse.jdt.internal.compiler.ast.Javadoc;

/**
 * Extension for java AST class {@link Javadoc}. Allows parsing and printing of javadoc blocks.
 * <p/>
 * The programming structure is oriented towards the original {@link Javadoc} class.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavadocExtension extends Javadoc {

    public char[] token;

    public JavadocParameter[] parameter;

    /**
     * Creates a new {@link Javadoc} instance.
     * 
     * @param sourceStart
     *            source start
     * @param sourceEnd
     *            source end
     */
    public JavadocExtension(int sourceStart, int sourceEnd) {
        super(sourceStart, sourceEnd);
    }

    @Override
    public StringBuffer print(int indent, StringBuffer output) {

        if (isEmpty()) {
            return printSingleLine(indent, output);
        }

        printIndent(indent, output).append("/**\n");

        int i;
        int length;
        if (this.token != null) {
            printIndent(indent + 1, output).append(" * ");
            output.append(token).append('\n').append('*').append('\n');
        }
        if (this.parameter != null) {
            i = 0;
            for (length = this.parameter.length; i < length; ++i) {
                printIndent(indent + 1, output).append(" * @");
                this.parameter[i].print(0, output).append('\n');
            }
        }
        if (this.paramReferences != null) {
            i = 0;
            for (length = this.paramReferences.length; i < length; ++i) {
                printIndent(indent + 1, output).append(" * @param ");
                this.paramReferences[i].print(indent, output).append('\n');
            }
        }
        if (this.paramTypeParameters != null) {
            i = 0;
            for (length = this.paramTypeParameters.length; i < length; ++i) {
                printIndent(indent + 1, output).append(" * @param <");
                this.paramTypeParameters[i].print(indent, output).append(">\n");
            }
        }
        if (this.returnStatement != null) {
            printIndent(indent + 1, output).append(" * @");
            this.returnStatement.print(indent, output).append('\n');
        }
        if (this.exceptionReferences != null) {
            i = 0;
            for (length = this.exceptionReferences.length; i < length; ++i) {
                printIndent(indent + 1, output).append(" * @throws ");
                this.exceptionReferences[i].print(indent, output).append('\n');
            }
        }
        if (this.seeReferences != null) {
            i = 0;
            for (length = this.seeReferences.length; i < length; ++i) {
                printIndent(indent + 1, output).append(" * @see ");
                this.seeReferences[i].print(indent, output).append('\n');
            }
        }
        printIndent(indent, output).append(" */\n");
        return output;
    }

    /**
     * Prints only a single line if no javadoc parameters are defined.
     * 
     * @param indent
     *            the indent
     * @param output
     *            the output string
     * 
     * @return the changed output
     */
    private StringBuffer printSingleLine(int indent, StringBuffer output) {
        printIndent(indent, output).append("/** ");
        if (this.token != null) {
            output.append(this.token);
        }
        output.append(" */").append('\n');
        return output;
    }

    /**
     * Checks whether javadoc has parameters or not.
     * 
     * @return <b>true</> if no parameters are defined, <b>false</b> otherwise
     */
    private boolean isEmpty() {
        if (this.parameter != null && this.parameter.length > 0) {
            return false;
        }
        if (this.paramReferences != null) {
            return false;
        }
        if (this.paramTypeParameters != null) {
            return false;
        }
        if (this.returnStatement != null) {
            return false;
        }
        if (this.exceptionReferences != null) {
            return false;
        }
        if (this.seeReferences != null) {
            return false;
        }
        return true;
    }
}
