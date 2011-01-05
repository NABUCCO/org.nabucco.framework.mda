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
package org.nabucco.framework.mda.logger;

import org.apache.log4j.Logger;

/**
 * Log4JMdaLogger
 * 
 * @author Frank Ratschinski, PRODYNA AG
 * @author Nicolas Moser, PRODYNA AG
 */
public class Log4JMdaLogger implements MdaLogger {

    private Logger logger;

    /**
     * Creates a new {@link Log4JMdaLogger} instance.
     * 
     * @param clazz
     *            the logging class
     */
    public Log4JMdaLogger(Class<?> clazz) {
        this.logger = Logger.getLogger(clazz);
    }

    @Override
    public void debug(Exception e, String... message) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug(appendMessages(message), e);
        }
    }

    @Override
    public void debug(String... message) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug(appendMessages(message));
        }
    }

    @Override
    public void error(Exception e, String... message) {
        this.logger.error(appendMessages(message), e);
    }

    @Override
    public void error(String... message) {
        this.logger.error(appendMessages(message));

    }

    @Override
    public void fatal(Exception e, String... message) {
        this.logger.fatal(appendMessages(message), e);

    }

    @Override
    public void fatal(String... message) {
        this.logger.fatal(appendMessages(message));

    }

    @Override
    public void info(Exception e, String... message) {
        if (this.logger.isInfoEnabled()) {
            this.logger.error(appendMessages(message), e);
        }
    }

    @Override
    public void info(String... message) {
        if (this.logger.isInfoEnabled()) {
            this.logger.info(appendMessages(message));
        }
    }

    @Override
    public void trace(String... message) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(appendMessages(message));
        }
    }

    @Override
    public void warning(Exception e, String... message) {
        this.logger.warn(appendMessages(message), e);
    }

    @Override
    public void warning(String... message) {
        this.logger.warn(appendMessages(message));

    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    };

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

        int msgLength = 0;
        int size = messages.length;

        for (int i = 0; i < size; i++) {
            String message = messages[i];
            if (message != null) {
                msgLength += message.length();
            }
        }

        StringBuilder result = new StringBuilder(msgLength);
        for (int i = 0; i < size; i++) {
            String message = messages[i];
            if (message != null) {
                result.append(messages[i]);
            }
        }

        return result.toString();
    }
}
