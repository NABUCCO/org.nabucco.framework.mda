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
package org.nabucco.framework.mda.model.java.ast.produce;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.CharLiteral;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.DoubleLiteral;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.FloatLiteral;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.ast.Javadoc;
import org.eclipse.jdt.internal.compiler.ast.JavadocSingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.JavadocSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Literal;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.LongLiteral;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.OR_OR_Expression;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.UnaryExpression;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.eclipse.jdt.internal.compiler.lookup.ExtraCompilerModifiers;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.element.discriminator.BinaryExpressionType;
import org.nabucco.framework.mda.model.java.ast.element.discriminator.LiteralType;
import org.nabucco.framework.mda.model.java.ast.extension.expression.CastExpressionExtension;
import org.nabucco.framework.mda.model.java.ast.extension.javadoc.JavadocExtension;
import org.nabucco.framework.mda.model.java.ast.extension.javadoc.JavadocParameter;
import org.nabucco.framework.mda.model.java.ast.extension.method.MethodDeclarationExtension;

/**
 * JavaAstModelProducer
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public final class JavaAstModelProducer {

    private static final String DOUBLE_SUFFIX = "D";

    private static final String FLOAT_SUFFIX = "F";

    private static final String LONG_SUFFIX = "L";

    /**
     * Singleton instance.
     */
    private static JavaAstModelProducer instance = new JavaAstModelProducer();

    /**
     * Private constructor.
     */
    private JavaAstModelProducer() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstModelProducer instance.
     */
    public static JavaAstModelProducer getInstance() {
        return instance;
    }

    public Argument createArgument(String name, TypeReference type) throws JavaModelException {
        return new Argument(name.toCharArray(), 0, type, 0);
    }

    public Assignment createAssignment(Expression left, Expression right) {
        return new Assignment(left, right, 0);
    }

    public BinaryExpression createBinaryExpression(BinaryExpressionType type, Expression left,
            Expression right, Integer operator) {

        switch (type) {
        case AND_AND_EXPRESSION:
            return new AND_AND_Expression(left, right, operator);
        case OR_OR_EXPRESSION:
            return new OR_OR_Expression(left, right, operator);
        case BINARY_EXPRESSION:
            return new BinaryExpression(left, right, operator);
        case EQUAL_EXPRESSION:
            return new EqualExpression(left, right, operator);
        }

        return null;
    }

    public Block createBlock(Statement... statements) throws JavaModelException {
        Block block = new Block(0);
        if (statements != null && statements.length > 0) {
            block.statements = statements;
        }
        return block;
    }

    public CompilationUnitDeclaration createCompilationUnitDeclaration(ProblemReporter reporter,
            CompilationResult result) throws JavaModelException {
        return new CompilationUnitDeclaration(reporter, result, 0);
    }

    public ConditionalExpression createConditionalExpression(Expression condition,
            Expression valueIfTrue, Expression valueIfFalse) {
        return new ConditionalExpression(condition, valueIfTrue, valueIfFalse);
    }

    public FieldDeclaration createFieldDeclaration(String name) throws JavaModelException {
        return createFieldDeclaration(name, ClassFileConstants.AccPrivate);
    }

    public FieldDeclaration createFieldDeclaration(String name, int modifier)
            throws JavaModelException {
        FieldDeclaration field = new FieldDeclaration(name.toCharArray(), 0, 0);
        field.modifiers = modifier;
        return field;
    }

    public FieldReference createFieldSuperReference(String name) throws JavaModelException {
        FieldReference reference = new FieldReference(name.toCharArray(), 0);
        reference.receiver = new SuperReference(0, 0);

        return reference;
    }

    public FieldReference createFieldThisReference(String name) throws JavaModelException {
        FieldReference reference = new FieldReference(name.toCharArray(), 0);
        reference.receiver = new ThisReference(0, 0);

        return reference;
    }

    /**
     * Creates an if-statement without else.
     * 
     * @param condition
     *            the condition
     * @param thenStatement
     *            the then block
     * 
     * @return the created if-statement
     * 
     * @throws JavaModelException
     */
    public IfStatement createIfStatement(Expression condition, Statement thenStatement)
            throws JavaModelException {
        return createIfStatement(condition, thenStatement, null);
    }

    /**
     * Creates an if-statement with else.
     * 
     * @param condition
     *            the condition
     * @param thenStatement
     *            the then block
     * @param elseStatement
     *            the else statement
     * 
     * @return the created if-statement
     * 
     * @throws JavaModelException
     */
    public IfStatement createIfStatement(Expression condition, Statement thenStatement,
            Statement elseStatement) throws JavaModelException {
        return new IfStatement(condition, thenStatement, elseStatement, 0, 0);
    }

    public InstanceOfExpression createInstanceOfExpression(Expression expression, TypeReference type)
            throws JavaModelException {
        return new InstanceOfExpression(expression, type);
    }

    public Literal createLiteral(String value, LiteralType type) throws JavaModelException {

        value = (value != null) ? value : "";

        switch (type) {
        case TRUE_LITERAL:
            return new TrueLiteral(0, 0);
        case FALSE_LITERAL:
            return new FalseLiteral(0, 0);
        case NULL_LITERAL:
            return new NullLiteral(0, 0);
        case STRING_LITERAL:
            return new StringLiteral(value.toCharArray(), 0, 0, 0);
        case FLOAT_LITERAL:
            return new FloatLiteral(appendLiteralSuffix(LiteralType.FLOAT_LITERAL, value), 0, 0);
        case DOUBLE_LITERAL:
            return new DoubleLiteral(appendLiteralSuffix(LiteralType.DOUBLE_LITERAL, value), 0, 0);
        case INT_LITERAL:
            return new IntLiteral(value.toCharArray(), 0, 0);
        case CHAR_LITERAL:
            return new CharLiteral(value.toCharArray(), 0, 0);
        case LONG_LITERAL:
            return new LongLiteral(appendLiteralSuffix(LiteralType.LONG_LITERAL, value), 0, 0);
        }

        return null;
    }

    private char[] appendLiteralSuffix(LiteralType type, String value) {
        if (value.length() == 0) {
            return value.toCharArray();
        }
        switch (type) {
        case DOUBLE_LITERAL: {
            if (!(value.substring(value.length() - 1).compareToIgnoreCase(DOUBLE_SUFFIX) == 0)) {
                return (value + DOUBLE_SUFFIX).toCharArray();
            }
        }
            //$FALL-THROUGH$
        case FLOAT_LITERAL: {
            if (!(value.substring(value.length() - 1).compareToIgnoreCase(FLOAT_SUFFIX) == 0)) {
                return (value + FLOAT_SUFFIX).toCharArray();
            }
        }
            //$FALL-THROUGH$
        case LONG_LITERAL: {
            if (!(value.substring(value.length() - 1).compareToIgnoreCase(LONG_SUFFIX) == 0)) {
                return (value + LONG_SUFFIX).toCharArray();
            }
        }
            //$FALL-THROUGH$
        default: {
            return value.toCharArray();
        }

        }
    }

    public MessageSend createMessageSend(String name, Expression receiver,
            List<? extends Expression> arguments) throws JavaModelException {

        MessageSend msgSend = new MessageSend();
        msgSend.selector = name.toCharArray();
        msgSend.receiver = receiver;

        if (arguments != null) {
            msgSend.arguments = arguments.toArray(new Expression[arguments.size()]);
        }

        return msgSend;
    }

    public MethodDeclaration createMethodDeclaration(String name, CompilationResult result,
            boolean isAbstract) throws JavaModelException {
        return this.createMethodDeclaration(name, result, ClassFileConstants.AccPublic, isAbstract);
    }

    public MethodDeclaration createMethodDeclaration(String name, CompilationResult result,
            int modifier) throws JavaModelException {
        return this.createMethodDeclaration(name, result, modifier, false);
    }

    public MethodDeclaration createMethodDeclaration(String name, CompilationResult result,
            int modifier, boolean isAbstract) throws JavaModelException {

        MethodDeclarationExtension method = new MethodDeclarationExtension(result);
        method.selector = name.toCharArray();
        method.returnType = new SingleTypeReference(new char[] { 'v', 'o', 'i', 'd' }, 0l);
        method.modifiers = modifier;

        if (isAbstract) {
            method.modifiers |= ClassFileConstants.AccAbstract;
            method.modifiers |= ExtraCompilerModifiers.AccSemicolonBody;
        }

        return method;
    }

    public QualifiedNameReference createQualifiedNameReference(String reference, String name)
            throws JavaModelException {
        char[][] tokens = new char[][] { reference.toCharArray(), name.toCharArray() };
        long[] positions = new long[] { 0l, 0l };
        return new QualifiedNameReference(tokens, positions, 0, 0);
    }

    public ReturnStatement createReturnStatement(Expression expression) throws JavaModelException {
        return new ReturnStatement(expression, 0, 0);
    }

    public SingleNameReference createSingleNameReference(String name) throws JavaModelException {
        return new SingleNameReference(name.toCharArray(), 0);
    }

    public TypeDeclaration createTypeDeclaration(String name, CompilationResult result)
            throws JavaModelException {

        TypeDeclaration type = new TypeDeclaration(result);
        type.name = name.toCharArray();
        return type;
    }

    public TypeReference createTypeReference(String name, boolean qualified)
            throws JavaModelException {

        if (name == null) {
            return null;
        }

        TypeReference reference;

        if (qualified) {

            String[] packages = name.split("\\.");
            char[][] sources = new char[packages.length][];

            for (int i = 0; i < packages.length; i++) {
                sources[i] = packages[i].toCharArray();
            }

            reference = new QualifiedTypeReference(sources, new long[packages.length]);
        } else {
            reference = new SingleTypeReference(name.toCharArray(), 0l);
        }

        // Other TypeReferences

        return reference;
    }

    public TypeReference createParameterizedTypeReference(String name, boolean qualified,
            List<TypeReference> parameters) throws JavaModelException {

        if (name == null) {
            return null;
        }

        TypeReference reference;

        TypeReference[] typeArguments = parameters.toArray(new TypeReference[parameters.size()]);

        if (qualified) {

            throw new UnsupportedOperationException(
                    "ParameterizedQualifiedTypeReference is not supported yet.");

            // ParameterizedQualifiedTypeReference

            // String[] packages = name.split(".");
            // char[][] sources = new char[packages.length][];
            //
            // for (int i = 0; i < packages.length; i++) {
            // sources[i] = packages[i].toCharArray();
            // }
            //
            // reference = new ParameterizedQualifiedTypeReference(sources, typeArguments, 0,
            // new long[packages.length]);

        }
        reference = new ParameterizedSingleTypeReference(name.toCharArray(), typeArguments, 0, 0l);

        // Other TypeReferences

        return reference;
    }

    public UnaryExpression createUnaryExpression(Expression expression, Integer operator)
            throws JavaModelException {
        return new UnaryExpression(expression, operator);
    }

    public ImportReference createImportReference(String importName) throws JavaModelException {

        List<char[]> pkgTokenList = new ArrayList<char[]>();

        if (importName.contains(".")) {
            String[] pkgToken = importName.split("\\.");
            for (int i = 0; i < pkgToken.length; i++) {
                pkgTokenList.add(pkgToken[i].toCharArray());
            }
        } else {
            pkgTokenList.add(importName.toCharArray());
        }

        char[][] importReference = pkgTokenList.toArray(new char[pkgTokenList.size()][]);
        return new ImportReference(importReference, new long[] { 0, 0 }, false, 0);
    }

    public Annotation createAnnotation(String name, String value) throws JavaModelException {

        if (value == null || value.equals("")) {
            MarkerAnnotation annotation = new MarkerAnnotation(createTypeReference(name, false), 0);
            return annotation;
        }

        SingleMemberAnnotation annotation = new SingleMemberAnnotation(createTypeReference(name,
                false), 0);
        annotation.memberValue = new StringLiteral(value.toCharArray(), 0, 0, 0);
        return annotation;

    }

    public Javadoc createJavadoc(String comment, List<JavadocParameter> parameterList)
            throws JavaModelException {

        comment = (comment == null) ? "" : comment.replace("\n", "");

        JavadocExtension javadoc = new JavadocExtension(0, 0);
        javadoc.token = comment.toCharArray();

        if (parameterList != null) {
            javadoc.parameter = parameterList.toArray(new JavadocParameter[parameterList.size()]);
        }

        return javadoc;
    }

    public JavadocParameter createJavadocParameter(String key, String value)
            throws JavaModelException {
        return new JavadocParameter(key.toLowerCase().toCharArray(), value.toCharArray());
    }

    public JavadocSingleNameReference createJavadocSingleNameReference(String name)
            throws JavaModelException {
        return new JavadocSingleNameReference(name.toCharArray(), 0l, 0, 0);
    }

    public JavadocSingleTypeReference createJavadocSingleTypeReference(String name)
            throws JavaModelException {
        return new JavadocSingleTypeReference(name.toCharArray(), 0l, 0, 0);
    }

    /**
     * Creates a this reference <code>this.</code>.
     * 
     * @return the this reference
     * 
     * @throws JavaModelException
     */
    public ThisReference createThisReference() throws JavaModelException {
        return new ThisReference(0, 0);
    }

    /**
     * Creates a super reference <code>super.</code>.
     * 
     * @return the super reference
     * 
     * @throws JavaModelException
     */
    public SuperReference createSuperReference() throws JavaModelException {
        return new SuperReference(0, 0);
    }

    /**
     * Creates an allocation expression <code>new Type(Type args...)</code>.
     * 
     * @param type
     *            the constructor type
     * @param constructorArguments
     *            the arguments of the constructor
     * 
     * @return the allocation expression
     * 
     * @throws JavaModelException
     */
    public AllocationExpression createAllocationExpression(TypeReference type,
            List<? extends Expression> constructorArguments) {
        AllocationExpression expression = new AllocationExpression();
        expression.type = type;

        if (constructorArguments != null) {
            expression.arguments = constructorArguments.toArray(new Expression[constructorArguments
                    .size()]);
        }

        return expression;
    }

    /**
     * Creates a class literal access <code>name.class</code>.
     * 
     * @param name
     *            name of the reference
     * 
     * @return the class literal access
     * 
     * @throws JavaModelException
     */
    public ClassLiteralAccess createClassLiteralAccess(String name) throws JavaModelException {
        return new ClassLiteralAccess(0, createTypeReference(name, false));
    }

    /**
     * Creates a class literal access <code>typeReference.class</code>.
     * 
     * @param name
     *            the type reference
     * 
     * @return the class literal access
     * 
     * @throws JavaModelException
     */
    public ClassLiteralAccess createClassLiteralAccess(TypeReference typeReference)
            throws JavaModelException {
        return new ClassLiteralAccess(0, typeReference);
    }

    /**
     * Creates a local declaration (e.g. String name; ).
     * 
     * @param type
     *            type of the declaration
     * @param name
     *            name of the declaration
     * 
     * @return the local declaration
     * 
     * @throws JavaModelException
     */
    public LocalDeclaration createLocalDeclaration(TypeReference type, String name)
            throws JavaModelException {
        LocalDeclaration localDeclaration = new LocalDeclaration(name.toCharArray(), 0, 0);
        localDeclaration.type = type;
        return localDeclaration;
    }

    /**
     * Creates a cast expression (e.g. Integer i = (Integer) number).
     * 
     * @return the cast expression
     * 
     * @throws JavaModelException
     */
    public CastExpression createCastExpression(Expression expression, TypeReference type)
            throws JavaModelException {
        CastExpression cast = new CastExpressionExtension(expression, type);
        return cast;
    }

    /**
     * Creates a <?> type reference.
     * 
     * @return the wildcard
     */
    public Wildcard createWildcard() {
        return new Wildcard(Wildcard.UNBOUND);
    }

    /**
     * Creates a <?> type reference.
     * 
     * @param type
     *            the extended type
     * 
     * @return the wildcard
     */
    public Wildcard createWildcard(TypeReference type) {
        Wildcard wildcard = new Wildcard(Wildcard.EXTENDS);
        wildcard.bound = type;
        return wildcard;
    }
}
