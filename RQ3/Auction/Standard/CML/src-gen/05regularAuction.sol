pragma solidity >=0.4.22 <0.7.0;
pragma experimental ABIEncoderV2;
import "./lib/cml/ConditionalContract.sol";
import "./lib/cml/DateTime.sol";
import "./lib/cml/IntLib.sol";
import "./lib/cml/RealLib.sol";
import "./lib/openzeppelin/PullPayment.sol";
import "./lib/cml/Model.sol";

contract RegularAuction is ConditionalContract, PullPayment {

	/*
	 * State variables
	 */
	Model.Party highestBidder;
	Model.Party auctioneer;
	Model.Party platform;
	uint commision;
	uint reservePrice;
	uint highestBid;
	uint biddingStart;
	uint biddingTime;
	uint lateTime1;
	uint lateTime2;
	bool ended;
	uint faultIR;
	bytes32 ownership;
	uint _contractStart;
	
	/*
	 * Constructor
	 */
	constructor(Model.Party memory _highestBidder, Model.Party memory _auctioneer, Model.Party memory _platform, uint _commision, uint _reservePrice, uint _highestBid, bytes32 _ownership, uint _biddingTime, uint _lateTime1, uint _lateTime2, uint _faultIR, uint _biddingStart)public {
		highestBidder = _highestBidder;
		auctioneer = _auctioneer;
		platform = _platform;
		commision = _commision;
		reservePrice = _reservePrice;
		highestBid = _highestBid;
		biddingTime = _biddingTime;
		lateTime1 = _lateTime1;
		lateTime2 = _lateTime2;
		faultIR = _faultIR;
		ownership = _ownership;
		biddingStart = _biddingStart;
		_contractStart = now;
	}
	
	/*
	 * Functions
	 */
	// @notice function for clause �cl.name�
	function payCommision() public
		checkAllowed("rule1")
	{
		_asyncTransfer(platform.id , commision);
		ownership = "platform";
	}
	
	// @notice function for clause �cl.name�
	function startBid() public
		checkAllowed("rule2")
	{
	}
	
	// @notice function for clause �cl.name�
	function bid() public
		checkAllowed("rule3")
	{
		require(msg.value > highestBid, "There already is a higher bid.");
		highestBidder = Model.Party(msg.sender);
		highestBid = msg.value;
	}
	
	// @notice function for clause �cl.name�
	function payHighest() public
		checkAllowed("rule4")
	{
		_asyncTransfer(platform.id , highestBid);
	}
	
	// @notice function for clause �cl.name�
	function endContract() public
		checkAllowed("rule5")
	{
		ended = true;
		ownership = "buyer";
		_asyncTransfer(auctioneer.id , highestBid);
	}
	
	// @notice function for clause �cl.name�
	function payFault() public
		checkAllowed("rule7")
	{
		_asyncTransfer(platform.id , faultIR * highestBid);
	}
	
	// @notice function for clause �cl.name�
	function endContract2() public
		checkAllowed("rule8")
	{
		ended = true;
		ownership = "seller";
		_asyncTransfer(auctioneer.id , highestBid * faultIR);
	}
	
	// Fallback function
	function() external payable {}
	
	function clauseAllowed(bytes32 _clauseId) internal returns (bool) {
		if (_clauseId == "rule1") {
			require(onlyBy(auctioneer.id), "Caller not authorized");
			return true;
		}
		if (_clauseId == "rule2") {
			require(onlyBy(platform.id), "Caller not authorized");
			require(onlyAfter(biddingStart, 0, false), "Function called too early");
			require( !ended, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule3") {
			require(onlyAfter(biddingStart, biddingTime, true), "Function not called within expected timeframe");
			require( !ended, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule4") {
			require(onlyBy(highestBidder.id), "Caller not authorized");
			require(onlyAfter(DateTime.addDuration(biddingStart, biddingTime), 12 hours, true), "Function not called within expected timeframe");
			require( !ended, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule5") {
			require(onlyBy(platform.id), "Caller not authorized");
			require(callSuccess(this.payHighest.selector), "Action payHighest did not occur");
			require(callCaller(this.payHighest.selector) == highestBidder.id, "Party highestBidder did not payHighest");
			require(onlyAfter(callTime(this.payHighest.selector), 0, false), "Function called too early");
			require( !ended, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule7") {
			require(onlyBy(highestBidder.id), "Caller not authorized");
			require( !ended, "Given condition(s) not met");
			return true;
		}
		if (_clauseId == "rule8") {
			require(onlyBy(platform.id), "Caller not authorized");
			require(callSuccess(this.payFault.selector), "Action payFault did not occur");
			require(callCaller(this.payFault.selector) == highestBidder.id, "Party highestBidder did not payFault");
			require(onlyAfter(callTime(this.payFault.selector), 0, false), "Function called too early");
			require( !ended, "Given condition(s) not met");
			return true;
		}
		return false;
	}
	
	function clauseFulfilledTime(bytes32 _clauseId) internal returns (uint) {
		uint max = 0;
		if (_clauseId == "rule1" && (callSuccess(this.payCommision.selector))) {
			if (max < callTime(this.payCommision.selector)) {
				max =  callTime(this.payCommision.selector);
			}
			return max;
		}
		if (_clauseId == "rule2" && (callSuccess(this.startBid.selector))) {
			if (max < callTime(this.startBid.selector)) {
				max =  callTime(this.startBid.selector);
			}
			return max;
		}
		if (_clauseId == "rule3" && (callSuccess(this.bid.selector))) {
			if (max < callTime(this.bid.selector)) {
				max =  callTime(this.bid.selector);
			}
			return max;
		}
		if (_clauseId == "rule4" && (callSuccess(this.payHighest.selector))) {
			if (max < callTime(this.payHighest.selector)) {
				max =  callTime(this.payHighest.selector);
			}
			return max;
		}
		if (_clauseId == "rule5" && (callSuccess(this.endContract.selector))) {
			if (max < callTime(this.endContract.selector)) {
				max =  callTime(this.endContract.selector);
			}
			return max;
		}
		if (_clauseId == "rule7" && (callSuccess(this.payFault.selector))) {
			if (max < callTime(this.payFault.selector)) {
				max =  callTime(this.payFault.selector);
			}
			return max;
		}
		if (_clauseId == "rule8" && (callSuccess(this.endContract2.selector))) {
			if (max < callTime(this.endContract2.selector)) {
				max =  callTime(this.endContract2.selector);
			}
			return max;
		}
		return max;
	}
	
	function contractObeyed() internal returns (bool) {
		return true;
	}
	
}