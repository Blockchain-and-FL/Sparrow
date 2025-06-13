pragma solidity >=0.7.0 <0.9.0;
contract ElectricVehiclePurchase  
{ 
	string public faultName = "" ;
	uint256 public signTime = 1441065600;
	string public signPlace = "ShenZhen" ;
	uint public shippingFee = 0 ;
	uint public defaultMoney = 1000 ;
	bool public checkResult = false ;
	uint256 public period = 864000 ;
	uint256 public warranty = 31536000 ;
	uint256 public Proportion = 500.0 ;
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
		   string   model ;
		   string   name ;
		   string   color ;
		   string   seat ;
		   uint   Voltage ;
		   string   power ;
		   uint   quantity ;
		   uint   price ;
		   uint   sum ;
		   string   Remark ;
	}
	
	Person public Buyer = Person("ChongQing Olympic Sports Center", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Seller = Person("ShenZhen AoHu Electric Vehicle Co., Ltd.", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
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
	token public Service = token("AH-Y14B", "14ElectricVehicle", "white", "regular", 72, "7.5", 1, 49800, 49800, "Shipping fee not included");
	constructor() {
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function rule1() public payable onlyState(ContractState) onlyBuyer unDone("rule1"){
			transferTo(Seller.account,10**14*Service.sum*Proportion/1000);
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
	}
	function rule2(uint _shippingFee) public payable onlyState(ContractState) onlySeller unDone("rule2"){
		shippingFee = _shippingFee;
		if(isDone("rule1")||!isTime(signTime+period)){
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3(bool _checkResult) public payable onlyState(ContractState) onlyBuyer {
		checkResult = _checkResult;
		if(isDone("rule2")||isTime(signTime+period)){
			if(isTrue(checkResult)){
				transferTo(Seller.account,10**14*Service.sum*Proportion/1000+shippingFee);
				ContractState="finish";
			}
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4() public payable onlyState(ContractState) onlyBuyer {
		if(isDone("rule3")||!isTime(signTime+warranty)){
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function rule5(uint _daynum) public payable onlyState(ContractState) onlySeller unDone("rule5"){
		uint daynum = _daynum;	
		if(!isDone("rule3")||isTime(signTime+2*period)){
			transferTo(Buyer.account,10**14*defaultMoney*daynum);
			ContractState="terminate";
			functionStatus["rule5"] = true;
			functionFinishTime["rule5"]=block.timestamp;
			emit completedRule(msg.sender,"rule5");
		}
	}
	function rule6(uint _daynum) public payable onlyState(ContractState) onlyBuyer unDone("rule6"){
		uint daynum = _daynum;	
		if(!isDone("rule2")||isTime(signTime+2*period)){
			transferTo(Seller.account,10**14*defaultMoney*daynum);
			ContractState="terminate";
			functionStatus["rule6"] = true;
			functionFinishTime["rule6"]=block.timestamp;
			emit completedRule(msg.sender,"rule6");
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
