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

import junit.framework.Assert;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.junit.Test;
import org.nabucco.framework.mda.model.java.ast.element.JavaAstElementFactory;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.extract.AbstractJavaAstExtractorTest;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;

/**
 * JavaAstTypeDeclarationExtractorTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstTypeDeclarationInterfaceExtractorTest extends AbstractJavaAstExtractorTest {

    @Test
    public void testTypeDeclarationExtractionPerTemplate() throws Exception {
        JavaTemplate template = super
                .loadJavaTemplateTemplate("src/template/com/prodyna/mda/template/java/samples/TypeDeclarationInterfaceTemplate.java");

        CompilationUnitDeclaration unit = template.getModel().getUnitList().get(0)
                .getUnitDeclaration();
        TypeDeclaration origianlTypeDeclaration = JavaAstElementFactory.getInstance()
                .getJavaAstUnit().getPublicJavaClass(unit);

        // Read type declaration.
        Appendable originalSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(origianlTypeDeclaration);

        // Extract (copy) type declaration.
        TypeDeclaration extractedTypeDeclaration = JavaAstExtractorFactory.getInstance()
                .getTypeDeclarationExtractor()
                .extractTypeDeclaration(template, "TypeDeclarationInterfaceTemplate");

        Assert.assertNotNull(extractedTypeDeclaration);

        JavaAstElementFactory.getInstance().getJavaAstType().beautify(extractedTypeDeclaration);
        Appendable copiedSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(extractedTypeDeclaration);

        // Comparing read and copied compilation unit.
        Assert.assertEquals(originalSourceCode.toString(), copiedSourceCode.toString());

        // Toggle it to view original and copied source code.
        // super.printOriginalAndCopiedAstNode(originalSourceCode, copiedSourceCode);
    }
}
