//var command = new Object();
//command.default = "SELECT";
//command.select = "SELECT";
//command.insert = "INSERT";
//command.delete = "DELETE";
//command.update = "UPDATE";

var CMD_TYPE_NONE = 'NONE';
var CMD_TYPE_SELECT = 'SELECT';
var CMD_TYPE_UPDATE = 'UPDATE';
var CMD_TYPE_DELETE = 'DELETE';
var CMD_TYPE_INSERT = 'INSERT';
var CMD_TYPE_BATCH_SAVE = 'BATCH_SAVE';
var APP_NAME = "GambleHub";
$(document).ready(function(){ 
	
}); // end $(document).ready

function createRequestDto(){
	var requestDto = {};
	requestDto.command = CMD_TYPE_NONE;
	requestDto.dataInstance = "";
	requestDto.dataClassName = "";
	return requestDto;
}