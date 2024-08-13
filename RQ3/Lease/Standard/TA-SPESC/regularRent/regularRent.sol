pragma solidity >=0.4.0 <0.6.0;
		
import "./LessorT.sol";
import "./LesseeT.sol";
import "./ThingA.sol";
contract regularRent {
	
	LessorT Lessor;
	LesseeT Lessee;
	
	contractInfo info1;
	bool result;
	float faultIR;
	uint lateDays;
	uint continueDays;
	bool continue;
	
	uint start;
	struct contractInfo{
		uint payDate;
		uint signTime;
		uint rent;
		uint continueRent;
		uint depositMoney;
		uint startDate;
		uint finishDate;
		uint payDuration;
	}
	
	function regularRent(){
		start = now;
		Lessor = new LessorT();
		Lessee = new LesseeT();
	}

	modifier onlyLessor{
		require(Lessor.contains(msg.sender));
		_;
	}
	
	modifier onlyLessee{
		require(Lessee.contains(msg.sender));
		_;
	}
	
	modifier no1Modifier{
		require(now < info1.startDate);
		_;
	}
	
	modifier no2Modifier{
		require(now > (Lessee.payFirstTime() && now < info1.startDate));
		_;
	}
	
	modifier no3Modifier{
		require((now > info1.startDate) &&(now < info1.startDate+432000));
		_;
	}
	
	modifier no4Modifier{
		require(now > (now > info1.startDate+432000));
		_;
	}
	
	modifier no5Modifier{
		require((now > info1.payDate + info1.payDuration) &&(now < info1.payDate + info1.payDuration+86400));
		_;
	}
	
	modifier no6Modifier{
		require((now > info1.payDate + info1.payDuration) &&(now < info1.payDate + info1.payDuration+432000));
		_;
	}
	
	modifier no7Modifier{
		require(now > (now > info1.payDate + info1.payDuration+432000));
		_;
	}
	
	modifier no8Modifier{
		require(now < info1.finishDate);
		_;
	}
	
	modifier no9_1Modifier{
		require(now > (Lessee.continueTime() && continue == true));
		_;
	}
	
	modifier no9_2Modifier{
		require(now > (Lessee.continueTime() && continue == false));
		_;
	}
	
	modifier no10Modifier{
		require(now > info1.finishDate);
		_;
	}
	
	function payFirst() onlyLessee() no1Modifier() public payable {
		//USER CODE HERE
		Lessor.transfer(info1.rent + info1.depositMoney);
		//CHECK
	
	}
	
	function changeUse() onlyLessor() no2Modifier() public {
		//USER CODE HERE
		thing.useRight = Lessee;
		//CHECK
		assert(thing.useRight == Lessee);
	}
	
	function changeLate(uint LateDay) onlyLessor() no3Modifier() public payable {
		//USER CODE HERE
		lateDays = LateDay;
		Lessee.transfer(info1.rent * faultIR);
		//CHECK
		assert(lateDays == LateDay);
	}
	
	function finishLate() onlyLessor() no4Modifier() public payable {
		//USER CODE HERE
		Lessee && 0.transfer(info1.rent * faultIR);
		Lessee.transfer(info1.rent + info1.depositMoney);
		//CHECK
	
	}
	
	function payRegular() onlyLessee() no5Modifier() public payable {
		//USER CODE HERE
		info1.payDate = now;
		Lessor.transfer(info1.rent);
		//CHECK
		assert(info1.payDate == now);
	}
	
	function payRegularLate(uint LateDay) onlyLessee() no6Modifier() public payable {
		//USER CODE HERE
		info1.payDate = info1.payDate + info1.payDuration;
		Lessor.transfer(info1.rent * lateDays);
		//CHECK
		assert(info1.payDate == info1.payDate + info1.payDuration);
	}
	
	function back() onlyLessor() no7Modifier() public {
		//USER CODE HERE
		thing.useRight = Lessor;
		//CHECK
		assert(thing.useRight == Lessor);
	}
	
	function continue(uint days) onlyLessee() no8Modifier() public payable {
		//USER CODE HERE
		continueDays = days;
		Lessor.transfer(info1.continueRent * continueDays);
		//CHECK
		assert(continueDays == days);
	}
	
	function confirmContinue(bool result) onlyLessor() no9_1Modifier() public {
		//USER CODE HERE
		continue = result;
		info1.finishDate = info1.finishDate + continueDays;
		//CHECK
		assert(continue == result && info1.finishDate == info1.finishDate + continueDays);
	}
	
	function confirmContinue(bool result) onlyLessor() no9_2Modifier() public payable {
		//USER CODE HERE
		continue = result;
		Lessee.transfer(info1.continueRent * continueDays);
		//CHECK
		assert(continue == result);
	}
	
	function endRent() onlyLessor() no10Modifier() public payable {
		//USER CODE HERE
		thing.useRight = Lessor;
		Lessee.amount.transfer(info1.depositMoney);
		//CHECK
		assert(thing.useRight == Lessor);
	}
	
}
