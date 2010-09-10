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
package org.nabucco.framework.mda.model.java.ast.element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.JavaAstUnit;
import org.nabucco.framework.mda.model.java.ast.produce.JavaAstModelProducer;
import org.nabucco.framework.mda.model.java.util.AstUtil;

/**
 * Encapsulates ECJ CompilationUnitDeclaration (java source file as AST).
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
class JavaAstUnitImpl implements JavaAstUnit {

    /**
     * Singleton instance.
     */
    private static JavaAstUnit instance = new JavaAstUnitImpl();

    /**
     * Private constructor.
     */
    private JavaAstUnitImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstUnit instance.
     */
    public static JavaAstUnit getInstance() {
        return instance;
    }

    @Override
    public List<TypeDeclaration> getAllJavaClasses(CompilationUnitDeclaration unit)
            throws JavaModelException {
        // Unmodifiable list.
        return Arrays.asList(unit.types);
    }

    @Override
    public TypeDeclaration getJavaClass(CompilationUnitDeclaration unit, String className)
            throws JavaModelException {
        for (TypeDeclaration typeDeclaration : unit.types) {
            if (JavaAstElementFactory.getInstance().getJavaAstType().getTypeName(typeDeclaration)
                    .equals(className)) {
                return typeDeclaration;
            }
        }
        throw new JavaModelException("No class found with name '" + className + "'.");
    }

    @Override
    public TypeDeclaration getPublicJavaClass(CompilationUnitDeclaration unit)
            throws JavaModelException {
        for (TypeDeclaration typeDeclaration : unit.types) {
            if (JavaAstElementFactory.getInstance().getJavaAstType()
                    .hasModifier(typeDeclaration, ClassFileConstants.AccPublic)) {
                return typeDeclaration;
            }
        }
        throw new JavaModelException("No public class found.");
    }

    @Override
    public ImportReference getPackage(CompilationUnitDeclaration unit) throws JavaModelException {
        return unit.currentPackage;
    }

    @Override
    public String getPackageAsString(CompilationUnitDeclaration unit) throws JavaModelException {
        if (unit.currentPackage == null) {
            return "";
        }

        StringBuilder pkg = new StringBuilder();
        for (char[] token : unit.currentPackage.tokens) {
            pkg.append(token);
            pkg.append(".");
        }
        return pkg.toString();
    }

    @Override
    public void setPackage(CompilationUnitDeclaration unit, String name) throws JavaModelException {

        if (name == null || name.equals("")) {
            unit.currentPackage = null;
        } else {
            ImportReference currentPkg = JavaAstModelProducer.getInstance().createImportReference(
                    name);
            unit.currentPackage = currentPkg;
        }
    }

    @Override
    public List<ImportReference> getImports(CompilationUnitDeclaration unit)
            throws JavaModelException {
        return Arrays.asList(unit.imports);
    }

    @Override
    public void addImport(CompilationUnitDeclaration unit, ImportReference importReference)
            throws JavaModelException {

        // Do not add already existing imports.
        for (ImportReference existingImport : unit.imports) {
            if (AstUtil.equals(existingImport.tokens, importReference.tokens)) {
                return;
            }
        }

        ImportReference[] imports = Arrays.copyOf(unit.imports, unit.imports.length + 1);
        imports[imports.length - 1] = importReference;
        unit.imports = imports;
    }

    @Override
    public void removeImport(CompilationUnitDeclaration unit, ImportReference importReference)
            throws JavaModelException {
        List<ImportReference> importList = new ArrayList<ImportReference>();
        for (ImportReference importRef : unit.imports) {
            if (!AstUtil.equals(importRef.tokens, importReference.tokens)) {
                importList.add(importRef);
            }
        }
        unit.imports = importList.toArray(new ImportReference[importList.size()]);
    }

    @Override
    public void beautify(CompilationUnitDeclaration unit) throws JavaModelException {
        for (TypeDeclaration typeDeclaration : unit.types) {
            JavaAstElementFactory.getInstance().getJavaAstType().beautify(typeDeclaration);
        }
    }
}
