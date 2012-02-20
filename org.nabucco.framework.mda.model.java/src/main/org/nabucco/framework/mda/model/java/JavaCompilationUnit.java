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
package org.nabucco.framework.mda.model.java;

import java.io.File;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.model.file.MdaFile;
import org.nabucco.framework.mda.model.java.ast.element.JavaAstElementFactory;
import org.nabucco.framework.mda.model.java.ast.extension.unit.CompilationUnitExtension;

/**
 * JavaCompilationUnit
 * <p/>
 * Wrapper for one Java AST {@link CompilationUnitDeclaration}. Holds extra information like
 * project, package, name, etc.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaCompilationUnit implements MdaFile {

    private static final long serialVersionUID = 1L;

    private static final String JAVA_SUFFIX = ".java";

    private CompilationUnitDeclaration unit;

    private String projectName;

    private String folder;

    private String version;

    /**
     * Creates a new {@link JavaCompilationUnit} instance.
     * 
     * @param unit
     *            the compilation unit declaration
     */
    public JavaCompilationUnit(CompilationUnitDeclaration unit) {
        if (unit == null) {
            throw new IllegalArgumentException("CompilationUnitDeclaration must be defined.");
        }

        this.unit = unit;
    }

    /**
     * Getter for the {@link CompilationUnitDeclaration} instance.
     * 
     * @return
     */
    public CompilationUnitDeclaration getUnitDeclaration() {
        return this.unit;
    }

    /**
     * Getter for the project name.
     * 
     * @return the project name
     */
    public String getProjectName() {
        return this.projectName;
    }

    /**
     * Setter for the project name.
     * 
     * @param projectName
     *            the name to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Getter for the source folder (src/main/gen, src/test/gen, etc.).
     * 
     * @return the source folder.
     */
    public String getSourceFolder() {
        return this.folder;
    }

    /**
     * Setter for the source folder (src/main/gen, src/test/gen, etc.).
     * 
     * @param folder
     *            the source folder to set
     */
    public void setSourceFolder(String folder) {
        this.folder = folder;
    }

    /**
     * Getter for the simple name of the compilation units' file (*.java).
     * 
     * @return the simple java file name
     * 
     * @throws JavaModelException
     */
    @Override
    public String getFileName() throws JavaModelException {

        StringBuilder fileName = new StringBuilder();

        TypeDeclaration mainType = JavaAstElementFactory.getInstance().getJavaAstUnit()
                .getPublicJavaClass(this.unit);

        fileName.append(mainType.name);
        fileName.append(JAVA_SUFFIX);

        return fileName.toString();
    }

    /**
     * Getter for the compilation units' package
     * 
     * @return
     * @throws JavaModelException
     */
    public String getPackage() throws JavaModelException {

        String pkg = JavaAstElementFactory.getInstance().getJavaAstUnit()
                .getPackageAsString(this.unit);

        return pkg.replace(".", File.separator);
    }

    /**
     * Getter for the file header.
     * 
     * @return the file header
     */
    public String getFileHeader() {
        if (!(this.unit instanceof CompilationUnitExtension)) {
            return "";
        }

        return ((CompilationUnitExtension) this.unit).getHeader(0);
    }

    /**
     * Getter for the public type declaration contained by the {@link CompilationUnitDeclaration}.
     * 
     * @return the class as {@link TypeDeclaration}
     * 
     * @throws JavaModelException
     */
    public TypeDeclaration getType() throws JavaModelException {
        return JavaAstElementFactory.getInstance().getJavaAstUnit().getPublicJavaClass(this.unit);
    }

    /**
     * Getter for the type declaration with the given name contained by the
     * {@link CompilationUnitDeclaration}.
     * 
     * @param name
     *            name of the class.
     * 
     * @return the class as {@link TypeDeclaration}
     * 
     * @throws JavaModelException
     */
    public TypeDeclaration getType(String name) throws JavaModelException {
        return JavaAstElementFactory.getInstance().getJavaAstUnit().getJavaClass(unit, name);
    }

    @Override
    public String getVersion() {
        return this.version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }
}
