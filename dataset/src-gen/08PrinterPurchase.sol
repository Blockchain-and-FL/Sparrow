pragma solidity >=0.7.0 <0.9.0;
contract PrinterPurchase  
{ 
	string public place = "Huangshi No. 2 Middle School" ;
	uint256 public giveTime = 1668816000;
	string public faultName = "" ;
	uint public amountMoney = 0 ;
	bool public checkResult = false ;
	uint256 public period = 2592000 ;
	uint public dayNum = 0 ;
	uint256 public Proportion = 50.0 ;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
	struct Aa {
		string name;
		address payable account;
	}
		struct token {
		   string   name ;
		   string   ID ;
		   uint   number ;
		   uint   unit_price ;
		   uint   price ;
	}
	
	Person public Buyer = Person("Huangshi No. 2 Middle School", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Seller = Person("The Yellowstone Difficult Area Dufenghe Skills Full Line", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Aa public Arbitration = Aa("arbitration institution", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	modifier onlyBuyer(){
		require(msg.sender == Buyer.account,"Only Buyer can access this.");
		 _; 
	}
	modifier onlySeller(){
		require(msg.sender == Seller.account,"Only Seller can access this.");
		 _; 
	}
	modifier onlyArbitration(){
		require(msg.sender == Arbitration.account,"Only Arbitration can access this.");
		 _; 
	}
	token public Service = token("printer", "CANONLBP2900+", 1, 1600, 1600);
	constructor() {
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function end() internal{
		ContractState="finish";
	}
	function end2() internal{
		ContractState="terminate";
	}
	function delivery1() internal view returns (bool) {
		if (isDone("rule2")&&!isTime(functionFinishTime["rule2"]+60*60*24*5)
		) return true;
		else return false;
	}
	function delivery2() internal view returns (bool) {
		if (isDone("rule2_2")&&!isTime(functionFinishTime["rule2_2"]+60*60*24*5)
		) return true;
		else return false;
	}
	function rule2() public payable onlyState(ContractState) onlySeller unDone("rule2"){
		if(logic(block.timestamp,giveTime,"==")){
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule2_2(uint _dayNum) public payable onlyState(ContractState) onlySeller unDone("rule2_2"){
		dayNum = _dayNum;
		if(isTime(giveTime)||!isTime(giveTime+period)||!isDone("rule2")){
			transferTo(Buyer.account,10**14*dayNum*Service.price*Proportion/1000);
			functionStatus["rule2_2"] = true;
			functionFinishTime["rule2_2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2_2");
		}
	}
	function rule2_3() public payable onlyState(ContractState) onlyBuyer unDone("rule2_3"){
		if(isTime(giveTime+period)||!isDone("rule2")||!isDone("rule2_2")){
			ContractState="terminate";
			functionStatus["rule2_3"] = true;
			functionFinishTime["rule2_3"]=block.timestamp;
			emit completedRule(msg.sender,"rule2_3");
		}
	}
	function rule3(bool _checkResult) public payable onlyState(ContractState) onlyBuyer unDone("rule3"){
		checkResult = _checkResult;
		if(delivery1()||delivery2()){
			transferTo(Seller.account,10**14*Service.price);
			end();
			if(!isTrue(checkResult)){
				ContractState="terminate";
			}
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4() public payable onlyState(ContractState) onlyBuyer unDone("rule4"){
		if(delivery1()||delivery2()||!isDone("rule3")){
			transferTo(Seller.account,10**14*Service.price*Proportion/1000);
			ContractState="terminate";
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function arbitrationClause(string memory _faultName, uint _amountMoney) internal onlyArbitration unDone("arbitrationClause"){
		faultName = _faultName;
		amountMoney = _amountMoney;
			functionStatus["arbitrationClause"] = true;
			functionFinishTime["arbitrationClause"]=block.timestamp;
			emit completedRule(msg.sender,"arbitrationClause");
	}
	function buyer_fault() internal onlyBuyer unDone("buyer_fault"){
		if(isDone("arbitrationClause")||compareStrings(faultName,Buyer.name)){
			transferTo(Seller.account,10**14*amountMoney);
			end2();
			functionStatus["buyer_fault"] = true;
			functionFinishTime["buyer_fault"]=block.timestamp;
			emit completedRule(msg.sender,"buyer_fault");
		}
	}
	function seller_fault() internal onlySeller unDone("seller_fault"){
		if(isDone("arbitrationClause")||compareStrings(faultName,Seller.name)){
			transferTo(Buyer.account,10**14*amountMoney);
			end2();
			functionStatus["seller_fault"] = true;
			functionFinishTime["seller_fault"]=block.timestamp;
			emit completedRule(msg.sender,"seller_fault");
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
