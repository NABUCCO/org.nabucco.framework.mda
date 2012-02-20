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
package org.nabucco.framework.mda.model.java.ast.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nabucco.framework.mda.MdaExeception;

/**
 * Context for the {@link JavaAstVisitor}.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstVisitorContext {

    private List<MdaExeception> exceptionList = new ArrayList<MdaExeception>();

    private boolean exceptionStatus = false;

    /**
     * @return Returns the exception list.
     */
    public List<MdaExeception> getExceptionList() {
        return Collections.unmodifiableList(this.exceptionList);
    }

    /**
     * Adds an exception to the context.
     * 
     * @param exception
     *            an {@link MdaExeception}
     */
    public void addException(MdaExeception exception) {
        exceptionList.add(exception);
        exceptionStatus = true;
    }

    /**
     * Checks whether a exception has been raised within the Java AST traversing.
     * 
     * @return <b>true</b> if an exception has been raised, <b>false</b> if not.
     */
    public boolean containsException() {
        return exceptionStatus;
    }

}
