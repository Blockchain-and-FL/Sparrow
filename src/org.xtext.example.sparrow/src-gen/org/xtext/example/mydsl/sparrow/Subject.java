/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Subject#getType <em>Type</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Subject#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.Subject#getSubjectExpression <em>Subject Expression</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getSubject()
 * @model
 * @generated
 */
public interface Subject extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getSubject_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Subject#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getSubject_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Subject#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Subject Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subject Expression</em>' containment reference.
   * @see #setSubjectExpression(SubjectExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getSubject_SubjectExpression()
   * @model containment="true"
   * @generated
   */
  SubjectExpression getSubjectExpression();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.Subject#getSubjectExpression <em>Subject Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subject Expression</em>' containment reference.
   * @see #getSubjectExpression()
   * @generated
   */
  void setSubjectExpression(SubjectExpression value);

} // Subject
