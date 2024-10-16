pragma solidity >=0.7.0 <0.9.0;
contract simpleRent  
{ 
	uint256 public startTime = 970747200;
	uint256 public finishTime = 973425600;
	uint256 public payTime = 970747200;
	uint256 public period = 864000 ;
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
	token public House = token("thing", 100, 30);
	constructor() {
	// 初始化群组
	}
	event completedRule(address indexed person, string rulename);
	function rule1() public payable onlyState(ContractState) onlylessee unDone("rule1"){
		if(!isTime(startTime)){
			transferTo(lessor.account,10**14*rent+despoit);
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
		}
	}
	function rule2() public payable onlyState(ContractState) onlylessee {
		if(isDone("rule1")||isTime(payTime+period)||!isTime(payTime+period+86400)||!isTime(finishTime)){
			transferTo(lessor.account,10**14*rent);
			payTime=payTime+period;
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3(uint _continueDays) public payable onlyState(ContractState) onlylessee {
		continueDays = _continueDays;
		if(!isTime(finishTime)){
			transferTo(lessor.account,10**14*rent*continueDays);
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4(bool _continue) public payable onlyState(ContractState) onlylessor {
		continue = _continue;
		if(isDone("rule3")){
			if(isTrue(continue)){
				finishTime=finishTime+continueDays*60*60*24;
			}
			if(!isTrue(continue)){
				transferTo(lessee.account,10**14*rent*continueDays);
			}
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function rule5() public payable onlyState(ContractState) onlylessor unDone("rule5"){
		if(isTime(finishTime)){
			transferTo(lessee.account,10**14*deposit);
			ContractState="finish";
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
