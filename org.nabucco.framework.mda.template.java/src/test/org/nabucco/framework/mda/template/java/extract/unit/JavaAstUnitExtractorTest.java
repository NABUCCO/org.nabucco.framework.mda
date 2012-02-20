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
package org.nabucco.framework.mda.template.java.extract.unit;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.junit.Assert;
import org.junit.Test;
import org.nabucco.framework.mda.model.java.ast.element.JavaAstElementFactory;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.extract.AbstractJavaAstExtractorTest;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;

/**
 * JavaAstUnitExtractorTest
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class JavaAstUnitExtractorTest extends AbstractJavaAstExtractorTest {

    @Test
    public void testUnitExtractionPerTemplate() throws Exception {
        JavaTemplate template = loadJavaTemplateTemplate("src/template/com/prodyna/mda/template/java/samples/CompilationUnitTemplate.java");
        CompilationUnitDeclaration originalUnit = template.getModel().getUnitList().get(0)
                .getUnitDeclaration();

        // Read compilation unit.
        Appendable originalSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(originalUnit);

        // Extract (copy) compilation unit.
        CompilationUnitDeclaration extractedCompilationUnit = JavaAstExtractorFactory.getInstance()
                .getUnitExtractor().extractCompilationUnit(template);
        Assert.assertNotNull(extractedCompilationUnit);

        JavaAstElementFactory.getInstance().getJavaAstUnit().beautify(extractedCompilationUnit);
        Appendable copiedSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(extractedCompilationUnit);

        // Comparing read and copied compilation unit.
        Assert.assertEquals(originalSourceCode.toString(), copiedSourceCode.toString());

        // Toggle it to view original and copied source code.
        // super.printOriginalAndCopiedAstNode(originalSourceCode, copiedSourceCode);
    }
}
