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
package org.nabucco.framework.mda.model.java.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.core.util.SimpleDocument;
import org.eclipse.jdt.internal.formatter.DefaultCodeFormatter;
import org.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.element.JavaAstElementFactory;

/**
 * Utility class for code formatting issues.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaCodeFormatter implements JavaCodeFormatterConstants {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            JavaCodeFormatter.class);

    /**
     * Formats code of a {@link CompilationUnitDeclaration} appropriate to the default eclipse code
     * formatter options.
     * 
     * @see DefaultCodeFormatterOptions
     * 
     * @param unit
     *            the compilation unit to format.
     * @param configFile
     *            the formatter configuration file.
     * 
     * @return the formatter code string
     * 
     * @throws JavaModelException
     *             if the code formatting was not successful
     */
    public String formatCode(CompilationUnitDeclaration unit, String configFile)
            throws JavaModelException {

        String sourceCode = JavaAstElementFactory.getInstance().getJavaAstCommon()
                .getSourceCode(unit).toString();

        String typeName = new String(JavaAstElementFactory.getInstance().getJavaAstUnit()
                .getPublicJavaClass(unit).name);

        CodeFormatter formatter;

        if (configFile != null) {
            formatter = ToolFactory.createCodeFormatter(this.readConfig(configFile),
                    ToolFactory.M_FORMAT_EXISTING);
        } else {
            formatter = this.createDefaultCodeFormatter();
        }

        TextEdit edit = formatter.format(CodeFormatter.K_COMPILATION_UNIT, sourceCode, OFFSET,
                sourceCode.length(), INDENTATION, LINE_SEPARATOR);

        if (edit == null) {
            logger.warning("Cannot format Java File '", typeName, ".java'.");
            return sourceCode;
        }

        try {
            IDocument document = new SimpleDocument(sourceCode);
            edit.apply(document);

            return document.get();

        } catch (MalformedTreeException e) {
            throw new JavaModelException("Error formatting [" + typeName + "].", e);
        } catch (BadLocationException e) {
            throw new JavaModelException("Error formatting [" + typeName + "].", e);
        }

    }

    /**
     * Creates a code formatter with default formatter properties.
     * 
     * <ul>
     * <li>Source : 1.5</li>
     * <li>Compliance : 1.5</li>
     * <li>Target Platform : 1.5</li>
     * </ul>
     * 
     * @return the default code formatter
     */
    private CodeFormatter createDefaultCodeFormatter() {

        DefaultCodeFormatterOptions formatterOptions = DefaultCodeFormatterOptions
                .getEclipseDefaultSettings();

        formatterOptions.page_width = MAX_LINE_WIDTH;

        @SuppressWarnings("unchecked")
        Map<String, Object> options = formatterOptions.getMap();
        options.put("org.eclipse.jdt.core.compiler.compliance", 1.5);
        options.put("org.eclipse.jdt.core.compiler.codegen.targetPlatform", 1.5);
        options.put("org.eclipse.jdt.core.compiler.source", 1.5);

        return new DefaultCodeFormatter(formatterOptions, options);
    }

    /**
     * Loads properties of a .properties or .xml file.
     * 
     * @param fileName
     *            name of the file
     * 
     * @return the formatter properties
     * 
     * @throws JavaModelException
     */
    private Properties readConfig(String fileName) throws JavaModelException {

        // TODO: Change FileName to InputStream

        String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));

        BufferedInputStream stream = null;
        try {
            stream = new BufferedInputStream(new FileInputStream(new File(fileName)));
            final Properties formatterOptions = new Properties();

            if (fileSuffix.equalsIgnoreCase(SUFFIX_PROPERTIES)) {
                formatterOptions.load(stream);
            } else if (fileSuffix.equalsIgnoreCase(SUFFIX_XML)) {
                formatterOptions.loadFromXML(stream);
            } else {
                throw new JavaModelException("Java Formatter file type '."
                        + fileSuffix + "' is not supported.");
            }

            return formatterOptions;

        } catch (IOException e) {
            throw new JavaModelException("Error reading formatter properties.", e);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    throw new JavaModelException("Error closing formatter file stream.", e);
                }
            }
        }
    }

}
