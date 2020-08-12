Checkerboard(11, 6);

function Checkerboard(width, height) {
    var str = ""; let cur = "*";
    for (let row = 0; row < height; row++) {
        for (let col = 0; col < width; col++) {
            if ((row % 2 === 0 && col % 2 === 0) 
                || (row % 2 === 1 && col % 2 === 1)) {
                cur = "*";
            }  else {
                cur = " ";
            }
            str += cur;
        }
        console.log(str);
        str = ""
    }
}