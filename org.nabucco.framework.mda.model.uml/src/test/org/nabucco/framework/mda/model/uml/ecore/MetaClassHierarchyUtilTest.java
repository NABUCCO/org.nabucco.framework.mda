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

package org.nabucco.framework.mda.model.uml.ecore;

import java.util.Set;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Assert;
import org.junit.Test;
import org.nabucco.framework.mda.model.uml.UmlModelException;
import org.nabucco.framework.mda.model.uml.ecore.MetaClassHierarchyUtil;

/**
 * MetaClassHierarchyUtilTest
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class MetaClassHierarchyUtilTest {

    @Test
    public void testMetaClassHierarchyUtil() throws UmlModelException {
        // Element.
        Set<Class<?>> superInterfaces = MetaClassHierarchyUtil
                .extractAllSuperInterfaces(Element.class);
        Assert.assertEquals(3, superInterfaces.size());

        // Association.
        superInterfaces = MetaClassHierarchyUtil.extractAllSuperInterfaces(Association.class);
        Assert.assertEquals(13, superInterfaces.size());

        // NamedElement.
        superInterfaces = MetaClassHierarchyUtil.extractAllSuperInterfaces(NamedElement.class);
        Assert.assertEquals(4, superInterfaces.size());
    }
}
