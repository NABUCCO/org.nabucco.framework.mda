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
package org.nabucco.framework.mda.template.java.extract;

import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * JavaAstStatementExtractor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstStatementExtractor {

    /**
     * Extracts and copies an inner statement out of an outer statement.
     * 
     * @param statement
     *            the {@link Statement}
     * @param scope
     *            the {@link BlockScope}
     * 
     * @return the extracted {@link Statement} copy.
     * 
     * @throws JavaTemplateException
     */
    <T extends Statement> T extractStatement(T statement, BlockScope scope)
            throws JavaTemplateException;

}
