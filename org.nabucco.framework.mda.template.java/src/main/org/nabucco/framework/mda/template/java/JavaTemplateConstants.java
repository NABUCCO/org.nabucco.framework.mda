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
package org.nabucco.framework.mda.template.java;

import org.nabucco.framework.mda.template.MdaTemplateConstants;

/**
 * JavaTemplateConstants
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface JavaTemplateConstants extends MdaTemplateConstants {

    final String SERVICE = "Service";

    final String COMPONENT = "Component";

    final String DATATYPE = "Datatype";
    
    final String COMMAND = "Command";

    final String COMMON = "Common";

    final String BROWSER = "Browser";

    final String INTERFACE = "Interface";

    final String ABSTRACT = "Abstract";

    final String IMPLEMENTATION = "Impl";

    final String OPERATION = "Operation";

    final String HANDLER = "Handler";

    final String VISITOR = "Visitor";

    final String MODEL = "Model";

    final String LOCATOR = "Locator";

    final String VIEW = "View";

    final String DELEGATE = "Delegate";

    final String FACTORY = "Factory";

    final String WIDGET = "Widget";

    final String WIDGET_FACTORY = WIDGET + FACTORY;

    final String SEARCH = "Search";

    final String EDIT = "Edit";

    final String LIST = "List";

    final String LAYOUTER = "Layouter";

    final String TABLE = "Table";

    final String FILTER = "Filter";

    final String DECLARATION = "Declaration";

    final String METHOD = "Method";

    final String LABEL_PROVIDER = "LabelProvider";

    /* Template Support */

    final String JAVA_SUFFIX = ".java";

}
