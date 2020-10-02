let box1 = document.createElement('textarea');
document.body.appendChild(box1);    

let box3 = document.createElement('input');
document.body.appendChild(box3);

let box4 = document.createElement('input');
document.body.appendChild(box4);

let button1 = document.createElement("BUTTON");
document.body.appendChild(button1);
button1.innerHTML = "submitA";

let button2 = document.createElement("BUTTON");
document.body.appendChild(button2);
button2.innerHTML = "submitB";

button1.setAttribute('id', 'button1');
button2.setAttribute('id', 'button2');
button1.setAttribute('type', 'submit');
button2.setAttribute('type', 'submit');

box1.setAttribute('id', 'box1');
//box2.setAttribute('id', 'box2');
box1.setAttribute('name', 'box1');
//box2.setAttribute('name', 'box2');

box3.setAttribute('id', 'box3');
box4.setAttribute('id', 'box4');
box3.setAttribute('name', 'box3');
box4.setAttribute('name', 'box4');

button1.addEventListener('click', function getInputValue(){
    var inputVal = document.getElementById("box3").value;
    inputVal = "\n PersonA: " + inputVal;
    var box1text = document.getElementById("box1");
    box1text.innerHTML += inputVal;
    box3.value = "";
});

button2.addEventListener('click', function getInputValue(){
    var inputVal = document.getElementById("box4").value;
    inputVal = "\n PersonB: " + inputVal;
    var box1text = document.getElementById("box1");
    box1text.innerHTML += inputVal;
    box4.value = "";
});

