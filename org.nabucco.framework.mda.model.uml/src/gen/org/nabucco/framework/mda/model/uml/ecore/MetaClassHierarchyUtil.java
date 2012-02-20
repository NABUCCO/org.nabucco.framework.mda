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

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.nabucco.framework.mda.model.uml.UmlModelException;
import org.nabucco.framework.mda.model.uml.ecore.EcoreMetaClassConstants;

/**
 * Useful helper class in conxtext of ecore meta class hierarchy.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class MetaClassHierarchyUtil {

    /**
     * For a ecore meta class all the super interface meta classes are extracted.
     * 
     * @param clazz
     * @return
     * @throws UmlModelException
     */
    public static Set<Class<?>> extractAllSuperInterfaces(Class<?> clazz) throws UmlModelException {
        if (!clazz.getName().startsWith(EcoreMetaClassConstants.ECORE_PACKAGE)) {
            throw new UmlModelException("The given 'Class' doesn't represent an ecore meta class.");
        }

        Set<Class<?>> superInterfaceSet = new HashSet<Class<?>>(1);
        Queue<Class<?>> queue = new LinkedList<Class<?>>(Arrays.asList(clazz.getInterfaces()));

        Class<?> superInterface = null;
        while (!queue.isEmpty()) {
            superInterface = queue.poll();

            superInterfaceSet.add(superInterface);

            for (Class<?> innerSuperInterface : superInterface.getInterfaces()) {
                queue.offer(innerSuperInterface);
            }
        }

        return superInterfaceSet;
    }
}
