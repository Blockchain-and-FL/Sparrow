/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.mydsl.sparrow.ElseExpression;
import org.xtext.example.mydsl.sparrow.SparrowPackage;
import org.xtext.example.mydsl.sparrow.TotalCondition;
import org.xtext.example.mydsl.sparrow.TotalExpression;
import org.xtext.example.mydsl.sparrow.TotalOperation;
import org.xtext.example.mydsl.sparrow.messageExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Total Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.TotalExpressionImpl#getSet <em>Set</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.TotalExpressionImpl#getTotalCondition <em>Total Condition</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.TotalExpressionImpl#getTotalOperation <em>Total Operation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.TotalExpressionImpl#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TotalExpressionImpl extends MinimalEObjectImpl.Container implements TotalExpression
{
  /**
   * The cached value of the '{@link #getSet() <em>Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSet()
   * @generated
   * @ordered
   */
  protected messageExpression set;

  /**
   * The cached value of the '{@link #getTotalCondition() <em>Total Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTotalCondition()
   * @generated
   * @ordered
   */
  protected TotalCondition totalCondition;

  /**
   * The cached value of the '{@link #getTotalOperation() <em>Total Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTotalOperation()
   * @generated
   * @ordered
   */
  protected TotalOperation totalOperation;

  /**
   * The cached value of the '{@link #getElseExpression() <em>Else Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseExpression()
   * @generated
   * @ordered
   */
  protected ElseExpression elseExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TotalExpressionImpl()
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
    return SparrowPackage.Literals.TOTAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public messageExpression getSet()
  {
    return set;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSet(messageExpression newSet, NotificationChain msgs)
  {
    messageExpression oldSet = set;
    set = newSet;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.TOTAL_EXPRESSION__SET, oldSet, newSet);
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
  public void setSet(messageExpression newSet)
  {
    if (newSet != set)
    {
      NotificationChain msgs = null;
      if (set != null)
        msgs = ((InternalEObject)set).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.TOTAL_EXPRESSION__SET, null, msgs);
      if (newSet != null)
        msgs = ((InternalEObject)newSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.TOTAL_EXPRESSION__SET, null, msgs);
      msgs = basicSetSet(newSet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.TOTAL_EXPRESSION__SET, newSet, newSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TotalCondition getTotalCondition()
  {
    return totalCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTotalCondition(TotalCondition newTotalCondition, NotificationChain msgs)
  {
    TotalCondition oldTotalCondition = totalCondition;
    totalCondition = newTotalCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.TOTAL_EXPRESSION__TOTAL_CONDITION, oldTotalCondition, newTotalCondition);
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
  public void setTotalCondition(TotalCondition newTotalCondition)
  {
    if (newTotalCondition != totalCondition)
    {
      NotificationChain msgs = null;
      if (totalCondition != null)
        msgs = ((InternalEObject)totalCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.TOTAL_EXPRESSION__TOTAL_CONDITION, null, msgs);
      if (newTotalCondition != null)
        msgs = ((InternalEObject)newTotalCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.TOTAL_EXPRESSION__TOTAL_CONDITION, null, msgs);
      msgs = basicSetTotalCondition(newTotalCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.TOTAL_EXPRESSION__TOTAL_CONDITION, newTotalCondition, newTotalCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TotalOperation getTotalOperation()
  {
    return totalOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTotalOperation(TotalOperation newTotalOperation, NotificationChain msgs)
  {
    TotalOperation oldTotalOperation = totalOperation;
    totalOperation = newTotalOperation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.TOTAL_EXPRESSION__TOTAL_OPERATION, oldTotalOperation, newTotalOperation);
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
  public void setTotalOperation(TotalOperation newTotalOperation)
  {
    if (newTotalOperation != totalOperation)
    {
      NotificationChain msgs = null;
      if (totalOperation != null)
        msgs = ((InternalEObject)totalOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.TOTAL_EXPRESSION__TOTAL_OPERATION, null, msgs);
      if (newTotalOperation != null)
        msgs = ((InternalEObject)newTotalOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.TOTAL_EXPRESSION__TOTAL_OPERATION, null, msgs);
      msgs = basicSetTotalOperation(newTotalOperation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.TOTAL_EXPRESSION__TOTAL_OPERATION, newTotalOperation, newTotalOperation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ElseExpression getElseExpression()
  {
    return elseExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseExpression(ElseExpression newElseExpression, NotificationChain msgs)
  {
    ElseExpression oldElseExpression = elseExpression;
    elseExpression = newElseExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.TOTAL_EXPRESSION__ELSE_EXPRESSION, oldElseExpression, newElseExpression);
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
  public void setElseExpression(ElseExpression newElseExpression)
  {
    if (newElseExpression != elseExpression)
    {
      NotificationChain msgs = null;
      if (elseExpression != null)
        msgs = ((InternalEObject)elseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.TOTAL_EXPRESSION__ELSE_EXPRESSION, null, msgs);
      if (newElseExpression != null)
        msgs = ((InternalEObject)newElseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.TOTAL_EXPRESSION__ELSE_EXPRESSION, null, msgs);
      msgs = basicSetElseExpression(newElseExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.TOTAL_EXPRESSION__ELSE_EXPRESSION, newElseExpression, newElseExpression));
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
      case SparrowPackage.TOTAL_EXPRESSION__SET:
        return basicSetSet(null, msgs);
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_CONDITION:
        return basicSetTotalCondition(null, msgs);
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_OPERATION:
        return basicSetTotalOperation(null, msgs);
      case SparrowPackage.TOTAL_EXPRESSION__ELSE_EXPRESSION:
        return basicSetElseExpression(null, msgs);
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
      case SparrowPackage.TOTAL_EXPRESSION__SET:
        return getSet();
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_CONDITION:
        return getTotalCondition();
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_OPERATION:
        return getTotalOperation();
      case SparrowPackage.TOTAL_EXPRESSION__ELSE_EXPRESSION:
        return getElseExpression();
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
      case SparrowPackage.TOTAL_EXPRESSION__SET:
        setSet((messageExpression)newValue);
        return;
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_CONDITION:
        setTotalCondition((TotalCondition)newValue);
        return;
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_OPERATION:
        setTotalOperation((TotalOperation)newValue);
        return;
      case SparrowPackage.TOTAL_EXPRESSION__ELSE_EXPRESSION:
        setElseExpression((ElseExpression)newValue);
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
      case SparrowPackage.TOTAL_EXPRESSION__SET:
        setSet((messageExpression)null);
        return;
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_CONDITION:
        setTotalCondition((TotalCondition)null);
        return;
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_OPERATION:
        setTotalOperation((TotalOperation)null);
        return;
      case SparrowPackage.TOTAL_EXPRESSION__ELSE_EXPRESSION:
        setElseExpression((ElseExpression)null);
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
      case SparrowPackage.TOTAL_EXPRESSION__SET:
        return set != null;
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_CONDITION:
        return totalCondition != null;
      case SparrowPackage.TOTAL_EXPRESSION__TOTAL_OPERATION:
        return totalOperation != null;
      case SparrowPackage.TOTAL_EXPRESSION__ELSE_EXPRESSION:
        return elseExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //TotalExpressionImpl