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

/**
 * ConfluenceHeadingSize
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public enum ConfluenceHeadingSize {

    H1(1),

    H2(2),

    H3(3),

    H4(4),

    H5(5),

    H6(6);

    private int size;

    /**
     * Creates a new {@link ConfluenceHeadingSize} instance.
     * 
     * @param size
     *            the heading size
     */
    private ConfluenceHeadingSize(int size) {
        this.size = size;
    }

    /**
     * Getter for the size.
     * 
     * @return Returns the size.
     */
    public int getValue() {
        return this.size;
    }

    /**
     * Resolves the {@link ConfluenceHeadingSize} from the given integer size.
     * 
     * @param size
     *            the size as integer
     * 
     * @return the confluence heading size for the given integer, or the default value H3
     */
    public static ConfluenceHeadingSize valueOf(int size) {
        for (ConfluenceHeadingSize confluenceHeadingSize : ConfluenceHeadingSize.values()) {
            if (confluenceHeadingSize.getValue() == size) {
                return confluenceHeadingSize;
            }
        }

        return ConfluenceHeadingSize.H3;
    }

}
