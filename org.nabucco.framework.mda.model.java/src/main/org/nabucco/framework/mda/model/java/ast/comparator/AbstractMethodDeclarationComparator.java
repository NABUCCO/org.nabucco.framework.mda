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
package org.nabucco.framework.mda.model.java.ast.comparator;

import java.util.Comparator;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;

/**
 * AbstractMethodComparator
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class AbstractMethodDeclarationComparator implements Comparator<AbstractMethodDeclaration> {

    /**
     * Singleton instance.
     */
    private static AbstractMethodDeclarationComparator instance = new AbstractMethodDeclarationComparator();

    /**
     * Private constructor.
     */
    private AbstractMethodDeclarationComparator() {
    }

    /**
     * Singleton access.
     * 
     * @return the AbstractMethodComparator instance.
     */
    public static AbstractMethodDeclarationComparator getInstance() {
        return instance;
    }

    @Override
    public int compare(AbstractMethodDeclaration o1, AbstractMethodDeclaration o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }

        int result = compareInstances(o1, o2);
        if (result != 0) {
            return result;
        }

        int modifiers1 = o1.modifiers;
        int modifiers2 = o2.modifiers;

        result = ModifiersComparator.PUBLIC_MODIFIER.compare(modifiers1, modifiers2);
        if (result != 0) {
            return result;
        }
        result = ModifiersComparator.FINAL_MODIFIER.compare(modifiers1, modifiers2);
        if (result != 0) {
            return result;
        }
        result = ModifiersComparator.STATIC_MODIFIER.compare(modifiers1, modifiers2);
        if (result != 0) {
            return result;
        }

        return result;
    }

    private int compareInstances(AbstractMethodDeclaration o1, AbstractMethodDeclaration o2) {
        boolean constructor1 = o1 instanceof ConstructorDeclaration;
        boolean constructor2 = o2 instanceof ConstructorDeclaration;

        if (constructor1 && constructor2) {
            return 0;
        }
        if (constructor1) {
            return -1;
        }
        if (constructor2) {
            return 1;
        }

        return 0;
    }
}
