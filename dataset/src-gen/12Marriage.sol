// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract marriage3  
{ 
	bool public isSpouseADead = false ;
	bool public isSpouseBDead = false ;
	bool public isSeperate = false ;
	uint256 public cohabitStartTime = 963187200;
	uint public jointFundValue = 0 ;
	bool public hasVacateNotice = false ;
	bool public isAllowedResident = true ;
	uint256 public noticeTime = 2145916800;
	uint256 public sepStartTime = 2145916800;
	uint256 public separationPd = 7776000 ;
	uint256 public vacatePd = 2592000 ;
	uint256 public serviceWindow = 1209600 ;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
		struct Gift {
		   string   description ; 
		   string   giver ; 
		   string   receiver ; 
		   uint   amount ; 
		   bool   isSigned ; 
	}
	
		struct Asset {
		   string   name ; 
		   uint   value ; 
		   string   owner ; 
		   bool   independent ; 
	}
	
		struct ServiceReport {
		   uint   id ; 
		   uint   amount ; 
		   uint256  reportTime ;
		   bool   paid ; 
	}
	
	Person public spouseA = Person("spouseA", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public spouseB = Person("spouseB", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	Person public currentServant = Person("currentServant", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	modifier onlyspouseA(){
		require(msg.sender == spouseA.account,"Only spouseA can access this.");
		 _; 
	}
	modifier onlyspouseB(){
		require(msg.sender == spouseB.account,"Only spouseB can access this.");
		 _; 
	}
	modifier onlycurrentServant(){
		require(msg.sender == currentServant.account,"Only currentServant can access this.");
		 _; 
	}
	Gift public giftSumA = Gift("", "B", "A", 2000, true);
	Gift public giftSumB = Gift("", "A", "B", 2000, true);
	Asset public home = Asset("HomeProperty", 5.0E8, "spouseA", true);
	Asset public car = Asset("CarModelX", 3.0E7, "spouseB", true);
	Asset public jointFund = Asset("JointFund", 0.0, "contract", false);
	ServiceReport public service = ServiceReport(0, 0, 2145916800, false);
	constructor() {
	}
	event completedRule(address indexed person, string rulename);
	function shareAssetOp() internal{
		transferTo(spouseA.account,10**14*(jointFundValue*500.0));
		transferTo(spouseB.account,10**14*(jointFundValue*500.0));
	}
	function vacateCon() internal view returns (bool) {
		if (hasVacateNotice) return true;
		else return false;
	}
	function updateJoiontFund(uint _jointFundValue) public payable onlyState(ContractState) {
		jointFundValue = _jointFundValue;  
			jointFund.value=jointFundValue;
			functionStatus["updateJoiontFund"] = true;
			functionFinishTime["updateJoiontFund"]=block.timestamp;
			emit completedRule(msg.sender,"updateJoiontFund");
	}
	function shareAssetByDead(bool _isSpouseADead, bool _isSpouseBDead, uint _jointFundValue) public payable onlyState(ContractState) unDone("shareAssetByDead"){
		isSpouseADead = _isSpouseADead;  
		isSpouseBDead = _isSpouseBDead;  
		jointFundValue = _jointFundValue;  
		if(isSpouseADead||isSpouseBDead){
			jointFund.value=jointFundValue;
			shareAssetOp();
			functionStatus["shareAssetByDead"] = true;
			functionFinishTime["shareAssetByDead"]=block.timestamp;
			emit completedRule(msg.sender,"shareAssetByDead");
		}
	}
	function recordSepStartTime() public payable onlyState(ContractState) {
			isSeperate=true;
			sepStartTime=block.timestamp;
			functionStatus["recordSepStartTime"] = true;
			functionFinishTime["recordSepStartTime"]=block.timestamp;
			emit completedRule(msg.sender,"recordSepStartTime");
	}
	function recordSepEndTime() public payable onlyState(ContractState) {
			isSeperate=false;
			functionStatus["recordSepEndTime"] = true;
			functionFinishTime["recordSepEndTime"]=block.timestamp;
			emit completedRule(msg.sender,"recordSepEndTime");
	}
	function shareAssetBySep(uint _jointFundValue) public payable onlyState(ContractState) unDone("shareAssetBySep"){
		jointFundValue = _jointFundValue;  
		if(!isDone("shareAssetByDead")&&isSeperate&&isTime(sepStartTime+separationPd)){
			jointFund.value=jointFundValue;
			shareAssetOp();
			functionStatus["shareAssetBySep"] = true;
			functionFinishTime["shareAssetBySep"]=block.timestamp;
			emit completedRule(msg.sender,"shareAssetBySep");
		}
	}
	function vacateNotice() public payable onlyState(ContractState) unDone("vacateNotice"){
			hasVacateNotice=true;
			noticeTime=block.timestamp;
			functionStatus["vacateNotice"] = true;
			functionFinishTime["vacateNotice"]=block.timestamp;
			emit completedRule(msg.sender,"vacateNotice");
	}
	function vacateEnforce() public payable onlyState(ContractState) unDone("vacateEnforce"){
		if(isDone("vacateNotice")&&vacateCon()){
			isAllowedResident=false;
			functionStatus["vacateEnforce"] = true;
			functionFinishTime["vacateEnforce"]=block.timestamp;
			emit completedRule(msg.sender,"vacateEnforce");
		}
	}
	function servicePay() public payable onlyState(ContractState) {
		if(!service.paid&&isTime(service.reportTime+serviceWindow)){
			transferTo(currentServant.account,10**14*(service.amount));
			jointFund.value=jointFund.value-service.amount;
			service.paid=true;
			functionStatus["servicePay"] = true;
			functionFinishTime["servicePay"]=block.timestamp;
			emit completedRule(msg.sender,"servicePay");
		}
	}
	// 检查某个功能是否已经执行
	function isDone(string memory functionName) internal view returns (bool) {
	    return functionStatus[functionName];
	}
	// 用于判断是否达到指定时间的函数
	function isTime(uint256 targetTime) internal view returns (bool) {
	    return block.timestamp >= targetTime;
	}
	// 辅助函数，根据比较符号执行比较
	    function compare(uint a, uint b, string memory op) internal pure returns (bool) {
	        if (compareStrings(op, ">")) {
	            return a > b;
	        } else if (compareStrings(op, "<")) {
	            return a < b;
	        } else if (compareStrings(op, ">=")) {
	            return a >= b;
	        } else if (compareStrings(op, "<=")) {
	            return a <= b;
	        } else if (compareStrings(op, "==")) {
	            return a == b;
	        } else if (compareStrings(op, "!=")) {
	            return a != b;
	        }
	        revert("Invalid operator.");
	    }
	
	
	    // 只有当满足条件 valueA > valueB 时，才能执行 setValue 函数
	    function logic(uint256 valueA, uint256 valueB, string memory symbol) internal pure returns (bool) {
	        return compare(valueA, valueB, symbol);
	    }
	event Transfer(address indexed from, address indexed to, uint amount);
	// 用于给指定地址转账
	function transferTo(address payable recipient, uint amount) internal {
	    require(recipient != address(0), "Invalid recipient address");
	    require(amount > 0, "Amount must be greater than zero");
	    recipient.transfer(amount);
	    emit Transfer(msg.sender,recipient, amount);
	}
	function compareTimestamps(uint256 timestamp1, uint256 timestamp2, uint256 customSeconds, string memory operator) internal pure returns (bool) {
	       // 计算两个时间戳的差值（取绝对值，确保差值为正数）
	       uint256 timeDifference = timestamp1 - timestamp2;
	       if (keccak256(bytes(operator)) == keccak256(bytes(">"))) {
	           return timeDifference > customSeconds;
	       } else if (keccak256(bytes(operator)) == keccak256(bytes("<"))) {
	           return timeDifference < customSeconds;
	       } else if (keccak256(bytes(operator)) == keccak256(bytes("=="))) {
	           return timeDifference == customSeconds;
	       } else if (keccak256(bytes(operator)) == keccak256(bytes("!=="))) {
	           return timeDifference != customSeconds;
	       } else {
	           revert("Invalid operator");
	       }
	   }
    modifier unDone(string memory functionName){
        require(!(functionStatus[functionName]),"require do this function unsucessfully");
        _;
    }
	event ContractStateChange(string newState);
	// 自定义 modifier：根据字符串参数值允许或禁止执行
	modifier onlyState(string memory State) {
	    require(compareStrings(State, "start") || compareStrings(State, "restart"), "Not allowed in this state");
	     emit ContractStateChange(State);
	    _;
	}
	// 辅助函数，比较两个字符串是否相等
	function compareStrings(string memory a, string memory b) internal pure returns (bool) {
	    return (keccak256(abi.encodePacked(a)) == keccak256(abi.encodePacked(b)));
	}
	
}
