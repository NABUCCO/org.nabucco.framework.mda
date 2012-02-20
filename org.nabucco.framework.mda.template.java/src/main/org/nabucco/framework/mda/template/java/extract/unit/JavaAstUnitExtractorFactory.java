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
package org.nabucco.framework.mda.template.java.extract.unit;

import org.nabucco.framework.mda.template.java.extract.JavaAstUnitExtractor;

/**
 * JavaAstUnitExtractorFactory
 * 
 * <br/>
 * <br/>
 * 
 * Factory for Java AST copy operations.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstUnitExtractorFactory {

    /**
     * Singleton instance.
     */
    private static JavaAstUnitExtractorFactory instance = new JavaAstUnitExtractorFactory();

    /**
     * Private constructor.
     */
    private JavaAstUnitExtractorFactory() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstUnitExtractorFactory instance.
     */
    public static JavaAstUnitExtractorFactory getInstance() {
        return instance;
    }

    /**
     * Returns a {@link JavaAstUnitExtractor} implementation instance.
     * 
     * @return a {@link JavaAstUnitExtractor} implementation instance.
     */
    public JavaAstUnitExtractor getJavaAstUnitExtractor() {
        return JavaAstUnitExtractorImpl.getInstance();
    }

}
