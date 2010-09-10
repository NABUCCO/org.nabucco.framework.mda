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
 * 
 * Log4JMdaLogger
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class Log4JMdaLogger implements MdaLogger {

    private Logger logger;

    public Log4JMdaLogger(Class<?> clazz) {
        this.logger = Logger.getLogger(clazz);
    }

    @Override
    public void debug(Exception e, String... message) {
        if (logger.isDebugEnabled()) {
            logger.debug(appendMessages(message), e);
        }
    }

    @Override
    public void debug(String... message) {
        if (logger.isDebugEnabled()) {
            logger.debug(appendMessages(message));
        }
    }

    @Override
    public void error(Exception e, String... message) {
        logger.error(appendMessages(message), e);
    }

    @Override
    public void error(String... message) {
        logger.error(appendMessages(message));

    }

    @Override
    public void fatal(Exception e, String... message) {
        logger.fatal(appendMessages(message), e);

    }

    @Override
    public void fatal(String... message) {
        logger.fatal(appendMessages(message));

    }

    @Override
    public void info(Exception e, String... message) {
        if (logger.isInfoEnabled()) {
            logger.error(appendMessages(message), e);
        }
    }

    @Override
    public void info(String... message) {
        if (logger.isInfoEnabled()) {
            logger.info(appendMessages(message));
        }
    }

    @Override
    public void trace(String... message) {
        if (logger.isTraceEnabled()) {
            logger.trace(appendMessages(message));
        }
    }

    @Override
    public void warning(Exception e, String... message) {
        logger.warn(appendMessages(message), e);
    }

    @Override
    public void warning(String... message) {
        logger.warn(appendMessages(message));

    }

    private String appendMessages(String... message) {
        int size = message.length;
        int msgLength = 0;
        for (int i = 0; i < size; i++) {
            msgLength += message[i].length();
        }
        StringBuilder sb = new StringBuilder(msgLength);
        for (int i = 0; i < size; i++) {
            sb.append(message[i]);
        }
        return sb.toString();
    }
}
