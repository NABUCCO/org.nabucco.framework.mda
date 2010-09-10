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
package org.nabucco.framework.mda.template.java.extract.statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.AnnotationMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.AssertStatement;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.BreakStatement;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.CharLiteral;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.Clinit;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ContinueStatement;
import org.eclipse.jdt.internal.compiler.ast.DoStatement;
import org.eclipse.jdt.internal.compiler.ast.DoubleLiteral;
import org.eclipse.jdt.internal.compiler.ast.EmptyStatement;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ExtendedStringLiteral;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.FloatLiteral;
import org.eclipse.jdt.internal.compiler.ast.ForStatement;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.ast.Javadoc;
import org.eclipse.jdt.internal.compiler.ast.JavadocAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.JavadocArgumentExpression;
import org.eclipse.jdt.internal.compiler.ast.JavadocArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.JavadocArraySingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.JavadocFieldReference;
import org.eclipse.jdt.internal.compiler.ast.JavadocImplicitTypeReference;
import org.eclipse.jdt.internal.compiler.ast.JavadocMessageSend;
import org.eclipse.jdt.internal.compiler.ast.JavadocQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.JavadocReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.JavadocSingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.JavadocSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.LabeledStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.LongLiteral;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.NormalAnnotation;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.OR_OR_Expression;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.PostfixExpression;
import org.eclipse.jdt.internal.compiler.ast.PrefixExpression;
import org.eclipse.jdt.internal.compiler.ast.QualifiedAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedSuperReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedThisReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.StringLiteralConcatenation;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.UnaryExpression;
import org.eclipse.jdt.internal.compiler.ast.WhileStatement;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.nabucco.framework.mda.model.java.JavaModelException;
import org.nabucco.framework.mda.model.java.ast.extension.expression.CastExpressionExtension;
import org.nabucco.framework.mda.model.java.ast.visitor.JavaAstVisitor;
import org.nabucco.framework.mda.template.java.JavaTemplateException;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;

/**
 * JavaAstStatementExtractorVisitor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstStatementExtractorVisitor extends JavaAstVisitor {

    private Statement statement;

    @Override
    public boolean visit(AllocationExpression allocationExpression, BlockScope scope) {

        AllocationExpression allocationCopy = new AllocationExpression();
        allocationCopy.type = copy(allocationExpression.type);
        allocationCopy.arguments = copy(allocationExpression.arguments, scope);
        allocationCopy.typeArguments = copy(allocationExpression.typeArguments, scope);
        this.statement = allocationCopy;

        return false;
    }

    @Override
    public boolean visit(AND_AND_Expression andAndExpression, BlockScope scope) {

        Expression left = copy(andAndExpression.left, scope);
        Expression right = copy(andAndExpression.right, scope);

        AND_AND_Expression andCopy = new AND_AND_Expression(left, right, 0);
        andCopy.bits = andAndExpression.bits;

        this.statement = andCopy;

        return false;
    }

    @Override
    public boolean visit(Argument argument, BlockScope scope) {

        TypeReference typeReference = copy(argument.type);

        Argument argumentCopy = new Argument(argument.name.clone(), argument.sourceEnd,
                typeReference, argument.modifiers);

        argumentCopy.initialization = copy(argument.initialization, scope);
        argumentCopy.annotations = copy(argument.annotations, scope);

        this.statement = argumentCopy;

        return false;
    }

    @Override
    public boolean visit(Argument argument, ClassScope scope) {
        throw new UnsupportedOperationException("Argument is not supported for ClassScope.");
    }

    @Override
    public boolean visit(ArrayAllocationExpression arrayAllocationExpression, BlockScope scope) {

        ArrayAllocationExpression arrayCopy = new ArrayAllocationExpression();
        arrayCopy.dimensions = copy(arrayAllocationExpression.dimensions, scope);
        arrayCopy.initializer = copy(arrayAllocationExpression.initializer, scope);
        arrayCopy.type = copy(arrayAllocationExpression.type);
        this.statement = arrayCopy;

        return false;
    }

    @Override
    public boolean visit(ArrayInitializer arrayInitializer, BlockScope scope) {

        ArrayInitializer arrayCopy = new ArrayInitializer();
        arrayCopy.expressions = copy(arrayInitializer.expressions, scope);
        this.statement = arrayCopy;

        return false;
    }

    @Override
    public boolean visit(ArrayReference arrayReference, BlockScope scope) {

        Expression receiver = copy(arrayReference.receiver, scope);
        Expression position = copy(arrayReference.position, scope);

        ArrayReference arrayCopy = new ArrayReference(receiver, position);
        this.statement = arrayCopy;

        return false;
    }

    @Override
    public boolean visit(AssertStatement assertStatement, BlockScope scope) {

        Expression assertExpression = copy(assertStatement.assertExpression, scope);

        AssertStatement assertCopy = new AssertStatement(assertExpression,
                assertStatement.sourceStart);

        assertCopy.exceptionArgument = copy(assertStatement.exceptionArgument, scope);

        this.statement = assertCopy;

        return false;
    }

    @Override
    public boolean visit(Assignment assignment, BlockScope scope) {

        Expression expression = copy(assignment.expression, scope);
        Expression lhs = copy(assignment.lhs, scope);

        Assignment assignmentCopy = new Assignment(lhs, expression, assignment.sourceEnd);
        this.statement = assignmentCopy;

        return false;
    }

    @Override
    public boolean visit(BinaryExpression binaryExpression, BlockScope scope) {

        Expression left = copy(binaryExpression.left, scope);
        Expression right = copy(binaryExpression.right, scope);

        BinaryExpression binaryCopy = new BinaryExpression(left, right, 0);
        binaryCopy.bits = binaryExpression.bits;

        this.statement = binaryCopy;

        return false;
    }

    @Override
    public boolean visit(Block block, BlockScope scope) {

        Block blockCopy = new Block(block.explicitDeclarations);
        blockCopy.statements = copy(blockCopy.statements, scope);

        blockCopy.statements = copy(block.statements, scope);

        this.statement = blockCopy;

        return false;
    }

    @Override
    public boolean visit(BreakStatement breakStatement, BlockScope scope) {

        BreakStatement breakCopy = new BreakStatement(breakStatement.label.clone(),
                breakStatement.sourceStart, breakStatement.sourceEnd);

        this.statement = breakCopy;

        return false;
    }

    @Override
    public boolean visit(CaseStatement caseStatement, BlockScope scope) {

        Expression constantExpression = copy(caseStatement.constantExpression, scope);

        CaseStatement caseCopy = new CaseStatement(constantExpression, caseStatement.sourceEnd,
                caseStatement.sourceStart);

        this.statement = caseCopy;

        return false;
    }

    @Override
    public boolean visit(CastExpression castExpression, BlockScope scope) {

        Expression expression = copy(castExpression.expression, scope);
        Expression type = copy(castExpression.type, scope);

        CastExpression castCopy = new CastExpressionExtension(expression, type);
        this.statement = castCopy;

        return false;
    }

    @Override
    public boolean visit(CharLiteral charLiteral, BlockScope scope) {

        CharLiteral literalCopy = new CharLiteral(charLiteral.source().clone(),
                charLiteral.sourceStart, charLiteral.sourceEnd);

        this.statement = literalCopy;

        return false;
    }

    @Override
    public boolean visit(ClassLiteralAccess classLiteral, BlockScope scope) {

        TypeReference typeReference = copy(classLiteral.type);

        ClassLiteralAccess literalCopy = new ClassLiteralAccess(classLiteral.sourceEnd,
                typeReference);

        this.statement = literalCopy;

        return false;
    }

    @Override
    public boolean visit(CompoundAssignment compoundAssignment, BlockScope scope) {

        Expression lhs = copy(compoundAssignment.lhs, scope);
        Expression expression = copy(compoundAssignment.expression, scope);

        CompoundAssignment compoundCopy = new CompoundAssignment(lhs, expression, 0,
                compoundAssignment.sourceEnd);

        this.statement = compoundCopy;

        return false;
    }

    @Override
    public boolean visit(ConditionalExpression conditionalExpression, BlockScope scope) {

        Expression condition = copy(conditionalExpression.condition, scope);
        Expression valueIfTrue = copy(conditionalExpression.valueIfTrue, scope);
        Expression valueIfFalse = copy(conditionalExpression.valueIfFalse, scope);

        ConditionalExpression conditionalCopy = new ConditionalExpression(condition, valueIfTrue,
                valueIfFalse);

        this.statement = conditionalCopy;

        return false;
    }

    @Override
    public boolean visit(ContinueStatement continueStatement, BlockScope scope) {

        ContinueStatement continueCopy = new ContinueStatement(continueStatement.label.clone(),
                continueStatement.sourceStart, continueStatement.sourceEnd);

        continueCopy.subroutines = copy(continueStatement.subroutines, scope);
        this.statement = continueCopy;

        return false;
    }

    @Override
    public boolean visit(DoStatement doStatement, BlockScope scope) {

        Expression condition = copy(doStatement.condition, scope);
        Statement action = copy(doStatement.action, scope);

        DoStatement statementCopy = new DoStatement(condition, action, doStatement.sourceStart,
                doStatement.sourceEnd);

        this.statement = statementCopy;

        return false;
    }

    @Override
    public boolean visit(DoubleLiteral doubleLiteral, BlockScope scope) {

        DoubleLiteral doubleCopy = new DoubleLiteral(doubleLiteral.source().clone(),
                doubleLiteral.sourceStart, doubleLiteral.sourceEnd);

        this.statement = doubleCopy;

        return false;
    }

    @Override
    public boolean visit(EmptyStatement emptyStatement, BlockScope scope) {

        EmptyStatement emptyCopy = new EmptyStatement(emptyStatement.sourceStart,
                emptyStatement.sourceEnd);

        this.statement = emptyCopy;

        return false;
    }

    @Override
    public boolean visit(EqualExpression equalExpression, BlockScope scope) {

        Expression left = copy(equalExpression.left, scope);
        Expression right = copy(equalExpression.right, scope);

        EqualExpression equalCopy = new EqualExpression(left, right, 0);
        equalCopy.bits = equalExpression.bits;
        this.statement = equalCopy;

        return false;
    }

    @Override
    public boolean visit(ExplicitConstructorCall explicitConstructor, BlockScope scope) {

        ExplicitConstructorCall callCopy = new ExplicitConstructorCall(
                explicitConstructor.accessMode);

        callCopy.arguments = copy(explicitConstructor.arguments, scope);
        callCopy.qualification = copy(explicitConstructor.qualification, scope);
        callCopy.typeArguments = copy(explicitConstructor.typeArguments);
        this.statement = callCopy;

        return false;
    }

    @Override
    public boolean visit(FalseLiteral falseLiteral, BlockScope scope) {

        FalseLiteral falseCopy = new FalseLiteral(falseLiteral.sourceStart, falseLiteral.sourceEnd);
        this.statement = falseCopy;

        return false;
    }

    @Override
    public boolean visit(FieldReference fieldReference, ClassScope scope) {
        throw new UnsupportedOperationException("FieldReference is not supported for ClassScope.");
    }

    @Override
    public boolean visit(FieldReference fieldReference, BlockScope scope) {

        FieldReference fieldCopy = new FieldReference(fieldReference.token.clone(), 0);
        fieldCopy.receiver = copy(fieldReference.receiver, scope);

        this.statement = fieldCopy;

        return false;
    }

    @Override
    public boolean visit(FloatLiteral floatLiteral, BlockScope scope) {

        FloatLiteral floatCopy = new FloatLiteral(floatLiteral.source().clone(),
                floatLiteral.sourceStart, floatLiteral.sourceEnd);

        this.statement = floatCopy;

        return false;
    }

    @Override
    public boolean visit(ForeachStatement forStatement, BlockScope scope) {

        LocalDeclaration elementVariable = copy(forStatement.elementVariable, scope);

        ForeachStatement foreachCopy = new ForeachStatement(elementVariable,
                forStatement.sourceStart);

        foreachCopy.action = copy(forStatement.action, scope);

        this.statement = foreachCopy;

        return false;
    }

    @Override
    public boolean visit(ForStatement forStatement, BlockScope scope) {

        Expression condition = copy(forStatement.condition, scope);
        Statement action = copy(forStatement.action, scope);
        Statement[] initializations = copy(forStatement.initializations, scope);
        Statement[] increments = copy(forStatement.increments, scope);

        ForStatement forCopy = new ForStatement(initializations, condition, increments, action,
                false, forStatement.sourceStart, forStatement.sourceEnd);

        this.statement = forCopy;

        return false;
    }

    @Override
    public boolean visit(IfStatement ifStatement, BlockScope scope) {

        Expression condition = copy(ifStatement.condition, scope);
        Statement thenStatement = copy(ifStatement.thenStatement, scope);
        Statement elseStatement = copy(ifStatement.elseStatement, scope);

        IfStatement ifCopy = elseStatement == null ? new IfStatement(condition, thenStatement,
                ifStatement.sourceStart, ifStatement.sourceEnd) : new IfStatement(condition,
                thenStatement, elseStatement, ifStatement.sourceStart, ifStatement.sourceEnd);

        this.statement = ifCopy;

        return false;
    }

    @Override
    public boolean visit(Initializer initializer, MethodScope scope) {

        Block block = copy(initializer.block, scope);

        Initializer initializerCopy = new Initializer(block, initializer.modifiers);
        initializerCopy.type = copy(initializer.type);

        this.statement = initializer;

        return false;
    }

    @Override
    public boolean visit(InstanceOfExpression instanceOfExpression, BlockScope scope) {

        Expression expression = copy(instanceOfExpression.expression, scope);
        TypeReference typeReference = copy(instanceOfExpression.type);

        InstanceOfExpression instanceofCopy = new InstanceOfExpression(expression, typeReference);
        this.statement = instanceofCopy;

        return false;
    }

    @Override
    public boolean visit(IntLiteral intLiteral, BlockScope scope) {
        IntLiteral intCopy = new IntLiteral(intLiteral.value);
        this.statement = intCopy;

        return false;
    }

    @Override
    public boolean visit(LabeledStatement labeledStatement, BlockScope scope) {
        throw new UnsupportedOperationException("LabeledStatement is not supported.");
    }

    @Override
    public boolean visit(LocalDeclaration localDeclaration, BlockScope scope) {

        LocalDeclaration localCopy = new LocalDeclaration(localDeclaration.name.clone(),
                localDeclaration.sourceStart, localDeclaration.sourceEnd);

        localCopy.annotations = copy(localDeclaration.annotations, scope);
        localCopy.initialization = copy(localDeclaration.initialization, scope);
        localCopy.modifiers = localDeclaration.modifiers;
        localCopy.type = copy(localDeclaration.type);

        this.statement = localCopy;

        return false;
    }

    @Override
    public boolean visit(LongLiteral longLiteral, BlockScope scope) {

        LongLiteral longCopy = new LongLiteral(longLiteral.source().clone(),
                longLiteral.sourceStart, longLiteral.sourceEnd);

        this.statement = longCopy;

        return false;
    }

    @Override
    public boolean visit(MarkerAnnotation annotation, BlockScope scope) {

        TypeReference typeReference = copy(annotation.type);

        MarkerAnnotation annotationCopy = new MarkerAnnotation(typeReference,
                annotation.sourceStart);

        annotationCopy.sourceEnd = annotation.sourceEnd;
        this.statement = annotationCopy;

        return false;
    }

    @Override
    public boolean visit(MessageSend messageSend, BlockScope scope) {

        MessageSend msgCopy = new MessageSend();
        msgCopy.selector = messageSend.selector.clone();
        msgCopy.receiver = copy(messageSend.receiver, scope);
        msgCopy.arguments = copy(messageSend.arguments, scope);
        this.statement = msgCopy;

        return false;
    }

    @Override
    public boolean visit(NormalAnnotation annotation, BlockScope scope) {

        TypeReference typeReference = copy(annotation.type);

        NormalAnnotation annotationCopy = new NormalAnnotation(typeReference,
                annotation.sourceStart);

        annotationCopy.sourceEnd = annotation.sourceEnd;

        try {
            List<MemberValuePair> extractedMemberValuePairs = JavaAstExtractorFactory.getInstance()
                    .getMemberValuePairExtractor().extractMemberValuePairs(annotation, scope);

            annotationCopy.memberValuePairs = extractedMemberValuePairs
                    .toArray(new MemberValuePair[extractedMemberValuePairs.size()]);
        } catch (JavaTemplateException e) {
            this.getVisitorContext().addException(e);
        }

        this.statement = annotationCopy;

        return false;
    }

    @Override
    public boolean visit(NullLiteral nullLiteral, BlockScope scope) {

        NullLiteral nullCopy = new NullLiteral(nullLiteral.sourceStart, nullLiteral.sourceEnd);
        this.statement = nullCopy;

        return false;
    }

    @Override
    public boolean visit(OR_OR_Expression orOrExpression, BlockScope scope) {

        Expression left = copy(orOrExpression.left, scope);
        Expression right = copy(orOrExpression.right, scope);

        OR_OR_Expression orCopy = new OR_OR_Expression(left, right, 0);
        orCopy.bits = orOrExpression.bits;

        this.statement = orCopy;

        return false;
    }

    @Override
    public boolean visit(PostfixExpression postfixExpression, BlockScope scope) {

        Expression lhs = copy(postfixExpression.lhs, scope);
        Expression expression = copy(postfixExpression.expression, scope);

        PostfixExpression postfixCopy = new PostfixExpression(lhs, expression,
                postfixExpression.operator, postfixExpression.sourceEnd);

        this.statement = postfixCopy;

        return false;
    }

    @Override
    public boolean visit(PrefixExpression prefixExpression, BlockScope scope) {

        Expression lhs = copy(prefixExpression.lhs, scope);
        Expression expression = copy(prefixExpression.expression, scope);

        PrefixExpression prefixCopy = new PrefixExpression(lhs, expression,
                prefixExpression.operator, prefixExpression.sourceStart);

        this.statement = prefixCopy;

        return false;
    }

    @Override
    public boolean visit(QualifiedAllocationExpression qualifiedAllocationExpression,
            BlockScope scope) {

        // TODO: Anonymous classes.
        this.getVisitorContext().addException(
                new JavaModelException("Anonymous classes are not supported."));

        QualifiedAllocationExpression allocationCopy = new QualifiedAllocationExpression();
        allocationCopy.enclosingInstance = copy(qualifiedAllocationExpression.enclosingInstance,
                scope);
        allocationCopy.arguments = copy(qualifiedAllocationExpression.arguments, scope);

        this.statement = allocationCopy;

        return false;
    }

    @Override
    public boolean visit(QualifiedNameReference qualifiedNameReference, BlockScope scope) {

        QualifiedNameReference nameCopy = new QualifiedNameReference(
                qualifiedNameReference.tokens.clone(),
                qualifiedNameReference.sourcePositions.clone(), qualifiedNameReference.sourceStart,
                qualifiedNameReference.sourceEnd);

        this.statement = nameCopy;

        return false;
    }

    @Override
    public boolean visit(QualifiedNameReference qualifiedNameReference, ClassScope scope) {

        QualifiedNameReference nameCopy = new QualifiedNameReference(
                qualifiedNameReference.tokens.clone(),
                qualifiedNameReference.sourcePositions.clone(), qualifiedNameReference.sourceStart,
                qualifiedNameReference.sourceEnd);

        this.statement = nameCopy;

        return false;
    }

    @Override
    public boolean visit(QualifiedSuperReference qualifiedSuperReference, BlockScope scope) {

        TypeReference qualification = copy(qualifiedSuperReference.qualification);

        QualifiedSuperReference superCopy = new QualifiedSuperReference(qualification,
                qualifiedSuperReference.sourceStart, qualifiedSuperReference.sourceEnd);

        this.statement = superCopy;

        return false;
    }

    @Override
    public boolean visit(QualifiedSuperReference qualifiedSuperReference, ClassScope scope) {

        TypeReference qualification = copy(qualifiedSuperReference.qualification);

        QualifiedSuperReference superCopy = new QualifiedSuperReference(qualification,
                qualifiedSuperReference.sourceStart, qualifiedSuperReference.sourceEnd);

        this.statement = superCopy;

        return false;
    }

    @Override
    public boolean visit(QualifiedThisReference qualifiedThisReference, BlockScope scope) {

        TypeReference qualification = copy(qualifiedThisReference.qualification);

        QualifiedThisReference thisCopy = new QualifiedThisReference(qualification,
                qualifiedThisReference.sourceStart, qualifiedThisReference.sourceEnd);

        this.statement = thisCopy;

        return false;
    }

    @Override
    public boolean visit(QualifiedThisReference qualifiedThisReference, ClassScope scope) {

        TypeReference qualification = copy(qualifiedThisReference.qualification);

        QualifiedThisReference thisCopy = new QualifiedThisReference(qualification,
                qualifiedThisReference.sourceStart, qualifiedThisReference.sourceEnd);

        this.statement = thisCopy;

        return false;
    }

    @Override
    public boolean visit(ReturnStatement returnStatement, BlockScope scope) {

        Expression expression = copy(returnStatement.expression, scope);

        ReturnStatement statementCopy = new ReturnStatement(expression,
                returnStatement.sourceStart(), returnStatement.sourceEnd());

        statementCopy.subroutines = copy(returnStatement.subroutines, scope);

        this.statement = statementCopy;

        return false;
    }

    @Override
    public boolean visit(SingleMemberAnnotation annotation, BlockScope scope) {

        TypeReference typeReference = copy(annotation.type);

        SingleMemberAnnotation annotationCopy = new SingleMemberAnnotation(typeReference,
                annotation.sourceStart);

        annotationCopy.sourceEnd = annotation.sourceEnd;
        annotationCopy.memberValue = copy(annotation.memberValue, scope);

        this.statement = annotationCopy;

        return false;
    }

    @Override
    public boolean visit(SingleNameReference singleNameReference, BlockScope scope) {

        SingleNameReference referenceCopy = new SingleNameReference(
                singleNameReference.token.clone(), singleNameReference.sourceEnd);

        this.statement = referenceCopy;

        return false;
    }

    @Override
    public boolean visit(SingleNameReference singleNameReference, ClassScope scope) {

        SingleNameReference referenceCopy = new SingleNameReference(
                singleNameReference.token.clone(), singleNameReference.sourceEnd);

        this.statement = referenceCopy;

        return false;
    }

    @Override
    public boolean visit(StringLiteral stringLiteral, BlockScope scope) {

        StringLiteral stringCopy = new StringLiteral(stringLiteral.source().clone(),
                stringLiteral.sourceStart, stringLiteral.sourceEnd, 0);

        this.statement = stringCopy;

        return false;
    }

    @Override
    public boolean visit(StringLiteralConcatenation literal, BlockScope scope) {

        if (literal.literals.length < 2) {
            return false;
        }

        StringLiteral stringA = (StringLiteral) copy(literal.literals[0], scope);
        StringLiteral stringB = (StringLiteral) copy(literal.literals[1], scope);

        StringLiteralConcatenation stringCopy = new StringLiteralConcatenation(stringA, stringB);
        this.statement = stringCopy;

        return false;
    }

    @Override
    public boolean visit(SuperReference superReference, BlockScope scope) {

        SuperReference superCopy = new SuperReference(superReference.sourceStart,
                superReference.sourceEnd);

        this.statement = superCopy;

        return false;
    }

    @Override
    public boolean visit(SwitchStatement switchStatement, BlockScope scope) {

        SwitchStatement switchCopy = new SwitchStatement();
        switchCopy.expression = copy(switchStatement.expression, scope);
        switchCopy.cases = copy(switchStatement.cases, scope);
        switchCopy.statements = copy(switchStatement.statements, scope);

        return false;
    }

    @Override
    public boolean visit(SynchronizedStatement synchronizedStatement, BlockScope scope) {

        Block block = copy(synchronizedStatement.block, scope);
        Expression expression = copy(synchronizedStatement.expression, scope);

        SynchronizedStatement synchronizedCopy = new SynchronizedStatement(expression, block,
                synchronizedStatement.sourceStart, synchronizedStatement.sourceEnd);

        this.statement = synchronizedCopy;

        return false;
    }

    @Override
    public boolean visit(ThisReference thisReference, BlockScope scope) {

        ThisReference thisCopy = new ThisReference(thisReference.sourceStart,
                thisReference.sourceEnd);

        this.statement = thisCopy;

        return false;
    }

    @Override
    public boolean visit(ThisReference thisReference, ClassScope scope) {

        ThisReference thisCopy = new ThisReference(thisReference.sourceStart,
                thisReference.sourceEnd);

        this.statement = thisCopy;

        return false;
    }

    @Override
    public boolean visit(ThrowStatement throwStatement, BlockScope scope) {

        Expression exception = copy(throwStatement.exception, scope);

        ThrowStatement throwCopy = new ThrowStatement(exception, throwStatement.sourceStart,
                throwStatement.sourceEnd);

        this.statement = throwCopy;

        return false;
    }

    @Override
    public boolean visit(TrueLiteral trueLiteral, BlockScope scope) {

        TrueLiteral trueCopy = new TrueLiteral(trueLiteral.sourceStart, trueLiteral.sourceEnd);
        this.statement = trueCopy;

        return false;
    }

    @Override
    public boolean visit(TryStatement tryStatement, BlockScope scope) {

        TryStatement tryCopy = new TryStatement();
        tryCopy.tryBlock = copy(tryStatement.tryBlock, scope);
        tryCopy.finallyBlock = copy(tryStatement.finallyBlock, scope);
        tryCopy.catchArguments = copy(tryStatement.catchArguments, scope);
        tryCopy.catchBlocks = copy(tryStatement.catchBlocks, scope);

        this.statement = tryCopy;

        return false;
    }

    @Override
    public boolean visit(UnaryExpression unaryExpression, BlockScope scope) {

        Expression expression = copy(unaryExpression.expression, scope);

        UnaryExpression unaryCopy = new UnaryExpression(expression, 0);
        unaryCopy.bits = unaryExpression.bits;

        this.statement = unaryCopy;

        return false;
    }

    @Override
    public boolean visit(WhileStatement whileStatement, BlockScope scope) {

        Expression condition = copy(whileStatement.condition, scope);
        Statement action = copy(whileStatement.action, scope);

        WhileStatement statementCopy = new WhileStatement(condition, action,
                whileStatement.sourceStart, whileStatement.sourceEnd);

        this.statement = statementCopy;

        return false;
    }

    // Not yet implemented visitor methods.
    // ///////////////////////////////////////////////////////////////////////////

    @Override
    public boolean visit(ExtendedStringLiteral extendedStringLiteral, BlockScope scope) {
        return super.visit(extendedStringLiteral, scope);
    }

    @Override
    public boolean visit(TypeParameter typeParameter, BlockScope scope) {
        return super.visit(typeParameter, scope);
    }

    @Override
    public boolean visit(TypeParameter typeParameter, ClassScope scope) {
        return super.visit(typeParameter, scope);
    }

    // Not considered (explicit) visit methods.
    // ///////////////////////////////////////////////////////////////////////

    @Override
    public boolean visit(Clinit clinit, ClassScope scope) {
        return super.visit(clinit, scope);
    }

    @Override
    public boolean visit(CompilationUnitDeclaration compilationUnitDeclaration,
            CompilationUnitScope scope) {
        return super.visit(compilationUnitDeclaration, scope);
    }

    @Override
    public boolean visit(ImportReference importRef, CompilationUnitScope scope) {
        return super.visit(importRef, scope);
    }

    @Override
    public boolean visit(MemberValuePair pair, BlockScope scope) {
        return super.visit(pair, scope);
    }

    @Override
    public boolean visit(TypeDeclaration localTypeDeclaration, BlockScope scope) {
        return super.visit(localTypeDeclaration, scope);
    }

    @Override
    public boolean visit(TypeDeclaration memberTypeDeclaration, ClassScope scope) {
        return super.visit(memberTypeDeclaration, scope);
    }

    @Override
    public boolean visit(TypeDeclaration typeDeclaration, CompilationUnitScope scope) {
        return super.visit(typeDeclaration, scope);
    }

    @Override
    public boolean visit(MethodDeclaration methodDeclaration, ClassScope scope) {
        return super.visit(methodDeclaration, scope);
    }

    @Override
    public boolean visit(FieldDeclaration fieldDeclaration, MethodScope scope) {
        return super.visit(fieldDeclaration, scope);
    }

    @Override
    public boolean visit(ParameterizedQualifiedTypeReference parameterizedQualifiedTypeReference,
            BlockScope scope) {
        return super.visit(parameterizedQualifiedTypeReference, scope);
    }

    @Override
    public boolean visit(ParameterizedQualifiedTypeReference parameterizedQualifiedTypeReference,
            ClassScope scope) {
        return super.visit(parameterizedQualifiedTypeReference, scope);
    }

    @Override
    public boolean visit(ParameterizedSingleTypeReference parameterizedSingleTypeReference,
            BlockScope scope) {
        return super.visit(parameterizedSingleTypeReference, scope);
    }

    @Override
    public boolean visit(ParameterizedSingleTypeReference parameterizedSingleTypeReference,
            ClassScope scope) {
        return super.visit(parameterizedSingleTypeReference, scope);
    }

    @Override
    public boolean visit(QualifiedTypeReference qualifiedTypeReference, BlockScope scope) {
        return super.visit(qualifiedTypeReference, scope);
    }

    @Override
    public boolean visit(QualifiedTypeReference qualifiedTypeReference, ClassScope scope) {
        return super.visit(qualifiedTypeReference, scope);
    }

    @Override
    public boolean visit(SingleTypeReference singleTypeReference, BlockScope scope) {
        return super.visit(singleTypeReference, scope);
    }

    @Override
    public boolean visit(SingleTypeReference singleTypeReference, ClassScope scope) {
        return super.visit(singleTypeReference, scope);
    }

    @Override
    public boolean visit(Wildcard wildcard, BlockScope scope) {
        return super.visit(wildcard, scope);
    }

    @Override
    public boolean visit(Wildcard wildcard, ClassScope scope) {
        return super.visit(wildcard, scope);
    }

    @Override
    public boolean visit(JavadocSingleTypeReference typeRef, BlockScope scope) {
        return super.visit(typeRef, scope);
    }

    @Override
    public boolean visit(JavadocSingleTypeReference typeRef, ClassScope scope) {
        return super.visit(typeRef, scope);
    }

    @Override
    public boolean visit(JavadocQualifiedTypeReference typeRef, BlockScope scope) {
        return super.visit(typeRef, scope);
    }

    @Override
    public boolean visit(JavadocQualifiedTypeReference typeRef, ClassScope scope) {
        return super.visit(typeRef, scope);
    }

    @Override
    public boolean visit(JavadocImplicitTypeReference implicitTypeReference, BlockScope scope) {
        return super.visit(implicitTypeReference, scope);
    }

    @Override
    public boolean visit(JavadocImplicitTypeReference implicitTypeReference, ClassScope scope) {
        return super.visit(implicitTypeReference, scope);
    }

    @Override
    public boolean visit(JavadocArrayQualifiedTypeReference typeRef, BlockScope scope) {
        return super.visit(typeRef, scope);
    }

    @Override
    public boolean visit(JavadocArrayQualifiedTypeReference typeRef, ClassScope scope) {
        return super.visit(typeRef, scope);
    }

    @Override
    public boolean visit(JavadocArraySingleTypeReference typeRef, BlockScope scope) {
        return super.visit(typeRef, scope);
    }

    @Override
    public boolean visit(JavadocArraySingleTypeReference typeRef, ClassScope scope) {
        return super.visit(typeRef, scope);
    }

    @Override
    public boolean visit(ArrayQualifiedTypeReference arrayQualifiedTypeReference, BlockScope scope) {
        return super.visit(arrayQualifiedTypeReference, scope);
    }

    @Override
    public boolean visit(ArrayQualifiedTypeReference arrayQualifiedTypeReference, ClassScope scope) {
        return super.visit(arrayQualifiedTypeReference, scope);
    }

    @Override
    public boolean visit(ArrayTypeReference arrayTypeReference, BlockScope scope) {
        return super.visit(arrayTypeReference, scope);
    }

    @Override
    public boolean visit(ArrayTypeReference arrayTypeReference, ClassScope scope) {
        return super.visit(arrayTypeReference, scope);
    }

    @Override
    public boolean visit(AnnotationMethodDeclaration annotationTypeDeclaration,
            ClassScope classScope) {
        return super.visit(annotationTypeDeclaration, classScope);
    }

    @Override
    public boolean visit(ConstructorDeclaration constructorDeclaration, ClassScope scope) {
        return super.visit(constructorDeclaration, scope);
    }

    @Override
    public boolean visit(Javadoc javadoc, BlockScope scope) {
        return super.visit(javadoc, scope);
    }

    @Override
    public boolean visit(Javadoc javadoc, ClassScope scope) {
        return super.visit(javadoc, scope);
    }

    @Override
    public boolean visit(JavadocAllocationExpression expression, BlockScope scope) {
        return super.visit(expression, scope);
    }

    @Override
    public boolean visit(JavadocAllocationExpression expression, ClassScope scope) {
        return super.visit(expression, scope);
    }

    @Override
    public boolean visit(JavadocArgumentExpression expression, BlockScope scope) {
        return super.visit(expression, scope);
    }

    @Override
    public boolean visit(JavadocArgumentExpression expression, ClassScope scope) {
        return super.visit(expression, scope);
    }

    @Override
    public boolean visit(JavadocFieldReference fieldRef, BlockScope scope) {
        return super.visit(fieldRef, scope);
    }

    @Override
    public boolean visit(JavadocFieldReference fieldRef, ClassScope scope) {
        return super.visit(fieldRef, scope);
    }

    @Override
    public boolean visit(JavadocMessageSend messageSend, BlockScope scope) {
        return super.visit(messageSend, scope);
    }

    @Override
    public boolean visit(JavadocMessageSend messageSend, ClassScope scope) {
        return super.visit(messageSend, scope);
    }

    @Override
    public boolean visit(JavadocReturnStatement statement, BlockScope scope) {
        return super.visit(statement, scope);
    }

    @Override
    public boolean visit(JavadocReturnStatement statement, ClassScope scope) {
        return super.visit(statement, scope);
    }

    @Override
    public boolean visit(JavadocSingleNameReference argument, BlockScope scope) {
        return super.visit(argument, scope);
    }

    @Override
    public boolean visit(JavadocSingleNameReference argument, ClassScope scope) {
        return super.visit(argument, scope);
    }

    @SuppressWarnings("unchecked")
    private <T extends Statement> T copy(T statement, BlockScope scope) {
        try {
            if (statement instanceof TypeReference) {
                return (T) copy((TypeReference) statement);
            }

            return JavaAstExtractorFactory.getInstance().getStatementExtractor()
                    .extractStatement(statement, scope);
        } catch (JavaTemplateException e) {
            this.getVisitorContext().addException(e);
        }
        return null;
    }

    private <T extends Statement> T[] copy(T[] statements, BlockScope scope) {

        if (statements == null) {
            return null;
        }

        List<T> statementList = new ArrayList<T>();

        for (T statement : statements) {
            T statementCopy = copy(statement, scope);
            statementList.add(statementCopy);
        }

        T[] statementCopies = Arrays.copyOf(statements, 0);
        statementCopies = statementList.toArray(statementCopies);

        return statementCopies;
    }

    private <T extends TypeReference> T copy(T typeReference) {
        try {
            return JavaAstExtractorFactory.getInstance().getTypeReferenceExtractor()
                    .extractTypeReference(typeReference);
        } catch (JavaTemplateException e) {
            this.getVisitorContext().addException(e);
        }
        return null;
    }

    private <T extends TypeReference> TypeReference[] copy(T[] typeReferences) {

        if (typeReferences == null) {
            return null;
        }

        List<TypeReference> typeReferenceList = new ArrayList<TypeReference>();

        for (T typeReference : typeReferences) {
            TypeReference typeReferenceCopy = copy(typeReference);
            typeReferenceList.add(typeReferenceCopy);
        }

        return typeReferenceList.toArray(new TypeReference[typeReferenceList.size()]);
    }

    public Statement getStatementCopy() {
        return this.statement;
    }
}
