pragma solidity >=0.7.0 <0.9.0;
import "./DateTime.sol"; 
contract PrinterPurchase  
{ 
	DateTime public datetime=DateTime(0xd9145CCE52D386f254917e481eB44e9943F39138);
	string place = "Huangshi No. 2 Middle School" ;
	uint256 giveTime = datetime.toTimestamp(2022,12,16,0,0);
	string faultName = "" ;
	ufixed amount = 0 ;
	bool checkResult = false ;
	uint256 period = 2592000 ;
	uint dayNum = 0 ;
	ufixed Proportion = 0.05 ;
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
		   string   name ;
		   string   ID ;
		   uint   number ;
		   ufixed   unit_price ;
		   uint   price ;
	}
	
	Person public Buyer = Person("Huangshi No. 2 Middle School", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Seller = Person("The Yellowstone Difficult Area Dufenghe Skills Full Line", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
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
	token public Service = token("printer", "CANONLBP2900+", 1, 1600, 1600);
	constructor() {
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function end() internal{
		ContractState="finish";
	}
	function end2() internal{
		ContractState="terminate";
	}
	function delivery1() internal view returns (bool) {
		if (isDone("rule2")&&!isTime(functionFinishTime["rule2"]+60*60*24*5)
		) return true;
		else return false;
	}
	function delivery2() internal view returns (bool) {
		if (isDone("rule2_2")&&!isTime(functionFinishTime["rule2_2"]+60*60*24*5)
		) return true;
		else return false;
	}
	function rule2() public payable onlyState(ContractState) onlySeller unDone("rule2"){
		if(logic(block.timestamp,giveTime,"==")){
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule2_2(uint _dayNum) public payable onlyState(ContractState) onlySeller unDone("rule2_2"){
		dayNum = _dayNum;
		if(isTime(giveTime)||!isTime(giveTime+period)||!isDone("rule2")){
			transferTo(Buyer.account,dayNum*Proportion*Service.price);
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
			transferTo(Seller.account,Service.price);
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
			transferTo(Seller.account,Service.price*Proportion);
			ContractState="terminate";
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function arbitrationClause(string _faultName, ufixed _amount) public payable onlyState(ContractState) onlyArbitration unDone("arbitrationClause"){
		faultName = _faultName;
		amount = _amount;
			functionStatus["arbitrationClause"] = true;
			functionFinishTime["arbitrationClause"]=block.timestamp;
			emit completedRule(msg.sender,"arbitrationClause");
	}
	function buyer_fault() public payable onlyState(ContractState) onlyBuyer unDone("buyer_fault"){
		if(isDone("arbitrationClause")||logic(faultName,Buyer.name,"==")){
			transferTo(Seller.account,amount);
			end2();
			functionStatus["buyer_fault"] = true;
			functionFinishTime["buyer_fault"]=block.timestamp;
			emit completedRule(msg.sender,"buyer_fault");
		}
	}
	function seller_fault() public payable onlyState(ContractState) onlySeller unDone("seller_fault"){
		if(isDone("arbitrationClause")||logic(faultName,Seller.name,"==")){
			transferTo(Buyer.account,amount);
			end2();
			functionStatus["seller_fault"] = true;
			functionFinishTime["seller_fault"]=block.timestamp;
			emit completedRule(msg.sender,"seller_fault");
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
