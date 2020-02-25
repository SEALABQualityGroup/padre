/**
 */
package jmtmodel.impl;

import jmtmodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JmtmodelFactoryImpl extends EFactoryImpl implements JmtmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JmtmodelFactory init() {
		try {
			JmtmodelFactory theJmtmodelFactory = (JmtmodelFactory)EPackage.Registry.INSTANCE.getEFactory(JmtmodelPackage.eNS_URI);
			if (theJmtmodelFactory != null) {
				return theJmtmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JmtmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JmtmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JmtmodelPackage.BLOCKING_REGION_TYPE: return createBlockingRegionType();
			case JmtmodelPackage.CLASS_CONSTRAINT_TYPE: return createClassConstraintType();
			case JmtmodelPackage.CLASSES_TYPE: return createClassesType();
			case JmtmodelPackage.CLASSRESULTS_TYPE: return createClassresultsType();
			case JmtmodelPackage.CLASSRESULTS_TYPE1: return createClassresultsType1();
			case JmtmodelPackage.CLASS_WEIGHT_TYPE: return createClassWeightType();
			case JmtmodelPackage.CLOSEDCLASS_TYPE: return createClosedclassType();
			case JmtmodelPackage.DELAYSTATION_TYPE: return createDelaystationType();
			case JmtmodelPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case JmtmodelPackage.DROP_RULES_TYPE: return createDropRulesType();
			case JmtmodelPackage.GLOBAL_CONSTRAINT_TYPE: return createGlobalConstraintType();
			case JmtmodelPackage.LDSTATION_TYPE: return createLdstationType();
			case JmtmodelPackage.LISTATION_TYPE: return createListationType();
			case JmtmodelPackage.MEASURE_TYPE: return createMeasureType();
			case JmtmodelPackage.MEASURE_TYPE1: return createMeasureType1();
			case JmtmodelPackage.MODEL_TYPE: return createModelType();
			case JmtmodelPackage.OPENCLASS_TYPE: return createOpenclassType();
			case JmtmodelPackage.PARAMETERS_TYPE: return createParametersType();
			case JmtmodelPackage.REGION_NODE_TYPE: return createRegionNodeType();
			case JmtmodelPackage.REGIONRESULTS_TYPE: return createRegionresultsType();
			case JmtmodelPackage.SERVICETIMES_TYPE: return createServicetimesType();
			case JmtmodelPackage.SERVICETIMES_TYPE1: return createServicetimesType1();
			case JmtmodelPackage.SERVICETIMES_TYPE2: return createServicetimesType2();
			case JmtmodelPackage.SERVICETIMES_TYPE3: return createServicetimesType3();
			case JmtmodelPackage.SERVICETIME_TYPE: return createServicetimeType();
			case JmtmodelPackage.SERVICETIME_TYPE1: return createServicetimeType1();
			case JmtmodelPackage.SOLUTIONS_TYPE: return createSolutionsType();
			case JmtmodelPackage.STATIONRESULTS_TYPE: return createStationresultsType();
			case JmtmodelPackage.STATIONS_TYPE: return createStationsType();
			case JmtmodelPackage.VISITS_TYPE: return createVisitsType();
			case JmtmodelPackage.VISITS_TYPE1: return createVisitsType1();
			case JmtmodelPackage.VISITS_TYPE2: return createVisitsType2();
			case JmtmodelPackage.VISIT_TYPE: return createVisitType();
			case JmtmodelPackage.VISIT_TYPE1: return createVisitType1();
			case JmtmodelPackage.VISIT_TYPE2: return createVisitType2();
			case JmtmodelPackage.WHAT_IF_TYPE: return createWhatIfType();
			case JmtmodelPackage.REFERENCE_STATION_TYPE: return createReferenceStationType();
			case JmtmodelPackage.CLASS_TYPE: return createClassType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockingRegionType createBlockingRegionType() {
		BlockingRegionTypeImpl blockingRegionType = new BlockingRegionTypeImpl();
		return blockingRegionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassConstraintType createClassConstraintType() {
		ClassConstraintTypeImpl classConstraintType = new ClassConstraintTypeImpl();
		return classConstraintType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassesType createClassesType() {
		ClassesTypeImpl classesType = new ClassesTypeImpl();
		return classesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassresultsType createClassresultsType() {
		ClassresultsTypeImpl classresultsType = new ClassresultsTypeImpl();
		return classresultsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassresultsType1 createClassresultsType1() {
		ClassresultsType1Impl classresultsType1 = new ClassresultsType1Impl();
		return classresultsType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassWeightType createClassWeightType() {
		ClassWeightTypeImpl classWeightType = new ClassWeightTypeImpl();
		return classWeightType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClosedclassType createClosedclassType() {
		ClosedclassTypeImpl closedclassType = new ClosedclassTypeImpl();
		return closedclassType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelaystationType createDelaystationType() {
		DelaystationTypeImpl delaystationType = new DelaystationTypeImpl();
		return delaystationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DropRulesType createDropRulesType() {
		DropRulesTypeImpl dropRulesType = new DropRulesTypeImpl();
		return dropRulesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalConstraintType createGlobalConstraintType() {
		GlobalConstraintTypeImpl globalConstraintType = new GlobalConstraintTypeImpl();
		return globalConstraintType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LdstationType createLdstationType() {
		LdstationTypeImpl ldstationType = new LdstationTypeImpl();
		return ldstationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListationType createListationType() {
		ListationTypeImpl listationType = new ListationTypeImpl();
		return listationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasureType createMeasureType() {
		MeasureTypeImpl measureType = new MeasureTypeImpl();
		return measureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasureType1 createMeasureType1() {
		MeasureType1Impl measureType1 = new MeasureType1Impl();
		return measureType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelType createModelType() {
		ModelTypeImpl modelType = new ModelTypeImpl();
		return modelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenclassType createOpenclassType() {
		OpenclassTypeImpl openclassType = new OpenclassTypeImpl();
		return openclassType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametersType createParametersType() {
		ParametersTypeImpl parametersType = new ParametersTypeImpl();
		return parametersType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionNodeType createRegionNodeType() {
		RegionNodeTypeImpl regionNodeType = new RegionNodeTypeImpl();
		return regionNodeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegionresultsType createRegionresultsType() {
		RegionresultsTypeImpl regionresultsType = new RegionresultsTypeImpl();
		return regionresultsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicetimesType createServicetimesType() {
		ServicetimesTypeImpl servicetimesType = new ServicetimesTypeImpl();
		return servicetimesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicetimesType1 createServicetimesType1() {
		ServicetimesType1Impl servicetimesType1 = new ServicetimesType1Impl();
		return servicetimesType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicetimesType2 createServicetimesType2() {
		ServicetimesType2Impl servicetimesType2 = new ServicetimesType2Impl();
		return servicetimesType2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicetimesType3 createServicetimesType3() {
		ServicetimesType3Impl servicetimesType3 = new ServicetimesType3Impl();
		return servicetimesType3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicetimeType createServicetimeType() {
		ServicetimeTypeImpl servicetimeType = new ServicetimeTypeImpl();
		return servicetimeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicetimeType1 createServicetimeType1() {
		ServicetimeType1Impl servicetimeType1 = new ServicetimeType1Impl();
		return servicetimeType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolutionsType createSolutionsType() {
		SolutionsTypeImpl solutionsType = new SolutionsTypeImpl();
		return solutionsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StationresultsType createStationresultsType() {
		StationresultsTypeImpl stationresultsType = new StationresultsTypeImpl();
		return stationresultsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StationsType createStationsType() {
		StationsTypeImpl stationsType = new StationsTypeImpl();
		return stationsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitsType createVisitsType() {
		VisitsTypeImpl visitsType = new VisitsTypeImpl();
		return visitsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitsType1 createVisitsType1() {
		VisitsType1Impl visitsType1 = new VisitsType1Impl();
		return visitsType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitsType2 createVisitsType2() {
		VisitsType2Impl visitsType2 = new VisitsType2Impl();
		return visitsType2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitType createVisitType() {
		VisitTypeImpl visitType = new VisitTypeImpl();
		return visitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitType1 createVisitType1() {
		VisitType1Impl visitType1 = new VisitType1Impl();
		return visitType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisitType2 createVisitType2() {
		VisitType2Impl visitType2 = new VisitType2Impl();
		return visitType2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhatIfType createWhatIfType() {
		WhatIfTypeImpl whatIfType = new WhatIfTypeImpl();
		return whatIfType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceStationType createReferenceStationType() {
		ReferenceStationTypeImpl referenceStationType = new ReferenceStationTypeImpl();
		return referenceStationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassType createClassType() {
		ClassTypeImpl classType = new ClassTypeImpl();
		return classType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JmtmodelPackage getJmtmodelPackage() {
		return (JmtmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JmtmodelPackage getPackage() {
		return JmtmodelPackage.eINSTANCE;
	}

} //JmtmodelFactoryImpl
