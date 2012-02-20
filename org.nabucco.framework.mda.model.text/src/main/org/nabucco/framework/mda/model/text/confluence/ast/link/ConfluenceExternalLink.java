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
package org.nabucco.framework.mda.model.text.confluence.ast.link;

import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceComponent;
import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceVisitor;

/**
 * ConfluenceExternLink
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class ConfluenceExternalLink extends ConfluenceComponent {

    private static final long serialVersionUID = 1L;
    
    private String url;

    private String label;

    /**
     * 
     * Creates a new {@link ConfluenceExternalLink} instance.
     * 
     */
    public ConfluenceExternalLink(String url, String label) {
        if (url == null) {
            throw new IllegalArgumentException("Cannot create External link. Url is 'null'");
        }
        if (label == null) {
            throw new IllegalArgumentException("Cannot create External link. Label is 'null'");
        }

        this.setLabel(label);
        this.setUrl(url);
    }

    @Override
    public <A> void accept(ConfluenceVisitor<A> visitor, A argument) {
        visitor.visit(this, argument);

    }

    /**
     * Setter for the url.
     * 
     * @param url The url to set.
     */
    void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter for the url.
     * 
     * @return Returns the url.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Setter for the label.
     * 
     * @param label The label to set.
     */
    void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter for the label.
     * 
     * @return Returns the label.
     */
    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
