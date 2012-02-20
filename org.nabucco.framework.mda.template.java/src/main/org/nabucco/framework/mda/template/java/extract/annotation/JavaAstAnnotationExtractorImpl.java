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
package org.nabucco.framework.mda.template.java.extract.annotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.nabucco.framework.mda.template.java.JavaTemplateException;
import org.nabucco.framework.mda.template.java.extract.JavaAstAnnotationExtractor;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.JavaAstStatementExtractor;

/**
 * JavaAstAnnotationExtractorImpl
 * 
 * @author Thomas Annen, PRODYNA AG
 */
class JavaAstAnnotationExtractorImpl implements JavaAstAnnotationExtractor {

    /**
     * Singleton instance.
     */
    private static JavaAstAnnotationExtractorImpl instance = new JavaAstAnnotationExtractorImpl();

    /**
     * Private constructor.
     */
    private JavaAstAnnotationExtractorImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstAnnotationExtractorImpl instance.
     */
    public static JavaAstAnnotationExtractorImpl getInstance() {
        return instance;
    }

    @Override
    public List<Annotation> extractAnnotations(TypeDeclaration typeDeclaration)
            throws JavaTemplateException {
        return this.extractAnnotations(typeDeclaration.annotations,
                typeDeclaration.staticInitializerScope);
    }

    @Override
    public List<Annotation> extractAnnotations(AbstractMethodDeclaration abstractMethodDeclaration)
            throws JavaTemplateException {
        return this.extractAnnotations(abstractMethodDeclaration.annotations,
                abstractMethodDeclaration.scope);
    }

    @Override
    public List<Annotation> extractAnnotations(
            AbstractVariableDeclaration abstractVariableDeclaration, BlockScope scope)
            throws JavaTemplateException {
        return this.extractAnnotations(abstractVariableDeclaration.annotations, scope);
    }

    private List<Annotation> extractAnnotations(Annotation[] annotations, BlockScope blockScope)
            throws JavaTemplateException {
        if (annotations == null) {
            return Collections.<Annotation> emptyList();
        }
        List<Annotation> annotationList = new ArrayList<Annotation>(annotations.length);

        // Because an 'Annotation' is a 'Statement' the 'JavaAstStatementExtractor' can be applied.
        JavaAstStatementExtractor statementExtractor = JavaAstExtractorFactory.getInstance()
                .getStatementExtractor();
        for (Annotation annotation : annotations) {
            Annotation annotationCopy = statementExtractor.extractStatement(annotation, blockScope);
            annotationList.add(annotationCopy);
        }

        return annotationList;
    }
}
