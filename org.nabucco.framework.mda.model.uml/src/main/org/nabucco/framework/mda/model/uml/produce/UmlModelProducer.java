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
package org.nabucco.framework.mda.model.uml.produce;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.internal.impl.UMLFactoryImpl;

/**
 * UmlModelProducer
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class UmlModelProducer {

    private UMLFactory factory = UMLFactoryImpl.eINSTANCE;

    /**
     * Singleton instance.
     */
    private static UmlModelProducer instance = new UmlModelProducer();

    /**
     * Private constructor.
     */
    private UmlModelProducer() {
    }

    /**
     * Singleton access.
     * 
     * @return the UmlModelProducer instance.
     */
    public static UmlModelProducer getInstance() {
        return instance;
    }

    public Class createUmlClass(Package rootPkg, String name) {
        Class clazz = rootPkg.createOwnedClass(name, false);
        return clazz;
    }

    public Component createUmlComponent(Package rootPkg, String name) {
        Component component = factory.createComponent();
        addToPackage(rootPkg, component);
        component.setName(name);
        return component;
    }

    public Enumeration createUmlEnumeration(Package rootPkg, String name) {
        Enumeration enumeration = rootPkg.createOwnedEnumeration(name);
        return enumeration;
    }

    public Model createUmlModel(Package rootPkg) {
        Model model = factory.createModel();
        addToPackage(rootPkg, model);
        return model;
    }

    public Package createUmlPackage(Package rootPkg, String name) {
        Package pkg = rootPkg.createNestedPackage(name);
        return pkg;
    }

    public Type createUmlDatatype(String name) {
        DataType type = factory.createDataType();
        type.setName(name);
        return type;
    }

    private void addToPackage(Package pkg, PackageableElement element) {
        if (pkg != null) {
            pkg.getPackagedElements().add(element);
        }
    }

}
