pragma solidity >=0.7.0 <0.9.0;
contract LightRent  
{ 
	uint public extend1 = 10000 ;
	uint public extend2 = 20000 ;
	uint public defaultMoney = 7710 ;
	uint256 public Proportion = 400.0 ;
	uint public dayNum = 0 ;
	uint256 public signTime = 1637193600;
	uint256 public period = 172800 ;
	string public signPlace = "HuangGang City, HuBei Province, HeFei" ;
	uint256 public startTime = 1637625600;
	uint256 public finishTime = 1637798400;
	bool public checkStatus = false ;
	uint public deviceAmount = 0 ;
	uint public defaultAmount = 10000 ;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
		struct token {
		   string   name ;
		   uint   price ;
	}
	
	Person public Buyer = Person("LuoTian County HuangMei Drama Group", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Seller = Person("GuangYing Electronic Products Sales Department, BaoHe District, HeTei City", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	modifier onlyBuyer(){
		require(msg.sender == Buyer.account,"Only Buyer can access this.");
		 _; 
	}
	modifier onlySeller(){
		require(msg.sender == Seller.account,"Only Seller can access this.");
		 _; 
	}
	token public Service = token("Performance services", 64807);
	constructor() {
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function depositPay() public payable onlyState(ContractState) onlyBuyer unDone("depositPay"){
		if(!isTime(signTime+period)){
			transferTo(Seller.account,10**14*Service.price*Proportion/1000);
			functionStatus["depositPay"] = true;
			functionFinishTime["depositPay"]=block.timestamp;
			emit completedRule(msg.sender,"depositPay");
		}
	}
	function depositPay_Late() public payable onlyState(ContractState) onlySeller unDone("depositPay_Late"){
		if(isTime(signTime+period)||!isDone("depositPay")){
			ContractState="terminate";
			functionStatus["depositPay_Late"] = true;
			functionFinishTime["depositPay_Late"]=block.timestamp;
			emit completedRule(msg.sender,"depositPay_Late");
		}
	}
	function balancePay() public payable onlyState(ContractState) onlyBuyer unDone("balancePay"){
		if(isDone("depositPay")||logic(block.timestamp,startTime,"==")){
			transferTo(Seller.account,10**14*Service.price-Service.price*Proportion/1000);
			functionStatus["balancePay"] = true;
			functionFinishTime["balancePay"]=block.timestamp;
			emit completedRule(msg.sender,"balancePay");
		}
	}
	function delivery() public payable onlyState(ContractState) onlySeller unDone("delivery"){
		if(isDone("balancePay")){
			functionStatus["delivery"] = true;
			functionFinishTime["delivery"]=block.timestamp;
			emit completedRule(msg.sender,"delivery");
		}
	}
	function confirm() public payable onlyState(ContractState) onlyBuyer unDone("confirm"){
		if(isDone("delivery")){
			functionStatus["confirm"] = true;
			functionFinishTime["confirm"]=block.timestamp;
			emit completedRule(msg.sender,"confirm");
		}
	}
	function fail_delivery(uint _lateDay) public payable onlyState(ContractState) onlySeller unDone("fail_delivery"){
		uint lateDay = _lateDay;	
		if(!isDone("confirm")||isTime(startTime)){
			transferTo(Buyer.account,10**14*lateDay*defaultMoney);
			functionStatus["fail_delivery"] = true;
			functionFinishTime["fail_delivery"]=block.timestamp;
			emit completedRule(msg.sender,"fail_delivery");
		}
	}
	function extended(uint _dayNum) public payable onlyState(ContractState) onlyBuyer unDone("extended"){
		dayNum = _dayNum;
		if(isDone("confirm")){
			if(logic(dayNum,1,"==")){
				transferTo(Seller.account,10**14*extend1);
			}
			if(logic(dayNum,1,"!=")){
				transferTo(Seller.account,10**14*extend1+extend2*dayNum-extend2);
			}
			functionStatus["extended"] = true;
			functionFinishTime["extended"]=block.timestamp;
			emit completedRule(msg.sender,"extended");
		}
	}
	function checkDevice(bool _checkStatus, uint _deviceAmount) public payable onlyState(ContractState) onlySeller unDone("checkDevice"){
		checkStatus = _checkStatus;
		deviceAmount = _deviceAmount;
		if(isTime(finishTime+dayNum)){
			functionStatus["checkDevice"] = true;
			functionFinishTime["checkDevice"]=block.timestamp;
			emit completedRule(msg.sender,"checkDevice");
		}
	}
	function status_good() public payable onlyState(ContractState) onlyBuyer unDone("status_good"){
		if(isDone("checkDevice")||isTrue(checkStatus)){
			ContractState="finish";
			functionStatus["status_good"] = true;
			functionFinishTime["status_good"]=block.timestamp;
			emit completedRule(msg.sender,"status_good");
		}
	}
	function status_bad() public payable onlyState(ContractState) onlyBuyer unDone("status_bad"){
		if(isDone("checkDevice")||!isTrue(checkStatus)){
			transferTo(Seller.account,10**14*deviceAmount);
			ContractState="finish";
			functionStatus["status_bad"] = true;
			functionFinishTime["status_bad"]=block.timestamp;
			emit completedRule(msg.sender,"status_bad");
		}
	}
	function terminate_Seller() public payable onlyState(ContractState) onlySeller unDone("terminate_Seller"){
		if(!isTime(finishTime+dayNum)){
			transferTo(Buyer.account,10**14*defaultAmount);
			ContractState="terminate";
			functionStatus["terminate_Seller"] = true;
			functionFinishTime["terminate_Seller"]=block.timestamp;
			emit completedRule(msg.sender,"terminate_Seller");
		}
	}
	function terminate_Buyer() public payable onlyState(ContractState) onlyBuyer unDone("terminate_Buyer"){
		if(!isTime(finishTime+dayNum)){
			transferTo(Seller.account,10**14*defaultAmount);
			ContractState="terminate";
			functionStatus["terminate_Buyer"] = true;
			functionFinishTime["terminate_Buyer"]=block.timestamp;
			emit completedRule(msg.sender,"terminate_Buyer");
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
	// Parameterized function to check whether a value is true
	function isTrue(bool valueToCheck) internal pure returns (bool) {
	    return valueToCheck == true;
	}
	event Transfer(address indexed from, address indexed to, uint amount);
	// Used to transfer funds to a specified address
	function transferTo(address payable recipient, uint amount) internal {
	    require(recipient != address(0), "Invalid recipient address");
	    require(amount > 0, "Amount must be greater than zero");
	    recipient.transfer(amount);
	    emit Transfer(msg.sender,recipient, amount);
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
