pragma solidity >=0.4.0 <0.6.0;

contract LesseeT{
	
	bytes32 name;
	uint amount;
	
	//attributes of actioncontinue
	bool _iscontinueDone;
	uint _continueTime;
	
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
	
}
