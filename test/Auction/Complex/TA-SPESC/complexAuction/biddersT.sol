pragma solidity >=0.4.0 <0.6.0;

contract biddersT{
	
	struct bidderstype{
		address _biddersaddress;
		
		bytes32 name;
		uint amount;
		
		//attributes of actionpayBid
		bool _ispayBidDone;
		uint _payBidTime;
		
		//attributes of actionpayDefault
		bool _ispayDefaultDone;
		uint _payDefaultTime;
		
	}
	
	uint _max;//time max
	uint _sum;//total member of this party
	uint _BidDoneNum;
	uint[] _BidTime;
	
	uint _payBidDoneNum;
	uint[] _payBidTime;
	
	uint _payDefaultDoneNum;
	uint[] _payDefaultTime;
	
	uint _payCompensationBDoneNum;
	uint[] _payCompensationBTime;
	
	bidderstype _Empty;//used to initialize
	bidderstype[] _biddersEntity;
	mapping(address=>uint) _userlist;
	
	function biddersT(){
		_BidDoneNum = 0;
		
		_payBidDoneNum = 0;
		
		_payDefaultDoneNum = 0;
		
		_payCompensationBDoneNum = 0;
		
		_biddersEntity.push(_Empty);
		_max = now*1000;
	}
	
	function getSum() public returns(uint c){
		return _sum;
	}
	
	function add(address a) public {
		_biddersEntity.push(_Empty);
		_userlist[a] = _sum;
		_sum ++;
	}
	
	function remove(address a) public {
		uint num = _userlist[a];
		_biddersEntity[num] = _biddersEntity[_sum-1];
		_userlist[_biddersEntity[num]._biddersaddress] = num;
		delete(_biddersEntity[num]);
		delete(_userlist[a]);
		_sum --;
	}
	
	function getList() public returns (address[]){
		address[] a;
		for(uint i = 0; i < _sum; i ++)
	        a[i] = _biddersEntity[i]._biddersaddress;
		return a;
	}
	
	function contains(address a) public returns (bool b){
		return _userlist[a] != 0;
	}
	
	function getname(address a) returns(bytes32 _result){
		uint num = _userlist[a];
		return _biddersEntity[num].name;
	}
	
	function setname(address a, bytes32 b){
		uint num = _userlist[a];
		_biddersEntity[num].name = b;
	}
	
	function getamount(address a) returns(uint _result){
		uint num = _userlist[a];
		return _biddersEntity[num].amount;
	}
	
	function setamount(address a, uint b){
		uint num = _userlist[a];
		_biddersEntity[num].amount = b;
	}
	
	function payBidDone(address a){
	    uint num = _userlist[a];
		_biddersEntity[num]._payBidTime = now;
		_biddersEntity[num]._ispayBidDone = true;
		_payBidTime.push(_biddersEntity[num]._payBidTime);
		_payBidDoneNum ++;
	}
	
	function payBidTime(address a) returns (uint result){
	    uint num = _userlist[a];
	    if(_biddersEntity[num]._ispayBidDone){
	        return _biddersEntity[num]._payBidTime;
	    }
	    return _max;
	}
				
	function payBidAllTime() returns (uint result){
	    if(_payBidDoneNum == _max-1){
	        return _payBidTime[_payBidDoneNum-1];
	    }
	    return _max;
	}
	
	function payBidSomeTime() returns (uint result){
	    if(_payBidDoneNum >= 1){
	        return _payBidTime[0];
	    }
	    return _max;
	}
	
	function payDefaultDone(address a){
	    uint num = _userlist[a];
		_biddersEntity[num]._payDefaultTime = now;
		_biddersEntity[num]._ispayDefaultDone = true;
		_payDefaultTime.push(_biddersEntity[num]._payDefaultTime);
		_payDefaultDoneNum ++;
	}
	
	function payDefaultTime(address a) returns (uint result){
	    uint num = _userlist[a];
	    if(_biddersEntity[num]._ispayDefaultDone){
	        return _biddersEntity[num]._payDefaultTime;
	    }
	    return _max;
	}
				
	function payDefaultAllTime() returns (uint result){
	    if(_payDefaultDoneNum == _max-1){
	        return _payDefaultTime[_payDefaultDoneNum-1];
	    }
	    return _max;
	}
	
	function payDefaultSomeTime() returns (uint result){
	    if(_payDefaultDoneNum >= 1){
	        return _payDefaultTime[0];
	    }
	    return _max;
	}
	
}
