/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.sparrow.Condition;
import org.xtext.example.mydsl.sparrow.ContractMessage;
import org.xtext.example.mydsl.sparrow.Group;
import org.xtext.example.mydsl.sparrow.Initialize;
import org.xtext.example.mydsl.sparrow.Model;
import org.xtext.example.mydsl.sparrow.Operation;
import org.xtext.example.mydsl.sparrow.Require;
import org.xtext.example.mydsl.sparrow.RuleStructure;
import org.xtext.example.mydsl.sparrow.SparrowPackage;
import org.xtext.example.mydsl.sparrow.Subject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getExtendName <em>Extend Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getSubjects <em>Subjects</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getInitialize <em>Initialize</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getContractMessage <em>Contract Message</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getRuleStructures <em>Rule Structures</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ModelImpl#getRequire <em>Require</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackageName()
   * @generated
   * @ordered
   */
  protected EList<String> packageName;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getExtendName() <em>Extend Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendName()
   * @generated
   * @ordered
   */
  protected static final String EXTEND_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtendName() <em>Extend Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendName()
   * @generated
   * @ordered
   */
  protected String extendName = EXTEND_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getSubjects() <em>Subjects</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubjects()
   * @generated
   * @ordered
   */
  protected EList<Subject> subjects;

  /**
   * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjects()
   * @generated
   * @ordered
   */
  protected EList<org.xtext.example.mydsl.sparrow.Object> objects;

  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  protected EList<Group> group;

  /**
   * The cached value of the '{@link #getInitialize() <em>Initialize</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialize()
   * @generated
   * @ordered
   */
  protected Initialize initialize;

  /**
   * The cached value of the '{@link #getContractMessage() <em>Contract Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContractMessage()
   * @generated
   * @ordered
   */
  protected ContractMessage contractMessage;

  /**
   * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditions()
   * @generated
   * @ordered
   */
  protected Condition conditions;

  /**
   * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperations()
   * @generated
   * @ordered
   */
  protected Operation operations;

  /**
   * The cached value of the '{@link #getRuleStructures() <em>Rule Structures</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuleStructures()
   * @generated
   * @ordered
   */
  protected RuleStructure ruleStructures;

  /**
   * The cached value of the '{@link #getRequire() <em>Require</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequire()
   * @generated
   * @ordered
   */
  protected Require require;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SparrowPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getPackageName()
  {
    if (packageName == null)
    {
      packageName = new EDataTypeEList<String>(String.class, this, SparrowPackage.MODEL__PACKAGE_NAME);
    }
    return packageName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getExtendName()
  {
    return extendName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExtendName(String newExtendName)
  {
    String oldExtendName = extendName;
    extendName = newExtendName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__EXTEND_NAME, oldExtendName, extendName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Subject> getSubjects()
  {
    if (subjects == null)
    {
      subjects = new EObjectContainmentEList<Subject>(Subject.class, this, SparrowPackage.MODEL__SUBJECTS);
    }
    return subjects;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<org.xtext.example.mydsl.sparrow.Object> getObjects()
  {
    if (objects == null)
    {
      objects = new EObjectContainmentEList<org.xtext.example.mydsl.sparrow.Object>(org.xtext.example.mydsl.sparrow.Object.class, this, SparrowPackage.MODEL__OBJECTS);
    }
    return objects;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Group> getGroup()
  {
    if (group == null)
    {
      group = new EObjectContainmentEList<Group>(Group.class, this, SparrowPackage.MODEL__GROUP);
    }
    return group;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Initialize getInitialize()
  {
    return initialize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitialize(Initialize newInitialize, NotificationChain msgs)
  {
    Initialize oldInitialize = initialize;
    initialize = newInitialize;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__INITIALIZE, oldInitialize, newInitialize);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInitialize(Initialize newInitialize)
  {
    if (newInitialize != initialize)
    {
      NotificationChain msgs = null;
      if (initialize != null)
        msgs = ((InternalEObject)initialize).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__INITIALIZE, null, msgs);
      if (newInitialize != null)
        msgs = ((InternalEObject)newInitialize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__INITIALIZE, null, msgs);
      msgs = basicSetInitialize(newInitialize, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__INITIALIZE, newInitialize, newInitialize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContractMessage getContractMessage()
  {
    return contractMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContractMessage(ContractMessage newContractMessage, NotificationChain msgs)
  {
    ContractMessage oldContractMessage = contractMessage;
    contractMessage = newContractMessage;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__CONTRACT_MESSAGE, oldContractMessage, newContractMessage);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setContractMessage(ContractMessage newContractMessage)
  {
    if (newContractMessage != contractMessage)
    {
      NotificationChain msgs = null;
      if (contractMessage != null)
        msgs = ((InternalEObject)contractMessage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__CONTRACT_MESSAGE, null, msgs);
      if (newContractMessage != null)
        msgs = ((InternalEObject)newContractMessage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__CONTRACT_MESSAGE, null, msgs);
      msgs = basicSetContractMessage(newContractMessage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__CONTRACT_MESSAGE, newContractMessage, newContractMessage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Condition getConditions()
  {
    return conditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditions(Condition newConditions, NotificationChain msgs)
  {
    Condition oldConditions = conditions;
    conditions = newConditions;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__CONDITIONS, oldConditions, newConditions);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConditions(Condition newConditions)
  {
    if (newConditions != conditions)
    {
      NotificationChain msgs = null;
      if (conditions != null)
        msgs = ((InternalEObject)conditions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__CONDITIONS, null, msgs);
      if (newConditions != null)
        msgs = ((InternalEObject)newConditions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__CONDITIONS, null, msgs);
      msgs = basicSetConditions(newConditions, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__CONDITIONS, newConditions, newConditions));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Operation getOperations()
  {
    return operations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperations(Operation newOperations, NotificationChain msgs)
  {
    Operation oldOperations = operations;
    operations = newOperations;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__OPERATIONS, oldOperations, newOperations);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOperations(Operation newOperations)
  {
    if (newOperations != operations)
    {
      NotificationChain msgs = null;
      if (operations != null)
        msgs = ((InternalEObject)operations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__OPERATIONS, null, msgs);
      if (newOperations != null)
        msgs = ((InternalEObject)newOperations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__OPERATIONS, null, msgs);
      msgs = basicSetOperations(newOperations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__OPERATIONS, newOperations, newOperations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RuleStructure getRuleStructures()
  {
    return ruleStructures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRuleStructures(RuleStructure newRuleStructures, NotificationChain msgs)
  {
    RuleStructure oldRuleStructures = ruleStructures;
    ruleStructures = newRuleStructures;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__RULE_STRUCTURES, oldRuleStructures, newRuleStructures);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRuleStructures(RuleStructure newRuleStructures)
  {
    if (newRuleStructures != ruleStructures)
    {
      NotificationChain msgs = null;
      if (ruleStructures != null)
        msgs = ((InternalEObject)ruleStructures).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__RULE_STRUCTURES, null, msgs);
      if (newRuleStructures != null)
        msgs = ((InternalEObject)newRuleStructures).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__RULE_STRUCTURES, null, msgs);
      msgs = basicSetRuleStructures(newRuleStructures, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__RULE_STRUCTURES, newRuleStructures, newRuleStructures));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Require getRequire()
  {
    return require;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRequire(Require newRequire, NotificationChain msgs)
  {
    Require oldRequire = require;
    require = newRequire;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__REQUIRE, oldRequire, newRequire);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRequire(Require newRequire)
  {
    if (newRequire != require)
    {
      NotificationChain msgs = null;
      if (require != null)
        msgs = ((InternalEObject)require).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__REQUIRE, null, msgs);
      if (newRequire != null)
        msgs = ((InternalEObject)newRequire).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.MODEL__REQUIRE, null, msgs);
      msgs = basicSetRequire(newRequire, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.MODEL__REQUIRE, newRequire, newRequire));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SparrowPackage.MODEL__SUBJECTS:
        return ((InternalEList<?>)getSubjects()).basicRemove(otherEnd, msgs);
      case SparrowPackage.MODEL__OBJECTS:
        return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
      case SparrowPackage.MODEL__GROUP:
        return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
      case SparrowPackage.MODEL__INITIALIZE:
        return basicSetInitialize(null, msgs);
      case SparrowPackage.MODEL__CONTRACT_MESSAGE:
        return basicSetContractMessage(null, msgs);
      case SparrowPackage.MODEL__CONDITIONS:
        return basicSetConditions(null, msgs);
      case SparrowPackage.MODEL__OPERATIONS:
        return basicSetOperations(null, msgs);
      case SparrowPackage.MODEL__RULE_STRUCTURES:
        return basicSetRuleStructures(null, msgs);
      case SparrowPackage.MODEL__REQUIRE:
        return basicSetRequire(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SparrowPackage.MODEL__PACKAGE_NAME:
        return getPackageName();
      case SparrowPackage.MODEL__NAME:
        return getName();
      case SparrowPackage.MODEL__EXTEND_NAME:
        return getExtendName();
      case SparrowPackage.MODEL__SUBJECTS:
        return getSubjects();
      case SparrowPackage.MODEL__OBJECTS:
        return getObjects();
      case SparrowPackage.MODEL__GROUP:
        return getGroup();
      case SparrowPackage.MODEL__INITIALIZE:
        return getInitialize();
      case SparrowPackage.MODEL__CONTRACT_MESSAGE:
        return getContractMessage();
      case SparrowPackage.MODEL__CONDITIONS:
        return getConditions();
      case SparrowPackage.MODEL__OPERATIONS:
        return getOperations();
      case SparrowPackage.MODEL__RULE_STRUCTURES:
        return getRuleStructures();
      case SparrowPackage.MODEL__REQUIRE:
        return getRequire();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SparrowPackage.MODEL__PACKAGE_NAME:
        getPackageName().clear();
        getPackageName().addAll((Collection<? extends String>)newValue);
        return;
      case SparrowPackage.MODEL__NAME:
        setName((String)newValue);
        return;
      case SparrowPackage.MODEL__EXTEND_NAME:
        setExtendName((String)newValue);
        return;
      case SparrowPackage.MODEL__SUBJECTS:
        getSubjects().clear();
        getSubjects().addAll((Collection<? extends Subject>)newValue);
        return;
      case SparrowPackage.MODEL__OBJECTS:
        getObjects().clear();
        getObjects().addAll((Collection<? extends org.xtext.example.mydsl.sparrow.Object>)newValue);
        return;
      case SparrowPackage.MODEL__GROUP:
        getGroup().clear();
        getGroup().addAll((Collection<? extends Group>)newValue);
        return;
      case SparrowPackage.MODEL__INITIALIZE:
        setInitialize((Initialize)newValue);
        return;
      case SparrowPackage.MODEL__CONTRACT_MESSAGE:
        setContractMessage((ContractMessage)newValue);
        return;
      case SparrowPackage.MODEL__CONDITIONS:
        setConditions((Condition)newValue);
        return;
      case SparrowPackage.MODEL__OPERATIONS:
        setOperations((Operation)newValue);
        return;
      case SparrowPackage.MODEL__RULE_STRUCTURES:
        setRuleStructures((RuleStructure)newValue);
        return;
      case SparrowPackage.MODEL__REQUIRE:
        setRequire((Require)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SparrowPackage.MODEL__PACKAGE_NAME:
        getPackageName().clear();
        return;
      case SparrowPackage.MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SparrowPackage.MODEL__EXTEND_NAME:
        setExtendName(EXTEND_NAME_EDEFAULT);
        return;
      case SparrowPackage.MODEL__SUBJECTS:
        getSubjects().clear();
        return;
      case SparrowPackage.MODEL__OBJECTS:
        getObjects().clear();
        return;
      case SparrowPackage.MODEL__GROUP:
        getGroup().clear();
        return;
      case SparrowPackage.MODEL__INITIALIZE:
        setInitialize((Initialize)null);
        return;
      case SparrowPackage.MODEL__CONTRACT_MESSAGE:
        setContractMessage((ContractMessage)null);
        return;
      case SparrowPackage.MODEL__CONDITIONS:
        setConditions((Condition)null);
        return;
      case SparrowPackage.MODEL__OPERATIONS:
        setOperations((Operation)null);
        return;
      case SparrowPackage.MODEL__RULE_STRUCTURES:
        setRuleStructures((RuleStructure)null);
        return;
      case SparrowPackage.MODEL__REQUIRE:
        setRequire((Require)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SparrowPackage.MODEL__PACKAGE_NAME:
        return packageName != null && !packageName.isEmpty();
      case SparrowPackage.MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SparrowPackage.MODEL__EXTEND_NAME:
        return EXTEND_NAME_EDEFAULT == null ? extendName != null : !EXTEND_NAME_EDEFAULT.equals(extendName);
      case SparrowPackage.MODEL__SUBJECTS:
        return subjects != null && !subjects.isEmpty();
      case SparrowPackage.MODEL__OBJECTS:
        return objects != null && !objects.isEmpty();
      case SparrowPackage.MODEL__GROUP:
        return group != null && !group.isEmpty();
      case SparrowPackage.MODEL__INITIALIZE:
        return initialize != null;
      case SparrowPackage.MODEL__CONTRACT_MESSAGE:
        return contractMessage != null;
      case SparrowPackage.MODEL__CONDITIONS:
        return conditions != null;
      case SparrowPackage.MODEL__OPERATIONS:
        return operations != null;
      case SparrowPackage.MODEL__RULE_STRUCTURES:
        return ruleStructures != null;
      case SparrowPackage.MODEL__REQUIRE:
        return require != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (packageName: ");
    result.append(packageName);
    result.append(", name: ");
    result.append(name);
    result.append(", extendName: ");
    result.append(extendName);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
