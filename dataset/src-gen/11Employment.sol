// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract employment2  
{ 
	uint public salary = 6000 ;
	uint256 public bonusPercentage = 150.0 ;
	uint256 public pd = 2592000 ;
	uint256 public probationPd = 15552000 ;
	uint256 public disacountPercentage = 800.0 ;
	uint256 public insurancePercentage = 120.0 ;
	uint256 public startTime = 1688947200;
	uint256 public firstPayTime = 1690761600;
	uint256 public firstAnnualTime = 1703980800;
	uint256 public finishTime = 1785456000;
	uint256 public hospitality = 432000 ;
	uint256 public leftdays = 432000 ;
	uint public workage = 0 ;
	uint public overworkhours = 0 ;
	uint public overworkfee = 50 ;
	string public ContractState="start";
	mapping(string => bool) public functionStatus;
	mapping(string => uint) public functionFinishTime;	
	struct Person {
		string name;
		address payable account;
	}
		struct Products {
		   string   name ; 
		   string   ownership ; 
	}
	
		struct Job {
		   string   name ; 
		   string   location ; 
		   string   content ; 
	}
	
	Person public company = Person("companyA", payable(0x5B38Da6a701c568545dCfcB03FcB875f56beddC4));
	Person public employee = Person("employee", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	Person public insuranceCompany = Person("insuranceCompanyC", payable(0x78731D3Ca6b7E34aC0F824c42a7cC18A495cabaB));
	modifier onlycompany(){
		require(msg.sender == company.account,"Only company can access this.");
		 _; 
	}
	modifier onlyemployee(){
		require(msg.sender == employee.account,"Only employee can access this.");
		 _; 
	}
	modifier onlyinsuranceCompany(){
		require(msg.sender == insuranceCompany.account,"Only insuranceCompany can access this.");
		 _; 
	}
	Products public products = Products("products", "companyA");
	Job public job = Job("software engineer", "Zhong Guancun", "maintain code base.");
	constructor() {
	}
	event completedRule(address indexed person, string rulename);
	function payRegular() internal{
		transferTo(employee.account,10**14*(salary+overworkhours*overworkfee));
		firstPayTime=firstPayTime+pd;
	}
	function renewYear() internal{
		firstAnnualTime=firstAnnualTime+946080000;
	}
	function payCon() internal view returns (bool) {
		if (isTime(firstPayTime)) return true;
		else return false;
	}
	function annualCon() internal view returns (bool) {
		if (isTime(firstAnnualTime)) return true;
		else return false;
	}
	function paySalary(uint _overworkhours) public payable onlyState(ContractState) {
		uint overworkhours = _overworkhours;   // Assign using the correct data type
		if(payCon()){
			if(isTime(startTime+probationPd)){
				payRegular();
			}
			if(!isTime(startTime+probationPd)){
				transferTo(employee.account,10**14*(salary*disacountPercentage+overworkhours*overworkfee));
			}
			functionStatus["paySalary"] = true;
			functionFinishTime["paySalary"]=block.timestamp;
			emit completedRule(msg.sender,"paySalary");
		}
	}
	function payBonus(uint _bonusWhole) public payable onlyState(ContractState) onlycompany {
		uint bonusWhole = _bonusWhole;   // Assign using the correct data type
		if(annualCon()){
			transferTo(employee.account,10**14*(bonusPercentage*bonusWhole));
			renewYear();
			functionStatus["payBonus"] = true;
			functionFinishTime["payBonus"]=block.timestamp;
			emit completedRule(msg.sender,"payBonus");
		}
	}
	function sickDaysPerYear(uint _expectdayoff) public payable onlyState(ContractState) onlyemployee {
		uint expectdayoff = _expectdayoff;   // Assign using the correct data type
		if(logic(expectdayoff,leftdays,"<=")){
			leftdays=leftdays-expectdayoff;
			if(isTime(firstAnnualTime+31536000)){
				workage=workage+1;
				renewYear();
				leftdays=hospitality;
			}
			if(logic(workage,4,">=")){
				hospitality=10;
			}
			functionStatus["sickDaysPerYear"] = true;
			functionFinishTime["sickDaysPerYear"]=block.timestamp;
			emit completedRule(msg.sender,"sickDaysPerYear");
		}
	}
	function payInsuranceA() public payable onlyState(ContractState) onlycompany {
		if(payCon()){
			transferTo(insuranceCompany.account,10**14*(insurancePercentage*salary));
			firstPayTime=firstPayTime+pd;
			functionStatus["payInsuranceA"] = true;
			functionFinishTime["payInsuranceA"]=block.timestamp;
			emit completedRule(msg.sender,"payInsuranceA");
		}
	}
	function payInsuranceB() public payable onlyState(ContractState) onlyemployee {
		if(payCon()){
			transferTo(insuranceCompany.account,10**14*(insurancePercentage*salary));
			firstPayTime=firstPayTime+pd;
			functionStatus["payInsuranceB"] = true;
			functionFinishTime["payInsuranceB"]=block.timestamp;
			emit completedRule(msg.sender,"payInsuranceB");
		}
	}
	function renewContract(bool _renew) public payable onlyState(ContractState) unDone("renewContract"){
		bool renew = _renew;   // Assign using the correct data type
		if(isTime(finishTime)){
			if(!renew){
				ContractState="terminate";
			}
			if(renew){
				finishTime=finishTime+435432704;
			}
			functionStatus["renewContract"] = true;
			functionFinishTime["renewContract"]=block.timestamp;
			emit completedRule(msg.sender,"renewContract");
		}
	}
	function productOwn(string memory _productList) public payable onlyState(ContractState) onlyemployee unDone("productOwn"){
		string memory productList = "productList"; 
		if(isDone("renewContract")&&isTime(finishTime)){
			products.name=productList;
			products.ownership=company.name;
			functionStatus["productOwn"] = true;
			functionFinishTime["productOwn"]=block.timestamp;
			emit completedRule(msg.sender,"productOwn");
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
	// Helper function to perform comparisons based on a comparison operator
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
	
	
	    // Only allow execution of the setValue function if the condition valueA > valueB is met
	    function logic(uint256 valueA, uint256 valueB, string memory symbol) internal pure returns (bool) {
	        return compare(valueA, valueB, symbol);
	    }
	event Transfer(address indexed from, address indexed to, uint amount);
	// Used to transfer funds to a specified address
	function transferTo(address payable recipient, uint amount) internal {
	    require(recipient != address(0), "Invalid recipient address");
	    require(amount > 0, "Amount must be greater than zero");
	    recipient.transfer(amount);
	    emit Transfer(msg.sender,recipient, amount);
	}
	function compareTimestamps(uint256 timestamp1, uint256 timestamp2, uint256 customSeconds, string memory operator) internal pure returns (bool) {
	       // Calculate the difference between two timestamps (take absolute value to ensure the result is positive)
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
