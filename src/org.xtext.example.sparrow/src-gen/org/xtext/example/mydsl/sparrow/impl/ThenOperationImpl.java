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

import org.xtext.example.mydsl.sparrow.AndOrOperationLink;
import org.xtext.example.mydsl.sparrow.FailResult;
import org.xtext.example.mydsl.sparrow.OperateLink;
import org.xtext.example.mydsl.sparrow.SparrowPackage;
import org.xtext.example.mydsl.sparrow.ThenOperation;
import org.xtext.example.mydsl.sparrow.Timepoint;
import org.xtext.example.mydsl.sparrow.trueOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Then Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ThenOperationImpl#getFollowingOperation <em>Following Operation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ThenOperationImpl#getLinkOperation <em>Link Operation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ThenOperationImpl#getAndor <em>Andor</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ThenOperationImpl#getTimePoint <em>Time Point</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.ThenOperationImpl#getFailresult <em>Failresult</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThenOperationImpl extends MinimalEObjectImpl.Container implements ThenOperation
{
  /**
   * The cached value of the '{@link #getFollowingOperation() <em>Following Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFollowingOperation()
   * @generated
   * @ordered
   */
  protected trueOperation followingOperation;

  /**
   * The cached value of the '{@link #getLinkOperation() <em>Link Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinkOperation()
   * @generated
   * @ordered
   */
  protected OperateLink linkOperation;

  /**
   * The cached value of the '{@link #getAndor() <em>Andor</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndor()
   * @generated
   * @ordered
   */
  protected EList<AndOrOperationLink> andor;

  /**
   * The cached value of the '{@link #getTimePoint() <em>Time Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimePoint()
   * @generated
   * @ordered
   */
  protected Timepoint timePoint;

  /**
   * The cached value of the '{@link #getFailresult() <em>Failresult</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailresult()
   * @generated
   * @ordered
   */
  protected FailResult failresult;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ThenOperationImpl()
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
    return SparrowPackage.Literals.THEN_OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public trueOperation getFollowingOperation()
  {
    return followingOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFollowingOperation(trueOperation newFollowingOperation, NotificationChain msgs)
  {
    trueOperation oldFollowingOperation = followingOperation;
    followingOperation = newFollowingOperation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.THEN_OPERATION__FOLLOWING_OPERATION, oldFollowingOperation, newFollowingOperation);
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
  public void setFollowingOperation(trueOperation newFollowingOperation)
  {
    if (newFollowingOperation != followingOperation)
    {
      NotificationChain msgs = null;
      if (followingOperation != null)
        msgs = ((InternalEObject)followingOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.THEN_OPERATION__FOLLOWING_OPERATION, null, msgs);
      if (newFollowingOperation != null)
        msgs = ((InternalEObject)newFollowingOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.THEN_OPERATION__FOLLOWING_OPERATION, null, msgs);
      msgs = basicSetFollowingOperation(newFollowingOperation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.THEN_OPERATION__FOLLOWING_OPERATION, newFollowingOperation, newFollowingOperation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OperateLink getLinkOperation()
  {
    if (linkOperation != null && linkOperation.eIsProxy())
    {
      InternalEObject oldLinkOperation = (InternalEObject)linkOperation;
      linkOperation = (OperateLink)eResolveProxy(oldLinkOperation);
      if (linkOperation != oldLinkOperation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SparrowPackage.THEN_OPERATION__LINK_OPERATION, oldLinkOperation, linkOperation));
      }
    }
    return linkOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperateLink basicGetLinkOperation()
  {
    return linkOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLinkOperation(OperateLink newLinkOperation)
  {
    OperateLink oldLinkOperation = linkOperation;
    linkOperation = newLinkOperation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.THEN_OPERATION__LINK_OPERATION, oldLinkOperation, linkOperation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AndOrOperationLink> getAndor()
  {
    if (andor == null)
    {
      andor = new EObjectContainmentEList<AndOrOperationLink>(AndOrOperationLink.class, this, SparrowPackage.THEN_OPERATION__ANDOR);
    }
    return andor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Timepoint getTimePoint()
  {
    return timePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTimePoint(Timepoint newTimePoint, NotificationChain msgs)
  {
    Timepoint oldTimePoint = timePoint;
    timePoint = newTimePoint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.THEN_OPERATION__TIME_POINT, oldTimePoint, newTimePoint);
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
  public void setTimePoint(Timepoint newTimePoint)
  {
    if (newTimePoint != timePoint)
    {
      NotificationChain msgs = null;
      if (timePoint != null)
        msgs = ((InternalEObject)timePoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.THEN_OPERATION__TIME_POINT, null, msgs);
      if (newTimePoint != null)
        msgs = ((InternalEObject)newTimePoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.THEN_OPERATION__TIME_POINT, null, msgs);
      msgs = basicSetTimePoint(newTimePoint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.THEN_OPERATION__TIME_POINT, newTimePoint, newTimePoint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FailResult getFailresult()
  {
    return failresult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFailresult(FailResult newFailresult, NotificationChain msgs)
  {
    FailResult oldFailresult = failresult;
    failresult = newFailresult;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.THEN_OPERATION__FAILRESULT, oldFailresult, newFailresult);
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
  public void setFailresult(FailResult newFailresult)
  {
    if (newFailresult != failresult)
    {
      NotificationChain msgs = null;
      if (failresult != null)
        msgs = ((InternalEObject)failresult).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.THEN_OPERATION__FAILRESULT, null, msgs);
      if (newFailresult != null)
        msgs = ((InternalEObject)newFailresult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.THEN_OPERATION__FAILRESULT, null, msgs);
      msgs = basicSetFailresult(newFailresult, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.THEN_OPERATION__FAILRESULT, newFailresult, newFailresult));
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
      case SparrowPackage.THEN_OPERATION__FOLLOWING_OPERATION:
        return basicSetFollowingOperation(null, msgs);
      case SparrowPackage.THEN_OPERATION__ANDOR:
        return ((InternalEList<?>)getAndor()).basicRemove(otherEnd, msgs);
      case SparrowPackage.THEN_OPERATION__TIME_POINT:
        return basicSetTimePoint(null, msgs);
      case SparrowPackage.THEN_OPERATION__FAILRESULT:
        return basicSetFailresult(null, msgs);
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
      case SparrowPackage.THEN_OPERATION__FOLLOWING_OPERATION:
        return getFollowingOperation();
      case SparrowPackage.THEN_OPERATION__LINK_OPERATION:
        if (resolve) return getLinkOperation();
        return basicGetLinkOperation();
      case SparrowPackage.THEN_OPERATION__ANDOR:
        return getAndor();
      case SparrowPackage.THEN_OPERATION__TIME_POINT:
        return getTimePoint();
      case SparrowPackage.THEN_OPERATION__FAILRESULT:
        return getFailresult();
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
      case SparrowPackage.THEN_OPERATION__FOLLOWING_OPERATION:
        setFollowingOperation((trueOperation)newValue);
        return;
      case SparrowPackage.THEN_OPERATION__LINK_OPERATION:
        setLinkOperation((OperateLink)newValue);
        return;
      case SparrowPackage.THEN_OPERATION__ANDOR:
        getAndor().clear();
        getAndor().addAll((Collection<? extends AndOrOperationLink>)newValue);
        return;
      case SparrowPackage.THEN_OPERATION__TIME_POINT:
        setTimePoint((Timepoint)newValue);
        return;
      case SparrowPackage.THEN_OPERATION__FAILRESULT:
        setFailresult((FailResult)newValue);
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
      case SparrowPackage.THEN_OPERATION__FOLLOWING_OPERATION:
        setFollowingOperation((trueOperation)null);
        return;
      case SparrowPackage.THEN_OPERATION__LINK_OPERATION:
        setLinkOperation((OperateLink)null);
        return;
      case SparrowPackage.THEN_OPERATION__ANDOR:
        getAndor().clear();
        return;
      case SparrowPackage.THEN_OPERATION__TIME_POINT:
        setTimePoint((Timepoint)null);
        return;
      case SparrowPackage.THEN_OPERATION__FAILRESULT:
        setFailresult((FailResult)null);
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
      case SparrowPackage.THEN_OPERATION__FOLLOWING_OPERATION:
        return followingOperation != null;
      case SparrowPackage.THEN_OPERATION__LINK_OPERATION:
        return linkOperation != null;
      case SparrowPackage.THEN_OPERATION__ANDOR:
        return andor != null && !andor.isEmpty();
      case SparrowPackage.THEN_OPERATION__TIME_POINT:
        return timePoint != null;
      case SparrowPackage.THEN_OPERATION__FAILRESULT:
        return failresult != null;
    }
    return super.eIsSet(featureID);
  }

} //ThenOperationImpl
