pragma solidity >=0.4.0 <0.6.0;

contract PlatformT{
	
	uint amount;
	
	//attributes of actionconfirmArrive
	bool _isconfirmArriveDone;
	uint _confirmArriveTime;
	
	address _PlatformAddress;
	uint _max;
	
	function PlatformT(){
		_max = now*1000;
	}
	
	function regist(address a) public {
		_PlatformAddress = a;
	}
	
	function getAddress() public returns (address a){
		return _PlatformAddress;
	}
	
	function getamount() returns(uint _result){
		return amount;
	}
	
	function setamount( uint a){
		amount = a;
	}
	
	function confirmArriveDone(){
		_confirmArriveTime = now;
		_isconfirmArriveDone = true;
	}
	
	function confirmArriveTime() returns (uint result){
	    if(_isconfirmArriveDone){
	        return _confirmArriveTime;
	    }
	    return _max;
	}
	
}
