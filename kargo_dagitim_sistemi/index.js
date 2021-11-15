//const labels = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
const labels = "0123456789";
let labelIndex = 0;
let markers = [];
let markerscoords = [];
var distance_graph = [];
let dissttt;
let i;
let j;
var jjj = 0;
let enKisaMesafe = Infinity;

var guzergah = [];
var enKisaYolHangiSatir;


 function initMap() {
  const directionsService = new google.maps.DirectionsService();
  const directionsRenderer = new google.maps.DirectionsRenderer();
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 12,
    center: {
      lat: 40.76724162735501,
      lng: 29.935527201408465
    },
    disableDefaultUI: !0
  });

  directionsRenderer.setMap(map);
 

  function onChangeHandler() {
    calculateAndDisplayRoute(directionsService, directionsRenderer);
    
  };




   google.maps.event.addListener(map, "click", (event) => {

    var myJSON = JSON.stringify(event.latLng.toJSON());
    localStorage.setItem("testJSON", myJSON);
    let text = localStorage.getItem("testJSON");
    let obj = JSON.parse(text);

    var string_latlng = '"' + obj.lat + ", " + obj.lng + '"';
    var stringlatlngspecial = string_latlng + " kordinati eklendi.";
    markerscoords[labelIndex] = string_latlng;

    addMarker(event.latLng, map);
    console.log(stringlatlngspecial);

    
    if (markerscoords.length >= 2) {
      
      enKisaYol().then(onChangeHandler);
      
      
      
     
     markers = [];
    }

  });

}


function calculateAndDisplayRoute(directionsService, directionsRenderer) {
 
  
  const waypts = [];

  if(markerscoords.length>2){
  for (let i = 1; i < markerscoords.length-1; i++) {
   
    
      waypts.push({
        location: markerscoords[guzergah[enKisaYolHangiSatir][i]],
        stopover: true,
      });

   
  }

  
  directionsService
    .route({
      origin: markerscoords[guzergah[enKisaYolHangiSatir][0]],
      destination: markerscoords[guzergah[enKisaYolHangiSatir][markerscoords.length-1]],
      waypoints: waypts,
      optimizeWaypoints: true,
      travelMode: google.maps.TravelMode.DRIVING,
    })
    .then((response) => {
      directionsRenderer.setDirections(response);
      
    
    })
    .catch((e) => window.alert("Directions request failed due to " + status));}

    else{

      directionsService
      .route({
        origin: {
          query: markerscoords[0],
        },
        destination: {
          query: markerscoords[1],
        },
        travelMode: google.maps.TravelMode.DRIVING,
      })
      .then((response) => {
        directionsRenderer.setDirections(response);
      })
      .catch((e) => window.alert("Directions request failed due to " + status));

    }



}

function addMarker(location, map) {



  var marker = new google.maps.Marker({
    position: location,
    label: labels[labelIndex++ % labels.length],
    map: map,
    icon: 'yellow-dot.png'
  });


  markers[jjj] = marker;
  jjj++;
}

 calculateDistance = async (baslangic, hedef) => {

  var origin = baslangic;
  var destination = hedef;
  var service = new google.maps.DistanceMatrixService();
  await service.getDistanceMatrix({
    origins: [origin],
    destinations: [destination],
    travelMode: google.maps.TravelMode.DRIVING,
    unitSystem: google.maps.UnitSystem.IMPERIAL, // miles and feet.
    // unitSystem: google.maps.UnitSystem.metric, // kilometers and meters.
    avoidHighways: false,
    avoidTolls: false
  },  callback );

// get distance results

}

async function callback(response, status) {
  
  if (status != google.maps.DistanceMatrixStatus.OK) {

  } else {
    var origin = response.originAddresses[0];
    var destination = response.destinationAddresses[0];
    if (response.rows[0].elements[0].status === "ZERO_RESULTS") {
      console.log("get a plane bro");
    } else {
      var distance = response.rows[0].elements[0].distance;
    //  var duration = response.rows[0].elements[0].duration;
     // console.log(response.rows[0].elements[0].distance);
      var distance_in_kilo = distance.value / 1000; // the kilom
    /*  var distance_in_mile = distance.value / 1609.34; // the mile
      var duration_text = duration.text;
      var duration_value = duration.value;*/
     
      
      
     dissttt = distance_in_kilo;
      
    }
  }

}


enKisaYol = async () => {
 
  enKisaMesafe = Infinity;
  guzergah = [];
  enKisaYolHangiSatir = null;
  distance_graph = [];


  for(var ix=0; ix<markerscoords.length; ix++) {
      distance_graph[ix] = new Array(markerscoords.length);
  }


  for (i = 0; markerscoords.length > i; i++) {
   
    for (j = 0; markerscoords.length > j; j++) {
     
       
        await calculateDistance(markerscoords[i], markerscoords[j]);

       
       
       // console.log("uzaklik"+ dissttt);
        distance_graph[i][j] = dissttt;


    }
  }

  console.log("uzaklik matrisini yazdir");
  for(var ii = 0; ii < markerscoords.length; ii++) {
    for(var z = 0; z < markerscoords.length; z++) {
      console.log("a" + ii + "," + z + "  =  " + distance_graph[ii][z]);
    }
  }



var tttt = [];
for(var x = 0; x<markerscoords.length; x++){

tttt.push(x);
}

guzergah = perm(tttt);

/*
console.log("permutasyon matrisini yazdir");
for(var ii = 0; ii < guzergah.length; ii++) {
  for(var z = 0; z < markerscoords.length; z++) {
    console.log("a" + ii + "," + z + "  =  " + guzergah[ii][z]);
  }
}*/


var enKisaMesafe_temporary = 0;



  for(var x = 0; x < guzergah.length; x++) {
    for(var z = 0; z < markerscoords.length-1; z++) {
    
      enKisaMesafe_temporary = enKisaMesafe_temporary +  distance_graph[guzergah[x][z]][guzergah[x][z+1]];
     

    }              
    if(enKisaMesafe_temporary < enKisaMesafe){
    enKisaMesafe = enKisaMesafe_temporary;
    enKisaYolHangiSatir = x;
    }
    enKisaMesafe_temporary = 0;


  }
   
  console.log("en kisa yol permutasyonda hangi satirda = "+enKisaYolHangiSatir);
  console.log("en kisa mesafe km = "+enKisaMesafe);
  console.log("permutasyon matrisinden en kisa yol satir = ["+guzergah[enKisaYolHangiSatir]+"]");


  
}



function perm(xs) {
  let ret = [];
  
    for (let i = 0; i < xs.length; i = i + 1) {
      let rest = perm(xs.slice(0, i).concat(xs.slice(i + 1)));
  
      if(!rest.length) {
        ret.push([xs[i]])
      } else {
        for(let j = 0; j < rest.length; j = j + 1) {
          ret.push([xs[i]].concat(rest[j]))
        }
      }
    }
    return ret;
  }

// console.log(perm([1,2,3,4]).join("\n"));
