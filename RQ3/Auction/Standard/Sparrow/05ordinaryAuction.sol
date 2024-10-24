pragma solidity >=0.7.0 <0.9.0;
contract ordinaryAuction  
{ 
	uint256 public startTime = 970754400;
	uint256 public finishTime = 970758000;
	string public highestBidder = "" ;
	uint public highestBid = 0 ;
	string public bidder = "" ;
	uint public bid = 0 ;
	uint256 public biddingTime = 3600 ;
	uint public reservePrice = 10000 ;
	uint public Commission = 1000 ;
	uint256 public signTime = 970272000;
	uint public FineIR = 200.0 ;
	uint256 public payTime = 43200 ;
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
		   string   ownership ;
	}
	
	Person public Platform = Person("B", payable(0x4B20993Bc481177ec7E8f571ceCaE8A9e22C02db));
	Person public Auctioneer = Person("A", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	modifier onlyPlatform(){
		require(msg.sender == Platform.account,"Only Platform can access this.");
		 _; 
	}
	modifier onlyAuctioneer(){
		require(msg.sender == Auctioneer.account,"Only Auctioneer can access this.");
		 _; 
	}
	token public thing = token("thing", 1, "A");
	constructor() {
	// Initialize the group
	}
	event completedRule(address indexed person, string rulename);
	function rule1() public payable onlyState(ContractState) onlyAuctioneer unDone("rule1"){
		if(!isTime(startTime)){
			transferTo(Platform.account,10**14*Commission);
			thing.ownership=Platform.name;
			functionStatus["rule1"] = true;
			functionFinishTime["rule1"]=block.timestamp;
			emit completedRule(msg.sender,"rule1");
		}
	}
	function rule2() public payable onlyState(ContractState) onlyPlatform unDone("rule2"){
		if(isDone("rule1")||compareTimestamps(startTime,block.timestamp,3600,"<")){
			functionStatus["rule2"] = true;
			functionFinishTime["rule2"]=block.timestamp;
			emit completedRule(msg.sender,"rule2");
		}
	}
	function rule3(string memory _bidder, uint _bid) public payable onlyState(ContractState) {
		bidder = _bidder;
		bid = _bid;
		if(isDone("rule2")||isTime(startTime)||!isTime(finishTime)||logic(bid,highestBid,">")||logic(bid,reservePrice,">=")){
			highestBid=bid;
			highestBidder=bidder;
			functionStatus["rule3"] = true;
			functionFinishTime["rule3"]=block.timestamp;
			emit completedRule(msg.sender,"rule3");
		}
	}
	function rule4(string memory _bidder) public payable onlyState(ContractState) unDone("rule4"){
		bidder = _bidder;
		if(isTime(finishTime)||compareStrings(bidder,highestBidder)||compareTimestamps(block.timestamp,finishTime,43200,"<")){
			transferTo(Platform.account,10**14*highestBid);
			functionStatus["rule4"] = true;
			functionFinishTime["rule4"]=block.timestamp;
			emit completedRule(msg.sender,"rule4");
		}
	}
	function rule5() public payable onlyState(ContractState) onlyPlatform unDone("rule5"){
		if(isDone("rule4")){
			transferTo(Auctioneer.account,10**14*highestBid);
			thing.ownership=bidder;
			ContractState="finish";
			functionStatus["rule5"] = true;
			functionFinishTime["rule5"]=block.timestamp;
			emit completedRule(msg.sender,"rule5");
		}
	}
	function rule7(string memory _bidder) public payable onlyState(ContractState) unDone("rule7"){
		bidder = _bidder;
		if(compareStrings(bidder,highestBidder)||compareTimestamps(block.timestamp,finishTime,43200,">=")||!isDone("rule4")){
			transferTo(Platform.account,10**14*highestBid*FineIR/1000);
			functionStatus["rule7"] = true;
			functionFinishTime["rule7"]=block.timestamp;
			emit completedRule(msg.sender,"rule7");
		}
	}
	function rule8() public payable onlyState(ContractState) onlyPlatform unDone("rule8"){
		if(isDone("rule7")){
			transferTo(Auctioneer.account,10**14*highestBid*FineIR/1000);
			functionStatus["rule8"] = true;
			functionFinishTime["rule8"]=block.timestamp;
			emit completedRule(msg.sender,"rule8");
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
	event Transfer(address indexed from, address indexed to, uint amount);
	// Transfer to a specified address
	function transferTo(address payable recipient, uint amount) internal {
	    require(recipient != address(0), "Invalid recipient address");
	    require(amount > 0, "Amount must be greater than zero");
	    recipient.transfer(amount);
	    emit Transfer(msg.sender,recipient, amount);
	}
	// Helper function to perform comparison based on the comparison operator
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
	
	
	    // The setValue function can only be executed if the condition valueA > valueB is met
	    function logic(uint256 valueA, uint256 valueB, string memory symbol) internal pure returns (bool) {
	        return compare(valueA, valueB, symbol);
	    }
	function compareTimestamps(uint256 timestamp1, uint256 timestamp2, uint256 customSeconds, string memory operator) internal returns (bool) {
	       // Calculate the difference between two timestamps (take the absolute value to ensure the difference is positive)
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
