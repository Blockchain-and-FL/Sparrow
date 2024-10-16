pragma solidity >=0.4.22 <0.7.0;
pragma experimental ABIEncoderV2;
import "./lib/cml/ConditionalContract.sol";
import "./lib/cml/DateTime.sol";
import "./lib/cml/IntLib.sol";
import "./lib/cml/RealLib.sol";
import "./lib/openzeppelin/PullPayment.sol";
import "./lib/cml/Model.sol";

contract ComplexRent is ConditionalContract, PullPayment {

	/*
	 * State variables
	 */
	Model.Party lessor;
	Model.Party lessee;
	Model.Party ca;
	Model.Party aa;
	Model.Party ra;
	uint rent;
	uint continueRent;
	uint continueDays;
	uint despoit;
	uint payPeriod;
	uint payLate;
	uint totalPeriod;
	uint faultIR;
	uint startTime;
	uint payTime;
	uint finishTime;
	bool end;
	bool continueResult;
	bytes32 faultName;
	uint compensation;
	bool finalResult;
	bytes32 ownership;
	bytes32 useRight;
	uint _contractStart;
	
	/*
	 * Constructor
	 */
	constructor(Model.Party memory _lessor, Model.Party memory _lessee, Model.Party memory _ca, Model.Party memory _aa, Model.Party memory _ra, uint _rent, uint _despoit, uint _payPeriod, uint _payLate, uint _totalPeriod, uint _faultIR, uint _startTime, uint _payTime, uint _finishTime, bytes32 _ownership, bytes32 _useRight, uint _continueRent, uint _continueDays)public {
		lessor = _lessor;
		lessee = _lessee;
		ca = _ca;
		aa = _aa;
		ra = _ra;
		rent = _rent;
		despoit = _despoit;
		payPeriod = _payPeriod;
		payLate = _payLate;
		totalPeriod = _totalPeriod;
		faultIR = _faultIR;
		startTime = _startTime;
		payTime = _payTime;
		finishTime = _finishTime;
		ownership = _ownership;
		useRight = _useRight;
		continueRent = _continueRent;
		continueDays = _continueDays;
		_contractStart = now;
	}
	
	/*
	 * Functions
	 */
	// @notice function for clause �cl.name�
	function checkResult(bool result) public
		checkAllowed("rule1")
	{
		finalResult = result;
	}
	
	// @notice function for clause �cl.name�
	function payOne() public
		checkAllowed("rule2")
	{
		_asyncTransfer(lessor.id , despoit + rent);
	}
	
	// @notice function for clause �cl.name�
	function changeUse() public
		checkAllowed("rule3")
	{
		useRight = "lessee";
	}
	
	// @notice function for clause �cl.name�
	function deliveryLate(uint latedays) public
		checkAllowed("rule4")
	{
		useRight = "lessee";
		_asyncTransfer(lessee.id , faultIR * rent * latedays);
	}
	
	// @notice function for clause �cl.name�
	function lateFinish(uint latedays) public
		checkAllowed("rule5")
	{
		_asyncTransfer(lessee.id , faultIR * rent * latedays + rent + despoit);
		end = true;
	}
	
	// @notice function for clause �cl.name�
	function payRegular() public
		checkAllowed("rule6")
	{
		_asyncTransfer(lessor.id , rent);
		payTime = DateTime.addDuration(payTime, payPeriod);
	}
	
	// @notice function for clause �cl.name�
	function payLate(uint latedays) public
		checkAllowed("rule7")
	{
		_asyncTransfer(lessor.id , faultIR * rent * latedays);
	}
	
	// @notice function for clause �cl.name�
	function backThing() public
		checkAllowed("rule8")
	{
		useRight = "lessor";
		end = true;
	}
	
	// @notice function for clause �cl.name�
	function confirmContinue(uint Days) public
		checkAllowed("rule9")
	{
		continueDays = Days;
		_asyncTransfer(lessor.id , continueRent * continueDays);
	}
	
	// @notice function for clause �cl.name�
	function setContinue(bool result) public
		checkAllowed("rule10")
	{
		continueResult = result;
	}
	
	// @notice function for clause �cl.name�
	function changeFinish() public
		checkAllowed("rule10_1")
	{
	}
	
	// @notice function for clause �cl.name�
	function rejectChange() public
		checkAllowed("rule10_2")
	{
		_asyncTransfer(lessee.id , continueRent * continueDays);
	}
	
	// @notice function for clause �cl.name�
	function finishBack() public
		checkAllowed("rule11")
	{
		useRight = "lessee";
		_asyncTransfer(lessee.id , despoit);
		end = true;
	}
	
	// @notice function for clause �cl.name�
	function pauseContract() public
		checkAllowed("rule12")
	{
		end = true;
	}
	
	// @notice function for clause �cl.name�
	function restartContract() public
		checkAllowed("rule13")
	{
		end = false;
	}
	
	// @notice function for clause �cl.name�
	function getAA() public
		checkAllowed("rule14")
	{
	}
	
	// @notice function for clause �cl.name�
	function getAA() public
		checkAllowed("rule15")
	{
	}
	
	// @notice function for clause �cl.name�
	function setSolution(bytes32 _faultName, uint _compensation) public
		checkAllowed("rule16")
	{
		faultName = _faultName;
		compensation = _compensation;
	}
	
	// @notice function for clause �cl.name�
	function payFaultLO() public
		checkAllowed("rule17_1")
	{
		_asyncTransfer(lessee.id , compensation);
	}
	
	// @notice function for clause �cl.name�
	function payFaultLE() public
		checkAllowed("rule17_2")
	{
		_asyncTransfer(lessor.id , compensation);
	}
	
	// Fallback function
	function() external payable {}
	
	function clauseAllowed(bytes32 _clauseId) internal returns (bool) {
		if (_clauseId == "rule1") {
			require(onlyBy(ca.id), "Caller not authorized");
			require(onlyBefore(startTime, 0, false), "Function called too late");
			return true;
		}
		if (_clauseId == "rule2") {
			require(onlyBy(lessee.id), "Caller not authorized");
			require(onlyBefore(startTime, 0, false), "Function called too late");
			require(finalResult = true, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule3") {
			require(onlyBy(lessor.id), "Caller not authorized");
			require(onlyBefore(startTime, 0, false), "Function called too late");
			require( !end, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule4") {
			require(onlyBy(lessor.id), "Caller not authorized");
			require(!(callSuccess(this.changeUse.selector)), "Clause rule3 was fulfilled");
			require(onlyAfter(clauseFulfilledTime("rule3"), payLate, true), "Function not called within expected timeframe");
			require( !end, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule5") {
			require(onlyBy(lessor.id), "Caller not authorized");
			require(onlyAfter(DateTime.addDuration(startTime, payLate), 0, false), "Function called too early");
			require( !end, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule6") {
			require(onlyBy(lessee.id), "Caller not authorized");
			require(onlyBefore(finishTime, 0, false), "Function called too late");
			return true;
		}
		if (_clauseId == "rule7") {
			require(onlyBy(lessee.id), "Caller not authorized");
			require(onlyAfter(payTime, payLate, true), "Function not called within expected timeframe");
			require( !end, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule8") {
			require(onlyBy(lessor.id), "Caller not authorized");
			require(onlyAfter(DateTime.addDuration(payTime, payLate), 0, false), "Function called too early");
			require( !end, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule9") {
			require(onlyBy(lessee.id), "Caller not authorized");
			require(onlyBefore(DateTime.addDuration(startTime, totalPeriod), 0, false), "Function called too late");
			return true;
		}
		if (_clauseId == "rule10") {
			require(onlyBy(lessor.id), "Caller not authorized");
			require(callSuccess(this.confirmContinue.selector), "Action confirmContinue did not occur");
			require(callCaller(this.confirmContinue.selector) == lessee.id, "Party lessee did not confirmContinue");
			require(onlyAfter(callTime(this.confirmContinue.selector), 0, false), "Function called too early");
			require( !end, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule10_1") {
			require(onlyBy(lessor.id), "Caller not authorized");
			require(callSuccess(this.setContinue.selector), "Action setContinue did not occur");
			require(callCaller(this.setContinue.selector) == lessor.id, "Party lessor did not setContinue");
			require(onlyAfter(callTime(this.setContinue.selector), 0, false), "Function called too early");
			require( !end && continueResult, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule10_2") {
			require(onlyBy(lessor.id), "Caller not authorized");
			require(callSuccess(this.setContinue.selector), "Action setContinue did not occur");
			require(callCaller(this.setContinue.selector) == lessor.id, "Party lessor did not setContinue");
			require(onlyAfter(callTime(this.setContinue.selector), 0, false), "Function called too early");
			require( !end &&  !continueResult, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule11") {
			require(onlyBy(lessor.id), "Caller not authorized");
			require(onlyAfter(DateTime.addDuration(startTime, totalPeriod), 0, false), "Function called too early");
			require( !end, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule12") {
			require(onlyBy(ra.id), "Caller not authorized");
			return true;
		}
		if (_clauseId == "rule13") {
			require(onlyBy(ra.id), "Caller not authorized");
			return true;
		}
		if (_clauseId == "rule14") {
			require(onlyBy(lessor.id), "Caller not authorized");
			return true;
		}
		if (_clauseId == "rule15") {
			require(onlyBy(lessee.id), "Caller not authorized");
			return true;
		}
		if (_clauseId == "rule16") {
			require(onlyBy(aa.id), "Caller not authorized");
			require(callSuccess(this.getAA.selector), "Action getAA did not occur");
			require(callCaller(this.getAA.selector) == lessor.id, "Party lessor did not getAA");
			require(onlyAfter(callTime(this.getAA.selector), 0, false), "Function called too early");
			return true;
		}
		if (_clauseId == "rule17_1") {
			require(onlyBy(lessor.id), "Caller not authorized");
			require(callSuccess(this.setSolution.selector), "Action setSolution did not occur");
			require(callCaller(this.setSolution.selector) == aa.id, "Party aa did not setSolution");
			require(onlyAfter(callTime(this.setSolution.selector), 0, false), "Function called too early");
			require(faultName == "lessor", "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule17_2") {
			require(onlyBy(lessee.id), "Caller not authorized");
			require(callSuccess(this.setSolution.selector), "Action setSolution did not occur");
			require(callCaller(this.setSolution.selector) == aa.id, "Party aa did not setSolution");
			require(onlyAfter(callTime(this.setSolution.selector), 0, false), "Function called too early");
			require(faultName == "lessee", "Given condition(s) not met");
			return true;
		}
		return false;
	}
	
	function clauseFulfilledTime(bytes32 _clauseId) internal returns (uint) {
		uint max = 0;
		if (_clauseId == "rule1" && (callSuccess(this.checkResult.selector))) {
			if (max < callTime(this.checkResult.selector)) {
				max =  callTime(this.checkResult.selector);
			}
			return max;
		}
		if (_clauseId == "rule2" && (callSuccess(this.payOne.selector))) {
			if (max < callTime(this.payOne.selector)) {
				max =  callTime(this.payOne.selector);
			}
			return max;
		}
		if (_clauseId == "rule3" && (callSuccess(this.changeUse.selector))) {
			if (max < callTime(this.changeUse.selector)) {
				max =  callTime(this.changeUse.selector);
			}
			return max;
		}
		if (_clauseId == "rule4" && (callSuccess(this.deliveryLate.selector))) {
			if (max < callTime(this.deliveryLate.selector)) {
				max =  callTime(this.deliveryLate.selector);
			}
			return max;
		}
		if (_clauseId == "rule5" && (callSuccess(this.lateFinish.selector))) {
			if (max < callTime(this.lateFinish.selector)) {
				max =  callTime(this.lateFinish.selector);
			}
			return max;
		}
		if (_clauseId == "rule6" && (callSuccess(this.payRegular.selector))) {
			if (max < callTime(this.payRegular.selector)) {
				max =  callTime(this.payRegular.selector);
			}
			return max;
		}
		if (_clauseId == "rule7" && (callSuccess(this.payLate.selector))) {
			if (max < callTime(this.payLate.selector)) {
				max =  callTime(this.payLate.selector);
			}
			return max;
		}
		if (_clauseId == "rule8" && (callSuccess(this.backThing.selector))) {
			if (max < callTime(this.backThing.selector)) {
				max =  callTime(this.backThing.selector);
			}
			return max;
		}
		if (_clauseId == "rule9" && (callSuccess(this.confirmContinue.selector))) {
			if (max < callTime(this.confirmContinue.selector)) {
				max =  callTime(this.confirmContinue.selector);
			}
			return max;
		}
		if (_clauseId == "rule10" && (callSuccess(this.setContinue.selector))) {
			if (max < callTime(this.setContinue.selector)) {
				max =  callTime(this.setContinue.selector);
			}
			return max;
		}
		if (_clauseId == "rule10_1" && (callSuccess(this.changeFinish.selector))) {
			if (max < callTime(this.changeFinish.selector)) {
				max =  callTime(this.changeFinish.selector);
			}
			return max;
		}
		if (_clauseId == "rule10_2" && (callSuccess(this.rejectChange.selector))) {
			if (max < callTime(this.rejectChange.selector)) {
				max =  callTime(this.rejectChange.selector);
			}
			return max;
		}
		if (_clauseId == "rule11" && (callSuccess(this.finishBack.selector))) {
			if (max < callTime(this.finishBack.selector)) {
				max =  callTime(this.finishBack.selector);
			}
			return max;
		}
		if (_clauseId == "rule12" && (callSuccess(this.pauseContract.selector))) {
			if (max < callTime(this.pauseContract.selector)) {
				max =  callTime(this.pauseContract.selector);
			}
			return max;
		}
		if (_clauseId == "rule13" && (callSuccess(this.restartContract.selector))) {
			if (max < callTime(this.restartContract.selector)) {
				max =  callTime(this.restartContract.selector);
			}
			return max;
		}
		if (_clauseId == "rule14" && (callSuccess(this.getAA.selector))) {
			if (max < callTime(this.getAA.selector)) {
				max =  callTime(this.getAA.selector);
			}
			return max;
		}
		if (_clauseId == "rule15" && (callSuccess(this.getAA.selector))) {
			if (max < callTime(this.getAA.selector)) {
				max =  callTime(this.getAA.selector);
			}
			return max;
		}
		if (_clauseId == "rule16" && (callSuccess(this.setSolution.selector))) {
			if (max < callTime(this.setSolution.selector)) {
				max =  callTime(this.setSolution.selector);
			}
			return max;
		}
		if (_clauseId == "rule17_1" && (callSuccess(this.payFaultLO.selector))) {
			if (max < callTime(this.payFaultLO.selector)) {
				max =  callTime(this.payFaultLO.selector);
			}
			return max;
		}
		if (_clauseId == "rule17_2" && (callSuccess(this.payFaultLE.selector))) {
			if (max < callTime(this.payFaultLE.selector)) {
				max =  callTime(this.payFaultLE.selector);
			}
			return max;
		}
		return max;
	}
	
	function contractObeyed() internal returns (bool) {
		return true;
	}
	
}
