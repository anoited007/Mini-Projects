
var whiteKeys = document.querySelectorAll(".piano-white");
var blackKeys = document.querySelectorAll(".piano-black-raised");

for(var i=0; i<whiteKeys.length; i++){
	let note = whiteKeys[i].getAttribute("class").slice(-2);
	whiteKeys[i].onmousedown = function(){start(note)}
}

for(var i=0; i<blackKeys.length; i++){
	let note = blackKeys[i].getAttribute("class").slice(-3);
	blackKeys[i].onmousedown = function(){start(note)}
}	 
	
function start(note){
	var audio = document.getElementById("sound-"+note);
	audio.currentTime = 0;
	audio.volume = 1.0;
	audio.play();
}

function stop(note) {
	var audio = document.getElementById("sound-"+note);
	audio.pause();
	audio.currentTime = 0;
}

var keyToNotes = {'z':'A2', 'x':'B2', 'c':'C3', 'v':'D3','b':'E3', 'n':'F3', 'm' :'G3', 'q': 'A3', 'w':'B3', 'e':'C4', 'r':'D4', 't':'E4', 'y':'F4', 'u':'G4', 'i':'A4', 'o':'B4', 'p':'C5', 's':'Bb2', 'f':'Db3','g':'Eb3', 'j':'Gb3', 'k' :'Ab3', '2':'Bb3', '4':'Db4', '5':'Eb4', '7':'Gb4', '8':'Ab4', '9':'Bb4'};

document.addEventListener("keypress", play);
	
function play (event){
	var note = keyToNotes[event.key.toLowerCase()];
	
	if(note != undefined) {
		start(note);
	}
}
