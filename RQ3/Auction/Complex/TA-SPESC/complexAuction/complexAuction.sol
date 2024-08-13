pragma solidity >=0.4.0 <0.6.0;
		
import "./biddersT.sol";
import "./platformT.sol";
import "./auctioneerT.sol";
import "./caT.sol";
import "./aaT.sol";
import "./raT.sol";
import "./ThingA.sol";
contract complexAuction {
	
	biddersT bidders;
	platformT platform;
	auctioneerT auctioneer;
	caT ca;
	aaT aa;
	raT ra;
	
	uint BiddingStartTime;
	uint bidPrice;
	uint highestPrice;
	address highestBidder;
	uint BiddingStopTime;
	bool result;
	uint commission;
	float defaultIR;
	bytes32 faultName;
	uint compensation;
	
	uint start;
	
	function complexAuction(){
		start = now;
		bidders = new biddersT();
		platform = new platformT();
		auctioneer = new auctioneerT();
		ca = new caT();
		aa = new aaT();
		ra = new raT();
	}

	modifier onlybidders{
		require(bidders.contains(msg.sender));
		_;
	}
	
	modifier onlyplatform{
		require(platform.contains(msg.sender));
		_;
	}
	
	modifier onlyauctioneer{
		require(auctioneer.contains(msg.sender));
		_;
	}
	
	modifier onlyca{
		require(ca.contains(msg.sender));
		_;
	}
	
	modifier onlyaa{
		require(aa.contains(msg.sender));
		_;
	}
	
	modifier onlyra{
		require(ra.contains(msg.sender));
		_;
	}
	
	modifier no2Modifier{
		require(result == true);
		_;
	}
	
	modifier no3Modifier{
		require(now > BiddingStartTime);
		_;
	}
	
	modifier no4Modifier{
		require(now > (platform.StartBiddingTime() && now < (BiddingStopTime && bidPrice > highestPrice)));
		_;
	}
	
	modifier no5Modifier{
		require(bidders.contains(highestBidder) && ((now > BiddingStopTime) &&(now < BiddingStopTime+43200)));
		_;
	}
	
	modifier no6Modifier{
		require(now > bidders.payBidTime(msg.sender));
		_;
	}
	
	modifier no8Modifier{
		require(now > (now > (BiddingStopTime && bidders.contains(highestBidder))+43200));
		_;
	}
	
	modifier no9Modifier{
		require(now > bidders.payDefaultTime(msg.sender));
		_;
	}
	
	modifier no12Modifier{
		require(now > (now > BiddingStopTime+259200));
		_;
	}
	
	modifier no13Modifier{
		require(platform.getAATime());
		_;
	}
	
	modifier no14_1Modifier{
		require(now > (aa.aaSetResultTime() && faultName == platform.name));
		_;
	}
	
	modifier no14_2Modifier{
		require(now > (aa.aaSetResultTime() && (faultName == bidders.name && bidders.contains(highestBidder))));
		_;
	}
	
	function check(bool checkResult) onlyca() public {
		//USER CODE HERE
		result = checkResult;
		//CHECK
		assert(result == checkResult);
	}
	
	function payCommission() onlyauctioneer() no2Modifier() public payable {
		//USER CODE HERE
		thing.ownership = platform;
		platform.amount.transfer(commission);
		//CHECK
		assert(thing.ownership == platform);
	}
	
	function StartBidding() onlyplatform() no3Modifier() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function Bid(uint price) onlybidders() no4Modifier() public {
		//USER CODE HERE
		highestPrice = bidPrice;
		bidders.contains(highestBidder);
		//CHECK
		assert(highestPrice == bidPrice && bidders.contains(highestBidder));
	}
	
	function payBid() onlybidders() no5Modifier() public payable {
		//USER CODE HERE
		platform.amount.transfer(highestPrice);
		//CHECK
	
	}
	
	function transferRight() onlyplatform() no6Modifier() public payable {
		//USER CODE HERE
		thing.ownership = highestBidder;
		auctioneer.amount.transfer(highestPrice);
		//CHECK
		assert(thing.ownership == highestBidder);
	}
	
	function payDefault() onlybidders() no8Modifier() public payable {
		//USER CODE HERE
		platform.amount.transfer(highestPrice * defaultIR);
		//CHECK
	
	}
	
	function returnThing() onlyplatform() no9Modifier() public payable {
		//USER CODE HERE
		thing.ownership = auctioneer;
		platform.amount.transfer(highestPrice * defaultIR);
		//CHECK
		assert(thing.ownership == auctioneer);
	}
	
	function pauseContract() onlyra() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function restartContract() onlyra() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function getAA() onlyplatform() no12Modifier() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function aaSetResult(bytes32 name, uint Compensation) onlyaa() no13Modifier() public {
		//USER CODE HERE
		faultName = name;
		compensation = Compensation;
		//CHECK
		assert(faultName == name && compensation == Compensation);
	}
	
	function payCompensationP() onlyplatform() no14_1Modifier() public payable {
		//USER CODE HERE
		highestBidder.transfer(compensation);
		//CHECK
	
	}
	
	function payCompensationB() onlybidders() no14_2Modifier() public payable {
		//USER CODE HERE
		platform.amount.transfer(compensation);
		//CHECK
	
	}
	
}
