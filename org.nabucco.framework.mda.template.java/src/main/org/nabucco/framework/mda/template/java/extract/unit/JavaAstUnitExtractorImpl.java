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

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.model.java.ast.extension.unit.CompilationUnitExtension;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;
import org.nabucco.framework.mda.template.java.accessor.JavaTemplateAccessor;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.JavaAstUnitExtractor;

/**
 * JavaAstUnitExtractorImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstUnitExtractorImpl implements JavaAstUnitExtractor {

    /**
     * Singleton instance.
     */
    private static JavaAstUnitExtractor instance = new JavaAstUnitExtractorImpl();

    /**
     * Private constructor.
     */
    private JavaAstUnitExtractorImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return a JavaAstUnitExtractor implementation instance.
     */
    public static JavaAstUnitExtractor getInstance() {
        return instance;
    }

    @Override
    public CompilationUnitDeclaration extractCompilationUnit(JavaTemplate template)
            throws JavaTemplateException {
        CompilationUnitDeclaration detectedCompilationUnitDeclaration = JavaTemplateAccessor
                .detectCompilationUnitDeclaration(template);

        return copyCompilationUnitDeclaration(detectedCompilationUnitDeclaration);
    }

    /**
     * Copies a {@link CompilationUnitDeclaration} instance deeply.<br/>
     * <br/>
     * This method is used instead of a visitor, since {@link CompilationUnitDeclaration} is top of
     * the ASTNode tree and no traversing of AST.
     * 
     * @param unit
     *            the compilationUnitDeclaration to copy
     * 
     * @return the copied compilationUnitDeclaration
     * 
     * @throws JavaTemplateException
     */
    private CompilationUnitDeclaration copyCompilationUnitDeclaration(
            CompilationUnitDeclaration unit) throws JavaTemplateException {
        CompilationUnitDeclaration unitClone = new CompilationUnitExtension(unit.problemReporter,
                unit.compilationResult, unit.sourceEnd);

        // Package.
        unitClone.currentPackage = JavaAstExtractorFactory.getInstance()
                .getImportReferenceExtractor().extractCurrentPackage(unit);

        // Import.
        List<ImportReference> extractedImportList = JavaAstExtractorFactory.getInstance()
                .getImportReferenceExtractor().extractImports(unit);
        unitClone.imports = extractedImportList.toArray(new ImportReference[extractedImportList
                .size()]);

        // Type declarations.
        List<TypeDeclaration> extractedTypeDeclarationList = JavaAstExtractorFactory.getInstance()
                .getTypeDeclarationExtractor().extractTypeDeclarations(unit);
        unitClone.types = extractedTypeDeclarationList
                .toArray(new TypeDeclaration[extractedTypeDeclarationList.size()]);

        return unitClone;
    }
}
