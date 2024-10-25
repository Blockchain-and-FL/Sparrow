/**
 * generated by Xtext 2.29.0
 */
package org.xtext.example.mydsl.sparrow.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.example.mydsl.sparrow.AdditionExpression;
import org.xtext.example.mydsl.sparrow.Address;
import org.xtext.example.mydsl.sparrow.AllNumber;
import org.xtext.example.mydsl.sparrow.AndOrCondition;
import org.xtext.example.mydsl.sparrow.AndOrOperationLink;
import org.xtext.example.mydsl.sparrow.BeforePoint;
import org.xtext.example.mydsl.sparrow.CompareString;
import org.xtext.example.mydsl.sparrow.Condition;
import org.xtext.example.mydsl.sparrow.ConditionLink;
import org.xtext.example.mydsl.sparrow.ContractMessage;
import org.xtext.example.mydsl.sparrow.DATE;
import org.xtext.example.mydsl.sparrow.Duration;
import org.xtext.example.mydsl.sparrow.ElseExpression;
import org.xtext.example.mydsl.sparrow.ExclusiveExpression;
import org.xtext.example.mydsl.sparrow.FailResult;
import org.xtext.example.mydsl.sparrow.FloatExpression;
import org.xtext.example.mydsl.sparrow.GetPeriodExpression;
import org.xtext.example.mydsl.sparrow.Group;
import org.xtext.example.mydsl.sparrow.Initialize;
import org.xtext.example.mydsl.sparrow.ManyRuleExpression;
import org.xtext.example.mydsl.sparrow.Message;
import org.xtext.example.mydsl.sparrow.MixExpression;
import org.xtext.example.mydsl.sparrow.Model;
import org.xtext.example.mydsl.sparrow.Now;
import org.xtext.example.mydsl.sparrow.ObjectExpress;
import org.xtext.example.mydsl.sparrow.ObjectExpression;
import org.xtext.example.mydsl.sparrow.OperateLink;
import org.xtext.example.mydsl.sparrow.Operation;
import org.xtext.example.mydsl.sparrow.OtherExpression;
import org.xtext.example.mydsl.sparrow.OtherMixExpression;
import org.xtext.example.mydsl.sparrow.ParallelExpression;
import org.xtext.example.mydsl.sparrow.PeriodExpression;
import org.xtext.example.mydsl.sparrow.PersonExpression;
import org.xtext.example.mydsl.sparrow.RegularExpression;
import org.xtext.example.mydsl.sparrow.RegularRuleExpression;
import org.xtext.example.mydsl.sparrow.Require;
import org.xtext.example.mydsl.sparrow.Right;
import org.xtext.example.mydsl.sparrow.RuleExpression;
import org.xtext.example.mydsl.sparrow.RuleStructure;
import org.xtext.example.mydsl.sparrow.RuleTimeExpression;
import org.xtext.example.mydsl.sparrow.SingleCondition;
import org.xtext.example.mydsl.sparrow.SingleExpression;
import org.xtext.example.mydsl.sparrow.SingleLinkCondition;
import org.xtext.example.mydsl.sparrow.SparrowFactory;
import org.xtext.example.mydsl.sparrow.SparrowPackage;
import org.xtext.example.mydsl.sparrow.StringExpression;
import org.xtext.example.mydsl.sparrow.SubExpression;
import org.xtext.example.mydsl.sparrow.Subject;
import org.xtext.example.mydsl.sparrow.SubjectExpress;
import org.xtext.example.mydsl.sparrow.SubjectExpression;
import org.xtext.example.mydsl.sparrow.ThenOperation;
import org.xtext.example.mydsl.sparrow.ThingExpression;
import org.xtext.example.mydsl.sparrow.ThisBoolean;
import org.xtext.example.mydsl.sparrow.ThisDate;
import org.xtext.example.mydsl.sparrow.ThisDecimal;
import org.xtext.example.mydsl.sparrow.ThisString;
import org.xtext.example.mydsl.sparrow.TimeSub;
import org.xtext.example.mydsl.sparrow.Timepoint;
import org.xtext.example.mydsl.sparrow.TotalCondition;
import org.xtext.example.mydsl.sparrow.TotalExpression;
import org.xtext.example.mydsl.sparrow.TotalOperation;
import org.xtext.example.mydsl.sparrow.TrueCondition;
import org.xtext.example.mydsl.sparrow.Value;
import org.xtext.example.mydsl.sparrow.WithinPoint;
import org.xtext.example.mydsl.sparrow.changeAddress;
import org.xtext.example.mydsl.sparrow.changeContract;
import org.xtext.example.mydsl.sparrow.changeExpression;
import org.xtext.example.mydsl.sparrow.changeOther;
import org.xtext.example.mydsl.sparrow.changeRule;
import org.xtext.example.mydsl.sparrow.changeString;
import org.xtext.example.mydsl.sparrow.checkExpression;
import org.xtext.example.mydsl.sparrow.everyMessage;
import org.xtext.example.mydsl.sparrow.initExpressiono;
import org.xtext.example.mydsl.sparrow.initExpressions;
import org.xtext.example.mydsl.sparrow.isDone;
import org.xtext.example.mydsl.sparrow.isTime;
import org.xtext.example.mydsl.sparrow.isTrue;
import org.xtext.example.mydsl.sparrow.keyvalue;
import org.xtext.example.mydsl.sparrow.logic;
import org.xtext.example.mydsl.sparrow.messageExpression;
import org.xtext.example.mydsl.sparrow.otherchange;
import org.xtext.example.mydsl.sparrow.setDateExpression;
import org.xtext.example.mydsl.sparrow.transferExpression;
import org.xtext.example.mydsl.sparrow.trueOperation;
import org.xtext.example.mydsl.sparrow.url;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SparrowFactoryImpl extends EFactoryImpl implements SparrowFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SparrowFactory init()
  {
    try
    {
      SparrowFactory theSparrowFactory = (SparrowFactory)EPackage.Registry.INSTANCE.getEFactory(SparrowPackage.eNS_URI);
      if (theSparrowFactory != null)
      {
        return theSparrowFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SparrowFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SparrowFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SparrowPackage.MODEL: return createModel();
      case SparrowPackage.REQUIRE: return createRequire();
      case SparrowPackage.INITIALIZE: return createInitialize();
      case SparrowPackage.INIT_EXPRESSIONS: return createinitExpressions();
      case SparrowPackage.INIT_EXPRESSIONO: return createinitExpressiono();
      case SparrowPackage.GROUP: return createGroup();
      case SparrowPackage.SUBJECT: return createSubject();
      case SparrowPackage.SUBJECT_EXPRESSION: return createSubjectExpression();
      case SparrowPackage.CONTRACT_MESSAGE: return createContractMessage();
      case SparrowPackage.MESSAGE: return createMessage();
      case SparrowPackage.KEYVALUE: return createkeyvalue();
      case SparrowPackage.VALUE: return createValue();
      case SparrowPackage.DURATION: return createDuration();
      case SparrowPackage.NOW: return createNow();
      case SparrowPackage.THIS_STRING: return createThisString();
      case SparrowPackage.ADDRESS: return createAddress();
      case SparrowPackage.ALL_NUMBER: return createAllNumber();
      case SparrowPackage.THIS_DECIMAL: return createThisDecimal();
      case SparrowPackage.URL: return createurl();
      case SparrowPackage.THIS_BOOLEAN: return createThisBoolean();
      case SparrowPackage.THIS_DATE: return createThisDate();
      case SparrowPackage.RIGHT: return createRight();
      case SparrowPackage.DATE: return createDATE();
      case SparrowPackage.OBJECT: return createObject();
      case SparrowPackage.OBJECT_EXPRESSION: return createObjectExpression();
      case SparrowPackage.CONDITION: return createCondition();
      case SparrowPackage.CONDITION_LINK: return createConditionLink();
      case SparrowPackage.AND_OR_CONDITION: return createAndOrCondition();
      case SparrowPackage.OPERATION: return createOperation();
      case SparrowPackage.OPERATE_LINK: return createOperateLink();
      case SparrowPackage.RULE_STRUCTURE: return createRuleStructure();
      case SparrowPackage.MANY_RULE_EXPRESSION: return createManyRuleExpression();
      case SparrowPackage.PARALLEL_EXPRESSION: return createParallelExpression();
      case SparrowPackage.EXCLUSIVE_EXPRESSION: return createExclusiveExpression();
      case SparrowPackage.REGULAR_RULE_EXPRESSION: return createRegularRuleExpression();
      case SparrowPackage.ADDITION_EXPRESSION: return createAdditionExpression();
      case SparrowPackage.TOTAL_CONDITION: return createTotalCondition();
      case SparrowPackage.SINGLE_LINK_CONDITION: return createSingleLinkCondition();
      case SparrowPackage.TOTAL_OPERATION: return createTotalOperation();
      case SparrowPackage.AND_OR_OPERATION_LINK: return createAndOrOperationLink();
      case SparrowPackage.THEN_OPERATION: return createThenOperation();
      case SparrowPackage.TOTAL_EXPRESSION: return createTotalExpression();
      case SparrowPackage.ELSE_EXPRESSION: return createElseExpression();
      case SparrowPackage.RULE_EXPRESSION: return createRuleExpression();
      case SparrowPackage.SET_DATE_EXPRESSION: return createsetDateExpression();
      case SparrowPackage.SUB_EXPRESSION: return createSubExpression();
      case SparrowPackage.FAIL_RESULT: return createFailResult();
      case SparrowPackage.TIMEPOINT: return createTimepoint();
      case SparrowPackage.WITHIN_POINT: return createWithinPoint();
      case SparrowPackage.BEFORE_POINT: return createBeforePoint();
      case SparrowPackage.SINGLE_CONDITION: return createSingleCondition();
      case SparrowPackage.TRUE_CONDITION: return createTrueCondition();
      case SparrowPackage.COMPARE_STRING: return createCompareString();
      case SparrowPackage.TIME_SUB: return createTimeSub();
      case SparrowPackage.IS_TIME: return createisTime();
      case SparrowPackage.LOGIC: return createlogic();
      case SparrowPackage.IS_TRUE: return createisTrue();
      case SparrowPackage.IS_DONE: return createisDone();
      case SparrowPackage.CHECK_EXPRESSION: return createcheckExpression();
      case SparrowPackage.MIX_EXPRESSION: return createMixExpression();
      case SparrowPackage.OTHER_MIX_EXPRESSION: return createOtherMixExpression();
      case SparrowPackage.SINGLE_EXPRESSION: return createSingleExpression();
      case SparrowPackage.PERIOD_EXPRESSION: return createPeriodExpression();
      case SparrowPackage.GET_PERIOD_EXPRESSION: return createGetPeriodExpression();
      case SparrowPackage.RULE_TIME_EXPRESSION: return createRuleTimeExpression();
      case SparrowPackage.OTHER_EXPRESSION: return createOtherExpression();
      case SparrowPackage.STRING_EXPRESSION: return createStringExpression();
      case SparrowPackage.FLOAT_EXPRESSION: return createFloatExpression();
      case SparrowPackage.PERSON_EXPRESSION: return createPersonExpression();
      case SparrowPackage.REGULAR_EXPRESSION: return createRegularExpression();
      case SparrowPackage.THING_EXPRESSION: return createThingExpression();
      case SparrowPackage.SUBJECT_EXPRESS: return createSubjectExpress();
      case SparrowPackage.OBJECT_EXPRESS: return createObjectExpress();
      case SparrowPackage.TRUE_OPERATION: return createtrueOperation();
      case SparrowPackage.MESSAGE_EXPRESSION: return createmessageExpression();
      case SparrowPackage.EVERY_MESSAGE: return createeveryMessage();
      case SparrowPackage.TRANSFER_EXPRESSION: return createtransferExpression();
      case SparrowPackage.CHANGE_EXPRESSION: return createchangeExpression();
      case SparrowPackage.CHANGE_STRING: return createchangeString();
      case SparrowPackage.OTHERCHANGE: return createotherchange();
      case SparrowPackage.CHANGE_CONTRACT: return createchangeContract();
      case SparrowPackage.CHANGE_RULE: return createchangeRule();
      case SparrowPackage.CHANGE_OTHER: return createchangeOther();
      case SparrowPackage.CHANGE_ADDRESS: return createchangeAddress();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Require createRequire()
  {
    RequireImpl require = new RequireImpl();
    return require;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Initialize createInitialize()
  {
    InitializeImpl initialize = new InitializeImpl();
    return initialize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public initExpressions createinitExpressions()
  {
    initExpressionsImpl initExpressions = new initExpressionsImpl();
    return initExpressions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public initExpressiono createinitExpressiono()
  {
    initExpressionoImpl initExpressiono = new initExpressionoImpl();
    return initExpressiono;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Group createGroup()
  {
    GroupImpl group = new GroupImpl();
    return group;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Subject createSubject()
  {
    SubjectImpl subject = new SubjectImpl();
    return subject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SubjectExpression createSubjectExpression()
  {
    SubjectExpressionImpl subjectExpression = new SubjectExpressionImpl();
    return subjectExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContractMessage createContractMessage()
  {
    ContractMessageImpl contractMessage = new ContractMessageImpl();
    return contractMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Message createMessage()
  {
    MessageImpl message = new MessageImpl();
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public keyvalue createkeyvalue()
  {
    keyvalueImpl keyvalue = new keyvalueImpl();
    return keyvalue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Duration createDuration()
  {
    DurationImpl duration = new DurationImpl();
    return duration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Now createNow()
  {
    NowImpl now = new NowImpl();
    return now;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThisString createThisString()
  {
    ThisStringImpl thisString = new ThisStringImpl();
    return thisString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Address createAddress()
  {
    AddressImpl address = new AddressImpl();
    return address;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AllNumber createAllNumber()
  {
    AllNumberImpl allNumber = new AllNumberImpl();
    return allNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThisDecimal createThisDecimal()
  {
    ThisDecimalImpl thisDecimal = new ThisDecimalImpl();
    return thisDecimal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public url createurl()
  {
    urlImpl url = new urlImpl();
    return url;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThisBoolean createThisBoolean()
  {
    ThisBooleanImpl thisBoolean = new ThisBooleanImpl();
    return thisBoolean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThisDate createThisDate()
  {
    ThisDateImpl thisDate = new ThisDateImpl();
    return thisDate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Right createRight()
  {
    RightImpl right = new RightImpl();
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DATE createDATE()
  {
    DATEImpl date = new DATEImpl();
    return date;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public org.xtext.example.mydsl.sparrow.Object createObject()
  {
    ObjectImpl object = new ObjectImpl();
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ObjectExpression createObjectExpression()
  {
    ObjectExpressionImpl objectExpression = new ObjectExpressionImpl();
    return objectExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Condition createCondition()
  {
    ConditionImpl condition = new ConditionImpl();
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConditionLink createConditionLink()
  {
    ConditionLinkImpl conditionLink = new ConditionLinkImpl();
    return conditionLink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AndOrCondition createAndOrCondition()
  {
    AndOrConditionImpl andOrCondition = new AndOrConditionImpl();
    return andOrCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OperateLink createOperateLink()
  {
    OperateLinkImpl operateLink = new OperateLinkImpl();
    return operateLink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RuleStructure createRuleStructure()
  {
    RuleStructureImpl ruleStructure = new RuleStructureImpl();
    return ruleStructure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ManyRuleExpression createManyRuleExpression()
  {
    ManyRuleExpressionImpl manyRuleExpression = new ManyRuleExpressionImpl();
    return manyRuleExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ParallelExpression createParallelExpression()
  {
    ParallelExpressionImpl parallelExpression = new ParallelExpressionImpl();
    return parallelExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExclusiveExpression createExclusiveExpression()
  {
    ExclusiveExpressionImpl exclusiveExpression = new ExclusiveExpressionImpl();
    return exclusiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RegularRuleExpression createRegularRuleExpression()
  {
    RegularRuleExpressionImpl regularRuleExpression = new RegularRuleExpressionImpl();
    return regularRuleExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AdditionExpression createAdditionExpression()
  {
    AdditionExpressionImpl additionExpression = new AdditionExpressionImpl();
    return additionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TotalCondition createTotalCondition()
  {
    TotalConditionImpl totalCondition = new TotalConditionImpl();
    return totalCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SingleLinkCondition createSingleLinkCondition()
  {
    SingleLinkConditionImpl singleLinkCondition = new SingleLinkConditionImpl();
    return singleLinkCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TotalOperation createTotalOperation()
  {
    TotalOperationImpl totalOperation = new TotalOperationImpl();
    return totalOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AndOrOperationLink createAndOrOperationLink()
  {
    AndOrOperationLinkImpl andOrOperationLink = new AndOrOperationLinkImpl();
    return andOrOperationLink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThenOperation createThenOperation()
  {
    ThenOperationImpl thenOperation = new ThenOperationImpl();
    return thenOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TotalExpression createTotalExpression()
  {
    TotalExpressionImpl totalExpression = new TotalExpressionImpl();
    return totalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ElseExpression createElseExpression()
  {
    ElseExpressionImpl elseExpression = new ElseExpressionImpl();
    return elseExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RuleExpression createRuleExpression()
  {
    RuleExpressionImpl ruleExpression = new RuleExpressionImpl();
    return ruleExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public setDateExpression createsetDateExpression()
  {
    setDateExpressionImpl setDateExpression = new setDateExpressionImpl();
    return setDateExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SubExpression createSubExpression()
  {
    SubExpressionImpl subExpression = new SubExpressionImpl();
    return subExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FailResult createFailResult()
  {
    FailResultImpl failResult = new FailResultImpl();
    return failResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Timepoint createTimepoint()
  {
    TimepointImpl timepoint = new TimepointImpl();
    return timepoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WithinPoint createWithinPoint()
  {
    WithinPointImpl withinPoint = new WithinPointImpl();
    return withinPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BeforePoint createBeforePoint()
  {
    BeforePointImpl beforePoint = new BeforePointImpl();
    return beforePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SingleCondition createSingleCondition()
  {
    SingleConditionImpl singleCondition = new SingleConditionImpl();
    return singleCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TrueCondition createTrueCondition()
  {
    TrueConditionImpl trueCondition = new TrueConditionImpl();
    return trueCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CompareString createCompareString()
  {
    CompareStringImpl compareString = new CompareStringImpl();
    return compareString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TimeSub createTimeSub()
  {
    TimeSubImpl timeSub = new TimeSubImpl();
    return timeSub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public isTime createisTime()
  {
    isTimeImpl isTime = new isTimeImpl();
    return isTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public logic createlogic()
  {
    logicImpl logic = new logicImpl();
    return logic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public isTrue createisTrue()
  {
    isTrueImpl isTrue = new isTrueImpl();
    return isTrue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public isDone createisDone()
  {
    isDoneImpl isDone = new isDoneImpl();
    return isDone;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public checkExpression createcheckExpression()
  {
    checkExpressionImpl checkExpression = new checkExpressionImpl();
    return checkExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MixExpression createMixExpression()
  {
    MixExpressionImpl mixExpression = new MixExpressionImpl();
    return mixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OtherMixExpression createOtherMixExpression()
  {
    OtherMixExpressionImpl otherMixExpression = new OtherMixExpressionImpl();
    return otherMixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SingleExpression createSingleExpression()
  {
    SingleExpressionImpl singleExpression = new SingleExpressionImpl();
    return singleExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PeriodExpression createPeriodExpression()
  {
    PeriodExpressionImpl periodExpression = new PeriodExpressionImpl();
    return periodExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GetPeriodExpression createGetPeriodExpression()
  {
    GetPeriodExpressionImpl getPeriodExpression = new GetPeriodExpressionImpl();
    return getPeriodExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RuleTimeExpression createRuleTimeExpression()
  {
    RuleTimeExpressionImpl ruleTimeExpression = new RuleTimeExpressionImpl();
    return ruleTimeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OtherExpression createOtherExpression()
  {
    OtherExpressionImpl otherExpression = new OtherExpressionImpl();
    return otherExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StringExpression createStringExpression()
  {
    StringExpressionImpl stringExpression = new StringExpressionImpl();
    return stringExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FloatExpression createFloatExpression()
  {
    FloatExpressionImpl floatExpression = new FloatExpressionImpl();
    return floatExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PersonExpression createPersonExpression()
  {
    PersonExpressionImpl personExpression = new PersonExpressionImpl();
    return personExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RegularExpression createRegularExpression()
  {
    RegularExpressionImpl regularExpression = new RegularExpressionImpl();
    return regularExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThingExpression createThingExpression()
  {
    ThingExpressionImpl thingExpression = new ThingExpressionImpl();
    return thingExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SubjectExpress createSubjectExpress()
  {
    SubjectExpressImpl subjectExpress = new SubjectExpressImpl();
    return subjectExpress;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ObjectExpress createObjectExpress()
  {
    ObjectExpressImpl objectExpress = new ObjectExpressImpl();
    return objectExpress;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public trueOperation createtrueOperation()
  {
    trueOperationImpl trueOperation = new trueOperationImpl();
    return trueOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public messageExpression createmessageExpression()
  {
    messageExpressionImpl messageExpression = new messageExpressionImpl();
    return messageExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public everyMessage createeveryMessage()
  {
    everyMessageImpl everyMessage = new everyMessageImpl();
    return everyMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public transferExpression createtransferExpression()
  {
    transferExpressionImpl transferExpression = new transferExpressionImpl();
    return transferExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public changeExpression createchangeExpression()
  {
    changeExpressionImpl changeExpression = new changeExpressionImpl();
    return changeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public changeString createchangeString()
  {
    changeStringImpl changeString = new changeStringImpl();
    return changeString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public otherchange createotherchange()
  {
    otherchangeImpl otherchange = new otherchangeImpl();
    return otherchange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public changeContract createchangeContract()
  {
    changeContractImpl changeContract = new changeContractImpl();
    return changeContract;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public changeRule createchangeRule()
  {
    changeRuleImpl changeRule = new changeRuleImpl();
    return changeRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public changeOther createchangeOther()
  {
    changeOtherImpl changeOther = new changeOtherImpl();
    return changeOther;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public changeAddress createchangeAddress()
  {
    changeAddressImpl changeAddress = new changeAddressImpl();
    return changeAddress;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SparrowPackage getSparrowPackage()
  {
    return (SparrowPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SparrowPackage getPackage()
  {
    return SparrowPackage.eINSTANCE;
  }

} //SparrowFactoryImpl
