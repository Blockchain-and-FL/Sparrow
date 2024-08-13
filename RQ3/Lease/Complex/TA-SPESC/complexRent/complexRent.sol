pragma solidity >=0.4.0 <0.6.0;
		
import "./LessorT.sol";
import "./LesseeT.sol";
import "./caT.sol";
import "./aaT.sol";
import "./raT.sol";
import "./ThingA.sol";
contract complexRent {
	
	LessorT Lessor;
	LesseeT Lessee;
	caT ca;
	aaT aa;
	raT ra;
	
	contractInfo info1;
	bool result;
	float faultIR;
	bytes32 faultName;
	uint compensation;
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
	
	function complexRent(){
		start = now;
		Lessor = new LessorT();
		Lessee = new LesseeT();
		ca = new caT();
		aa = new aaT();
		ra = new raT();
	}

	modifier onlyLessor{
		require(Lessor.contains(msg.sender));
		_;
	}
	
	modifier onlyLessee{
		require(Lessee.contains(msg.sender));
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
	
	modifier no1Modifier{
		require(now < info1.startDate);
		_;
	}
	
	modifier no2Modifier{
		require(result == true && now < info1.startDate);
		_;
	}
	
	modifier no3Modifier{
		require(now > (Lessee.payFirstTime() && now < info1.startDate));
		_;
	}
	
	modifier no4Modifier{
		require((now > info1.startDate) &&(now < info1.startDate+432000));
		_;
	}
	
	modifier no5Modifier{
		require(now > (now > info1.startDate+432000));
		_;
	}
	
	modifier no6Modifier{
		require((now > info1.payDate + info1.payDuration) &&(now < info1.payDate + info1.payDuration+86400));
		_;
	}
	
	modifier no7Modifier{
		require((now > info1.payDate + info1.payDuration) &&(now < info1.payDate + info1.payDuration+432000));
		_;
	}
	
	modifier no8Modifier{
		require(now > (now > info1.payDate + info1.payDuration+432000));
		_;
	}
	
	modifier no9Modifier{
		require(now < info1.finishDate);
		_;
	}
	
	modifier no10_1Modifier{
		require(now > (Lessee.continueTime() && continue == true));
		_;
	}
	
	modifier no10_2Modifier{
		require(now > (Lessee.continueTime() && continue == false));
		_;
	}
	
	modifier no11Modifier{
		require(now > info1.finishDate);
		_;
	}
	
	modifier no16Modifier{
		require(Lessor.getAA1Time() || Lessee.getAA2Time());
		_;
	}
	
	modifier no17_1Modifier{
		require(now > (aa.aaSetResultTime() && faultName == Lessor.name));
		_;
	}
	
	modifier no18_2Modifier{
		require(now > (aa.aaSetResultTime() && faultName == Lessee.name));
		_;
	}
	
	function check(bool checkResult) onlyca() no1Modifier() public {
		//USER CODE HERE
		result = checkResult;
		//CHECK
		assert(result == checkResult);
	}
	
	function payFirst() onlyLessee() no2Modifier() public payable {
		//USER CODE HERE
		Lessor.transfer(info1.rent + info1.depositMoney);
		//CHECK
	
	}
	
	function changeUse() onlyLessor() no3Modifier() public {
		//USER CODE HERE
		thing.useRight = Lessee;
		//CHECK
		assert(thing.useRight == Lessee);
	}
	
	function changeLate(uint LateDay) onlyLessor() no4Modifier() public payable {
		//USER CODE HERE
		lateDays = LateDay;
		Lessee.transfer(info1.rent * faultIR);
		//CHECK
		assert(lateDays == LateDay);
	}
	
	function finishLate() onlyLessor() no5Modifier() public payable {
		//USER CODE HERE
		Lessee && 0.transfer(info1.rent * faultIR);
		Lessee.transfer(info1.rent + info1.depositMoney);
		//CHECK
	
	}
	
	function payRegular() onlyLessee() no6Modifier() public payable {
		//USER CODE HERE
		info1.payDate = now;
		Lessor.transfer(info1.rent);
		//CHECK
		assert(info1.payDate == now);
	}
	
	function payRegularLate(uint LateDay) onlyLessee() no7Modifier() public payable {
		//USER CODE HERE
		info1.payDate = info1.payDate + info1.payDuration;
		Lessor.transfer(info1.rent * lateDays);
		//CHECK
		assert(info1.payDate == info1.payDate + info1.payDuration);
	}
	
	function back() onlyLessor() no8Modifier() public {
		//USER CODE HERE
		thing.useRight = Lessor;
		//CHECK
		assert(thing.useRight == Lessor);
	}
	
	function continue(uint days) onlyLessee() no9Modifier() public payable {
		//USER CODE HERE
		continueDays = days;
		Lessor.transfer(info1.continueRent * continueDays);
		//CHECK
		assert(continueDays == days);
	}
	
	function confirmContinue(bool result) onlyLessor() no10_1Modifier() public {
		//USER CODE HERE
		continue = result;
		info1.finishDate = info1.finishDate + continueDays;
		//CHECK
		assert(continue == result && info1.finishDate == info1.finishDate + continueDays);
	}
	
	function confirmContinue(bool result) onlyLessor() no10_2Modifier() public payable {
		//USER CODE HERE
		continue = result;
		Lessee.transfer(info1.continueRent * continueDays);
		//CHECK
		assert(continue == result);
	}
	
	function endRent() onlyLessor() no11Modifier() public payable {
		//USER CODE HERE
		thing.useRight = Lessor;
		Lessee.amount.transfer(info1.depositMoney);
		//CHECK
		assert(thing.useRight == Lessor);
	}
	
	function pauseContract() onlyra() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function restartContract() onlyra() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function getAA1() onlyLessor() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function getAA2() onlyLessee() public {
		//USER CODE HERE
		//CHECK
	
	}
	
	function aaSetResult(bytes32 name, uint Compensation) onlyaa() no16Modifier() public {
		//USER CODE HERE
		faultName = name;
		compensation = Compensation;
		//CHECK
		assert(faultName == name && compensation == Compensation);
	}
	
	function payCompensation1() onlyLessor() no17_1Modifier() public payable {
		//USER CODE HERE
		Lessee.transfer(compensation);
		//CHECK
	
	}
	
	function payCompensation2() onlyLessee() no18_2Modifier() public payable {
		//USER CODE HERE
		Lessor.transfer(compensation);
		//CHECK
	
	}
	
}
