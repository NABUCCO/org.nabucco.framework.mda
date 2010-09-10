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
package org.nabucco.framework.mda.model.java.ast.extension.unit;

import java.util.Arrays;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.nabucco.framework.mda.model.java.ast.comparator.ImportDeclarationComparator;

/**
 * Extension for java AST class {@link CompilationUnitDeclaration}. Allows parsing and printing of
 * comment blocks.
 * <p/>
 * The programming structure is oriented towards the original {@link CompilationUnitDeclaration}
 * class.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class CompilationUnitExtension extends CompilationUnitDeclaration {

    public char[] rootComment;

    /**
     * Creates a new {@link CompilationUnitExtension} instance.
     * 
     * @param problemReporter
     *            the problem reporter
     * @param compilationResult
     *            the compilation result
     * @param sourceLength
     *            the source length
     */
    public CompilationUnitExtension(ProblemReporter problemReporter,
            CompilationResult compilationResult, int sourceLength) {
        super(problemReporter, compilationResult, sourceLength);
    }

    @Override
    public StringBuffer print(int indent, StringBuffer output) {

        output.append("/*").append('\n').append(" *");
        if (rootComment != null) {
            output.append(rootComment);
        } else {
            output.append(" NABUCCO Generator,");
            output.append(" Copyright (c) 2010,");
            output.append(" PRODYNA AG, Germany.");
            output.append(" All rights reserved.");
        }
        output.append('\n').append(" */").append('\n');

        if (imports != null) {
            Arrays.sort(this.imports, ImportDeclarationComparator.getInstance());
        }

        return super.print(indent, output);
    }

}
