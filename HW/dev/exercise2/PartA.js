// Part A
Box(5,6);
function Box(width, height) {
    var row = "";
    for (let i = 0; i < width; i++) {
        row += "*";
    }
    for (let i = 0; i < height; i++) {
        console.log(row);
    }
}