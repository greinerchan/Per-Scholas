LH();
function LH() {
    var list = new Array();
    var L = prompt("Please enter an lower limits");
    var H = prompt("Please enter an upper limits");
    var fullString;
    for (let i = L; i < H; i++) {
        list.push(i);
    }
    console.log(...list);
}