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
package org.nabucco.framework.mda.model.java.ast.element;

import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.nabucco.framework.mda.model.java.ast.JavaAstArgument;

/**
 * JavaAstArgumentImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstArgumentImpl implements JavaAstArgument {

    /**
     * Singleton instance.
     */
    private static JavaAstArgument instance = new JavaAstArgumentImpl();

    /**
     * Private constructor.
     */
    private JavaAstArgumentImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstArgument instance.
     */
    public static JavaAstArgument getInstance() {
        return instance;
    }

    @Override
    public String getName(Argument argument) {
        return new String(argument.name);
    }

    @Override
    public void setName(Argument argument, String name) {
        argument.name = name.toCharArray();
    }

    @Override
    public TypeReference getType(Argument argument) {
        return argument.type;
    }

    @Override
    public void setType(Argument argument, TypeReference type) {
        argument.type = type;
    }

}
