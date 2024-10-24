/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.ContractMessage#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getContractMessage()
 * @model
 * @generated
 */
public interface ContractMessage extends EObject
{
  /**
   * Returns the value of the '<em><b>Message</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.sparrow.Message}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' containment reference list.
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getContractMessage_Message()
   * @model containment="true"
   * @generated
   */
  EList<Message> getMessage();

} // ContractMessage
