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
package org.nabucco.framework.mda.model.java.ast.extension.expression;

import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;

/**
 * Extension for java AST class {@link CastExpression}. Allows printing of annotation in correct
 * order.
 * <p/>
 * The programming structure is oriented towards the original {@link CastExpression} class.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class CastExpressionExtension extends CastExpression {

    /**
     * Creates a new {@link CastExpressionExtension} instance.
     * 
     * @param expression
     *            the expression
     * @param type
     *            the type
     */
    public CastExpressionExtension(Expression expression, Expression type) {
        super(expression, type);
    }

    @Override
    public StringBuffer printExpression(int indent, StringBuffer output) {
        output.append("(");
        super.printExpression(indent, output);
        output.append(")");

        return output;
    }

}
