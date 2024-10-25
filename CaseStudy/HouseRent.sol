// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract HouseRent  
{ 
	uint public deposit = 6000 ;
	uint public rent = 6000 ;
	uint256 public pd = 2592000 ;
	uint256 public mddt = 604800 ;
	uint256 public mpdt = 2592000 ;
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
		payTime=payTime+pd;
	}
	function completeDelivery() internal view returns (bool) {
		if (isDone("rule3")) return true;
		else return false;
	}
	function rule1() public payable onlyState(ContractState) onlyTenant unDone("rule1"){
		if(!isTime(startTime)){
			transferTo(Landlord.account,10**14*(deposit+rent));
			changeRule("rule1");
		}
	}
	function rule2() public payable onlyState(ContractState) onlyLandlord unDone("rule2"){
		if(isTime(startTime)&&!isDone("rule1")){
			ContractState="terminate";
			changeRule("rule2");
		}
	}
	function rule3() public payable onlyState(ContractState) onlyLandlord unDone("rule3"){
		if(!isTime(startTime)&&isDone("rule1")){
			house.useRight=Tenant.name;
			changeRule("rule3");
		}
	}
	function rule4() public payable onlyState(ContractState) onlyLandlord unDone("rule4"){
		if(isTime(startTime)&&!isDone("rule3")&&!isTime(startTime+time1)){
			house.useRight=Tenant.name;
			transferTo(Tenant.account,10**14*(rent));
			changeRule("rule4");
		}
	}
	function rule5() public payable onlyState(ContractState) onlyLandlord unDone("rule5"){
		if(!isDone("rule3")&&isTime(startTime+mddt)){
			transferTo(Tenant.account,10**14*(deposit+rent));
			ContractState="terminate";
			changeRule("rule5");
		}
	}
	function rule6() public payable onlyState(ContractState) onlyTenant {
		if(completeDelivery()&&isTime(payTime+mpdt)&&!isTime(payTime+mpdt+86400)){
			payRegular();
			changeRule("rule6");
		}
	}
	function rule7() public payable onlyState(ContractState) onlyTenant unDone("rule7"){
		if(completeDelivery()&&!isDone("rule6")&&isTime(payTime+pd+86400)&&!isTime(payTime+pd+mpdt)){
			transferTo(Landlord.account,10**14*(2*rent));
			payTime=payTime+pd;
			changeRule("rule7");
		}
	}
	function rule8() public payable onlyState(ContractState) onlyLandlord unDone("rule8"){
		if(completeDelivery()&&!isDone("rule6")&&!isDone("rule7")&&isTime(payTime+pd+mpdt)){
			ContractState="terminate";
			changeRule("rule8");
		}
	}
	function rule9(bool _checkresult) public payable onlyState(ContractState) onlyLandlord unDone("rule9"){
		bool checkresult = _checkresult;	
		if(isTime(finishTime)){
			ContractState="terminate";
			house.useRight="Landlord.name";
			if(checkresult){
				transferTo(Tenant.account,10**14*(deposit));
				ContractState="finish";
			}
			changeRule("rule9");
		}
	}
	function rule10(string memory _aaresult) public payable onlyaa unDone("rule10"){
		aaresult = _aaresult;
			changeRule("rule10");
	}
	function rule11() public payable onlyLandlord unDone("rule11"){
		if(isDone("rule10")&&compareStrings(aaresult,Landlord.name)){
			transferTo(Tenant.account,10**14*(penalty));
			ContractState="terminate";
			changeRule("rule11");
		}
	}
	function rule12() public payable onlyTenant unDone("rule12"){
		if(isDone("rule10")&&compareStrings(aaresult,Tenant.name)){
			transferTo(Landlord.account,10**14*(penalty));
			ContractState="terminate";
			changeRule("rule12");
		}
	}
	function rule13() public payable onlyra unDone("rule13"){
			ContractState="pause";
			changeRule("rule13");
	}
	function rule14() public payable onlyra unDone("rule14"){
			ContractState="restart";
			changeRule("rule14");
	}
	function rule15() public payable onlyra unDone("rule15"){
			ContractState="terminate";
			changeRule("rule15");
	}
	// Check if a specific function has been executed
	function isDone(string memory functionName) internal view returns (bool) {
	    return functionStatus[functionName];
	}
	// Function to determine if the specified time has been reached
	function isTime(uint256 targetTime) internal view returns (bool) {
	    return block.timestamp >= targetTime;
	}
	event Transfer(address indexed from, address indexed to, uint amount);
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
	
	// Each clause calls a fixed function, changes the clause state after execution, and records events and time
	function changeRule(string memory ruleName) internal {
		functionStatus[ruleName] = true;
		functionFinishTime[ruleName]=block.timestamp;
		emit completedRule(msg.sender,ruleName);
}
}
