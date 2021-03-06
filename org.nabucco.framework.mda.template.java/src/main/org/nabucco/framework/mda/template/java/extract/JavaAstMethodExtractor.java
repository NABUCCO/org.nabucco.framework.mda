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
package org.nabucco.framework.mda.template.java.extract;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.model.java.ast.element.method.JavaAstMethodSignature;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * JavaAstMethodExtractor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstMethodExtractor {

    /**
     * Extracts a {@link AbstractMethodDeclaration} copy by type declaration name and method
     * signature of a given template.
     * 
     * @param template
     *            the java template
     * @param methodSignature
     *            Signature of the method to load
     * 
     * @return the extracted {@link AbstractMethodDeclaration}
     * 
     * @throws JavaTemplateException
     */
    AbstractMethodDeclaration extractMethod(JavaTemplate template, String typeDeclarationName,
            JavaAstMethodSignature methodSignature) throws JavaTemplateException;

    /**
     * Extracts and copies all {@link AbstractMethodDeclaration} of a given {@link TypeDeclaration}.
     * 
     * @param type
     *            the TypeDeclaration
     * 
     * @return the extracted {@link AbstractMethodDeclaration} list.
     * 
     * @throws JavaTemplateException
     */
    List<AbstractMethodDeclaration> extractMethods(TypeDeclaration type)
            throws JavaTemplateException;

    /**
     * Extracts a {@link AbstractMethodDeclaration} copy by type declaration name and method
     * signature of a given template.
     * 
     * @param template
     * @param typeDeclarationName
     * @param methodSignature
     * @return
     * @throws JavaTemplateException
     */
    AbstractMethodDeclaration extractConstructor(JavaTemplate template, String typeDeclarationName,
            JavaAstMethodSignature methodSignature) throws JavaTemplateException;

    /**
     * Extracts and copies all {@link AbstractMethodDeclaration} of a given {@link TypeDeclaration}.
     * 
     * @param type
     *            the TypeDeclaration
     * 
     * @return
     * @throws JavaTemplateException
     */
    List<AbstractMethodDeclaration> extractConstructors(TypeDeclaration type)
            throws JavaTemplateException;
}
