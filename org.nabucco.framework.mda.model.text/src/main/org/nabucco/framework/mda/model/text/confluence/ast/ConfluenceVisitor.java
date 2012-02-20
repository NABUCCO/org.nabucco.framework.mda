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
package org.nabucco.framework.mda.model.text.confluence.ast;

import org.nabucco.framework.mda.model.text.confluence.ast.format.ConfluenceLine;
import org.nabucco.framework.mda.model.text.confluence.ast.format.ConfluenceSeparator;
import org.nabucco.framework.mda.model.text.confluence.ast.heading.ConfluenceHeading;
import org.nabucco.framework.mda.model.text.confluence.ast.link.ConfluenceExternalLink;
import org.nabucco.framework.mda.model.text.confluence.ast.link.ConfluenceLink;
import org.nabucco.framework.mda.model.text.confluence.ast.link.ConfluenceLocalAnchor;
import org.nabucco.framework.mda.model.text.confluence.ast.metadatalist.ConfluenceMetadataList;
import org.nabucco.framework.mda.model.text.confluence.ast.metadatalist.ConfluenceMetadataListContent;
import org.nabucco.framework.mda.model.text.confluence.ast.metadatalist.ConfluenceMetadataListElement;
import org.nabucco.framework.mda.model.text.confluence.ast.page.ConfluencePage;
import org.nabucco.framework.mda.model.text.confluence.ast.page.ConfluencePagePart;
import org.nabucco.framework.mda.model.text.confluence.ast.table.ConfluenceTable;
import org.nabucco.framework.mda.model.text.confluence.ast.table.ConfluenceTableRow;
import org.nabucco.framework.mda.model.text.confluence.ast.table.ConfluenceTableRowContent;
import org.nabucco.framework.mda.model.text.confluence.ast.text.ConfluenceText;

/**
 * ConfluenceVisitor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public abstract class ConfluenceVisitor<A> {

    /**
     * Visit the confluence page.
     * 
     * @param page
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluencePage page, A argument) {
        this.visitChildren(page, argument);
    }

    /**
     * Visit the confluence page.
     * 
     * @param page
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluencePagePart page, A argument) {
        this.visitChildren(page, argument);
    }

    /**
     * Visit the confluence heading.
     * 
     * @param heading
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceHeading heading, A argument) {
        this.visitChildren(heading, argument);
    }

    /**
     * Visit the confluence heading.
     * 
     * @param heading
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceMetadataList metadataList, A argument) {
        this.visitChildren(metadataList, argument);
    }

    /**
     * Visit the confluence line.
     * 
     * @param heading
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceLine line, A argument) {
        this.visitChildren(line, argument);
    }

    /**
     * Visit the confluence line.
     * 
     * @param heading
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceSeparator saparator, A argument) {
        this.visitChildren(saparator, argument);
    }

    /**
     * Visit the confluence heading.
     * 
     * @param heading
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceMetadataListElement metadataListelement, A argument) {
        this.visitChildren(metadataListelement, argument);
    }

    /**
     * Visit the confluence text.
     * 
     * @param text
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceText text, A argument) {
        this.visitChildren(text, argument);
    }

    /**
     * Visit the confluence text element.
     * 
     * @param element
     *            the confluence element
     * @param argument
     *            the child argument
     */
    public void visit(ConfluenceMetadataListContent text, A argument) {
        this.visitChildren(text, argument);
    }

    /**
     * Visit the confluence link.
     * 
     * @param text
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceLink link, A argument) {
        this.visitChildren(link, argument);
    }

    /**
     * Visit the confluence link.
     * 
     * @param text
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceExternalLink link, A argument) {
        this.visitChildren(link, argument);
    }

    /**
     * Visit the confluence link.
     * 
     * @param text
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceLocalAnchor link, A argument) {
        this.visitChildren(link, argument);
    }

    /**
     * Visit the confluence table.
     * 
     * @param text
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceTable table, A argument) {
        this.visitChildren(table, argument);
    }

    /**
     * Visit the confluence table row.
     * 
     * @param text
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceTableRow row, A argument) {
        this.visitChildren(row, argument);
    }

    /**
     * Visit the confluence table row.
     * 
     * @param text
     *            the element to visit
     * @param argument
     *            the passed argument
     */
    public void visit(ConfluenceTableRowContent rowContent, A argument) {
        this.visitChildren(rowContent, argument);
    }

    /**
     * Visit the children of a confluence element if any exist.
     * 
     * @param element
     *            the confluence element
     * @param argument
     *            the child argument
     */
    private void visitChildren(ConfluenceElement element, A argument) {
        if (element instanceof ConfluenceComposite) {
            for (ConfluenceElement child : ((ConfluenceComposite) element).getChildren()) {
                child.accept(this, argument);
            }
        }
    }

}
