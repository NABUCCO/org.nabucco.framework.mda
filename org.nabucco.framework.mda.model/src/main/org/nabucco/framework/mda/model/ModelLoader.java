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
package org.nabucco.framework.mda.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * ModelLoader
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public abstract class ModelLoader<M extends ModelImplementation, A> {

    protected static final String ENCODING = "ISO-8859-1";

    private static final int DEFAULT_BUFFER_SIZE = 1024;

    private static final Charset CHARSET = Charset.forName(ENCODING);

    private static final CharsetDecoder DECODER = CHARSET.newDecoder();

    /**
     * Loads a model
     * 
     * @param argument
     *            an argument with loading information (like a file location)
     * 
     * @return the loaded model
     * 
     * @throws ModelException
     */
    public abstract M loadModel(A argument) throws ModelException;

    /**
     * Parses a {@link File} and returns the content as {@link String}.
     * 
     * @param file
     *            the file to parse
     * 
     * @return the extracted string
     * 
     * @throws IOException
     */
    protected String loadFile(File file) throws IOException {
        long size = file.length();
        char[] buffer = new char[(int) size];
        FileReader filereader = new FileReader(file);
        filereader.read(buffer);
        return new String(buffer);
    }

    /**
     * Parses a {@link InputStream} and returns the content as {@link String}.
     * 
     * @param file
     *            the file to parse
     * 
     * @return the extracted string
     * 
     * @throws IOException
     */
    protected String loadStream(InputStream in) throws IOException {

        StringBuilder result = new StringBuilder();
        ReadableByteChannel channel = Channels.newChannel(in);

        try {
            ByteBuffer buffer = ByteBuffer.allocateDirect(DEFAULT_BUFFER_SIZE);

            CharBuffer charBuffer = CharBuffer.allocate(DEFAULT_BUFFER_SIZE);

            while (channel.read(buffer) != -1) {
                buffer.flip();

                DECODER.decode(buffer, charBuffer, false);
                charBuffer.flip();

                result.append(charBuffer);

                buffer.clear();
                charBuffer.clear();
            }
        } finally {
            if (channel != null) {
                channel.close();
            }
        }

        return result.toString();
    }

}
