pragma solidity >=0.7.0 <0.9.0;
contract simplePurchase  
{ 
	string public place = "place" ;
	uint256 public giveTime = 970704000;
	uint256 public signTime = 970358400;
	uint public price = 100 ;
	uint256 public period = 1296000 ;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
		struct token {
		   string   name ;
		   uint   number ;
		   ufixed   unit_price ;
	}
	
	Person public Buyer = Person("A", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Seller = Person("B", payable(0xAb8483F64d9C6d1EcF9b849Ae677dD3315835cb2));
	Person public Platform = Person("P", payable(0x4B20993Bc481177ec7E8f571ceCaE8A9e22C02db));
	modifier onlyBuyer(){
		require(msg.sender == Buyer.account,"Only Buyer can access this.");
		 _; 
	}
	modifier onlySeller(){
		require(msg.sender == Seller.account,"Only Seller can access this.");
		 _; 
	}
	modifier onlyPlatform(){
		require(msg.sender == Platform.account,"Only Platform can access this.");
		 _; 
	}
	token public Thing = token("thing", 1, 100);
	constructor() {
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function end() internal{
		ContractState="finish";
	}
	function rule1() public payable onlyState(ContractState) onlyBuyer unDone("rule1"){
		if(!isTime(giveTime)){
			transferTo(Platform.account,10**14*price);
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
		}
	}
	function rule2() public payable onlyState(ContractState) onlySeller unDone("rule2"){
		if(isDone("rule1")||compareTimestamps(block.timestamp,giveTime,86400,"<")){
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3() public payable onlyState(ContractState) onlyPlatform unDone("rule3"){
		if(isDone("rule2")){
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4() public payable onlyState(ContractState) onlyBuyer unDone("rule4"){
		if(!isTime(functionFinishTime["rule3"]+60*60*24*15)
		){
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function rule5() public payable onlyState(ContractState) onlyPlatform unDone("rule5"){
		if(isDone("rule4")){
			transferTo(Seller.account,10**14*price);
			end();
			functionStatus["rule5"] = true;
			functionFinishTime["rule5"]=block.timestamp;
			emit completedRule(msg.sender,"rule5");
		}
	}
	function rule6() public payable onlyState(ContractState) onlyPlatform unDone("rule6"){
		if(isDone("rule3")||isTime(functionFinishTime["rule3"]+1296000)){
			transferTo(Seller.account,10**14*price);
			end();
			functionStatus["rule6"] = true;
			functionFinishTime["rule6"]=block.timestamp;
			emit completedRule(msg.sender,"rule6");
		}
	}
	// Check if a specific function has been executed
	function isDone(string memory functionName) internal view returns (bool) {
	    return functionStatus[functionName];
	}
	// Function to determine if the specified time has been reached
	function isTime(uint256 targetTime) internal view returns (bool) {
	    return block.timestamp >= targetTime;
	}
	Function to check if the value is true.
	function isTrue(bool valueToCheck) internal pure returns (bool) {
	    return valueToCheck == true;
	}
	event Transfer(address indexed from, address indexed to, uint amount);
	// Transfer to a specified address
	function transferTo(address payable recipient, uint amount) internal {
	    require(recipient != address(0), "Invalid recipient address");
	    require(amount > 0, "Amount must be greater than zero");
	    recipient.transfer(amount);
	    emit Transfer(msg.sender,recipient, amount);
	}
	function compareTimestamps(uint256 timestamp1, uint256 timestamp2, uint256 customSeconds, string memory operator) internal returns (bool) {
	       // Calculate the difference between two timestamps (take the absolute value to ensure the difference is positive)
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
	// Custom modifier: Allow or prohibit execution based on string parameter value
	modifier onlyState(string memory State) {
	    require(compareStrings(State, "start") || compareStrings(State, "restart"), "Not allowed in this state");
	     emit ContractStateChange(State);
	    _;
	}
	// Helper function to compare if two strings are equal
	function compareStrings(string memory a, string memory b) internal pure returns (bool) {
	    return (keccak256(abi.encodePacked(a)) == keccak256(abi.encodePacked(b)));
	}
}
