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
package org.nabucco.framework.mda.template.java;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.nabucco.framework.mda.model.java.JavaCompilationUnit;
import org.nabucco.framework.mda.model.java.JavaModel;
import org.nabucco.framework.mda.template.MdaTemplate;
import org.nabucco.framework.mda.template.MdaTemplateException;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;

/**
 * JavaTemplate
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class JavaTemplate extends MdaTemplate<JavaModel> {

    /**
     * Creates a new {@link JavaTemplate} instance.
     * 
     * @param model
     *            the java model
     */
    public JavaTemplate(JavaModel model) {
        super(model);
    }

    @Override
    public JavaModel extractModel() throws JavaTemplateException {
        CompilationUnitDeclaration unit = JavaAstExtractorFactory.getInstance().getUnitExtractor()
                .extractCompilationUnit(this);

        return new JavaModel(new JavaCompilationUnit(unit));
    }

    @Override
    public JavaTemplate copyTemplate() throws MdaTemplateException {
        return new JavaTemplate(this.extractModel());
    }

    /**
     * Getter for the template compilation unit.
     * 
     * @return the unit
     */
    public JavaCompilationUnit getUnit() {
        JavaModel model = super.getModel();
        if (model == null) {
            throw new IllegalStateException(
                    "Cannot retrieve the template unit. Model is not valid [null].");
        }
        if (model.getUnitList() == null || model.getUnitList().size() != 1) {
            throw new IllegalStateException(
                    "Cannot retrieve the template unit. Unit cannot be determined.");
        }

        return model.getUnitList().get(0);
    }
}
