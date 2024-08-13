pragma solidity >=0.4.0 <0.6.0;
		
import "./SellerT.sol";
import "./BuyerT.sol";
import "./PlatformT.sol";
import "./ThingA.sol";
contract simplePurchase {
	
	SellerT Seller;
	BuyerT Buyer;
	PlatformT Platform;
	
	contractInfo info1;
	
	uint start;
	struct contractInfo{
		uint giveDate;
		uint Price;
	}
	
	function simplePurchase(){
		start = now;
		Seller = new SellerT();
		Buyer = new BuyerT();
		Platform = new PlatformT();
	}

	modifier onlySeller{
		require(Seller.contains(msg.sender));
		_;
	}
	
	modifier onlyBuyer{
		require(Buyer.contains(msg.sender));
		_;
	}
	
	modifier onlyPlatform{
		require(Platform.contains(msg.sender));
		_;
	}
	
	modifier no1Modifier{
		require(now < info1.giveDate);
		_;
	}
	
	modifier no2Modifier{
		require(now < (info1.giveDate && now > Buyer.confirmBuyTime()));
		_;
	}
	
	modifier no3Modifier{
		require(now > Seller.deliveryTime());
		_;
	}
	
	modifier no4Modifier{
		require((now > Platform.confirmArriveTime()) &&(now < Platform.confirmArriveTime()+1296000));
		_;
	}
	
	modifier no5Modifier{
		require(now > Buyer.confirmGetTime());
		_;
	}
	
	modifier no6Modifier{
		require(now > (now > Platform.confirmArriveTime()+1296000));
		_;
	}
	
	function confirmBuy() onlyBuyer() no1Modifier() public payable {
		//USER CODE HERE
		Platform.amount.transfer(info1.Price);
		//CHECK
	
	}
	
	function delivery() onlySeller() no2Modifier() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function confirmArrive() onlyPlatform() no3Modifier() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function confirmGet() onlyBuyer() no4Modifier() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function endSale31() onlyPlatform() no5Modifier() public payable {
		//USER CODE HERE
		Seller.amount.transfer(info1.Price);
		//CHECK
	
	}
	
	function endSale32() onlyPlatform() no6Modifier() public payable {
		//USER CODE HERE
		Seller.amount.transfer(info1.Price);
		//CHECK
	
	}
	
}
