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
package org.nabucco.framework.mda.template.java.extract.field;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;
import org.nabucco.framework.mda.template.java.accessor.JavaTemplateAccessor;
import org.nabucco.framework.mda.template.java.extract.JavaAstFieldExtractor;

/**
 * JavaAstFieldExtractorImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstFieldExtractorImpl implements JavaAstFieldExtractor {

    /**
     * Singleton instance.
     */
    private static JavaAstFieldExtractor instance = new JavaAstFieldExtractorImpl();

    /**
     * Private constructor.
     */
    private JavaAstFieldExtractorImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return a JavaAstFieldExtractor implementation instance.
     */
    public static JavaAstFieldExtractor getInstance() {
        return instance;
    }

    @Override
    public FieldDeclaration extractField(JavaTemplate template, String typeDeclarationName,
            String fieldName) throws JavaTemplateException {

        TypeDeclaration typeDeclaration = JavaTemplateAccessor.detectTypeDeclaration(template,
                typeDeclarationName);

        JavaAstFieldExtractorVisitor visitor = new JavaAstFieldExtractorVisitor();
        typeDeclaration.traverse(visitor, typeDeclaration.scope);

        if (visitor.getVisitorContext().containsException()) {
            throw new JavaTemplateException(visitor.getVisitorContext().getExceptionList().get(0));
        }

        List<FieldDeclaration> fields = visitor.getAllFieldCopies();
        
        for (FieldDeclaration fieldDeclaration : fields) {
            String name = new String(fieldDeclaration.name);
            
            if (name.equals(fieldName)) {
                return fieldDeclaration;
            }
        }

        return null;
    }

    @Override
    public List<FieldDeclaration> extractFields(TypeDeclaration type) throws JavaTemplateException {

        JavaAstFieldExtractorVisitor visitor = new JavaAstFieldExtractorVisitor();

        type.traverse(visitor, type.scope);

        List<FieldDeclaration> fieldCopyList = visitor.getAllFieldCopies();
        fieldCopyList.addAll(visitor.getAllInitializerCopies());

        if (visitor.getVisitorContext().containsException()) {
            throw new JavaTemplateException(visitor.getVisitorContext().getExceptionList().get(0));
        }

        return fieldCopyList;
    }
}
