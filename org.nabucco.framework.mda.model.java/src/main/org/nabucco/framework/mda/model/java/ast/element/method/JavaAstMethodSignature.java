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
package org.nabucco.framework.mda.model.java.ast.element.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;

/**
 * JavaAstMethodSignature
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class JavaAstMethodSignature {

    private String methodName;

    private String[] parameterTypeNames;

    public JavaAstMethodSignature(String methodName, String... parameterTypeNames) {
        this.methodName = methodName;
        this.parameterTypeNames = parameterTypeNames;
    }

    /**
     * The method signature is built using method name and argument (input parameter) type names.
     * 
     * @param methodDeclaration
     * @return
     */
    public static JavaAstMethodSignature generateMethodSignature(
            AbstractMethodDeclaration methodDeclaration) {
        String methodName = new String(methodDeclaration.selector);
        if (methodDeclaration.arguments == null) {
            return new JavaAstMethodSignature(methodName);
        }

        List<String> argumentTypeNames = new ArrayList<String>();
        for (Argument argument : methodDeclaration.arguments) {
            argumentTypeNames.add(new String(argument.type.getLastToken()));
        }
        return new JavaAstMethodSignature(methodName,
                argumentTypeNames.toArray(new String[argumentTypeNames.size()]));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
        result = prime * result + Arrays.hashCode(parameterTypeNames);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JavaAstMethodSignature other = (JavaAstMethodSignature) obj;
        if (methodName == null) {
            if (other.methodName != null)
                return false;
        } else if (!methodName.equals(other.methodName))
            return false;
        if (!Arrays.equals(parameterTypeNames, other.parameterTypeNames))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(methodName);
        builder.append("(");
        for (int i = 0; i < parameterTypeNames.length; i++) {
            builder.append(parameterTypeNames[i]);
            builder.append(",");
        }
        if (builder.indexOf(",") != -1) {
            builder.delete(builder.length() - 1, builder.length());
        }
        builder.append(")");

        return builder.toString();
    }

    public String getMethodName() {
        return methodName;
    }
}
