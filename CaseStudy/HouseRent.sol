// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract HouseRent  
{ 
	uint public deposit = 6000 ;
	uint public rent = 6000 ;
	uint256 public payDuration = 2592000 ;
	uint256 public maxDeliveryDelayTime = 604800 ;
	uint256 public maxPaymentDelayTime = 2592000 ;
	uint256 public payTime = 1699617600;
	uint256 public startTime = 1699617600;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
	struct aa {
		string name;
		address payable account;
	}
	struct ra {
		string name;
		address payable account;
	}
		struct House {
		   string   location ; 
		   string   useRight ; 
		   string   ownRight ; 
	}
	
	Person public Landlord = Person("LandlordA", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Tenant = Person("TenantB", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	aa public aa = aa("aa", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	ra public ra = ra("ra", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	modifier onlyLandlord(){
		require(msg.sender == Landlord.account,"Only Landlord can access this.");
		 _; 
	}
	modifier onlyTenant(){
		require(msg.sender == Tenant.account,"Only Tenant can access this.");
		 _; 
	}
	modifier onlyaa(){
		require(msg.sender == aa.account,"Only aa can access this.");
		 _; 
	}
	modifier onlyra(){
		require(msg.sender == ra.account,"Only ra can access this.");
		 _; 
	}
	House public house = House("thing", 1, "A");
	constructor() {
	}
	event completedRule(address indexed person, string rulename);
	function payRegular() internal{
		transferTo(Landlord.account,10**14*(rent));
		payTime=payTime+payDuration;
	}
	function completeDelivery() internal view returns (bool) {
		if (isDone("useRightDelivery")) return true;
		else return false;
	}
	function depositPay() public payable onlyState(ContractState) onlyTenant unDone("depositPay"){
		if(!isTime(startTime)){
			transferTo(Landlord.account,10**14*(deposit+rent));
			functionStatus["depositPay"] = true;
			functionFinishTime["depositPay"]=block.timestamp;
			emit completedRule(msg.sender,"depositPay");
		}
	}
	function lateDepositEnd() public payable onlyState(ContractState) onlyLandlord unDone("lateDepositEnd"){
		if(isTime(startTime)&&!isDone("depositPay")){
			ContractState="terminate";
			functionStatus["lateDepositEnd"] = true;
			functionFinishTime["lateDepositEnd"]=block.timestamp;
			emit completedRule(msg.sender,"lateDepositEnd");
		}
	}
	function useRightDelivery() public payable onlyState(ContractState) onlyLandlord unDone("useRightDelivery"){
		if(!isTime(startTime)&&isDone("depositPay")){
			house.useRight=Tenant.name;
			functionStatus["useRightDelivery"] = true;
			functionFinishTime["useRightDelivery"]=block.timestamp;
			emit completedRule(msg.sender,"useRightDelivery");
		}
	}
	function lateDeliveryPenalty() public payable onlyState(ContractState) onlyLandlord unDone("lateDeliveryPenalty"){
		if(isTime(startTime)&&!isDone("useRightDelivery")&&!isTime(startTime+maxDeliveryDelayTime)){
			house.useRight=Tenant.name;
			transferTo(Tenant.account,10**14*(rent));
			functionStatus["lateDeliveryPenalty"] = true;
			functionFinishTime["lateDeliveryPenalty"]=block.timestamp;
			emit completedRule(msg.sender,"lateDeliveryPenalty");
		}
	}
	function overdueDeliveryEnd() public payable onlyState(ContractState) onlyLandlord unDone("overdueDeliveryEnd"){
		if(!isDone("useRightDelivery")&&isTime(startTime+maxDeliveryDelayTime)){
			transferTo(Tenant.account,10**14*(deposit+rent));
			ContractState="terminate";
			functionStatus["overdueDeliveryEnd"] = true;
			functionFinishTime["overdueDeliveryEnd"]=block.timestamp;
			emit completedRule(msg.sender,"overdueDeliveryEnd");
		}
	}
	function payRent() public payable onlyState(ContractState) {
		if(completeDelivery()){
			if(isTime(payTime+maxPaymentDelayTime)&&!isTime(payTime+maxPaymentDelayTime+86400)){
				payRegular();
			}
			if(isTime(payTime+payDuration+86400)&&!isTime(payTime+payDuration+maxPaymentDelayTime)){
				transferTo(Landlord.account,10**14*(2*rent));
				payTime=payTime+payDuration;
			}
			functionStatus["payRent"] = true;
			functionFinishTime["payRent"]=block.timestamp;
			emit completedRule(msg.sender,"payRent");
		}
	}
	function lateRentPayPenalty() public payable onlyState(ContractState) onlyTenant unDone("lateRentPayPenalty"){
		if(completeDelivery()&&!isDone("payRent")&&isTime(payTime+payDuration+86400)&&!isTime(payTime+payDuration+maxPaymentDelayTime)){
			transferTo(Landlord.account,10**14*(2*rent));
			payTime=payTime+payDuration;
			functionStatus["lateRentPayPenalty"] = true;
			functionFinishTime["lateRentPayPenalty"]=block.timestamp;
			emit completedRule(msg.sender,"lateRentPayPenalty");
		}
	}
	function overdueRentPayEnd() public payable onlyState(ContractState) onlyLandlord unDone("overdueRentPayEnd"){
		if(completeDelivery()&&!isDone("payRent")&&!isDone("lateRentPayPenalty")&&isTime(payTime+payDuration+maxPaymentDelayTime)){
			ContractState="terminate";
			functionStatus["overdueRentPayEnd"] = true;
			functionFinishTime["overdueRentPayEnd"]=block.timestamp;
			emit completedRule(msg.sender,"overdueRentPayEnd");
		}
	}
	function houseCheck(bool _checkresult) public payable onlyState(ContractState) onlyLandlord unDone("houseCheck"){
		bool checkresult = _checkresult;   // Assign using the correct data type
		if(isTime(finishTime)){
			ContractState="terminate";
			house.useRight="Landlord.name";
			if(checkresult){
				transferTo(Tenant.account,10**14*(deposit));
				ContractState="finish";
			}
			functionStatus["houseCheck"] = true;
			functionFinishTime["houseCheck"]=block.timestamp;
			emit completedRule(msg.sender,"houseCheck");
		}
	}
	function arbitrateResult(string memory _aaresult) public payable onlyaa unDone("arbitrateResult"){
		aaresult = _aaresult;  
			functionStatus["arbitrateResult"] = true;
			functionFinishTime["arbitrateResult"]=block.timestamp;
			emit completedRule(msg.sender,"arbitrateResult");
	}
	function landlordCompensate() public payable onlyLandlord unDone("landlordCompensate"){
		if(isDone("arbitrateResult")&&compareStrings(aaresult,Landlord.name)){
			transferTo(Tenant.account,10**14*(penalty));
			ContractState="terminate";
			functionStatus["landlordCompensate"] = true;
			functionFinishTime["landlordCompensate"]=block.timestamp;
			emit completedRule(msg.sender,"landlordCompensate");
		}
	}
	function tenantCompensate() public payable onlyTenant unDone("tenantCompensate"){
		if(isDone("arbitrateResult")&&compareStrings(aaresult,Tenant.name)){
			transferTo(Landlord.account,10**14*(penalty));
			ContractState="terminate";
			functionStatus["tenantCompensate"] = true;
			functionFinishTime["tenantCompensate"]=block.timestamp;
			emit completedRule(msg.sender,"tenantCompensate");
		}
	}
	function regulatoryPause() public payable onlyra unDone("regulatoryPause"){
			ContractState="pause";
			functionStatus["regulatoryPause"] = true;
			functionFinishTime["regulatoryPause"]=block.timestamp;
			emit completedRule(msg.sender,"regulatoryPause");
	}
	function regulatoryRestart() public payable onlyra unDone("regulatoryRestart"){
			ContractState="restart";
			functionStatus["regulatoryRestart"] = true;
			functionFinishTime["regulatoryRestart"]=block.timestamp;
			emit completedRule(msg.sender,"regulatoryRestart");
	}
	function regulatoryTerminate() public payable onlyra unDone("regulatoryTerminate"){
			ContractState="terminate";
			functionStatus["regulatoryTerminate"] = true;
			functionFinishTime["regulatoryTerminate"]=block.timestamp;
			emit completedRule(msg.sender,"regulatoryTerminate");
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
