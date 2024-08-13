pragma solidity >=0.4.0 <0.6.0;

contract SellerT{
	
	bytes32 name;
	uint amount;
	
	//attributes of actiondelivery
	bool _isdeliveryDone;
	uint _deliveryTime;
	
	//attributes of actionsuspendDelivery1
	bool _issuspendDelivery1Done;
	uint _suspendDelivery1Time;
	
	//attributes of actionsuspendDelivery2
	bool _issuspendDelivery2Done;
	uint _suspendDelivery2Time;
	
	//attributes of actionendSale1
	bool _isendSale1Done;
	uint _endSale1Time;
	
	address _SellerAddress;
	uint _max;
	
	function SellerT(){
		_max = now*1000;
	}
	
	function regist(address a) public {
		_SellerAddress = a;
	}
	
	function getAddress() public returns (address a){
		return _SellerAddress;
	}
	
	function getname() returns(bytes32 _result){
		return name;
	}
	
	function setname( bytes32 a){
		name = a;
	}
	
	function getamount() returns(uint _result){
		return amount;
	}
	
	function setamount( uint a){
		amount = a;
	}
	
	function deliveryDone(){
		_deliveryTime = now;
		_isdeliveryDone = true;
	}
	
	function deliveryTime() returns (uint result){
	    if(_isdeliveryDone){
	        return _deliveryTime;
	    }
	    return _max;
	}
	
	function suspendDelivery1Done(){
		_suspendDelivery1Time = now;
		_issuspendDelivery1Done = true;
	}
	
	function suspendDelivery1Time() returns (uint result){
	    if(_issuspendDelivery1Done){
	        return _suspendDelivery1Time;
	    }
	    return _max;
	}
	
	function suspendDelivery2Done(){
		_suspendDelivery2Time = now;
		_issuspendDelivery2Done = true;
	}
	
	function suspendDelivery2Time() returns (uint result){
	    if(_issuspendDelivery2Done){
	        return _suspendDelivery2Time;
	    }
	    return _max;
	}
	
	function endSale1Done(){
		_endSale1Time = now;
		_isendSale1Done = true;
	}
	
	function endSale1Time() returns (uint result){
	    if(_isendSale1Done){
	        return _endSale1Time;
	    }
	    return _max;
	}
	
}
