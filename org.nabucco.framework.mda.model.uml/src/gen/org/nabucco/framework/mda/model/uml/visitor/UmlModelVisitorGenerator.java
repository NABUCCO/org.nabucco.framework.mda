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

package org.nabucco.framework.mda.model.uml.visitor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.uml.ecore.EcoreMetaClassConstants;
import org.nabucco.framework.mda.model.uml.ecore.MetaClassHierarchySorter;

/**
 * There are generated code fragments for 'UmlModelVisitors'.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class UmlModelVisitorGenerator {

    private static enum VisitorType {
        STRUCTURED, CONTENT
    };

    /**
     * Comment for <code>ECORE_ELEMENT</code>
     */
    private static final String ECORE_ELEMENT = EcoreMetaClassConstants.ECORE_PACKAGE + ".Element";

    /**
     * The current visitor type decides for which visitor the output is generated.
     */
    private static final VisitorType CURRENT_VISITOR_TYPE = VisitorType.CONTENT;

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            UmlModelVisitorGenerator.class);

    public static void main(String[] args) throws Exception {
        Set<Class<?>> metaClassSet = extractMetaClasses();
        logger.trace("Number of meta classes " + metaClassSet.size());

        List<Class<?>> sortedMetaClasses = MetaClassHierarchySorter
                .sortMetaClassesByInterfaceHierarchy(metaClassSet);

        PrintStream out = System.out;

        out.println("\n\n");
        
        StringBuilder builder = new StringBuilder();
        buildUmlModelContentVisitorFragment(sortedMetaClasses, builder);

        out.println(builder.toString());
    }

    /**
     * The code fragment for 'UmlModelContentVisitor' is built.
     * 
     * @param metaClasses
     * @return
     */
    private static void buildUmlModelContentVisitorFragment(List<Class<?>> metaClasses,
            StringBuilder builder) {
        for (Class<?> metaClass : metaClasses) {
            if (metaClass.getName().equals(ECORE_ELEMENT)) {
                continue;
            }

            // Specific visit methods.
            builder.append("    public void visit(");
            builder.append(metaClass.getName());
            builder.append(" uml");
            builder.append(metaClass.getSimpleName());

            if (CURRENT_VISITOR_TYPE == VisitorType.CONTENT) {
                builder.append(", M targetMdaModel) throws UmlVisitorException {");
            } else if (CURRENT_VISITOR_TYPE == VisitorType.STRUCTURED) {
                builder.append(") throws UmlVisitorException {");
            } else {
                throw new IllegalArgumentException("Following visitor type isn't supported: "
                        + CURRENT_VISITOR_TYPE);
            }

            builder.append("\n");
            builder.append("        visit(");
            builder.append("uml");
            builder.append(metaClass.getSimpleName());

            if (CURRENT_VISITOR_TYPE == VisitorType.CONTENT) {
                builder.append(".getOwnedElements(), targetMdaModel);");
            } else if (CURRENT_VISITOR_TYPE == VisitorType.STRUCTURED) {
                builder.append(".getOwnedElements());");
            } else {
                throw new IllegalArgumentException("Following visitor type isn't supported: "
                        + CURRENT_VISITOR_TYPE);
            }

            builder.append("\n");
            builder.append("    }");

            builder.append("\n\n");
        }

        // General visit method.
        String decisionStatement = "        if";
        builder.append("    public final void visit(");
        builder.append(EcoreMetaClassConstants.ECORE_PACKAGE);

        if (CURRENT_VISITOR_TYPE == VisitorType.CONTENT) {
            builder.append(".Element umlElement, M targetMdaModel) throws UmlVisitorException {");
        } else if (CURRENT_VISITOR_TYPE == VisitorType.STRUCTURED) {
            builder.append(".Element umlElement) throws UmlVisitorException {");
        } else {
            throw new IllegalArgumentException("Following visitor type isn't supported: "
                    + CURRENT_VISITOR_TYPE);
        }

        builder.append("\n");
        for (Class<?> metaClass : metaClasses) {
            if (metaClass.getName().equals(ECORE_ELEMENT)) {
                continue;
            }

            builder.append(decisionStatement);
            builder.append(" (umlElement instanceof ");
            builder.append(metaClass.getName());
            builder.append(") {");
            builder.append("\n");
            builder.append("            visit((");
            builder.append(metaClass.getName());

            if (CURRENT_VISITOR_TYPE == VisitorType.CONTENT) {
                builder.append(") umlElement, targetMdaModel);");
            } else if (CURRENT_VISITOR_TYPE == VisitorType.STRUCTURED) {
                builder.append(") umlElement);");
            } else {
                throw new IllegalArgumentException("Following visitor type isn't supported: "
                        + CURRENT_VISITOR_TYPE);
            }

            builder.append("\n");
            builder.append("        }");

            decisionStatement = " else if";
        }
        builder.append(" else {");
        builder.append("\n");
        builder.append("            logger.warning(umlElement.getClass().getName(), \" : not yet supported\");");
        builder.append("\n");
        builder.append("        }");
        builder.append("\n");
        builder.append("    }");
    }

    /**
     * The meta class names are extracted from a property file. For every name the meta class is
     * extracted per reflection.
     * 
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static Set<Class<?>> extractMetaClasses() throws IOException, FileNotFoundException {
        Properties umlMetaClassNames = new Properties();
        umlMetaClassNames.load(new FileInputStream("./conf/gen/umlMetaClasses.properties"));

        Set<Class<?>> metaClasses = new HashSet<Class<?>>();
        for (Object metaClassName : umlMetaClassNames.keySet()) {
            try {
                metaClasses.add(Class.forName(EcoreMetaClassConstants.ECORE_PACKAGE
                        + "." + (String) metaClassName));
            } catch (ClassNotFoundException e) {
                logger.warning("Class not found: " + metaClassName);
            }
        }

        return metaClasses;
    }
}
