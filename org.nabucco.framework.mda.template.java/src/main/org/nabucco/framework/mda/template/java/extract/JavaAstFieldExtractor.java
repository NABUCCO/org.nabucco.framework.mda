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

import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * Interface for copy operations on {@link FieldDeclaration}.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstFieldExtractor {

    /**
     * Extracts a {@link FieldDeclaration} copy by its name of a given template.
     * 
     * @param template
     *            the java template
     * @param typeDeclarationName
     *            the type declaration name
     * @param field
     *            name name of the field to load
     * 
     * @return the extracted {@link FieldDeclaration}
     * 
     * @throws JavaTemplateException
     */
    FieldDeclaration extractField(JavaTemplate template, String typeDeclarationName,
            String fieldName) throws JavaTemplateException;

    /**
     * Extracts and copies all {@link FieldDeclaration} of a given {@link TypeDeclaration}.
     * 
     * @param type
     *            the TypeDeclaration
     * 
     * @return the extracted FieldDeclaration list.
     * 
     * @throws JavaTemplateException
     */
    List<FieldDeclaration> extractFields(TypeDeclaration type) throws JavaTemplateException;
}
