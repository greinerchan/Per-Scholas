cross(8);

function cross(size) {
    var str = ""; 
    for (let i = 0; i < size; i++) {
        for (let j = 0; j < size; j++) {
            if (i === j || (i + j === (size - 1))) {
                str += "*";
            } else {
                str += " "
            }
        }
        console.log(str);
        str = "";
    }
}