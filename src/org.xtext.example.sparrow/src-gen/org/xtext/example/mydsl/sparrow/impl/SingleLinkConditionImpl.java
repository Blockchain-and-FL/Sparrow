/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.mydsl.sparrow.ConditionLink;
import org.xtext.example.mydsl.sparrow.SingleLinkCondition;
import org.xtext.example.mydsl.sparrow.SparrowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Link Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.SingleLinkConditionImpl#getNo <em>No</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.SingleLinkConditionImpl#getLinkCondition <em>Link Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleLinkConditionImpl extends MinimalEObjectImpl.Container implements SingleLinkCondition
{
  /**
   * The default value of the '{@link #getNo() <em>No</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNo()
   * @generated
   * @ordered
   */
  protected static final String NO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNo() <em>No</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNo()
   * @generated
   * @ordered
   */
  protected String no = NO_EDEFAULT;

  /**
   * The cached value of the '{@link #getLinkCondition() <em>Link Condition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinkCondition()
   * @generated
   * @ordered
   */
  protected ConditionLink linkCondition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleLinkConditionImpl()
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
    return SparrowPackage.Literals.SINGLE_LINK_CONDITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getNo()
  {
    return no;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNo(String newNo)
  {
    String oldNo = no;
    no = newNo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.SINGLE_LINK_CONDITION__NO, oldNo, no));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConditionLink getLinkCondition()
  {
    if (linkCondition != null && linkCondition.eIsProxy())
    {
      InternalEObject oldLinkCondition = (InternalEObject)linkCondition;
      linkCondition = (ConditionLink)eResolveProxy(oldLinkCondition);
      if (linkCondition != oldLinkCondition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SparrowPackage.SINGLE_LINK_CONDITION__LINK_CONDITION, oldLinkCondition, linkCondition));
      }
    }
    return linkCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionLink basicGetLinkCondition()
  {
    return linkCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLinkCondition(ConditionLink newLinkCondition)
  {
    ConditionLink oldLinkCondition = linkCondition;
    linkCondition = newLinkCondition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.SINGLE_LINK_CONDITION__LINK_CONDITION, oldLinkCondition, linkCondition));
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
      case SparrowPackage.SINGLE_LINK_CONDITION__NO:
        return getNo();
      case SparrowPackage.SINGLE_LINK_CONDITION__LINK_CONDITION:
        if (resolve) return getLinkCondition();
        return basicGetLinkCondition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SparrowPackage.SINGLE_LINK_CONDITION__NO:
        setNo((String)newValue);
        return;
      case SparrowPackage.SINGLE_LINK_CONDITION__LINK_CONDITION:
        setLinkCondition((ConditionLink)newValue);
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
      case SparrowPackage.SINGLE_LINK_CONDITION__NO:
        setNo(NO_EDEFAULT);
        return;
      case SparrowPackage.SINGLE_LINK_CONDITION__LINK_CONDITION:
        setLinkCondition((ConditionLink)null);
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
      case SparrowPackage.SINGLE_LINK_CONDITION__NO:
        return NO_EDEFAULT == null ? no != null : !NO_EDEFAULT.equals(no);
      case SparrowPackage.SINGLE_LINK_CONDITION__LINK_CONDITION:
        return linkCondition != null;
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
    result.append(" (no: ");
    result.append(no);
    result.append(')');
    return result.toString();
  }

} //SingleLinkConditionImpl
