/**
 */
package jmtmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see jmtmodel.JmtmodelFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface JmtmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jmtmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "jmtmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jmtmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JmtmodelPackage eINSTANCE = jmtmodel.impl.JmtmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link jmtmodel.impl.BlockingRegionTypeImpl <em>Blocking Region Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.BlockingRegionTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getBlockingRegionType()
	 * @generated
	 */
	int BLOCKING_REGION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Region Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_REGION_TYPE__REGION_NODE = 0;

	/**
	 * The feature id for the '<em><b>Global Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Class Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_REGION_TYPE__CLASS_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Class Weight</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_REGION_TYPE__CLASS_WEIGHT = 3;

	/**
	 * The feature id for the '<em><b>Drop Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_REGION_TYPE__DROP_RULES = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_REGION_TYPE__NAME = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_REGION_TYPE__TYPE = 6;

	/**
	 * The number of structural features of the '<em>Blocking Region Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_REGION_TYPE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Blocking Region Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCKING_REGION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ClassConstraintTypeImpl <em>Class Constraint Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ClassConstraintTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassConstraintType()
	 * @generated
	 */
	int CLASS_CONSTRAINT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Job Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT_TYPE__JOB_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Max Jobs Per Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT_TYPE__MAX_JOBS_PER_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Class Constraint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Class Constraint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONSTRAINT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ClassesTypeImpl <em>Classes Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ClassesTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassesType()
	 * @generated
	 */
	int CLASSES_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSES_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Closedclass</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSES_TYPE__CLOSEDCLASS = 1;

	/**
	 * The feature id for the '<em><b>Openclass</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSES_TYPE__OPENCLASS = 2;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSES_TYPE__NUMBER = 3;

	/**
	 * The number of structural features of the '<em>Classes Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSES_TYPE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Classes Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ClassresultsTypeImpl <em>Classresults Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ClassresultsTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassresultsType()
	 * @generated
	 */
	int CLASSRESULTS_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSRESULTS_TYPE__MEASURE = 0;

	/**
	 * The feature id for the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSRESULTS_TYPE__CUSTOMERCLASS = 1;

	/**
	 * The number of structural features of the '<em>Classresults Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSRESULTS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Classresults Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSRESULTS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ClassresultsType1Impl <em>Classresults Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ClassresultsType1Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassresultsType1()
	 * @generated
	 */
	int CLASSRESULTS_TYPE1 = 4;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSRESULTS_TYPE1__MEASURE = 0;

	/**
	 * The feature id for the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSRESULTS_TYPE1__CUSTOMERCLASS = 1;

	/**
	 * The number of structural features of the '<em>Classresults Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSRESULTS_TYPE1_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Classresults Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSRESULTS_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ClassWeightTypeImpl <em>Class Weight Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ClassWeightTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassWeightType()
	 * @generated
	 */
	int CLASS_WEIGHT_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Job Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_WEIGHT_TYPE__JOB_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_WEIGHT_TYPE__WEIGHT = 1;

	/**
	 * The number of structural features of the '<em>Class Weight Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_WEIGHT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Class Weight Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_WEIGHT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ClosedclassTypeImpl <em>Closedclass Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ClosedclassTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getClosedclassType()
	 * @generated
	 */
	int CLOSEDCLASS_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEDCLASS_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Population</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEDCLASS_TYPE__POPULATION = 1;

	/**
	 * The number of structural features of the '<em>Closedclass Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEDCLASS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Closedclass Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSEDCLASS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.DelaystationTypeImpl <em>Delaystation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.DelaystationTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getDelaystationType()
	 * @generated
	 */
	int DELAYSTATION_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Servicetimes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAYSTATION_TYPE__SERVICETIMES = 0;

	/**
	 * The feature id for the '<em><b>Visits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAYSTATION_TYPE__VISITS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAYSTATION_TYPE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Delaystation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAYSTATION_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Delaystation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAYSTATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.DocumentRootImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 8;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MODEL = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.DropRulesTypeImpl <em>Drop Rules Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.DropRulesTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getDropRulesType()
	 * @generated
	 */
	int DROP_RULES_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Drop This Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_RULES_TYPE__DROP_THIS_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Job Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_RULES_TYPE__JOB_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Drop Rules Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_RULES_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Drop Rules Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_RULES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.GlobalConstraintTypeImpl <em>Global Constraint Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.GlobalConstraintTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getGlobalConstraintType()
	 * @generated
	 */
	int GLOBAL_CONSTRAINT_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Max Jobs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONSTRAINT_TYPE__MAX_JOBS = 0;

	/**
	 * The number of structural features of the '<em>Global Constraint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONSTRAINT_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Global Constraint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONSTRAINT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.LdstationTypeImpl <em>Ldstation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.LdstationTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getLdstationType()
	 * @generated
	 */
	int LDSTATION_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Servicetimes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDSTATION_TYPE__SERVICETIMES = 0;

	/**
	 * The feature id for the '<em><b>Visits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDSTATION_TYPE__VISITS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDSTATION_TYPE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDSTATION_TYPE__SERVERS = 3;

	/**
	 * The number of structural features of the '<em>Ldstation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDSTATION_TYPE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Ldstation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LDSTATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ListationTypeImpl <em>Listation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ListationTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getListationType()
	 * @generated
	 */
	int LISTATION_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Servicetimes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTATION_TYPE__SERVICETIMES = 0;

	/**
	 * The feature id for the '<em><b>Visits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTATION_TYPE__VISITS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTATION_TYPE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTATION_TYPE__SERVERS = 3;

	/**
	 * The number of structural features of the '<em>Listation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTATION_TYPE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Listation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.MeasureTypeImpl <em>Measure Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.MeasureTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getMeasureType()
	 * @generated
	 */
	int MEASURE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Alfa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__ALFA = 0;

	/**
	 * The feature id for the '<em><b>Analyzed Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__ANALYZED_SAMPLES = 1;

	/**
	 * The feature id for the '<em><b>Discarded Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__DISCARDED_SAMPLES = 2;

	/**
	 * The feature id for the '<em><b>Lower Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__LOWER_LIMIT = 3;

	/**
	 * The feature id for the '<em><b>Max Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__MAX_SAMPLES = 4;

	/**
	 * The feature id for the '<em><b>Mean Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__MEAN_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Measure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__MEASURE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__NODE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__PRECISION = 8;

	/**
	 * The feature id for the '<em><b>Successful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__SUCCESSFUL = 9;

	/**
	 * The feature id for the '<em><b>Upper Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE__UPPER_LIMIT = 10;

	/**
	 * The number of structural features of the '<em>Measure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Measure Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.MeasureType1Impl <em>Measure Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.MeasureType1Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getMeasureType1()
	 * @generated
	 */
	int MEASURE_TYPE1 = 14;

	/**
	 * The feature id for the '<em><b>Alfa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__ALFA = 0;

	/**
	 * The feature id for the '<em><b>Analyzed Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__ANALYZED_SAMPLES = 1;

	/**
	 * The feature id for the '<em><b>Discarded Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__DISCARDED_SAMPLES = 2;

	/**
	 * The feature id for the '<em><b>Lower Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__LOWER_LIMIT = 3;

	/**
	 * The feature id for the '<em><b>Max Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__MAX_SAMPLES = 4;

	/**
	 * The feature id for the '<em><b>Mean Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__MEAN_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Measure Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__MEASURE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__NODE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__PRECISION = 8;

	/**
	 * The feature id for the '<em><b>Successful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__SUCCESSFUL = 9;

	/**
	 * The feature id for the '<em><b>Upper Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1__UPPER_LIMIT = 10;

	/**
	 * The number of structural features of the '<em>Measure Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Measure Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURE_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ModelTypeImpl <em>Model Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ModelTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getModelType()
	 * @generated
	 */
	int MODEL_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__PARAMETERS = 1;

	/**
	 * The feature id for the '<em><b>Blocking Region</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__BLOCKING_REGION = 2;

	/**
	 * The feature id for the '<em><b>What If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__WHAT_IF = 3;

	/**
	 * The feature id for the '<em><b>Solutions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__SOLUTIONS = 4;

	/**
	 * The feature id for the '<em><b>Jaba</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__JABA = 5;

	/**
	 * The number of structural features of the '<em>Model Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Model Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.OpenclassTypeImpl <em>Openclass Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.OpenclassTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getOpenclassType()
	 * @generated
	 */
	int OPENCLASS_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPENCLASS_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPENCLASS_TYPE__RATE = 1;

	/**
	 * The number of structural features of the '<em>Openclass Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPENCLASS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Openclass Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPENCLASS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ParametersTypeImpl <em>Parameters Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ParametersTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getParametersType()
	 * @generated
	 */
	int PARAMETERS_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_TYPE__CLASSES = 0;

	/**
	 * The feature id for the '<em><b>Stations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_TYPE__STATIONS = 1;

	/**
	 * The feature id for the '<em><b>Reference Station</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_TYPE__REFERENCE_STATION = 2;

	/**
	 * The number of structural features of the '<em>Parameters Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Parameters Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.RegionNodeTypeImpl <em>Region Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.RegionNodeTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getRegionNodeType()
	 * @generated
	 */
	int REGION_NODE_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_NODE_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_NODE_TYPE__NODE_NAME = 1;

	/**
	 * The number of structural features of the '<em>Region Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_NODE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Region Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_NODE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.RegionresultsTypeImpl <em>Regionresults Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.RegionresultsTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getRegionresultsType()
	 * @generated
	 */
	int REGIONRESULTS_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Classresults</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGIONRESULTS_TYPE__CLASSRESULTS = 0;

	/**
	 * The feature id for the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGIONRESULTS_TYPE__REGION = 1;

	/**
	 * The number of structural features of the '<em>Regionresults Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGIONRESULTS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Regionresults Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGIONRESULTS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ServicetimesTypeImpl <em>Servicetimes Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ServicetimesTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimesType()
	 * @generated
	 */
	int SERVICETIMES_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE__CUSTOMERCLASS = 1;

	/**
	 * The number of structural features of the '<em>Servicetimes Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Servicetimes Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ServicetimesType1Impl <em>Servicetimes Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ServicetimesType1Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimesType1()
	 * @generated
	 */
	int SERVICETIMES_TYPE1 = 21;

	/**
	 * The feature id for the '<em><b>Servicetime</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE1__SERVICETIME = 0;

	/**
	 * The number of structural features of the '<em>Servicetimes Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE1_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Servicetimes Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ServicetimesType2Impl <em>Servicetimes Type2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ServicetimesType2Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimesType2()
	 * @generated
	 */
	int SERVICETIMES_TYPE2 = 22;

	/**
	 * The feature id for the '<em><b>Servicetimes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE2__SERVICETIMES = 0;

	/**
	 * The number of structural features of the '<em>Servicetimes Type2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE2_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Servicetimes Type2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE2_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ServicetimesType3Impl <em>Servicetimes Type3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ServicetimesType3Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimesType3()
	 * @generated
	 */
	int SERVICETIMES_TYPE3 = 23;

	/**
	 * The feature id for the '<em><b>Servicetime</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE3__SERVICETIME = 0;

	/**
	 * The number of structural features of the '<em>Servicetimes Type3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE3_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Servicetimes Type3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIMES_TYPE3_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ServicetimeTypeImpl <em>Servicetime Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ServicetimeTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimeType()
	 * @generated
	 */
	int SERVICETIME_TYPE = 24;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIME_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIME_TYPE__CUSTOMERCLASS = 1;

	/**
	 * The number of structural features of the '<em>Servicetime Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIME_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Servicetime Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIME_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ServicetimeType1Impl <em>Servicetime Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ServicetimeType1Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimeType1()
	 * @generated
	 */
	int SERVICETIME_TYPE1 = 25;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIME_TYPE1__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIME_TYPE1__CUSTOMERCLASS = 1;

	/**
	 * The number of structural features of the '<em>Servicetime Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIME_TYPE1_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Servicetime Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICETIME_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.SolutionsTypeImpl <em>Solutions Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.SolutionsTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getSolutionsType()
	 * @generated
	 */
	int SOLUTIONS_TYPE = 26;

	/**
	 * The feature id for the '<em><b>Stationresults</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTIONS_TYPE__STATIONRESULTS = 0;

	/**
	 * The feature id for the '<em><b>Regionresults</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTIONS_TYPE__REGIONRESULTS = 1;

	/**
	 * The feature id for the '<em><b>Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTIONS_TYPE__ITERATION = 2;

	/**
	 * The feature id for the '<em><b>Iteration Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTIONS_TYPE__ITERATION_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Ok</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTIONS_TYPE__OK = 4;

	/**
	 * The feature id for the '<em><b>Solution Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTIONS_TYPE__SOLUTION_METHOD = 5;

	/**
	 * The number of structural features of the '<em>Solutions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTIONS_TYPE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Solutions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTIONS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.StationresultsTypeImpl <em>Stationresults Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.StationresultsTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getStationresultsType()
	 * @generated
	 */
	int STATIONRESULTS_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Classresults</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONRESULTS_TYPE__CLASSRESULTS = 0;

	/**
	 * The feature id for the '<em><b>Station</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONRESULTS_TYPE__STATION = 1;

	/**
	 * The number of structural features of the '<em>Stationresults Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONRESULTS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Stationresults Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONRESULTS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.StationsTypeImpl <em>Stations Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.StationsTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getStationsType()
	 * @generated
	 */
	int STATIONS_TYPE = 28;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONS_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Delaystation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONS_TYPE__DELAYSTATION = 1;

	/**
	 * The feature id for the '<em><b>Listation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONS_TYPE__LISTATION = 2;

	/**
	 * The feature id for the '<em><b>Ldstation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONS_TYPE__LDSTATION = 3;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONS_TYPE__NUMBER = 4;

	/**
	 * The number of structural features of the '<em>Stations Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONS_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Stations Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIONS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.VisitsTypeImpl <em>Visits Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.VisitsTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitsType()
	 * @generated
	 */
	int VISITS_TYPE = 29;

	/**
	 * The feature id for the '<em><b>Visit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITS_TYPE__VISIT = 0;

	/**
	 * The number of structural features of the '<em>Visits Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Visits Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.VisitsType1Impl <em>Visits Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.VisitsType1Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitsType1()
	 * @generated
	 */
	int VISITS_TYPE1 = 30;

	/**
	 * The feature id for the '<em><b>Visit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITS_TYPE1__VISIT = 0;

	/**
	 * The number of structural features of the '<em>Visits Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITS_TYPE1_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Visits Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITS_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.VisitsType2Impl <em>Visits Type2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.VisitsType2Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitsType2()
	 * @generated
	 */
	int VISITS_TYPE2 = 31;

	/**
	 * The feature id for the '<em><b>Visit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITS_TYPE2__VISIT = 0;

	/**
	 * The number of structural features of the '<em>Visits Type2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITS_TYPE2_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Visits Type2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITS_TYPE2_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.VisitTypeImpl <em>Visit Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.VisitTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitType()
	 * @generated
	 */
	int VISIT_TYPE = 32;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE__CUSTOMERCLASS = 1;

	/**
	 * The number of structural features of the '<em>Visit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Visit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.VisitType1Impl <em>Visit Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.VisitType1Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitType1()
	 * @generated
	 */
	int VISIT_TYPE1 = 33;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE1__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE1__CUSTOMERCLASS = 1;

	/**
	 * The number of structural features of the '<em>Visit Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE1_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Visit Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE1_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.VisitType2Impl <em>Visit Type2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.VisitType2Impl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitType2()
	 * @generated
	 */
	int VISIT_TYPE2 = 34;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE2__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Customerclass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE2__CUSTOMERCLASS = 1;

	/**
	 * The number of structural features of the '<em>Visit Type2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE2_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Visit Type2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIT_TYPE2_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.WhatIfTypeImpl <em>What If Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.WhatIfTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getWhatIfType()
	 * @generated
	 */
	int WHAT_IF_TYPE = 35;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHAT_IF_TYPE__CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Station Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHAT_IF_TYPE__STATION_NAME = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHAT_IF_TYPE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHAT_IF_TYPE__VALUES = 3;

	/**
	 * The number of structural features of the '<em>What If Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHAT_IF_TYPE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>What If Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHAT_IF_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ReferenceStationTypeImpl <em>Reference Station Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ReferenceStationTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getReferenceStationType()
	 * @generated
	 */
	int REFERENCE_STATION_TYPE = 36;

	/**
	 * The feature id for the '<em><b>Class</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_STATION_TYPE__CLASS = 0;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_STATION_TYPE__NUMBER = 1;

	/**
	 * The number of structural features of the '<em>Reference Station Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_STATION_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Reference Station Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_STATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link jmtmodel.impl.ClassTypeImpl <em>Class Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jmtmodel.impl.ClassTypeImpl
	 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassType()
	 * @generated
	 */
	int CLASS_TYPE = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Ref Station</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE__REF_STATION = 1;

	/**
	 * The number of structural features of the '<em>Class Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Class Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link jmtmodel.BlockingRegionType <em>Blocking Region Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blocking Region Type</em>'.
	 * @see jmtmodel.BlockingRegionType
	 * @generated
	 */
	EClass getBlockingRegionType();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.BlockingRegionType#getRegionNode <em>Region Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Region Node</em>'.
	 * @see jmtmodel.BlockingRegionType#getRegionNode()
	 * @see #getBlockingRegionType()
	 * @generated
	 */
	EReference getBlockingRegionType_RegionNode();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.BlockingRegionType#getGlobalConstraint <em>Global Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Global Constraint</em>'.
	 * @see jmtmodel.BlockingRegionType#getGlobalConstraint()
	 * @see #getBlockingRegionType()
	 * @generated
	 */
	EReference getBlockingRegionType_GlobalConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.BlockingRegionType#getClassConstraint <em>Class Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Constraint</em>'.
	 * @see jmtmodel.BlockingRegionType#getClassConstraint()
	 * @see #getBlockingRegionType()
	 * @generated
	 */
	EReference getBlockingRegionType_ClassConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.BlockingRegionType#getClassWeight <em>Class Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Weight</em>'.
	 * @see jmtmodel.BlockingRegionType#getClassWeight()
	 * @see #getBlockingRegionType()
	 * @generated
	 */
	EReference getBlockingRegionType_ClassWeight();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.BlockingRegionType#getDropRules <em>Drop Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Drop Rules</em>'.
	 * @see jmtmodel.BlockingRegionType#getDropRules()
	 * @see #getBlockingRegionType()
	 * @generated
	 */
	EReference getBlockingRegionType_DropRules();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.BlockingRegionType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jmtmodel.BlockingRegionType#getName()
	 * @see #getBlockingRegionType()
	 * @generated
	 */
	EAttribute getBlockingRegionType_Name();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.BlockingRegionType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see jmtmodel.BlockingRegionType#getType()
	 * @see #getBlockingRegionType()
	 * @generated
	 */
	EAttribute getBlockingRegionType_Type();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ClassConstraintType <em>Class Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Constraint Type</em>'.
	 * @see jmtmodel.ClassConstraintType
	 * @generated
	 */
	EClass getClassConstraintType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClassConstraintType#getJobClass <em>Job Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Class</em>'.
	 * @see jmtmodel.ClassConstraintType#getJobClass()
	 * @see #getClassConstraintType()
	 * @generated
	 */
	EAttribute getClassConstraintType_JobClass();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClassConstraintType#getMaxJobsPerClass <em>Max Jobs Per Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Jobs Per Class</em>'.
	 * @see jmtmodel.ClassConstraintType#getMaxJobsPerClass()
	 * @see #getClassConstraintType()
	 * @generated
	 */
	EAttribute getClassConstraintType_MaxJobsPerClass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ClassesType <em>Classes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classes Type</em>'.
	 * @see jmtmodel.ClassesType
	 * @generated
	 */
	EClass getClassesType();

	/**
	 * Returns the meta object for the attribute list '{@link jmtmodel.ClassesType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see jmtmodel.ClassesType#getGroup()
	 * @see #getClassesType()
	 * @generated
	 */
	EAttribute getClassesType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ClassesType#getClosedclass <em>Closedclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Closedclass</em>'.
	 * @see jmtmodel.ClassesType#getClosedclass()
	 * @see #getClassesType()
	 * @generated
	 */
	EReference getClassesType_Closedclass();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ClassesType#getOpenclass <em>Openclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Openclass</em>'.
	 * @see jmtmodel.ClassesType#getOpenclass()
	 * @see #getClassesType()
	 * @generated
	 */
	EReference getClassesType_Openclass();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClassesType#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see jmtmodel.ClassesType#getNumber()
	 * @see #getClassesType()
	 * @generated
	 */
	EAttribute getClassesType_Number();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ClassresultsType <em>Classresults Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classresults Type</em>'.
	 * @see jmtmodel.ClassresultsType
	 * @generated
	 */
	EClass getClassresultsType();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ClassresultsType#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measure</em>'.
	 * @see jmtmodel.ClassresultsType#getMeasure()
	 * @see #getClassresultsType()
	 * @generated
	 */
	EReference getClassresultsType_Measure();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClassresultsType#getCustomerclass <em>Customerclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customerclass</em>'.
	 * @see jmtmodel.ClassresultsType#getCustomerclass()
	 * @see #getClassresultsType()
	 * @generated
	 */
	EAttribute getClassresultsType_Customerclass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ClassresultsType1 <em>Classresults Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classresults Type1</em>'.
	 * @see jmtmodel.ClassresultsType1
	 * @generated
	 */
	EClass getClassresultsType1();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ClassresultsType1#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measure</em>'.
	 * @see jmtmodel.ClassresultsType1#getMeasure()
	 * @see #getClassresultsType1()
	 * @generated
	 */
	EReference getClassresultsType1_Measure();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClassresultsType1#getCustomerclass <em>Customerclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customerclass</em>'.
	 * @see jmtmodel.ClassresultsType1#getCustomerclass()
	 * @see #getClassresultsType1()
	 * @generated
	 */
	EAttribute getClassresultsType1_Customerclass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ClassWeightType <em>Class Weight Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Weight Type</em>'.
	 * @see jmtmodel.ClassWeightType
	 * @generated
	 */
	EClass getClassWeightType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClassWeightType#getJobClass <em>Job Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Class</em>'.
	 * @see jmtmodel.ClassWeightType#getJobClass()
	 * @see #getClassWeightType()
	 * @generated
	 */
	EAttribute getClassWeightType_JobClass();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClassWeightType#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see jmtmodel.ClassWeightType#getWeight()
	 * @see #getClassWeightType()
	 * @generated
	 */
	EAttribute getClassWeightType_Weight();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ClosedclassType <em>Closedclass Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Closedclass Type</em>'.
	 * @see jmtmodel.ClosedclassType
	 * @generated
	 */
	EClass getClosedclassType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClosedclassType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jmtmodel.ClosedclassType#getName()
	 * @see #getClosedclassType()
	 * @generated
	 */
	EAttribute getClosedclassType_Name();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClosedclassType#getPopulation <em>Population</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Population</em>'.
	 * @see jmtmodel.ClosedclassType#getPopulation()
	 * @see #getClosedclassType()
	 * @generated
	 */
	EAttribute getClosedclassType_Population();

	/**
	 * Returns the meta object for class '{@link jmtmodel.DelaystationType <em>Delaystation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delaystation Type</em>'.
	 * @see jmtmodel.DelaystationType
	 * @generated
	 */
	EClass getDelaystationType();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.DelaystationType#getServicetimes <em>Servicetimes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Servicetimes</em>'.
	 * @see jmtmodel.DelaystationType#getServicetimes()
	 * @see #getDelaystationType()
	 * @generated
	 */
	EReference getDelaystationType_Servicetimes();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.DelaystationType#getVisits <em>Visits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visits</em>'.
	 * @see jmtmodel.DelaystationType#getVisits()
	 * @see #getDelaystationType()
	 * @generated
	 */
	EReference getDelaystationType_Visits();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.DelaystationType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jmtmodel.DelaystationType#getName()
	 * @see #getDelaystationType()
	 * @generated
	 */
	EAttribute getDelaystationType_Name();

	/**
	 * Returns the meta object for class '{@link jmtmodel.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see jmtmodel.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link jmtmodel.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see jmtmodel.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link jmtmodel.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see jmtmodel.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link jmtmodel.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see jmtmodel.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.DocumentRoot#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model</em>'.
	 * @see jmtmodel.DocumentRoot#getModel()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Model();

	/**
	 * Returns the meta object for class '{@link jmtmodel.DropRulesType <em>Drop Rules Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drop Rules Type</em>'.
	 * @see jmtmodel.DropRulesType
	 * @generated
	 */
	EClass getDropRulesType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.DropRulesType#isDropThisClass <em>Drop This Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Drop This Class</em>'.
	 * @see jmtmodel.DropRulesType#isDropThisClass()
	 * @see #getDropRulesType()
	 * @generated
	 */
	EAttribute getDropRulesType_DropThisClass();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.DropRulesType#getJobClass <em>Job Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Class</em>'.
	 * @see jmtmodel.DropRulesType#getJobClass()
	 * @see #getDropRulesType()
	 * @generated
	 */
	EAttribute getDropRulesType_JobClass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.GlobalConstraintType <em>Global Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Constraint Type</em>'.
	 * @see jmtmodel.GlobalConstraintType
	 * @generated
	 */
	EClass getGlobalConstraintType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.GlobalConstraintType#getMaxJobs <em>Max Jobs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Jobs</em>'.
	 * @see jmtmodel.GlobalConstraintType#getMaxJobs()
	 * @see #getGlobalConstraintType()
	 * @generated
	 */
	EAttribute getGlobalConstraintType_MaxJobs();

	/**
	 * Returns the meta object for class '{@link jmtmodel.LdstationType <em>Ldstation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ldstation Type</em>'.
	 * @see jmtmodel.LdstationType
	 * @generated
	 */
	EClass getLdstationType();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.LdstationType#getServicetimes <em>Servicetimes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Servicetimes</em>'.
	 * @see jmtmodel.LdstationType#getServicetimes()
	 * @see #getLdstationType()
	 * @generated
	 */
	EReference getLdstationType_Servicetimes();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.LdstationType#getVisits <em>Visits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visits</em>'.
	 * @see jmtmodel.LdstationType#getVisits()
	 * @see #getLdstationType()
	 * @generated
	 */
	EReference getLdstationType_Visits();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.LdstationType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jmtmodel.LdstationType#getName()
	 * @see #getLdstationType()
	 * @generated
	 */
	EAttribute getLdstationType_Name();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.LdstationType#getServers <em>Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Servers</em>'.
	 * @see jmtmodel.LdstationType#getServers()
	 * @see #getLdstationType()
	 * @generated
	 */
	EAttribute getLdstationType_Servers();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ListationType <em>Listation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Listation Type</em>'.
	 * @see jmtmodel.ListationType
	 * @generated
	 */
	EClass getListationType();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.ListationType#getServicetimes <em>Servicetimes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Servicetimes</em>'.
	 * @see jmtmodel.ListationType#getServicetimes()
	 * @see #getListationType()
	 * @generated
	 */
	EReference getListationType_Servicetimes();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.ListationType#getVisits <em>Visits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visits</em>'.
	 * @see jmtmodel.ListationType#getVisits()
	 * @see #getListationType()
	 * @generated
	 */
	EReference getListationType_Visits();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ListationType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jmtmodel.ListationType#getName()
	 * @see #getListationType()
	 * @generated
	 */
	EAttribute getListationType_Name();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ListationType#getServers <em>Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Servers</em>'.
	 * @see jmtmodel.ListationType#getServers()
	 * @see #getListationType()
	 * @generated
	 */
	EAttribute getListationType_Servers();

	/**
	 * Returns the meta object for class '{@link jmtmodel.MeasureType <em>Measure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Type</em>'.
	 * @see jmtmodel.MeasureType
	 * @generated
	 */
	EClass getMeasureType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getAlfa <em>Alfa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alfa</em>'.
	 * @see jmtmodel.MeasureType#getAlfa()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_Alfa();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getAnalyzedSamples <em>Analyzed Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analyzed Samples</em>'.
	 * @see jmtmodel.MeasureType#getAnalyzedSamples()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_AnalyzedSamples();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getDiscardedSamples <em>Discarded Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discarded Samples</em>'.
	 * @see jmtmodel.MeasureType#getDiscardedSamples()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_DiscardedSamples();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getLowerLimit <em>Lower Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Limit</em>'.
	 * @see jmtmodel.MeasureType#getLowerLimit()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_LowerLimit();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getMaxSamples <em>Max Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Samples</em>'.
	 * @see jmtmodel.MeasureType#getMaxSamples()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_MaxSamples();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getMeanValue <em>Mean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mean Value</em>'.
	 * @see jmtmodel.MeasureType#getMeanValue()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_MeanValue();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getMeasureType <em>Measure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure Type</em>'.
	 * @see jmtmodel.MeasureType#getMeasureType()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_MeasureType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getNodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Type</em>'.
	 * @see jmtmodel.MeasureType#getNodeType()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_NodeType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getPrecision <em>Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precision</em>'.
	 * @see jmtmodel.MeasureType#getPrecision()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_Precision();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#isSuccessful <em>Successful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Successful</em>'.
	 * @see jmtmodel.MeasureType#isSuccessful()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_Successful();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType#getUpperLimit <em>Upper Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Limit</em>'.
	 * @see jmtmodel.MeasureType#getUpperLimit()
	 * @see #getMeasureType()
	 * @generated
	 */
	EAttribute getMeasureType_UpperLimit();

	/**
	 * Returns the meta object for class '{@link jmtmodel.MeasureType1 <em>Measure Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measure Type1</em>'.
	 * @see jmtmodel.MeasureType1
	 * @generated
	 */
	EClass getMeasureType1();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getAlfa <em>Alfa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alfa</em>'.
	 * @see jmtmodel.MeasureType1#getAlfa()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_Alfa();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getAnalyzedSamples <em>Analyzed Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analyzed Samples</em>'.
	 * @see jmtmodel.MeasureType1#getAnalyzedSamples()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_AnalyzedSamples();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getDiscardedSamples <em>Discarded Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discarded Samples</em>'.
	 * @see jmtmodel.MeasureType1#getDiscardedSamples()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_DiscardedSamples();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getLowerLimit <em>Lower Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Limit</em>'.
	 * @see jmtmodel.MeasureType1#getLowerLimit()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_LowerLimit();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getMaxSamples <em>Max Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Samples</em>'.
	 * @see jmtmodel.MeasureType1#getMaxSamples()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_MaxSamples();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getMeanValue <em>Mean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mean Value</em>'.
	 * @see jmtmodel.MeasureType1#getMeanValue()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_MeanValue();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getMeasureType <em>Measure Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure Type</em>'.
	 * @see jmtmodel.MeasureType1#getMeasureType()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_MeasureType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getNodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Type</em>'.
	 * @see jmtmodel.MeasureType1#getNodeType()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_NodeType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getPrecision <em>Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precision</em>'.
	 * @see jmtmodel.MeasureType1#getPrecision()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_Precision();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#isSuccessful <em>Successful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Successful</em>'.
	 * @see jmtmodel.MeasureType1#isSuccessful()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_Successful();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.MeasureType1#getUpperLimit <em>Upper Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Limit</em>'.
	 * @see jmtmodel.MeasureType1#getUpperLimit()
	 * @see #getMeasureType1()
	 * @generated
	 */
	EAttribute getMeasureType1_UpperLimit();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type</em>'.
	 * @see jmtmodel.ModelType
	 * @generated
	 */
	EClass getModelType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ModelType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see jmtmodel.ModelType#getDescription()
	 * @see #getModelType()
	 * @generated
	 */
	EAttribute getModelType_Description();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.ModelType#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameters</em>'.
	 * @see jmtmodel.ModelType#getParameters()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ModelType#getBlockingRegion <em>Blocking Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocking Region</em>'.
	 * @see jmtmodel.ModelType#getBlockingRegion()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_BlockingRegion();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.ModelType#getWhatIf <em>What If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>What If</em>'.
	 * @see jmtmodel.ModelType#getWhatIf()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_WhatIf();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ModelType#getSolutions <em>Solutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Solutions</em>'.
	 * @see jmtmodel.ModelType#getSolutions()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_Solutions();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ModelType#isJaba <em>Jaba</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jaba</em>'.
	 * @see jmtmodel.ModelType#isJaba()
	 * @see #getModelType()
	 * @generated
	 */
	EAttribute getModelType_Jaba();

	/**
	 * Returns the meta object for class '{@link jmtmodel.OpenclassType <em>Openclass Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Openclass Type</em>'.
	 * @see jmtmodel.OpenclassType
	 * @generated
	 */
	EClass getOpenclassType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.OpenclassType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jmtmodel.OpenclassType#getName()
	 * @see #getOpenclassType()
	 * @generated
	 */
	EAttribute getOpenclassType_Name();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.OpenclassType#getRate <em>Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate</em>'.
	 * @see jmtmodel.OpenclassType#getRate()
	 * @see #getOpenclassType()
	 * @generated
	 */
	EAttribute getOpenclassType_Rate();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ParametersType <em>Parameters Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameters Type</em>'.
	 * @see jmtmodel.ParametersType
	 * @generated
	 */
	EClass getParametersType();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.ParametersType#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Classes</em>'.
	 * @see jmtmodel.ParametersType#getClasses()
	 * @see #getParametersType()
	 * @generated
	 */
	EReference getParametersType_Classes();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.ParametersType#getStations <em>Stations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stations</em>'.
	 * @see jmtmodel.ParametersType#getStations()
	 * @see #getParametersType()
	 * @generated
	 */
	EReference getParametersType_Stations();

	/**
	 * Returns the meta object for the containment reference '{@link jmtmodel.ParametersType#getReferenceStation <em>Reference Station</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference Station</em>'.
	 * @see jmtmodel.ParametersType#getReferenceStation()
	 * @see #getParametersType()
	 * @generated
	 */
	EReference getParametersType_ReferenceStation();

	/**
	 * Returns the meta object for class '{@link jmtmodel.RegionNodeType <em>Region Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region Node Type</em>'.
	 * @see jmtmodel.RegionNodeType
	 * @generated
	 */
	EClass getRegionNodeType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.RegionNodeType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see jmtmodel.RegionNodeType#getValue()
	 * @see #getRegionNodeType()
	 * @generated
	 */
	EAttribute getRegionNodeType_Value();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.RegionNodeType#getNodeName <em>Node Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Name</em>'.
	 * @see jmtmodel.RegionNodeType#getNodeName()
	 * @see #getRegionNodeType()
	 * @generated
	 */
	EAttribute getRegionNodeType_NodeName();

	/**
	 * Returns the meta object for class '{@link jmtmodel.RegionresultsType <em>Regionresults Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regionresults Type</em>'.
	 * @see jmtmodel.RegionresultsType
	 * @generated
	 */
	EClass getRegionresultsType();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.RegionresultsType#getClassresults <em>Classresults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classresults</em>'.
	 * @see jmtmodel.RegionresultsType#getClassresults()
	 * @see #getRegionresultsType()
	 * @generated
	 */
	EReference getRegionresultsType_Classresults();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.RegionresultsType#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Region</em>'.
	 * @see jmtmodel.RegionresultsType#getRegion()
	 * @see #getRegionresultsType()
	 * @generated
	 */
	EAttribute getRegionresultsType_Region();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ServicetimesType <em>Servicetimes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Servicetimes Type</em>'.
	 * @see jmtmodel.ServicetimesType
	 * @generated
	 */
	EClass getServicetimesType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ServicetimesType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see jmtmodel.ServicetimesType#getValue()
	 * @see #getServicetimesType()
	 * @generated
	 */
	EAttribute getServicetimesType_Value();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ServicetimesType#getCustomerclass <em>Customerclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customerclass</em>'.
	 * @see jmtmodel.ServicetimesType#getCustomerclass()
	 * @see #getServicetimesType()
	 * @generated
	 */
	EAttribute getServicetimesType_Customerclass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ServicetimesType1 <em>Servicetimes Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Servicetimes Type1</em>'.
	 * @see jmtmodel.ServicetimesType1
	 * @generated
	 */
	EClass getServicetimesType1();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ServicetimesType1#getServicetime <em>Servicetime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Servicetime</em>'.
	 * @see jmtmodel.ServicetimesType1#getServicetime()
	 * @see #getServicetimesType1()
	 * @generated
	 */
	EReference getServicetimesType1_Servicetime();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ServicetimesType2 <em>Servicetimes Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Servicetimes Type2</em>'.
	 * @see jmtmodel.ServicetimesType2
	 * @generated
	 */
	EClass getServicetimesType2();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ServicetimesType2#getServicetimes <em>Servicetimes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Servicetimes</em>'.
	 * @see jmtmodel.ServicetimesType2#getServicetimes()
	 * @see #getServicetimesType2()
	 * @generated
	 */
	EReference getServicetimesType2_Servicetimes();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ServicetimesType3 <em>Servicetimes Type3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Servicetimes Type3</em>'.
	 * @see jmtmodel.ServicetimesType3
	 * @generated
	 */
	EClass getServicetimesType3();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ServicetimesType3#getServicetime <em>Servicetime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Servicetime</em>'.
	 * @see jmtmodel.ServicetimesType3#getServicetime()
	 * @see #getServicetimesType3()
	 * @generated
	 */
	EReference getServicetimesType3_Servicetime();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ServicetimeType <em>Servicetime Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Servicetime Type</em>'.
	 * @see jmtmodel.ServicetimeType
	 * @generated
	 */
	EClass getServicetimeType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ServicetimeType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see jmtmodel.ServicetimeType#getValue()
	 * @see #getServicetimeType()
	 * @generated
	 */
	EAttribute getServicetimeType_Value();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ServicetimeType#getCustomerclass <em>Customerclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customerclass</em>'.
	 * @see jmtmodel.ServicetimeType#getCustomerclass()
	 * @see #getServicetimeType()
	 * @generated
	 */
	EAttribute getServicetimeType_Customerclass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ServicetimeType1 <em>Servicetime Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Servicetime Type1</em>'.
	 * @see jmtmodel.ServicetimeType1
	 * @generated
	 */
	EClass getServicetimeType1();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ServicetimeType1#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see jmtmodel.ServicetimeType1#getValue()
	 * @see #getServicetimeType1()
	 * @generated
	 */
	EAttribute getServicetimeType1_Value();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ServicetimeType1#getCustomerclass <em>Customerclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customerclass</em>'.
	 * @see jmtmodel.ServicetimeType1#getCustomerclass()
	 * @see #getServicetimeType1()
	 * @generated
	 */
	EAttribute getServicetimeType1_Customerclass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.SolutionsType <em>Solutions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solutions Type</em>'.
	 * @see jmtmodel.SolutionsType
	 * @generated
	 */
	EClass getSolutionsType();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.SolutionsType#getStationresults <em>Stationresults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stationresults</em>'.
	 * @see jmtmodel.SolutionsType#getStationresults()
	 * @see #getSolutionsType()
	 * @generated
	 */
	EReference getSolutionsType_Stationresults();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.SolutionsType#getRegionresults <em>Regionresults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regionresults</em>'.
	 * @see jmtmodel.SolutionsType#getRegionresults()
	 * @see #getSolutionsType()
	 * @generated
	 */
	EReference getSolutionsType_Regionresults();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.SolutionsType#getIteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iteration</em>'.
	 * @see jmtmodel.SolutionsType#getIteration()
	 * @see #getSolutionsType()
	 * @generated
	 */
	EAttribute getSolutionsType_Iteration();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.SolutionsType#getIterationValue <em>Iteration Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iteration Value</em>'.
	 * @see jmtmodel.SolutionsType#getIterationValue()
	 * @see #getSolutionsType()
	 * @generated
	 */
	EAttribute getSolutionsType_IterationValue();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.SolutionsType#isOk <em>Ok</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ok</em>'.
	 * @see jmtmodel.SolutionsType#isOk()
	 * @see #getSolutionsType()
	 * @generated
	 */
	EAttribute getSolutionsType_Ok();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.SolutionsType#getSolutionMethod <em>Solution Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solution Method</em>'.
	 * @see jmtmodel.SolutionsType#getSolutionMethod()
	 * @see #getSolutionsType()
	 * @generated
	 */
	EAttribute getSolutionsType_SolutionMethod();

	/**
	 * Returns the meta object for class '{@link jmtmodel.StationresultsType <em>Stationresults Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stationresults Type</em>'.
	 * @see jmtmodel.StationresultsType
	 * @generated
	 */
	EClass getStationresultsType();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.StationresultsType#getClassresults <em>Classresults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classresults</em>'.
	 * @see jmtmodel.StationresultsType#getClassresults()
	 * @see #getStationresultsType()
	 * @generated
	 */
	EReference getStationresultsType_Classresults();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.StationresultsType#getStation <em>Station</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Station</em>'.
	 * @see jmtmodel.StationresultsType#getStation()
	 * @see #getStationresultsType()
	 * @generated
	 */
	EAttribute getStationresultsType_Station();

	/**
	 * Returns the meta object for class '{@link jmtmodel.StationsType <em>Stations Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stations Type</em>'.
	 * @see jmtmodel.StationsType
	 * @generated
	 */
	EClass getStationsType();

	/**
	 * Returns the meta object for the attribute list '{@link jmtmodel.StationsType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see jmtmodel.StationsType#getGroup()
	 * @see #getStationsType()
	 * @generated
	 */
	EAttribute getStationsType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.StationsType#getDelaystation <em>Delaystation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Delaystation</em>'.
	 * @see jmtmodel.StationsType#getDelaystation()
	 * @see #getStationsType()
	 * @generated
	 */
	EReference getStationsType_Delaystation();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.StationsType#getListation <em>Listation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Listation</em>'.
	 * @see jmtmodel.StationsType#getListation()
	 * @see #getStationsType()
	 * @generated
	 */
	EReference getStationsType_Listation();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.StationsType#getLdstation <em>Ldstation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ldstation</em>'.
	 * @see jmtmodel.StationsType#getLdstation()
	 * @see #getStationsType()
	 * @generated
	 */
	EReference getStationsType_Ldstation();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.StationsType#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see jmtmodel.StationsType#getNumber()
	 * @see #getStationsType()
	 * @generated
	 */
	EAttribute getStationsType_Number();

	/**
	 * Returns the meta object for class '{@link jmtmodel.VisitsType <em>Visits Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visits Type</em>'.
	 * @see jmtmodel.VisitsType
	 * @generated
	 */
	EClass getVisitsType();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.VisitsType#getVisit <em>Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Visit</em>'.
	 * @see jmtmodel.VisitsType#getVisit()
	 * @see #getVisitsType()
	 * @generated
	 */
	EReference getVisitsType_Visit();

	/**
	 * Returns the meta object for class '{@link jmtmodel.VisitsType1 <em>Visits Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visits Type1</em>'.
	 * @see jmtmodel.VisitsType1
	 * @generated
	 */
	EClass getVisitsType1();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.VisitsType1#getVisit <em>Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Visit</em>'.
	 * @see jmtmodel.VisitsType1#getVisit()
	 * @see #getVisitsType1()
	 * @generated
	 */
	EReference getVisitsType1_Visit();

	/**
	 * Returns the meta object for class '{@link jmtmodel.VisitsType2 <em>Visits Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visits Type2</em>'.
	 * @see jmtmodel.VisitsType2
	 * @generated
	 */
	EClass getVisitsType2();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.VisitsType2#getVisit <em>Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Visit</em>'.
	 * @see jmtmodel.VisitsType2#getVisit()
	 * @see #getVisitsType2()
	 * @generated
	 */
	EReference getVisitsType2_Visit();

	/**
	 * Returns the meta object for class '{@link jmtmodel.VisitType <em>Visit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visit Type</em>'.
	 * @see jmtmodel.VisitType
	 * @generated
	 */
	EClass getVisitType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.VisitType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see jmtmodel.VisitType#getValue()
	 * @see #getVisitType()
	 * @generated
	 */
	EAttribute getVisitType_Value();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.VisitType#getCustomerclass <em>Customerclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customerclass</em>'.
	 * @see jmtmodel.VisitType#getCustomerclass()
	 * @see #getVisitType()
	 * @generated
	 */
	EAttribute getVisitType_Customerclass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.VisitType1 <em>Visit Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visit Type1</em>'.
	 * @see jmtmodel.VisitType1
	 * @generated
	 */
	EClass getVisitType1();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.VisitType1#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see jmtmodel.VisitType1#getValue()
	 * @see #getVisitType1()
	 * @generated
	 */
	EAttribute getVisitType1_Value();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.VisitType1#getCustomerclass <em>Customerclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customerclass</em>'.
	 * @see jmtmodel.VisitType1#getCustomerclass()
	 * @see #getVisitType1()
	 * @generated
	 */
	EAttribute getVisitType1_Customerclass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.VisitType2 <em>Visit Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visit Type2</em>'.
	 * @see jmtmodel.VisitType2
	 * @generated
	 */
	EClass getVisitType2();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.VisitType2#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see jmtmodel.VisitType2#getValue()
	 * @see #getVisitType2()
	 * @generated
	 */
	EAttribute getVisitType2_Value();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.VisitType2#getCustomerclass <em>Customerclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customerclass</em>'.
	 * @see jmtmodel.VisitType2#getCustomerclass()
	 * @see #getVisitType2()
	 * @generated
	 */
	EAttribute getVisitType2_Customerclass();

	/**
	 * Returns the meta object for class '{@link jmtmodel.WhatIfType <em>What If Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>What If Type</em>'.
	 * @see jmtmodel.WhatIfType
	 * @generated
	 */
	EClass getWhatIfType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.WhatIfType#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see jmtmodel.WhatIfType#getClassName()
	 * @see #getWhatIfType()
	 * @generated
	 */
	EAttribute getWhatIfType_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.WhatIfType#getStationName <em>Station Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Station Name</em>'.
	 * @see jmtmodel.WhatIfType#getStationName()
	 * @see #getWhatIfType()
	 * @generated
	 */
	EAttribute getWhatIfType_StationName();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.WhatIfType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see jmtmodel.WhatIfType#getType()
	 * @see #getWhatIfType()
	 * @generated
	 */
	EAttribute getWhatIfType_Type();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.WhatIfType#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Values</em>'.
	 * @see jmtmodel.WhatIfType#getValues()
	 * @see #getWhatIfType()
	 * @generated
	 */
	EAttribute getWhatIfType_Values();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ReferenceStationType <em>Reference Station Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Station Type</em>'.
	 * @see jmtmodel.ReferenceStationType
	 * @generated
	 */
	EClass getReferenceStationType();

	/**
	 * Returns the meta object for the containment reference list '{@link jmtmodel.ReferenceStationType#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class</em>'.
	 * @see jmtmodel.ReferenceStationType#getClass_()
	 * @see #getReferenceStationType()
	 * @generated
	 */
	EReference getReferenceStationType_Class();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ReferenceStationType#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see jmtmodel.ReferenceStationType#getNumber()
	 * @see #getReferenceStationType()
	 * @generated
	 */
	EAttribute getReferenceStationType_Number();

	/**
	 * Returns the meta object for class '{@link jmtmodel.ClassType <em>Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Type</em>'.
	 * @see jmtmodel.ClassType
	 * @generated
	 */
	EClass getClassType();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClassType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jmtmodel.ClassType#getName()
	 * @see #getClassType()
	 * @generated
	 */
	EAttribute getClassType_Name();

	/**
	 * Returns the meta object for the attribute '{@link jmtmodel.ClassType#getRefStation <em>Ref Station</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Station</em>'.
	 * @see jmtmodel.ClassType#getRefStation()
	 * @see #getClassType()
	 * @generated
	 */
	EAttribute getClassType_RefStation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JmtmodelFactory getJmtmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link jmtmodel.impl.BlockingRegionTypeImpl <em>Blocking Region Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.BlockingRegionTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getBlockingRegionType()
		 * @generated
		 */
		EClass BLOCKING_REGION_TYPE = eINSTANCE.getBlockingRegionType();

		/**
		 * The meta object literal for the '<em><b>Region Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCKING_REGION_TYPE__REGION_NODE = eINSTANCE.getBlockingRegionType_RegionNode();

		/**
		 * The meta object literal for the '<em><b>Global Constraint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCKING_REGION_TYPE__GLOBAL_CONSTRAINT = eINSTANCE.getBlockingRegionType_GlobalConstraint();

		/**
		 * The meta object literal for the '<em><b>Class Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCKING_REGION_TYPE__CLASS_CONSTRAINT = eINSTANCE.getBlockingRegionType_ClassConstraint();

		/**
		 * The meta object literal for the '<em><b>Class Weight</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCKING_REGION_TYPE__CLASS_WEIGHT = eINSTANCE.getBlockingRegionType_ClassWeight();

		/**
		 * The meta object literal for the '<em><b>Drop Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCKING_REGION_TYPE__DROP_RULES = eINSTANCE.getBlockingRegionType_DropRules();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCKING_REGION_TYPE__NAME = eINSTANCE.getBlockingRegionType_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCKING_REGION_TYPE__TYPE = eINSTANCE.getBlockingRegionType_Type();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ClassConstraintTypeImpl <em>Class Constraint Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ClassConstraintTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassConstraintType()
		 * @generated
		 */
		EClass CLASS_CONSTRAINT_TYPE = eINSTANCE.getClassConstraintType();

		/**
		 * The meta object literal for the '<em><b>Job Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_CONSTRAINT_TYPE__JOB_CLASS = eINSTANCE.getClassConstraintType_JobClass();

		/**
		 * The meta object literal for the '<em><b>Max Jobs Per Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_CONSTRAINT_TYPE__MAX_JOBS_PER_CLASS = eINSTANCE.getClassConstraintType_MaxJobsPerClass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ClassesTypeImpl <em>Classes Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ClassesTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassesType()
		 * @generated
		 */
		EClass CLASSES_TYPE = eINSTANCE.getClassesType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSES_TYPE__GROUP = eINSTANCE.getClassesType_Group();

		/**
		 * The meta object literal for the '<em><b>Closedclass</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSES_TYPE__CLOSEDCLASS = eINSTANCE.getClassesType_Closedclass();

		/**
		 * The meta object literal for the '<em><b>Openclass</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSES_TYPE__OPENCLASS = eINSTANCE.getClassesType_Openclass();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSES_TYPE__NUMBER = eINSTANCE.getClassesType_Number();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ClassresultsTypeImpl <em>Classresults Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ClassresultsTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassresultsType()
		 * @generated
		 */
		EClass CLASSRESULTS_TYPE = eINSTANCE.getClassresultsType();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSRESULTS_TYPE__MEASURE = eINSTANCE.getClassresultsType_Measure();

		/**
		 * The meta object literal for the '<em><b>Customerclass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSRESULTS_TYPE__CUSTOMERCLASS = eINSTANCE.getClassresultsType_Customerclass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ClassresultsType1Impl <em>Classresults Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ClassresultsType1Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassresultsType1()
		 * @generated
		 */
		EClass CLASSRESULTS_TYPE1 = eINSTANCE.getClassresultsType1();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSRESULTS_TYPE1__MEASURE = eINSTANCE.getClassresultsType1_Measure();

		/**
		 * The meta object literal for the '<em><b>Customerclass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASSRESULTS_TYPE1__CUSTOMERCLASS = eINSTANCE.getClassresultsType1_Customerclass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ClassWeightTypeImpl <em>Class Weight Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ClassWeightTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassWeightType()
		 * @generated
		 */
		EClass CLASS_WEIGHT_TYPE = eINSTANCE.getClassWeightType();

		/**
		 * The meta object literal for the '<em><b>Job Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_WEIGHT_TYPE__JOB_CLASS = eINSTANCE.getClassWeightType_JobClass();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_WEIGHT_TYPE__WEIGHT = eINSTANCE.getClassWeightType_Weight();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ClosedclassTypeImpl <em>Closedclass Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ClosedclassTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getClosedclassType()
		 * @generated
		 */
		EClass CLOSEDCLASS_TYPE = eINSTANCE.getClosedclassType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSEDCLASS_TYPE__NAME = eINSTANCE.getClosedclassType_Name();

		/**
		 * The meta object literal for the '<em><b>Population</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOSEDCLASS_TYPE__POPULATION = eINSTANCE.getClosedclassType_Population();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.DelaystationTypeImpl <em>Delaystation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.DelaystationTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getDelaystationType()
		 * @generated
		 */
		EClass DELAYSTATION_TYPE = eINSTANCE.getDelaystationType();

		/**
		 * The meta object literal for the '<em><b>Servicetimes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELAYSTATION_TYPE__SERVICETIMES = eINSTANCE.getDelaystationType_Servicetimes();

		/**
		 * The meta object literal for the '<em><b>Visits</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELAYSTATION_TYPE__VISITS = eINSTANCE.getDelaystationType_Visits();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELAYSTATION_TYPE__NAME = eINSTANCE.getDelaystationType_Name();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.DocumentRootImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__MODEL = eINSTANCE.getDocumentRoot_Model();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.DropRulesTypeImpl <em>Drop Rules Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.DropRulesTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getDropRulesType()
		 * @generated
		 */
		EClass DROP_RULES_TYPE = eINSTANCE.getDropRulesType();

		/**
		 * The meta object literal for the '<em><b>Drop This Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DROP_RULES_TYPE__DROP_THIS_CLASS = eINSTANCE.getDropRulesType_DropThisClass();

		/**
		 * The meta object literal for the '<em><b>Job Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DROP_RULES_TYPE__JOB_CLASS = eINSTANCE.getDropRulesType_JobClass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.GlobalConstraintTypeImpl <em>Global Constraint Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.GlobalConstraintTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getGlobalConstraintType()
		 * @generated
		 */
		EClass GLOBAL_CONSTRAINT_TYPE = eINSTANCE.getGlobalConstraintType();

		/**
		 * The meta object literal for the '<em><b>Max Jobs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_CONSTRAINT_TYPE__MAX_JOBS = eINSTANCE.getGlobalConstraintType_MaxJobs();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.LdstationTypeImpl <em>Ldstation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.LdstationTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getLdstationType()
		 * @generated
		 */
		EClass LDSTATION_TYPE = eINSTANCE.getLdstationType();

		/**
		 * The meta object literal for the '<em><b>Servicetimes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDSTATION_TYPE__SERVICETIMES = eINSTANCE.getLdstationType_Servicetimes();

		/**
		 * The meta object literal for the '<em><b>Visits</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LDSTATION_TYPE__VISITS = eINSTANCE.getLdstationType_Visits();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LDSTATION_TYPE__NAME = eINSTANCE.getLdstationType_Name();

		/**
		 * The meta object literal for the '<em><b>Servers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LDSTATION_TYPE__SERVERS = eINSTANCE.getLdstationType_Servers();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ListationTypeImpl <em>Listation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ListationTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getListationType()
		 * @generated
		 */
		EClass LISTATION_TYPE = eINSTANCE.getListationType();

		/**
		 * The meta object literal for the '<em><b>Servicetimes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LISTATION_TYPE__SERVICETIMES = eINSTANCE.getListationType_Servicetimes();

		/**
		 * The meta object literal for the '<em><b>Visits</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LISTATION_TYPE__VISITS = eINSTANCE.getListationType_Visits();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LISTATION_TYPE__NAME = eINSTANCE.getListationType_Name();

		/**
		 * The meta object literal for the '<em><b>Servers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LISTATION_TYPE__SERVERS = eINSTANCE.getListationType_Servers();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.MeasureTypeImpl <em>Measure Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.MeasureTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getMeasureType()
		 * @generated
		 */
		EClass MEASURE_TYPE = eINSTANCE.getMeasureType();

		/**
		 * The meta object literal for the '<em><b>Alfa</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__ALFA = eINSTANCE.getMeasureType_Alfa();

		/**
		 * The meta object literal for the '<em><b>Analyzed Samples</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__ANALYZED_SAMPLES = eINSTANCE.getMeasureType_AnalyzedSamples();

		/**
		 * The meta object literal for the '<em><b>Discarded Samples</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__DISCARDED_SAMPLES = eINSTANCE.getMeasureType_DiscardedSamples();

		/**
		 * The meta object literal for the '<em><b>Lower Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__LOWER_LIMIT = eINSTANCE.getMeasureType_LowerLimit();

		/**
		 * The meta object literal for the '<em><b>Max Samples</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__MAX_SAMPLES = eINSTANCE.getMeasureType_MaxSamples();

		/**
		 * The meta object literal for the '<em><b>Mean Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__MEAN_VALUE = eINSTANCE.getMeasureType_MeanValue();

		/**
		 * The meta object literal for the '<em><b>Measure Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__MEASURE_TYPE = eINSTANCE.getMeasureType_MeasureType();

		/**
		 * The meta object literal for the '<em><b>Node Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__NODE_TYPE = eINSTANCE.getMeasureType_NodeType();

		/**
		 * The meta object literal for the '<em><b>Precision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__PRECISION = eINSTANCE.getMeasureType_Precision();

		/**
		 * The meta object literal for the '<em><b>Successful</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__SUCCESSFUL = eINSTANCE.getMeasureType_Successful();

		/**
		 * The meta object literal for the '<em><b>Upper Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE__UPPER_LIMIT = eINSTANCE.getMeasureType_UpperLimit();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.MeasureType1Impl <em>Measure Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.MeasureType1Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getMeasureType1()
		 * @generated
		 */
		EClass MEASURE_TYPE1 = eINSTANCE.getMeasureType1();

		/**
		 * The meta object literal for the '<em><b>Alfa</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__ALFA = eINSTANCE.getMeasureType1_Alfa();

		/**
		 * The meta object literal for the '<em><b>Analyzed Samples</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__ANALYZED_SAMPLES = eINSTANCE.getMeasureType1_AnalyzedSamples();

		/**
		 * The meta object literal for the '<em><b>Discarded Samples</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__DISCARDED_SAMPLES = eINSTANCE.getMeasureType1_DiscardedSamples();

		/**
		 * The meta object literal for the '<em><b>Lower Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__LOWER_LIMIT = eINSTANCE.getMeasureType1_LowerLimit();

		/**
		 * The meta object literal for the '<em><b>Max Samples</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__MAX_SAMPLES = eINSTANCE.getMeasureType1_MaxSamples();

		/**
		 * The meta object literal for the '<em><b>Mean Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__MEAN_VALUE = eINSTANCE.getMeasureType1_MeanValue();

		/**
		 * The meta object literal for the '<em><b>Measure Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__MEASURE_TYPE = eINSTANCE.getMeasureType1_MeasureType();

		/**
		 * The meta object literal for the '<em><b>Node Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__NODE_TYPE = eINSTANCE.getMeasureType1_NodeType();

		/**
		 * The meta object literal for the '<em><b>Precision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__PRECISION = eINSTANCE.getMeasureType1_Precision();

		/**
		 * The meta object literal for the '<em><b>Successful</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__SUCCESSFUL = eINSTANCE.getMeasureType1_Successful();

		/**
		 * The meta object literal for the '<em><b>Upper Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURE_TYPE1__UPPER_LIMIT = eINSTANCE.getMeasureType1_UpperLimit();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ModelTypeImpl <em>Model Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ModelTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getModelType()
		 * @generated
		 */
		EClass MODEL_TYPE = eINSTANCE.getModelType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TYPE__DESCRIPTION = eINSTANCE.getModelType_Description();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__PARAMETERS = eINSTANCE.getModelType_Parameters();

		/**
		 * The meta object literal for the '<em><b>Blocking Region</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__BLOCKING_REGION = eINSTANCE.getModelType_BlockingRegion();

		/**
		 * The meta object literal for the '<em><b>What If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__WHAT_IF = eINSTANCE.getModelType_WhatIf();

		/**
		 * The meta object literal for the '<em><b>Solutions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__SOLUTIONS = eINSTANCE.getModelType_Solutions();

		/**
		 * The meta object literal for the '<em><b>Jaba</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TYPE__JABA = eINSTANCE.getModelType_Jaba();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.OpenclassTypeImpl <em>Openclass Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.OpenclassTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getOpenclassType()
		 * @generated
		 */
		EClass OPENCLASS_TYPE = eINSTANCE.getOpenclassType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPENCLASS_TYPE__NAME = eINSTANCE.getOpenclassType_Name();

		/**
		 * The meta object literal for the '<em><b>Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPENCLASS_TYPE__RATE = eINSTANCE.getOpenclassType_Rate();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ParametersTypeImpl <em>Parameters Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ParametersTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getParametersType()
		 * @generated
		 */
		EClass PARAMETERS_TYPE = eINSTANCE.getParametersType();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERS_TYPE__CLASSES = eINSTANCE.getParametersType_Classes();

		/**
		 * The meta object literal for the '<em><b>Stations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERS_TYPE__STATIONS = eINSTANCE.getParametersType_Stations();

		/**
		 * The meta object literal for the '<em><b>Reference Station</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERS_TYPE__REFERENCE_STATION = eINSTANCE.getParametersType_ReferenceStation();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.RegionNodeTypeImpl <em>Region Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.RegionNodeTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getRegionNodeType()
		 * @generated
		 */
		EClass REGION_NODE_TYPE = eINSTANCE.getRegionNodeType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGION_NODE_TYPE__VALUE = eINSTANCE.getRegionNodeType_Value();

		/**
		 * The meta object literal for the '<em><b>Node Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGION_NODE_TYPE__NODE_NAME = eINSTANCE.getRegionNodeType_NodeName();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.RegionresultsTypeImpl <em>Regionresults Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.RegionresultsTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getRegionresultsType()
		 * @generated
		 */
		EClass REGIONRESULTS_TYPE = eINSTANCE.getRegionresultsType();

		/**
		 * The meta object literal for the '<em><b>Classresults</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGIONRESULTS_TYPE__CLASSRESULTS = eINSTANCE.getRegionresultsType_Classresults();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGIONRESULTS_TYPE__REGION = eINSTANCE.getRegionresultsType_Region();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ServicetimesTypeImpl <em>Servicetimes Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ServicetimesTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimesType()
		 * @generated
		 */
		EClass SERVICETIMES_TYPE = eINSTANCE.getServicetimesType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICETIMES_TYPE__VALUE = eINSTANCE.getServicetimesType_Value();

		/**
		 * The meta object literal for the '<em><b>Customerclass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICETIMES_TYPE__CUSTOMERCLASS = eINSTANCE.getServicetimesType_Customerclass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ServicetimesType1Impl <em>Servicetimes Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ServicetimesType1Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimesType1()
		 * @generated
		 */
		EClass SERVICETIMES_TYPE1 = eINSTANCE.getServicetimesType1();

		/**
		 * The meta object literal for the '<em><b>Servicetime</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICETIMES_TYPE1__SERVICETIME = eINSTANCE.getServicetimesType1_Servicetime();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ServicetimesType2Impl <em>Servicetimes Type2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ServicetimesType2Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimesType2()
		 * @generated
		 */
		EClass SERVICETIMES_TYPE2 = eINSTANCE.getServicetimesType2();

		/**
		 * The meta object literal for the '<em><b>Servicetimes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICETIMES_TYPE2__SERVICETIMES = eINSTANCE.getServicetimesType2_Servicetimes();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ServicetimesType3Impl <em>Servicetimes Type3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ServicetimesType3Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimesType3()
		 * @generated
		 */
		EClass SERVICETIMES_TYPE3 = eINSTANCE.getServicetimesType3();

		/**
		 * The meta object literal for the '<em><b>Servicetime</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICETIMES_TYPE3__SERVICETIME = eINSTANCE.getServicetimesType3_Servicetime();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ServicetimeTypeImpl <em>Servicetime Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ServicetimeTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimeType()
		 * @generated
		 */
		EClass SERVICETIME_TYPE = eINSTANCE.getServicetimeType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICETIME_TYPE__VALUE = eINSTANCE.getServicetimeType_Value();

		/**
		 * The meta object literal for the '<em><b>Customerclass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICETIME_TYPE__CUSTOMERCLASS = eINSTANCE.getServicetimeType_Customerclass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ServicetimeType1Impl <em>Servicetime Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ServicetimeType1Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getServicetimeType1()
		 * @generated
		 */
		EClass SERVICETIME_TYPE1 = eINSTANCE.getServicetimeType1();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICETIME_TYPE1__VALUE = eINSTANCE.getServicetimeType1_Value();

		/**
		 * The meta object literal for the '<em><b>Customerclass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICETIME_TYPE1__CUSTOMERCLASS = eINSTANCE.getServicetimeType1_Customerclass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.SolutionsTypeImpl <em>Solutions Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.SolutionsTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getSolutionsType()
		 * @generated
		 */
		EClass SOLUTIONS_TYPE = eINSTANCE.getSolutionsType();

		/**
		 * The meta object literal for the '<em><b>Stationresults</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTIONS_TYPE__STATIONRESULTS = eINSTANCE.getSolutionsType_Stationresults();

		/**
		 * The meta object literal for the '<em><b>Regionresults</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTIONS_TYPE__REGIONRESULTS = eINSTANCE.getSolutionsType_Regionresults();

		/**
		 * The meta object literal for the '<em><b>Iteration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTIONS_TYPE__ITERATION = eINSTANCE.getSolutionsType_Iteration();

		/**
		 * The meta object literal for the '<em><b>Iteration Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTIONS_TYPE__ITERATION_VALUE = eINSTANCE.getSolutionsType_IterationValue();

		/**
		 * The meta object literal for the '<em><b>Ok</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTIONS_TYPE__OK = eINSTANCE.getSolutionsType_Ok();

		/**
		 * The meta object literal for the '<em><b>Solution Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTIONS_TYPE__SOLUTION_METHOD = eINSTANCE.getSolutionsType_SolutionMethod();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.StationresultsTypeImpl <em>Stationresults Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.StationresultsTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getStationresultsType()
		 * @generated
		 */
		EClass STATIONRESULTS_TYPE = eINSTANCE.getStationresultsType();

		/**
		 * The meta object literal for the '<em><b>Classresults</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIONRESULTS_TYPE__CLASSRESULTS = eINSTANCE.getStationresultsType_Classresults();

		/**
		 * The meta object literal for the '<em><b>Station</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIONRESULTS_TYPE__STATION = eINSTANCE.getStationresultsType_Station();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.StationsTypeImpl <em>Stations Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.StationsTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getStationsType()
		 * @generated
		 */
		EClass STATIONS_TYPE = eINSTANCE.getStationsType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIONS_TYPE__GROUP = eINSTANCE.getStationsType_Group();

		/**
		 * The meta object literal for the '<em><b>Delaystation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIONS_TYPE__DELAYSTATION = eINSTANCE.getStationsType_Delaystation();

		/**
		 * The meta object literal for the '<em><b>Listation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIONS_TYPE__LISTATION = eINSTANCE.getStationsType_Listation();

		/**
		 * The meta object literal for the '<em><b>Ldstation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIONS_TYPE__LDSTATION = eINSTANCE.getStationsType_Ldstation();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIONS_TYPE__NUMBER = eINSTANCE.getStationsType_Number();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.VisitsTypeImpl <em>Visits Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.VisitsTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitsType()
		 * @generated
		 */
		EClass VISITS_TYPE = eINSTANCE.getVisitsType();

		/**
		 * The meta object literal for the '<em><b>Visit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISITS_TYPE__VISIT = eINSTANCE.getVisitsType_Visit();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.VisitsType1Impl <em>Visits Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.VisitsType1Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitsType1()
		 * @generated
		 */
		EClass VISITS_TYPE1 = eINSTANCE.getVisitsType1();

		/**
		 * The meta object literal for the '<em><b>Visit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISITS_TYPE1__VISIT = eINSTANCE.getVisitsType1_Visit();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.VisitsType2Impl <em>Visits Type2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.VisitsType2Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitsType2()
		 * @generated
		 */
		EClass VISITS_TYPE2 = eINSTANCE.getVisitsType2();

		/**
		 * The meta object literal for the '<em><b>Visit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISITS_TYPE2__VISIT = eINSTANCE.getVisitsType2_Visit();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.VisitTypeImpl <em>Visit Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.VisitTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitType()
		 * @generated
		 */
		EClass VISIT_TYPE = eINSTANCE.getVisitType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIT_TYPE__VALUE = eINSTANCE.getVisitType_Value();

		/**
		 * The meta object literal for the '<em><b>Customerclass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIT_TYPE__CUSTOMERCLASS = eINSTANCE.getVisitType_Customerclass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.VisitType1Impl <em>Visit Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.VisitType1Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitType1()
		 * @generated
		 */
		EClass VISIT_TYPE1 = eINSTANCE.getVisitType1();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIT_TYPE1__VALUE = eINSTANCE.getVisitType1_Value();

		/**
		 * The meta object literal for the '<em><b>Customerclass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIT_TYPE1__CUSTOMERCLASS = eINSTANCE.getVisitType1_Customerclass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.VisitType2Impl <em>Visit Type2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.VisitType2Impl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getVisitType2()
		 * @generated
		 */
		EClass VISIT_TYPE2 = eINSTANCE.getVisitType2();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIT_TYPE2__VALUE = eINSTANCE.getVisitType2_Value();

		/**
		 * The meta object literal for the '<em><b>Customerclass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIT_TYPE2__CUSTOMERCLASS = eINSTANCE.getVisitType2_Customerclass();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.WhatIfTypeImpl <em>What If Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.WhatIfTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getWhatIfType()
		 * @generated
		 */
		EClass WHAT_IF_TYPE = eINSTANCE.getWhatIfType();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHAT_IF_TYPE__CLASS_NAME = eINSTANCE.getWhatIfType_ClassName();

		/**
		 * The meta object literal for the '<em><b>Station Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHAT_IF_TYPE__STATION_NAME = eINSTANCE.getWhatIfType_StationName();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHAT_IF_TYPE__TYPE = eINSTANCE.getWhatIfType_Type();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHAT_IF_TYPE__VALUES = eINSTANCE.getWhatIfType_Values();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ReferenceStationTypeImpl <em>Reference Station Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ReferenceStationTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getReferenceStationType()
		 * @generated
		 */
		EClass REFERENCE_STATION_TYPE = eINSTANCE.getReferenceStationType();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_STATION_TYPE__CLASS = eINSTANCE.getReferenceStationType_Class();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_STATION_TYPE__NUMBER = eINSTANCE.getReferenceStationType_Number();

		/**
		 * The meta object literal for the '{@link jmtmodel.impl.ClassTypeImpl <em>Class Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jmtmodel.impl.ClassTypeImpl
		 * @see jmtmodel.impl.JmtmodelPackageImpl#getClassType()
		 * @generated
		 */
		EClass CLASS_TYPE = eINSTANCE.getClassType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_TYPE__NAME = eINSTANCE.getClassType_Name();

		/**
		 * The meta object literal for the '<em><b>Ref Station</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_TYPE__REF_STATION = eINSTANCE.getClassType_RefStation();

	}

} //JmtmodelPackage
