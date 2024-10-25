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
import org.xtext.example.mydsl.sparrow.OperateLink;
import org.xtext.example.mydsl.sparrow.SparrowPackage;
import org.xtext.example.mydsl.sparrow.trueOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operate Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.OperateLinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.OperateLinkImpl#getFirstOperation <em>First Operation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.OperateLinkImpl#getLinkOperation <em>Link Operation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.impl.OperateLinkImpl#getAndOrLink <em>And Or Link</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperateLinkImpl extends MinimalEObjectImpl.Container implements OperateLink
{
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
   * The cached value of the '{@link #getFirstOperation() <em>First Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstOperation()
   * @generated
   * @ordered
   */
  protected trueOperation firstOperation;

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
   * The cached value of the '{@link #getAndOrLink() <em>And Or Link</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAndOrLink()
   * @generated
   * @ordered
   */
  protected EList<AndOrOperationLink> andOrLink;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperateLinkImpl()
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
    return SparrowPackage.Literals.OPERATE_LINK;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.OPERATE_LINK__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public trueOperation getFirstOperation()
  {
    return firstOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirstOperation(trueOperation newFirstOperation, NotificationChain msgs)
  {
    trueOperation oldFirstOperation = firstOperation;
    firstOperation = newFirstOperation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SparrowPackage.OPERATE_LINK__FIRST_OPERATION, oldFirstOperation, newFirstOperation);
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
  public void setFirstOperation(trueOperation newFirstOperation)
  {
    if (newFirstOperation != firstOperation)
    {
      NotificationChain msgs = null;
      if (firstOperation != null)
        msgs = ((InternalEObject)firstOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.OPERATE_LINK__FIRST_OPERATION, null, msgs);
      if (newFirstOperation != null)
        msgs = ((InternalEObject)newFirstOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SparrowPackage.OPERATE_LINK__FIRST_OPERATION, null, msgs);
      msgs = basicSetFirstOperation(newFirstOperation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.OPERATE_LINK__FIRST_OPERATION, newFirstOperation, newFirstOperation));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SparrowPackage.OPERATE_LINK__LINK_OPERATION, oldLinkOperation, linkOperation));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SparrowPackage.OPERATE_LINK__LINK_OPERATION, oldLinkOperation, linkOperation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AndOrOperationLink> getAndOrLink()
  {
    if (andOrLink == null)
    {
      andOrLink = new EObjectContainmentEList<AndOrOperationLink>(AndOrOperationLink.class, this, SparrowPackage.OPERATE_LINK__AND_OR_LINK);
    }
    return andOrLink;
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
      case SparrowPackage.OPERATE_LINK__FIRST_OPERATION:
        return basicSetFirstOperation(null, msgs);
      case SparrowPackage.OPERATE_LINK__AND_OR_LINK:
        return ((InternalEList<?>)getAndOrLink()).basicRemove(otherEnd, msgs);
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
      case SparrowPackage.OPERATE_LINK__NAME:
        return getName();
      case SparrowPackage.OPERATE_LINK__FIRST_OPERATION:
        return getFirstOperation();
      case SparrowPackage.OPERATE_LINK__LINK_OPERATION:
        if (resolve) return getLinkOperation();
        return basicGetLinkOperation();
      case SparrowPackage.OPERATE_LINK__AND_OR_LINK:
        return getAndOrLink();
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
      case SparrowPackage.OPERATE_LINK__NAME:
        setName((String)newValue);
        return;
      case SparrowPackage.OPERATE_LINK__FIRST_OPERATION:
        setFirstOperation((trueOperation)newValue);
        return;
      case SparrowPackage.OPERATE_LINK__LINK_OPERATION:
        setLinkOperation((OperateLink)newValue);
        return;
      case SparrowPackage.OPERATE_LINK__AND_OR_LINK:
        getAndOrLink().clear();
        getAndOrLink().addAll((Collection<? extends AndOrOperationLink>)newValue);
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
      case SparrowPackage.OPERATE_LINK__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SparrowPackage.OPERATE_LINK__FIRST_OPERATION:
        setFirstOperation((trueOperation)null);
        return;
      case SparrowPackage.OPERATE_LINK__LINK_OPERATION:
        setLinkOperation((OperateLink)null);
        return;
      case SparrowPackage.OPERATE_LINK__AND_OR_LINK:
        getAndOrLink().clear();
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
      case SparrowPackage.OPERATE_LINK__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SparrowPackage.OPERATE_LINK__FIRST_OPERATION:
        return firstOperation != null;
      case SparrowPackage.OPERATE_LINK__LINK_OPERATION:
        return linkOperation != null;
      case SparrowPackage.OPERATE_LINK__AND_OR_LINK:
        return andOrLink != null && !andOrLink.isEmpty();
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

} //OperateLinkImpl
