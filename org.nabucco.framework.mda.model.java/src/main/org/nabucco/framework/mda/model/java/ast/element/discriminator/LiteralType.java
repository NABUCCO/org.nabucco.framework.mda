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
package org.nabucco.framework.mda.model.java.ast.element.discriminator;

/**
 * LiteralType
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public enum LiteralType {

    TRUE_LITERAL,

    FALSE_LITERAL,

    NULL_LITERAL,

    STRING_LITERAL,

    FLOAT_LITERAL,

    INT_LITERAL,

    DOUBLE_LITERAL,

    CHAR_LITERAL,

    BOOLEAN_LITERAL,

    LONG_LITERAL;

    /**
     * Maps a given java primitive type to it's LiteralType
     * 
     * @param primitivType
     *            a java primitive Datatype
     * @return the corresponding LiteralType
     */
    public static LiteralType mapFromString(String primitivType) {
        if (primitivType.compareToIgnoreCase("String") == 0) {
            return STRING_LITERAL;
        } else if (primitivType.compareToIgnoreCase("Integer") == 0) {
            return INT_LITERAL;
        } else if (primitivType.compareToIgnoreCase("Long") == 0) {
            return LONG_LITERAL;
        } else if (primitivType.compareToIgnoreCase("Float") == 0) {
            return FLOAT_LITERAL;
        } else if (primitivType.compareToIgnoreCase("Double") == 0) {
            return DOUBLE_LITERAL;
        } else if (primitivType.compareToIgnoreCase("Character") == 0) {
            return CHAR_LITERAL;
        } else if (primitivType.compareToIgnoreCase("Boolean") == 0) {
            return BOOLEAN_LITERAL;
        } else if (primitivType.compareToIgnoreCase("false") == 0) {
            return FALSE_LITERAL;
        } else if (primitivType.compareToIgnoreCase("true") == 0) {
            return TRUE_LITERAL;
        } else if (primitivType.compareToIgnoreCase("null") == 0) {
            return NULL_LITERAL;
        }
        return null;
    }

}
