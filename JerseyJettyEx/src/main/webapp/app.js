
 //lattitude longitude
//var f = new mm.Follower(map, new mm.Location(37.811530, -122.2666097), 'Test marqueur');

var initMap = function() {
  map = new MM.Map('map', new MM.TemplatedLayer("http://tile.openstreetmap.org/{Z}/{X}/{Y}.png")); 

  map.parent.style.position = 'absolute';
  map.parent.style.left = '0';
  map.parent.style.top = '0';
 
  map.setCenterZoom(new MM.Location(48.856614, 2.3522219), 14);
  var pt = new MM.Point(container.offsetWidth*0.75, container.offsetHeight*0.5);
  var loc =  map.pointLocation(pt);

}

var loadYQL = function(url, callback) {
     var yqlURL = 'http://query.yahooapis.com/v1/public/yql';
    var yqlArgs = {
      q: 'select * from xml where url="'+url+'"',
      format: 'json',
      callback: callback
    };
    var queries = [];
    for (var prop in yqlArgs) {
        queries.push(prop + '=' + yqlArgs[prop]);
    }
    var script = document.createElement('script');
    script.src = yqlURL + '?' + queries.join('&');
    document.getElementsByTagName('head')[0].appendChild(script);
}

var cablist = function(data) {
    if (data && data.query && data.query.results) {
        var cabs = data.query.results.cabs;
        if (cabs && cabs.cab) {
            for (var i = 0; i < cabs.cab.length; i++) {
                var cabURL = 'http://cabspotting.org/cab.xml.php?cab=' + cabs.cab[i].id;
                loadYQL(cabURL, 'plotcab');
            }
        }
    }
}
 
var plotcab = function(data) {
    //console.log(data);
    if (data && data.query && data.query.results) {
        var cab = data.query.results.cab;
        if (cab && cab.point) {
            // add cab viz
            var points = cab.point;
            if (points.length && points.length > 0) {
                var location = new com.modestmaps.Location(points[0].lat, points[0].lon);
                new com.modestmaps.CabFollower(map, location, points[0].cab)
            }
        }
    }
}