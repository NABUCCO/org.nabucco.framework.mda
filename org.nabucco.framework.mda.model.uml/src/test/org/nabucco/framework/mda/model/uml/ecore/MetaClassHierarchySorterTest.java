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

import java.util.HashSet;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.RedefinableElement;
import org.junit.Test;
import org.nabucco.framework.mda.model.uml.UmlModelException;
import org.nabucco.framework.mda.model.uml.ecore.MetaClassHierarchySorter;

/**
 * MetaClassHierarchySorterTest
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class MetaClassHierarchySorterTest {

    @Test
    public void testMetaClassHierarchySorterSimple() throws UmlModelException {
        HashSet<Class<?>> metaClassSet = new HashSet<Class<?>>();

        // No meta classes.
        List<Class<?>> sortedMetaClasses = MetaClassHierarchySorter
                .sortMetaClassesByInterfaceHierarchy(metaClassSet);
        Assert.assertEquals(0, sortedMetaClasses.size());

        // Element.
        metaClassSet.add(Element.class);
        sortedMetaClasses = MetaClassHierarchySorter
                .sortMetaClassesByInterfaceHierarchy(metaClassSet);
        Assert.assertEquals(1, sortedMetaClasses.size());
        Assert.assertSame(Element.class, sortedMetaClasses.get(0));

        // Include, Exclude, Element.
        metaClassSet.clear();
        metaClassSet.add(Include.class);
        metaClassSet.add(Element.class);
        metaClassSet.add(Extend.class);
        sortedMetaClasses = MetaClassHierarchySorter
                .sortMetaClassesByInterfaceHierarchy(metaClassSet);
        Assert.assertEquals(3, sortedMetaClasses.size());

        Assert.assertTrue(sortedMetaClasses.get(0).equals(Include.class)
                && sortedMetaClasses.get(1).equals(Extend.class)
                || sortedMetaClasses.get(1).equals(Include.class)
                && sortedMetaClasses.get(0).equals(Extend.class));

        Assert.assertSame(Element.class, sortedMetaClasses.get(2));
    }

    @Test
    public void testMetaClassHierarchySorterComplex1() throws UmlModelException {
        HashSet<Class<?>> metaClassSet = new HashSet<Class<?>>();

        // ConnecterEnd, MultiplicityElement, Element.
        metaClassSet.clear();
        metaClassSet.add(Element.class);
        metaClassSet.add(ConnectorEnd.class);
        metaClassSet.add(MultiplicityElement.class);
        List<Class<?>> sortedMetaClasses = MetaClassHierarchySorter
                .sortMetaClassesByInterfaceHierarchy(metaClassSet);
        Assert.assertEquals(3, sortedMetaClasses.size());

        Assert.assertSame(ConnectorEnd.class, sortedMetaClasses.get(0));
        Assert.assertSame(MultiplicityElement.class, sortedMetaClasses.get(1));
        Assert.assertSame(Element.class, sortedMetaClasses.get(2));

        // RedefinableElement, Classifier, NamedElement, Element
        metaClassSet.clear();
        metaClassSet.add(Element.class);
        metaClassSet.add(Classifier.class);
        metaClassSet.add(RedefinableElement.class);
        metaClassSet.add(NamedElement.class);

        sortedMetaClasses = MetaClassHierarchySorter
                .sortMetaClassesByInterfaceHierarchy(metaClassSet);
        Assert.assertEquals(4, sortedMetaClasses.size());

        Assert.assertSame(Classifier.class, sortedMetaClasses.get(0));
        Assert.assertSame(RedefinableElement.class, sortedMetaClasses.get(1));
        Assert.assertSame(NamedElement.class, sortedMetaClasses.get(2));
        Assert.assertSame(Element.class, sortedMetaClasses.get(3));
    }

    @Test
    public void testMetaClassHierarchySorterComplex2() throws UmlModelException {
        HashSet<Class<?>> metaClassSet = new HashSet<Class<?>>();

        // Behavior, Component, Class, Classifier, Namespace.
        metaClassSet.clear();
        metaClassSet.add(org.eclipse.uml2.uml.Class.class);
        metaClassSet.add(Behavior.class);
        metaClassSet.add(Component.class);
        metaClassSet.add(Classifier.class);
        metaClassSet.add(Namespace.class);
        List<Class<?>> sortedMetaClasses = MetaClassHierarchySorter
                .sortMetaClassesByInterfaceHierarchy(metaClassSet);
        Assert.assertEquals(5, sortedMetaClasses.size());

        Assert.assertTrue(sortedMetaClasses.get(0).equals(Behavior.class)
                && sortedMetaClasses.get(1).equals(Component.class)
                || sortedMetaClasses.get(1).equals(Behavior.class)
                && sortedMetaClasses.get(0).equals(Component.class));

        Assert.assertSame(org.eclipse.uml2.uml.Class.class, sortedMetaClasses.get(2));
        Assert.assertSame(Classifier.class, sortedMetaClasses.get(3));
        Assert.assertSame(Namespace.class, sortedMetaClasses.get(4));
    }
}
