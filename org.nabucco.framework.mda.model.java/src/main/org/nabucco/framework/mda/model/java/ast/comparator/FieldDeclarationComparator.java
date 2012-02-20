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
package org.nabucco.framework.mda.model.java.ast.comparator;

import java.util.Comparator;

import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;

/**
 * FieldDeclarationComparator
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class FieldDeclarationComparator implements Comparator<FieldDeclaration> {

    /**
     * Singleton instance.
     */
    private static FieldDeclarationComparator instance = new FieldDeclarationComparator();

    /**
     * Private constructor.
     */
    private FieldDeclarationComparator() {
    }

    /**
     * Singleton access.
     * 
     * @return the AbstractMethodComparator instance.
     */
    public static FieldDeclarationComparator getInstance() {
        return instance;
    }

    @Override
    public int compare(FieldDeclaration o1, FieldDeclaration o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }

        int modifiers1 = o1.modifiers;
        int modifiers2 = o2.modifiers;

        int result = compareInstances(o1, o2);
        if (result != 0) {
            return result;
        }
        result = ModifiersComparator.PRIVATE_MODIFIER.compare(modifiers1, modifiers2);
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

    private int compareInstances(FieldDeclaration o1, FieldDeclaration o2) {
        boolean initializer1 = o1 instanceof Initializer;
        boolean initializer2 = o2 instanceof Initializer;

        if (initializer1 && initializer2) {
            return 0;
        }
        if (initializer1) {
            return -1;
        }
        if (initializer2) {
            return 1;
        }

        return 0;
    }
}
