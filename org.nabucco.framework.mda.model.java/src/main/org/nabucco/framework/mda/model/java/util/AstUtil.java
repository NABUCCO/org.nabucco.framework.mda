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
package org.nabucco.framework.mda.model.java.util;

import java.util.Arrays;

/**
 * Offers convenient access to char.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public final class AstUtil {

    private AstUtil() {
    }

    /**
     * Copies a two dimensional char array.
     * 
     * @param twoDimensionalCharArray
     * @return
     */
    public static char[][] copyTwoDimensionalCharArray(char[][] twoDimensionalCharArray) {
        char[][] twoDimensionalArrayCopy = new char[twoDimensionalCharArray.length][];

        for (int i = 0; i < twoDimensionalCharArray.length; i++) {
            twoDimensionalArrayCopy[i] = twoDimensionalCharArray[i].clone();
        }
        return twoDimensionalArrayCopy;
    }

    /**
     * Copies a two dimensional long array.
     * 
     * @param twoDimensionalCharArray
     * @return
     */
    public static long[][] copyTwoDimensionalLongArray(long[][] twoDimensionalCharArray) {
        long[][] twoDimensionalArrayCopy = new long[twoDimensionalCharArray.length][];

        for (int i = 0; i < twoDimensionalCharArray.length; i++) {
            twoDimensionalArrayCopy[i] = twoDimensionalCharArray[i].clone();
        }
        return twoDimensionalArrayCopy;
    }

    /**
     * Compares two two-dimensional char arrays for equalty.
     * 
     * @param c1
     *            the first char array
     * @param c2
     *            the second char array
     * @return <tt>true</tt> if the two specified arrays of longs are <i>equal</i> to one another,
     *         <tt>false</tt> otherwise.
     */
    public static boolean equals(char[][] c1, char[][] c2) {
        if (c1 == c2)
            return true;
        if (c1 == null || c2 == null)
            return false;

        int length = c1.length;
        if (c2.length != length)
            return false;

        for (int i = 0; i < length; i++)
            if (!Arrays.equals(c1[i], c2[i]))
                return false;

        return true;
    }
}
