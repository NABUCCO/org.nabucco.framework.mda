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
package org.nabucco.framework.mda.model.uml;

import org.nabucco.framework.mda.model.ModelException;

/**
 * UmlModelException
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class UmlModelException extends ModelException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new {@link UmlModelException} instance.
     */
    public UmlModelException() {
    }

    /**
     * Creates a new {@link UmlModelException} instance.
     * 
     * @param message
     *            the error message
     * @param cause
     *            the error cause
     */
    public UmlModelException(String message, Exception cause) {
        super(message, cause);
    }

    /**
     * Creates a new {@link UmlModelException} instance.
     * 
     * @param message
     *            the error message
     */
    public UmlModelException(String messages) {
        super(messages);
    }

    /**
     * Creates a new {@link UmlModelException} instance.
     * 
     * @param cause
     *            the error cause
     */
    public UmlModelException(Exception cause) {
        super(cause);
    }

}
