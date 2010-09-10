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

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.JavaAstCommon;

/**
 * Offers common functions for ECJ 'Java-AST' elements.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstCommonImpl implements JavaAstCommon {

    /**
     * Singleton instance.
     */
    private static JavaAstCommonImpl instance = new JavaAstCommonImpl();

    /**
     * Private constructor.
     */
    private JavaAstCommonImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstCommonImpl instance.
     */
    public static JavaAstCommonImpl getInstance() {
        return instance;
    }

    @Override
    public <T extends ASTNode> Appendable getSourceCode(T element) throws JavaModelException {
        StringBuffer source = new StringBuffer();
        element.print(0, source);
        return source;
    }
}
