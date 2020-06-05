function $e(id){
	return document.getElementById(id) ;
}

function funDoFocus(ele,width,height){
	ele.style.width = Math.ceil(width+20) + 'px' ;
	ele.style.height = Math.ceil(height+20) + 'px' ;
}

function funDoBlur(ele,width,height){
	ele.style.width = width + 'px' ;
	ele.style.height = height + 'px' ;
}

var Platform = 'DVB' ;
var key = {};
if (Platform=="win") {
    key = {
        Up: 38,
        Down: 40,
        Left: 37,
        Right: 39,
        Ok: 13,
        F1: 112,
        F2: 113,
        F3: 114,
        F4: 115,
		numb1: 49,
        numb2: 50,
        numb3: 51,
        numb4: 52,
        numb5: 53,
        numb6: 54,
        numb7: 55,
        numb8: 56,
        numb9: 57,
        numb0: 48,
        Mute: 77,
        Back: 66,
        Track: 82,
        VolumeUp: 190,
        VolumeDown: 188,
        Fav: 84,
        PlayBack: 80,
		PageDown:34,
		PageUp:33,
		Menu:72
    };
}
else {
    key = {
        Up: 65362,
        Down: 65364,
        Left: 65361,
        Right: 65363,
        Ok: 65293,
        F1: 32,
        F2: 33,
        F3: 34,
        F4: 35,
        numb1: 49,
        numb2: 50,
        numb3: 51,
        numb4: 52,
        numb5: 53,
        numb6: 54,
        numb7: 55,
        numb8: 56,
        numb9: 57,
        numb0: 48,
        Mute: 63563,
        Back: 65367,
        Track: 65307,
        VolumeUp: 63561,
        VolumeDown: 63562,
        Fav: 36,
        PlayBack: 72,
		PageDown:26,
		PageUp:25,
		Menu:65360
    };
}
