pragma solidity >=0.4.0 <0.6.0;
		
import "./LessorT.sol";
import "./LesseeT.sol";
import "./ThingA.sol";
contract simpleRent {
	
	LessorT Lessor;
	LesseeT Lessee;
	
	contractInfo info1;
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
	
	function simpleRent(){
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
		require((now > info1.payDate + info1.payDuration) &&(now < info1.payDate + info1.payDuration+86400));
		_;
	}
	
	modifier no3Modifier{
		require(now < info1.finishDate);
		_;
	}
	
	modifier no4_1Modifier{
		require(now > (Lessee.continueTime() && continue == true));
		_;
	}
	
	modifier no4_2Modifier{
		require(now > (Lessee.continueTime() && continue == false));
		_;
	}
	
	modifier no5Modifier{
		require(now > info1.finishDate);
		_;
	}
	
	function payFirst() onlyLessee() no1Modifier() public payable {
		//USER CODE HERE
		Lessor.transfer(info1.rent + info1.depositMoney);
		//CHECK
	
	}
	
	function payRegular() onlyLessee() no2Modifier() public payable {
		//USER CODE HERE
		info1.payDate = now;
		Lessor.transfer(info1.rent);
		//CHECK
		assert(info1.payDate == now);
	}
	
	function continue(uint days) onlyLessee() no3Modifier() public payable {
		//USER CODE HERE
		continueDays = days;
		Lessor.transfer(info1.continueRent * continueDays);
		//CHECK
		assert(continueDays == days);
	}
	
	function confirmContinue(bool result) onlyLessor() no4_1Modifier() public {
		//USER CODE HERE
		continue = result;
		info1.finishDate = info1.finishDate + continueDays;
		//CHECK
		assert(continue == result && info1.finishDate == info1.finishDate + continueDays);
	}
	
	function confirmContinue(bool result) onlyLessor() no4_2Modifier() public payable {
		//USER CODE HERE
		continue = result;
		Lessee.transfer(info1.continueRent * continueDays);
		//CHECK
		assert(continue == result);
	}
	
	function endRent() onlyLessor() no5Modifier() public payable {
		//USER CODE HERE
		Lessee.amount.transfer(info1.depositMoney);
		//CHECK
	
	}
	
}
