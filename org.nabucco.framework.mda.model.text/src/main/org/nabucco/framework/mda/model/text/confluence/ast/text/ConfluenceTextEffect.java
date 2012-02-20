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
package org.nabucco.framework.mda.model.text.confluence.ast.text;

/**
 * ConfluenceHeadingSize
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public enum ConfluenceTextEffect {

    STRONG("*"),

    EMPHASIS("_"),

    CITATION("??"),

    STRIKETHROUGH("-"),

    UNDERLINE("+"),

    SUPERSCRIPT("^"),

    EXCERPT("{excerpt}"),

    CODE("{{", "}}"), 
    
    NEWLINE("", "\r\n\r\n"),

    SUBSCRIPT("~");

    private String startLiteral;

    private String endLiteral;

    /**
     * Creates a new {@link ConfluenceTextEffect} instance.
     * 
     * @param literal
     *            the text effect literal
     */
    private ConfluenceTextEffect(String literal) {
        this.startLiteral = literal;
        this.endLiteral = literal;
    }

    /**
     * Creates a new {@link ConfluenceTextEffect} instance.
     * 
     * @param literal
     *            the text effect literal
     */
    private ConfluenceTextEffect(String literal, String endLiteral) {
        this.startLiteral = literal;
        this.endLiteral = endLiteral;
    }

    /**
     * Getter for the start literal.
     * 
     * @return Returns the start literal.
     */
    public String getStartLiteral() {
        return this.startLiteral;
    }

    /**
     * Getter for the end literal.
     * 
     * @return Returns the end literal.
     */
    public String getEndLiteral() {
        return this.endLiteral;
    }

}
