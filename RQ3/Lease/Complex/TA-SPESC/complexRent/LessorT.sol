pragma solidity >=0.4.0 <0.6.0;

contract LessorT{
	
	bytes32 name;
	uint amount;
	
	//attributes of actiongetAA1
	bool _isgetAA1Done;
	uint _getAA1Time;
	
	address _LessorAddress;
	uint _max;
	
	function LessorT(){
		_max = now*1000;
	}
	
	function regist(address a) public {
		_LessorAddress = a;
	}
	
	function getAddress() public returns (address a){
		return _LessorAddress;
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
	
	function getAA1Done(){
		_getAA1Time = now;
		_isgetAA1Done = true;
	}
	
	function getAA1Time() returns (uint result){
	    if(_isgetAA1Done){
	        return _getAA1Time;
	    }
	    return _max;
	}
	
}
