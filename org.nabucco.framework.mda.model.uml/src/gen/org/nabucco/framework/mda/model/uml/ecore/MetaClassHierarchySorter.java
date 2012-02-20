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
package org.nabucco.framework.mda.model.uml.ecore;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.nabucco.framework.mda.model.uml.UmlModelException;

/**
 * Sorts the meta classes according interface hierarchy.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class MetaClassHierarchySorter {

    /**
     * The meta classes are sorted by interface hierarchy. The sorting is done from specific meta
     * classes to general meta classes.
     * 
     * @param metaClassSet
     * @return
     * @throws UmlModelException
     */
    public static List<Class<?>> sortMetaClassesByInterfaceHierarchy(Set<Class<?>> metaClassSet)
            throws UmlModelException {
        // The transforming to list must be done because of swapping algorithm and a because a set
        // isn't sorted.
        List<Class<?>> metaClasses = new ArrayList<Class<?>>(metaClassSet);

        for (int i = 0; i < metaClasses.size(); i++) {
            Class<?> outerClass = metaClasses.get(i);

            for (int j = i + 1; j < metaClasses.size(); j++) {
                Class<?> innerClass = metaClasses.get(j);

                // Outer class is a super interface.
                if (isSuperInterface(innerClass, outerClass)) {
                    // Swapping.
                    metaClasses.set(i, innerClass);
                    metaClasses.set(j, outerClass);

                    outerClass = innerClass;
                }
            }
        }

        return metaClasses;
    }

    /**
     * Checks if given 'superInterfaceClazz' is a super interface. The hierarchy level doesn't
     * matter.
     * 
     * @param clazz
     * @param superInterfaceClazz
     * @return
     * @throws UmlModelException
     */
    private static boolean isSuperInterface(Class<?> clazz, Class<?> superInterfaceClazz)
            throws UmlModelException {
        Set<Class<?>> superInterfaces = MetaClassHierarchyUtil.extractAllSuperInterfaces(clazz);
        return superInterfaces.contains(superInterfaceClazz);
    }
}
