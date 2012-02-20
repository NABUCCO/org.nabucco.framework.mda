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
 * ConfluenceLink
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class ConfluenceLink extends ConfluenceComponent {

    private static final long serialVersionUID = 1L;

    private String alias;

    private String namespace;

    private String pagetitle;

    private String tip;

    private ConfluenceLocalAnchor anchor;

    /**
     * 
     * Creates a new {@link ConfluenceLink} instance.
     * 
     */
    public ConfluenceLink() {

    }

    /**
     * 
     * Creates a new {@link ConfluenceLink} instance. Global link
     * 
     * @param alias
     *            The alias to display
     * @param namespace
     *            The namespace for the Link
     * @param pagetitle
     *            Title of the linked page
     * @param tip
     *            Tooltip for the link
     */
    public ConfluenceLink(String alias, String namespace, String pagetitle, String tip) {
        this.alias = alias;
        this.namespace = namespace;
        this.pagetitle = pagetitle;
        this.tip = tip;
    }

    /**
     * 
     * Creates a new {@link ConfluenceLink} instance. Global link
     * 
     * @param alias
     *            The alias to display
     * @param namespace
     *            The namespace for the Link
     * @param pagetitle
     *            Title of the linked page
     * @param tip
     *            Tooltip for the link
     */
    public ConfluenceLink(String alias, String namespace, String pagetitle) {
        this.alias = alias;
        this.namespace = namespace;
        this.pagetitle = pagetitle;
    }

    /**
     * 
     * Creates a new {@link ConfluenceLink} instance. Local link
     * 
     * @param alias
     *            The alias to display
     * @param namespace
     *            The namespace for the Link
     * @param pagetitle
     *            Title of the linked page
     * @param tip
     *            Tooltip for the link
     */
    public ConfluenceLink(ConfluenceLocalAnchor anchor) {
        this.anchor = anchor;
    }

    /**
     * 
     * Creates a new {@link ConfluenceLink} instance.
     * 
     * @param alias
     *            The alias to display
     * @param pagetitle
     *            Title of the linked page
     */
    public ConfluenceLink(String alias, String pagetitle) {
        this.alias = alias;
        this.pagetitle = pagetitle;
    }

    /**
     * 
     * Creates a new {@link ConfluenceLink} instance.
     * 
     * @param alias
     *            The alias to display
     * @param pagetitle
     *            Title of the linked page
     */
    public ConfluenceLink(String pagetitle) {
        this.alias = pagetitle;
        this.pagetitle = pagetitle;
    }

    @Override
    public <A> void accept(ConfluenceVisitor<A> visitor, A argument) {
        visitor.visit(this, argument);
    }

    /**
     * Getter for the alias.
     * 
     * @return Returns the alias.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Setter for the alias.
     * 
     * @param alias
     *            The alias to set.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Getter for the namespace.
     * 
     * @return Returns the namespace.
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Setter for the namespace.
     * 
     * @param namespace
     *            The namespace to set.
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Getter for the pagetitle.
     * 
     * @return Returns the pagetitle.
     */
    public String getPagetitle() {
        return pagetitle;
    }

    /**
     * Setter for the pagetitle.
     * 
     * @param pagetitle
     *            The pagetitle to set.
     */
    public void setPagetitle(String pagetitle) {
        this.pagetitle = pagetitle;
    }

    /**
     * Getter for the tip.
     * 
     * @return Returns the tip.
     */
    public String getTip() {
        return tip;
    }

    /**
     * Setter for the tip.
     * 
     * @param tip
     *            The tip to set.
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Setter for the anchor.
     * 
     * @param anchor
     *            The anchor to set.
     */
    public void setAnchor(ConfluenceLocalAnchor anchor) {
        this.anchor = anchor;
    }

    /**
     * Getter for the anchor.
     * 
     * @return Returns the anchor.
     */
    public ConfluenceLocalAnchor getAnchor() {
        return anchor;
    }
}
