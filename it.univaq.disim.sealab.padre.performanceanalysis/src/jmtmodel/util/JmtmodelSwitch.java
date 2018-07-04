/**
 */
package jmtmodel.util;

import jmtmodel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see jmtmodel.JmtmodelPackage
 * @generated
 */
public class JmtmodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JmtmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JmtmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = JmtmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case JmtmodelPackage.BLOCKING_REGION_TYPE: {
				BlockingRegionType blockingRegionType = (BlockingRegionType)theEObject;
				T result = caseBlockingRegionType(blockingRegionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE: {
				ClassConstraintType classConstraintType = (ClassConstraintType)theEObject;
				T result = caseClassConstraintType(classConstraintType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.CLASSES_TYPE: {
				ClassesType classesType = (ClassesType)theEObject;
				T result = caseClassesType(classesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.CLASSRESULTS_TYPE: {
				ClassresultsType classresultsType = (ClassresultsType)theEObject;
				T result = caseClassresultsType(classresultsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.CLASSRESULTS_TYPE1: {
				ClassresultsType1 classresultsType1 = (ClassresultsType1)theEObject;
				T result = caseClassresultsType1(classresultsType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.CLASS_WEIGHT_TYPE: {
				ClassWeightType classWeightType = (ClassWeightType)theEObject;
				T result = caseClassWeightType(classWeightType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.CLOSEDCLASS_TYPE: {
				ClosedclassType closedclassType = (ClosedclassType)theEObject;
				T result = caseClosedclassType(closedclassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.DELAYSTATION_TYPE: {
				DelaystationType delaystationType = (DelaystationType)theEObject;
				T result = caseDelaystationType(delaystationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.DROP_RULES_TYPE: {
				DropRulesType dropRulesType = (DropRulesType)theEObject;
				T result = caseDropRulesType(dropRulesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.GLOBAL_CONSTRAINT_TYPE: {
				GlobalConstraintType globalConstraintType = (GlobalConstraintType)theEObject;
				T result = caseGlobalConstraintType(globalConstraintType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.LDSTATION_TYPE: {
				LdstationType ldstationType = (LdstationType)theEObject;
				T result = caseLdstationType(ldstationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.LISTATION_TYPE: {
				ListationType listationType = (ListationType)theEObject;
				T result = caseListationType(listationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.MEASURE_TYPE: {
				MeasureType measureType = (MeasureType)theEObject;
				T result = caseMeasureType(measureType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.MEASURE_TYPE1: {
				MeasureType1 measureType1 = (MeasureType1)theEObject;
				T result = caseMeasureType1(measureType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.MODEL_TYPE: {
				ModelType modelType = (ModelType)theEObject;
				T result = caseModelType(modelType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.OPENCLASS_TYPE: {
				OpenclassType openclassType = (OpenclassType)theEObject;
				T result = caseOpenclassType(openclassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.PARAMETERS_TYPE: {
				ParametersType parametersType = (ParametersType)theEObject;
				T result = caseParametersType(parametersType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.REGION_NODE_TYPE: {
				RegionNodeType regionNodeType = (RegionNodeType)theEObject;
				T result = caseRegionNodeType(regionNodeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.REGIONRESULTS_TYPE: {
				RegionresultsType regionresultsType = (RegionresultsType)theEObject;
				T result = caseRegionresultsType(regionresultsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.SERVICETIMES_TYPE: {
				ServicetimesType servicetimesType = (ServicetimesType)theEObject;
				T result = caseServicetimesType(servicetimesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.SERVICETIMES_TYPE1: {
				ServicetimesType1 servicetimesType1 = (ServicetimesType1)theEObject;
				T result = caseServicetimesType1(servicetimesType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.SERVICETIMES_TYPE2: {
				ServicetimesType2 servicetimesType2 = (ServicetimesType2)theEObject;
				T result = caseServicetimesType2(servicetimesType2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.SERVICETIMES_TYPE3: {
				ServicetimesType3 servicetimesType3 = (ServicetimesType3)theEObject;
				T result = caseServicetimesType3(servicetimesType3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.SERVICETIME_TYPE: {
				ServicetimeType servicetimeType = (ServicetimeType)theEObject;
				T result = caseServicetimeType(servicetimeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.SERVICETIME_TYPE1: {
				ServicetimeType1 servicetimeType1 = (ServicetimeType1)theEObject;
				T result = caseServicetimeType1(servicetimeType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.SOLUTIONS_TYPE: {
				SolutionsType solutionsType = (SolutionsType)theEObject;
				T result = caseSolutionsType(solutionsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.STATIONRESULTS_TYPE: {
				StationresultsType stationresultsType = (StationresultsType)theEObject;
				T result = caseStationresultsType(stationresultsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.STATIONS_TYPE: {
				StationsType stationsType = (StationsType)theEObject;
				T result = caseStationsType(stationsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.VISITS_TYPE: {
				VisitsType visitsType = (VisitsType)theEObject;
				T result = caseVisitsType(visitsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.VISITS_TYPE1: {
				VisitsType1 visitsType1 = (VisitsType1)theEObject;
				T result = caseVisitsType1(visitsType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.VISITS_TYPE2: {
				VisitsType2 visitsType2 = (VisitsType2)theEObject;
				T result = caseVisitsType2(visitsType2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.VISIT_TYPE: {
				VisitType visitType = (VisitType)theEObject;
				T result = caseVisitType(visitType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.VISIT_TYPE1: {
				VisitType1 visitType1 = (VisitType1)theEObject;
				T result = caseVisitType1(visitType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.VISIT_TYPE2: {
				VisitType2 visitType2 = (VisitType2)theEObject;
				T result = caseVisitType2(visitType2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.WHAT_IF_TYPE: {
				WhatIfType whatIfType = (WhatIfType)theEObject;
				T result = caseWhatIfType(whatIfType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.REFERENCE_STATION_TYPE: {
				ReferenceStationType referenceStationType = (ReferenceStationType)theEObject;
				T result = caseReferenceStationType(referenceStationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JmtmodelPackage.CLASS_TYPE: {
				ClassType classType = (ClassType)theEObject;
				T result = caseClassType(classType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blocking Region Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blocking Region Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockingRegionType(BlockingRegionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Constraint Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Constraint Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassConstraintType(ClassConstraintType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classes Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classes Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassesType(ClassesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classresults Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classresults Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassresultsType(ClassresultsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classresults Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classresults Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassresultsType1(ClassresultsType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Weight Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Weight Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassWeightType(ClassWeightType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Closedclass Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Closedclass Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClosedclassType(ClosedclassType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delaystation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delaystation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelaystationType(DelaystationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Drop Rules Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Drop Rules Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDropRulesType(DropRulesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Constraint Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Constraint Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalConstraintType(GlobalConstraintType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ldstation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ldstation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLdstationType(LdstationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Listation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Listation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListationType(ListationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measure Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measure Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasureType(MeasureType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measure Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measure Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasureType1(MeasureType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelType(ModelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Openclass Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Openclass Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenclassType(OpenclassType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameters Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameters Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParametersType(ParametersType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Region Node Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Region Node Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegionNodeType(RegionNodeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regionresults Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regionresults Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegionresultsType(RegionresultsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Servicetimes Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Servicetimes Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServicetimesType(ServicetimesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Servicetimes Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Servicetimes Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServicetimesType1(ServicetimesType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Servicetimes Type2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Servicetimes Type2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServicetimesType2(ServicetimesType2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Servicetimes Type3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Servicetimes Type3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServicetimesType3(ServicetimesType3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Servicetime Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Servicetime Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServicetimeType(ServicetimeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Servicetime Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Servicetime Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServicetimeType1(ServicetimeType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solutions Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solutions Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolutionsType(SolutionsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stationresults Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stationresults Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStationresultsType(StationresultsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stations Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stations Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStationsType(StationsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visits Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visits Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitsType(VisitsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visits Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visits Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitsType1(VisitsType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visits Type2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visits Type2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitsType2(VisitsType2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visit Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visit Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitType(VisitType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visit Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visit Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitType1(VisitType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visit Type2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visit Type2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitType2(VisitType2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>What If Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>What If Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhatIfType(WhatIfType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Station Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Station Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceStationType(ReferenceStationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassType(ClassType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //JmtmodelSwitch
