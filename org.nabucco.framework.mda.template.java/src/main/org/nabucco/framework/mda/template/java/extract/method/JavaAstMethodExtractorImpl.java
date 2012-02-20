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
package org.nabucco.framework.mda.template.java.extract.method;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.model.java.ast.element.method.JavaAstMethodSignature;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;
import org.nabucco.framework.mda.template.java.accessor.JavaTemplateAccessor;
import org.nabucco.framework.mda.template.java.extract.JavaAstMethodExtractor;

/**
 * JavaAstMethodExtractorImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstMethodExtractorImpl implements JavaAstMethodExtractor {

    /**
     * Singleton instance.
     */
    private static JavaAstMethodExtractor instance = new JavaAstMethodExtractorImpl();

    /**
     * Private constructor.
     */
    private JavaAstMethodExtractorImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstMethodExtractor instance.
     */
    public static JavaAstMethodExtractor getInstance() {
        return instance;
    }

    @Override
    public AbstractMethodDeclaration extractMethod(JavaTemplate template,
            String typeDeclarationName, JavaAstMethodSignature methodSignature)
            throws JavaTemplateException {
        TypeDeclaration typeDeclaration = JavaTemplateAccessor.detectTypeDeclaration(template,
                typeDeclarationName);

        JavaAstMethodExtractorVisitor visitor = new JavaAstMethodExtractorVisitor();
        typeDeclaration.traverse(visitor, typeDeclaration.scope);

        if (visitor.getVisitorContext().containsException()) {
            throw new JavaTemplateException(visitor.getVisitorContext().getExceptionList().get(0));
        }
        return visitor.getMethodCopy(methodSignature);
    }

    @Override
    public List<AbstractMethodDeclaration> extractMethods(TypeDeclaration type)
            throws JavaTemplateException {

        JavaAstMethodExtractorVisitor visitor = new JavaAstMethodExtractorVisitor();
        type.traverse(visitor, type.scope);

        if (visitor.getVisitorContext().containsException()) {
            throw new JavaTemplateException(visitor.getVisitorContext().getExceptionList().get(0));
        }

        return visitor.getAllMethodCopies();
    }

    @Override
    public AbstractMethodDeclaration extractConstructor(JavaTemplate template,
            String typeDeclarationName, JavaAstMethodSignature methodSignature)
            throws JavaTemplateException {
        TypeDeclaration typeDeclaration = JavaTemplateAccessor.detectTypeDeclaration(template,
                typeDeclarationName);

        JavaAstMethodExtractorVisitor visitor = new JavaAstMethodExtractorVisitor();
        typeDeclaration.traverse(visitor, typeDeclaration.scope);

        if (visitor.getVisitorContext().containsException()) {
            throw new JavaTemplateException(visitor.getVisitorContext().getExceptionList().get(0));
        }
        return visitor.getConstructorCopy(methodSignature);
    }

    @Override
    public List<AbstractMethodDeclaration> extractConstructors(TypeDeclaration type)
            throws JavaTemplateException {

        JavaAstMethodExtractorVisitor visitor = new JavaAstMethodExtractorVisitor();
        type.traverse(visitor, type.scope);

        if (visitor.getVisitorContext().containsException()) {
            throw new JavaTemplateException(visitor.getVisitorContext().getExceptionList().get(0));
        }

        return visitor.getAllConstructorCopies();
    }
}
