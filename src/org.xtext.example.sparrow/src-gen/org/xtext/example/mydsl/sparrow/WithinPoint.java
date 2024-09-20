/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Within Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.sparrow.WithinPoint#getNumber <em>Number</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.WithinPoint#getTime <em>Time</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.sparrow.WithinPoint#getThing <em>Thing</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getWithinPoint()
 * @model
 * @generated
 */
public interface WithinPoint extends Timepoint
{
  /**
   * Returns the value of the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' attribute.
   * @see #setNumber(int)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getWithinPoint_Number()
   * @model
   * @generated
   */
  int getNumber();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.WithinPoint#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #getNumber()
   * @generated
   */
  void setNumber(int value);

  /**
   * Returns the value of the '<em><b>Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time</em>' attribute.
   * @see #setTime(String)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getWithinPoint_Time()
   * @model
   * @generated
   */
  String getTime();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.WithinPoint#getTime <em>Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time</em>' attribute.
   * @see #getTime()
   * @generated
   */
  void setTime(String value);

  /**
   * Returns the value of the '<em><b>Thing</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Thing</em>' reference.
   * @see #setThing(RuleExpression)
   * @see org.xtext.example.mydsl.sparrow.SparrowPackage#getWithinPoint_Thing()
   * @model
   * @generated
   */
  RuleExpression getThing();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.sparrow.WithinPoint#getThing <em>Thing</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Thing</em>' reference.
   * @see #getThing()
   * @generated
   */
  void setThing(RuleExpression value);

} // WithinPoint
