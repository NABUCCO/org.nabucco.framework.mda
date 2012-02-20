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
package org.nabucco.framework.mda.model.uml.visitor;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.MdaModel;
import org.nabucco.framework.mda.model.ModelImplementation;
import org.nabucco.framework.mda.model.visitor.MdaModelVisitorContext;

/**
 * Visits the UML Elements in deep manner (prerequisite). With this visitor the target model is
 * generated.
 * 
 * @author Thomas Annen, PRODYNA AG
 */
public abstract class UmlModelContentVisitor<M extends MdaModel<? extends ModelImplementation>, C extends MdaModelVisitorContext>
        extends UmlModelVisitor<C> {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            UmlModelContentVisitor.class);

    /**
     * @param visitorContext
     */
    public UmlModelContentVisitor(C visitorContext) {
        super(visitorContext);
    }

    // GENERATED CODE START.
    // //////////////////////////////////////////////////////////////////////////////////////////

    public void visit(org.eclipse.uml2.uml.Duration umlDuration, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDuration.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ReclassifyObjectAction umlReclassifyObjectAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlReclassifyObjectAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ProtocolStateMachine umlProtocolStateMachine,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlProtocolStateMachine.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.MessageOccurrenceSpecification umlMessageOccurrenceSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlMessageOccurrenceSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Extension umlExtension, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExtension.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ExtensionEnd umlExtensionEnd, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExtensionEnd.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LiteralString umlLiteralString, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlLiteralString.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Interaction umlInteraction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInteraction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.QualifierValue umlQualifierValue, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlQualifierValue.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Pseudostate umlPseudostate, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlPseudostate.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ConsiderIgnoreFragment umlConsiderIgnoreFragment,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlConsiderIgnoreFragment.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ParameterSet umlParameterSet, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlParameterSet.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CommunicationPath umlCommunicationPath, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlCommunicationPath.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Interface umlInterface, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInterface.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Operation umlOperation, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlOperation.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CallBehaviorAction umlCallBehaviorAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlCallBehaviorAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.StateMachine umlStateMachine, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlStateMachine.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ValuePin umlValuePin, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlValuePin.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.BroadcastSignalAction umlBroadcastSignalAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlBroadcastSignalAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Slot umlSlot, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlSlot.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.AnyReceiveEvent umlAnyReceiveEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlAnyReceiveEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Parameter umlParameter, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlParameter.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Port umlPort, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlPort.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TimeInterval umlTimeInterval, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTimeInterval.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Region umlRegion, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlRegion.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ActivityFinalNode umlActivityFinalNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlActivityFinalNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.AddVariableValueAction umlAddVariableValueAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlAddVariableValueAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Message umlMessage, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlMessage.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CallOperationAction umlCallOperationAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlCallOperationAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Signal umlSignal, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlSignal.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ActionInputPin umlActionInputPin, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlActionInputPin.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Actor umlActor, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlActor.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.FunctionBehavior umlFunctionBehavior, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlFunctionBehavior.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DurationInterval umlDurationInterval, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDurationInterval.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DestroyLinkAction umlDestroyLinkAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDestroyLinkAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Device umlDevice, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDevice.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.OpaqueBehavior umlOpaqueBehavior, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlOpaqueBehavior.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Variable umlVariable, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlVariable.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ProfileApplication umlProfileApplication,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlProfileApplication.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ExtensionPoint umlExtensionPoint, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExtensionPoint.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.StringExpression umlStringExpression, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlStringExpression.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.GeneralOrdering umlGeneralOrdering, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlGeneralOrdering.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.StartClassifierBehaviorAction umlStartClassifierBehaviorAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlStartClassifierBehaviorAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.FlowFinalNode umlFlowFinalNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlFlowFinalNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.GeneralizationSet umlGeneralizationSet, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlGeneralizationSet.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ActivityPartition umlActivityPartition, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlActivityPartition.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.SendObjectAction umlSendObjectAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlSendObjectAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ConnectionPointReference umlConnectionPointReference,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlConnectionPointReference.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Collaboration umlCollaboration, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlCollaboration.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Deployment umlDeployment, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDeployment.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.ClassifierTemplateParameter umlClassifierTemplateParameter,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlClassifierTemplateParameter.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ProtocolTransition umlProtocolTransition,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlProtocolTransition.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.ReadStructuralFeatureAction umlReadStructuralFeatureAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlReadStructuralFeatureAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Component umlComponent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlComponent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.SendSignalEvent umlSendSignalEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlSendSignalEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CreateLinkObjectAction umlCreateLinkObjectAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlCreateLinkObjectAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LiteralUnlimitedNatural umlLiteralUnlimitedNatural,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlLiteralUnlimitedNatural.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LiteralBoolean umlLiteralBoolean, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlLiteralBoolean.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Generalization umlGeneralization, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlGeneralization.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DurationConstraint umlDurationConstraint,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlDurationConstraint.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Property umlProperty, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlProperty.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.AcceptCallAction umlAcceptCallAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlAcceptCallAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.AssociationClass umlAssociationClass, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlAssociationClass.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.UseCase umlUseCase, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlUseCase.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Association umlAssociation, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlAssociation.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.SendSignalAction umlSendSignalAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlSendSignalAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ReadVariableAction umlReadVariableAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlReadVariableAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.SequenceNode umlSequenceNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlSequenceNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ConnectorEnd umlConnectorEnd, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlConnectorEnd.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TimeConstraint umlTimeConstraint, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTimeConstraint.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Include umlInclude, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInclude.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.PartDecomposition umlPartDecomposition, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlPartDecomposition.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.StateInvariant umlStateInvariant, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlStateInvariant.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CreationEvent umlCreationEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlCreationEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Manifestation umlManifestation, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlManifestation.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LiteralNull umlLiteralNull, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlLiteralNull.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.BehaviorExecutionSpecification umlBehaviorExecutionSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlBehaviorExecutionSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.ReadIsClassifiedObjectAction umlReadIsClassifiedObjectAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlReadIsClassifiedObjectAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.SendOperationEvent umlSendOperationEvent,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlSendOperationEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Enumeration umlEnumeration, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlEnumeration.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InputPin umlInputPin, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInputPin.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction umlRemoveStructuralFeatureValueAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlRemoveStructuralFeatureValueAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.AcceptEventAction umlAcceptEventAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlAcceptEventAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Comment umlComment, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlComment.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.IntervalConstraint umlIntervalConstraint,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlIntervalConstraint.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TestIdentityAction umlTestIdentityAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlTestIdentityAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LiteralInteger umlLiteralInteger, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlLiteralInteger.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.ExecutionOccurrenceSpecification umlExecutionOccurrenceSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlExecutionOccurrenceSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.FinalState umlFinalState, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlFinalState.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Reception umlReception, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlReception.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Activity umlActivity, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlActivity.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Clause umlClause, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlClause.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.OccurrenceSpecification umlOccurrenceSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlOccurrenceSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ClearAssociationAction umlClearAssociationAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlClearAssociationAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Substitution umlSubstitution, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlSubstitution.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DestructionEvent umlDestructionEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDestructionEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CallEvent umlCallEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlCallEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ConnectableElement umlConnectableElement,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlConnectableElement.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.AddStructuralFeatureValueAction umlAddStructuralFeatureValueAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlAddStructuralFeatureValueAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Behavior umlBehavior, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlBehavior.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.RemoveVariableValueAction umlRemoveVariableValueAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlRemoveVariableValueAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LoopNode umlLoopNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlLoopNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ReadSelfAction umlReadSelfAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlReadSelfAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Interval umlInterval, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInterval.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DecisionNode umlDecisionNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDecisionNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DestroyObjectAction umlDestroyObjectAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlDestroyObjectAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.ClearStructuralFeatureAction umlClearStructuralFeatureAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlClearStructuralFeatureAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.WriteStructuralFeatureAction umlWriteStructuralFeatureAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlWriteStructuralFeatureAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ClearVariableAction umlClearVariableAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlClearVariableAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.FinalNode umlFinalNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlFinalNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InformationItem umlInformationItem, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInformationItem.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.BehavioralFeature umlBehavioralFeature, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlBehavioralFeature.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Transition umlTransition, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTransition.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ProtocolConformance umlProtocolConformance,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlProtocolConformance.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Stereotype umlStereotype, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlStereotype.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DataStoreNode umlDataStoreNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDataStoreNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.EnumerationLiteral umlEnumerationLiteral,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlEnumerationLiteral.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.OpaqueAction umlOpaqueAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlOpaqueAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Profile umlProfile, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlProfile.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.ConnectableElementTemplateParameter umlConnectableElementTemplateParameter,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlConnectableElementTemplateParameter.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DeploymentSpecification umlDeploymentSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlDeploymentSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.OutputPin umlOutputPin, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlOutputPin.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LiteralSpecification umlLiteralSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlLiteralSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.RedefinableTemplateSignature umlRedefinableTemplateSignature,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlRedefinableTemplateSignature.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ValueSpecificationAction umlValueSpecificationAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlValueSpecificationAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction umlReadLinkObjectEndQualifierAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlReadLinkObjectEndQualifierAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Extend umlExtend, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExtend.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.SignalEvent umlSignalEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlSignalEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.OperationTemplateParameter umlOperationTemplateParameter,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlOperationTemplateParameter.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ExpansionRegion umlExpansionRegion, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExpansionRegion.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ExpansionNode umlExpansionNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExpansionNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.PackageMerge umlPackageMerge, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlPackageMerge.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.JoinNode umlJoinNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlJoinNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.UnmarshallAction umlUnmarshallAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlUnmarshallAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CallAction umlCallAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlCallAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ReplyAction umlReplyAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlReplyAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ExecutionEnvironment umlExecutionEnvironment,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlExecutionEnvironment.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ElementImport umlElementImport, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlElementImport.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Artifact umlArtifact, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlArtifact.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CombinedFragment umlCombinedFragment, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlCombinedFragment.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Continuation umlContinuation, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlContinuation.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Model umlModel, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlModel.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.StructuralFeature umlStructuralFeature, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlStructuralFeature.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TemplateSignature umlTemplateSignature, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTemplateSignature.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ConditionalNode umlConditionalNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlConditionalNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InstanceValue umlInstanceValue, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInstanceValue.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Expression umlExpression, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExpression.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Node umlNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.WriteVariableAction umlWriteVariableAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlWriteVariableAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ControlFlow umlControlFlow, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlControlFlow.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ActivityParameterNode umlActivityParameterNode,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlActivityParameterNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LinkEndCreationData umlLinkEndCreationData,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlLinkEndCreationData.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ReadLinkObjectEndAction umlReadLinkObjectEndAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlReadLinkObjectEndAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.PackageImport umlPackageImport, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlPackageImport.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Class umlClass, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlClass.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Pin umlPin, M targetMdaModel) throws UmlVisitorException {
        visit(umlPin.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.InterruptibleActivityRegion umlInterruptibleActivityRegion,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlInterruptibleActivityRegion.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.MultiplicityElement umlMultiplicityElement,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlMultiplicityElement.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ObjectFlow umlObjectFlow, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlObjectFlow.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LinkEndDestructionData umlLinkEndDestructionData,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlLinkEndDestructionData.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.StructuredActivityNode umlStructuredActivityNode,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlStructuredActivityNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InvocationAction umlInvocationAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInvocationAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.RaiseExceptionAction umlRaiseExceptionAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlRaiseExceptionAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.TemplateParameterSubstitution umlTemplateParameterSubstitution,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlTemplateParameterSubstitution.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.VariableAction umlVariableAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlVariableAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ReadLinkAction umlReadLinkAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlReadLinkAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TimeEvent umlTimeEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTimeEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InstanceSpecification umlInstanceSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlInstanceSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.State umlState, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlState.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Usage umlUsage, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlUsage.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.BehavioredClassifier umlBehavioredClassifier,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlBehavioredClassifier.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CentralBufferNode umlCentralBufferNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlCentralBufferNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.PrimitiveType umlPrimitiveType, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlPrimitiveType.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TimeExpression umlTimeExpression, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTimeExpression.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InterfaceRealization umlInterfaceRealization,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlInterfaceRealization.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CreateLinkAction umlCreateLinkAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlCreateLinkAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ExceptionHandler umlExceptionHandler, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExceptionHandler.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ReadExtentAction umlReadExtentAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlReadExtentAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ChangeEvent umlChangeEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlChangeEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.StructuralFeatureAction umlStructuralFeatureAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlStructuralFeatureAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.MessageEvent umlMessageEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlMessageEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.EncapsulatedClassifier umlEncapsulatedClassifier,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlEncapsulatedClassifier.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ActivityGroup umlActivityGroup, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlActivityGroup.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CreateObjectAction umlCreateObjectAction,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlCreateObjectAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InitialNode umlInitialNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInitialNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Realization umlRealization, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlRealization.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Abstraction umlAbstraction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlAbstraction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InteractionUse umlInteractionUse, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInteractionUse.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Trigger umlTrigger, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTrigger.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InformationFlow umlInformationFlow, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlInformationFlow.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Dependency umlDependency, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDependency.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.WriteLinkAction umlWriteLinkAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlWriteLinkAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Package umlPackage, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlPackage.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TemplateParameter umlTemplateParameter, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTemplateParameter.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LinkAction umlLinkAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlLinkAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DataType umlDataType, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDataType.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InteractionOperand umlInteractionOperand,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlInteractionOperand.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Vertex umlVertex, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlVertex.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.StructuredClassifier umlStructuredClassifier,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlStructuredClassifier.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.OpaqueExpression umlOpaqueExpression, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlOpaqueExpression.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DeploymentTarget umlDeploymentTarget, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDeploymentTarget.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ExecutionEvent umlExecutionEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExecutionEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Classifier umlClassifier, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlClassifier.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.MergeNode umlMergeNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlMergeNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ActivityEdge umlActivityEdge, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlActivityEdge.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Action umlAction, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlAction.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ValueSpecification umlValueSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlValueSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.CollaborationUse umlCollaborationUse, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlCollaborationUse.getOwnedElements(), targetMdaModel);
    }

    public void visit(
            org.eclipse.uml2.uml.ActionExecutionSpecification umlActionExecutionSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlActionExecutionSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ForkNode umlForkNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlForkNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Lifeline umlLifeline, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlLifeline.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Connector umlConnector, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlConnector.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InteractionConstraint umlInteractionConstraint,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlInteractionConstraint.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ControlNode umlControlNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlControlNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ObjectNode umlObjectNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlObjectNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TypedElement umlTypedElement, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTypedElement.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DeployedArtifact umlDeployedArtifact, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlDeployedArtifact.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ExecutableNode umlExecutableNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlExecutableNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Constraint umlConstraint, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlConstraint.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Type umlType, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlType.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Event umlEvent, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlEvent.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ExecutionSpecification umlExecutionSpecification,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlExecutionSpecification.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.PackageableElement umlPackageableElement,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlPackageableElement.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ParameterableElement umlParameterableElement,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlParameterableElement.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.InteractionFragment umlInteractionFragment,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlInteractionFragment.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.ActivityNode umlActivityNode, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlActivityNode.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Feature umlFeature, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlFeature.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Gate umlGate, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlGate.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TemplateBinding umlTemplateBinding, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlTemplateBinding.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.RedefinableElement umlRedefinableElement,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlRedefinableElement.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Namespace umlNamespace, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlNamespace.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.DirectedRelationship umlDirectedRelationship,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlDirectedRelationship.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.Relationship umlRelationship, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlRelationship.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.LinkEndData umlLinkEndData, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlLinkEndData.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.MessageEnd umlMessageEnd, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlMessageEnd.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.TemplateableElement umlTemplateableElement,
            M targetMdaModel) throws UmlVisitorException {
        visit(umlTemplateableElement.getOwnedElements(), targetMdaModel);
    }

    public void visit(org.eclipse.uml2.uml.NamedElement umlNamedElement, M targetMdaModel)
            throws UmlVisitorException {
        visit(umlNamedElement.getOwnedElements(), targetMdaModel);
    }

    public final void visit(org.eclipse.uml2.uml.Element umlElement, M targetMdaModel)
            throws UmlVisitorException {
        if (umlElement instanceof org.eclipse.uml2.uml.Duration) {
            visit((org.eclipse.uml2.uml.Duration) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReclassifyObjectAction) {
            visit((org.eclipse.uml2.uml.ReclassifyObjectAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ProtocolStateMachine) {
            visit((org.eclipse.uml2.uml.ProtocolStateMachine) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MessageOccurrenceSpecification) {
            visit((org.eclipse.uml2.uml.MessageOccurrenceSpecification) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Extension) {
            visit((org.eclipse.uml2.uml.Extension) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExtensionEnd) {
            visit((org.eclipse.uml2.uml.ExtensionEnd) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralString) {
            visit((org.eclipse.uml2.uml.LiteralString) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Interaction) {
            visit((org.eclipse.uml2.uml.Interaction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.QualifierValue) {
            visit((org.eclipse.uml2.uml.QualifierValue) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Pseudostate) {
            visit((org.eclipse.uml2.uml.Pseudostate) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConsiderIgnoreFragment) {
            visit((org.eclipse.uml2.uml.ConsiderIgnoreFragment) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ParameterSet) {
            visit((org.eclipse.uml2.uml.ParameterSet) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CommunicationPath) {
            visit((org.eclipse.uml2.uml.CommunicationPath) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Interface) {
            visit((org.eclipse.uml2.uml.Interface) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Operation) {
            visit((org.eclipse.uml2.uml.Operation) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CallBehaviorAction) {
            visit((org.eclipse.uml2.uml.CallBehaviorAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StateMachine) {
            visit((org.eclipse.uml2.uml.StateMachine) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ValuePin) {
            visit((org.eclipse.uml2.uml.ValuePin) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.BroadcastSignalAction) {
            visit((org.eclipse.uml2.uml.BroadcastSignalAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Slot) {
            visit((org.eclipse.uml2.uml.Slot) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AnyReceiveEvent) {
            visit((org.eclipse.uml2.uml.AnyReceiveEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Parameter) {
            visit((org.eclipse.uml2.uml.Parameter) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Port) {
            visit((org.eclipse.uml2.uml.Port) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TimeInterval) {
            visit((org.eclipse.uml2.uml.TimeInterval) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Region) {
            visit((org.eclipse.uml2.uml.Region) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityFinalNode) {
            visit((org.eclipse.uml2.uml.ActivityFinalNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AddVariableValueAction) {
            visit((org.eclipse.uml2.uml.AddVariableValueAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Message) {
            visit((org.eclipse.uml2.uml.Message) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CallOperationAction) {
            visit((org.eclipse.uml2.uml.CallOperationAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Signal) {
            visit((org.eclipse.uml2.uml.Signal) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActionInputPin) {
            visit((org.eclipse.uml2.uml.ActionInputPin) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Actor) {
            visit((org.eclipse.uml2.uml.Actor) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.FunctionBehavior) {
            visit((org.eclipse.uml2.uml.FunctionBehavior) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DurationInterval) {
            visit((org.eclipse.uml2.uml.DurationInterval) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DestroyLinkAction) {
            visit((org.eclipse.uml2.uml.DestroyLinkAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Device) {
            visit((org.eclipse.uml2.uml.Device) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OpaqueBehavior) {
            visit((org.eclipse.uml2.uml.OpaqueBehavior) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Variable) {
            visit((org.eclipse.uml2.uml.Variable) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ProfileApplication) {
            visit((org.eclipse.uml2.uml.ProfileApplication) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExtensionPoint) {
            visit((org.eclipse.uml2.uml.ExtensionPoint) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StringExpression) {
            visit((org.eclipse.uml2.uml.StringExpression) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.GeneralOrdering) {
            visit((org.eclipse.uml2.uml.GeneralOrdering) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StartClassifierBehaviorAction) {
            visit((org.eclipse.uml2.uml.StartClassifierBehaviorAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.FlowFinalNode) {
            visit((org.eclipse.uml2.uml.FlowFinalNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.GeneralizationSet) {
            visit((org.eclipse.uml2.uml.GeneralizationSet) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityPartition) {
            visit((org.eclipse.uml2.uml.ActivityPartition) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SendObjectAction) {
            visit((org.eclipse.uml2.uml.SendObjectAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConnectionPointReference) {
            visit((org.eclipse.uml2.uml.ConnectionPointReference) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Collaboration) {
            visit((org.eclipse.uml2.uml.Collaboration) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Deployment) {
            visit((org.eclipse.uml2.uml.Deployment) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ClassifierTemplateParameter) {
            visit((org.eclipse.uml2.uml.ClassifierTemplateParameter) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ProtocolTransition) {
            visit((org.eclipse.uml2.uml.ProtocolTransition) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadStructuralFeatureAction) {
            visit((org.eclipse.uml2.uml.ReadStructuralFeatureAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Component) {
            visit((org.eclipse.uml2.uml.Component) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SendSignalEvent) {
            visit((org.eclipse.uml2.uml.SendSignalEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CreateLinkObjectAction) {
            visit((org.eclipse.uml2.uml.CreateLinkObjectAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralUnlimitedNatural) {
            visit((org.eclipse.uml2.uml.LiteralUnlimitedNatural) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralBoolean) {
            visit((org.eclipse.uml2.uml.LiteralBoolean) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Generalization) {
            visit((org.eclipse.uml2.uml.Generalization) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DurationConstraint) {
            visit((org.eclipse.uml2.uml.DurationConstraint) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Property) {
            visit((org.eclipse.uml2.uml.Property) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AcceptCallAction) {
            visit((org.eclipse.uml2.uml.AcceptCallAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AssociationClass) {
            visit((org.eclipse.uml2.uml.AssociationClass) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.UseCase) {
            visit((org.eclipse.uml2.uml.UseCase) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Association) {
            visit((org.eclipse.uml2.uml.Association) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SendSignalAction) {
            visit((org.eclipse.uml2.uml.SendSignalAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadVariableAction) {
            visit((org.eclipse.uml2.uml.ReadVariableAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SequenceNode) {
            visit((org.eclipse.uml2.uml.SequenceNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConnectorEnd) {
            visit((org.eclipse.uml2.uml.ConnectorEnd) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TimeConstraint) {
            visit((org.eclipse.uml2.uml.TimeConstraint) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Include) {
            visit((org.eclipse.uml2.uml.Include) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PartDecomposition) {
            visit((org.eclipse.uml2.uml.PartDecomposition) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StateInvariant) {
            visit((org.eclipse.uml2.uml.StateInvariant) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CreationEvent) {
            visit((org.eclipse.uml2.uml.CreationEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Manifestation) {
            visit((org.eclipse.uml2.uml.Manifestation) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralNull) {
            visit((org.eclipse.uml2.uml.LiteralNull) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.BehaviorExecutionSpecification) {
            visit((org.eclipse.uml2.uml.BehaviorExecutionSpecification) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadIsClassifiedObjectAction) {
            visit((org.eclipse.uml2.uml.ReadIsClassifiedObjectAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SendOperationEvent) {
            visit((org.eclipse.uml2.uml.SendOperationEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Enumeration) {
            visit((org.eclipse.uml2.uml.Enumeration) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InputPin) {
            visit((org.eclipse.uml2.uml.InputPin) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction) {
            visit((org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction) umlElement,
                    targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AcceptEventAction) {
            visit((org.eclipse.uml2.uml.AcceptEventAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Comment) {
            visit((org.eclipse.uml2.uml.Comment) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.IntervalConstraint) {
            visit((org.eclipse.uml2.uml.IntervalConstraint) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TestIdentityAction) {
            visit((org.eclipse.uml2.uml.TestIdentityAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralInteger) {
            visit((org.eclipse.uml2.uml.LiteralInteger) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutionOccurrenceSpecification) {
            visit((org.eclipse.uml2.uml.ExecutionOccurrenceSpecification) umlElement,
                    targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.FinalState) {
            visit((org.eclipse.uml2.uml.FinalState) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Reception) {
            visit((org.eclipse.uml2.uml.Reception) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Activity) {
            visit((org.eclipse.uml2.uml.Activity) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Clause) {
            visit((org.eclipse.uml2.uml.Clause) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OccurrenceSpecification) {
            visit((org.eclipse.uml2.uml.OccurrenceSpecification) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ClearAssociationAction) {
            visit((org.eclipse.uml2.uml.ClearAssociationAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Substitution) {
            visit((org.eclipse.uml2.uml.Substitution) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DestructionEvent) {
            visit((org.eclipse.uml2.uml.DestructionEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CallEvent) {
            visit((org.eclipse.uml2.uml.CallEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConnectableElement) {
            visit((org.eclipse.uml2.uml.ConnectableElement) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.AddStructuralFeatureValueAction) {
            visit((org.eclipse.uml2.uml.AddStructuralFeatureValueAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Behavior) {
            visit((org.eclipse.uml2.uml.Behavior) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RemoveVariableValueAction) {
            visit((org.eclipse.uml2.uml.RemoveVariableValueAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LoopNode) {
            visit((org.eclipse.uml2.uml.LoopNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadSelfAction) {
            visit((org.eclipse.uml2.uml.ReadSelfAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Interval) {
            visit((org.eclipse.uml2.uml.Interval) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DecisionNode) {
            visit((org.eclipse.uml2.uml.DecisionNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DestroyObjectAction) {
            visit((org.eclipse.uml2.uml.DestroyObjectAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ClearStructuralFeatureAction) {
            visit((org.eclipse.uml2.uml.ClearStructuralFeatureAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.WriteStructuralFeatureAction) {
            visit((org.eclipse.uml2.uml.WriteStructuralFeatureAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ClearVariableAction) {
            visit((org.eclipse.uml2.uml.ClearVariableAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.FinalNode) {
            visit((org.eclipse.uml2.uml.FinalNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InformationItem) {
            visit((org.eclipse.uml2.uml.InformationItem) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.BehavioralFeature) {
            visit((org.eclipse.uml2.uml.BehavioralFeature) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Transition) {
            visit((org.eclipse.uml2.uml.Transition) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ProtocolConformance) {
            visit((org.eclipse.uml2.uml.ProtocolConformance) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Stereotype) {
            visit((org.eclipse.uml2.uml.Stereotype) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DataStoreNode) {
            visit((org.eclipse.uml2.uml.DataStoreNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.EnumerationLiteral) {
            visit((org.eclipse.uml2.uml.EnumerationLiteral) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OpaqueAction) {
            visit((org.eclipse.uml2.uml.OpaqueAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Profile) {
            visit((org.eclipse.uml2.uml.Profile) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConnectableElementTemplateParameter) {
            visit((org.eclipse.uml2.uml.ConnectableElementTemplateParameter) umlElement,
                    targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DeploymentSpecification) {
            visit((org.eclipse.uml2.uml.DeploymentSpecification) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OutputPin) {
            visit((org.eclipse.uml2.uml.OutputPin) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LiteralSpecification) {
            visit((org.eclipse.uml2.uml.LiteralSpecification) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RedefinableTemplateSignature) {
            visit((org.eclipse.uml2.uml.RedefinableTemplateSignature) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ValueSpecificationAction) {
            visit((org.eclipse.uml2.uml.ValueSpecificationAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction) {
            visit((org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction) umlElement,
                    targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Extend) {
            visit((org.eclipse.uml2.uml.Extend) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.SignalEvent) {
            visit((org.eclipse.uml2.uml.SignalEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OperationTemplateParameter) {
            visit((org.eclipse.uml2.uml.OperationTemplateParameter) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExpansionRegion) {
            visit((org.eclipse.uml2.uml.ExpansionRegion) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExpansionNode) {
            visit((org.eclipse.uml2.uml.ExpansionNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PackageMerge) {
            visit((org.eclipse.uml2.uml.PackageMerge) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.JoinNode) {
            visit((org.eclipse.uml2.uml.JoinNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.UnmarshallAction) {
            visit((org.eclipse.uml2.uml.UnmarshallAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CallAction) {
            visit((org.eclipse.uml2.uml.CallAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReplyAction) {
            visit((org.eclipse.uml2.uml.ReplyAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutionEnvironment) {
            visit((org.eclipse.uml2.uml.ExecutionEnvironment) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ElementImport) {
            visit((org.eclipse.uml2.uml.ElementImport) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Artifact) {
            visit((org.eclipse.uml2.uml.Artifact) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CombinedFragment) {
            visit((org.eclipse.uml2.uml.CombinedFragment) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Continuation) {
            visit((org.eclipse.uml2.uml.Continuation) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Model) {
            visit((org.eclipse.uml2.uml.Model) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StructuralFeature) {
            visit((org.eclipse.uml2.uml.StructuralFeature) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateSignature) {
            visit((org.eclipse.uml2.uml.TemplateSignature) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ConditionalNode) {
            visit((org.eclipse.uml2.uml.ConditionalNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InstanceValue) {
            visit((org.eclipse.uml2.uml.InstanceValue) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Expression) {
            visit((org.eclipse.uml2.uml.Expression) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Node) {
            visit((org.eclipse.uml2.uml.Node) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.WriteVariableAction) {
            visit((org.eclipse.uml2.uml.WriteVariableAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ControlFlow) {
            visit((org.eclipse.uml2.uml.ControlFlow) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityParameterNode) {
            visit((org.eclipse.uml2.uml.ActivityParameterNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LinkEndCreationData) {
            visit((org.eclipse.uml2.uml.LinkEndCreationData) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadLinkObjectEndAction) {
            visit((org.eclipse.uml2.uml.ReadLinkObjectEndAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PackageImport) {
            visit((org.eclipse.uml2.uml.PackageImport) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Class) {
            visit((org.eclipse.uml2.uml.Class) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Pin) {
            visit((org.eclipse.uml2.uml.Pin) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InterruptibleActivityRegion) {
            visit((org.eclipse.uml2.uml.InterruptibleActivityRegion) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MultiplicityElement) {
            visit((org.eclipse.uml2.uml.MultiplicityElement) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ObjectFlow) {
            visit((org.eclipse.uml2.uml.ObjectFlow) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LinkEndDestructionData) {
            visit((org.eclipse.uml2.uml.LinkEndDestructionData) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StructuredActivityNode) {
            visit((org.eclipse.uml2.uml.StructuredActivityNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InvocationAction) {
            visit((org.eclipse.uml2.uml.InvocationAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RaiseExceptionAction) {
            visit((org.eclipse.uml2.uml.RaiseExceptionAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateParameterSubstitution) {
            visit((org.eclipse.uml2.uml.TemplateParameterSubstitution) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.VariableAction) {
            visit((org.eclipse.uml2.uml.VariableAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadLinkAction) {
            visit((org.eclipse.uml2.uml.ReadLinkAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TimeEvent) {
            visit((org.eclipse.uml2.uml.TimeEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InstanceSpecification) {
            visit((org.eclipse.uml2.uml.InstanceSpecification) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.State) {
            visit((org.eclipse.uml2.uml.State) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Usage) {
            visit((org.eclipse.uml2.uml.Usage) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.BehavioredClassifier) {
            visit((org.eclipse.uml2.uml.BehavioredClassifier) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CentralBufferNode) {
            visit((org.eclipse.uml2.uml.CentralBufferNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PrimitiveType) {
            visit((org.eclipse.uml2.uml.PrimitiveType) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TimeExpression) {
            visit((org.eclipse.uml2.uml.TimeExpression) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InterfaceRealization) {
            visit((org.eclipse.uml2.uml.InterfaceRealization) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CreateLinkAction) {
            visit((org.eclipse.uml2.uml.CreateLinkAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExceptionHandler) {
            visit((org.eclipse.uml2.uml.ExceptionHandler) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ReadExtentAction) {
            visit((org.eclipse.uml2.uml.ReadExtentAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ChangeEvent) {
            visit((org.eclipse.uml2.uml.ChangeEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StructuralFeatureAction) {
            visit((org.eclipse.uml2.uml.StructuralFeatureAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MessageEvent) {
            visit((org.eclipse.uml2.uml.MessageEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.EncapsulatedClassifier) {
            visit((org.eclipse.uml2.uml.EncapsulatedClassifier) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityGroup) {
            visit((org.eclipse.uml2.uml.ActivityGroup) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CreateObjectAction) {
            visit((org.eclipse.uml2.uml.CreateObjectAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InitialNode) {
            visit((org.eclipse.uml2.uml.InitialNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Realization) {
            visit((org.eclipse.uml2.uml.Realization) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Abstraction) {
            visit((org.eclipse.uml2.uml.Abstraction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InteractionUse) {
            visit((org.eclipse.uml2.uml.InteractionUse) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Trigger) {
            visit((org.eclipse.uml2.uml.Trigger) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InformationFlow) {
            visit((org.eclipse.uml2.uml.InformationFlow) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Dependency) {
            visit((org.eclipse.uml2.uml.Dependency) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.WriteLinkAction) {
            visit((org.eclipse.uml2.uml.WriteLinkAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Package) {
            visit((org.eclipse.uml2.uml.Package) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateParameter) {
            visit((org.eclipse.uml2.uml.TemplateParameter) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LinkAction) {
            visit((org.eclipse.uml2.uml.LinkAction) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DataType) {
            visit((org.eclipse.uml2.uml.DataType) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InteractionOperand) {
            visit((org.eclipse.uml2.uml.InteractionOperand) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Vertex) {
            visit((org.eclipse.uml2.uml.Vertex) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.StructuredClassifier) {
            visit((org.eclipse.uml2.uml.StructuredClassifier) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.OpaqueExpression) {
            visit((org.eclipse.uml2.uml.OpaqueExpression) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DeploymentTarget) {
            visit((org.eclipse.uml2.uml.DeploymentTarget) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutionEvent) {
            visit((org.eclipse.uml2.uml.ExecutionEvent) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Classifier) {
            visit((org.eclipse.uml2.uml.Classifier) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MergeNode) {
            visit((org.eclipse.uml2.uml.MergeNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityEdge) {
            visit((org.eclipse.uml2.uml.ActivityEdge) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Action) {
            visit((org.eclipse.uml2.uml.Action) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ValueSpecification) {
            visit((org.eclipse.uml2.uml.ValueSpecification) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.CollaborationUse) {
            visit((org.eclipse.uml2.uml.CollaborationUse) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActionExecutionSpecification) {
            visit((org.eclipse.uml2.uml.ActionExecutionSpecification) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ForkNode) {
            visit((org.eclipse.uml2.uml.ForkNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Lifeline) {
            visit((org.eclipse.uml2.uml.Lifeline) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Connector) {
            visit((org.eclipse.uml2.uml.Connector) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InteractionConstraint) {
            visit((org.eclipse.uml2.uml.InteractionConstraint) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ControlNode) {
            visit((org.eclipse.uml2.uml.ControlNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ObjectNode) {
            visit((org.eclipse.uml2.uml.ObjectNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TypedElement) {
            visit((org.eclipse.uml2.uml.TypedElement) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DeployedArtifact) {
            visit((org.eclipse.uml2.uml.DeployedArtifact) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutableNode) {
            visit((org.eclipse.uml2.uml.ExecutableNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Constraint) {
            visit((org.eclipse.uml2.uml.Constraint) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Type) {
            visit((org.eclipse.uml2.uml.Type) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Event) {
            visit((org.eclipse.uml2.uml.Event) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ExecutionSpecification) {
            visit((org.eclipse.uml2.uml.ExecutionSpecification) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.PackageableElement) {
            visit((org.eclipse.uml2.uml.PackageableElement) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ParameterableElement) {
            visit((org.eclipse.uml2.uml.ParameterableElement) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.InteractionFragment) {
            visit((org.eclipse.uml2.uml.InteractionFragment) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.ActivityNode) {
            visit((org.eclipse.uml2.uml.ActivityNode) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Feature) {
            visit((org.eclipse.uml2.uml.Feature) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Gate) {
            visit((org.eclipse.uml2.uml.Gate) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateBinding) {
            visit((org.eclipse.uml2.uml.TemplateBinding) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.RedefinableElement) {
            visit((org.eclipse.uml2.uml.RedefinableElement) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Namespace) {
            visit((org.eclipse.uml2.uml.Namespace) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.DirectedRelationship) {
            visit((org.eclipse.uml2.uml.DirectedRelationship) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.Relationship) {
            visit((org.eclipse.uml2.uml.Relationship) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.LinkEndData) {
            visit((org.eclipse.uml2.uml.LinkEndData) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.MessageEnd) {
            visit((org.eclipse.uml2.uml.MessageEnd) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.TemplateableElement) {
            visit((org.eclipse.uml2.uml.TemplateableElement) umlElement, targetMdaModel);
        } else if (umlElement instanceof org.eclipse.uml2.uml.NamedElement) {
            visit((org.eclipse.uml2.uml.NamedElement) umlElement, targetMdaModel);
        } else {
            logger.warning(umlElement.getClass().getName(), " : not yet supported");
        }
    }

    // GENERATED CODE END.
    // ////////////////////////////////////////////////////////////////////////////////////////////

    public final void visit(
            org.eclipse.emf.common.util.EList<org.eclipse.uml2.uml.Element> elementList,
            M targetMdaModel) throws UmlVisitorException {
        for (int i = 0; i < elementList.size(); i++) {
            visit(elementList.get(i), targetMdaModel);
        }
    }
}
