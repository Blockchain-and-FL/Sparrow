pragma solidity >=0.4.0 <0.6.0;

contract caT{
	
	
	address _caAddress;
	uint _max;
	
	function caT(){
		_max = now*1000;
	}
	
	function regist(address a) public {
		_caAddress = a;
	}
	
	function getAddress() public returns (address a){
		return _caAddress;
	}
	
}
