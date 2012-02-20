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
package org.nabucco.framework.mda.logger;

/**
 * MdaLogger
 * 
 * @author Frank Ratschinski, PRODYNA AG
 * @author Nicolas Moser, PRODYNA AG
 */
public interface MdaLogger {

    /**
     * Severity 0.
     * 
     * @param e
     *            the cause
     * @param message
     *            the message
     */
    void fatal(Throwable t, String... message);

    /**
     * Severity 1.
     * 
     * @param e
     *            the cause
     * @param message
     *            the message
     */
    void error(Throwable t, String... message);

    /**
     * Severity 2.
     * 
     * @param e
     *            the cause
     * @param message
     *            the message
     */
    void warning(Throwable t, String... message);

    /**
     * Severity 3.
     * 
     * @param e
     *            the cause
     * @param message
     *            the message
     */
    void info(Throwable t, String... message);

    /**
     * Severity 4.
     * 
     * @param e
     *            the cause
     * @param message
     *            the message
     */
    void debug(Throwable t, String... message);

    /**
     * Severity 0.
     * 
     * @param message
     */
    void fatal(String... message);

    /**
     * Severity 1.
     * 
     * @param message
     *            the message
     */
    void error(String... message);

    /**
     * Severity 2.
     * 
     * @param message
     *            the message
     */
    void warning(String... message);

    /**
     * Severity 3.
     * 
     * @param message
     *            the message
     */
    void info(String... message);

    /**
     * Severity 4.
     * 
     * @param message
     *            the message
     */
    void debug(String... message);

    /**
     * Severity 5.
     * 
     * @param message
     *            the message
     */
    void trace(String... message);

    /**
     * Checks whether debug is enabled.
     * 
     * @return <b>true</b> if the debug level is enabled, <b>false</b> if not
     */
    boolean isDebugEnabled();

    /**
     * Checks whether trace is enabled.
     * 
     * @return <b>true</b> if the trace level is enabled, <b>false</b> if not
     */
    boolean isTraceEnabled();
}
