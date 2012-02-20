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
package org.nabucco.framework.mda.model.text.confluence.ast.table;

import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceComposite;
import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceElement;
import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceVisitor;

/**
 * ConfluenceTableRow
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class ConfluenceTableRow extends ConfluenceComposite {

    private static final long serialVersionUID = 1L;

    private boolean isHeader;

    public ConfluenceTableRow() {
        setHeader(false);
    }

    /**
     * 
     * Creates a new {@link ConfluenceTableRow} instance.
     * 
     * @param isHeader
     *            The row representes a header of the table
     */
    public ConfluenceTableRow(boolean isHeader) {
        this.setHeader(isHeader);
    }

    @Override
    public <A> void accept(ConfluenceVisitor<A> visitor, A argument) {
        visitor.visit(this, argument);
    }

    /**
     * Setter for the isHeader.
     * 
     * @param isHeader
     *            The isHeader to set.
     */
    public void setHeader(boolean isHeader) {
        this.isHeader = isHeader;
    }

    /**
     * Getter for the isHeader.
     * 
     * @return Returns the isHeader.
     */
    public boolean isHeader() {
        return isHeader;
    }

    @Override
    public void addElement(ConfluenceElement element) {
        // TODO Auto-generated method stub
        super.addElement(element);
        
        // Make content elements extend the heading status
        if (element instanceof ConfluenceTableRowContent) {
            ((ConfluenceTableRowContent) element).setHeader(this.isHeader);
        }
    }

}
