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
package org.nabucco.framework.mda.model.text.confluence;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.mda.model.MdaModelType;
import org.nabucco.framework.mda.model.ModelImplementation;
import org.nabucco.framework.mda.model.text.confluence.ast.page.ConfluencePage;

/**
 * ConfluenceModel
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ConfluenceModel extends ModelImplementation {

    private static final long serialVersionUID = 1L;

    private List<ConfluencePage> pages = new ArrayList<ConfluencePage>();

    /**
     * Creates a new {@link ConfluenceModelTest} instance.
     */
    public ConfluenceModel() {
        super(MdaModelType.CONFLUENCE);
    }

    /**
     * 
     * Creates a new {@link ConfluenceModel} instance with one Page
     * 
     * @param page
     */
    public ConfluenceModel(ConfluencePage page) {
        this();
        this.pages.add(page);

    }

    /**
     * Getter for the pages.
     * 
     * @return Returns the pages.
     */
    public List<ConfluencePage> getPages() {
        return this.pages;
    }

}
