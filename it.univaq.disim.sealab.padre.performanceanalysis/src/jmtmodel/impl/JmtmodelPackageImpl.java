/**
 */
package jmtmodel.impl;

import jmtmodel.BlockingRegionType;
import jmtmodel.ClassConstraintType;
import jmtmodel.ClassType;
import jmtmodel.ClassWeightType;
import jmtmodel.ClassesType;
import jmtmodel.ClassresultsType;
import jmtmodel.ClassresultsType1;
import jmtmodel.ClosedclassType;
import jmtmodel.DelaystationType;
import jmtmodel.DocumentRoot;
import jmtmodel.DropRulesType;
import jmtmodel.GlobalConstraintType;
import jmtmodel.JmtmodelFactory;
import jmtmodel.JmtmodelPackage;
import jmtmodel.LdstationType;
import jmtmodel.ListationType;
import jmtmodel.MeasureType;
import jmtmodel.MeasureType1;
import jmtmodel.ModelType;
import jmtmodel.OpenclassType;
import jmtmodel.ParametersType;
import jmtmodel.ReferenceStationType;
import jmtmodel.RegionNodeType;
import jmtmodel.RegionresultsType;
import jmtmodel.ServicetimeType;
import jmtmodel.ServicetimeType1;
import jmtmodel.ServicetimesType;
import jmtmodel.ServicetimesType1;
import jmtmodel.ServicetimesType2;
import jmtmodel.ServicetimesType3;
import jmtmodel.SolutionsType;
import jmtmodel.StationresultsType;
import jmtmodel.StationsType;
import jmtmodel.VisitType;
import jmtmodel.VisitType1;
import jmtmodel.VisitType2;
import jmtmodel.VisitsType;
import jmtmodel.VisitsType1;
import jmtmodel.VisitsType2;
import jmtmodel.WhatIfType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JmtmodelPackageImpl extends EPackageImpl implements JmtmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockingRegionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classConstraintTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classresultsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classresultsType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classWeightTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closedclassTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delaystationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dropRulesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalConstraintTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ldstationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openclassTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parametersTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regionNodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regionresultsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicetimesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicetimesType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicetimesType2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicetimesType3EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicetimeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicetimeType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solutionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stationresultsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stationsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitsType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitsType2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitType2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whatIfTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceStationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see jmtmodel.JmtmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JmtmodelPackageImpl() {
		super(eNS_URI, JmtmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JmtmodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JmtmodelPackage init() {
		if (isInited) return (JmtmodelPackage)EPackage.Registry.INSTANCE.getEPackage(JmtmodelPackage.eNS_URI);

		// Obtain or create and register package
		JmtmodelPackageImpl theJmtmodelPackage = (JmtmodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JmtmodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JmtmodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theJmtmodelPackage.createPackageContents();

		// Initialize created meta-data
		theJmtmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJmtmodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JmtmodelPackage.eNS_URI, theJmtmodelPackage);
		return theJmtmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockingRegionType() {
		return blockingRegionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockingRegionType_RegionNode() {
		return (EReference)blockingRegionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockingRegionType_GlobalConstraint() {
		return (EReference)blockingRegionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockingRegionType_ClassConstraint() {
		return (EReference)blockingRegionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockingRegionType_ClassWeight() {
		return (EReference)blockingRegionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockingRegionType_DropRules() {
		return (EReference)blockingRegionTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockingRegionType_Name() {
		return (EAttribute)blockingRegionTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockingRegionType_Type() {
		return (EAttribute)blockingRegionTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassConstraintType() {
		return classConstraintTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassConstraintType_JobClass() {
		return (EAttribute)classConstraintTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassConstraintType_MaxJobsPerClass() {
		return (EAttribute)classConstraintTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassesType() {
		return classesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassesType_Group() {
		return (EAttribute)classesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassesType_Closedclass() {
		return (EReference)classesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassesType_Openclass() {
		return (EReference)classesTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassesType_Number() {
		return (EAttribute)classesTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassresultsType() {
		return classresultsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassresultsType_Measure() {
		return (EReference)classresultsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassresultsType_Customerclass() {
		return (EAttribute)classresultsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassresultsType1() {
		return classresultsType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassresultsType1_Measure() {
		return (EReference)classresultsType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassresultsType1_Customerclass() {
		return (EAttribute)classresultsType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassWeightType() {
		return classWeightTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassWeightType_JobClass() {
		return (EAttribute)classWeightTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassWeightType_Weight() {
		return (EAttribute)classWeightTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClosedclassType() {
		return closedclassTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClosedclassType_Name() {
		return (EAttribute)closedclassTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClosedclassType_Population() {
		return (EAttribute)closedclassTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelaystationType() {
		return delaystationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelaystationType_Servicetimes() {
		return (EReference)delaystationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelaystationType_Visits() {
		return (EReference)delaystationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDelaystationType_Name() {
		return (EAttribute)delaystationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Model() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDropRulesType() {
		return dropRulesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDropRulesType_DropThisClass() {
		return (EAttribute)dropRulesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDropRulesType_JobClass() {
		return (EAttribute)dropRulesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalConstraintType() {
		return globalConstraintTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalConstraintType_MaxJobs() {
		return (EAttribute)globalConstraintTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLdstationType() {
		return ldstationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdstationType_Servicetimes() {
		return (EReference)ldstationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLdstationType_Visits() {
		return (EReference)ldstationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdstationType_Name() {
		return (EAttribute)ldstationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLdstationType_Servers() {
		return (EAttribute)ldstationTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListationType() {
		return listationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListationType_Servicetimes() {
		return (EReference)listationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListationType_Visits() {
		return (EReference)listationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getListationType_Name() {
		return (EAttribute)listationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getListationType_Servers() {
		return (EAttribute)listationTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasureType() {
		return measureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_Alfa() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_AnalyzedSamples() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_DiscardedSamples() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_LowerLimit() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_MaxSamples() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_MeanValue() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_MeasureType() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_NodeType() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_Precision() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_Successful() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType_UpperLimit() {
		return (EAttribute)measureTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasureType1() {
		return measureType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_Alfa() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_AnalyzedSamples() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_DiscardedSamples() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_LowerLimit() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_MaxSamples() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_MeanValue() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_MeasureType() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_NodeType() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_Precision() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_Successful() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureType1_UpperLimit() {
		return (EAttribute)measureType1EClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelType() {
		return modelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelType_Description() {
		return (EAttribute)modelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelType_Parameters() {
		return (EReference)modelTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelType_BlockingRegion() {
		return (EReference)modelTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelType_WhatIf() {
		return (EReference)modelTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelType_Solutions() {
		return (EReference)modelTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelType_Jaba() {
		return (EAttribute)modelTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenclassType() {
		return openclassTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenclassType_Name() {
		return (EAttribute)openclassTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenclassType_Rate() {
		return (EAttribute)openclassTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParametersType() {
		return parametersTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametersType_Classes() {
		return (EReference)parametersTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametersType_Stations() {
		return (EReference)parametersTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParametersType_ReferenceStation() {
		return (EReference)parametersTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegionNodeType() {
		return regionNodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegionNodeType_Value() {
		return (EAttribute)regionNodeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegionNodeType_NodeName() {
		return (EAttribute)regionNodeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegionresultsType() {
		return regionresultsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegionresultsType_Classresults() {
		return (EReference)regionresultsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegionresultsType_Region() {
		return (EAttribute)regionresultsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServicetimesType() {
		return servicetimesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServicetimesType_Value() {
		return (EAttribute)servicetimesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServicetimesType_Customerclass() {
		return (EAttribute)servicetimesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServicetimesType1() {
		return servicetimesType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServicetimesType1_Servicetime() {
		return (EReference)servicetimesType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServicetimesType2() {
		return servicetimesType2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServicetimesType2_Servicetimes() {
		return (EReference)servicetimesType2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServicetimesType3() {
		return servicetimesType3EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServicetimesType3_Servicetime() {
		return (EReference)servicetimesType3EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServicetimeType() {
		return servicetimeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServicetimeType_Value() {
		return (EAttribute)servicetimeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServicetimeType_Customerclass() {
		return (EAttribute)servicetimeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServicetimeType1() {
		return servicetimeType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServicetimeType1_Value() {
		return (EAttribute)servicetimeType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServicetimeType1_Customerclass() {
		return (EAttribute)servicetimeType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolutionsType() {
		return solutionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolutionsType_Stationresults() {
		return (EReference)solutionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolutionsType_Regionresults() {
		return (EReference)solutionsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolutionsType_Iteration() {
		return (EAttribute)solutionsTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolutionsType_IterationValue() {
		return (EAttribute)solutionsTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolutionsType_Ok() {
		return (EAttribute)solutionsTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolutionsType_SolutionMethod() {
		return (EAttribute)solutionsTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStationresultsType() {
		return stationresultsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStationresultsType_Classresults() {
		return (EReference)stationresultsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStationresultsType_Station() {
		return (EAttribute)stationresultsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStationsType() {
		return stationsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStationsType_Group() {
		return (EAttribute)stationsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStationsType_Delaystation() {
		return (EReference)stationsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStationsType_Listation() {
		return (EReference)stationsTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStationsType_Ldstation() {
		return (EReference)stationsTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStationsType_Number() {
		return (EAttribute)stationsTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitsType() {
		return visitsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisitsType_Visit() {
		return (EReference)visitsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitsType1() {
		return visitsType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisitsType1_Visit() {
		return (EReference)visitsType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitsType2() {
		return visitsType2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisitsType2_Visit() {
		return (EReference)visitsType2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitType() {
		return visitTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisitType_Value() {
		return (EAttribute)visitTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisitType_Customerclass() {
		return (EAttribute)visitTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitType1() {
		return visitType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisitType1_Value() {
		return (EAttribute)visitType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisitType1_Customerclass() {
		return (EAttribute)visitType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitType2() {
		return visitType2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisitType2_Value() {
		return (EAttribute)visitType2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisitType2_Customerclass() {
		return (EAttribute)visitType2EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhatIfType() {
		return whatIfTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWhatIfType_ClassName() {
		return (EAttribute)whatIfTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWhatIfType_StationName() {
		return (EAttribute)whatIfTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWhatIfType_Type() {
		return (EAttribute)whatIfTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWhatIfType_Values() {
		return (EAttribute)whatIfTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceStationType() {
		return referenceStationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceStationType_Class() {
		return (EReference)referenceStationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceStationType_Number() {
		return (EAttribute)referenceStationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassType() {
		return classTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassType_Name() {
		return (EAttribute)classTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassType_RefStation() {
		return (EAttribute)classTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JmtmodelFactory getJmtmodelFactory() {
		return (JmtmodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		blockingRegionTypeEClass = createEClass(BLOCKING_REGION_TYPE);
		createEReference(blockingRegionTypeEClass, BLOCKING_REGION_TYPE__REGION_NODE);
		createEReference(blockingRegionTypeEClass, BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT);
		createEReference(blockingRegionTypeEClass, BLOCKING_REGION_TYPE__CLASS_CONSTRAINT);
		createEReference(blockingRegionTypeEClass, BLOCKING_REGION_TYPE__CLASS_WEIGHT);
		createEReference(blockingRegionTypeEClass, BLOCKING_REGION_TYPE__DROP_RULES);
		createEAttribute(blockingRegionTypeEClass, BLOCKING_REGION_TYPE__NAME);
		createEAttribute(blockingRegionTypeEClass, BLOCKING_REGION_TYPE__TYPE);

		classConstraintTypeEClass = createEClass(CLASS_CONSTRAINT_TYPE);
		createEAttribute(classConstraintTypeEClass, CLASS_CONSTRAINT_TYPE__JOB_CLASS);
		createEAttribute(classConstraintTypeEClass, CLASS_CONSTRAINT_TYPE__MAX_JOBS_PER_CLASS);

		classesTypeEClass = createEClass(CLASSES_TYPE);
		createEAttribute(classesTypeEClass, CLASSES_TYPE__GROUP);
		createEReference(classesTypeEClass, CLASSES_TYPE__CLOSEDCLASS);
		createEReference(classesTypeEClass, CLASSES_TYPE__OPENCLASS);
		createEAttribute(classesTypeEClass, CLASSES_TYPE__NUMBER);

		classresultsTypeEClass = createEClass(CLASSRESULTS_TYPE);
		createEReference(classresultsTypeEClass, CLASSRESULTS_TYPE__MEASURE);
		createEAttribute(classresultsTypeEClass, CLASSRESULTS_TYPE__CUSTOMERCLASS);

		classresultsType1EClass = createEClass(CLASSRESULTS_TYPE1);
		createEReference(classresultsType1EClass, CLASSRESULTS_TYPE1__MEASURE);
		createEAttribute(classresultsType1EClass, CLASSRESULTS_TYPE1__CUSTOMERCLASS);

		classWeightTypeEClass = createEClass(CLASS_WEIGHT_TYPE);
		createEAttribute(classWeightTypeEClass, CLASS_WEIGHT_TYPE__JOB_CLASS);
		createEAttribute(classWeightTypeEClass, CLASS_WEIGHT_TYPE__WEIGHT);

		closedclassTypeEClass = createEClass(CLOSEDCLASS_TYPE);
		createEAttribute(closedclassTypeEClass, CLOSEDCLASS_TYPE__NAME);
		createEAttribute(closedclassTypeEClass, CLOSEDCLASS_TYPE__POPULATION);

		delaystationTypeEClass = createEClass(DELAYSTATION_TYPE);
		createEReference(delaystationTypeEClass, DELAYSTATION_TYPE__SERVICETIMES);
		createEReference(delaystationTypeEClass, DELAYSTATION_TYPE__VISITS);
		createEAttribute(delaystationTypeEClass, DELAYSTATION_TYPE__NAME);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MODEL);

		dropRulesTypeEClass = createEClass(DROP_RULES_TYPE);
		createEAttribute(dropRulesTypeEClass, DROP_RULES_TYPE__DROP_THIS_CLASS);
		createEAttribute(dropRulesTypeEClass, DROP_RULES_TYPE__JOB_CLASS);

		globalConstraintTypeEClass = createEClass(GLOBAL_CONSTRAINT_TYPE);
		createEAttribute(globalConstraintTypeEClass, GLOBAL_CONSTRAINT_TYPE__MAX_JOBS);

		ldstationTypeEClass = createEClass(LDSTATION_TYPE);
		createEReference(ldstationTypeEClass, LDSTATION_TYPE__SERVICETIMES);
		createEReference(ldstationTypeEClass, LDSTATION_TYPE__VISITS);
		createEAttribute(ldstationTypeEClass, LDSTATION_TYPE__NAME);
		createEAttribute(ldstationTypeEClass, LDSTATION_TYPE__SERVERS);

		listationTypeEClass = createEClass(LISTATION_TYPE);
		createEReference(listationTypeEClass, LISTATION_TYPE__SERVICETIMES);
		createEReference(listationTypeEClass, LISTATION_TYPE__VISITS);
		createEAttribute(listationTypeEClass, LISTATION_TYPE__NAME);
		createEAttribute(listationTypeEClass, LISTATION_TYPE__SERVERS);

		measureTypeEClass = createEClass(MEASURE_TYPE);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__ALFA);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__ANALYZED_SAMPLES);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__DISCARDED_SAMPLES);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__LOWER_LIMIT);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__MAX_SAMPLES);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__MEAN_VALUE);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__MEASURE_TYPE);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__NODE_TYPE);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__PRECISION);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__SUCCESSFUL);
		createEAttribute(measureTypeEClass, MEASURE_TYPE__UPPER_LIMIT);

		measureType1EClass = createEClass(MEASURE_TYPE1);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__ALFA);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__ANALYZED_SAMPLES);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__DISCARDED_SAMPLES);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__LOWER_LIMIT);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__MAX_SAMPLES);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__MEAN_VALUE);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__MEASURE_TYPE);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__NODE_TYPE);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__PRECISION);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__SUCCESSFUL);
		createEAttribute(measureType1EClass, MEASURE_TYPE1__UPPER_LIMIT);

		modelTypeEClass = createEClass(MODEL_TYPE);
		createEAttribute(modelTypeEClass, MODEL_TYPE__DESCRIPTION);
		createEReference(modelTypeEClass, MODEL_TYPE__PARAMETERS);
		createEReference(modelTypeEClass, MODEL_TYPE__BLOCKING_REGION);
		createEReference(modelTypeEClass, MODEL_TYPE__WHAT_IF);
		createEReference(modelTypeEClass, MODEL_TYPE__SOLUTIONS);
		createEAttribute(modelTypeEClass, MODEL_TYPE__JABA);

		openclassTypeEClass = createEClass(OPENCLASS_TYPE);
		createEAttribute(openclassTypeEClass, OPENCLASS_TYPE__NAME);
		createEAttribute(openclassTypeEClass, OPENCLASS_TYPE__RATE);

		parametersTypeEClass = createEClass(PARAMETERS_TYPE);
		createEReference(parametersTypeEClass, PARAMETERS_TYPE__CLASSES);
		createEReference(parametersTypeEClass, PARAMETERS_TYPE__STATIONS);
		createEReference(parametersTypeEClass, PARAMETERS_TYPE__REFERENCE_STATION);

		regionNodeTypeEClass = createEClass(REGION_NODE_TYPE);
		createEAttribute(regionNodeTypeEClass, REGION_NODE_TYPE__VALUE);
		createEAttribute(regionNodeTypeEClass, REGION_NODE_TYPE__NODE_NAME);

		regionresultsTypeEClass = createEClass(REGIONRESULTS_TYPE);
		createEReference(regionresultsTypeEClass, REGIONRESULTS_TYPE__CLASSRESULTS);
		createEAttribute(regionresultsTypeEClass, REGIONRESULTS_TYPE__REGION);

		servicetimesTypeEClass = createEClass(SERVICETIMES_TYPE);
		createEAttribute(servicetimesTypeEClass, SERVICETIMES_TYPE__VALUE);
		createEAttribute(servicetimesTypeEClass, SERVICETIMES_TYPE__CUSTOMERCLASS);

		servicetimesType1EClass = createEClass(SERVICETIMES_TYPE1);
		createEReference(servicetimesType1EClass, SERVICETIMES_TYPE1__SERVICETIME);

		servicetimesType2EClass = createEClass(SERVICETIMES_TYPE2);
		createEReference(servicetimesType2EClass, SERVICETIMES_TYPE2__SERVICETIMES);

		servicetimesType3EClass = createEClass(SERVICETIMES_TYPE3);
		createEReference(servicetimesType3EClass, SERVICETIMES_TYPE3__SERVICETIME);

		servicetimeTypeEClass = createEClass(SERVICETIME_TYPE);
		createEAttribute(servicetimeTypeEClass, SERVICETIME_TYPE__VALUE);
		createEAttribute(servicetimeTypeEClass, SERVICETIME_TYPE__CUSTOMERCLASS);

		servicetimeType1EClass = createEClass(SERVICETIME_TYPE1);
		createEAttribute(servicetimeType1EClass, SERVICETIME_TYPE1__VALUE);
		createEAttribute(servicetimeType1EClass, SERVICETIME_TYPE1__CUSTOMERCLASS);

		solutionsTypeEClass = createEClass(SOLUTIONS_TYPE);
		createEReference(solutionsTypeEClass, SOLUTIONS_TYPE__STATIONRESULTS);
		createEReference(solutionsTypeEClass, SOLUTIONS_TYPE__REGIONRESULTS);
		createEAttribute(solutionsTypeEClass, SOLUTIONS_TYPE__ITERATION);
		createEAttribute(solutionsTypeEClass, SOLUTIONS_TYPE__ITERATION_VALUE);
		createEAttribute(solutionsTypeEClass, SOLUTIONS_TYPE__OK);
		createEAttribute(solutionsTypeEClass, SOLUTIONS_TYPE__SOLUTION_METHOD);

		stationresultsTypeEClass = createEClass(STATIONRESULTS_TYPE);
		createEReference(stationresultsTypeEClass, STATIONRESULTS_TYPE__CLASSRESULTS);
		createEAttribute(stationresultsTypeEClass, STATIONRESULTS_TYPE__STATION);

		stationsTypeEClass = createEClass(STATIONS_TYPE);
		createEAttribute(stationsTypeEClass, STATIONS_TYPE__GROUP);
		createEReference(stationsTypeEClass, STATIONS_TYPE__DELAYSTATION);
		createEReference(stationsTypeEClass, STATIONS_TYPE__LISTATION);
		createEReference(stationsTypeEClass, STATIONS_TYPE__LDSTATION);
		createEAttribute(stationsTypeEClass, STATIONS_TYPE__NUMBER);

		visitsTypeEClass = createEClass(VISITS_TYPE);
		createEReference(visitsTypeEClass, VISITS_TYPE__VISIT);

		visitsType1EClass = createEClass(VISITS_TYPE1);
		createEReference(visitsType1EClass, VISITS_TYPE1__VISIT);

		visitsType2EClass = createEClass(VISITS_TYPE2);
		createEReference(visitsType2EClass, VISITS_TYPE2__VISIT);

		visitTypeEClass = createEClass(VISIT_TYPE);
		createEAttribute(visitTypeEClass, VISIT_TYPE__VALUE);
		createEAttribute(visitTypeEClass, VISIT_TYPE__CUSTOMERCLASS);

		visitType1EClass = createEClass(VISIT_TYPE1);
		createEAttribute(visitType1EClass, VISIT_TYPE1__VALUE);
		createEAttribute(visitType1EClass, VISIT_TYPE1__CUSTOMERCLASS);

		visitType2EClass = createEClass(VISIT_TYPE2);
		createEAttribute(visitType2EClass, VISIT_TYPE2__VALUE);
		createEAttribute(visitType2EClass, VISIT_TYPE2__CUSTOMERCLASS);

		whatIfTypeEClass = createEClass(WHAT_IF_TYPE);
		createEAttribute(whatIfTypeEClass, WHAT_IF_TYPE__CLASS_NAME);
		createEAttribute(whatIfTypeEClass, WHAT_IF_TYPE__STATION_NAME);
		createEAttribute(whatIfTypeEClass, WHAT_IF_TYPE__TYPE);
		createEAttribute(whatIfTypeEClass, WHAT_IF_TYPE__VALUES);

		referenceStationTypeEClass = createEClass(REFERENCE_STATION_TYPE);
		createEReference(referenceStationTypeEClass, REFERENCE_STATION_TYPE__CLASS);
		createEAttribute(referenceStationTypeEClass, REFERENCE_STATION_TYPE__NUMBER);

		classTypeEClass = createEClass(CLASS_TYPE);
		createEAttribute(classTypeEClass, CLASS_TYPE__NAME);
		createEAttribute(classTypeEClass, CLASS_TYPE__REF_STATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(blockingRegionTypeEClass, BlockingRegionType.class, "BlockingRegionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockingRegionType_RegionNode(), this.getRegionNodeType(), null, "regionNode", null, 1, -1, BlockingRegionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockingRegionType_GlobalConstraint(), this.getGlobalConstraintType(), null, "globalConstraint", null, 1, 1, BlockingRegionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockingRegionType_ClassConstraint(), this.getClassConstraintType(), null, "classConstraint", null, 0, -1, BlockingRegionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockingRegionType_ClassWeight(), this.getClassWeightType(), null, "classWeight", null, 0, -1, BlockingRegionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockingRegionType_DropRules(), this.getDropRulesType(), null, "dropRules", null, 0, -1, BlockingRegionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockingRegionType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, BlockingRegionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockingRegionType_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, BlockingRegionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classConstraintTypeEClass, ClassConstraintType.class, "ClassConstraintType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassConstraintType_JobClass(), theXMLTypePackage.getString(), "jobClass", null, 1, 1, ClassConstraintType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassConstraintType_MaxJobsPerClass(), theXMLTypePackage.getDouble(), "maxJobsPerClass", null, 1, 1, ClassConstraintType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classesTypeEClass, ClassesType.class, "ClassesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassesType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, ClassesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassesType_Closedclass(), this.getClosedclassType(), null, "closedclass", null, 0, -1, ClassesType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getClassesType_Openclass(), this.getOpenclassType(), null, "openclass", null, 0, -1, ClassesType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassesType_Number(), theXMLTypePackage.getPositiveInteger(), "number", null, 1, 1, ClassesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classresultsTypeEClass, ClassresultsType.class, "ClassresultsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassresultsType_Measure(), this.getMeasureType(), null, "measure", null, 0, -1, ClassresultsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassresultsType_Customerclass(), theXMLTypePackage.getString(), "customerclass", null, 1, 1, ClassresultsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classresultsType1EClass, ClassresultsType1.class, "ClassresultsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassresultsType1_Measure(), this.getMeasureType1(), null, "measure", null, 0, -1, ClassresultsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassresultsType1_Customerclass(), theXMLTypePackage.getString(), "customerclass", null, 1, 1, ClassresultsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classWeightTypeEClass, ClassWeightType.class, "ClassWeightType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassWeightType_JobClass(), theXMLTypePackage.getString(), "jobClass", null, 1, 1, ClassWeightType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassWeightType_Weight(), theXMLTypePackage.getDouble(), "weight", null, 1, 1, ClassWeightType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(closedclassTypeEClass, ClosedclassType.class, "ClosedclassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClosedclassType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ClosedclassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClosedclassType_Population(), theXMLTypePackage.getDouble(), "population", null, 1, 1, ClosedclassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(delaystationTypeEClass, DelaystationType.class, "DelaystationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDelaystationType_Servicetimes(), this.getServicetimesType3(), null, "servicetimes", null, 1, 1, DelaystationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelaystationType_Visits(), this.getVisitsType2(), null, "visits", null, 1, 1, DelaystationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDelaystationType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, DelaystationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Model(), this.getModelType(), null, "model", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(dropRulesTypeEClass, DropRulesType.class, "DropRulesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDropRulesType_DropThisClass(), theXMLTypePackage.getBoolean(), "dropThisClass", null, 1, 1, DropRulesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDropRulesType_JobClass(), theXMLTypePackage.getString(), "jobClass", null, 1, 1, DropRulesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalConstraintTypeEClass, GlobalConstraintType.class, "GlobalConstraintType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGlobalConstraintType_MaxJobs(), theXMLTypePackage.getDouble(), "maxJobs", null, 1, 1, GlobalConstraintType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ldstationTypeEClass, LdstationType.class, "LdstationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLdstationType_Servicetimes(), this.getServicetimesType2(), null, "servicetimes", null, 1, 1, LdstationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLdstationType_Visits(), this.getVisitsType1(), null, "visits", null, 1, 1, LdstationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLdstationType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, LdstationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLdstationType_Servers(), theXMLTypePackage.getInteger(), "servers", null, 0, 1, LdstationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listationTypeEClass, ListationType.class, "ListationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListationType_Servicetimes(), this.getServicetimesType1(), null, "servicetimes", null, 1, 1, ListationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getListationType_Visits(), this.getVisitsType(), null, "visits", null, 1, 1, ListationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getListationType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ListationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getListationType_Servers(), theXMLTypePackage.getInteger(), "servers", null, 0, 1, ListationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(measureTypeEClass, MeasureType.class, "MeasureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasureType_Alfa(), theXMLTypePackage.getDouble(), "alfa", null, 0, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_AnalyzedSamples(), theXMLTypePackage.getInt(), "analyzedSamples", null, 0, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_DiscardedSamples(), theXMLTypePackage.getInt(), "discardedSamples", null, 0, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_LowerLimit(), theXMLTypePackage.getDouble(), "lowerLimit", null, 0, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_MaxSamples(), theXMLTypePackage.getInt(), "maxSamples", null, 0, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_MeanValue(), theXMLTypePackage.getDouble(), "meanValue", null, 0, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_MeasureType(), theXMLTypePackage.getString(), "measureType", null, 1, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_NodeType(), theXMLTypePackage.getString(), "nodeType", null, 0, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_Precision(), theXMLTypePackage.getDouble(), "precision", null, 0, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_Successful(), theXMLTypePackage.getBoolean(), "successful", null, 1, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType_UpperLimit(), theXMLTypePackage.getDouble(), "upperLimit", null, 0, 1, MeasureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(measureType1EClass, MeasureType1.class, "MeasureType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasureType1_Alfa(), theXMLTypePackage.getDouble(), "alfa", null, 0, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_AnalyzedSamples(), theXMLTypePackage.getInt(), "analyzedSamples", null, 0, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_DiscardedSamples(), theXMLTypePackage.getInt(), "discardedSamples", null, 0, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_LowerLimit(), theXMLTypePackage.getDouble(), "lowerLimit", null, 0, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_MaxSamples(), theXMLTypePackage.getInt(), "maxSamples", null, 0, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_MeanValue(), theXMLTypePackage.getDouble(), "meanValue", null, 0, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_MeasureType(), theXMLTypePackage.getString(), "measureType", null, 1, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_NodeType(), theXMLTypePackage.getString(), "nodeType", null, 0, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_Precision(), theXMLTypePackage.getDouble(), "precision", null, 0, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_Successful(), theXMLTypePackage.getBoolean(), "successful", null, 1, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasureType1_UpperLimit(), theXMLTypePackage.getDouble(), "upperLimit", null, 0, 1, MeasureType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelTypeEClass, ModelType.class, "ModelType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelType_Parameters(), this.getParametersType(), null, "parameters", null, 1, 1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelType_BlockingRegion(), this.getBlockingRegionType(), null, "blockingRegion", null, 0, -1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelType_WhatIf(), this.getWhatIfType(), null, "whatIf", null, 0, 1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelType_Solutions(), this.getSolutionsType(), null, "solutions", null, 0, -1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelType_Jaba(), theXMLTypePackage.getBoolean(), "jaba", null, 0, 1, ModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openclassTypeEClass, OpenclassType.class, "OpenclassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenclassType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, OpenclassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenclassType_Rate(), theXMLTypePackage.getDouble(), "rate", null, 1, 1, OpenclassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parametersTypeEClass, ParametersType.class, "ParametersType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParametersType_Classes(), this.getClassesType(), null, "classes", null, 1, 1, ParametersType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParametersType_Stations(), this.getStationsType(), null, "stations", null, 1, 1, ParametersType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParametersType_ReferenceStation(), this.getReferenceStationType(), null, "referenceStation", null, 0, 1, ParametersType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(regionNodeTypeEClass, RegionNodeType.class, "RegionNodeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegionNodeType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, RegionNodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegionNodeType_NodeName(), theXMLTypePackage.getString(), "nodeName", null, 1, 1, RegionNodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(regionresultsTypeEClass, RegionresultsType.class, "RegionresultsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegionresultsType_Classresults(), this.getClassresultsType(), null, "classresults", null, 1, -1, RegionresultsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegionresultsType_Region(), theXMLTypePackage.getString(), "region", null, 1, 1, RegionresultsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicetimesTypeEClass, ServicetimesType.class, "ServicetimesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServicetimesType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ServicetimesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServicetimesType_Customerclass(), theXMLTypePackage.getString(), "customerclass", null, 1, 1, ServicetimesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicetimesType1EClass, ServicetimesType1.class, "ServicetimesType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServicetimesType1_Servicetime(), this.getServicetimeType(), null, "servicetime", null, 1, -1, ServicetimesType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicetimesType2EClass, ServicetimesType2.class, "ServicetimesType2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServicetimesType2_Servicetimes(), this.getServicetimesType(), null, "servicetimes", null, 1, -1, ServicetimesType2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicetimesType3EClass, ServicetimesType3.class, "ServicetimesType3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServicetimesType3_Servicetime(), this.getServicetimeType1(), null, "servicetime", null, 1, -1, ServicetimesType3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicetimeTypeEClass, ServicetimeType.class, "ServicetimeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServicetimeType_Value(), theXMLTypePackage.getDouble(), "value", null, 0, 1, ServicetimeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServicetimeType_Customerclass(), theXMLTypePackage.getString(), "customerclass", null, 1, 1, ServicetimeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicetimeType1EClass, ServicetimeType1.class, "ServicetimeType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServicetimeType1_Value(), theXMLTypePackage.getDouble(), "value", null, 0, 1, ServicetimeType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServicetimeType1_Customerclass(), theXMLTypePackage.getString(), "customerclass", null, 1, 1, ServicetimeType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solutionsTypeEClass, SolutionsType.class, "SolutionsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolutionsType_Stationresults(), this.getStationresultsType(), null, "stationresults", null, 1, -1, SolutionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolutionsType_Regionresults(), this.getRegionresultsType(), null, "regionresults", null, 0, -1, SolutionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSolutionsType_Iteration(), theXMLTypePackage.getInteger(), "iteration", null, 0, 1, SolutionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSolutionsType_IterationValue(), theXMLTypePackage.getDouble(), "iterationValue", null, 0, 1, SolutionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSolutionsType_Ok(), theXMLTypePackage.getBoolean(), "ok", null, 0, 1, SolutionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSolutionsType_SolutionMethod(), theXMLTypePackage.getString(), "solutionMethod", null, 0, 1, SolutionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stationresultsTypeEClass, StationresultsType.class, "StationresultsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStationresultsType_Classresults(), this.getClassresultsType1(), null, "classresults", null, 1, -1, StationresultsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStationresultsType_Station(), theXMLTypePackage.getString(), "station", null, 1, 1, StationresultsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stationsTypeEClass, StationsType.class, "StationsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStationsType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, StationsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStationsType_Delaystation(), this.getDelaystationType(), null, "delaystation", null, 0, -1, StationsType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStationsType_Listation(), this.getListationType(), null, "listation", null, 0, -1, StationsType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStationsType_Ldstation(), this.getLdstationType(), null, "ldstation", null, 0, -1, StationsType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getStationsType_Number(), theXMLTypePackage.getPositiveInteger(), "number", null, 1, 1, StationsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visitsTypeEClass, VisitsType.class, "VisitsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVisitsType_Visit(), this.getVisitType1(), null, "visit", null, 1, -1, VisitsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visitsType1EClass, VisitsType1.class, "VisitsType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVisitsType1_Visit(), this.getVisitType(), null, "visit", null, 1, -1, VisitsType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visitsType2EClass, VisitsType2.class, "VisitsType2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVisitsType2_Visit(), this.getVisitType2(), null, "visit", null, 1, -1, VisitsType2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visitTypeEClass, VisitType.class, "VisitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVisitType_Value(), theXMLTypePackage.getDouble(), "value", null, 0, 1, VisitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisitType_Customerclass(), theXMLTypePackage.getString(), "customerclass", null, 1, 1, VisitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visitType1EClass, VisitType1.class, "VisitType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVisitType1_Value(), theXMLTypePackage.getDouble(), "value", null, 0, 1, VisitType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisitType1_Customerclass(), theXMLTypePackage.getString(), "customerclass", null, 1, 1, VisitType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visitType2EClass, VisitType2.class, "VisitType2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVisitType2_Value(), theXMLTypePackage.getDouble(), "value", null, 0, 1, VisitType2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisitType2_Customerclass(), theXMLTypePackage.getString(), "customerclass", null, 1, 1, VisitType2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whatIfTypeEClass, WhatIfType.class, "WhatIfType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWhatIfType_ClassName(), theXMLTypePackage.getString(), "className", null, 0, 1, WhatIfType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWhatIfType_StationName(), theXMLTypePackage.getString(), "stationName", null, 0, 1, WhatIfType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWhatIfType_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, WhatIfType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWhatIfType_Values(), theXMLTypePackage.getString(), "values", null, 1, 1, WhatIfType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceStationTypeEClass, ReferenceStationType.class, "ReferenceStationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceStationType_Class(), this.getClassType(), null, "class", null, 0, -1, ReferenceStationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceStationType_Number(), theXMLTypePackage.getPositiveInteger(), "number", null, 1, 1, ReferenceStationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classTypeEClass, ClassType.class, "ClassType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassType_RefStation(), theXMLTypePackage.getString(), "refStation", null, 1, 1, ClassType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "qualified", "false"
		   });	
		addAnnotation
		  (blockingRegionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "blockingRegion_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getBlockingRegionType_RegionNode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "regionNode",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getBlockingRegionType_GlobalConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "globalConstraint",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getBlockingRegionType_ClassConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "classConstraint",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getBlockingRegionType_ClassWeight(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "classWeight",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getBlockingRegionType_DropRules(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dropRules",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getBlockingRegionType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getBlockingRegionType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (classConstraintTypeEClass, 
		   source, 
		   new String[] {
			 "name", "classConstraint_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getClassConstraintType_JobClass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "jobClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getClassConstraintType_MaxJobsPerClass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxJobsPerClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (classesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "classes_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getClassesType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });	
		addAnnotation
		  (getClassesType_Closedclass(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "closedclass",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });	
		addAnnotation
		  (getClassesType_Openclass(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "openclass",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });	
		addAnnotation
		  (getClassesType_Number(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "number",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (classresultsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "classresults_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getClassresultsType_Measure(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "measure",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getClassresultsType_Customerclass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "customerclass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (classresultsType1EClass, 
		   source, 
		   new String[] {
			 "name", "classresults_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getClassresultsType1_Measure(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "measure",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getClassresultsType1_Customerclass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "customerclass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (classWeightTypeEClass, 
		   source, 
		   new String[] {
			 "name", "classWeight_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getClassWeightType_JobClass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "jobClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getClassWeightType_Weight(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "weight",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (closedclassTypeEClass, 
		   source, 
		   new String[] {
			 "name", "closedclass_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getClosedclassType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getClosedclassType_Population(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "population",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (delaystationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "delaystation_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getDelaystationType_Servicetimes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "servicetimes",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDelaystationType_Visits(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visits",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDelaystationType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });	
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });	
		addAnnotation
		  (getDocumentRoot_Model(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "model",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (dropRulesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "dropRules_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getDropRulesType_DropThisClass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dropThisClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDropRulesType_JobClass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "jobClass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (globalConstraintTypeEClass, 
		   source, 
		   new String[] {
			 "name", "globalConstraint_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getGlobalConstraintType_MaxJobs(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxJobs",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (ldstationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ldstation_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getLdstationType_Servicetimes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "servicetimes",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getLdstationType_Visits(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visits",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getLdstationType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getLdstationType_Servers(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "servers",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (listationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "listation_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getListationType_Servicetimes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "servicetimes",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getListationType_Visits(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visits",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getListationType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getListationType_Servers(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "servers",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (measureTypeEClass, 
		   source, 
		   new String[] {
			 "name", "measure_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getMeasureType_Alfa(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "alfa",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_AnalyzedSamples(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "analyzedSamples",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_DiscardedSamples(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "discardedSamples",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_LowerLimit(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lowerLimit",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_MaxSamples(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxSamples",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_MeanValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "meanValue",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_MeasureType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "measureType",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_NodeType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "nodeType",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_Precision(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "precision",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_Successful(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "successful",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType_UpperLimit(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "upperLimit",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (measureType1EClass, 
		   source, 
		   new String[] {
			 "name", "measure_._1_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getMeasureType1_Alfa(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "alfa",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_AnalyzedSamples(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "analyzedSamples",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_DiscardedSamples(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "discardedSamples",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_LowerLimit(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lowerLimit",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_MaxSamples(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maxSamples",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_MeanValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "meanValue",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_MeasureType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "measureType",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_NodeType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "nodeType",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_Precision(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "precision",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_Successful(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "successful",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMeasureType1_UpperLimit(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "upperLimit",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (modelTypeEClass, 
		   source, 
		   new String[] {
			 "name", "model_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getModelType_Description(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getModelType_Parameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameters",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getModelType_BlockingRegion(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "blockingRegion",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getModelType_WhatIf(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "whatIf",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getModelType_Solutions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "solutions",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getModelType_Jaba(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "jaba",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (openclassTypeEClass, 
		   source, 
		   new String[] {
			 "name", "openclass_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getOpenclassType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getOpenclassType_Rate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "rate",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (parametersTypeEClass, 
		   source, 
		   new String[] {
			 "name", "parameters_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getParametersType_Classes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "classes",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getParametersType_Stations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "stations",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getParametersType_ReferenceStation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "referenceStation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (regionNodeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "regionNode_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getRegionNodeType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getRegionNodeType_NodeName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "nodeName",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (regionresultsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "regionresults_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRegionresultsType_Classresults(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "classresults",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRegionresultsType_Region(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "region",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (servicetimesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "servicetimes_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getServicetimesType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getServicetimesType_Customerclass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "customerclass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (servicetimesType1EClass, 
		   source, 
		   new String[] {
			 "name", "servicetimes_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getServicetimesType1_Servicetime(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "servicetime",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (servicetimesType2EClass, 
		   source, 
		   new String[] {
			 "name", "servicetimes_._2_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getServicetimesType2_Servicetimes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "servicetimes",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (servicetimesType3EClass, 
		   source, 
		   new String[] {
			 "name", "servicetimes_._3_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getServicetimesType3_Servicetime(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "servicetime",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (servicetimeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "servicetime_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getServicetimeType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getServicetimeType_Customerclass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "customerclass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (servicetimeType1EClass, 
		   source, 
		   new String[] {
			 "name", "servicetime_._1_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getServicetimeType1_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getServicetimeType1_Customerclass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "customerclass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (solutionsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "solutions_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSolutionsType_Stationresults(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "stationresults",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSolutionsType_Regionresults(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "regionresults",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSolutionsType_Iteration(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "iteration",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSolutionsType_IterationValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "iterationValue",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSolutionsType_Ok(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ok",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getSolutionsType_SolutionMethod(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "solutionMethod",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (stationresultsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "stationresults_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getStationresultsType_Classresults(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "classresults",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getStationresultsType_Station(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "station",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (stationsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "stations_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getStationsType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });	
		addAnnotation
		  (getStationsType_Delaystation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "delaystation",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });	
		addAnnotation
		  (getStationsType_Listation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "listation",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });	
		addAnnotation
		  (getStationsType_Ldstation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ldstation",
			 "namespace", "##targetNamespace",
			 "group", "group:0"
		   });	
		addAnnotation
		  (getStationsType_Number(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "number",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (visitsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "visits_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getVisitsType_Visit(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visit",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (visitsType1EClass, 
		   source, 
		   new String[] {
			 "name", "visits_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getVisitsType1_Visit(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visit",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (visitsType2EClass, 
		   source, 
		   new String[] {
			 "name", "visits_._2_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getVisitsType2_Visit(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "visit",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (visitTypeEClass, 
		   source, 
		   new String[] {
			 "name", "visit_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getVisitType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getVisitType_Customerclass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "customerclass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (visitType1EClass, 
		   source, 
		   new String[] {
			 "name", "visit_._1_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getVisitType1_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getVisitType1_Customerclass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "customerclass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (visitType2EClass, 
		   source, 
		   new String[] {
			 "name", "visit_._2_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getVisitType2_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getVisitType2_Customerclass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "customerclass",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (whatIfTypeEClass, 
		   source, 
		   new String[] {
			 "name", "whatIf_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getWhatIfType_ClassName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "className",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getWhatIfType_StationName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "stationName",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getWhatIfType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getWhatIfType_Values(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "values",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (referenceStationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "referenceStation_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getReferenceStationType_Class(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "class",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getReferenceStationType_Number(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "number",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (classTypeEClass, 
		   source, 
		   new String[] {
			 "name", "class_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getClassType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getClassType_RefStation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "refStation",
			 "namespace", "##targetNamespace"
		   });
	}

} //JmtmodelPackageImpl
