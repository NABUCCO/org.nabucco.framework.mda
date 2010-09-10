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
package org.nabucco.framework.mda.model.java.ast.element;

import java.util.Arrays;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.JavaAstMethodCall;

/**
 * JavaAstMethodCallImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaAstMethodCallImpl implements JavaAstMethodCall {

    /**
     * Singleton instance.
     */
    private static JavaAstMethodCallImpl instance = new JavaAstMethodCallImpl();

    /**
     * Private constructor.
     */
    private JavaAstMethodCallImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstMethodCallImpl instance.
     */
    public static JavaAstMethodCallImpl getInstance() {
        return instance;
    }

    @Override
    public void addArgument(Expression argument, MessageSend method) throws JavaModelException {
        if (argument != null && method != null) {
            Expression[] arguments = method.arguments;
            Expression[] argumentsCopy = Arrays.copyOf(arguments, arguments.length + 1);
            argumentsCopy[argumentsCopy.length - 1] = argument;
            method.arguments = argumentsCopy;
        }
    }

    @Override
    public void setMethodName(String name, MessageSend method) throws JavaModelException {
        if (name != null && method != null) {
            method.selector = name.toCharArray();
        }
    }

    @Override
    public void setMethodReceiver(Expression receiver, MessageSend method)
            throws JavaModelException {
        if (receiver != null && method != null) {
            method.receiver = receiver;
        }
    }

}
