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
package org.nabucco.framework.mda.template.java.extract.importreference;

import org.nabucco.framework.mda.template.java.extract.JavaAstImportReferenceExtractor;

/**
 * JavaAstImportReferenceExtractorFactory
 * 
 * <br/>
 * <br/>
 * 
 * Factory for Java AST import reference (imports or package definitions) manipulation operations.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstImportReferenceExtractorFactory {

    /**
     * Singleton instance.
     */
    private static JavaAstImportReferenceExtractorFactory instance = new JavaAstImportReferenceExtractorFactory();

    /**
     * Private constructor.
     */
    private JavaAstImportReferenceExtractorFactory() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstImportReferenceExtractorFactory instance.
     */
    public static JavaAstImportReferenceExtractorFactory getInstance() {
        return instance;
    }

    /**
     * Returns a {@link JavaAstImportReferenceExtractor} implementation instance.
     * 
     * @return a {@link JavaAstImportReferenceExtractor} implementation instance.
     */
    public JavaAstImportReferenceExtractor getJavaAstImportReferenceExtractor() {
        return JavaAstImportReferenceExtractorImpl.getInstance();
    }
}
