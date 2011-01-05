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

import java.util.Arrays;

import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.JavaAstReference;

/**
 * JavaAstReferenceImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstReferenceImpl implements JavaAstReference {

    private final static char[] INT = { 'i', 'n', 't' };

    private final static char[] LONG = { 'l', 'o', 'n', 'g' };

    private final static char[] DOUBLE = { 'd', 'o', 'u', 'b', 'l', 'e' };

    private final static char[] FLOAT = { 'f', 'l', 'o', 'a', 't' };

    private final static char[] BOOLEAN = { 'b', 'o', 'o', 'l', 'e', 'a', 'n' };

    private final static char[] SHORT = { 's', 'h', 'o', 'r', 't' };

    private final static char[] BYTE = { 'b', 'y', 't', 'e' };

    private final static char[] CHAR = { 'c', 'h', 'a', 'r' };

    private final static char[] VOID = { 'v', 'o', 'i', 'd' };

    /**
     * Singleton instance.
     */
    private static JavaAstReferenceImpl instance = new JavaAstReferenceImpl();

    /**
     * Private constructor.
     */
    private JavaAstReferenceImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstReferenceImpl instance.
     */
    public static JavaAstReferenceImpl getInstance() {
        return instance;
    }

    @Override
    public Boolean isPrimitive(TypeReference reference) {

        if (reference == null) {
            return false;
        }

        char[] name = reference.getLastToken();

        if (Arrays.equals(name, INT)) {
            return true;
        } else if (Arrays.equals(name, LONG)) {
            return true;
        } else if (Arrays.equals(name, DOUBLE)) {
            return true;
        } else if (Arrays.equals(name, FLOAT)) {
            return true;
        } else if (Arrays.equals(name, BOOLEAN)) {
            return true;
        } else if (Arrays.equals(name, SHORT)) {
            return true;
        } else if (Arrays.equals(name, BYTE)) {
            return true;
        } else if (Arrays.equals(name, CHAR)) {
            return true;
        } else if (Arrays.equals(name, VOID)) {
            return true;
        }

        return false;
    }

    public ParameterizedSingleTypeReference getAsParameterized(TypeReference reference,
            TypeReference[] parameter) {
        return new ParameterizedSingleTypeReference(reference.getLastToken(), parameter, 0, 0);
    }

    @Override
    public String getName(FieldReference reference) throws JavaModelException {
        if (reference != null) {
            return new String(reference.token);
        }
        return null;
    }

    @Override
    public void setName(String name, FieldReference reference) throws JavaModelException {
        if (name != null && reference != null) {
            reference.token = name.toCharArray();
        }
    }

}
