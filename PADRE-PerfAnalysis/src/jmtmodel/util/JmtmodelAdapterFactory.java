/**
 */
package jmtmodel.util;

import jmtmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see jmtmodel.JmtmodelPackage
 * @generated
 */
public class JmtmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JmtmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JmtmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = JmtmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JmtmodelSwitch<Adapter> modelSwitch =
		new JmtmodelSwitch<Adapter>() {
			@Override
			public Adapter caseBlockingRegionType(BlockingRegionType object) {
				return createBlockingRegionTypeAdapter();
			}
			@Override
			public Adapter caseClassConstraintType(ClassConstraintType object) {
				return createClassConstraintTypeAdapter();
			}
			@Override
			public Adapter caseClassesType(ClassesType object) {
				return createClassesTypeAdapter();
			}
			@Override
			public Adapter caseClassresultsType(ClassresultsType object) {
				return createClassresultsTypeAdapter();
			}
			@Override
			public Adapter caseClassresultsType1(ClassresultsType1 object) {
				return createClassresultsType1Adapter();
			}
			@Override
			public Adapter caseClassWeightType(ClassWeightType object) {
				return createClassWeightTypeAdapter();
			}
			@Override
			public Adapter caseClosedclassType(ClosedclassType object) {
				return createClosedclassTypeAdapter();
			}
			@Override
			public Adapter caseDelaystationType(DelaystationType object) {
				return createDelaystationTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseDropRulesType(DropRulesType object) {
				return createDropRulesTypeAdapter();
			}
			@Override
			public Adapter caseGlobalConstraintType(GlobalConstraintType object) {
				return createGlobalConstraintTypeAdapter();
			}
			@Override
			public Adapter caseLdstationType(LdstationType object) {
				return createLdstationTypeAdapter();
			}
			@Override
			public Adapter caseListationType(ListationType object) {
				return createListationTypeAdapter();
			}
			@Override
			public Adapter caseMeasureType(MeasureType object) {
				return createMeasureTypeAdapter();
			}
			@Override
			public Adapter caseMeasureType1(MeasureType1 object) {
				return createMeasureType1Adapter();
			}
			@Override
			public Adapter caseModelType(ModelType object) {
				return createModelTypeAdapter();
			}
			@Override
			public Adapter caseOpenclassType(OpenclassType object) {
				return createOpenclassTypeAdapter();
			}
			@Override
			public Adapter caseParametersType(ParametersType object) {
				return createParametersTypeAdapter();
			}
			@Override
			public Adapter caseRegionNodeType(RegionNodeType object) {
				return createRegionNodeTypeAdapter();
			}
			@Override
			public Adapter caseRegionresultsType(RegionresultsType object) {
				return createRegionresultsTypeAdapter();
			}
			@Override
			public Adapter caseServicetimesType(ServicetimesType object) {
				return createServicetimesTypeAdapter();
			}
			@Override
			public Adapter caseServicetimesType1(ServicetimesType1 object) {
				return createServicetimesType1Adapter();
			}
			@Override
			public Adapter caseServicetimesType2(ServicetimesType2 object) {
				return createServicetimesType2Adapter();
			}
			@Override
			public Adapter caseServicetimesType3(ServicetimesType3 object) {
				return createServicetimesType3Adapter();
			}
			@Override
			public Adapter caseServicetimeType(ServicetimeType object) {
				return createServicetimeTypeAdapter();
			}
			@Override
			public Adapter caseServicetimeType1(ServicetimeType1 object) {
				return createServicetimeType1Adapter();
			}
			@Override
			public Adapter caseSolutionsType(SolutionsType object) {
				return createSolutionsTypeAdapter();
			}
			@Override
			public Adapter caseStationresultsType(StationresultsType object) {
				return createStationresultsTypeAdapter();
			}
			@Override
			public Adapter caseStationsType(StationsType object) {
				return createStationsTypeAdapter();
			}
			@Override
			public Adapter caseVisitsType(VisitsType object) {
				return createVisitsTypeAdapter();
			}
			@Override
			public Adapter caseVisitsType1(VisitsType1 object) {
				return createVisitsType1Adapter();
			}
			@Override
			public Adapter caseVisitsType2(VisitsType2 object) {
				return createVisitsType2Adapter();
			}
			@Override
			public Adapter caseVisitType(VisitType object) {
				return createVisitTypeAdapter();
			}
			@Override
			public Adapter caseVisitType1(VisitType1 object) {
				return createVisitType1Adapter();
			}
			@Override
			public Adapter caseVisitType2(VisitType2 object) {
				return createVisitType2Adapter();
			}
			@Override
			public Adapter caseWhatIfType(WhatIfType object) {
				return createWhatIfTypeAdapter();
			}
			@Override
			public Adapter caseReferenceStationType(ReferenceStationType object) {
				return createReferenceStationTypeAdapter();
			}
			@Override
			public Adapter caseClassType(ClassType object) {
				return createClassTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.BlockingRegionType <em>Blocking Region Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.BlockingRegionType
	 * @generated
	 */
	public Adapter createBlockingRegionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ClassConstraintType <em>Class Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ClassConstraintType
	 * @generated
	 */
	public Adapter createClassConstraintTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ClassesType <em>Classes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ClassesType
	 * @generated
	 */
	public Adapter createClassesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ClassresultsType <em>Classresults Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ClassresultsType
	 * @generated
	 */
	public Adapter createClassresultsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ClassresultsType1 <em>Classresults Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ClassresultsType1
	 * @generated
	 */
	public Adapter createClassresultsType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ClassWeightType <em>Class Weight Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ClassWeightType
	 * @generated
	 */
	public Adapter createClassWeightTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ClosedclassType <em>Closedclass Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ClosedclassType
	 * @generated
	 */
	public Adapter createClosedclassTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.DelaystationType <em>Delaystation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.DelaystationType
	 * @generated
	 */
	public Adapter createDelaystationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.DropRulesType <em>Drop Rules Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.DropRulesType
	 * @generated
	 */
	public Adapter createDropRulesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.GlobalConstraintType <em>Global Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.GlobalConstraintType
	 * @generated
	 */
	public Adapter createGlobalConstraintTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.LdstationType <em>Ldstation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.LdstationType
	 * @generated
	 */
	public Adapter createLdstationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ListationType <em>Listation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ListationType
	 * @generated
	 */
	public Adapter createListationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.MeasureType <em>Measure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.MeasureType
	 * @generated
	 */
	public Adapter createMeasureTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.MeasureType1 <em>Measure Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.MeasureType1
	 * @generated
	 */
	public Adapter createMeasureType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ModelType
	 * @generated
	 */
	public Adapter createModelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.OpenclassType <em>Openclass Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.OpenclassType
	 * @generated
	 */
	public Adapter createOpenclassTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ParametersType <em>Parameters Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ParametersType
	 * @generated
	 */
	public Adapter createParametersTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.RegionNodeType <em>Region Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.RegionNodeType
	 * @generated
	 */
	public Adapter createRegionNodeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.RegionresultsType <em>Regionresults Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.RegionresultsType
	 * @generated
	 */
	public Adapter createRegionresultsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ServicetimesType <em>Servicetimes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ServicetimesType
	 * @generated
	 */
	public Adapter createServicetimesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ServicetimesType1 <em>Servicetimes Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ServicetimesType1
	 * @generated
	 */
	public Adapter createServicetimesType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ServicetimesType2 <em>Servicetimes Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ServicetimesType2
	 * @generated
	 */
	public Adapter createServicetimesType2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ServicetimesType3 <em>Servicetimes Type3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ServicetimesType3
	 * @generated
	 */
	public Adapter createServicetimesType3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ServicetimeType <em>Servicetime Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ServicetimeType
	 * @generated
	 */
	public Adapter createServicetimeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ServicetimeType1 <em>Servicetime Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ServicetimeType1
	 * @generated
	 */
	public Adapter createServicetimeType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.SolutionsType <em>Solutions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.SolutionsType
	 * @generated
	 */
	public Adapter createSolutionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.StationresultsType <em>Stationresults Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.StationresultsType
	 * @generated
	 */
	public Adapter createStationresultsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.StationsType <em>Stations Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.StationsType
	 * @generated
	 */
	public Adapter createStationsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.VisitsType <em>Visits Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.VisitsType
	 * @generated
	 */
	public Adapter createVisitsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.VisitsType1 <em>Visits Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.VisitsType1
	 * @generated
	 */
	public Adapter createVisitsType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.VisitsType2 <em>Visits Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.VisitsType2
	 * @generated
	 */
	public Adapter createVisitsType2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.VisitType <em>Visit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.VisitType
	 * @generated
	 */
	public Adapter createVisitTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.VisitType1 <em>Visit Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.VisitType1
	 * @generated
	 */
	public Adapter createVisitType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.VisitType2 <em>Visit Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.VisitType2
	 * @generated
	 */
	public Adapter createVisitType2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.WhatIfType <em>What If Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.WhatIfType
	 * @generated
	 */
	public Adapter createWhatIfTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ReferenceStationType <em>Reference Station Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ReferenceStationType
	 * @generated
	 */
	public Adapter createReferenceStationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link jmtmodel.ClassType <em>Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see jmtmodel.ClassType
	 * @generated
	 */
	public Adapter createClassTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //JmtmodelAdapterFactory
