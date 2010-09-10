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

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.visitor.MdaModelVisitorContext;

/**
 * Visits the UML Elements in deep manner (prerequisite). With this visitor there is no target model
 * generated.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public class UmlStructureVisitor<C extends MdaModelVisitorContext> extends UmlModelVisitor<C> {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            UmlStructureVisitor.class);

    /**
     * @param visitorContext
     */
    public UmlStructureVisitor(C visitorContext) {
        super(visitorContext);
    }

    // GENERATED CODE START.
    // //////////////////////////////////////////////////////////////////////////////////////////

    public void visit(org.eclipse.uml2.uml.Reception umlReception) throws UmlVisitorException {
        visit(umlReception.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Region umlRegion) throws UmlVisitorException {
        visit(umlRegion.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InteractionOperand umlInteractionOperand)
            throws UmlVisitorException {
        visit(umlInteractionOperand.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Profile umlProfile) throws UmlVisitorException {
        visit(umlProfile.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Deployment umlDeployment) throws UmlVisitorException {
        visit(umlDeployment.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.SendObjectAction umlSendObjectAction)
            throws UmlVisitorException {
        visit(umlSendObjectAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ExecutionEnvironment umlExecutionEnvironment)
            throws UmlVisitorException {
        visit(umlExecutionEnvironment.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.StateInvariant umlStateInvariant)
            throws UmlVisitorException {
        visit(umlStateInvariant.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Slot umlSlot) throws UmlVisitorException {
        visit(umlSlot.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ReadLinkAction umlReadLinkAction)
            throws UmlVisitorException {
        visit(umlReadLinkAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.GeneralOrdering umlGeneralOrdering)
            throws UmlVisitorException {
        visit(umlGeneralOrdering.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.FinalState umlFinalState) throws UmlVisitorException {
        visit(umlFinalState.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.ExecutionOccurrenceSpecification umlExecutionOccurrenceSpecification)
            throws UmlVisitorException {
        visit(umlExecutionOccurrenceSpecification.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LinkEndCreationData umlLinkEndCreationData)
            throws UmlVisitorException {
        visit(umlLinkEndCreationData.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Activity umlActivity) throws UmlVisitorException {
        visit(umlActivity.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DeploymentSpecification umlDeploymentSpecification)
            throws UmlVisitorException {
        visit(umlDeploymentSpecification.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CallEvent umlCallEvent) throws UmlVisitorException {
        visit(umlCallEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.BroadcastSignalAction umlBroadcastSignalAction)
            throws UmlVisitorException {
        visit(umlBroadcastSignalAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LiteralBoolean umlLiteralBoolean)
            throws UmlVisitorException {
        visit(umlLiteralBoolean.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.ActionExecutionSpecification umlActionExecutionSpecification)
            throws UmlVisitorException {
        visit(umlActionExecutionSpecification.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Comment umlComment) throws UmlVisitorException {
        visit(umlComment.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InstanceValue umlInstanceValue)
            throws UmlVisitorException {
        visit(umlInstanceValue.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.EnumerationLiteral umlEnumerationLiteral)
            throws UmlVisitorException {
        visit(umlEnumerationLiteral.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.MessageOccurrenceSpecification umlMessageOccurrenceSpecification)
            throws UmlVisitorException {
        visit(umlMessageOccurrenceSpecification.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InterfaceRealization umlInterfaceRealization)
            throws UmlVisitorException {
        visit(umlInterfaceRealization.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.InterruptibleActivityRegion umlInterruptibleActivityRegion)
            throws UmlVisitorException {
        visit(umlInterruptibleActivityRegion.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ExpansionRegion umlExpansionRegion)
            throws UmlVisitorException {
        visit(umlExpansionRegion.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.PackageImport umlPackageImport)
            throws UmlVisitorException {
        visit(umlPackageImport.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ConnectionPointReference umlConnectionPointReference)
            throws UmlVisitorException {
        visit(umlConnectionPointReference.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Port umlPort) throws UmlVisitorException {
        visit(umlPort.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DestroyLinkAction umlDestroyLinkAction)
            throws UmlVisitorException {
        visit(umlDestroyLinkAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ValueSpecificationAction umlValueSpecificationAction)
            throws UmlVisitorException {
        visit(umlValueSpecificationAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TemplateBinding umlTemplateBinding)
            throws UmlVisitorException {
        visit(umlTemplateBinding.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Collaboration umlCollaboration)
            throws UmlVisitorException {
        visit(umlCollaboration.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Stereotype umlStereotype) throws UmlVisitorException {
        visit(umlStereotype.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ActionInputPin umlActionInputPin)
            throws UmlVisitorException {
        visit(umlActionInputPin.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Artifact umlArtifact) throws UmlVisitorException {
        visit(umlArtifact.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LiteralInteger umlLiteralInteger)
            throws UmlVisitorException {
        visit(umlLiteralInteger.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ActivityFinalNode umlActivityFinalNode)
            throws UmlVisitorException {
        visit(umlActivityFinalNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Operation umlOperation) throws UmlVisitorException {
        visit(umlOperation.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Lifeline umlLifeline) throws UmlVisitorException {
        visit(umlLifeline.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.FlowFinalNode umlFlowFinalNode)
            throws UmlVisitorException {
        visit(umlFlowFinalNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DurationInterval umlDurationInterval)
            throws UmlVisitorException {
        visit(umlDurationInterval.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.UnmarshallAction umlUnmarshallAction)
            throws UmlVisitorException {
        visit(umlUnmarshallAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ProtocolConformance umlProtocolConformance)
            throws UmlVisitorException {
        visit(umlProtocolConformance.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.PartDecomposition umlPartDecomposition)
            throws UmlVisitorException {
        visit(umlPartDecomposition.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LoopNode umlLoopNode) throws UmlVisitorException {
        visit(umlLoopNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ActivityParameterNode umlActivityParameterNode)
            throws UmlVisitorException {
        visit(umlActivityParameterNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CommunicationPath umlCommunicationPath)
            throws UmlVisitorException {
        visit(umlCommunicationPath.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.StringExpression umlStringExpression)
            throws UmlVisitorException {
        visit(umlStringExpression.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Signal umlSignal) throws UmlVisitorException {
        visit(umlSignal.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.SendSignalAction umlSendSignalAction)
            throws UmlVisitorException {
        visit(umlSendSignalAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ParameterSet umlParameterSet) throws UmlVisitorException {
        visit(umlParameterSet.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.State umlState) throws UmlVisitorException {
        visit(umlState.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.AddStructuralFeatureValueAction umlAddStructuralFeatureValueAction)
            throws UmlVisitorException {
        visit(umlAddStructuralFeatureValueAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ForkNode umlForkNode) throws UmlVisitorException {
        visit(umlForkNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Model umlModel) throws UmlVisitorException {
        visit(umlModel.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DestroyObjectAction umlDestroyObjectAction)
            throws UmlVisitorException {
        visit(umlDestroyObjectAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ObjectFlow umlObjectFlow) throws UmlVisitorException {
        visit(umlObjectFlow.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.ReadStructuralFeatureAction umlReadStructuralFeatureAction)
            throws UmlVisitorException {
        visit(umlReadStructuralFeatureAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Interaction umlInteraction) throws UmlVisitorException {
        visit(umlInteraction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CreateLinkObjectAction umlCreateLinkObjectAction)
            throws UmlVisitorException {
        visit(umlCreateLinkObjectAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.SignalEvent umlSignalEvent) throws UmlVisitorException {
        visit(umlSignalEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ExecutionEvent umlExecutionEvent)
            throws UmlVisitorException {
        visit(umlExecutionEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Trigger umlTrigger) throws UmlVisitorException {
        visit(umlTrigger.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LinkEndDestructionData umlLinkEndDestructionData)
            throws UmlVisitorException {
        visit(umlLinkEndDestructionData.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ExtensionPoint umlExtensionPoint)
            throws UmlVisitorException {
        visit(umlExtensionPoint.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Package umlPackage) throws UmlVisitorException {
        visit(umlPackage.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.OperationTemplateParameter umlOperationTemplateParameter)
            throws UmlVisitorException {
        visit(umlOperationTemplateParameter.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ChangeEvent umlChangeEvent) throws UmlVisitorException {
        visit(umlChangeEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InteractionConstraint umlInteractionConstraint)
            throws UmlVisitorException {
        visit(umlInteractionConstraint.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InteractionUse umlInteractionUse)
            throws UmlVisitorException {
        visit(umlInteractionUse.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.PackageMerge umlPackageMerge) throws UmlVisitorException {
        visit(umlPackageMerge.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.ClearStructuralFeatureAction umlClearStructuralFeatureAction)
            throws UmlVisitorException {
        visit(umlClearStructuralFeatureAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ReadVariableAction umlReadVariableAction)
            throws UmlVisitorException {
        visit(umlReadVariableAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.AcceptCallAction umlAcceptCallAction)
            throws UmlVisitorException {
        visit(umlAcceptCallAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ConditionalNode umlConditionalNode)
            throws UmlVisitorException {
        visit(umlConditionalNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Variable umlVariable) throws UmlVisitorException {
        visit(umlVariable.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.AssociationClass umlAssociationClass)
            throws UmlVisitorException {
        visit(umlAssociationClass.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TimeInterval umlTimeInterval) throws UmlVisitorException {
        visit(umlTimeInterval.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CreateObjectAction umlCreateObjectAction)
            throws UmlVisitorException {
        visit(umlCreateObjectAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Component umlComponent) throws UmlVisitorException {
        visit(umlComponent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ControlFlow umlControlFlow) throws UmlVisitorException {
        visit(umlControlFlow.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ProfileApplication umlProfileApplication)
            throws UmlVisitorException {
        visit(umlProfileApplication.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ProtocolStateMachine umlProtocolStateMachine)
            throws UmlVisitorException {
        visit(umlProtocolStateMachine.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Message umlMessage) throws UmlVisitorException {
        visit(umlMessage.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction umlRemoveStructuralFeatureValueAction)
            throws UmlVisitorException {
        visit(umlRemoveStructuralFeatureValueAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CreateLinkAction umlCreateLinkAction)
            throws UmlVisitorException {
        visit(umlCreateLinkAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TestIdentityAction umlTestIdentityAction)
            throws UmlVisitorException {
        visit(umlTestIdentityAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Substitution umlSubstitution) throws UmlVisitorException {
        visit(umlSubstitution.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.SendOperationEvent umlSendOperationEvent)
            throws UmlVisitorException {
        visit(umlSendOperationEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ProtocolTransition umlProtocolTransition)
            throws UmlVisitorException {
        visit(umlProtocolTransition.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Interval umlInterval) throws UmlVisitorException {
        visit(umlInterval.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DestructionEvent umlDestructionEvent)
            throws UmlVisitorException {
        visit(umlDestructionEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.OccurrenceSpecification umlOccurrenceSpecification)
            throws UmlVisitorException {
        visit(umlOccurrenceSpecification.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ReclassifyObjectAction umlReclassifyObjectAction)
            throws UmlVisitorException {
        visit(umlReclassifyObjectAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.OutputPin umlOutputPin) throws UmlVisitorException {
        visit(umlOutputPin.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.FunctionBehavior umlFunctionBehavior)
            throws UmlVisitorException {
        visit(umlFunctionBehavior.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ConsiderIgnoreFragment umlConsiderIgnoreFragment)
            throws UmlVisitorException {
        visit(umlConsiderIgnoreFragment.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.RaiseExceptionAction umlRaiseExceptionAction)
            throws UmlVisitorException {
        visit(umlRaiseExceptionAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Pseudostate umlPseudostate) throws UmlVisitorException {
        visit(umlPseudostate.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ClearVariableAction umlClearVariableAction)
            throws UmlVisitorException {
        visit(umlClearVariableAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.JoinNode umlJoinNode) throws UmlVisitorException {
        visit(umlJoinNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Device umlDevice) throws UmlVisitorException {
        visit(umlDevice.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LiteralUnlimitedNatural umlLiteralUnlimitedNatural)
            throws UmlVisitorException {
        visit(umlLiteralUnlimitedNatural.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ReadSelfAction umlReadSelfAction)
            throws UmlVisitorException {
        visit(umlReadSelfAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ReadLinkObjectEndAction umlReadLinkObjectEndAction)
            throws UmlVisitorException {
        visit(umlReadLinkObjectEndAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ExtensionEnd umlExtensionEnd) throws UmlVisitorException {
        visit(umlExtensionEnd.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.AddVariableValueAction umlAddVariableValueAction)
            throws UmlVisitorException {
        visit(umlAddVariableValueAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.BehavioralFeature umlBehavioralFeature)
            throws UmlVisitorException {
        visit(umlBehavioralFeature.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Expression umlExpression) throws UmlVisitorException {
        visit(umlExpression.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LiteralString umlLiteralString)
            throws UmlVisitorException {
        visit(umlLiteralString.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.ConnectableElementTemplateParameter umlConnectableElementTemplateParameter)
            throws UmlVisitorException {
        visit(umlConnectableElementTemplateParameter.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CallOperationAction umlCallOperationAction)
            throws UmlVisitorException {
        visit(umlCallOperationAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Realization umlRealization) throws UmlVisitorException {
        visit(umlRealization.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DurationConstraint umlDurationConstraint)
            throws UmlVisitorException {
        visit(umlDurationConstraint.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Node umlNode) throws UmlVisitorException {
        visit(umlNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.PrimitiveType umlPrimitiveType)
            throws UmlVisitorException {
        visit(umlPrimitiveType.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.ClassifierTemplateParameter umlClassifierTemplateParameter)
            throws UmlVisitorException {
        visit(umlClassifierTemplateParameter.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Vertex umlVertex) throws UmlVisitorException {
        visit(umlVertex.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ValuePin umlValuePin) throws UmlVisitorException {
        visit(umlValuePin.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.UseCase umlUseCase) throws UmlVisitorException {
        visit(umlUseCase.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CallBehaviorAction umlCallBehaviorAction)
            throws UmlVisitorException {
        visit(umlCallBehaviorAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TimeConstraint umlTimeConstraint)
            throws UmlVisitorException {
        visit(umlTimeConstraint.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Continuation umlContinuation) throws UmlVisitorException {
        visit(umlContinuation.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Transition umlTransition) throws UmlVisitorException {
        visit(umlTransition.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Property umlProperty) throws UmlVisitorException {
        visit(umlProperty.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InstanceSpecification umlInstanceSpecification)
            throws UmlVisitorException {
        visit(umlInstanceSpecification.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Generalization umlGeneralization)
            throws UmlVisitorException {
        visit(umlGeneralization.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ClearAssociationAction umlClearAssociationAction)
            throws UmlVisitorException {
        visit(umlClearAssociationAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.GeneralizationSet umlGeneralizationSet)
            throws UmlVisitorException {
        visit(umlGeneralizationSet.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.IntervalConstraint umlIntervalConstraint)
            throws UmlVisitorException {
        visit(umlIntervalConstraint.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Manifestation umlManifestation)
            throws UmlVisitorException {
        visit(umlManifestation.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.RemoveVariableValueAction umlRemoveVariableValueAction)
            throws UmlVisitorException {
        visit(umlRemoveVariableValueAction.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.WriteStructuralFeatureAction umlWriteStructuralFeatureAction)
            throws UmlVisitorException {
        visit(umlWriteStructuralFeatureAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CreationEvent umlCreationEvent)
            throws UmlVisitorException {
        visit(umlCreationEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.WriteLinkAction umlWriteLinkAction)
            throws UmlVisitorException {
        visit(umlWriteLinkAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DecisionNode umlDecisionNode) throws UmlVisitorException {
        visit(umlDecisionNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InitialNode umlInitialNode) throws UmlVisitorException {
        visit(umlInitialNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Interface umlInterface) throws UmlVisitorException {
        visit(umlInterface.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InputPin umlInputPin) throws UmlVisitorException {
        visit(umlInputPin.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ElementImport umlElementImport)
            throws UmlVisitorException {
        visit(umlElementImport.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.AnyReceiveEvent umlAnyReceiveEvent)
            throws UmlVisitorException {
        visit(umlAnyReceiveEvent.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction umlReadLinkObjectEndQualifierAction)
            throws UmlVisitorException {
        visit(umlReadLinkObjectEndQualifierAction.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.RedefinableTemplateSignature umlRedefinableTemplateSignature)
            throws UmlVisitorException {
        visit(umlRedefinableTemplateSignature.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.TemplateParameterSubstitution umlTemplateParameterSubstitution)
            throws UmlVisitorException {
        visit(umlTemplateParameterSubstitution.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LiteralNull umlLiteralNull) throws UmlVisitorException {
        visit(umlLiteralNull.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Actor umlActor) throws UmlVisitorException {
        visit(umlActor.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.StructuralFeatureAction umlStructuralFeatureAction)
            throws UmlVisitorException {
        visit(umlStructuralFeatureAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ReadExtentAction umlReadExtentAction)
            throws UmlVisitorException {
        visit(umlReadExtentAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.SequenceNode umlSequenceNode) throws UmlVisitorException {
        visit(umlSequenceNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.StructuredActivityNode umlStructuredActivityNode)
            throws UmlVisitorException {
        visit(umlStructuredActivityNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LinkAction umlLinkAction) throws UmlVisitorException {
        visit(umlLinkAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ExpansionNode umlExpansionNode)
            throws UmlVisitorException {
        visit(umlExpansionNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.AcceptEventAction umlAcceptEventAction)
            throws UmlVisitorException {
        visit(umlAcceptEventAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.SendSignalEvent umlSendSignalEvent)
            throws UmlVisitorException {
        visit(umlSendSignalEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Clause umlClause) throws UmlVisitorException {
        visit(umlClause.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Parameter umlParameter) throws UmlVisitorException {
        visit(umlParameter.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LiteralSpecification umlLiteralSpecification)
            throws UmlVisitorException {
        visit(umlLiteralSpecification.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.StartClassifierBehaviorAction umlStartClassifierBehaviorAction)
            throws UmlVisitorException {
        visit(umlStartClassifierBehaviorAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.QualifierValue umlQualifierValue)
            throws UmlVisitorException {
        visit(umlQualifierValue.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TemplateParameter umlTemplateParameter)
            throws UmlVisitorException {
        visit(umlTemplateParameter.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Abstraction umlAbstraction) throws UmlVisitorException {
        visit(umlAbstraction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ReplyAction umlReplyAction) throws UmlVisitorException {
        visit(umlReplyAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.MessageEvent umlMessageEvent) throws UmlVisitorException {
        visit(umlMessageEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ExceptionHandler umlExceptionHandler)
            throws UmlVisitorException {
        visit(umlExceptionHandler.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CollaborationUse umlCollaborationUse)
            throws UmlVisitorException {
        visit(umlCollaborationUse.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Usage umlUsage) throws UmlVisitorException {
        visit(umlUsage.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.BehaviorExecutionSpecification umlBehaviorExecutionSpecification)
            throws UmlVisitorException {
        visit(umlBehaviorExecutionSpecification.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Extension umlExtension) throws UmlVisitorException {
        visit(umlExtension.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Extend umlExtend) throws UmlVisitorException {
        visit(umlExtend.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ActivityPartition umlActivityPartition)
            throws UmlVisitorException {
        visit(umlActivityPartition.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Enumeration umlEnumeration) throws UmlVisitorException {
        visit(umlEnumeration.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TemplateSignature umlTemplateSignature)
            throws UmlVisitorException {
        visit(umlTemplateSignature.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CallAction umlCallAction) throws UmlVisitorException {
        visit(umlCallAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Connector umlConnector) throws UmlVisitorException {
        visit(umlConnector.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.StateMachine umlStateMachine) throws UmlVisitorException {
        visit(umlStateMachine.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.FinalNode umlFinalNode) throws UmlVisitorException {
        visit(umlFinalNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Gate umlGate) throws UmlVisitorException {
        visit(umlGate.getOwnedElements());
    }

    public void visit(
            org.eclipse.uml2.uml.ReadIsClassifiedObjectAction umlReadIsClassifiedObjectAction)
            throws UmlVisitorException {
        visit(umlReadIsClassifiedObjectAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DeploymentTarget umlDeploymentTarget)
            throws UmlVisitorException {
        visit(umlDeploymentTarget.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.OpaqueBehavior umlOpaqueBehavior)
            throws UmlVisitorException {
        visit(umlOpaqueBehavior.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ExecutionSpecification umlExecutionSpecification)
            throws UmlVisitorException {
        visit(umlExecutionSpecification.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CombinedFragment umlCombinedFragment)
            throws UmlVisitorException {
        visit(umlCombinedFragment.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Include umlInclude) throws UmlVisitorException {
        visit(umlInclude.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ActivityEdge umlActivityEdge) throws UmlVisitorException {
        visit(umlActivityEdge.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.WriteVariableAction umlWriteVariableAction)
            throws UmlVisitorException {
        visit(umlWriteVariableAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Behavior umlBehavior) throws UmlVisitorException {
        visit(umlBehavior.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.MergeNode umlMergeNode) throws UmlVisitorException {
        visit(umlMergeNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ControlNode umlControlNode) throws UmlVisitorException {
        visit(umlControlNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.LinkEndData umlLinkEndData) throws UmlVisitorException {
        visit(umlLinkEndData.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DeployedArtifact umlDeployedArtifact)
            throws UmlVisitorException {
        visit(umlDeployedArtifact.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DataStoreNode umlDataStoreNode)
            throws UmlVisitorException {
        visit(umlDataStoreNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Association umlAssociation) throws UmlVisitorException {
        visit(umlAssociation.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InformationItem umlInformationItem)
            throws UmlVisitorException {
        visit(umlInformationItem.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Class umlClass) throws UmlVisitorException {
        visit(umlClass.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Pin umlPin) throws UmlVisitorException {
        visit(umlPin.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.EncapsulatedClassifier umlEncapsulatedClassifier)
            throws UmlVisitorException {
        visit(umlEncapsulatedClassifier.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.StructuralFeature umlStructuralFeature)
            throws UmlVisitorException {
        visit(umlStructuralFeature.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Dependency umlDependency) throws UmlVisitorException {
        visit(umlDependency.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Constraint umlConstraint) throws UmlVisitorException {
        visit(umlConstraint.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InformationFlow umlInformationFlow)
            throws UmlVisitorException {
        visit(umlInformationFlow.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TimeEvent umlTimeEvent) throws UmlVisitorException {
        visit(umlTimeEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DataType umlDataType) throws UmlVisitorException {
        visit(umlDataType.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.OpaqueExpression umlOpaqueExpression)
            throws UmlVisitorException {
        visit(umlOpaqueExpression.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.CentralBufferNode umlCentralBufferNode)
            throws UmlVisitorException {
        visit(umlCentralBufferNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.MessageEnd umlMessageEnd) throws UmlVisitorException {
        visit(umlMessageEnd.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.OpaqueAction umlOpaqueAction) throws UmlVisitorException {
        visit(umlOpaqueAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.DirectedRelationship umlDirectedRelationship)
            throws UmlVisitorException {
        visit(umlDirectedRelationship.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ConnectorEnd umlConnectorEnd) throws UmlVisitorException {
        visit(umlConnectorEnd.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.VariableAction umlVariableAction)
            throws UmlVisitorException {
        visit(umlVariableAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Relationship umlRelationship) throws UmlVisitorException {
        visit(umlRelationship.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InvocationAction umlInvocationAction)
            throws UmlVisitorException {
        visit(umlInvocationAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.StructuredClassifier umlStructuredClassifier)
            throws UmlVisitorException {
        visit(umlStructuredClassifier.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Feature umlFeature) throws UmlVisitorException {
        visit(umlFeature.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Action umlAction) throws UmlVisitorException {
        visit(umlAction.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Event umlEvent) throws UmlVisitorException {
        visit(umlEvent.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ObjectNode umlObjectNode) throws UmlVisitorException {
        visit(umlObjectNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.BehavioredClassifier umlBehavioredClassifier)
            throws UmlVisitorException {
        visit(umlBehavioredClassifier.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ActivityGroup umlActivityGroup)
            throws UmlVisitorException {
        visit(umlActivityGroup.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TimeExpression umlTimeExpression)
            throws UmlVisitorException {
        visit(umlTimeExpression.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Classifier umlClassifier) throws UmlVisitorException {
        visit(umlClassifier.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ExecutableNode umlExecutableNode)
            throws UmlVisitorException {
        visit(umlExecutableNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Duration umlDuration) throws UmlVisitorException {
        visit(umlDuration.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ConnectableElement umlConnectableElement)
            throws UmlVisitorException {
        visit(umlConnectableElement.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ValueSpecification umlValueSpecification)
            throws UmlVisitorException {
        visit(umlValueSpecification.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ActivityNode umlActivityNode) throws UmlVisitorException {
        visit(umlActivityNode.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Type umlType) throws UmlVisitorException {
        visit(umlType.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.InteractionFragment umlInteractionFragment)
            throws UmlVisitorException {
        visit(umlInteractionFragment.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.Namespace umlNamespace) throws UmlVisitorException {
        visit(umlNamespace.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TypedElement umlTypedElement) throws UmlVisitorException {
        visit(umlTypedElement.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.PackageableElement umlPackageableElement)
            throws UmlVisitorException {
        visit(umlPackageableElement.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.RedefinableElement umlRedefinableElement)
            throws UmlVisitorException {
        visit(umlRedefinableElement.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.MultiplicityElement umlMultiplicityElement)
            throws UmlVisitorException {
        visit(umlMultiplicityElement.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.TemplateableElement umlTemplateableElement)
            throws UmlVisitorException {
        visit(umlTemplateableElement.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.NamedElement umlNamedElement) throws UmlVisitorException {
        visit(umlNamedElement.getOwnedElements());
    }

    public void visit(org.eclipse.uml2.uml.ParameterableElement umlParameterableElement)
            throws UmlVisitorException {
        visit(umlParameterableElement.getOwnedElements());
    }

    public final void visit(org.eclipse.uml2.uml.Element umlElement) throws UmlVisitorException {
        if (umlElement instanceof org.eclipse.uml2.uml.Reception) {
            visit((org.eclipse.uml2.uml.Reception) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Region) {
            visit((org.eclipse.uml2.uml.Region) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InteractionOperand) {
            visit((org.eclipse.uml2.uml.InteractionOperand) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Profile) {
            visit((org.eclipse.uml2.uml.Profile) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Deployment) {
            visit((org.eclipse.uml2.uml.Deployment) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SendObjectAction) {
            visit((org.eclipse.uml2.uml.SendObjectAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutionEnvironment) {
            visit((org.eclipse.uml2.uml.ExecutionEnvironment) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StateInvariant) {
            visit((org.eclipse.uml2.uml.StateInvariant) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Slot) {
            visit((org.eclipse.uml2.uml.Slot) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadLinkAction) {
            visit((org.eclipse.uml2.uml.ReadLinkAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.GeneralOrdering) {
            visit((org.eclipse.uml2.uml.GeneralOrdering) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.FinalState) {
            visit((org.eclipse.uml2.uml.FinalState) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutionOccurrenceSpecification) {
            visit((org.eclipse.uml2.uml.ExecutionOccurrenceSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LinkEndCreationData) {
            visit((org.eclipse.uml2.uml.LinkEndCreationData) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Activity) {
            visit((org.eclipse.uml2.uml.Activity) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DeploymentSpecification) {
            visit((org.eclipse.uml2.uml.DeploymentSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CallEvent) {
            visit((org.eclipse.uml2.uml.CallEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.BroadcastSignalAction) {
            visit((org.eclipse.uml2.uml.BroadcastSignalAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralBoolean) {
            visit((org.eclipse.uml2.uml.LiteralBoolean) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActionExecutionSpecification) {
            visit((org.eclipse.uml2.uml.ActionExecutionSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Comment) {
            visit((org.eclipse.uml2.uml.Comment) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InstanceValue) {
            visit((org.eclipse.uml2.uml.InstanceValue) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.EnumerationLiteral) {
            visit((org.eclipse.uml2.uml.EnumerationLiteral) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MessageOccurrenceSpecification) {
            visit((org.eclipse.uml2.uml.MessageOccurrenceSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InterfaceRealization) {
            visit((org.eclipse.uml2.uml.InterfaceRealization) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InterruptibleActivityRegion) {
            visit((org.eclipse.uml2.uml.InterruptibleActivityRegion) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExpansionRegion) {
            visit((org.eclipse.uml2.uml.ExpansionRegion) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PackageImport) {
            visit((org.eclipse.uml2.uml.PackageImport) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConnectionPointReference) {
            visit((org.eclipse.uml2.uml.ConnectionPointReference) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Port) {
            visit((org.eclipse.uml2.uml.Port) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DestroyLinkAction) {
            visit((org.eclipse.uml2.uml.DestroyLinkAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ValueSpecificationAction) {
            visit((org.eclipse.uml2.uml.ValueSpecificationAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateBinding) {
            visit((org.eclipse.uml2.uml.TemplateBinding) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Collaboration) {
            visit((org.eclipse.uml2.uml.Collaboration) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Stereotype) {
            visit((org.eclipse.uml2.uml.Stereotype) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActionInputPin) {
            visit((org.eclipse.uml2.uml.ActionInputPin) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Artifact) {
            visit((org.eclipse.uml2.uml.Artifact) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralInteger) {
            visit((org.eclipse.uml2.uml.LiteralInteger) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityFinalNode) {
            visit((org.eclipse.uml2.uml.ActivityFinalNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Operation) {
            visit((org.eclipse.uml2.uml.Operation) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Lifeline) {
            visit((org.eclipse.uml2.uml.Lifeline) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.FlowFinalNode) {
            visit((org.eclipse.uml2.uml.FlowFinalNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DurationInterval) {
            visit((org.eclipse.uml2.uml.DurationInterval) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.UnmarshallAction) {
            visit((org.eclipse.uml2.uml.UnmarshallAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ProtocolConformance) {
            visit((org.eclipse.uml2.uml.ProtocolConformance) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PartDecomposition) {
            visit((org.eclipse.uml2.uml.PartDecomposition) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LoopNode) {
            visit((org.eclipse.uml2.uml.LoopNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityParameterNode) {
            visit((org.eclipse.uml2.uml.ActivityParameterNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CommunicationPath) {
            visit((org.eclipse.uml2.uml.CommunicationPath) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StringExpression) {
            visit((org.eclipse.uml2.uml.StringExpression) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Signal) {
            visit((org.eclipse.uml2.uml.Signal) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SendSignalAction) {
            visit((org.eclipse.uml2.uml.SendSignalAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ParameterSet) {
            visit((org.eclipse.uml2.uml.ParameterSet) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.State) {
            visit((org.eclipse.uml2.uml.State) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AddStructuralFeatureValueAction) {
            visit((org.eclipse.uml2.uml.AddStructuralFeatureValueAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ForkNode) {
            visit((org.eclipse.uml2.uml.ForkNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Model) {
            visit((org.eclipse.uml2.uml.Model) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DestroyObjectAction) {
            visit((org.eclipse.uml2.uml.DestroyObjectAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ObjectFlow) {
            visit((org.eclipse.uml2.uml.ObjectFlow) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadStructuralFeatureAction) {
            visit((org.eclipse.uml2.uml.ReadStructuralFeatureAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Interaction) {
            visit((org.eclipse.uml2.uml.Interaction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CreateLinkObjectAction) {
            visit((org.eclipse.uml2.uml.CreateLinkObjectAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SignalEvent) {
            visit((org.eclipse.uml2.uml.SignalEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutionEvent) {
            visit((org.eclipse.uml2.uml.ExecutionEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Trigger) {
            visit((org.eclipse.uml2.uml.Trigger) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LinkEndDestructionData) {
            visit((org.eclipse.uml2.uml.LinkEndDestructionData) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExtensionPoint) {
            visit((org.eclipse.uml2.uml.ExtensionPoint) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Package) {
            visit((org.eclipse.uml2.uml.Package) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OperationTemplateParameter) {
            visit((org.eclipse.uml2.uml.OperationTemplateParameter) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ChangeEvent) {
            visit((org.eclipse.uml2.uml.ChangeEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InteractionConstraint) {
            visit((org.eclipse.uml2.uml.InteractionConstraint) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InteractionUse) {
            visit((org.eclipse.uml2.uml.InteractionUse) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PackageMerge) {
            visit((org.eclipse.uml2.uml.PackageMerge) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ClearStructuralFeatureAction) {
            visit((org.eclipse.uml2.uml.ClearStructuralFeatureAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadVariableAction) {
            visit((org.eclipse.uml2.uml.ReadVariableAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AcceptCallAction) {
            visit((org.eclipse.uml2.uml.AcceptCallAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConditionalNode) {
            visit((org.eclipse.uml2.uml.ConditionalNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Variable) {
            visit((org.eclipse.uml2.uml.Variable) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AssociationClass) {
            visit((org.eclipse.uml2.uml.AssociationClass) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TimeInterval) {
            visit((org.eclipse.uml2.uml.TimeInterval) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CreateObjectAction) {
            visit((org.eclipse.uml2.uml.CreateObjectAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Component) {
            visit((org.eclipse.uml2.uml.Component) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ControlFlow) {
            visit((org.eclipse.uml2.uml.ControlFlow) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ProfileApplication) {
            visit((org.eclipse.uml2.uml.ProfileApplication) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ProtocolStateMachine) {
            visit((org.eclipse.uml2.uml.ProtocolStateMachine) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Message) {
            visit((org.eclipse.uml2.uml.Message) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction) {
            visit((org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CreateLinkAction) {
            visit((org.eclipse.uml2.uml.CreateLinkAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TestIdentityAction) {
            visit((org.eclipse.uml2.uml.TestIdentityAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Substitution) {
            visit((org.eclipse.uml2.uml.Substitution) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SendOperationEvent) {
            visit((org.eclipse.uml2.uml.SendOperationEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ProtocolTransition) {
            visit((org.eclipse.uml2.uml.ProtocolTransition) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Interval) {
            visit((org.eclipse.uml2.uml.Interval) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DestructionEvent) {
            visit((org.eclipse.uml2.uml.DestructionEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OccurrenceSpecification) {
            visit((org.eclipse.uml2.uml.OccurrenceSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReclassifyObjectAction) {
            visit((org.eclipse.uml2.uml.ReclassifyObjectAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OutputPin) {
            visit((org.eclipse.uml2.uml.OutputPin) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.FunctionBehavior) {
            visit((org.eclipse.uml2.uml.FunctionBehavior) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConsiderIgnoreFragment) {
            visit((org.eclipse.uml2.uml.ConsiderIgnoreFragment) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RaiseExceptionAction) {
            visit((org.eclipse.uml2.uml.RaiseExceptionAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Pseudostate) {
            visit((org.eclipse.uml2.uml.Pseudostate) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ClearVariableAction) {
            visit((org.eclipse.uml2.uml.ClearVariableAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.JoinNode) {
            visit((org.eclipse.uml2.uml.JoinNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Device) {
            visit((org.eclipse.uml2.uml.Device) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralUnlimitedNatural) {
            visit((org.eclipse.uml2.uml.LiteralUnlimitedNatural) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadSelfAction) {
            visit((org.eclipse.uml2.uml.ReadSelfAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadLinkObjectEndAction) {
            visit((org.eclipse.uml2.uml.ReadLinkObjectEndAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExtensionEnd) {
            visit((org.eclipse.uml2.uml.ExtensionEnd) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AddVariableValueAction) {
            visit((org.eclipse.uml2.uml.AddVariableValueAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.BehavioralFeature) {
            visit((org.eclipse.uml2.uml.BehavioralFeature) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Expression) {
            visit((org.eclipse.uml2.uml.Expression) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralString) {
            visit((org.eclipse.uml2.uml.LiteralString) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConnectableElementTemplateParameter) {
            visit((org.eclipse.uml2.uml.ConnectableElementTemplateParameter) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CallOperationAction) {
            visit((org.eclipse.uml2.uml.CallOperationAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Realization) {
            visit((org.eclipse.uml2.uml.Realization) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DurationConstraint) {
            visit((org.eclipse.uml2.uml.DurationConstraint) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Node) {
            visit((org.eclipse.uml2.uml.Node) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PrimitiveType) {
            visit((org.eclipse.uml2.uml.PrimitiveType) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ClassifierTemplateParameter) {
            visit((org.eclipse.uml2.uml.ClassifierTemplateParameter) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Vertex) {
            visit((org.eclipse.uml2.uml.Vertex) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ValuePin) {
            visit((org.eclipse.uml2.uml.ValuePin) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.UseCase) {
            visit((org.eclipse.uml2.uml.UseCase) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CallBehaviorAction) {
            visit((org.eclipse.uml2.uml.CallBehaviorAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TimeConstraint) {
            visit((org.eclipse.uml2.uml.TimeConstraint) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Continuation) {
            visit((org.eclipse.uml2.uml.Continuation) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Transition) {
            visit((org.eclipse.uml2.uml.Transition) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Property) {
            visit((org.eclipse.uml2.uml.Property) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InstanceSpecification) {
            visit((org.eclipse.uml2.uml.InstanceSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Generalization) {
            visit((org.eclipse.uml2.uml.Generalization) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ClearAssociationAction) {
            visit((org.eclipse.uml2.uml.ClearAssociationAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.GeneralizationSet) {
            visit((org.eclipse.uml2.uml.GeneralizationSet) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.IntervalConstraint) {
            visit((org.eclipse.uml2.uml.IntervalConstraint) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Manifestation) {
            visit((org.eclipse.uml2.uml.Manifestation) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RemoveVariableValueAction) {
            visit((org.eclipse.uml2.uml.RemoveVariableValueAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.WriteStructuralFeatureAction) {
            visit((org.eclipse.uml2.uml.WriteStructuralFeatureAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CreationEvent) {
            visit((org.eclipse.uml2.uml.CreationEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.WriteLinkAction) {
            visit((org.eclipse.uml2.uml.WriteLinkAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DecisionNode) {
            visit((org.eclipse.uml2.uml.DecisionNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InitialNode) {
            visit((org.eclipse.uml2.uml.InitialNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Interface) {
            visit((org.eclipse.uml2.uml.Interface) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InputPin) {
            visit((org.eclipse.uml2.uml.InputPin) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ElementImport) {
            visit((org.eclipse.uml2.uml.ElementImport) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AnyReceiveEvent) {
            visit((org.eclipse.uml2.uml.AnyReceiveEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction) {
            visit((org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RedefinableTemplateSignature) {
            visit((org.eclipse.uml2.uml.RedefinableTemplateSignature) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateParameterSubstitution) {
            visit((org.eclipse.uml2.uml.TemplateParameterSubstitution) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralNull) {
            visit((org.eclipse.uml2.uml.LiteralNull) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Actor) {
            visit((org.eclipse.uml2.uml.Actor) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StructuralFeatureAction) {
            visit((org.eclipse.uml2.uml.StructuralFeatureAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadExtentAction) {
            visit((org.eclipse.uml2.uml.ReadExtentAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SequenceNode) {
            visit((org.eclipse.uml2.uml.SequenceNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StructuredActivityNode) {
            visit((org.eclipse.uml2.uml.StructuredActivityNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LinkAction) {
            visit((org.eclipse.uml2.uml.LinkAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExpansionNode) {
            visit((org.eclipse.uml2.uml.ExpansionNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AcceptEventAction) {
            visit((org.eclipse.uml2.uml.AcceptEventAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SendSignalEvent) {
            visit((org.eclipse.uml2.uml.SendSignalEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Clause) {
            visit((org.eclipse.uml2.uml.Clause) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Parameter) {
            visit((org.eclipse.uml2.uml.Parameter) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralSpecification) {
            visit((org.eclipse.uml2.uml.LiteralSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StartClassifierBehaviorAction) {
            visit((org.eclipse.uml2.uml.StartClassifierBehaviorAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.QualifierValue) {
            visit((org.eclipse.uml2.uml.QualifierValue) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateParameter) {
            visit((org.eclipse.uml2.uml.TemplateParameter) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Abstraction) {
            visit((org.eclipse.uml2.uml.Abstraction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReplyAction) {
            visit((org.eclipse.uml2.uml.ReplyAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MessageEvent) {
            visit((org.eclipse.uml2.uml.MessageEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExceptionHandler) {
            visit((org.eclipse.uml2.uml.ExceptionHandler) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CollaborationUse) {
            visit((org.eclipse.uml2.uml.CollaborationUse) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Usage) {
            visit((org.eclipse.uml2.uml.Usage) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.BehaviorExecutionSpecification) {
            visit((org.eclipse.uml2.uml.BehaviorExecutionSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Extension) {
            visit((org.eclipse.uml2.uml.Extension) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Extend) {
            visit((org.eclipse.uml2.uml.Extend) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityPartition) {
            visit((org.eclipse.uml2.uml.ActivityPartition) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Enumeration) {
            visit((org.eclipse.uml2.uml.Enumeration) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateSignature) {
            visit((org.eclipse.uml2.uml.TemplateSignature) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CallAction) {
            visit((org.eclipse.uml2.uml.CallAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Connector) {
            visit((org.eclipse.uml2.uml.Connector) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StateMachine) {
            visit((org.eclipse.uml2.uml.StateMachine) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.FinalNode) {
            visit((org.eclipse.uml2.uml.FinalNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Gate) {
            visit((org.eclipse.uml2.uml.Gate) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadIsClassifiedObjectAction) {
            visit((org.eclipse.uml2.uml.ReadIsClassifiedObjectAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DeploymentTarget) {
            visit((org.eclipse.uml2.uml.DeploymentTarget) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OpaqueBehavior) {
            visit((org.eclipse.uml2.uml.OpaqueBehavior) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutionSpecification) {
            visit((org.eclipse.uml2.uml.ExecutionSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CombinedFragment) {
            visit((org.eclipse.uml2.uml.CombinedFragment) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Include) {
            visit((org.eclipse.uml2.uml.Include) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityEdge) {
            visit((org.eclipse.uml2.uml.ActivityEdge) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.WriteVariableAction) {
            visit((org.eclipse.uml2.uml.WriteVariableAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Behavior) {
            visit((org.eclipse.uml2.uml.Behavior) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MergeNode) {
            visit((org.eclipse.uml2.uml.MergeNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ControlNode) {
            visit((org.eclipse.uml2.uml.ControlNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LinkEndData) {
            visit((org.eclipse.uml2.uml.LinkEndData) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DeployedArtifact) {
            visit((org.eclipse.uml2.uml.DeployedArtifact) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DataStoreNode) {
            visit((org.eclipse.uml2.uml.DataStoreNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Association) {
            visit((org.eclipse.uml2.uml.Association) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InformationItem) {
            visit((org.eclipse.uml2.uml.InformationItem) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Class) {
            visit((org.eclipse.uml2.uml.Class) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Pin) {
            visit((org.eclipse.uml2.uml.Pin) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.EncapsulatedClassifier) {
            visit((org.eclipse.uml2.uml.EncapsulatedClassifier) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StructuralFeature) {
            visit((org.eclipse.uml2.uml.StructuralFeature) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Dependency) {
            visit((org.eclipse.uml2.uml.Dependency) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Constraint) {
            visit((org.eclipse.uml2.uml.Constraint) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InformationFlow) {
            visit((org.eclipse.uml2.uml.InformationFlow) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TimeEvent) {
            visit((org.eclipse.uml2.uml.TimeEvent) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DataType) {
            visit((org.eclipse.uml2.uml.DataType) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OpaqueExpression) {
            visit((org.eclipse.uml2.uml.OpaqueExpression) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CentralBufferNode) {
            visit((org.eclipse.uml2.uml.CentralBufferNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MessageEnd) {
            visit((org.eclipse.uml2.uml.MessageEnd) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OpaqueAction) {
            visit((org.eclipse.uml2.uml.OpaqueAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DirectedRelationship) {
            visit((org.eclipse.uml2.uml.DirectedRelationship) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConnectorEnd) {
            visit((org.eclipse.uml2.uml.ConnectorEnd) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.VariableAction) {
            visit((org.eclipse.uml2.uml.VariableAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Relationship) {
            visit((org.eclipse.uml2.uml.Relationship) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InvocationAction) {
            visit((org.eclipse.uml2.uml.InvocationAction) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StructuredClassifier) {
            visit((org.eclipse.uml2.uml.StructuredClassifier) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Feature) {
            visit((org.eclipse.uml2.uml.Feature) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Action) {
            visit((org.eclipse.uml2.uml.Action) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Event) {
            visit((org.eclipse.uml2.uml.Event) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ObjectNode) {
            visit((org.eclipse.uml2.uml.ObjectNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.BehavioredClassifier) {
            visit((org.eclipse.uml2.uml.BehavioredClassifier) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityGroup) {
            visit((org.eclipse.uml2.uml.ActivityGroup) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TimeExpression) {
            visit((org.eclipse.uml2.uml.TimeExpression) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Classifier) {
            visit((org.eclipse.uml2.uml.Classifier) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutableNode) {
            visit((org.eclipse.uml2.uml.ExecutableNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Duration) {
            visit((org.eclipse.uml2.uml.Duration) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConnectableElement) {
            visit((org.eclipse.uml2.uml.ConnectableElement) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ValueSpecification) {
            visit((org.eclipse.uml2.uml.ValueSpecification) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityNode) {
            visit((org.eclipse.uml2.uml.ActivityNode) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Type) {
            visit((org.eclipse.uml2.uml.Type) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InteractionFragment) {
            visit((org.eclipse.uml2.uml.InteractionFragment) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Namespace) {
            visit((org.eclipse.uml2.uml.Namespace) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TypedElement) {
            visit((org.eclipse.uml2.uml.TypedElement) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PackageableElement) {
            visit((org.eclipse.uml2.uml.PackageableElement) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RedefinableElement) {
            visit((org.eclipse.uml2.uml.RedefinableElement) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MultiplicityElement) {
            visit((org.eclipse.uml2.uml.MultiplicityElement) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateableElement) {
            visit((org.eclipse.uml2.uml.TemplateableElement) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.NamedElement) {
            visit((org.eclipse.uml2.uml.NamedElement) umlElement);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ParameterableElement) {
            visit((org.eclipse.uml2.uml.ParameterableElement) umlElement);
        } else {
            logger.warning(umlElement.getClass().getName(), " : not yet supported");
        }
    }

    // GENERATED CODE END.
    // ////////////////////////////////////////////////////////////////////////////////////////////

    public final void visit(
            org.eclipse.emf.common.util.EList<org.eclipse.uml2.uml.Element> elementList)
            throws UmlVisitorException {
        for (int i = 0; i < elementList.size(); i++) {
            visit(elementList.get(i));
        }
    }
}
