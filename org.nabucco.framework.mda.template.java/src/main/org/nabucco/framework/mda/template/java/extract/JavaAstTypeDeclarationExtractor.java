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
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * JavaAstTypeDeclarationExtractor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstTypeDeclarationExtractor {

    /**
     * Extracts a {@link TypeDeclaration} by its name of a given template.
     * 
     * @param template
     *            the java template
     * @param typeDeclarationName
     *            name of the type declaration to load
     * 
     * @return the extracted {@link TypeDeclaration}
     * 
     * @throws JavaTemplateException
     */
    TypeDeclaration extractTypeDeclaration(JavaTemplate template, String typeDeclarationName)
            throws JavaTemplateException;

    /**
     * Extracts all {@link TypeDeclaration} of a given {@link CompilationUnitDeclaration}.
     * 
     * @param unit
     *            the CompilationUnitDeclaration
     * 
     * @return the extracted {@link TypeDeclaration} list.
     * 
     * @throws JavaTemplateException
     */
    List<TypeDeclaration> extractTypeDeclarations(CompilationUnitDeclaration unit)
            throws JavaTemplateException;

}
