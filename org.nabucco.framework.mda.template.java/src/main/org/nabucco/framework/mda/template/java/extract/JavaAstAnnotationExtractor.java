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
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * Interface for copy operations on {@link Annotation}.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public interface JavaAstAnnotationExtractor {

    /**
     * Extracts and copies all annotations of a {@link TypeDeclaration}.
     * 
     * @param typeDeclaration
     *            the {@link TypeDeclaration}
     * 
     * @return the list of {@link Annotation}
     * 
     * @throws JavaTemplateException
     */
    List<Annotation> extractAnnotations(TypeDeclaration typeDeclaration)
            throws JavaTemplateException;

    /**
     * Extracts and copies all annotations of a {@link AbstractMethodDeclaration}.
     * 
     * @param typeDeclaration
     *            the {@link AbstractMethodDeclaration}
     * 
     * @return the list of {@link Annotation}
     * 
     * @throws JavaTemplateException
     */
    List<Annotation> extractAnnotations(AbstractMethodDeclaration abstractMethodDeclaration)
            throws JavaTemplateException;

    /**
     * Extracts and copies all annotations of a {@link AbstractVariableDeclaration}.
     * 
     * @param typeDeclaration
     *            the {@link AbstractVariableDeclaration}
     * @param scope
     *            the {@link BlockScope}
     * 
     * @return the list of {@link Annotation}
     * 
     * @throws JavaTemplateException
     */
    List<Annotation> extractAnnotations(AbstractVariableDeclaration abstractVariableDeclaration,
            BlockScope scope) throws JavaTemplateException;

}
