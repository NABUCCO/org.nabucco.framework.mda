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

import java.io.File;

import org.nabucco.framework.mda.model.ModelImplementation;

/**
 * ConfluenceFileLocator
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class ConfluencePathLocator<M extends ModelImplementation> implements PathLocator<M> {

    private String rootPath;

    private final String folderPath = "doc" + File.separatorChar + "api" + File.separatorChar;

    public ConfluencePathLocator(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getPath(M model, String projectName) {
        if (!this.rootPath.endsWith(File.pathSeparator)) {
            this.rootPath += File.separatorChar;
        }
        return rootPath + projectName + File.separatorChar + folderPath;
    }

}
