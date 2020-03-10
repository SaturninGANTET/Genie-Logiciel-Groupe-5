
function getServerData(url, success){
    $.ajax({
		type:'GET',
        dataType: "json",
        url: url
    }).done(success);
}

function postServerData(url, success){
    $.ajax({
		type: 'POST',
        dataType: "json",
        url: url
    }).done(success);
}

function getClassServerData(url, success){
    $.ajax({
        url: url
    }).done(success);
}

function putServerData(url, success){
    $.ajax({
		type: 'PUT',
        dataType: "json",
        url: url
    }).done(success);
}

function putTextServerData(url, success){
    $.ajax({
		type: 'PUT',
        dataType: "text",
        url: url
    }).done(success);
}

function deleteServerData(url, success){
    $.ajax({
		type: 'DELETE',
        dataType: "json",
        url: url
    }).done(success);
}

function callAddPlace(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultAddPlace").append(html);
}

$(function(){
	$("#addPlace").click(function(){
		putTextServerData("ws/home/addplace/1/1/1/1",callAddPlace);
	});
});


function callInfoPlace(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultInfoPlace").append(html);
}

$(function(){
	$("#infoPlace").click(function(){
		getClassServerData("ws/home/infoplace/1/1/1",callInfoPlace);
	});
});


function callInfoPlace(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultInfoPlace").append(html);
}

$(function(){
	$("#infoPlace").click(function(){
		getClassServerData("ws/home/infoplace/1/1/1",callInfoPlace);
	});
});


function callClosestPlace(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultClosestPlace").append(html);
}

$(function(){
	$("#closestPlace").click(function(){
		getServerData("ws/home/closestplace/1/1/1",callClosestPlace);
	});
});


function callOtherMap(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultOtherMap").append(html);
}

$(function(){
	$("#otherMap").click(function(){
		getServerData("ws/home/othermap/1/1",callOtherMap);
	});
});


function callFriendList(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultFriendList").append(html);
}

$(function(){
	$("#friendList").click(function(){
		getServerData("ws/home/adressbook/1",callFriendList);
	});
});


function callFriendMap(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultFriendMap").append(html);
}

$(function(){
	$("#friendMap").click(function(){
		getServerData("ws/home/adressbook/friendmap/1",callFriendMap);
	});
});


function callAddFriend(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultAddFriend").append(html);
}

$(function(){
	$("#addFriend").click(function(){
		putServerData("ws/home/adressbook/1/2",callAddFriend);
	});
});


function callRemoveFriend(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultRemoveFriend").append(html);
}

$(function(){
	$("#removeFriend").click(function(){
		deleteServerData("ws/home/adressbook/1/2",callRemoveFriend);
	});
});


function callModifyPlace(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultModifyPlace").append(html);
}

$(function(){
	$("#modifyPlace").click(function(){
		postServerData("ws/home/addmodifyplace/1/1/1",callModifyPlace);
	});
});


function callRemovePlace(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultRemovePlace").append(html);
}

$(function(){
	$("#removePlace").click(function(){
		deleteServerData("ws/home/adressbook/1/2",callRemovePlace);
	});
});