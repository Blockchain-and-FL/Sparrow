// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract dataCompliance  
{ 
	bool public hasBreachOccurred = false ;
	uint256 public contractStartDate = 1704067200;
	uint256 public contractEndDate = 1767225600;
	bool public isTerminated = false ;
	bool public authorizedForSub = false ;
	bool public isControllerAuditRequested = false ;
	bool public subProcessorApproved = false ;
	bool public dataDeletedOrReturned = false ;
	uint public dataStatus = 0 ;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct DataController {
		string name;
		address payable account;
	}
	struct DataProcessor {
		string name;
		address payable account;
	}
	struct SubProcessor {
		string name;
		address payable account;
	}
		struct PersonalData {
		   string   subjectId ; 
		   string   dataType ; 
		   string   value ; 
		   uint256  collectionTime ;
		   uint   status ; 
	}
	
		struct DataBreach {
		   uint   id ; 
		   string   breachType ; 
		   uint256  occurredAt ;
		   bool   notifiedController ; 
	}
	
	DataController public controller = DataController("Controller", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	DataProcessor public processor = DataProcessor("Processor", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	SubProcessor public subprocessor = SubProcessor("SubProcessor", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	modifier onlycontroller(){
		require(msg.sender == controller.account,"Only controller can access this.");
		 _; 
	}
	modifier onlyprocessor(){
		require(msg.sender == processor.account,"Only processor can access this.");
		 _; 
	}
	modifier onlysubprocessor(){
		require(msg.sender == subprocessor.account,"Only subprocessor can access this.");
		 _; 
	}
	DataBreach public lastBreach = DataBreach(0, "", 2145916800, false);
	PersonalData public record1 = PersonalData("user1", "email", "user@example.com", 1714521600, 0);
	constructor() {
	}
	event completedRule(address indexed person, string rulename);
	function notifyControllerOp() internal{
		hasBreachOccurred=false;
		lastBreach.notifiedController=true;
	}
	function contractOngoing() internal view returns (bool) {
		if (!isTerminated) return true;
		else return false;
	}
	function breachNotifyDue() internal view returns (bool) {
		if (hasBreachOccurred) return true;
		else return false;
	}
	function processorMustAssist() internal view returns (bool) {
		if (isControllerAuditRequested) return true;
		else return false;
	}
	function subProcessorAllowed() internal view returns (bool) {
		if (subProcessorApproved) return true;
		else return false;
	}
	function endOfContract() internal view returns (bool) {
		if (isTime(contractEndDate)) return true;
		else return false;
	}
	function giveInstructions(uint _dataStatus) public payable onlyState(ContractState) onlycontroller unDone("giveInstructions"){
		dataStatus = _dataStatus;  
			functionStatus["giveInstructions"] = true;
			functionFinishTime["giveInstructions"]=block.timestamp;
			emit completedRule(msg.sender,"giveInstructions");
	}
	function obeyInstructions() public payable onlyState(ContractState) onlyprocessor {
		if(contractOngoing()&&isDone("giveInstructions")&&logic(dataStatus,4,"<=")||logic(dataStatus,0,">=")){
			record1.status=dataStatus;
			functionStatus["giveInstructions"]=false;
			functionStatus["obeyInstructions"] = true;
			functionFinishTime["obeyInstructions"]=block.timestamp;
			emit completedRule(msg.sender,"obeyInstructions");
		}
	}
	function ControllerAuditRequested(bool _isControllerAuditRequested) public payable onlyState(ContractState) onlycontroller unDone("ControllerAuditRequested"){
		isControllerAuditRequested = _isControllerAuditRequested;  
			functionStatus["ControllerAuditRequested"] = true;
			functionFinishTime["ControllerAuditRequested"]=block.timestamp;
			emit completedRule(msg.sender,"ControllerAuditRequested");
	}
	function allowSubProcessorUse() public payable onlyState(ContractState) onlycontroller unDone("allowSubProcessorUse"){
		if(subProcessorAllowed()){
			authorizedForSub=true;
			functionStatus["allowSubProcessorUse"] = true;
			functionFinishTime["allowSubProcessorUse"]=block.timestamp;
			emit completedRule(msg.sender,"allowSubProcessorUse");
		}
	}
	function ProcessBySub() public payable onlyState(ContractState) onlysubprocessor {
		if(isDone("allowSubProcessorUse")&&authorizedForSub&&isDone("giveInstructions")){
			record1.status=dataStatus;
			functionStatus["ProcessBySub"] = true;
			functionFinishTime["ProcessBySub"]=block.timestamp;
			emit completedRule(msg.sender,"ProcessBySub");
		}
	}
	function foundBreach(bool _hasBreachOccurred) public payable onlyState(ContractState) onlyprocessor unDone("foundBreach"){
		hasBreachOccurred = _hasBreachOccurred;  
			hasBreachOccurred=true;
			functionStatus["foundBreach"] = true;
			functionFinishTime["foundBreach"]=block.timestamp;
			emit completedRule(msg.sender,"foundBreach");
	}
	function notifyBreach() public payable onlyState(ContractState) onlyprocessor {
		if(breachNotifyDue()){
			notifyControllerOp();
			functionStatus["notifyBreach"] = true;
			functionFinishTime["notifyBreach"]=block.timestamp;
			emit completedRule(msg.sender,"notifyBreach");
		}
	}
	function endAgreementDataHandling(uint _dataStatus) public payable onlyState(ContractState) unDone("endAgreementDataHandling"){
		dataStatus = _dataStatus;  
		if(endOfContract()&&!dataDeletedOrReturned){
			dataDeletedOrReturned=true;
			if(logic(dataStatus,2,"==")){
				record1.status=2;
			}
			if(logic(dataStatus,3,"==")){
				record1.status=3;
			}
			functionStatus["endAgreementDataHandling"] = true;
			functionFinishTime["endAgreementDataHandling"]=block.timestamp;
			emit completedRule(msg.sender,"endAgreementDataHandling");
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
