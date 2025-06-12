// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract LiabilityRelease2  
{ 
	bool public voluntarySigned = false ;
	bool public waiverConfirmed = false ;
	bool public allRisksAcknowledged = false ;
	bool public damagePending = false ;
	bool public claimResolved = true ;
	uint256 public activityDate = 1749978000;
	uint256 public signTime = 1685620800;
	string public emergencyContact = "Wang Fang" ;
	string public emergencyPhone = "+65 9123 4567" ;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
		struct Risk {
		   string   description ; 
		   bool   acknowledged ; 
	}
	
		struct Waiver {
		   string   cause ; 
		   string   consequence ; 
		   bool   isWaived ; 
	}
	
		struct DamageClaim {
		   string   reason ; 
		   string   liableParty ; 
		   string   victim ; 
		   uint   amount ; 
		   bool   resolved ; 
	}
	
	Person public releasor = Person("Releasor", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public releasee = Person("Releasee", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	modifier onlyreleasor(){
		require(msg.sender == releasor.account,"Only releasor can access this.");
		 _; 
	}
	modifier onlyreleasee(){
		require(msg.sender == releasee.account,"Only releasee can access this.");
		 _; 
	}
	Risk public risk1 = Risk("Physical injury (e.g., sprains, fractures)", false);
	Risk public risk2 = Risk("Psychological stress or discomfort", false);
	Risk public risk3 = Risk("Equipment malfunction", false);
	Risk public risk4 = Risk("Weather-related accidents", false);
	Waiver public waiver1 = Waiver("Physical injury during activity", "No liability to Releasee", false);
	Waiver public waiver2 = Waiver("Equipment failure", "No liability to Releasee", false);
	Waiver public waiver3 = Waiver("Unforeseen weather risks", "No liability to Releasee", false);
	DamageClaim public claim = DamageClaim("No claim yet", "releasor", "releasee", 0.0, true);
	constructor() {
	}
	event completedRule(address indexed person, string rulename);
	function confirmConsent() internal{
		voluntarySigned=true;
	}
	function acceptAllRisks() internal{
		risk1.acknowledged=true;
		risk2.acknowledged=true;risk3.acknowledged=true;risk4.acknowledged=true;
	}
	function waiveAllLiabilities() internal{
		waiver1.isWaived=true;
		waiver2.isWaived=true;waiver3.isWaived=true;
	}
	function resolveClaim() internal{
		claim.resolved=true;
		damagePending=false;claimResolved=true;
	}
	function canClaim() internal view returns (bool) {
		if (isTime(activityDate)) return true;
		else return false;
	}
	function validClaim1() internal view returns (bool) {
		if (compareStrings(claim.liableParty,releasor.name)) return true;
		else return false;
	}
	function validClaim2() internal view returns (bool) {
		if (compareStrings(claim.liableParty,releasee.name)) return true;
		else return false;
	}
	function canArchive() internal view returns (bool) {
		if (isTime(activityDate+86400)) return true;
		else return false;
	}
	function signAgreement() public payable onlyState(ContractState) onlyreleasor unDone("signAgreement"){
		if(isTime(signTime)&&!isTime(signTime+86400)){
			confirmConsent();
			acceptAllRisks();
			waiveAllLiabilities();
			waiverConfirmed=true;
			allRisksAcknowledged=true;
			functionStatus["signAgreement"] = true;
			functionFinishTime["signAgreement"]=block.timestamp;
			emit completedRule(msg.sender,"signAgreement");
		}
	}
	function submitClaim(string memory _liableParty, string memory _victim, string memory _reason, uint _amount) public payable onlyState(ContractState) unDone("submitClaim"){
		string memory liableParty = "liableParty"; 
		string memory victim = "victim"; 
		string memory reason = "reason"; 
		uint amount = _amount;   // 使用正确的类型进行赋值
		if(isDone("signAgreement")&&canClaim()&&voluntarySigned&&!damagePending){
			if(validClaim1()||validClaim2()){
				claim.reason=reason;
				claim.liableParty=liableParty;
				claim.victim=victim;
				claim.amount=amount;
				claim.resolved=false;
				damagePending=true;
				claimResolved=false;
			}
			functionStatus["submitClaim"] = true;
			functionFinishTime["submitClaim"]=block.timestamp;
			emit completedRule(msg.sender,"submitClaim");
		}
	}
	function payCompensation() public payable onlyState(ContractState) unDone("payCompensation"){
		if(isDone("submitClaim")&&damagePending&&!claimResolved){
			if(validClaim1()){
				transferTo(releasee.account,10**14*(claim.amount));
				resolveClaim();
			}
			if(validClaim2()){
				transferTo(releasor.account,10**14*(claim.amount));
				resolveClaim();
			}
			functionStatus["payCompensation"] = true;
			functionFinishTime["payCompensation"]=block.timestamp;
			emit completedRule(msg.sender,"payCompensation");
		}
	}
	function archiveAgreement() public payable onlyState(ContractState) onlyreleasee unDone("archiveAgreement"){
		if(canArchive()&&!damagePending){
			ContractState="finish";
			functionStatus["archiveAgreement"] = true;
			functionFinishTime["archiveAgreement"]=block.timestamp;
			emit completedRule(msg.sender,"archiveAgreement");
		}
	}
	// 用于判断是否达到指定时间的函数
	function isTime(uint256 targetTime) internal view returns (bool) {
	    return block.timestamp >= targetTime;
	}
	// 检查某个功能是否已经执行
	function isDone(string memory functionName) internal view returns (bool) {
	    return functionStatus[functionName];
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
