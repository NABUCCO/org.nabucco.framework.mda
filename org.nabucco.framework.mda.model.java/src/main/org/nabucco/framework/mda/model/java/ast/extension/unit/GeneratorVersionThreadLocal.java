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
package org.nabucco.framework.mda.model.java.ast.extension.unit;

/**
 * generatorVersionThreadLocal
 * <p/>
 * Utility class for accessing the generator identifier by thread-local variables.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public final class GeneratorVersionThreadLocal {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<String>();

    /**
     * Private constructor must not be invoked.
     */
    private GeneratorVersionThreadLocal() {
    }

    /**
     * Sets the generator identifier to the thread-local variables.
     * 
     * @param generatorVersion
     *            the generator identifier to set into the thread-local variables
     */
    public static final void setGeneratorVersion(String generatorVersion) {
        THREAD_LOCAL.set(generatorVersion);
    }

    /**
     * Gets the generator identifier from the thread-local variables.
     * 
     * @return the generator identifier to from the thread-local variables
     */
    public static final String getGeneratorVersion() {
        return THREAD_LOCAL.get();
    }

}
