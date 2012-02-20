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
package org.nabucco.framework.mda.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;

/**
 * MessageFormatter
 * <p/>
 * Provides utility methods to format Strings concerning parameters.
 * 
 * @author Nicolas Moser PRODYNA AG
 */
public class MessageFormatter {

    private static MdaLogger logger = MdaLoggingFactory.getInstance()
            .getLogger(MessageFormat.class);

    /**
     * Private constructor must not be invoked.
     */
    private MessageFormatter() {
    }

    /**
     * Formats the message in the format "text text {parameter} {another}" with the objects in the
     * given map. Uses the default-local from the platform.
     * 
     * @param plainMessage
     *            the message
     * @param params
     *            the parameters
     * @return the formatted message
     */
    public static String format(String plainMessage, Map<String, ? extends Serializable> params) {
        return format(plainMessage, params, Locale.getDefault());
    }

    /**
     * Formats the message in the format "text text {parameter} {another}" with the objects in the
     * given map.
     * 
     * @param plainMessage
     *            the message
     * @param params
     *            the parameters
     * @param locale
     *            the input-local
     * @return the formatted message
     */
    public static String format(String plainMessage, Map<String, ? extends Serializable> params,
            Locale locale) {
        String out = plainMessage;
        try {
            String[] parameterKeysMessage = getParameterKeys(plainMessage);
            plainMessage = escape(plainMessage);
            out = prepareForMessageFormat(plainMessage);
            Object[] paramValues = getParameterValues(parameterKeysMessage, params);
            MessageFormat messageFormat = new MessageFormat(out, locale);
            out = messageFormat.format(paramValues);
        } catch (RuntimeException e) {
            logger.error(e, "Error formatting message: ", plainMessage);
        }
        return out;
    }

    /**
     * Substitues a message from <code>Error at {name} with {error}</code> to
     * <code>Error at {0} with {1}</code>.
     * 
     * @param plainMessage
     *            the message in format one
     * @param parameterKeysMessage
     *            the keys to substitute
     * @return the message in java-message-format
     */
    private static String prepareForMessageFormat(String plainMessage) {
        char[] chs = plainMessage.toCharArray();
        boolean capture = false;
        int count = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            switch (chs[i]) {
            case '{':
                capture = true;
                out.append(chs[i]);
                break;
            case '}':
            case ',':
                if (capture) {
                    capture = false;
                    out.append(count++).append(chs[i]);
                    break;
                }
                //$FALL-THROUGH$
            default: {
                if (!capture) {
                    out.append(chs[i]);
                }
            }
            }
        }
        return out.toString();
    }

    /**
     * Returns the parameter-values corresponding to the ordering in the message.
     * 
     * @param parameterKeys
     *            the parameter-keys from the message
     * @param params
     *            the param-map
     * @return the parameter-values in the correct ordering
     */
    private static Object[] getParameterValues(String[] parameterKeys,
            Map<String, ? extends Serializable> params) {
        Object[] out = new Object[parameterKeys.length];
        for (int i = 0; i < parameterKeys.length; i++) {
            if (params.containsKey(parameterKeys[i])) {
                out[i] = params.get(parameterKeys[i]);
            } else {
                out[i] = "";
            }
        }
        return out;
    }

    /**
     * Captures all parameters in the format <code>{paramname}</code> and returns
     * <code>paramname</code>.
     * 
     * @param plainMessage
     *            the message with parameters
     * @return an array of parameter-names
     */
    private static String[] getParameterKeys(String plainMessage) {
        char[] chs = plainMessage.toCharArray();
        char[] captureResult = new char[chs.length];
        boolean capture = false;
        int count = 0;
        List<String> params = new ArrayList<String>();
        for (int i = 0; i < chs.length; i++) {
            switch (chs[i]) {
            case '{':
                capture = true;
                break;
            case '}':
            case ',':
                if (capture) {
                    capture = false;
                    params.add(new String(captureResult, 0, count));
                    count = 0;
                    break;
                }
                //$FALL-THROUGH$
            default: {
                if (capture) {
                    if (Character.isLetter(chs[i]) || Character.isDigit(chs[i]) || chs[i] == '.') {
                        captureResult[count] = chs[i];
                        count++;
                    }
                }
            }
            }
        }
        return params.toArray(new String[params.size()]);
    }

    /** Escapes a given string for message-format. */
    private static String escape(String s) {
        StringBuilder out = new StringBuilder();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            if (c == '\'') {
                out.append('\'');
            }
            out.append(c);
        }
        return out.toString();
    }

}
