
function add(){
	var answer = document.getElementById("answer");
	var x = parseInt(document.getElementById("X").value);
	var y = parseInt(document.getElementById("Y").value);
	answer.value = x + y;
}

function sub(){
	var answer = document.getElementById("answer");
	var x = parseInt(document.getElementById("X").value);
	var y = parseInt(document.getElementById("Y").value);
	answer.value = x - y;
}

function mul(){
	var answer = document.getElementById("answer");
	var x = parseInt(document.getElementById("X").value);
	var y = parseInt(document.getElementById("Y").value);
	answer.value = x * y;
}

function dvd(){
	var answer = document.getElementById("answer");
	var x = parseInt(document.getElementById("X").value);
	var y = parseInt(document.getElementById("Y").value);
	if (y == 0){
		answer.value = "Divider Can Not Be Zero";
	} else{
	answer.value = x / y;
	}
}