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
package org.nabucco.framework.mda.model.java.ast.comparator;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.jdt.internal.compiler.ast.ImportReference;

/**
 * ImportDeclarationComparator
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ImportDeclarationComparator implements Comparator<ImportReference> {

    private static final char[] IMPORT_JAVA = { 'j', 'a', 'v', 'a' };

    private static final char[] IMPORT_JAVAX = { 'j', 'a', 'v', 'a', 'x' };

    private static final char[] IMPORT_ORG = { 'o', 'r', 'g' };

    private static final char[] IMPORT_COM = { 'c', 'o', 'm' };

    /**
     * Singleton instance.
     */
    private static ImportDeclarationComparator instance = new ImportDeclarationComparator();

    /**
     * Private constructor.
     */
    private ImportDeclarationComparator() {
    }

    /**
     * Singleton access.
     * 
     * @return the ImportDeclarationComparator instance.
     */
    public static ImportDeclarationComparator getInstance() {
        return instance;
    }

    @Override
    public int compare(ImportReference i1, ImportReference i2) {
        if (i1 == null && i2 == null) {
            return 0;
        }
        if (i1 == null) {
            return -1;
        }
        if (i2 == null) {
            return 1;
        }

        char[][] import1 = i1.getImportName();
        char[][] import2 = i2.getImportName();

        return this.compare(import1, import2);
    }

    /**
     * Compares two import arrays.
     * 
     * @param i1
     *            the first import
     * @param i2
     *            the second import
     * 
     * @return the result
     */
    private int compare(char[][] i1, char[][] i2) {
        int len1 = i1.length;
        int len2 = i2.length;
        int min = Math.min(len1, len2);
        int result;

        if (min > 0) {
            result = this.comparePrefix(i1[0], i2[0]);
            if (result != 0) {
                return result;
            }
        }

        for (int i = 0; i < min; i++) {
            result = this.compare(i1[i], i2[i]);
            if (result != 0) {
                return result;
            }
        }
        return len1 - len2;
    }

    /**
     * Compares the first token of the import references in following order:
     * <ol>
     * <li>java</li>
     * <li>javax</li>
     * <li>org</li>
     * <li>com</li>
     * </ol>
     * 
     * @param i1
     * @param i2
     * @return
     */
    private int comparePrefix(char[] i1, char[] i2) {
        int result = this.compare(i1, i2);
        if (result == 0) {
            return 0;
        }

        int prio1 = this.getPriority(i1);
        int prio2 = this.getPriority(i2);

        int prio = (prio1 < prio2 ? -1 : (prio1 == prio2 ? 0 : 1));

        if (prio != 0) {
            return prio;
        }
        return result;
    }

    private int getPriority(char[] i) {
        if (Arrays.equals(i, IMPORT_JAVA)) {
            return 1;
        } else if (Arrays.equals(i, IMPORT_JAVAX)) {
            return 2;
        } else if (Arrays.equals(i, IMPORT_JAVAX)) {
            return 3;
        } else if (Arrays.equals(i, IMPORT_ORG)) {
            return 4;
        } else if (Arrays.equals(i, IMPORT_COM)) {
            return 5;
        }
        return 6;
    }

    /**
     * Compares two import tokens.
     * 
     * @param i1
     *            the first import token
     * @param i2
     *            the second import token
     * 
     * @return the result
     */
    private int compare(char[] i1, char[] i2) {
        int len1 = i1.length;
        int len2 = i2.length;
        int min = Math.min(len1, len2);

        for (int i = 0; i < min; i++) {
            int result = i1[i] - i2[i];
            if (result != 0) {
                return result;
            }
        }
        return len1 - len2;
    }

}
