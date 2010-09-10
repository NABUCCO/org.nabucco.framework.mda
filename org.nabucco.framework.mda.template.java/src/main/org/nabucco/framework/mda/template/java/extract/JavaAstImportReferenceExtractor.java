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
package org.nabucco.framework.mda.template.java.extract;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * Interface for import reference (imports or package definitions) manipulation operations.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstImportReferenceExtractor {

    /**
     * Extracts and copies the current package of a {@link CompilationUnitDeclaration}.
     * 
     * @see ImportReference
     * 
     * @param compilationUnitDeclaration
     *            the compilation unit to extract.
     * 
     * @return the current package
     * 
     * @throws JavaTemplateException
     */
    ImportReference extractCurrentPackage(CompilationUnitDeclaration compilationUnitDeclaration)
            throws JavaTemplateException;

    /**
     * Extracts and copies the import references of a {@link CompilationUnitDeclaration}.
     * 
     * @see ImportReference
     * 
     * @param compilationUnitDeclaration
     *            the compilation unit to extract.
     * 
     * @return a list of {@link ImportReference}
     * 
     * @throws JavaTemplateException
     */
    List<ImportReference> extractImports(CompilationUnitDeclaration compilationUnitDeclaration)
            throws JavaTemplateException;
}