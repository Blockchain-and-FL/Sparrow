/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.sparrow.OperateLink;
import org.xtext.example.mydsl.sparrow.Operation;
import org.xtext.example.mydsl.sparrow.SparrowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.OperationImpl#getOperates <em>Operates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends MinimalEObjectImpl.Container implements Operation
{
  /**
   * The cached value of the '{@link #getOperates() <em>Operates</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperates()
   * @generated
   * @ordered
   */
  protected EList<OperateLink> operates;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationImpl()
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
    return SparrowPackage.Literals.OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<OperateLink> getOperates()
  {
    if (operates == null)
    {
      operates = new EObjectContainmentEList<OperateLink>(OperateLink.class, this, SparrowPackage.OPERATION__OPERATES);
    }
    return operates;
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
      case SparrowPackage.OPERATION__OPERATES:
        return ((InternalEList<?>)getOperates()).basicRemove(otherEnd, msgs);
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
      case SparrowPackage.OPERATION__OPERATES:
        return getOperates();
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
      case SparrowPackage.OPERATION__OPERATES:
        getOperates().clear();
        getOperates().addAll((Collection<? extends OperateLink>)newValue);
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
      case SparrowPackage.OPERATION__OPERATES:
        getOperates().clear();
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
      case SparrowPackage.OPERATION__OPERATES:
        return operates != null && !operates.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OperationImpl