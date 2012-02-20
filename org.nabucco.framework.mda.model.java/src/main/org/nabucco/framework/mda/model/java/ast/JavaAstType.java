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
package org.nabucco.framework.mda.model.java.ast;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.element.method.JavaAstMethodSignature;

/**
 * Encapsulates ECJ TypeDeclaration (java class).
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstType {

    /**
     * Delivers class name.
     * 
     * @param type
     * @return
     * @throws JavaModelException
     */
    String getTypeName(TypeDeclaration type) throws JavaModelException;

    /**
     * Updates class name, including constructors.
     * 
     * @param type
     * @param name
     * @throws JavaModelException
     */
    void setTypeName(TypeDeclaration type, String name) throws JavaModelException;

    /**
     * Delivers all member properties.
     * 
     * @param type
     * @return
     * @throws JavaModelException
     */
    List<FieldDeclaration> getFields(TypeDeclaration type) throws JavaModelException;

    /**
     * Delivers member property for given name.
     * 
     * @param type
     * @param fieldName
     * @return
     * @throws JavaModelException
     */
    FieldDeclaration getField(TypeDeclaration type, String fieldName) throws JavaModelException;

    /**
     * Adds a member property.
     * 
     * @param type
     * @param field
     * @throws JavaModelException
     */
    void addField(TypeDeclaration type, FieldDeclaration field) throws JavaModelException;

    /**
     * Removes a member property.
     * 
     * @param type
     * @param field
     * @throws JavaModelException
     */
    void removeField(TypeDeclaration type, FieldDeclaration field) throws JavaModelException;

    /**
     * Delivers all methods.
     * 
     * @param type
     * @return
     * @throws JavaModelException
     */
    List<AbstractMethodDeclaration> getMethods(TypeDeclaration type) throws JavaModelException;

    /**
     * Delivers method for given method signature.
     * 
     * @param type
     * @param methodSignature
     * @return
     * @throws JavaModelException
     */
    AbstractMethodDeclaration getMethod(TypeDeclaration type, JavaAstMethodSignature methodSignature)
            throws JavaModelException;

    /**
     * Adds a member method.
     * 
     * @param type
     * @param method
     * @throws JavaModelException
     */
    void addMethod(TypeDeclaration type, MethodDeclaration method) throws JavaModelException;

    /**
     * Delivers all constructors.
     * 
     * @param type
     * @return
     * @throws JavaModelException
     */
    List<ConstructorDeclaration> getConstructors(TypeDeclaration type) throws JavaModelException;

    /**
     * Removes a method from a type.
     * 
     * @param type
     * @param method
     * @throws JavaModelException
     */
    void removeMethod(TypeDeclaration type, AbstractMethodDeclaration method)
            throws JavaModelException;

    /**
     * Delivers constructor for given method signature.
     * 
     * @param type
     * @param methodSignature
     * @return
     * @throws JavaModelException
     */
    ConstructorDeclaration getConstructor(TypeDeclaration type,
            JavaAstMethodSignature methodSignature) throws JavaModelException;

    /**
     * Delivers the superclass of a {@link TypeDeclaration}.
     * 
     * @param type
     * @return
     * @throws JavaModelException
     */
    TypeReference getSuperClass(TypeDeclaration type) throws JavaModelException;

    /**
     * Updates the superclass of a {@link TypeDeclaration}.
     * 
     * @param type
     * @param superClass
     * @throws JavaModelException
     */
    void setSuperClass(TypeDeclaration type, TypeReference superClass) throws JavaModelException;

    /**
     * Delivers the interfaces of a {@link TypeDeclaration}.
     * 
     * @param type
     * @return
     * @throws JavaModelException
     */
    List<TypeReference> getInterfaces(TypeDeclaration type) throws JavaModelException;

    /**
     * Adds an interface to the interfaces of a {@link TypeDeclaration}.
     * 
     * @param type
     * @param intf
     * @throws JavaModelException
     */
    void addInterface(TypeDeclaration type, TypeReference intf) throws JavaModelException;

    /**
     * Adds an annotation to the {@link TypeDeclaration}.
     * 
     * @param type
     * @param annotation
     */
    void addAnnotation(TypeDeclaration type, Annotation annotation) throws JavaModelException;

    /**
     * Checks if type has given modifier. Please use constants of class {@link ClassFileConstants}.
     * 
     * @see org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants
     * 
     * @param type
     * @param modifier
     * @return
     * @throws JavaModelException
     */
    boolean hasModifier(TypeDeclaration type, int modifier) throws JavaModelException;

    /**
     * Removing unnecessary elements [e.g. clinit()] and sorting elements.
     * 
     * Sorting order: static final fields static fields static initializer fields constructors
     * public methods private methods
     * 
     * @param unit
     */
    void beautify(TypeDeclaration type) throws JavaModelException;

    /**
     * @param type
     *            the type to modify
     * @param modifierFlag
     *            the flags to add
     * @throws JavaModelException
     */
    void addModifier(TypeDeclaration type, int modifierFlag) throws JavaModelException;

    /**
     * @param type
     *            the type to modify
     * @param modifierFlag
     * @throws JavaModelException
     */
    void removeModifier(TypeDeclaration type, int modifierFlag) throws JavaModelException;

    /**
     * Adds the given types as Parameters to the given type, if possible.
     * 
     * @param type
     *            {@link TypeDeclaration} to be parameterized
     * @param parameters
     *            List of {@link TypeDeclaration} to add as parameters, order is used.
     * @throws JavaModelException
     */
    void addTypeParameter(TypeDeclaration type, List<TypeReference> parameters)
            throws JavaModelException;
}
