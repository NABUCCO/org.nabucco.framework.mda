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
package org.nabucco.framework.mda.template.java.extract.method;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.junit.Assert;
import org.junit.Test;
import org.nabucco.framework.mda.model.java.ast.element.JavaAstElementFactory;
import org.nabucco.framework.mda.model.java.ast.element.method.JavaAstMethodSignature;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.extract.AbstractJavaAstExtractorTest;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;

/**
 * JavaAstMethodExtractorTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstAbstractMethodExtractorTest extends AbstractJavaAstExtractorTest {

    @Test
    public void testAbstractMethodDeclarationExtractionPerTemplateMethod() throws Exception {
        JavaTemplate template = super
                .loadJavaTemplateTemplate("src/template/com/prodyna/mda/template/java/samples/AbstractMethodDeclarationTemplate.java");

        CompilationUnitDeclaration unit = template.getModel().getUnitList().get(0)
                .getUnitDeclaration();
        TypeDeclaration originalTypeDeclaration = JavaAstElementFactory.getInstance()
                .getJavaAstUnit().getPublicJavaClass(unit);

        JavaAstMethodSignature methodSignature = new JavaAstMethodSignature("foo");

        // Read method declaration.
        AbstractMethodDeclaration originalMethod = JavaAstElementFactory.getInstance()
                .getJavaAstType().getMethod(originalTypeDeclaration, methodSignature);
        Appendable originalSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(originalMethod);

        // Extract (copy) method declaration.
        AbstractMethodDeclaration extractedMethod = JavaAstExtractorFactory.getInstance()
                .getMethodExtractor()
                .extractMethod(template, "AbstractMethodDeclarationTemplate", methodSignature);

        Assert.assertNotNull(extractedMethod);

        Appendable copiedSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(extractedMethod);

        // Comparing read and copied method declaration.
        Assert.assertEquals(originalSourceCode.toString(), copiedSourceCode.toString());

        // Toggle it to view original and copied source code.
        // super.printOriginalAndCopiedAstNode(originalSourceCode, copiedSourceCode);
    }

    @Test
    public void testAbstractMethodDeclarationExtractionPerTemplateConstructor() throws Exception {
        JavaTemplate template = super
                .loadJavaTemplateTemplate("src/template/com/prodyna/mda/template/java/samples/AbstractMethodDeclarationTemplate.java");

        CompilationUnitDeclaration unit = template.getModel().getUnitList().get(0)
                .getUnitDeclaration();
        TypeDeclaration originalTypeDeclaration = JavaAstElementFactory.getInstance()
                .getJavaAstUnit().getPublicJavaClass(unit);

        JavaAstMethodSignature methodSignature = new JavaAstMethodSignature(
                "AbstractMethodDeclarationTemplate", "float");

        // Read method declaration.
        AbstractMethodDeclaration originalConstructor = JavaAstElementFactory.getInstance()
                .getJavaAstType().getConstructor(originalTypeDeclaration, methodSignature);
        Appendable originalSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(originalConstructor);

        // Extract (copy) method declaration.
        AbstractMethodDeclaration extractedConstructor = JavaAstExtractorFactory.getInstance()
                .getMethodExtractor()
                .extractConstructor(template, "AbstractMethodDeclarationTemplate", methodSignature);

        Assert.assertNotNull(extractedConstructor);

        Appendable copiedSourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(extractedConstructor);

        // Comparing read and copied constructor.
        Assert.assertEquals(originalSourceCode.toString(), copiedSourceCode.toString());

        // Toggle it to view original and copied source code.
        // super.printOriginalAndCopiedAstNode(originalSourceCode, copiedSourceCode);
    }

    @Test
    public void testAbstractMethodDeclarationExtractionPerTypeDeclarationAllMethods()
            throws Exception {
        JavaTemplate template = super
                .loadJavaTemplateTemplate("src/template/com/prodyna/mda/template/java/samples/AbstractMethodDeclarationTemplate.java");

        CompilationUnitDeclaration unit = template.getModel().getUnitList().get(0)
                .getUnitDeclaration();
        TypeDeclaration originalTypeDeclaration = JavaAstElementFactory.getInstance()
                .getJavaAstUnit().getPublicJavaClass(unit);

        // Read method declarations.
        List<AbstractMethodDeclaration> originalMethods = JavaAstElementFactory.getInstance()
                .getJavaAstType().getMethods(originalTypeDeclaration);
        Assert.assertEquals(3, originalMethods.size());

        // Extract (copy) method declaration.
        List<AbstractMethodDeclaration> extractedMethods = JavaAstExtractorFactory.getInstance()
                .getMethodExtractor().extractMethods(originalTypeDeclaration);

        Assert.assertEquals(originalMethods.size(), extractedMethods.size());
    }

    @Test
    public void testAbstractMethodDeclarationExtractionPerTypeDeclarationAllConstructors()
            throws Exception {
        JavaTemplate template = super
                .loadJavaTemplateTemplate("src/template/com/prodyna/mda/template/java/samples/AbstractMethodDeclarationTemplate.java");

        CompilationUnitDeclaration unit = template.getModel().getUnitList().get(0)
                .getUnitDeclaration();
        TypeDeclaration originalTypeDeclaration = JavaAstElementFactory.getInstance()
                .getJavaAstUnit().getPublicJavaClass(unit);

        // Read method declarations.
        List<ConstructorDeclaration> originalConstructors = JavaAstElementFactory.getInstance()
                .getJavaAstType().getConstructors(originalTypeDeclaration);
        Assert.assertEquals(2, originalConstructors.size());

        // Extract (copy) method declaration.
        List<AbstractMethodDeclaration> extractedConstructors = JavaAstExtractorFactory
                .getInstance().getMethodExtractor().extractConstructors(originalTypeDeclaration);

        Assert.assertEquals(originalConstructors.size(), extractedConstructors.size());
    }
}
