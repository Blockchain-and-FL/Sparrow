pragma solidity >=0.7.0 <0.9.0;
contract ordinaryRent  
{ 
	uint256 public startTime = 970747200;
	uint256 public finishTime = 973425600;
	uint256 public payTime = 970747200;
	uint256 public period = 864000 ;
	uint256 public max_late = 432000 ;
	uint public late_days = 0 ;
	uint256 public breakIR = 200.0 ;
	uint public rent = 1000 ;
	uint public despoit = 500 ;
	uint public continueRent = 200 ;
	bool public continue = false ;
	uint public continueDays = 0 ;
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
		   uint   day ;
		   string   ownership ;
		   string   useRight ;
	}
	
	Person public lessor = Person("A", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public lessee = Person("B", payable(0xAb8483F64d9C6d1EcF9b849Ae677dD3315835cb2));
	modifier onlylessor(){
		require(msg.sender == lessor.account,"Only lessor can access this.");
		 _; 
	}
	modifier onlylessee(){
		require(msg.sender == lessee.account,"Only lessee can access this.");
		 _; 
	}
	token public thing = token("thing", 100, 30, "A", "A");
	constructor() {
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function giveUse() internal{
		thing.useRight=lessee.name;
	}
	function getUse() internal{
		thing.useRight=lessor.name;
	}
	function end() internal{
		ContractState="finish";
	}
	function end2() internal{
		ContractState="terminate";
	}
	function give() internal view returns (bool) {
		if (isDone("rule2")||isDone("rule3")) return true;
		else return false;
	}
	function rule1() public payable onlyState(ContractState) onlylessee unDone("rule1"){
		if(!isTime(startTime)){
			transferTo(lessor.account,10**14*rent+despoit);
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
		}
	}
	function rule2() public payable onlyState(ContractState) onlylessor unDone("rule2"){
		if(isDone("rule1")||!isTime(startTime)){
			giveUse();
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3(uint _late_days) public payable onlyState(ContractState) onlylessor unDone("rule3"){
		late_days = _late_days;
		if(!isTime(startTime+max_late)||!isDone("rule2")){
			transferTo(lessee.account,10**14*rent*5*breakIR/1000);
			giveUse();
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4() public payable onlyState(ContractState) onlylessor unDone("rule4"){
		if(isTime(startTime+max_late)||!isDone("rule3")||!isDone("rule2")){
			transferTo(lessee.account,10**14*rent*5*breakIR/1000+rent+despoit);
			end2();
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function rule5() public payable onlyState(ContractState) onlylessee {
		if(give()||isTime(payTime+period)||!isTime(payTime+period+86400)||!isTime(finishTime)){
			transferTo(lessor.account,10**14*rent);
			payTime=payTime+period;
			functionStatus["rule7"]=true;
			functionStatus["rule5"] = true;
			functionFinishTime["rule5"]=block.timestamp;
			emit completedRule(msg.sender,"rule5");
		}
	}
	function rule6(uint _late_days) public payable onlyState(ContractState) onlylessee {
		late_days = _late_days;
		if(isTime(payTime+period+86400)||!isTime(payTime+period+432000)){
			transferTo(lessor.account,10**14*rent*late_days*breakIR/1000);
			payTime=payTime+period;
			functionStatus["rule7"]=true;
			functionStatus["rule6"] = true;
			functionFinishTime["rule6"]=block.timestamp;
			emit completedRule(msg.sender,"rule6");
		}
	}
	function rule7(uint _late_days) public payable onlyState(ContractState) onlylessor unDone("rule7"){
		late_days = _late_days;
		if(isTime(payTime+period+432000)){
			getUse();
			end2();
			functionStatus["rule7"] = true;
			functionFinishTime["rule7"]=block.timestamp;
			emit completedRule(msg.sender,"rule7");
		}
	}
	function rule8(uint _continueDays) public payable onlyState(ContractState) onlylessee {
		continueDays = _continueDays;
		if(!isTime(finishTime)){
			transferTo(lessor.account,10**14*rent*continueDays);
			functionStatus["rule8"] = true;
			functionFinishTime["rule8"]=block.timestamp;
			emit completedRule(msg.sender,"rule8");
		}
	}
	function rule9(bool _continue) public payable onlyState(ContractState) onlylessor {
		continue = _continue;
		if(isDone("rule8")){
			if(isTrue(continue)){
				finishTime=finishTime+continueDays*60*60*24;
			}
			if(!isTrue(continue)){
				transferTo(lessee.account,10**14*rent*continueDays);
			}
			functionStatus["rule9"] = true;
			functionFinishTime["rule9"]=block.timestamp;
			emit completedRule(msg.sender,"rule9");
		}
	}
	function rule5() public payable onlyState(ContractState) onlylessor unDone("rule5"){
		if(isTime(finishTime)){
			getUse();
			transferTo(lessee.account,10**14*deposit);
			end();
			functionStatus["rule5"] = true;
			functionFinishTime["rule5"]=block.timestamp;
			emit completedRule(msg.sender,"rule5");
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
