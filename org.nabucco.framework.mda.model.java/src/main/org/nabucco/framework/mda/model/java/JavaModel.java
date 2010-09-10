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
package org.nabucco.framework.mda.model.java;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.mda.model.MdaModelType;
import org.nabucco.framework.mda.model.ModelImplementation;

/**
 * JavaModel
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class JavaModel extends ModelImplementation {

    private static final long serialVersionUID = 1L;

    private List<JavaCompilationUnit> unitList = new ArrayList<JavaCompilationUnit>();

    /**
     * Creates a new {@link JavaModel} instance with an empty compilation unit list.
     */
    public JavaModel() {
        super(MdaModelType.JAVA);
    }

    /**
     * Creates a new {@link JavaModel} instance with one compilation unit.
     * 
     * @param unit
     *            the compilation unit
     */
    public JavaModel(JavaCompilationUnit unit) {
        super(MdaModelType.JAVA);
        this.unitList.add(unit);
    }

    /**
     * Creates a new {@link JavaModel} instance with a compilation unit list.
     * 
     * @param unitList
     *            the compilation unit list
     */
    public JavaModel(List<JavaCompilationUnit> unitList) {
        super(MdaModelType.JAVA);
        this.unitList.addAll(unitList);
    }

    /**
     * Getter for the list of compilation units.
     * 
     * @return the list of compilation units
     */
    public List<JavaCompilationUnit> getUnitList() {
        return this.unitList;
    }

}
