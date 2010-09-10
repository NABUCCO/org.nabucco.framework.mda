/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.mda.template.xml.provider;

import java.io.File;
import java.util.zip.ZipEntry;

import org.nabucco.framework.mda.template.xml.XmlTemplateConstants;
import org.nabucco.framework.mda.util.file.DefaultFileFilter;

/**
 * XmlTemplateFileFilter
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class XmlTemplateFileFilter extends DefaultFileFilter implements XmlTemplateConstants {

    /**
     * Singleton instance.
     */
    private static XmlTemplateFileFilter instance = new XmlTemplateFileFilter();

    /**
     * Private constructor.
     */
    private XmlTemplateFileFilter() {
    }

    /**
     * Singleton access.
     * 
     * @return the XmlTemplateFileFilter instance.
     */
    public static XmlTemplateFileFilter getInstance() {
        return instance;
    }

    @Override
    public boolean accept(File file) {
        String name = file.getName();
        if (name.endsWith(XML_SUFFIX)) {
            return true;
        }
        return super.accept(file);
    }

    @Override
    public boolean accept(ZipEntry entry) {
        if (!entry.isDirectory() && entry.getName().endsWith(XML_SUFFIX)) {
            return true;
        }
        return super.accept(entry);
    }

}
