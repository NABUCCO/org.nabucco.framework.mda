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
package org.nabucco.framework.mda.model.java.ast.element;

import org.nabucco.framework.mda.model.java.ast.JavaAstArgument;
import org.nabucco.framework.mda.model.java.ast.JavaAstCommon;
import org.nabucco.framework.mda.model.java.ast.JavaAstField;
import org.nabucco.framework.mda.model.java.ast.JavaAstMethod;
import org.nabucco.framework.mda.model.java.ast.JavaAstMethodCall;
import org.nabucco.framework.mda.model.java.ast.JavaAstParameter;
import org.nabucco.framework.mda.model.java.ast.JavaAstReference;
import org.nabucco.framework.mda.model.java.ast.JavaAstType;
import org.nabucco.framework.mda.model.java.ast.JavaAstUnit;

/**
 * Factory for all classes offering functions for EJC 'Java-AST' elements.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class JavaAstElementFactory {

    /**
     * Singleton instance.
     */
    private static JavaAstElementFactory instance = new JavaAstElementFactory();

    /**
     * Private constructor.
     */
    private JavaAstElementFactory() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstElementFactory instance.
     */
    public static JavaAstElementFactory getInstance() {
        return instance;
    }

    public JavaAstCommon getJavaAstCommon() {
        return JavaAstCommonImpl.getInstance();
    }

    public JavaAstUnit getJavaAstUnit() {
        return JavaAstUnitImpl.getInstance();
    }

    public JavaAstType getJavaAstType() {
        return JavaAstTypeImpl.getInstance();
    }

    public JavaAstField getJavaAstField() {
        return JavaAstFieldImpl.getInstance();
    }

    public JavaAstMethod getJavaAstMethod() {
        return JavaAstMethodImpl.getInstance();
    }

    public JavaAstParameter getJavaAstParameter() {
        return JavaAstParameterImpl.getInstance();
    }

    public JavaAstArgument getJavaAstArgument() {
        return JavaAstArgumentImpl.getInstance();
    }

    public JavaAstReference getJavaAstReference() {
        return JavaAstReferenceImpl.getInstance();
    }

    public JavaAstMethodCall getJavaAstMethodCall() {
        return JavaAstMethodCallImpl.getInstance();
    }
}
