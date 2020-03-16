var initMap = function() {
  var container = document.getElementById('container');
    
  leftMap = new MM.Map('left-map', new MM.TemplatedLayer("http://tile.openstreetmap.org/{Z}/{X}/{Y}.png")); 
  rightMap = new MM.Map('right-map', new MM.TemplatedLayer("http://s3.amazonaws.com/com.modestmaps.bluemarble/{Z}-r{Y}-c{X}.jpg")); 
     
  leftMap.parent.style.position = 'absolute';
  leftMap.parent.style.left = '0';
  leftMap.parent.style.top = '0';
  rightMap.parent.style.position = 'absolute';
  rightMap.parent.style.left = parseInt(container.offsetWidth/2) + 'px';
  rightMap.parent.style.top = '0';

  leftMap.setCenterZoom(new MM.Location(0, 0), 2);
  var pt = new MM.Point(container.offsetWidth*0.75, container.offsetHeight*0.5);
  var loc = leftMap.pointLocation(pt);
  rightMap.setCenterZoom(loc, leftMap.getZoom());

  var leftChanging = false, rightChanging = false;
  function syncMaps() {
    if (leftChanging) {
      var pt = new MM.Point(container.offsetWidth*0.75, container.offsetHeight*0.5);
      var loc = leftMap.pointLocation(pt);
      rightMap.setCenterZoom(loc, leftMap.getZoom());
    }
    if (rightChanging) {
      var pt = new MM.Point(-container.offsetWidth*0.25, container.offsetHeight*0.5);
      var loc = rightMap.pointLocation(pt);
      leftMap.setCenterZoom(loc, rightMap.getZoom());
    }
  }
  function leftSync() {
    if (!rightChanging) {
      leftChanging = true;
      syncMaps();
      leftChanging = false;
     }
  }
  function rightSync() {
    if (!leftChanging) {
      rightChanging = true;
      syncMaps();
      rightChanging = false;
    }
  }

  leftMap.addCallback('centered', leftSync);
  rightMap.addCallback('centered', rightSync);
  leftMap.addCallback('panned', leftSync);
  rightMap.addCallback('panned', rightSync);
  leftMap.addCallback('zoomed', leftSync);
  rightMap.addCallback('zoomed', rightSync);
}