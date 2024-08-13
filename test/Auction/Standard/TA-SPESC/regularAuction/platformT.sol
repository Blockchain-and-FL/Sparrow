pragma solidity >=0.4.0 <0.6.0;

contract platformT{
	
	bytes32 name;
	uint amount;
	
	//attributes of actionStartBidding
	bool _isStartBiddingDone;
	uint _StartBiddingTime;
	
	address _platformAddress;
	uint _max;
	
	function platformT(){
		_max = now*1000;
	}
	
	function regist(address a) public {
		_platformAddress = a;
	}
	
	function getAddress() public returns (address a){
		return _platformAddress;
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
	
	function StartBiddingDone(){
		_StartBiddingTime = now;
		_isStartBiddingDone = true;
	}
	
	function StartBiddingTime() returns (uint result){
	    if(_isStartBiddingDone){
	        return _StartBiddingTime;
	    }
	    return _max;
	}
	
}
