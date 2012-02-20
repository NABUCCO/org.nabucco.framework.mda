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
package org.nabucco.framework.mda.model.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.nabucco.framework.mda.model.ModelException;

/**
 * MdaFileComparator
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MdaFileComparator {

    private int bufferSize;

    private ByteBuffer buffer1;

    private ByteBuffer buffer2;

    // private static final int DEFAULT_BUFFER_SIZE = 131072; // 128 KB;

    private static final int DEFAULT_BUFFER_SIZE = 65536; // 64 KB;

    /**
     * Creates a new {@link MdaFileComparator} instance.
     */
    public MdaFileComparator() {
        this(DEFAULT_BUFFER_SIZE);
    }

    /**
     * Creates a new {@link MdaFileComparator} instance.
     * 
     * @param bufferSize
     *            size of the buffer
     */
    public MdaFileComparator(int bufferSize) {
        this.bufferSize = bufferSize;
        this.buffer1 = ByteBuffer.allocate(bufferSize);
        this.buffer2 = ByteBuffer.allocate(bufferSize);
    }

    /**
     * Compares a file content with a string for equalty.
     * 
     * @param file
     *            the file
     * @param content
     *            the generated content as string
     * 
     * @return <b>true</b> if the contents are equal, <b>false</b> if not.
     * 
     * @throws ModelException
     *             if the files are not valid
     */
    public boolean compare(File file, String content) throws ModelException {

        if (file == null || content == null) {
            return false;
        }

        if (!file.exists()) {
            return false;
        }

        long oldLength = file.length();
        long newLength = content.length();

        if (oldLength != newLength) {
            return false;
        }

        FileInputStream fileInput;

        try {
            fileInput = new FileInputStream(file);
            
            int size1 = 0;
            int size2 = 0;
            long alreadyReadedBytes = 0;

            while (alreadyReadedBytes < oldLength) {

                this.buffer1.clear();
                this.buffer2.clear();

                size1 = this.readIn(fileInput.getChannel(), this.buffer1);
                size2 = this.readIn(content, this.buffer2, size2);

                if (!compare(this.buffer1, this.buffer2, size1)) {
                    return false;
                }
                alreadyReadedBytes += size1;
            }

            return true;

        } catch (Exception e) {
            throw new ModelException("Error comparing generated content with file '"
                    + file.getName() + "'.", e);
        }

    }

    /**
     * Read the file into the buffer
     * 
     * @param file
     *            the file channel holding the content
     * @param buffer
     *            the buffer to add the content
     * 
     * @return the buffer size
     * 
     * @throws IOException
     *             when the file cannot be read
     */
    private int readIn(FileChannel file, ByteBuffer buffer) throws IOException {
        int x = 0, z = 0;
        do {
            x += z;
            z = file.read(buffer);
        } while ((x < this.bufferSize) & (z != -1));
        return x;
    }

    /**
     * Read the string into the buffer.
     * 
     * @param content
     *            the string content
     * @param buffer
     *            the buffer to add the content
     * 
     * @return the buffer size
     */
    private int readIn(String content, ByteBuffer buffer, int size) {

        char[] contentArray = content.toCharArray();

        int j = 0;
        
        for (int i = size; i < contentArray.length; i++) {

            if (j >= this.bufferSize) {
                return i;
            }

            buffer.put(j, (byte) contentArray[i]);
            
            j++;
        }

        return contentArray.length;
    }

    /**
     * Compare two buffers.
     * 
     * @param a
     *            the first buffer
     * @param b
     *            the second buffer
     * @param len
     *            the buffer length
     * 
     * @return <b>true</b> when the buffers are equal, <b>false</b> if not
     */
    private static boolean compare(ByteBuffer a, ByteBuffer b, int len) {
        for (int i = 0; i < len; i++) {
            if (a.get(i) != b.get(i))
                return false;
        }
        return true;
    }

}
