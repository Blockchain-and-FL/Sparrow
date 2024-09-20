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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.sparrow.SparrowPackage;
import org.xtext.example.mydsl.sparrow.Subject;
import org.xtext.example.mydsl.sparrow.Value;
import org.xtext.example.mydsl.sparrow.initExpressions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>init Expressions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.initExpressionsImpl#getSubtype <em>Subtype</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.initExpressionsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.initExpressionsImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class initExpressionsImpl extends MinimalEObjectImpl.Container implements initExpressions
{
  /**
   * The cached value of the '{@link #getSubtype() <em>Subtype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubtype()
   * @generated
   * @ordered
   */
  protected Subject subtype;

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
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected EList<Value> value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected initExpressionsImpl()
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
    return SparrowPackage.Literals.INIT_EXPRESSIONS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Subject getSubtype()
  {
    if (subtype != null && subtype.eIsProxy())
    {
      InternalEObject oldSubtype = (InternalEObject)subtype;
      subtype = (Subject)eResolveProxy(oldSubtype);
      if (subtype != oldSubtype)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SparrowPackage.INIT_EXPRESSIONS__SUBTYPE, oldSubtype, subtype));
      }
    }
    return subtype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Subject basicGetSubtype()
  {
    return subtype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSubtype(Subject newSubtype)
  {
    Subject oldSubtype = subtype;
    subtype = newSubtype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.INIT_EXPRESSIONS__SUBTYPE, oldSubtype, subtype));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.INIT_EXPRESSIONS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Value> getValue()
  {
    if (value == null)
    {
      value = new EObjectContainmentEList<Value>(Value.class, this, SparrowPackage.INIT_EXPRESSIONS__VALUE);
    }
    return value;
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
      case SparrowPackage.INIT_EXPRESSIONS__VALUE:
        return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
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
      case SparrowPackage.INIT_EXPRESSIONS__SUBTYPE:
        if (resolve) return getSubtype();
        return basicGetSubtype();
      case SparrowPackage.INIT_EXPRESSIONS__NAME:
        return getName();
      case SparrowPackage.INIT_EXPRESSIONS__VALUE:
        return getValue();
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
      case SparrowPackage.INIT_EXPRESSIONS__SUBTYPE:
        setSubtype((Subject)newValue);
        return;
      case SparrowPackage.INIT_EXPRESSIONS__NAME:
        setName((String)newValue);
        return;
      case SparrowPackage.INIT_EXPRESSIONS__VALUE:
        getValue().clear();
        getValue().addAll((Collection<? extends Value>)newValue);
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
      case SparrowPackage.INIT_EXPRESSIONS__SUBTYPE:
        setSubtype((Subject)null);
        return;
      case SparrowPackage.INIT_EXPRESSIONS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SparrowPackage.INIT_EXPRESSIONS__VALUE:
        getValue().clear();
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
      case SparrowPackage.INIT_EXPRESSIONS__SUBTYPE:
        return subtype != null;
      case SparrowPackage.INIT_EXPRESSIONS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SparrowPackage.INIT_EXPRESSIONS__VALUE:
        return value != null && !value.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //initExpressionsImpl