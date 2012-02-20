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
package org.nabucco.framework.mda.template.java.extract;

import org.nabucco.framework.mda.template.java.extract.annotation.JavaAstAnnotationExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.field.JavaAstFieldExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.importreference.JavaAstImportReferenceExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.membervaluepair.JavaAstMemberValuePairExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.method.JavaAstMethodExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.statement.JavaAstStatementExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.type.declaration.JavaAstTypeDeclarationExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.type.reference.JavaAstTypeReferenceExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.unit.JavaAstUnitExtractorFactory;

/**
 * Factory for Java AST extraction and clone operations.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstExtractorFactory {

    /**
     * Singleton instance.
     */
    private static JavaAstExtractorFactory instance = new JavaAstExtractorFactory();

    /**
     * Private constructor.
     */
    private JavaAstExtractorFactory() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstExtractorFactory instance.
     */
    public static JavaAstExtractorFactory getInstance() {
        return instance;
    }

    /**
     * Returns a {@link JavaAstImportReferenceExtractor} implementation instance.
     * 
     * @return a {@link JavaAstImportReferenceExtractor} implementation instance.
     */
    public JavaAstImportReferenceExtractor getImportReferenceExtractor() {
        return JavaAstImportReferenceExtractorFactory.getInstance()
                .getJavaAstImportReferenceExtractor();
    }

    /**
     * Returns a {@link JavaAstUnitExtractor} implementation instance.
     * 
     * @return a {@link JavaAstUnitExtractor} implementation instance.
     */
    public JavaAstUnitExtractor getUnitExtractor() {
        return JavaAstUnitExtractorFactory.getInstance().getJavaAstUnitExtractor();
    }

    /**
     * Returns a {@link JavaAstTypeDeclarationExtractor} implementation instance.
     * 
     * @return a {@link JavaAstTypeDeclarationExtractor} implementation instance.
     */
    public JavaAstTypeDeclarationExtractor getTypeDeclarationExtractor() {
        return JavaAstTypeDeclarationExtractorFactory.getInstance()
                .getJavaAstTypeDeclarationExtractor();
    }

    /**
     * Returns a {@link JavaAstFieldExtractor} implementation instance.
     * 
     * @return a {@link JavaAstFieldExtractor} implementation instance.
     */
    public JavaAstFieldExtractor getFieldExtractor() {
        return JavaAstFieldExtractorFactory.getInstance().getJavaAstFieldExtractor();
    }

    /**
     * Returns a {@link JavaAstMethodExtractor} implementation instance.
     * 
     * @return a {@link JavaAstMethodExtractor} implementation instance.
     */
    public JavaAstMethodExtractor getMethodExtractor() {
        return JavaAstMethodExtractorFactory.getInstance().getJavaAstMethodExtractor();
    }

    /**
     * Returns a {@link JavaAstTypeReferenceExtractor} implementation instance.
     * 
     * @return a {@link JavaAstTypeReferenceExtractor} implementation instance.
     */
    public JavaAstTypeReferenceExtractor getTypeReferenceExtractor() {
        return JavaAstTypeReferenceExtractorFactory.getInstance()
                .getJavaAstTypeReferenceExtractor();
    }

    /**
     * Returns a {@link JavaAstStatementExtractor} implementation instance.
     * 
     * @return a {@link JavaAstStatementExtractor} implementation instance.
     */
    public JavaAstStatementExtractor getStatementExtractor() {
        return JavaAstStatementExtractorFactory.getInstance().getJavaAstExpressionExtractor();
    }

    /**
     * Returns a {@link JavaAstAnnotationExtractor} implementation instance.
     * 
     * @return a {@link JavaAstAnnotationExtractor} implementation instance.
     */
    public JavaAstAnnotationExtractor getAnnotationExtractor() {
        return JavaAstAnnotationExtractorFactory.getInstance().getJavaAstAnnotationExtractor();
    }

    /**
     * Returns a {@link JavaAstMemberValuePairExtractor} implementation instance.
     * 
     * @return a {@link JavaAstMemberValuePairExtractor} implementation instance.
     */
    public JavaAstMemberValuePairExtractor getMemberValuePairExtractor() {
        return JavaAstMemberValuePairExtractorFactory.getInstance()
                .getJavaAstMemberValuePairExtractor();
    }
}
