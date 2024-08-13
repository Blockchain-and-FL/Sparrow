pragma solidity >=0.4.0 <0.6.0;
		
import "./biddersT.sol";
import "./platformT.sol";
import "./auctioneerT.sol";
import "./ThingA.sol";
contract simpleAuction {
	
	biddersT bidders;
	platformT platform;
	auctioneerT auctioneer;
	
	uint BiddingStartTime;
	uint bidPrice;
	uint highestPrice;
	address highestBidder;
	uint BiddingStopTime;
	uint commission;
	
	uint start;
	
	function simpleAuction(){
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
	
	function payCommission() onlyauctioneer() public payable {
		//USER CODE HERE
		platform.amount.transfer(commission);
		//CHECK
	
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
		auctioneer.amount.transfer(highestPrice);
		//CHECK
	
	}
	
}
