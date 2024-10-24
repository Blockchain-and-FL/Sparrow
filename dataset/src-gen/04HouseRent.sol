pragma solidity >=0.7.0 <0.9.0;
import "./DateTime.sol"; 
contract HouseRent  
{ 
	DateTime public datetime=DateTime(0xd9145CCE52D386f254917e481eB44e9943F39138);
	uint penalty = 3000 ;
	uint management_fee = 4000 ;
	uint256 payduration = 31536000 ;
	uint256 startTime = datetime.toTimestamp(2020,10,16,0,0);
	uint256 finishTime = datetime.toTimestamp(2023,10,15,0,0);
	uint256 payTime = datetime.toTimestamp(2020,10,16,0,0);
	uint time1 = 7776000 ;
	uint time2 = 1296000 ;
	bool continue = false ;
	uint amount = 0 ;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
		struct House {
		   string   location ;
		   string   usage ;
	}
	
	Person public Landlord = Person("Fengshan Town Vegetable Village Joint Stock Economic Cooperative", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Tenant = Person("Luotian County Statistics Bureau", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	modifier onlyLandlord(){
		require(msg.sender == Landlord.account,"Only Landlord can access this.");
		 _; 
	}
	modifier onlyTenant(){
		require(msg.sender == Tenant.account,"Only Tenant can access this.");
		 _; 
	}
	House public house = House("Lijiawan", "office");
	constructor() {
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function rule1() public payable onlyState(ContractState) onlyTenant unDone("rule1"){
		if(!isTime(startTime)){
			transferTo(Landlord.account,management_fee);
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
		}
	}
	function rule2() public payable onlyState(ContractState) onlyTenant unDone("rule2"){
		if(isDone("rule1")||!isTime(payTime+payduration)){
			transferTo(Landlord.account,management_fee);
			payTime=block.timestamp;
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3(bool _continue) public payable onlyState(ContractState) onlyTenant unDone("rule3"){
		continue = _continue;
		if(!isTime(finishTime)){
			if(isTrue(continue)){
				transferTo(Landlord.account,management_fee);
				finishTime=finishTime+payduration;
			}
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4(uint _amount) public payable onlyState(ContractState) onlyLandlord unDone("rule4"){
		amount = _amount;
		if(isTime(finishTime)||!isTime(finishTime+time2)){
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function rule5() public payable onlyState(ContractState) onlyTenant unDone("rule5"){
		if(isDone("rule4")){
			transferTo(Landlord.account,amount);
			ContractState="finish";
			functionStatus["rule5"] = true;
			functionFinishTime["rule5"]=block.timestamp;
			emit completedRule(msg.sender,"rule5");
		}
	}
	function rule6() public payable onlyState(ContractState) onlyLandlord unDone("rule6"){
		if(isDone("rule1")||isTime(payTime+payduration+time1)){
			ContractState="terminate";
			functionStatus["rule6"] = true;
			functionFinishTime["rule6"]=block.timestamp;
			emit completedRule(msg.sender,"rule6");
		}
	}
	function rule7() public payable onlyState(ContractState) onlyLandlord unDone("rule7"){
		if(!isTime(finishTime)){
			transferTo(Tenant.account,penalty);
			ContractState="terminate";
			functionStatus["rule7"] = true;
			functionFinishTime["rule7"]=block.timestamp;
			emit completedRule(msg.sender,"rule7");
		}
	}
	function rule8() public payable onlyState(ContractState) onlyTenant unDone("rule8"){
		if(!isTime(finishTime)){
			transferTo(Landlord.account,penalty);
			ContractState="terminate";
			functionStatus["rule8"] = true;
			functionFinishTime["rule8"]=block.timestamp;
			emit completedRule(msg.sender,"rule8");
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
	event Transfer(address indexed from, address indexed to, uint256 amount);
	// Transfer to a specified address
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
