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
package org.nabucco.framework.mda.model.java.ast.extension.javadoc;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Javadoc;

/**
 * Allows parsing and printing of javadoc parameters.
 * <p/>
 * The programming structure is oriented towards the original {@link Javadoc} class.
 * 
 * @see JavadocExtension
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavadocParameter extends ASTNode {

    public char[] name;

    public char[] token;

    public JavadocParameter(char[] name, char[] token) {
        this.name = name;
        this.token = token;
    }

    @Override
    public StringBuffer print(int indent, StringBuffer output) {
        printIndent(indent, output);
        return output.append(name).append(' ').append(token);
    }

}
