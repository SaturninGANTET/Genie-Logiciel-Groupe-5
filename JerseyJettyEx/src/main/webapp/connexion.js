
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

function callGetMessage(result){
	var template1 = _.template($('#template1').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultgetMessage").append(html);
}

$(function(){
	$("#getMessage").click(function(){
		putTextServerData("ws/connexion/getmessage/1/1/1/1",callGetMessage);
	});
});

