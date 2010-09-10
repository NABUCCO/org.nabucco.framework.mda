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

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * Interface for copy operations on {@link CompilationUnitDeclaration}.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstUnitExtractor {

    /**
     * Extracts a {@link CompilationUnitDeclaration} copy by its given template (only one
     * compilation unit must exist for a template).
     * 
     * @param template
     *            the java template
     * @param name
     *            name of the unit to extract
     * 
     * @return the loaded {@link CompilationUnitDeclaration}
     * 
     * @throws JavaTemplateException
     */
    CompilationUnitDeclaration extractCompilationUnit(JavaTemplate template)
            throws JavaTemplateException;
}
