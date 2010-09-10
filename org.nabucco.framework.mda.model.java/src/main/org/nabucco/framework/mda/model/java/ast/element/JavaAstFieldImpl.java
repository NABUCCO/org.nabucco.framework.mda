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

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.JavaAstField;

/**
 * Encapsulates ECJ FieldDeclaration (java property).
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
class JavaAstFieldImpl implements JavaAstField {

    /**
     * Singleton instance.
     */
    private static JavaAstField instance = new JavaAstFieldImpl();

    /**
     * Private constructor.
     */
    private JavaAstFieldImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstField instance.
     */
    public static JavaAstField getInstance() {
        return instance;
    }

    @Override
    public String getFieldName(FieldDeclaration field) throws JavaModelException {
        return field.name != null ? new String(field.name) : null;
    }

    @Override
    public void setFieldName(FieldDeclaration field, String name) throws JavaModelException {
        field.name = name.toCharArray();
    }

    @Override
    public TypeReference getFieldType(FieldDeclaration field) throws JavaModelException {
        return field.type;
    }

    @Override
    public void setFieldType(FieldDeclaration field, TypeReference type) throws JavaModelException {
        field.type = type;
    }

    @Override
    public int getModifier(FieldDeclaration node) throws JavaModelException {
        return node.modifiers;
    }

    @Override
    public void setModifier(FieldDeclaration node, int modifier) throws JavaModelException {
        node.modifiers = modifier;
    }

    @Override
    public Expression getFieldInitializer(FieldDeclaration field) throws JavaModelException {
        return field.initialization;
    }

    @Override
    public void setFieldInitializer(FieldDeclaration field, Expression expression)
            throws JavaModelException {
        field.initialization = expression;
    }

    @Override
    public void addModifier(FieldDeclaration field, int modifierFlag) throws JavaModelException {
        field.modifiers = field.modifiers | modifierFlag;
    }

    @Override
    public void removeModifier(FieldDeclaration field, int modifierFlag) throws JavaModelException {
        field.modifiers &= ~modifierFlag;
    }

}
