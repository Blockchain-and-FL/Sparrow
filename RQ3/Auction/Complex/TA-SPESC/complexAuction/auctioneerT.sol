pragma solidity >=0.4.0 <0.6.0;

contract auctioneerT{
	
	uint amount;
	
	address _auctioneerAddress;
	uint _max;
	
	function auctioneerT(){
		_max = now*1000;
	}
	
	function regist(address a) public {
		_auctioneerAddress = a;
	}
	
	function getAddress() public returns (address a){
		return _auctioneerAddress;
	}
	
	function getamount() returns(uint _result){
		return amount;
	}
	
	function setamount( uint a){
		amount = a;
	}
	
}
