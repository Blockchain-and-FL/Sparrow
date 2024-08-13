pragma solidity >=0.7.0 <0.9.0;
contract ordinaryPurchase  
{ 
	string public place = "place" ;
	uint256 public giveTime = 970704000;
	uint256 public signTime = 970358400;
	uint public price = 100 ;
	uint256 public late_deliveryIR = 50.0 ;
	uint256 public terminatedIR = 200.0 ;
	uint public late_days = 0 ;
	uint256 public late = 432000 ;
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
		   string   ownership ;
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
	token public Thing = token("thing", 1, 100, "A");
	constructor() {
	// 初始化群组
	}
	event completedRule(address indexed person, string rulename);
	function end() internal{
		ContractState="finish";
	}
	function end2() internal{
		ContractState="terminate";
	}
	function terminate_pay() internal{
		transferTo(Buyer.account,10**14*price*terminatedIR/1000);
	}
	function transfer_own() internal{
		Thing.ownership="Buyer.name";
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
		if(isDone("rule2")||isDone("rule7")){
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4() public payable onlyState(ContractState) onlyBuyer unDone("rule4"){
		if(!isTime(functionFinishTime["rule3"]+60*60*24*15)
		){
			transfer_own();
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
			transfer_own();
			end();
			functionStatus["rule6"] = true;
			functionFinishTime["rule6"]=block.timestamp;
			emit completedRule(msg.sender,"rule6");
		}
	}
	function rule7(uint _late_days) public payable onlyState(ContractState) onlySeller unDone("rule7"){
		late_days = _late_days;
		if(compareTimestamps(block.timestamp,giveTime,432000,"<")){
			transferTo(Buyer.account,10**14*late_days*price*late_deliveryIR/1000);
			functionStatus["rule7"] = true;
			functionFinishTime["rule7"]=block.timestamp;
			emit completedRule(msg.sender,"rule7");
		}
	}
	function rule8() public payable onlyState(ContractState) onlySeller unDone("rule8"){
		if(compareTimestamps(block.timestamp,giveTime,432000,">")||!isDone("rule7")){
			terminate_pay();
			end2();
			functionStatus["rule8"] = true;
			functionFinishTime["rule8"]=block.timestamp;
			emit completedRule(msg.sender,"rule8");
		}
	}
	function rule9() public payable onlyState(ContractState) onlyPlatform unDone("rule9"){
		if(isDone("rule8")){
			transferTo(Buyer.account,10**14*price);
			functionStatus["rule9"] = true;
			functionFinishTime["rule9"]=block.timestamp;
			emit completedRule(msg.sender,"rule9");
		}
	}
	function rule10() public payable onlyState(ContractState) onlyBuyer unDone("rule10"){
			terminate_pay();
			functionStatus["rule10"] = true;
			functionFinishTime["rule10"]=block.timestamp;
			emit completedRule(msg.sender,"rule10");
	}
	function rule11() public payable onlyState(ContractState) onlySeller unDone("rule11"){
			terminate_pay();
			functionStatus["rule11"] = true;
			functionFinishTime["rule11"]=block.timestamp;
			emit completedRule(msg.sender,"rule11");
	}
	function rule12() public payable onlyState(ContractState) onlyPlatform unDone("rule12"){
		if(isDone("rule10")||isDone("rule11")){
			transferTo(Buyer.account,10**14*price);
			end2();
			functionStatus["rule12"] = true;
			functionFinishTime["rule12"]=block.timestamp;
			emit completedRule(msg.sender,"rule12");
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
	function compareTimestamps(uint256 timestamp1, uint256 timestamp2, uint256 customSeconds, string memory operator) internal returns (bool) {
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
