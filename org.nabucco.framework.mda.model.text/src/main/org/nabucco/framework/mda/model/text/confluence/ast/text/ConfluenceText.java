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

import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceComponent;
import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceVisitor;

/**
 * ConfluenceText
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ConfluenceText extends ConfluenceComponent {

    private static final long serialVersionUID = 1L;

    private ConfluenceTextEffect effectType;

    private static String EMPTY = "";

    private String value;

    /**
     * Creates a new {@link ConfluenceText} instance.
     */
    public ConfluenceText() {
    }

    /**
     * Creates a new {@link ConfluenceText} instance.
     * 
     * @param value
     *            the text
     */
    public ConfluenceText(String value) {
        this.value = value;
    }

    /**
     * Creates a new {@link ConfluenceText} instance.
     * 
     * @param effect
     *            the text effect
     */
    public ConfluenceText(ConfluenceTextEffect effect) {
        this.effectType = effect;
        this.value = EMPTY;
    }

    /**
     * Creates a new {@link ConfluenceText} instance.
     * 
     * @param value
     *            the text
     * @param effect
     *            the text effect
     */
    public ConfluenceText(String value, ConfluenceTextEffect effect) {
        this.value = value;
        this.effectType = effect;
    }

    /**
     * Getter for the value.
     * 
     * @return Returns the value.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Setter for the value.
     * 
     * @param value
     *            The value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Getter for the effectType.
     * 
     * @return Returns the effectType.
     */
    public ConfluenceTextEffect getEffectType() {
        return this.effectType;
    }

    /**
     * Setter for the effectType.
     * 
     * @param effectType
     *            The effectType to set.
     */
    public void setEffectType(ConfluenceTextEffect effectType) {
        this.effectType = effectType;
    }

    @Override
    public <A> void accept(ConfluenceVisitor<A> visitor, A argument) {
        visitor.visit(this, argument);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
