pragma solidity ^0.4.22;

contract ThingA{
	
	struct Thingtype{
		bytes32 name;
		uint day_rent;
		uint days;
	}			
	function getname(address a) returns(bytes32 _result){
		uint num = _userlist[a];
		return _ThingEntity[num].name;
	}
	
	function setname(address a, bytes32 b){
		uint num = _userlist[a];
		_ThingEntity[num].name = b;
	}
	
	function getday_rent(address a) returns(uint _result){
		uint num = _userlist[a];
		return _ThingEntity[num].day_rent;
	}
	
	function setday_rent(address a, uint b){
		uint num = _userlist[a];
		_ThingEntity[num].day_rent = b;
	}
	
	function getdays(address a) returns(uint _result){
		uint num = _userlist[a];
		return _ThingEntity[num].days;
	}
	
	function setdays(address a, uint b){
		uint num = _userlist[a];
		_ThingEntity[num].days = b;
	}
	
            function registerThing() public {
            			//USER CODE HERE
            	
            			//CHECK
            		}
            
            		function unregisterThing() public {
            			//USER CODE HERE
            	
            			//CHECK
            		}
            
            		function transferThing() public {
            			//USER CODE HERE
            			
            			//CHECK
            		}
                }
}
