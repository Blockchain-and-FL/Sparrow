pragma solidity >=0.4.0 <0.6.0;

contract SellerT{
	
	bytes32 name;
	uint amount;
	
	//attributes of actiondelivery
	bool _isdeliveryDone;
	uint _deliveryTime;
	
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
	
}
