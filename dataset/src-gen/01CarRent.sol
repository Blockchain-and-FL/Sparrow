pragma solidity >=0.7.0 <0.9.0;
import "./DateTime.sol"; 
contract CarRent  
{ 
	DateTime public datetime=DateTime(0xd9145CCE52D386f254917e481eB44e9943F39138);
	ufixed default11 = 0.02 ;
	ufixed default12 = 0.05 ;
	ufixed default2 = 0.05 ;
	uint dayNum = 0 ;
	string faultName = "" ;
	ufixed amount = 0 ;
	uint256 signTime = datetime.toTimestamp(2022,11,9,0,0);
	string signPlaca = "XiAn" ;
	uint256 startTime = datetime.toTimestamp(2023,7,10,0,0);
	uint256 finishTime = datetime.toTimestamp(2023,7,31,0,0);
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
		   uint   number ;
		   uint   unit_price ;
		   uint   price ;
	}
	
	Person public Buyer = Person("ShanXi Provincial Department of Housing and Urban-Rural Development Agency Supplier", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public Seller = Person("XiAn YingBin Auto Car Service", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
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
	token public Service = token("vehicle rental service", 3, 11600, 34800);
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
	function time1() internal view returns (bool) {
		if (!isTime(functionFinishTime["checkThing"]+60*60*24*10)
		) return true;
		else return false;
	}
	function time2() internal view returns (bool) {
		if (!isTime(functionFinishTime["checkThing"]+60*60*24*7)
		) return true;
		else return false;
	}
	function trueCheck() internal view returns (bool) {
		if (isDone("checkThing")&&isTrue(checkResult)) return true;
		else return false;
	}
	function totalCheck() internal view returns (bool) {
		if (trueCheck()&&time1()||time1()) return true;
		else return false;
	}
	function logic1() internal view returns (bool) {
		if (logic(price*dayNum*default11,price*default12,">")) return true;
		else return false;
	}
	function delivery() public payable onlyState(ContractState) onlySeller unDone("delivery"){
		if(isTime(startTime)||!isTime(finishTime)){
			functionStatus["delivery"] = true;
			functionFinishTime["delivery"]=block.timestamp;
			emit completedRule(msg.sender,"delivery");
		}
	}
	function checkThing(bool _checkResult) public payable onlyState(ContractState) onlyBuyer unDone("checkThing"){
		bool checkResult = _checkResult;	
		if(isDone("delivery")){
			functionStatus["checkThing"] = true;
			functionFinishTime["checkThing"]=block.timestamp;
			emit completedRule(msg.sender,"checkThing");
		}
	}
	function check_good() public payable onlyState(ContractState) onlyBuyer unDone("check_good"){
		if(totalCheck()||isDone("postpone_Buyer")){
			transferTo(Seller.account,Service.price);
			end();
			functionStatus["check_good"] = true;
			functionFinishTime["check_good"]=block.timestamp;
			emit completedRule(msg.sender,"check_good");
		}
	}
	function check_false() public payable onlyState(ContractState) onlyBuyer unDone("check_false"){
		if(isDone("checkThing")||!isTrue(checkResult)||time2()){
			functionStatus["check_false"] = true;
			functionFinishTime["check_false"]=block.timestamp;
			emit completedRule(msg.sender,"check_false");
		}
	}
	function return() public payable onlyState(ContractState) onlyBuyer unDone("return"){
		if(isDone("check_false")||!isTime(functionFinishTime["check_false"]+60*60*24*3)
		){
			functionStatus["delivery"]="false";
			functionStatus["check_good"]="false";
			functionStatus["return"] = true;
			functionFinishTime["return"]=block.timestamp;
			emit completedRule(msg.sender,"return");
		}
	}
	function postpone_Seller(uint _dayNum) public payable onlyState(ContractState) onlyBuyer unDone("postpone_Seller"){
		dayNum = _dayNum;
		if(isTime(finishTime)||!isDone("delivery")){
			functionStatus["delivery"]="true";
			if(logic1()){
				price=price-price*dayNum*default12;
			}
			if(!logic1()){
				price=price-price*dayNum*default11;
			}
			functionStatus["postpone_Seller"] = true;
			functionFinishTime["postpone_Seller"]=block.timestamp;
			emit completedRule(msg.sender,"postpone_Seller");
		}
	}
	function postpone_Buyer(uint _dayNum) public payable onlyState(ContractState) onlySeller unDone("postpone_Buyer"){
		dayNum = _dayNum;
		if(trueCheck()||!time1()||!isDone("check_good")){
			if(logic1()){
				price=price+price*dayNum*default12;
			}
			if(!logic1()){
				price=price+price*dayNum*default11;
			}
			functionStatus["postpone_Buyer"] = true;
			functionFinishTime["postpone_Buyer"]=block.timestamp;
			emit completedRule(msg.sender,"postpone_Buyer");
		}
	}
	function terminate_Seller() public payable onlyState(ContractState) onlySeller unDone("terminate_Seller"){
			transferTo(Buyer.account,default2*price);
			end2();
			functionStatus["terminate_Seller"] = true;
			functionFinishTime["terminate_Seller"]=block.timestamp;
			emit completedRule(msg.sender,"terminate_Seller");
	}
	function terminate_Buyer() public payable onlyState(ContractState) onlyBuyer unDone("terminate_Buyer"){
			transferTo(Seller.account,default2*price);
			end2();
			functionStatus["terminate_Buyer"] = true;
			functionFinishTime["terminate_Buyer"]=block.timestamp;
			emit completedRule(msg.sender,"terminate_Buyer");
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
			end();
			functionStatus["buyer_fault"] = true;
			functionFinishTime["buyer_fault"]=block.timestamp;
			emit completedRule(msg.sender,"buyer_fault");
		}
	}
	function seller_fault() public payable onlyState(ContractState) onlySeller unDone("seller_fault"){
		if(isDone("arbitrationClause")||logic(faultName,Seller.name,"==")){
			transferTo(Buyer.account,amount);
			end();
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
