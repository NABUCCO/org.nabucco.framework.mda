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
package org.nabucco.framework.mda.model.text.confluence.ast.page;

import org.nabucco.framework.mda.model.text.confluence.ConfluenceModelException;
import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceComposite;
import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceVisitor;

/**
 * ConfluencePage
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ConfluencePage extends ConfluenceComposite {

    private static final long serialVersionUID = 1L;

    private String name;

    private String projectName;
    
    private String pageType;

    /**
     * Creates a new {@link ConfluencePage} instance.
     * 
     * @param name
     *            the page name
     * @param projectName
     *            name of the project
     * @param type
     *            type of the page (component, datatype e.g.)
     */
    public ConfluencePage(String name, String projectName, String pageType) throws ConfluenceModelException {
        if (name == null || projectName == null || pageType == null) {
            throw new ConfluenceModelException("Page must have a name and a type!");
        }

        this.name = name;
        this.setPageType(pageType);
        this.setProjectName(projectName);
    }

    /**
     * Getter for the name.
     * 
     * @return Returns the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for the name.
     * 
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        // TODO: NullSafety
        this.name = name;
    }

    @Override
    public <A> void accept(ConfluenceVisitor<A> visitor, A argument) {
        visitor.visit(this, argument);
    }

    /**
     * Setter for the projectName.
     * 
     * @param projectName
     *            The projectName to set.
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Getter for the projectName.
     * 
     * @return Returns the projectName.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Setter for the pageType.
     * 
     * @param pageType The pageType to set.
     */
    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    /**
     * Getter for the pageType.
     * 
     * @return Returns the pageType.
     */
    public String getPageType() {
        return pageType;
    }

}
