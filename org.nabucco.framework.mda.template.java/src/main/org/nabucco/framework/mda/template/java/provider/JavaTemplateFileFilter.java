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
package org.nabucco.framework.mda.template.java.provider;

import java.io.File;
import java.util.zip.ZipEntry;

import org.nabucco.framework.mda.template.java.JavaTemplateConstants;
import org.nabucco.framework.mda.util.file.DefaultFileFilter;

/**
 * JavaTemplateFileFilter
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaTemplateFileFilter extends DefaultFileFilter implements JavaTemplateConstants {

    /**
     * Singleton instance.
     */
    private static JavaTemplateFileFilter instance = new JavaTemplateFileFilter();

    /**
     * Private constructor.
     */
    private JavaTemplateFileFilter() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaTemplateFileFilter instance.
     */
    public static JavaTemplateFileFilter getInstance() {
        return instance;
    }

    @Override
    public boolean accept(File file) {
        String name = file.getName();
        if (name.endsWith(JAVA_SUFFIX)) {
            return true;
        }
        return super.accept(file);
    }

    @Override
    public boolean accept(ZipEntry entry) {
        if (!entry.isDirectory() && entry.getName().endsWith(JAVA_SUFFIX)) {
            return true;
        }
        return super.accept(entry);
    }
}
