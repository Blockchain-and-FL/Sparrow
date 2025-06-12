pragma solidity >=0.7.0 <0.9.0;
contract ComputerPurchase  
{ 
	string public place = "" ;
	uint256 public giveTime = 1676937600;
	string public faultName = "" ;
	uint public amountMoney = 0 ;
	bool public checkResult = false ;
	uint256 public period = 2592000 ;
	uint public dayNum = 0 ;
	uint256 public Proportion = 1.0 ;
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
	
	Person public Buyer = Person("Boyue Kindergarten, Jianghan District, Wuhan City", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Seller = Person("Wuhan Dizhihou Trading Co., Ltd.", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
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
	token public Service = token("computer", "M43Y", 1, 4950, 4950);
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
	function delivery1() internal view returns (bool) {
		if (isDone("rule2")&&!isTime(functionFinishTime["rule2"]+60*60*24*3)
		) return true;
		else return false;
	}
	function delivery2() internal view returns (bool) {
		if (isDone("rule2_2")&&!isTime(functionFinishTime["rule2_2"]+60*60*24*3)
		) return true;
		else return false;
	}
	function rule1(string memory _place) public payable onlyState(ContractState) onlyBuyer unDone("rule1"){
		place = _place;
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
	}
	function rule2() public payable onlyState(ContractState) onlySeller unDone("rule2"){
		if(isDone("rule1")||logic(block.timestamp,giveTime,"==")){
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
	// 辅助函数，根据比较符号执行比较
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
	
	
	    // 只有当满足条件 valueA > valueB 时，才能执行 setValue 函数
	    function logic(uint256 valueA, uint256 valueB, string memory symbol) internal pure returns (bool) {
	        return compare(valueA, valueB, symbol);
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
