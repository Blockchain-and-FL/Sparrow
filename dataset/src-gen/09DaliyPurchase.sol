pragma solidity >=0.7.0 <0.9.0;
contract DaliyPurchase  
{ 
	string public place = "" ;
	uint256 public giveTime = 0;
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
		   uint   unit_price ;
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
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function rule1(uint16 _year,uint8 _months,uint8 _days,uint8 _hours,uint8 _minutes,string memory _place) public payable onlyState(ContractState) onlyBuyer unDone("rule1"){
		giveTime=convertToTimestamp(_year,_months,_days,_hours,_minutes);
		place = _place;
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
	}
	function rule2() public payable onlyState(ContractState) onlySeller unDone("rule2"){
		if(isTime(giveTime)||!isTime(giveTime+86400)){
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3() public payable onlyState(ContractState) onlyBuyer unDone("rule3"){
		if(isDone("rule2")){
			transferTo(Seller.account,10**14*Service.price);
			ContractState="finish";
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	// Check whether a specific function has already been executed
	function isDone(string memory functionName) internal view returns (bool) {
	    return functionStatus[functionName];
	}
	event Transfer(address indexed from, address indexed to, uint amount);
	// Used to transfer funds to a specified address
	function transferTo(address payable recipient, uint amount) internal {
	    require(recipient != address(0), "Invalid recipient address");
	    require(amount > 0, "Amount must be greater than zero");
	    recipient.transfer(amount);
	    emit Transfer(msg.sender,recipient, amount);
	}
	// Check if the current time reaches the target time
	function isTime(uint256 targetTime) internal view returns (bool) {
	    return block.timestamp >= targetTime;
	}
	function isLeapYear(uint16 year) internal pure returns (bool) {
	    if (year % 4 != 0) {
	        return false;
	    }
	    if (year % 100 != 0) {
	        return true;
	    }
	    if (year % 400 != 0) {
	        return false;
	    }
	    return true;
	}
					
	function getDaysInMonth(uint8 month, uint16 year) internal pure returns (uint8) {
	    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
	        return 31;
	    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
	        return 30;
	    } else if (isLeapYear(year)) {
	        return 29;
	    } else {
	        return 28;
	    }
	}
					
	function convertToTimestamp(uint16 year, uint8 month, uint8 day, uint8 hour, uint8 minute) public pure returns (uint256) {
	    require(year >= 1970, "Year must be 1970 or later");
	    require(month >= 1 && month <= 12, "Invalid month");
	    require(day >= 1 && day <= getDaysInMonth(month, year), "Invalid day");
	    require(hour >= 0 && hour <= 23, "Invalid hour");
	    require(minute >= 0 && minute <= 59, "Invalid minute");
	    uint256 timestamp = 0;
	    for (uint16 y = 1970; y < year; y++) {
	        if (isLeapYear(y)) {
	            timestamp += 366 days;
	        } else {
	            timestamp += 365 days;
	        }
	    }
	    for (uint8 m = 1; m < month; m++) {
	        timestamp += uint256(getDaysInMonth(m, year)) * 1 days;
	    }
	    timestamp += uint256(day - 1) * 1 days;
	    timestamp += uint256(hour) * 1 hours;
	    timestamp += uint256(minute) * 1 minutes;
	    return timestamp;
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
