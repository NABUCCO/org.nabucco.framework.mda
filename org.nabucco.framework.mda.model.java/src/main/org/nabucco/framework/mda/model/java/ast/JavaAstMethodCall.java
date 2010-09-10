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
package org.nabucco.framework.mda.model.java.ast;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.nabucco.framework.mda.model.java.JavaModelException;

/**
 * JavaAstMethodCall
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaAstMethodCall {

    /**
     * Adds an argument to the method call.
     * 
     * @param argument
     *            the argument to add
     * @param method
     *            the method call to update
     * 
     * @throws JavaModelException
     */
    void addArgument(Expression argument, MessageSend method) throws JavaModelException;

    /**
     * Updates the methods name.
     * 
     * @param name
     *            name of the method
     * @param method
     *            the method call to update
     * 
     * @throws JavaModelException
     */
    void setMethodName(String name, MessageSend method) throws JavaModelException;

    /**
     * Updates the methods receiver.
     * 
     * @param receiver
     *            receiver of the method
     * @param method
     *            the method call to update
     * 
     * @throws JavaModelException
     */
    void setMethodReceiver(Expression receiver, MessageSend method) throws JavaModelException;

}
