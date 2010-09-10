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

package org.nabucco.framework.mda.template.java.extract.membervaluepair;

import org.nabucco.framework.mda.template.java.extract.JavaAstMemberValuePairExtractor;

/**
 * Factory for Java AST copy operations.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class JavaAstMemberValuePairExtractorFactory {

    /**
     * Singleton instance.
     */
    private static JavaAstMemberValuePairExtractorFactory instance = new JavaAstMemberValuePairExtractorFactory();

    /**
     * Private constructor.
     */
    private JavaAstMemberValuePairExtractorFactory() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstMemberValuePairExtractorFactory instance.
     */
    public static JavaAstMemberValuePairExtractorFactory getInstance() {
        return instance;
    }

    /**
     * Returns a {@link JavaAstMemberValuePairExtractor} implementation instance.
     * 
     * @return a {@link JavaAstMemberValuePairExtractor} implementation instance.
     */
    public JavaAstMemberValuePairExtractor getJavaAstMemberValuePairExtractor() {
        return JavaAstMemberValuePairExtractorImpl.getInstance();
    }
}
