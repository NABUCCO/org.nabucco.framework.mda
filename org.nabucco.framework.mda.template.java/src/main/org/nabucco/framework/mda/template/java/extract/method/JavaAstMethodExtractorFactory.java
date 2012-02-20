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
package org.nabucco.framework.mda.template.java.extract.method;

import org.nabucco.framework.mda.template.java.extract.JavaAstMethodExtractor;

/**
 * JavaAstMethodExtractorFactory
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstMethodExtractorFactory {

    /**
     * Singleton instance.
     */
    private static JavaAstMethodExtractorFactory instance = new JavaAstMethodExtractorFactory();

    /**
     * Private constructor.
     */
    private JavaAstMethodExtractorFactory() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstMethodExtractorFactory instance.
     */
    public static JavaAstMethodExtractorFactory getInstance() {
        return instance;
    }

    /**
     * Returns a {@link JavaAstMethodExtractor} implementation instance.
     * 
     * @return a {@link JavaAstMethodExtractor} implementation instance.
     */
    public JavaAstMethodExtractor getJavaAstMethodExtractor() {
        return JavaAstMethodExtractorImpl.getInstance();
    }

}
