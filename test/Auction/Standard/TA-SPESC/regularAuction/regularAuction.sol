pragma solidity >=0.4.0 <0.6.0;
		
import "./biddersT.sol";
import "./platformT.sol";
import "./auctioneerT.sol";
import "./ThingA.sol";
contract regularAuction {
	
	biddersT bidders;
	platformT platform;
	auctioneerT auctioneer;
	
	uint BiddingStartTime;
	uint bidPrice;
	uint highestPrice;
	address highestBidder;
	uint BiddingStopTime;
	uint commission;
	float defaultIR;
	
	uint start;
	
	function regularAuction(){
		start = now;
		bidders = new biddersT();
		platform = new platformT();
		auctioneer = new auctioneerT();
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
	
	modifier no2Modifier{
		require(now > BiddingStartTime);
		_;
	}
	
	modifier no3Modifier{
		require(now > (platform.StartBiddingTime() && now < (BiddingStopTime && bidPrice > highestPrice)));
		_;
	}
	
	modifier no4Modifier{
		require(bidders.contains(highestBidder) && ((now > BiddingStopTime) &&(now < BiddingStopTime+43200)));
		_;
	}
	
	modifier no5Modifier{
		require(now > bidders.payBidTime(msg.sender));
		_;
	}
	
	modifier no7Modifier{
		require(now > (now > (BiddingStopTime && bidders.contains(highestBidder))+43200));
		_;
	}
	
	modifier no8Modifier{
		require(now > bidders.payDefaultTime(msg.sender));
		_;
	}
	
	function payCommission() onlyauctioneer() public payable {
		//USER CODE HERE
		thing.ownership = platform;
		platform.amount.transfer(commission);
		//CHECK
		assert(thing.ownership == platform);
	}
	
	function StartBidding() onlyplatform() no2Modifier() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function Bid(uint price) onlybidders() no3Modifier() public {
		//USER CODE HERE
		highestPrice = bidPrice;
		bidders.contains(highestBidder);
		//CHECK
		assert(highestPrice == bidPrice && bidders.contains(highestBidder));
	}
	
	function payBid() onlybidders() no4Modifier() public payable {
		//USER CODE HERE
		platform.amount.transfer(highestPrice);
		//CHECK
	
	}
	
	function transferRight() onlyplatform() no5Modifier() public payable {
		//USER CODE HERE
		thing.ownership = highestBidder;
		auctioneer.amount.transfer(highestPrice);
		//CHECK
		assert(thing.ownership == highestBidder);
	}
	
	function payDefault() onlybidders() no7Modifier() public payable {
		//USER CODE HERE
		platform.amount.transfer(highestPrice * defaultIR);
		//CHECK
	
	}
	
	function returnThing() onlyplatform() no8Modifier() public payable {
		//USER CODE HERE
		thing.ownership = auctioneer;
		platform.amount.transfer(highestPrice * defaultIR);
		//CHECK
		assert(thing.ownership == auctioneer);
	}
	
}
