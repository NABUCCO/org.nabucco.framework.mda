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
package org.nabucco.framework.mda.template.java.extract.field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.element.JavaAstElementFactory;
import org.nabucco.framework.mda.model.java.ast.visitor.JavaAstVisitor;
import org.nabucco.framework.mda.template.java.JavaTemplateException;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;

/**
 * Visits and copies all {@link FieldDeclaration} with children of a given {@link ASTNode}.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstFieldExtractorVisitor extends JavaAstVisitor {

    private static final String SERIAL_VERSION_UID = "serialVersionUID";

    private Map<String, FieldDeclaration> fieldCopyMap = new HashMap<String, FieldDeclaration>();

    private List<Initializer> initializerList = new ArrayList<Initializer>();

    @Override
    public boolean visit(FieldDeclaration fieldDeclaration, MethodScope scope) {

        checkFieldType(fieldDeclaration);

        String fieldName = new String(fieldDeclaration.name);

        FieldDeclaration fieldCopy = new FieldDeclaration(fieldName.toCharArray(),
                fieldDeclaration.sourceStart, fieldDeclaration.sourceEnd);

        fieldCopy.modifiers = fieldDeclaration.modifiers;

        copyAbstractVariableDeclaration(fieldDeclaration, fieldCopy, scope);
        fieldCopyMap.put(fieldName, fieldCopy);

        return false;
    }

    @Override
    public boolean visit(Initializer initializer, MethodScope scope) {

        try {
            // Block
            Block block = JavaAstExtractorFactory.getInstance().getStatementExtractor()
                    .extractStatement(initializer.block, scope);
            Initializer initCopy = new Initializer(block, initializer.modifiers);

            copyAbstractVariableDeclaration(initializer, initCopy, scope);
            initializerList.add(initCopy);

        } catch (JavaTemplateException e) {
            this.getVisitorContext().addException(e);
        }

        return false;
    }

    private void copyAbstractVariableDeclaration(AbstractVariableDeclaration from,
            AbstractVariableDeclaration to, BlockScope scope) {

        try {
            // Annotations.
            List<Annotation> extractedAnnotations = JavaAstExtractorFactory.getInstance()
                    .getAnnotationExtractor().extractAnnotations(from, scope);
            to.annotations = extractedAnnotations.toArray(new Annotation[extractedAnnotations
                    .size()]);

            // Type.
            to.type = JavaAstExtractorFactory.getInstance().getTypeReferenceExtractor()
                    .extractTypeReference(from.type);

            // Initialization.
            to.initialization = JavaAstExtractorFactory.getInstance().getStatementExtractor()
                    .extractStatement(from.initialization, scope);

        } catch (JavaTemplateException e) {
            this.getVisitorContext().addException(e);
        }
    }

    private void checkFieldType(FieldDeclaration field) {

        try {
            String name = new String(field.name);
            if (JavaAstElementFactory.getInstance().getJavaAstReference().isPrimitive(field.type)
                    && !name.equals(SERIAL_VERSION_UID)) {

                String exceptionMsg = "Primitive types are not supported [" + name + "].";
                JavaTemplateException exception = new JavaTemplateException(exceptionMsg);

                this.getVisitorContext().addException(exception);
            }
        } catch (JavaModelException e) {
            throw new IllegalArgumentException("Refernce is not valid.");
        }
    }

    /**
     * Getter for the visited {@link FieldDeclaration} by its name.
     * 
     * @param name
     *            the field's name.
     * 
     * @return a {@link FieldDeclaration}
     */
    public FieldDeclaration getFieldCopy(String name) {
        return fieldCopyMap.get(name);
    }

    /**
     * Getter for all visited {@link FieldDeclaration}.
     * 
     * @return a list of {@link FieldDeclaration}
     */
    public List<FieldDeclaration> getAllFieldCopies() {
        return new ArrayList<FieldDeclaration>(fieldCopyMap.values());
    }

    /**
     * Getter for all visited {@link Initializer}.
     * 
     * @return a list of {@link Initializer}
     */
    public List<Initializer> getAllInitializerCopies() {
        return this.initializerList;
    }

}
