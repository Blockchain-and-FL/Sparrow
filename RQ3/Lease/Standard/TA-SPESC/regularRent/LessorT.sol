pragma solidity >=0.4.0 <0.6.0;

contract LessorT{
	
	bytes32 name;
	uint amount;
	
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
	
}
