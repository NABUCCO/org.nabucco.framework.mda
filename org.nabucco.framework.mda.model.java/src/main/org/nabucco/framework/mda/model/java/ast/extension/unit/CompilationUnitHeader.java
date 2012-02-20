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
package org.nabucco.framework.mda.model.java.ast.extension.unit;

/**
 * CompilationUnitHeader
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
interface CompilationUnitHeader {

    final String HEADER = " Copyright {year} PRODYNA AG\n"
            + " * \n"
            + " * Licensed under the Eclipse Public License (EPL), Version 1.0 (the \"License\"); you may not use\n"
            + " * this file except in compliance with the License. You may obtain a copy of the License at\n"
            + " * \n"
            + " * http://www.opensource.org/licenses/eclipse-1.0.php or\n"
            + " * http://nabuccosource.org/License.html\n"
            + " * \n"
            + " * Unless required by applicable law or agreed to in writing, software distributed under the\n"
            + " * License is distributed on an \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,\n"
            + " * either express or implied. See the License for the specific language governing permissions\n"
            + " * and limitations under the License.";

    final String GENERATOR = "Generated with {generator} in version {version}.";
}
