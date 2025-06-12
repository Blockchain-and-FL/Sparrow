pragma solidity >=0.7.0 <0.9.0;
contract HouseRent  
{ 
	uint public penalty = 3000 ;
	uint public management_fee = 4000 ;
	uint256 public payduration = 31536000 ;
	uint256 public startTime = 1602806400;
	uint256 public finishTime = 1697328000;
	uint256 public payTime = 1602806400;
	uint public time1 = 7776000 ;
	uint public time2 = 1296000 ;
	bool public go_on = false ;
	uint public amountMoney = 0 ;
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
	// 初始化群组
	}
	event completedRule(address indexed person, string rulename);
	function rule1() public payable onlyState(ContractState) onlyTenant unDone("rule1"){
		if(!isTime(startTime)){
			transferTo(Landlord.account,10**14*management_fee);
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
		}
	}
	function rule2() public payable onlyState(ContractState) onlyTenant {
		if(isDone("rule1")||!isTime(payTime+payduration)){
			transferTo(Landlord.account,10**14*management_fee);
			payTime=block.timestamp;
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3(bool _go_on) public payable onlyState(ContractState) onlyTenant unDone("rule3"){
		go_on = _go_on;
		if(!isTime(finishTime)){
			if(isTrue(go_on)){
				transferTo(Landlord.account,10**14*management_fee);
				finishTime=finishTime+payduration;
			}
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4(uint _amountMoney) public payable onlyState(ContractState) onlyLandlord unDone("rule4"){
		amountMoney = _amountMoney;
		if(isTime(finishTime)||!isTime(finishTime+time2)){
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function rule5() public payable onlyState(ContractState) onlyTenant unDone("rule5"){
		if(isDone("rule4")){
			transferTo(Landlord.account,10**14*amountMoney);
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
			transferTo(Tenant.account,10**14*penalty);
			ContractState="terminate";
			functionStatus["rule7"] = true;
			functionFinishTime["rule7"]=block.timestamp;
			emit completedRule(msg.sender,"rule7");
		}
	}
	function rule8() public payable onlyState(ContractState) onlyTenant unDone("rule8"){
		if(!isTime(finishTime)){
			transferTo(Landlord.account,10**14*penalty);
			ContractState="terminate";
			functionStatus["rule8"] = true;
			functionFinishTime["rule8"]=block.timestamp;
			emit completedRule(msg.sender,"rule8");
		}
	}
	// 检查某个功能是否已经执行
	function isDone(string memory functionName) internal view returns (bool) {
	    return functionStatus[functionName];
	}
	// 用于判断是否达到指定时间的函数
	function isTime(uint256 targetTime) internal view returns (bool) {
	    return block.timestamp >= targetTime;
	}
	// 带参数的函数，用于检查值是否为 true
	function isTrue(bool valueToCheck) internal pure returns (bool) {
	    return valueToCheck == true;
	}
	event Transfer(address indexed from, address indexed to, uint amount);
	// 用于给指定地址转账
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
