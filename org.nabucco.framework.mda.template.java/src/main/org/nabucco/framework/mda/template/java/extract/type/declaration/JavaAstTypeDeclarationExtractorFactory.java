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
package org.nabucco.framework.mda.template.java.extract.type.declaration;

import org.nabucco.framework.mda.template.java.extract.JavaAstTypeDeclarationExtractor;

/**
 * JavaAstTypeDeclarationExtractorFactory
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstTypeDeclarationExtractorFactory {

    /**
     * Singleton instance.
     */
    private static JavaAstTypeDeclarationExtractorFactory instance = new JavaAstTypeDeclarationExtractorFactory();

    /**
     * Private constructor.
     */
    private JavaAstTypeDeclarationExtractorFactory() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstTypeDeclarationExtractorFactory instance.
     */
    public static JavaAstTypeDeclarationExtractorFactory getInstance() {
        return instance;
    }

    /**
     * Returns a {@link JavaAstTypeDeclarationExtractor} implementation instance.
     * 
     * @return a {@link JavaAstTypeDeclarationExtractor} implementation instance.
     */
    public JavaAstTypeDeclarationExtractor getJavaAstTypeDeclarationExtractor() {
        return JavaAstTypeDeclarationExtractorImpl.getInstance();
    }

}
