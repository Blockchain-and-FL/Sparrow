pragma solidity >=0.7.0 <0.9.0;
import "./DateTime.sol"; 
contract ElectricVehiclePurchase  
{ 
	DateTime public datetime=DateTime(0xd9145CCE52D386f254917e481eB44e9943F39138);
	string faultName = "" ;
	uint256 signTime = datetime.toTimestamp(2015,9,1,0,0);
	string signPlace = "ShenZhen" ;
	ufixed shippingFee = 0 ;
	ufixed default = 1000 ;
	bool checkResult = false ;
	uint256 period = 864000 ;
	uint256 warranty = 31536000 ;
	ufixed Proportion = 0.5 ;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
	struct Ca {
		string name;
		address payable account;
		uint256 key;
		uint256 year;
	}
		struct token {
		   string   model ;
		   string   name ;
		   string   color ;
		   string   seat ;
		   uint   Voltage ;
		   ufixed   power ;
		   uint   quantity ;
		   uint   price ;
		   uint   sum ;
		   string   Remark ;
	}
	
	Person public Buyer = Person("ChongQing Olympic Sports Center", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Seller = Person("ShenZhen AoHu Electric Vehicle Co., Ltd.", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Ca public Arbitration = Ca("arbitration institution", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
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
	token public Service = token("AH-Y14B", "14ElectricVehicle", "white", "regular", 72, 7.5, 1, 49800, 49800, "Shipping fee not included");
	constructor() {
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function rule1() public payable onlyState(ContractState) onlyBuyer unDone("rule1"){
			transferTo(Seller.account,Service.sum*Proportion);
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
	}
	function rule2(ufixed _shippingFee) public payable onlyState(ContractState) onlySeller unDone("rule2"){
		shippingFee = _shippingFee;
		if(isDone("rule1")||!isTime(signTime+period)){
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3(bool _checkResult) public payable onlyState(ContractState) onlyBuyer unDone("rule3"){
		checkResult = _checkResult;
		if(isDone("rule2")||isTime(signTime+period)){
			if(isTrue(checkResult)){
				transferTo(Seller.account,Service.sum*Proportion+shippingFee);
				ContractState="finish";
			}
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4() public payable onlyState(ContractState) onlyBuyer unDone("rule4"){
		if(isDone("rule3")||!isTime(signTime+warranty)){
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function rule5(uint _daynum) public payable onlyState(ContractState) onlySeller unDone("rule5"){
		uint daynum = _daynum;	
		if(!isDone("rule3")||isTime(signTime+2*period)){
			transferTo(Buyer.account,default*daynum);
			ContractState="terminate";
			functionStatus["rule5"] = true;
			functionFinishTime["rule5"]=block.timestamp;
			emit completedRule(msg.sender,"rule5");
		}
	}
	function rule6(uint _daynum) public payable onlyState(ContractState) onlyBuyer unDone("rule6"){
		uint daynum = _daynum;	
		if(!isDone("rule2")||isTime(signTime+2*period)){
			transferTo(Seller.account,default*daynum);
			ContractState="terminate";
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
