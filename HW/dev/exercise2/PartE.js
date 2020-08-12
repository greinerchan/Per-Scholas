upTriangle(8);
function upTriangle(length) {
    
    for (let i = length; i > 0; i--) {
        let str = "";
        for (j = 0; j < (length - i); j++) {
            str += " ";
        }
        for (j = 0; j < i; j++) {
            str += "*"
        }
        console.log(str);
    }

}