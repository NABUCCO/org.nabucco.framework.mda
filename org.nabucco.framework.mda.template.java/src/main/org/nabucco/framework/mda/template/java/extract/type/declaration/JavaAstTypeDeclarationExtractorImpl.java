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
package org.nabucco.framework.mda.template.java.extract.type.declaration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.model.java.ast.extension.type.TypeDeclarationExtension;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;
import org.nabucco.framework.mda.template.java.accessor.JavaTemplateAccessor;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.JavaAstTypeDeclarationExtractor;

/**
 * JavaAstTypeDeclarationExtractorImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstTypeDeclarationExtractorImpl implements JavaAstTypeDeclarationExtractor {

    /**
     * Singleton instance.
     */
    private static JavaAstTypeDeclarationExtractor instance = new JavaAstTypeDeclarationExtractorImpl();

    /**
     * Private constructor.
     */
    private JavaAstTypeDeclarationExtractorImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstTypeDeclarationExtractor instance.
     */
    public static JavaAstTypeDeclarationExtractor getInstance() {
        return instance;
    }

    @Override
    public TypeDeclaration extractTypeDeclaration(JavaTemplate template, String typeDeclarationName)
            throws JavaTemplateException {
        TypeDeclaration typeDeclaration = JavaTemplateAccessor.detectTypeDeclaration(template,
                typeDeclarationName);

        return copyTypeDeclaration(typeDeclaration);
    }

    @Override
    public List<TypeDeclaration> extractTypeDeclarations(CompilationUnitDeclaration unit)
            throws JavaTemplateException {
        List<TypeDeclaration> typeList = new ArrayList<TypeDeclaration>();

        for (TypeDeclaration type : unit.types) {
            TypeDeclaration typeCopy = copyTypeDeclaration(type);

            if (typeCopy != null) {
                typeList.add(typeCopy);
            }
        }

        return typeList;
    }

    private TypeDeclaration copyTypeDeclaration(TypeDeclaration type) throws JavaTemplateException {
        if (type == null) {
            return null;
        }

        String name = new String(type.name);

        TypeDeclaration typeClone = new TypeDeclarationExtension(type.compilationResult);
        typeClone.name = name.toCharArray();

        typeClone.modifiers = type.modifiers;

        // Annotations.
        List<Annotation> extractedAnnotations = JavaAstExtractorFactory.getInstance()
                .getAnnotationExtractor().extractAnnotations(type);
        typeClone.annotations = extractedAnnotations.toArray(new Annotation[extractedAnnotations
                .size()]);

        // Fields.
        List<FieldDeclaration> fieldList = JavaAstExtractorFactory.getInstance()
                .getFieldExtractor().extractFields(type);
        typeClone.fields = fieldList.toArray(new FieldDeclaration[fieldList.size()]);

        // Methods and constructors.
        List<AbstractMethodDeclaration> constructorList = JavaAstExtractorFactory.getInstance()
                .getMethodExtractor().extractConstructors(type);

        List<AbstractMethodDeclaration> methodList = JavaAstExtractorFactory.getInstance()
                .getMethodExtractor().extractMethods(type);
        // Adding constructors.
        methodList.addAll(constructorList);

        typeClone.methods = methodList.toArray(new AbstractMethodDeclaration[methodList.size()]);

        // Super class and super interfaces.
        typeClone.superclass = JavaAstExtractorFactory.getInstance().getTypeReferenceExtractor()
                .extractTypeReference(type.superclass);
        typeClone.superInterfaces = JavaAstExtractorFactory.getInstance()
                .getTypeReferenceExtractor().extractTypeReferences(type.superInterfaces);

        return typeClone;
    }
}
