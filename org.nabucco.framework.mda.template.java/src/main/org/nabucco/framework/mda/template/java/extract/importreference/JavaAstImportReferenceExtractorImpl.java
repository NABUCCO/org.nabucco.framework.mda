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
package org.nabucco.framework.mda.template.java.extract.importreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.nabucco.framework.mda.model.java.util.AstUtil;
import org.nabucco.framework.mda.template.java.extract.JavaAstImportReferenceExtractor;

/**
 * JavaAstImportReferenceExtractorImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstImportReferenceExtractorImpl implements JavaAstImportReferenceExtractor {

    /**
     * Singleton instance.
     */
    private static JavaAstImportReferenceExtractor instance = new JavaAstImportReferenceExtractorImpl();

    /**
     * Private constructor.
     */
    private JavaAstImportReferenceExtractorImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return a JavaAstImportReferenceExtractor implementation instance.
     */
    public static JavaAstImportReferenceExtractor getInstance() {
        return instance;
    }

    @Override
    public ImportReference extractCurrentPackage(
            CompilationUnitDeclaration compilationUnitDeclaration) {

        ImportReference currentPackage = compilationUnitDeclaration.currentPackage;
        ImportReference currentPackageCopy = copyImportReference(currentPackage);

        return currentPackageCopy;
    }

    @Override
    public List<ImportReference> extractImports(
            CompilationUnitDeclaration compilationUnitDeclaration) {

        if (compilationUnitDeclaration.imports == null) {
            return Collections.<ImportReference> emptyList();
        }

        ImportReference[] imports = compilationUnitDeclaration.imports;
        List<ImportReference> importList = new ArrayList<ImportReference>(imports.length);

        for (ImportReference importReference : imports) {
            importList.add(copyImportReference(importReference));
        }

        return importList;
    }

    private ImportReference copyImportReference(ImportReference importReference) {
        if (importReference == null) {
            return null;
        }

        char[][] tokensCopy = AstUtil.copyTwoDimensionalCharArray(importReference.tokens);

        ImportReference importReferenceCopy = new ImportReference(tokensCopy,
                importReference.sourcePositions.clone(), false, importReference.modifiers);
        importReferenceCopy.bits = importReference.bits;

        return importReferenceCopy;
    }
}
