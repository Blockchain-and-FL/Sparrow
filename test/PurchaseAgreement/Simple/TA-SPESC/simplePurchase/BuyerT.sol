pragma solidity >=0.4.0 <0.6.0;

contract BuyerT{
	
	bytes32 name;
	uint amount;
	
	//attributes of actionconfirmBuy
	bool _isconfirmBuyDone;
	uint _confirmBuyTime;
	
	//attributes of actionconfirmGet
	bool _isconfirmGetDone;
	uint _confirmGetTime;
	
	address _BuyerAddress;
	uint _max;
	
	function BuyerT(){
		_max = now*1000;
	}
	
	function regist(address a) public {
		_BuyerAddress = a;
	}
	
	function getAddress() public returns (address a){
		return _BuyerAddress;
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
	
	function confirmBuyDone(){
		_confirmBuyTime = now;
		_isconfirmBuyDone = true;
	}
	
	function confirmBuyTime() returns (uint result){
	    if(_isconfirmBuyDone){
	        return _confirmBuyTime;
	    }
	    return _max;
	}
	
	function confirmGetDone(){
		_confirmGetTime = now;
		_isconfirmGetDone = true;
	}
	
	function confirmGetTime() returns (uint result){
	    if(_isconfirmGetDone){
	        return _confirmGetTime;
	    }
	    return _max;
	}
	
}
