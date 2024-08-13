pragma solidity >=0.4.0 <0.6.0;
		
import "./SellerT.sol";
import "./BuyerT.sol";
import "./PlatformT.sol";
import "./caT.sol";
import "./aaT.sol";
import "./raT.sol";
import "./courtT.sol";
import "./ThingA.sol";
contract complexPurchase {
	
	SellerT Seller;
	BuyerT Buyer;
	PlatformT Platform;
	caT ca;
	aaT aa;
	raT ra;
	courtT court;
	
	contractInfo info1;
	float lateIR;
	float finishIR;
	bool result;
	float lateAmount;
	bool confirmSolution;
	bytes32 solutionS;
	bytes32 solutionB;
	bytes32 faultName;
	uint Compensation;
	
	uint start;
	struct contractInfo{
		uint giveDate;
		uint Price;
	}
	
	function complexPurchase(){
		start = now;
		Seller = new SellerT();
		Buyer = new BuyerT();
		Platform = new PlatformT();
		ca = new caT();
		aa = new aaT();
		ra = new raT();
		court = new courtT();
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
	
	modifier onlycourt{
		require(court.contains(msg.sender));
		_;
	}
	
	modifier no2Modifier{
		require(result == true);
		_;
	}
	
	modifier no3Modifier{
		require(now < (info1.giveDate && now > Buyer.confirmBuyTime()));
		_;
	}
	
	modifier no4Modifier{
		require(now > (Seller.deliveryTime() || now > Seller.suspendDelivery1Time()));
		_;
	}
	
	modifier no5Modifier{
		require((now > Platform.confirmArriveTime()) &&(now < Platform.confirmArriveTime()+1296000));
		_;
	}
	
	modifier no6Modifier{
		require(now > Buyer.confirmGetTime());
		_;
	}
	
	modifier no7Modifier{
		require(now > (now > Platform.confirmArriveTime()+1296000));
		_;
	}
	
	modifier no8Modifier{
		require((now > (info1.giveDate && now > Buyer.confirmBuyTime())) &&(now < (info1.giveDate && now > Buyer.confirmBuyTime())+432000));
		_;
	}
	
	modifier no9Modifier{
		require(now > (now > (info1.giveDate && now > Buyer.confirmBuyTime())+432000));
		_;
	}
	
	modifier no10Modifier{
		require(now > Seller.suspendDelivery2Time());
		_;
	}
	
	modifier no13Modifier{
		require(now > (Buyer.endSale2Time() || now > Seller.endSale1Time()));
		_;
	}
	
	modifier no18Modifier{
		require(solutionS == null && solutionB == null);
		_;
	}
	
	modifier no19Modifier{
		require(now > Buyer.BuyerSetResultTime());
		_;
	}
	
	modifier no20_1Modifier{
		require((confirmSolution == true || now > (court.courtSetResultTime() || aa.aaSetResultTime())) && faultName == Seller.name);
		_;
	}
	
	modifier no20_2Modifier{
		require((confirmSolution == true || now > (court.courtSetResultTime() || aa.aaSetResultTime())) && faultName == Buyer.name);
		_;
	}
	
	modifier no21Modifier{
		require(solutionS == null && solutionB == null);
		_;
	}
	
	modifier no23Modifier{
		require(solutionS == null && solutionB == null);
		_;
	}
	
	function check(bool checkResult) onlyca() public {
		//USER CODE HERE
		result = checkResult;
		//CHECK
		assert(result == checkResult);
	}
	
	function confirmBuy() onlyBuyer() no2Modifier() public payable {
		//USER CODE HERE
		Platform.amount.transfer(info1.Price);
		//CHECK
	
	}
	
	function delivery() onlySeller() no3Modifier() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function confirmArrive() onlyPlatform() no4Modifier() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function confirmGet() onlyBuyer() no5Modifier() public {
		//USER CODE HERE
		thing.ownership = Buyer;
		//CHECK
		assert(thing.ownership == Buyer);
	}
	
	function endSale31() onlyPlatform() no6Modifier() public payable {
		//USER CODE HERE
		Seller.amount.transfer(info1.Price);
		//CHECK
	
	}
	
	function endSale32() onlyPlatform() no7Modifier() public payable {
		//USER CODE HERE
		thing.ownership = Buyer;
		Seller.amount.transfer(info1.Price);
		//CHECK
		assert(thing.ownership == Buyer);
	}
	
	function suspendDelivery1(uint lateDays) onlySeller() no8Modifier() public payable {
		//USER CODE HERE
		Buyer.amount.transfer(info1.Price * lateIR);
		//CHECK
	
	}
	
	function suspendDelivery2() onlySeller() no9Modifier() public payable {
		//USER CODE HERE
		Buyer.amount.transfer(info1.Price * lateIR);
		//CHECK
	
	}
	
	function endSale33() onlyPlatform() no10Modifier() public payable {
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
	
	function endSale34() onlyPlatform() no13Modifier() public payable {
		//USER CODE HERE
		Buyer.amount.transfer(info1.Price);
		//CHECK
	
	}
	
	function pauseContract() onlyra() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function restartContract() onlyra() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function chooseSolutionB(bytes32 solutionB) onlyBuyer() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function chooseSolutionS(bytes32 solutionS) onlySeller() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function BuyerSetResult(bytes32 name, uint Compensation) onlyBuyer() no18Modifier() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function confirmResult(bool confirm) onlySeller() no19Modifier() public {
		//USER CODE HERE
		confirmSolution = confirm;
		//CHECK
		assert(confirmSolution == confirm);
	}
	
	function payCompensationS() onlySeller() no20_1Modifier() public payable {
		//USER CODE HERE
		Buyer.amount.transfer(Compensation);
		//CHECK
	
	}
	
	function payCompensationB() onlyBuyer() no20_2Modifier() public payable {
		//USER CODE HERE
		Seller.amount.transfer(Compensation);
		//CHECK
	
	}
	
	function courtSetResult(bytes32 name, uint Compensation) onlycourt() no21Modifier() public {
		//USER CODE HERE
		faultName = name;
		Compensation = Compensation;
		//CHECK
		assert(faultName == name && Compensation == Compensation);
	}
	
	function aaSetResult(bytes32 name, uint Compensation) onlyaa() no23Modifier() public {
		//USER CODE HERE
		faultName = name;
		Compensation = Compensation;
		//CHECK
		assert(faultName == name && Compensation == Compensation);
	}
	
}
