pragma solidity >=0.4.0 <0.6.0;

contract LesseeT{
	
	bytes32 name;
	uint amount;
	
	//attributes of actionpayFirst
	bool _ispayFirstDone;
	uint _payFirstTime;
	
	//attributes of actioncontinue
	bool _iscontinueDone;
	uint _continueTime;
	
	//attributes of actiongetAA2
	bool _isgetAA2Done;
	uint _getAA2Time;
	
	address _LesseeAddress;
	uint _max;
	
	function LesseeT(){
		_max = now*1000;
	}
	
	function regist(address a) public {
		_LesseeAddress = a;
	}
	
	function getAddress() public returns (address a){
		return _LesseeAddress;
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
	
	function payFirstDone(){
		_payFirstTime = now;
		_ispayFirstDone = true;
	}
	
	function payFirstTime() returns (uint result){
	    if(_ispayFirstDone){
	        return _payFirstTime;
	    }
	    return _max;
	}
	
	function continueDone(){
		_continueTime = now;
		_iscontinueDone = true;
	}
	
	function continueTime() returns (uint result){
	    if(_iscontinueDone){
	        return _continueTime;
	    }
	    return _max;
	}
	
	function getAA2Done(){
		_getAA2Time = now;
		_isgetAA2Done = true;
	}
	
	function getAA2Time() returns (uint result){
	    if(_isgetAA2Done){
	        return _getAA2Time;
	    }
	    return _max;
	}
	
}
