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
package org.nabucco.framework.mda.template.java.accessor;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.element.JavaAstElementFactory;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * JavaTemplateDetector
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class JavaTemplateAccessor {

    private JavaTemplateAccessor() {
    }

    public static CompilationUnitDeclaration detectCompilationUnitDeclaration(JavaTemplate template)
            throws JavaTemplateException {
        validateInputTemplate(template);

        CompilationUnitDeclaration compilationUnitDeclaration = template.getModel().getUnitList()
                .get(0).getUnitDeclaration();

        return compilationUnitDeclaration;
    }

    public static TypeDeclaration detectTypeDeclaration(JavaTemplate template,
            String typeDeclarationName) throws JavaTemplateException {
        validateInputTemplate(template);

        CompilationUnitDeclaration compilationUnitDeclaration = template.getModel().getUnitList()
                .get(0).getUnitDeclaration();

        TypeDeclaration typeDeclaration = null;
        try {
            typeDeclaration = JavaAstElementFactory.getInstance().getJavaAstUnit()
                    .getJavaClass(compilationUnitDeclaration, typeDeclarationName);
        } catch (JavaModelException e) {
            // TODO: Handling.
            throw new JavaTemplateException(e);
        }

        return typeDeclaration;
    }

    private static void validateInputTemplate(JavaTemplate template) throws JavaTemplateException {
        if (template == null) {
            throw new JavaTemplateException("'template' mustn't be null.");
        }
        if (template.getModel() == null) {
            throw new JavaTemplateException("Model of 'template' mustn't be null.");
        }
        if (template.getModel().getUnitList() == null) {
            throw new JavaTemplateException("Unit list of 'template' mustn't be null.");
        }
        if (template.getModel().getUnitList().size() != 1) {
            throw new JavaTemplateException("Size of unit list of 'template' must be 1.");
        }
        CompilationUnitDeclaration compilationUnitDeclaration = template.getModel().getUnitList()
                .get(0).getUnitDeclaration();
        if (compilationUnitDeclaration == null) {
            throw new JavaTemplateException("Compliation unit mustn't be null.");
        }
    }
}
