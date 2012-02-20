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
package org.nabucco.framework.mda.template.java.extract.field;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.junit.Assert;
import org.junit.Test;
import org.nabucco.framework.mda.model.java.ast.element.JavaAstElementFactory;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.extract.AbstractJavaAstExtractorTest;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;

/**
 * JavaAstFieldExtractorTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstFieldExtractorTest extends AbstractJavaAstExtractorTest {

    @Test
    public void testVariableDeclarationExtractionPerTemplateMethod() throws Exception {
        JavaTemplate template = super
                .loadJavaTemplateTemplate("src/template/com/prodyna/mda/template/java/samples/FieldDeclarationTemplate.java");

        CompilationUnitDeclaration unit = template.getModel().getUnitList().get(0)
                .getUnitDeclaration();
        TypeDeclaration originalTypeDeclaration = JavaAstElementFactory.getInstance()
                .getJavaAstUnit().getPublicJavaClass(unit);

        // Read variable declaration.
        FieldDeclaration originalField = JavaAstElementFactory.getInstance().getJavaAstType()
                .getField(originalTypeDeclaration, "serialVersionUID");
        Appendable originalSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(originalField);

        // Extract (copy) variable declaration.
        FieldDeclaration extractedField = JavaAstExtractorFactory.getInstance().getFieldExtractor()
                .extractField(template, "FieldDeclarationTemplate", "serialVersionUID");

        Assert.assertNotNull(extractedField);

        Appendable copiedSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(extractedField);

        // Comparing read and copied variable declaration.
        Assert.assertEquals(originalSourceCode.toString(), copiedSourceCode.toString());

        // Toggle it to view original and copied source code.
        // super.printOriginalAndCopiedAstNode(originalSourceCode, copiedSourceCode);
    }

    @Test
    public void testVariableDeclarationExtractionPerTypeDeclaration() throws Exception {
        JavaTemplate template = super
                .loadJavaTemplateTemplate("src/template/com/prodyna/mda/template/java/samples/FieldDeclarationTemplate.java");

        CompilationUnitDeclaration unit = template.getModel().getUnitList().get(0)
                .getUnitDeclaration();
        TypeDeclaration originalTypeDeclaration = JavaAstElementFactory.getInstance()
                .getJavaAstUnit().getPublicJavaClass(unit);

        // Read field declarations.
        List<FieldDeclaration> originalFields = JavaAstElementFactory.getInstance()
                .getJavaAstType().getFields(originalTypeDeclaration);
        Assert.assertEquals(3, originalFields.size());

        // Extract (copy) field declarations.
        List<FieldDeclaration> extractedFields = JavaAstExtractorFactory.getInstance()
                .getFieldExtractor().extractFields(originalTypeDeclaration);

        Assert.assertEquals(originalFields.size(), extractedFields.size());
    }
}
