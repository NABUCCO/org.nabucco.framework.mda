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
package org.nabucco.framework.mda.util.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * FileTreeVisitor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public abstract class FileTreeVisitor {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * Traverse the file directory tree recursively.
     * 
     * @param file
     *            the root file
     */
    public final void visit(final File file) throws IOException {
        if (file.isDirectory()) {

            this.visitDir(file);

            final File[] children = file.listFiles();

            for (File child : children) {
                this.visit(child);
            }

        } else if (DefaultFileFilter.getInstance().isArchive(file)) {
            this.visitArchive(file);
        } else {
            this.visitFile(file);
        }
    }

    /**
     * Traverse the file directory tree recursively for an appropriate file filter.
     * 
     * @param file
     *            the root file
     * @param filter
     *            file filter
     */
    public final void visit(final File file, final FileFilter filter) throws IOException {
        if (file.isDirectory()) {

            this.visitDir(file);

            final File[] children = file.listFiles(filter);

            for (File child : children) {
                this.visit(child, filter);
            }

        } else if (DefaultFileFilter.getInstance().isArchive(file)) {
            this.visitArchive(file);
        } else {
            this.visitFile(file);

        }
    }

    /**
     * Traverse the file directory tree recursively for an appropriate filename filter.
     * 
     * @param file
     *            the root file
     * @param filter
     *            filter file filter
     */
    public final void visit(final File file, final FilenameFilter filter) throws IOException {
        if (file.isDirectory()) {

            this.visitDir(file);

            final File[] children = file.listFiles(filter);

            for (File child : children) {
                this.visit(child, filter);
            }
        } else if (DefaultFileFilter.getInstance().isArchive(file)) {
            this.visitArchive(file);
        } else {
            this.visitFile(file);
        }
    }

    /**
     * Visits all directories.
     * 
     * @param dir
     *            the directory
     */
    protected void visitDir(final File dir) throws IOException {
    }

    /**
     * Visits all files.
     * 
     * @param file
     *            the file
     */
    protected void visitFile(final File file) throws IOException {
    }

    /**
     * Visit archive files.
     * 
     * @param zipFile
     * @throws IOException
     */
    protected void visitArchive(File zipFile) throws IOException {
    }

    protected final String convertStream(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        while ((tmp = br.readLine()) != null) {
            sb.append(tmp).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

}
