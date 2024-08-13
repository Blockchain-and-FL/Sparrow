pragma solidity >=0.4.0 <0.6.0;
		
import "./SellerT.sol";
import "./BuyerT.sol";
import "./PlatformT.sol";
import "./ThingA.sol";
contract regularPurchase {
	
	SellerT Seller;
	BuyerT Buyer;
	PlatformT Platform;
	
	contractInfo info1;
	float lateIR;
	float finishIR;
	
	uint start;
	struct contractInfo{
		uint giveDate;
		uint Price;
	}
	
	function regularPurchase(){
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
	
	modifier no2Modifier{
		require(now < (info1.giveDate && now > Buyer.confirmBuyTime()));
		_;
	}
	
	modifier no3Modifier{
		require(now > (Seller.deliveryTime() || now > Seller.suspendDelivery1Time()));
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
	
	modifier no7Modifier{
		require((now > (info1.giveDate && now > Buyer.confirmBuyTime())) &&(now < (info1.giveDate && now > Buyer.confirmBuyTime())+432000));
		_;
	}
	
	modifier no8Modifier{
		require(now > (now > (info1.giveDate && now > Buyer.confirmBuyTime())+432000));
		_;
	}
	
	modifier no9Modifier{
		require(now > Seller.suspendDelivery2Time());
		_;
	}
	
	modifier no12Modifier{
		require(now > (Buyer.endSale2Time() || now > Seller.endSale1Time()));
		_;
	}
	
	function confirmBuy() onlyBuyer() public payable {
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
		thing.ownership = Buyer;
		//CHECK
		assert(thing.ownership == Buyer);
	}
	
	function endSale31() onlyPlatform() no5Modifier() public payable {
		//USER CODE HERE
		Seller.amount.transfer(info1.Price);
		//CHECK
	
	}
	
	function endSale32() onlyPlatform() no6Modifier() public payable {
		//USER CODE HERE
		thing.ownership = Buyer;
		Seller.amount.transfer(info1.Price);
		//CHECK
		assert(thing.ownership == Buyer);
	}
	
	function suspendDelivery1(uint lateDays) onlySeller() no7Modifier() public payable {
		//USER CODE HERE
		Buyer.amount.transfer(info1.Price * lateIR);
		//CHECK
	
	}
	
	function suspendDelivery2() onlySeller() no8Modifier() public payable {
		//USER CODE HERE
		Buyer.amount.transfer(info1.Price * lateIR);
		//CHECK
	
	}
	
	function endSale33() onlyPlatform() no9Modifier() public payable {
		//USER CODE HERE
		Buyer.amount.transfer(info1.Price);
		//CHECK
	
	}
	
	function endSale2() onlyBuyer() public payable {
		//USER CODE HERE
		Seller.amount.transfer(info1.Price * finishIR);
		//CHECK
	
	}
	
	function endSale1() onlySeller() public payable {
		//USER CODE HERE
		Buyer.amount.transfer(info1.Price * finishIR);
		//CHECK
	
	}
	
	function endSale34() onlyPlatform() no12Modifier() public payable {
		//USER CODE HERE
		Buyer.amount.transfer(info1.Price);
		//CHECK
	
	}
	
}
