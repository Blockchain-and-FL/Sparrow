pragma solidity >=0.4.0 <0.6.0;

contract raT{
	
	
	address _raAddress;
	uint _max;
	
	function raT(){
		_max = now*1000;
	}
	
	function regist(address a) public {
		_raAddress = a;
	}
	
	function getAddress() public returns (address a){
		return _raAddress;
	}
	
}
