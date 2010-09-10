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

    private static final int DEFAULT_BUFFER_SIZE = 65536; // 64 KB;

    public MdaFileComparator() {
        this(DEFAULT_BUFFER_SIZE);
    }

    public MdaFileComparator(int bufferSize) {
        this.bufferSize = bufferSize;
        this.buffer1 = ByteBuffer.allocate(bufferSize);
        this.buffer2 = ByteBuffer.allocate(bufferSize);
    }

    /**
     * Compares two files for content.
     * 
     * @param file
     *            the first file
     * @param newFile
     *            the second file
     * 
     * @return <b>true</b> if the files are equal, <b>false</b> if not.
     * 
     * @throws ModelException
     *             if the files are not valid
     */
    public boolean compareFileContent(File file, String content) throws ModelException {

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

            long alreadyReadedBytes = 0;

            while (alreadyReadedBytes < oldLength) {

                this.buffer1.clear();
                this.buffer2.clear();

                int size1 = readIn(fileInput.getChannel(), this.buffer1);
                readIn(content, this.buffer2);

                if (!compare(this.buffer1, this.buffer2, size1)) {
                    return false;
                }
                alreadyReadedBytes += size1;
            }

            return true;

        } catch (IOException e) {
            throw new ModelException("Error comparing files.", e);
        }

    }

    private int readIn(FileChannel file, ByteBuffer buffer) throws IOException {
        int x = 0, z = 0;
        do {
            x += z;
            z = file.read(buffer);
        } while ((x < this.bufferSize) & (z != -1));
        return x;
    }

    private void readIn(String content, ByteBuffer buffer) {

        // TODO: buffersize

        char[] contentArray = content.toCharArray();

        for (int i = 0; i < contentArray.length; i++) {
            buffer.put(i, (byte) contentArray[i]);
        }
    }

    private static boolean compare(ByteBuffer a, ByteBuffer b, int len) {
        for (int i = 0; i < len; i++) {
            if (a.get(i) != b.get(i))
                return false;
        }
        return true;
    }

}
