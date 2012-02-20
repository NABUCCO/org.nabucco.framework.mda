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
package org.nabucco.framework.mda.model.text.confluence.ast.heading;

import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceComposite;
import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceVisitor;

/**
 * ConfluenceHeading
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ConfluenceHeading extends ConfluenceComposite {

    /** The Heading Literal */
    public static final String LITERAL = "h";

    private static final long serialVersionUID = 1L;

    private ConfluenceHeadingSize size;

    /**
     * Creates a new {@link ConfluenceHeading} instance.
     * 
     * @param size
     *            the heading size
     */
    public ConfluenceHeading(ConfluenceHeadingSize size) {
        if (size == null) {
            this.size = ConfluenceHeadingSize.H3;
        } else {
            this.size = size;
        }
    }

    /**
     * Creates a new {@link ConfluenceHeading} instance.
     * 
     * @param size
     *            the heading size
     */
    public ConfluenceHeading(int size) {
        this.size = ConfluenceHeadingSize.valueOf(size);
    }

    /**
     * Getter for the size.
     * 
     * @return Returns the size.
     */
    public ConfluenceHeadingSize getSize() {
        return this.size;
    }

    /**
     * Setter for the size.
     * 
     * @param size
     *            The size to set.
     */
    public void setSize(ConfluenceHeadingSize size) {
        this.size = size;
    }

    /**
     * Setter for the size.
     * 
     * @param size
     *            The size to set.
     */
    public void setSize(int size) {
        this.size = ConfluenceHeadingSize.valueOf(size);
    }

    @Override
    public <A> void accept(ConfluenceVisitor<A> visitor, A argument) {
        visitor.visit(this, argument);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
