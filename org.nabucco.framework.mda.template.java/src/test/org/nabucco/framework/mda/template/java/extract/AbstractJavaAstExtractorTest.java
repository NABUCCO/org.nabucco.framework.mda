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

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.junit.Assert;
import org.nabucco.framework.mda.model.java.JavaModel;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.JavaModelLoader;
import org.nabucco.framework.mda.model.java.ast.element.JavaAstElementFactory;
import org.nabucco.framework.mda.template.java.JavaTemplate;

/**
 * AbstractJavaAstExtractorTest
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public abstract class AbstractJavaAstExtractorTest {

    protected JavaTemplate loadJavaTemplateTemplate(String templatePath) throws Exception {
        JavaModelLoader loader = new JavaModelLoader();
        FileInputStream inputStream = new FileInputStream(new File(templatePath));
        JavaModel model = loader.loadModel(inputStream);
        Assert.assertEquals(1, model.getUnitList().size());

        // The original compilation unit is beautified.
        this.beautify(model);

        JavaTemplate template = new JavaTemplate(model);
        return template;
    }

    protected void printOriginalAndCopiedAstNode(Appendable original, Appendable copy,
            PrintStream out) {
        out.println("\n");
        out.println("Original ----------------------------------------------------------------------------");
        out.println(original.toString());
        out.println("End - Original ----------------------------------------------------------------------");
        out.println("\n\n");
        out.println("Copy --------------------------------------------------------------------------------");
        out.println(copy.toString());
        out.println("End - Copy --------------------------------------------------------------------------");
    }

    private void beautify(JavaModel model) throws JavaModelException {
        CompilationUnitDeclaration unit = model.getUnitList().get(0).getUnitDeclaration();
        JavaAstElementFactory.getInstance().getJavaAstUnit().beautify(unit);
    }
}
