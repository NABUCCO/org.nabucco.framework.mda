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
package org.nabucco.framework.mda.model.file.path;

import org.nabucco.framework.mda.model.ModelImplementation;

/**
 * MdaPathLocatorImpl
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class PathLocatorFactory<M extends ModelImplementation> {

    public PathLocatorFactory() {
    }

    /**
     * Returns the path locator of needed type
     * 
     * @param type
     * @param rootPath
     * @return
     */
    public PathLocator<M> getPathLocator(MdaPathTypes type, String rootPath) {
        PathLocator<M> retVal = null;

        switch (type) {
        case Confluence:
            retVal = new ConfluencePathLocator<M>(rootPath);
            break;
        }
        return retVal;
    }

}
