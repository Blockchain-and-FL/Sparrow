// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract partnership  
{ 
	uint256 public pd = 7776000 ;
	uint public PLRatioForA = 60 ;
	uint public PLRatioForB = 40 ;
	uint256 public startTime = 1735689600;
	uint256 public finishTime = 1798675200;
	uint256 public payTime = 1738281600;
	bool public withdraw1 = false ;
	bool public withdraw2 = false ;
	bool public contri1 = false ;
	bool public contri2 = false ;
	uint public loss = 0 ;
	string public newName = "" ;
	address public newAccount = payable(payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
		struct contribution {
		   string   name ; 
		   uint   value ; 
		   string   ownRight ; 
	}
	
	Person public partner1 = Person("partnerA", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public partner2 = Person("partnerB", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	Person public manager = Person("manager", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	modifier onlypartner1(){
		require(msg.sender == partner1.account,"Only partner1 can access this.");
		 _; 
	}
	modifier onlypartner2(){
		require(msg.sender == partner2.account,"Only partner2 can access this.");
		 _; 
	}
	modifier onlymanager(){
		require(msg.sender == manager.account,"Only manager can access this.");
		 _; 
	}
	contribution public equipmentByA = contribution("equipment", 100000, "partnerA");
	contribution public timeEffortByB = contribution("timeEffort", 50000, "partnerB");
	constructor() {
	}
	event completedRule(address indexed person, string rulename);
	function payOp() internal{
		payTime=payTime+pd;
	}
	function payCon() internal view returns (bool) {
		if (isTime(payTime)) return true;
		else return false;
	}
	function lossShareCon() internal view returns (bool) {
		if (isDone("lossSet")||payCon()) return true;
		else return false;
	}
	function withdrawCon() internal view returns (bool) {
		if (isDone("checkResult")) return true;
		else return false;
	}
	function contribute1() public payable onlyState(ContractState) onlypartner1 unDone("contribute1"){
		if(!isTime(startTime)){
			contri1=true;
			functionStatus["contribute1"] = true;
			functionFinishTime["contribute1"]=block.timestamp;
			emit completedRule(msg.sender,"contribute1");
		}
	}
	function contribute2() public payable onlyState(ContractState) onlypartner2 unDone("contribute2"){
		if(!isTime(startTime)){
			contri2=true;
			functionStatus["contribute2"] = true;
			functionFinishTime["contribute2"]=block.timestamp;
			emit completedRule(msg.sender,"contribute2");
		}
	}
	function checkResult() public payable onlyState(ContractState) unDone("checkResult"){
		if(isDone("contribute1")&&isDone("contribute2")&&isTime(startTime)&&!isTime(startTime+86400)){
			if(!contri1||!contri2){
				ContractState="terminate";
			}
			functionStatus["checkResult"] = true;
			functionFinishTime["checkResult"]=block.timestamp;
			emit completedRule(msg.sender,"checkResult");
		}
	}
	function profitShared(uint _profit) public payable onlyState(ContractState) onlymanager {
		uint profit = _profit;   // Assign using the correct data type
		if(logic(profit,0,">")&&payCon()){
			transferTo(partner1.account,10**14*(profit*PLRatioForA*10.0));
			transferTo(partner2.account,10**14*(profit*PLRatioForB*10.0));
			payOp();
			functionStatus["profitShared"] = true;
			functionFinishTime["profitShared"]=block.timestamp;
			emit completedRule(msg.sender,"profitShared");
		}
	}
	function lossSet(uint _loss) public payable onlyState(ContractState) onlymanager {
		loss = _loss;  
			functionStatus["lossSet"] = true;
			functionFinishTime["lossSet"]=block.timestamp;
			emit completedRule(msg.sender,"lossSet");
	}
	function lossSharedA() public payable onlyState(ContractState) onlypartner1 {
		if(lossShareCon()){
			transferTo(manager.account,10**14*(loss*PLRatioForA*10.0));
			functionStatus["lossSharedA"] = true;
			functionFinishTime["lossSharedA"]=block.timestamp;
			emit completedRule(msg.sender,"lossSharedA");
		}
	}
	function lossSharedB() public payable onlyState(ContractState) onlypartner2 {
		if(lossShareCon()){
			transferTo(manager.account,10**14*(loss*PLRatioForB*10.0));
			functionStatus["lossSharedB"] = true;
			functionFinishTime["lossSharedB"]=block.timestamp;
			emit completedRule(msg.sender,"lossSharedB");
		}
	}
	function resetLoss() public payable onlyState(ContractState) {
		if(isDone("lossSharedA")&&isDone("lossSharedB")){
			loss=0;
			payOp();
			functionStatus["lossSharedA"]=false;
			functionStatus["lossSharedB"]=false;
			functionStatus["resetLoss"] = true;
			functionFinishTime["resetLoss"]=block.timestamp;
			emit completedRule(msg.sender,"resetLoss");
		}
	}
	function withdrawNoticeByA() public payable onlyState(ContractState) onlypartner1 unDone("withdrawNoticeByA"){
		if(withdrawCon()){
			withdraw1=true;
			functionStatus["withdrawNoticeByA"] = true;
			functionFinishTime["withdrawNoticeByA"]=block.timestamp;
			emit completedRule(msg.sender,"withdrawNoticeByA");
		}
	}
	function withdrawNoticeByB() public payable onlyState(ContractState) onlypartner2 unDone("withdrawNoticeByB"){
		if(withdrawCon()){
			withdraw2=true;
			functionStatus["withdrawNoticeByB"] = true;
			functionFinishTime["withdrawNoticeByB"]=block.timestamp;
			emit completedRule(msg.sender,"withdrawNoticeByB");
		}
	}
	function withdrawA(uint _property) public payable onlyState(ContractState) onlymanager unDone("withdrawA"){
		uint property = _property;   // Assign using the correct data type
		if(isDone("withdrawNoticeByA")&&withdraw1){
			transferTo(partner1.account,10**14*(property));
			PLRatioForB=100;
			functionStatus["withdrawA"] = true;
			functionFinishTime["withdrawA"]=block.timestamp;
			emit completedRule(msg.sender,"withdrawA");
		}
	}
	function withdrawB(uint _property) public payable onlyState(ContractState) onlymanager unDone("withdrawB"){
		uint property = _property;   // Assign using the correct data type
		if(isDone("withdrawNoticeByB")&&withdraw2){
			transferTo(partner2.account,10**14*(property));
			PLRatioForA=100;
			functionStatus["withdrawB"] = true;
			functionFinishTime["withdrawB"]=block.timestamp;
			emit completedRule(msg.sender,"withdrawB");
		}
	}
	function joinNew(string memory _newName, address _newAccount) public payable onlyState(ContractState) unDone("joinNew"){
		newName = _newName;  
		newAccount = _newAccount;  
			if(isDone("withdrawA")&&!isDone("withdrawB")){
				partner1.name=newName;
				partner1.account=payable(newAccount);
			}
			if(isDone("withdrawB")&&!isDone("withdrawA")){
				partner2.name=newName;
				partner2.account=payable(newAccount);
			}
			functionStatus["joinNew"] = true;
			functionFinishTime["joinNew"]=block.timestamp;
			emit completedRule(msg.sender,"joinNew");
	}
	function redistriPercen(uint _percentA, uint _percentB) public payable onlyState(ContractState) onlymanager unDone("redistriPercen"){
		uint percentA = _percentA;   // Assign using the correct data type
		uint percentB = _percentB;   // Assign using the correct data type
		if(isDone("joinNew")&&logic(percentA+percentB,100,"==")){
			PLRatioForA=percentA;
			PLRatioForB=percentB;
			functionStatus["redistriPercen"] = true;
			functionFinishTime["redistriPercen"]=block.timestamp;
			emit completedRule(msg.sender,"redistriPercen");
		}
	}
	// Check whether a specific function has already been executed
	function isDone(string memory functionName) internal view returns (bool) {
	    return functionStatus[functionName];
	}
	// Check if the current time reaches the target time
	function isTime(uint256 targetTime) internal view returns (bool) {
	    return block.timestamp >= targetTime;
	}
	// Helper function to perform comparisons based on a comparison operator
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
	
	
	    // Only allow execution of the setValue function if the condition valueA > valueB is met
	    function logic(uint256 valueA, uint256 valueB, string memory symbol) internal pure returns (bool) {
	        return compare(valueA, valueB, symbol);
	    }
	event Transfer(address indexed from, address indexed to, uint amount);
	// Used to transfer funds to a specified address
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
	// Custom modifier: allow or restrict execution based on the value of a string parameter
	modifier onlyState(string memory State) {
	    require(compareStrings(State, "start") || compareStrings(State, "restart"), "Not allowed in this state");
	     emit ContractStateChange(State);
	    _;
	}
	// Helper function to compare whether two strings are equal
	function compareStrings(string memory a, string memory b) internal pure returns (bool) {
	    return (keccak256(abi.encodePacked(a)) == keccak256(abi.encodePacked(b)));
	}
	
}
