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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Clinit;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.JavaAstType;
import org.nabucco.framework.mda.model.java.ast.comparator.AbstractMethodDeclarationComparator;
import org.nabucco.framework.mda.model.java.ast.comparator.FieldDeclarationComparator;
import org.nabucco.framework.mda.model.java.ast.element.method.JavaAstMethodSignature;

/**
 * Encapsulates ECJ TypeDeclaration (java class).
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
class JavaAstTypeImpl implements JavaAstType {

    /**
     * Singleton instance.
     */
    private static JavaAstType instance = new JavaAstTypeImpl();

    /**
     * Private constructor.
     */
    private JavaAstTypeImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstType instance.
     */
    public static JavaAstType getInstance() {
        return instance;
    }

    @Override
    public String getTypeName(TypeDeclaration type) {
        return new String(type.name);
    }

    @Override
    public void setTypeName(TypeDeclaration type, String name) throws JavaModelException {
        // Setting new constructor name.
        for (AbstractMethodDeclaration method : type.methods) {
            if (method.isConstructor()) {
                JavaAstElementFactory.getInstance().getJavaAstMethod().setMethodName(method, name);
            }
        }

        // Set new class name.
        type.name = name.toCharArray();
    }

    @Override
    public List<FieldDeclaration> getFields(TypeDeclaration type) {
        return Arrays.asList(type.fields);
    }

    @Override
    public FieldDeclaration getField(TypeDeclaration type, String fieldName)
            throws JavaModelException {
        for (FieldDeclaration field : type.fields) {
            String traversedfieldName = JavaAstElementFactory.getInstance().getJavaAstField()
                    .getFieldName(field);
            if (traversedfieldName == null) {
                continue;
            }

            if (traversedfieldName.equals(fieldName)) {
                return field;
            }
        }
        throw new JavaModelException("No such field '" + fieldName + "' found");
    }

    @Override
    public void addField(TypeDeclaration type, FieldDeclaration field) throws JavaModelException {
        FieldDeclaration[] newFields = Arrays.copyOf(type.fields, type.fields.length + 1);
        newFields[newFields.length - 1] = field;
        type.fields = newFields;
    }

    @Override
    public void removeField(TypeDeclaration type, FieldDeclaration field) throws JavaModelException {
        List<FieldDeclaration> fieldList = new ArrayList<FieldDeclaration>();
        for (FieldDeclaration typeField : type.fields) {
            if (!typeField.equals(field)) {
                fieldList.add(typeField);
            }
        }
        type.fields = fieldList.toArray(new FieldDeclaration[fieldList.size()]);

    }

    @Override
    public List<AbstractMethodDeclaration> getMethods(TypeDeclaration type)
            throws JavaModelException {
        List<AbstractMethodDeclaration> methodList = new ArrayList<AbstractMethodDeclaration>();

        for (AbstractMethodDeclaration method : type.methods) {
            // No constructors and 'Clint'-methods are delivered.
            if (method.isConstructor() || method.isClinit()) {
                continue;
            }

            methodList.add(method);
        }

        // Unmodifiable list.
        return Collections.unmodifiableList(methodList);
    }

    @Override
    public AbstractMethodDeclaration getMethod(TypeDeclaration type,
            JavaAstMethodSignature methodSignature) throws JavaModelException {
        JavaAstMethodSignature generateMethodSignature = null;
        for (AbstractMethodDeclaration method : getMethods(type)) {
            generateMethodSignature = JavaAstMethodSignature.generateMethodSignature(method);

            if (generateMethodSignature.equals(methodSignature)) {
                return method;
            }
        }
        throw new JavaModelException("No such method '" + methodSignature.toString() + "' found");
    }

    @Override
    public void addMethod(TypeDeclaration type, MethodDeclaration method) throws JavaModelException {
        AbstractMethodDeclaration[] newMethods = Arrays.copyOf(type.methods,
                type.methods.length + 1);
        newMethods[newMethods.length - 1] = method;
        type.methods = newMethods;
    }

    @Override
    public List<ConstructorDeclaration> getConstructors(TypeDeclaration type)
            throws JavaModelException {
        List<ConstructorDeclaration> methodList = new ArrayList<ConstructorDeclaration>(1);

        for (AbstractMethodDeclaration method : type.methods) {
            if (method.isConstructor()) {
                methodList.add((ConstructorDeclaration) method);
            }
        }

        return methodList;
    }

    @Override
    public void removeMethod(TypeDeclaration type, AbstractMethodDeclaration method)
            throws JavaModelException {
        List<AbstractMethodDeclaration> methodList = new ArrayList<AbstractMethodDeclaration>();
        for (AbstractMethodDeclaration typeMethod : type.methods) {
            if (!typeMethod.equals(method)) {
                methodList.add(typeMethod);
            }
        }
        type.methods = methodList.toArray(new AbstractMethodDeclaration[methodList.size()]);
    }

    @Override
    public ConstructorDeclaration getConstructor(TypeDeclaration type,
            JavaAstMethodSignature methodSignature) throws JavaModelException {

        JavaAstMethodSignature constructorSignature;
        for (ConstructorDeclaration constructor : getConstructors(type)) {
            constructorSignature = JavaAstMethodSignature.generateMethodSignature(constructor);

            if (constructorSignature.equals(methodSignature)) {
                return constructor;
            }
        }
        throw new JavaModelException("No such constructor '" + methodSignature + "' found");
    }

    @Override
    public TypeReference getSuperClass(TypeDeclaration type) throws JavaModelException {
        return type.superclass;
    }

    @Override
    public void setSuperClass(TypeDeclaration type, TypeReference superClass)
            throws JavaModelException {
        type.superclass = superClass;
    }

    @Override
    public List<TypeReference> getInterfaces(TypeDeclaration type) throws JavaModelException {
        return Arrays.asList(type.superInterfaces);
    }

    @Override
    public void addInterface(TypeDeclaration type, TypeReference interf) {
        TypeReference[] interfaces;
        if (type.superInterfaces != null) {
            interfaces = Arrays.copyOf(type.superInterfaces, type.superInterfaces.length + 1);
        } else {
            interfaces = new TypeReference[1];
        }
        interfaces[interfaces.length - 1] = interf;
        type.superInterfaces = interfaces;
    }

    @Override
    public void addAnnotation(TypeDeclaration type, Annotation annotation)
            throws JavaModelException {
        Annotation[] annotations = Arrays.copyOf(type.annotations, type.annotations.length + 1);
        annotations[annotations.length - 1] = annotation;
        type.annotations = annotations;
    }

    @Override
    public boolean hasModifier(TypeDeclaration type, int modifier) throws JavaModelException {
        int modifiers = type.modifiers;

        return (modifiers & modifier) > 0;
    }

    @Override
    public void beautify(TypeDeclaration type) throws JavaModelException {
        // Removing unnecessary elements.
        removeUnnecessaryElements(type);

        // Sort elements of type declarations.
        sortElements(type);
    }

    private void removeUnnecessaryElements(TypeDeclaration type) {
        // Methods and constructors.
        if (type.methods != null) {
            List<AbstractMethodDeclaration> methodDeclarationList = new ArrayList<AbstractMethodDeclaration>();
            for (AbstractMethodDeclaration methodDeclaration : type.methods) {
                if (methodDeclaration instanceof Clinit) {
                    continue;
                }

                methodDeclarationList.add(methodDeclaration);
            }
            type.methods = methodDeclarationList
                    .toArray(new AbstractMethodDeclaration[methodDeclarationList.size()]);
        }
    }

    private void sortElements(TypeDeclaration type) {
        // Methods and constructors.
        if (type.methods != null) {
            List<AbstractMethodDeclaration> methodDeclarationList = Arrays.asList(type.methods);
            Collections.sort(methodDeclarationList,
                    AbstractMethodDeclarationComparator.getInstance());

            type.methods = methodDeclarationList
                    .toArray(new AbstractMethodDeclaration[methodDeclarationList.size()]);
        }

        // Fields.
        if (type.fields != null) {
            List<FieldDeclaration> fieldDeclarationList = Arrays.asList(type.fields);
            Collections.sort(fieldDeclarationList, FieldDeclarationComparator.getInstance());

            type.fields = fieldDeclarationList.toArray(new FieldDeclaration[fieldDeclarationList
                    .size()]);
        }
    }

    @Override
    public void addModifier(TypeDeclaration type, int modifierFlag) throws JavaModelException {
        type.modifiers = type.modifiers | modifierFlag;
    }

    @Override
    public void removeModifier(TypeDeclaration type, int modifierFlag) throws JavaModelException {
        type.modifiers &= ~modifierFlag;

    }

    @Override
    public void addTypeParameter(TypeDeclaration type, List<TypeReference> parameters)
            throws JavaModelException {
        type.typeParameters = asTypeParameterArray(parameters);
    }

    public TypeReference getAsParameterized(TypeReference type, List<TypeReference> params) {
        return new ParameterizedSingleTypeReference(type.getLastToken(),
                params.toArray(new TypeReference[0]), 0, 0);
    }

    /**
     * @param parameters
     */
    private TypeParameter[] asTypeParameterArray(List<TypeReference> parameters) {
        TypeParameter[] result = new TypeParameter[parameters.size()];
        for (int i = 0; i < result.length; i++) {
            TypeReference typeReference = parameters.get(i);
            TypeParameter typeParameter = new TypeParameter();
            // behavior resulting behavior of a TypeParameter instance is
            // <TypeParameter.name extends TypeParameter.type>
            // typeParameter.type = typeReference;
            typeParameter.name = typeReference.getLastToken();
            result[i] = typeParameter;
        }
        return result;
    }
}
