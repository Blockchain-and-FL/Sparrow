pragma solidity >=0.7.0 <0.9.0;
import "./DateTime.sol"; 
contract DaliyPurchase  
{ 
	DateTime public datetime=DateTime(0xd9145CCE52D386f254917e481eB44e9943F39138);
	string place = "" ;
	uint256 giveTime = datetime.toTimestamp(0);
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
		struct token {
		   string   name ;
		   string   ID ;
		   uint   number ;
		   ufixed   unit_price ;
		   uint   price ;
	}
	
	Person public Buyer = Person("Wuhan Caidian District Justice Bureau", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Seller = Person("Shengxing Hardware Store, Caidian District, Wuhan City", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	modifier onlyBuyer(){
		require(msg.sender == Buyer.account,"Only Buyer can access this.");
		 _; 
	}
	modifier onlySeller(){
		require(msg.sender == Seller.account,"Only Seller can access this.");
		 _; 
	}
	token public Service = token("Daliy", "many", 1, 4801, 4801);
	constructor() {
	// 初始化群组
	}
	event completedRule(address indexed person, string rulename);
	function rule1(string _place, uint _giveTime) public payable onlyState(ContractState) onlyBuyer unDone("rule1"){
		place = _place;
		giveTime = _giveTime;
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
	}
	function rule2() public payable onlyState(ContractState) onlySeller unDone("rule2"){
		if(logic(block.timestamp,giveTime,"==")){
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3() public payable onlyState(ContractState) onlyBuyer unDone("rule3"){
		if(isDone("rule2")){
			transferTo(Seller.account,Service.price);
			ContractState="finish";
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	// 检查某个功能是否已经执行
	function isDone(string memory functionName) internal view returns (bool) {
	    return functionStatus[functionName];
	}
	event Transfer(address indexed from, address indexed to, uint256 amount);
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
