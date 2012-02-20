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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.DefaultErrorHandlingPolicies;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.nabucco.framework.mda.model.java.jdt.NameEnvironment;
import org.nabucco.framework.mda.model.java.jdt.TypeRequestor;

/**
 * JavaModelSupport
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public final class JavaModelSupport {

    private static final int MAX_PROBLEMS_PER_UNIT = 100;

    private static final int TOTAL_UNITS_KNOWN = 1;

    private static final int UNIT_INDEX = 0;

    /**
     * Private constructor.
     */
    private JavaModelSupport() {
        throw new IllegalStateException("Private constructor must not be invoked.");
    }

    public static CompilerOptions createCompilerOptions() {

        Map<String, String> settings = new HashMap<String, String>();
        settings.put(CompilerOptions.OPTION_Compliance, CompilerOptions.VERSION_1_6);
        settings.put(CompilerOptions.OPTION_Source, CompilerOptions.VERSION_1_6);
        settings.put(CompilerOptions.OPTION_TargetPlatform, CompilerOptions.VERSION_1_6);
        // settings.put(CompilerOptions.OPTION_DocCommentSupport, CompilerOptions.ENABLED);

        CompilerOptions compilerOptions = new CompilerOptions(settings);

        return compilerOptions;
    }

    public static LookupEnvironment createLookupEnvironment(CompilationUnitDeclaration unit,
            CompilerOptions options) {

        TypeRequestor typeRequestor = new TypeRequestor();
        NameEnvironment nameEnvironment = new NameEnvironment();

        LookupEnvironment lookupEnvironment = new LookupEnvironment(typeRequestor, options,
                unit.problemReporter, nameEnvironment);

        return lookupEnvironment;
    }

    public static ProblemReporter createDefaultProblemReporter(CompilerOptions options) {
        return new ProblemReporter(DefaultErrorHandlingPolicies.proceedWithAllProblems(), options,
                new DefaultProblemFactory());
    }

    public static CompilationResult createCompilationResult(CompilationUnit unit) {
        return new CompilationResult(unit, UNIT_INDEX, TOTAL_UNITS_KNOWN, MAX_PROBLEMS_PER_UNIT);
    }
}
