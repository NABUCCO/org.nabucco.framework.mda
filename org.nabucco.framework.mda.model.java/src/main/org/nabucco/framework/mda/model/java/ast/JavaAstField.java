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
package org.nabucco.framework.mda.model.java.ast;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.nabucco.framework.mda.model.java.JavaModelException;

/**
 * Encapsulates ECJ FieldDeclaration (java property).
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstField {

    /**
     * Delivers name of property.
     * 
     * @param field
     *            the {@link FieldDeclaration}
     * 
     * @return the field's name
     * 
     * @throws JavaModelException
     */
    String getFieldName(FieldDeclaration field) throws JavaModelException;

    /**
     * Updates name of property.
     * 
     * @param field
     *            the {@link FieldDeclaration} to modify
     * @param name
     *            the name to set
     * 
     * @throws JavaModelException
     */
    void setFieldName(FieldDeclaration field, String name) throws JavaModelException;

    /**
     * Delivers type of property.
     * 
     * @param field
     *            the {@link FieldDeclaration}
     * 
     * @return return the field's type
     * 
     * @throws JavaModelException
     */
    TypeReference getFieldType(FieldDeclaration field) throws JavaModelException;

    /**
     * Updates type of property.
     * 
     * @param field
     *            the {@link FieldDeclaration} to modify
     * @param type
     *            the type to set
     * 
     * @throws JavaModelException
     */
    void setFieldType(FieldDeclaration field, TypeReference type) throws JavaModelException;

    /**
     * Delivers modifier of property.
     * 
     * @param field
     *            the {@link FieldDeclaration}
     * 
     * @return the field's modifier
     * 
     * @throws JavaModelException
     */
    int getModifier(FieldDeclaration field) throws JavaModelException;

    /**
     * Updates modifier of property.
     * 
     * @param field
     *            the {@link FieldDeclaration} to modify
     * @param modifier
     *            the modifier
     * 
     * @throws JavaModelException
     */
    void setModifier(FieldDeclaration field, int modifier) throws JavaModelException;

    /**
     * Adds the given modifier flag to the current modifier.
     * 
     * @param field
     *            the field to modify
     * @param modifierFlag
     *            an accessModifierFlag defined in {@link ClassFileConstants}
     * @throws JavaModelException
     */
    void addModifier(FieldDeclaration field, int modifierFlag) throws JavaModelException;

    /**
     * Removes the given modifier flag to the current modifier.
     * 
     * @param field
     *            the field to modify
     * @param modifierFlag
     *            an accessModifierFlag defined in {@link ClassFileConstants}
     * @throws JavaModelException
     */
    void removeModifier(FieldDeclaration field, int modifierFlag) throws JavaModelException;

    /**
     * Delivers the fields initializer (e.g. = 1L).
     * 
     * @param field
     *            the {@link FieldDeclaration}
     * 
     * @return return the field's type
     * 
     * @throws JavaModelException
     */
    Expression getFieldInitializer(FieldDeclaration field) throws JavaModelException;

    /**
     * Updates the fields initializer (e.g. = 1L).
     * 
     * @param field
     *            the {@link FieldDeclaration} to modify
     * @param expression
     *            the expression to set as initializer
     * 
     * @throws JavaModelException
     */
    void setFieldInitializer(FieldDeclaration field, Expression expression)
            throws JavaModelException;

}