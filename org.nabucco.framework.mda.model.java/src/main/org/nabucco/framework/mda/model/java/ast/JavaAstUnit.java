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
package org.nabucco.framework.mda.model.java.ast;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.model.java.JavaModelException;

/**
 * Encapsulates ECJ CompilationUnitDeclaration (java source file as AST).
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstUnit {

    /**
     * Return all java classes of the compilation unit.
     * 
     * @return A list of TypeDeclaration objects.
     * @throws JavaModelException
     */
    List<TypeDeclaration> getAllJavaClasses(CompilationUnitDeclaration unit)
            throws JavaModelException;

    /**
     * Returns a specific java class declaration from the compilation unit.
     * 
     * @param className
     *            The name of the class.
     * @return The TypeDeclaration object.
     * @throws JavaModelException
     *             If no class with given name was found.
     */
    TypeDeclaration getJavaClass(CompilationUnitDeclaration unit, String className)
            throws JavaModelException;

    /**
     * Delivers main (public) class of from the compilation unit.
     * 
     * @param unit
     * @return
     * @throws JavaModelException
     */
    TypeDeclaration getPublicJavaClass(CompilationUnitDeclaration unit) throws JavaModelException;

    /**
     * Delivers the package as {@link ImportReference}.
     * 
     * @param unit
     * @return
     * @throws JavaModelException
     */
    ImportReference getPackage(CompilationUnitDeclaration unit) throws JavaModelException;

    /**
     * Delivers the package name as string.
     * 
     * @param unit
     * @return
     * @throws JavaModelException
     */
    String getPackageAsString(CompilationUnitDeclaration unit) throws JavaModelException;

    /**
     * Updates an import reference of a {@link CompilationUnitDeclaration} to the specified name.
     * 
     * @param unit
     *            the {@link CompilationUnitDeclaration} to modify
     * @param name
     *            the new package declaration, e.g. org.nabucco.framework.mda.mda
     */
    void setPackage(CompilationUnitDeclaration unit, String name) throws JavaModelException;

    /**
     * Delivers the list of imports.
     * 
     * @param unit
     * @return
     * @throws JavaModelException
     */
    List<ImportReference> getImports(CompilationUnitDeclaration unit) throws JavaModelException;

    /**
     * Adds an import to the compilation unit.
     * 
     * @param unit
     * @param importReference
     * @throws JavaModelException
     */
    void addImport(CompilationUnitDeclaration unit, ImportReference importReference)
            throws JavaModelException;

    /**
     * Removes an import from the compilation unit.
     * 
     * @param unit
     * @param importReference
     * @throws JavaModelException
     */
    void removeImport(CompilationUnitDeclaration unit, ImportReference importReference)
            throws JavaModelException;

    /**
     * Removing unnecessary elements and sorting elements.
     * 
     * @param unit
     */
    void beautify(CompilationUnitDeclaration unit) throws JavaModelException;
}