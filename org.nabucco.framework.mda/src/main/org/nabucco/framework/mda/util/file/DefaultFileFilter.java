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
package org.nabucco.framework.mda.util.file;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;

/**
 * DefaultFileFilter
 * 
 * @author Silas Schwarz PRODYNA AG
 */
public class DefaultFileFilter implements FileFilter {

    protected static final List<String> ARCHIVE_EXTENSIONS = Arrays.asList(new String[] { ".jar",
            ".zip" });

    /**
     * Singleton instance.
     */
    private static DefaultFileFilter instance = new DefaultFileFilter();

    /**
     * Private constructor.
     */
    protected DefaultFileFilter() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaTemplateFileFilter instance.
     */
    public static DefaultFileFilter getInstance() {
        return instance;
    }

    /**
     * Checks by file extension if the given file is a valid zip-conform archive.
     * 
     * @param file
     *            input file
     * @return <code>true</code> if has zip conform file extension and can be read, otherwise
     *         <code>false</code>
     */
    public boolean isArchive(File file) {
        if (file.isFile() && file.canRead() && validateArchiveExtension(file.getName())) {
            return true;
        }
        return false;
    }

    /**
     * Checks a given Filename for a zip like extension
     * 
     * @param name
     *            the archive name
     * @return
     */
    private boolean validateArchiveExtension(String name) {
        int lastIndexOfDot = name.lastIndexOf('.');
        if (lastIndexOfDot > 0) {
            return ARCHIVE_EXTENSIONS.contains(name.substring(lastIndexOfDot, name.length()));
        }
        return false;
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        if (isArchive(file)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a given ZipEntry if valid to the file filter, default implementation returns
     * <code>false</code>.
     * 
     * @param entry
     *            Zip file entry.
     * @return <code>true</code> if zip entry is valid, otherwise <code>false</code>
     */
    public boolean accept(ZipEntry entry) {
        return false;
    }

}
