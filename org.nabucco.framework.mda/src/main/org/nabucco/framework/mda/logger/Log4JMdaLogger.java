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

import org.apache.log4j.Logger;
import org.nabucco.framework.mda.MdaExeception;

/**
 * Log4JMdaLogger
 * 
 * @author Frank Ratschinski, PRODYNA AG
 * @author Nicolas Moser, PRODYNA AG
 */
public class Log4JMdaLogger implements MdaLogger {

    /** The delegated logger. */
    private Logger logger;

    /**
     * Creates a new {@link Log4JMdaLogger} instance.
     * 
     * @param clazz
     *            the logging class
     */
    public Log4JMdaLogger(Class<?> clazz) {
        if (clazz != null) {
            this.logger = Logger.getLogger(clazz);
        } else {
            this.logger = Logger.getLogger(MdaLogger.class);
            this.logger.warn("No logging class defined using default 'NabuccoLogger'!");
        }
    }

    @Override
    public void fatal(Throwable throwable, String... message) {
        if (!this.isLogged(throwable)) {
            this.logger.fatal(this.appendMessages(message), throwable);
        }
    }

    @Override
    public void fatal(String... message) {
        this.logger.fatal(this.appendMessages(message));
    }

    @Override
    public void error(Throwable throwable, String... message) {
        if (!this.isLogged(throwable)) {
            this.logger.error(this.appendMessages(message), throwable);
        }
    }

    @Override
    public void error(String... message) {
        this.logger.error(this.appendMessages(message));
    }

    @Override
    public void warning(Throwable throwable, String... message) {
        if (!this.isLogged(throwable)) {
            this.logger.warn(this.appendMessages(message), throwable);
        }
    }

    @Override
    public void warning(String... message) {
        this.logger.warn(this.appendMessages(message));
    }

    @Override
    public void info(Throwable throwable, String... message) {
        if (this.logger.isInfoEnabled() && !this.isLogged(throwable)) {
            this.logger.error(this.appendMessages(message), throwable);
        }
    }

    @Override
    public void info(String... message) {
        if (this.logger.isInfoEnabled()) {
            this.logger.info(this.appendMessages(message));
        }
    }

    @Override
    public void debug(Throwable throwable, String... message) {
        if (this.logger.isDebugEnabled() && !this.isLogged(throwable)) {
            this.logger.debug(this.appendMessages(message), throwable);
        }
    }

    @Override
    public void debug(String... message) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug(this.appendMessages(message));
        }
    }

    @Override
    public void trace(String... message) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(this.appendMessages(message));
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    /**
     * Check whether the exception has already been logged and must not be logged again.
     * 
     * @param throwable
     *            the throwable to log
     * 
     * @return <b>true</b> if the exception must be logged, <b>false</b> if not
     */
    private boolean isLogged(Throwable throwable) {
        if (throwable == null) {
            return true;
        }

        if (throwable instanceof MdaExeception) {
            MdaExeception loggingBehaviour = (MdaExeception) throwable;

            boolean isLogged = loggingBehaviour.isLogged();
            loggingBehaviour.setLogged(true);

            return isLogged;
        }

        return false;
    }

    /**
     * Append the message fragments into a common string.
     * 
     * @param messages
     *            the message tokens
     * 
     * @return the resulting message
     */
    private String appendMessages(String... messages) {
        if (messages == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        if (this.isDebugEnabled()) {
            String identifier = MdaIdentifierThreadLocal.getMdaIdentifier();
            if (identifier != null && !identifier.isEmpty()) {
                result.append("ID=[");
                result.append(identifier);
                result.append("] ");
            }
        }

        for (int i = 0; i < messages.length; i++) {
            String message = messages[i];
            if (message != null) {
                result.append(messages[i]);
            }
        }

        return result.toString();
    }
}
