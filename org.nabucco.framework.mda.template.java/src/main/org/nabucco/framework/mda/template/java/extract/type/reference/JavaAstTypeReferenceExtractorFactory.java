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
package org.nabucco.framework.mda.template.java.extract.type.reference;

import org.nabucco.framework.mda.template.java.extract.JavaAstTypeReferenceExtractor;

/**
 * JavaAstTypeReferenceExtractorFactory
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstTypeReferenceExtractorFactory {

    /**
     * Singleton instance.
     */
    private static JavaAstTypeReferenceExtractorFactory instance = new JavaAstTypeReferenceExtractorFactory();

    /**
     * Private constructor.
     */
    private JavaAstTypeReferenceExtractorFactory() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstTypeReferenceExtractorFactory instance.
     */
    public static JavaAstTypeReferenceExtractorFactory getInstance() {
        return instance;
    }

    /**
     * Returns a {@link JavaAstTypeReferenceExtractor} implementation instance.
     * 
     * @return a {@link JavaAstTypeReferenceExtractor} implementation instance.
     */
    public JavaAstTypeReferenceExtractor getJavaAstTypeReferenceExtractor() {
        return JavaAstTypeReferenceExtractorImpl.getInstance();
    }

}
