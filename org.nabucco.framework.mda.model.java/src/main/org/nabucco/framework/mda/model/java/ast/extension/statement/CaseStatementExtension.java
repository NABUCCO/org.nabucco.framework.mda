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
package org.nabucco.framework.mda.model.java.ast.extension.statement;

import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.Expression;

/**
 * Extension for java AST class {@link CaseStatement}. Allows printing of annotation in correct
 * order.
 * <p/>
 * The programming structure is oriented towards the original {@link CaseStatement} class.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class CaseStatementExtension extends CaseStatement {

    /**
     * Creates a new {@link CaseStatementExtension} instance.
     * 
     * @param constantExpression
     *            the expression
     * @param sourceEnd
     *            the source end
     * @param sourceStart
     *            the source start
     */
    public CaseStatementExtension(Expression constantExpression, int sourceEnd, int sourceStart) {
        super(constantExpression, sourceEnd, sourceStart);
    }

    @Override
    public StringBuffer printStatement(int tab, StringBuffer output) {
        printIndent(tab, output);
        if (this.constantExpression == null) {
            output.append("default : "); //$NON-NLS-1$
        } else {
            output.append("case "); //$NON-NLS-1$
            this.constantExpression.printExpression(0, output).append(" : "); //$NON-NLS-1$
        }
        return output;
    }

}
