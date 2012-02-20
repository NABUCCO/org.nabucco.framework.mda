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

import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.NormalAnnotation;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * Interface for copy operations on {@link MemberValuePair}.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public interface JavaAstMemberValuePairExtractor {

    /**
     * Extracts and copies the member value pairs of a {@link NormalAnnotation}.
     * 
     * @param annotation
     *            the {@link NormalAnnotation}
     * @param scope
     *            the {@link BlockScope}
     * 
     * @return a list of {@link MemberValuePair}
     * 
     * @throws JavaTemplateException
     */
    List<MemberValuePair> extractMemberValuePairs(NormalAnnotation annotation, BlockScope scope)
            throws JavaTemplateException;
}
