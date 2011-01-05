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
package org.nabucco.framework.mda.model.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.ModelLoader;

/**
 * 
 * Parses a Java source file to load the appropriate JavaModel.<br/>
 * <br/>
 * It is important to notice that the parser is not a compiler. It will flag errors only if there is
 * something in the source file that will affect the AST Tree integrity. <br/>
 * <br/>
 * For instance, if you type <code>classs</code> instead of <code>class</code>, it will affect the
 * creation of a TypeDeclaration node, and it will be an error. On the other hand, if you type
 * <code>private Stringgg str;</code>, it will be valid because a class called <code>Stringgg</code>
 * may exist somewhere. Only the compiler would be able to flag this as an error. Just be aware that
 * a valid tree does not mean a valid compilation.
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class JavaModelLoader extends ModelLoader<JavaModel, InputStream> {

    private static final String FILE_NAME = "Template.java";

    private CompilerOptions compilerOptions;

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            JavaModelLoader.class);

    public JavaModelLoader() {
        compilerOptions = JavaModelSupport.createCompilerOptions();
    }

    @Override
    public JavaModel loadModel(InputStream inputStream) throws ModelException {

        if (inputStream == null) {
            return new JavaModel();
        }

        try {
            String sourceCode = super.loadStream(inputStream);

            ProblemReporter problemReporter = JavaModelSupport
                    .createDefaultProblemReporter(compilerOptions);

            CompilationUnit compilationUnit = new CompilationUnit(sourceCode.toCharArray(),
                    FILE_NAME, ENCODING);

            CompilationResult result = JavaModelSupport.createCompilationResult(compilationUnit);

            // Parser
            Parser parser = new Parser(problemReporter, true);
            CompilationUnitDeclaration unit = parser.parse(compilationUnit, result);

            this.compile(result, parser, unit);

            List<JavaCompilationUnit> unitList = new ArrayList<JavaCompilationUnit>();
            unitList.add(new JavaCompilationUnit(unit));

            return new JavaModel(unitList);

        } catch (IOException e) {
            logger.error(e, "Cannot load Java file.");
            throw new JavaModelException("Cannot load Java file.", e);
        }
    }

    /**
     * Starts the basic compilation process. Fills the scopes of the java AST nodes.
     * 
     * @param result
     *            the compilation result for compilation errors
     * @param parser
     *            the parser
     * @param unit
     *            the compilation unit to compile
     */
    private void compile(CompilationResult result, Parser parser, CompilationUnitDeclaration unit) {
        try {

            LookupEnvironment environment = JavaModelSupport.createLookupEnvironment(unit,
                    this.compilerOptions);

            this.beginCompile(environment, result, unit);
            this.process(environment, parser, unit);

        } catch (AbortCompilation e) {
            StringBuilder msg = new StringBuilder();
            msg.append("Skip compilation for ");
            msg.append(unit.getMainTypeName());
            msg.append(". ");
            msg.append(e.problem);
            logger.debug(msg.toString());
        }
    }

    /**
     * Begins the compilation process
     * 
     * @param lookupEnvironment
     *            the lookup environment
     * @param result
     *            the compilation result
     * @param unit
     *            the compilation unit
     */
    private void beginCompile(LookupEnvironment lookupEnvironment, CompilationResult result,
            CompilationUnitDeclaration unit) {

        lookupEnvironment.buildTypeBindings(unit, null);

        ImportReference currentPackage = unit.currentPackage;
        if (currentPackage != null) {
            result.recordPackageName(currentPackage.tokens);
        }

        lookupEnvironment.completeTypeBindings();
    }

    /**
     * Process a compilation unit already parsed and build.
     * 
     * @param environment
     *            the lookup environment
     * @param parser
     *            the parser
     * @param unit
     *            the compilation unit
     */
    private void process(LookupEnvironment environment, Parser parser,
            CompilationUnitDeclaration unit) {

        environment.unitBeingCompleted = unit;

        parser.getMethodBodies(unit);

        // fault in fields & methods
        if (unit.scope != null) {
            unit.scope.faultInTypes();
        }

        // verify inherited methods
        if (unit.scope != null) {
            unit.scope.verifyMethods(environment.methodVerifier());
        }

        // type checking
        unit.resolve();

        // flow analysis
        unit.analyseCode();

        // code generation
        unit.generateCode();

        if (JavaModelSupport.createCompilerOptions().produceReferenceInfo && unit.scope != null) {
            unit.scope.storeDependencyInfo();
        }

        unit.finalizeProblems();

        environment.unitBeingCompleted = null;

        unit.ignoreFurtherInvestigation = false;
        unit.cleanUp();
    }

}
