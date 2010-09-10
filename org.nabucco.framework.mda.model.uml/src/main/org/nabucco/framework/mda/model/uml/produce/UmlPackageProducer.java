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
package org.nabucco.framework.mda.model.uml.produce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Type;

/**
 * UmlPackageProducer
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class UmlPackageProducer {

    /**
     * Singleton instance.
     */
    private static UmlPackageProducer instance = new UmlPackageProducer();

    /**
     * Private constructor.
     */
    private UmlPackageProducer() {
    }

    /**
     * Singleton access.
     * 
     * @return the UmlPackageProducer instance.
     */
    public static UmlPackageProducer getInstance() {
        return instance;
    }

    /**
     * Creates an hierarchical UML package structure out of a String representation.
     * 
     * @param rootPkg
     *            the root package to insert the package structure into
     * @param name
     *            the string representation of the package, e.g. "org.nabucco.framework"
     * 
     * @return the child package
     */
    public Package createPackages(Package rootPkg, String name) {

        if (name.contains(".")) {

            String[] pkgTokens = name.split("\\.");
            Package pkg = createSubPackage(rootPkg, pkgTokens[0]);

            for (int i = 1; i < pkgTokens.length - 1; i++) {
                pkg = createSubPackage(pkg, pkgTokens[i]);
            }
            return pkg;
        }
        return rootPkg;
    }

    private Package createSubPackage(Package rootPkg, String pkgName) {

        Package pkg;
        PackageableElement element = rootPkg.getPackagedElement(pkgName);

        if (element == null) {
            pkg = UmlModelProducer.getInstance().createUmlPackage(rootPkg, pkgName);
        } else {

            if (element instanceof Package) {
                pkg = (Package) rootPkg.getPackagedElement(pkgName);
            } else {
                throw new IllegalArgumentException("Element name already used in package "
                        + pkgName);
            }
        }
        return pkg;
    }

    /**
     * Crates a String representation out of an hierarchical UML package structure.
     * 
     * @param type
     *            the type within the package structure.
     * 
     * @return a string representation of the type's package, e.g. 'org.nabucco.framework'
     */
    public String getPackageString(Type type) {

        List<String> pkgTokenList = new ArrayList<String>();
        Package parentPkg = type.getPackage();

        while (parentPkg != null && parentPkg.getName() != null) {

            if (!(parentPkg instanceof Model || parentPkg instanceof Profile)) {
                pkgTokenList.add(parentPkg.getName());
            }

            parentPkg = parentPkg.getNestingPackage();
        }

        Collections.reverse(pkgTokenList);

        StringBuilder pkgName = new StringBuilder();
        for (String pkgToken : pkgTokenList) {
            pkgName.append(pkgToken);
            pkgName.append(".");
        }

        if (pkgName.length() == 0) {
            return null;
        }

        return pkgName.substring(0, pkgName.length() - 1);
    }

}
