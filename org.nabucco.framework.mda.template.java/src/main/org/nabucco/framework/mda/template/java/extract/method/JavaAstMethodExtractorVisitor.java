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
package org.nabucco.framework.mda.template.java.extract.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.nabucco.framework.mda.model.java.ast.element.method.JavaAstMethodSignature;
import org.nabucco.framework.mda.model.java.ast.extension.method.ConstructorDeclarationExtension;
import org.nabucco.framework.mda.model.java.ast.extension.method.MethodDeclarationExtension;
import org.nabucco.framework.mda.model.java.ast.visitor.JavaAstVisitor;
import org.nabucco.framework.mda.template.java.JavaTemplateException;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.JavaAstStatementExtractor;
import org.nabucco.framework.mda.template.java.extract.statement.JavaAstStatementExtractorFactory;

/**
 * JavaAstMethodExtractorVisitor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstMethodExtractorVisitor extends JavaAstVisitor {

    /** Methods by Signature. */
    private Map<JavaAstMethodSignature, AbstractMethodDeclaration> methodMap = new HashMap<JavaAstMethodSignature, AbstractMethodDeclaration>();

    /** Methods by Signature. */
    private Map<JavaAstMethodSignature, AbstractMethodDeclaration> constructorMap = new HashMap<JavaAstMethodSignature, AbstractMethodDeclaration>();

    /** Methods in order. */
    private List<AbstractMethodDeclaration> methodList = new ArrayList<AbstractMethodDeclaration>();

    /** Constructors in order. */
    private List<AbstractMethodDeclaration> constructorList = new ArrayList<AbstractMethodDeclaration>();

    @Override
    public boolean visit(MethodDeclaration methodDeclaration, ClassScope scope) {
        MethodDeclaration methodCopy = new MethodDeclarationExtension(
                methodDeclaration.compilationResult);
        copyAbstractMethodDeclaration(methodDeclaration, methodCopy);

        try {
            methodCopy.thrownExceptions = JavaAstExtractorFactory.getInstance()
                    .getTypeReferenceExtractor()
                    .extractTypeReferences(methodDeclaration.thrownExceptions);

            methodCopy.returnType = JavaAstExtractorFactory.getInstance()
                    .getTypeReferenceExtractor().extractTypeReference(methodDeclaration.returnType);
        } catch (JavaTemplateException e) {
            this.getVisitorContext().addException(e);
        }

        JavaAstMethodSignature signature = JavaAstMethodSignature
                .generateMethodSignature(methodDeclaration);

        this.methodMap.put(signature, methodCopy);
        this.methodList.add(methodCopy);

        return false;
    }

    @Override
    public boolean visit(ConstructorDeclaration constructor, ClassScope scope) {
        ConstructorDeclaration constructorCopy = new ConstructorDeclarationExtension(
                constructor.compilationResult);
        copyAbstractMethodDeclaration(constructor, constructorCopy);

        JavaAstMethodSignature signature = JavaAstMethodSignature
                .generateMethodSignature(constructor);

        this.constructorMap.put(signature, constructorCopy);
        this.constructorList.add(constructorCopy);

        return false;
    }

    /**
     * Getter for the visited {@link MethodDeclaration} by its method signature.
     * 
     * @param methodSignature
     *            the method's signature.
     * 
     * @return a {@link MethodDeclaration}
     */
    public AbstractMethodDeclaration getMethodCopy(JavaAstMethodSignature methodSignature) {
        return methodMap.get(methodSignature);
    }

    /**
     * Getter for all visited {@link MethodDeclaration}.
     * 
     * @return a list of {@link MethodDeclaration}
     */
    public List<AbstractMethodDeclaration> getAllMethodCopies() {
        return this.methodList;
    }

    /**
     * Getter for the visited {@link ConstructorDeclaration} by its method signature.
     * 
     * @param methodSignature
     *            the method's signature.
     * 
     * @return a {@link MethodDeclaration}
     */
    public AbstractMethodDeclaration getConstructorCopy(JavaAstMethodSignature methodSignature) {
        return constructorMap.get(methodSignature);
    }

    /**
     * Getter for all visited {@link ConstructorDeclaration}.
     * 
     * @return a list of {@link MethodDeclaration}
     */
    public List<AbstractMethodDeclaration> getAllConstructorCopies() {
        return this.constructorList;
    }

    private void copyAbstractMethodDeclaration(AbstractMethodDeclaration from,
            AbstractMethodDeclaration to) {

        to.selector = from.selector.clone();
        to.modifiers = from.modifiers;

        JavaAstStatementExtractor extractor = JavaAstStatementExtractorFactory.getInstance()
                .getJavaAstExpressionExtractor();

        try {
            // Arguments.
            if (from.arguments != null) {
                List<Argument> argumentList = new ArrayList<Argument>();

                for (Argument argument : from.arguments) {
                    argumentList.add(extractor.extractStatement(argument, from.scope));
                }
                to.arguments = argumentList.toArray(new Argument[argumentList.size()]);
            }

            // Statements.
            if (from.statements != null) {
                List<Statement> statementList = new ArrayList<Statement>();

                for (Statement statement : from.statements) {
                    statementList.add(extractor.extractStatement(statement, from.scope));
                }
                to.statements = statementList.toArray(new Statement[statementList.size()]);
            }

            // Constructor Call
            if (from instanceof ConstructorDeclaration && to instanceof ConstructorDeclaration) {

                ConstructorDeclaration fromConstructor = (ConstructorDeclaration) from;
                ConstructorDeclaration toConstructor = (ConstructorDeclaration) to;

                if (fromConstructor.constructorCall != null) {
                    toConstructor.constructorCall = extractor.extractStatement(
                            fromConstructor.constructorCall, fromConstructor.scope);
                }
            }

            // Annotations.
            List<Annotation> extractedAnnotations;
            extractedAnnotations = JavaAstExtractorFactory.getInstance().getAnnotationExtractor()
                    .extractAnnotations(from);
            to.annotations = extractedAnnotations.toArray(new Annotation[extractedAnnotations
                    .size()]);

        } catch (JavaTemplateException e) {
            this.getVisitorContext().addException(e);
        }
    }
}
