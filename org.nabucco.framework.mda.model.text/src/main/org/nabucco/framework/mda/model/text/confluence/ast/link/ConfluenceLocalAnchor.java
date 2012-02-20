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
 * ConfluenceLocalLink
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class ConfluenceLocalAnchor extends ConfluenceComponent {

    private static final long serialVersionUID = 1L;

    private String anchorName;

    public ConfluenceLocalAnchor(String anchorName) {
        this.setAnchorName(anchorName);
    }

    @Override
    public <A> void accept(ConfluenceVisitor<A> visitor, A argument) {
        visitor.visit(this, argument);

    }

    /**
     * Setter for the anchorName.
     * 
     * @param anchorName
     *            The anchorName to set.
     */
    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    /**
     * Getter for the anchorName.
     * 
     * @return Returns the anchorName.
     */
    public String getAnchorName() {
        return anchorName;
    }

}
