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
package org.nabucco.framework.mda.model.java.ast.extension.unit;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.nabucco.framework.mda.model.java.ast.comparator.ImportDeclarationComparator;
import org.nabucco.framework.mda.util.MessageFormatter;

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
        if (this.rootComment != null) {
            output.append(this.rootComment);
            output.append('\n');
        } else {

            {
                String plainMessage = CompilationUnitHeader.HEADER;
                Map<String, Serializable> params = new HashMap<String, Serializable>();
                params.put("year", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                output.append(MessageFormatter.format(plainMessage, params));
            }

            output.append('\n');

            String generator = GeneratorIdentifierThreadLocal.getGeneratorIdentifier();
            String version = GeneratorVersionThreadLocal.getGeneratorVersion();

            if (generator != null && version != null) {
                String plainMessage = CompilationUnitHeader.GENERATOR;
                Map<String, Serializable> params = new HashMap<String, Serializable>();
                params.put("generator", generator);
                params.put("version", version);

                String message = MessageFormatter.format(plainMessage, params);

                output.append(" * ").append('\n');
                output.append(" * ").append(message).append('\n');
                output.append(" * ").append('\n');
            }
        }

        output.append(" */").append('\n');

        if (this.imports != null) {
            Arrays.sort(this.imports, ImportDeclarationComparator.getInstance());
        }

        return super.print(indent, output);
    }

    /**
     * Getter for the compilation unit file header.
     * 
     * @param indent
     *            the indent.
     * 
     * @return the file header
     */
    public String getHeader(int indent) {

        StringBuilder output = new StringBuilder();

        output.append("/*").append('\n').append(" *");
        if (this.rootComment != null) {
            output.append(this.rootComment);
            output.append('\n');
        } else {

            {
                String plainMessage = CompilationUnitHeader.HEADER;
                Map<String, Serializable> params = new HashMap<String, Serializable>();
                params.put("year", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                output.append(MessageFormatter.format(plainMessage, params));
            }

            output.append('\n');

            String generator = GeneratorIdentifierThreadLocal.getGeneratorIdentifier();
            String version = GeneratorVersionThreadLocal.getGeneratorVersion();

            if (generator != null && version != null) {
                String plainMessage = CompilationUnitHeader.GENERATOR;
                Map<String, Serializable> params = new HashMap<String, Serializable>();
                params.put("generator", generator);
                params.put("version", version);

                String message = MessageFormatter.format(plainMessage, params);

                output.append(" * ").append('\n');
                output.append(" * ").append(message).append('\n');
                output.append(" * ").append('\n');
            }
        }

        output.append(" */").append('\n');

        return output.toString();
    }
}
