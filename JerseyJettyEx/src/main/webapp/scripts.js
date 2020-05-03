
// On s'assure que la page est chargée
window.onload = function(){
    // On initialise la carte sur les coordonnées GPS de Paris
    let macarte = L.map('carte').setView([48.852969, 2.349903], 13)

    // On charge les tuiles depuis un serveur au choix, ici OpenStreetMap France
    L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
        attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
        minZoom: 1,
        maxZoom: 20
    }).addTo(macarte);
    
    L.Routing.control({ 
      waypoints: [
        L.latLng(57.74, 11.94),
        L.latLng(57.6792, 11.949)
    ],  
      router: L.Routing.mapbox('pk.eyJ1IjoibWF4aW1lNTU1NTUiLCJhIjoiY2s5M3p1c3R2MDEzNzNmbzExYjY5cHRhcSJ9.xjtb4gJp4llULxFZzuitwQ')
  }).addTo(macarte);


  // ajouter un marqueur sur paris lattitude longitude
  L.marker([48.866667, 2.333333],
    {

    }).addTo(macarte);


  //adding barre de recherche
  var searchControl = L.esri.Geocoding.geosearch().addTo(macarte);

  var results = L.layerGroup().addTo(macarte);

  searchControl.on('results', function (data) {
    results.clearLayers();
    for (var i = data.results.length - 1; i >= 0; i--) {
      results.addLayer(L.marker(data.results[i].latlng));
    }
  });

  function createButton(label, container) {
    var btn = L.DomUtil.create('button', '', container);
    btn.setAttribute('type', 'button');
    btn.innerHTML = label;
    return btn;
}

// test marqueur par click layer group





// test popup en click

/*
var popup = L.popup();

function onMapClick(e) {
    popup
        .setLatLng(e.latlng)
        .setContent("You clicked the map at " + e.latlng.toString())
        .openOn(macarte);
}

macarte.on('click', onMapClick);

*/

// affiche un message de destination en cliquant

macarte.on('click', function(e) {
    var container = L.DomUtil.create('div'),
        startBtn = createButton('Start from this location', container),
        destBtn = createButton('Go to this location', container);

    L.popup()
        .setContent(container)
        .setLatLng(e.latlng)
        .openOn(macarte);
    L.DomEvent.on(startBtn, 'click', function() {
        control.spliceWaypoints(0, 1, e.latlng);
       macarte.closePopup();
    });
    L.DomEvent.on(destBtn, 'click', function() {
         control.spliceWaypoints(control.getWaypoints().length - 1, 1, e.latlng);
        macarte.closePopup();
    });
   
});

}

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

function callAddPlace(result){
	var template1 = _.template($('#test').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultAddPlace").append(html);
}

$(function(){
	$("#addPlace").click(function(){
		putTextServerData("ws/lef/addplace/1/1",callAddPlace);
	});
});


/**
Test satutu
*/

function postServerDataSatutu(url, data, success){
    console.log(data);
    $.ajax({
        type: 'POST',
        data: data,
        url:url
    }).done(success);
}

register = () =>{
    console.log("function register() called");
    console.log(document.getElementById("champ-pass").value);
    postServerDataSatutu("ws/login/register","email="+document.getElementById("champ-email").value+"&pass="+document.getElementById("champ-pass").value,function(result){
        console.log(result);
    });
}
