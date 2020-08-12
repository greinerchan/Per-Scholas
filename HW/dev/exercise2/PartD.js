lowTriangle(8);
function lowTriangle(length) {
    for (let i = 0; i < length; i++) {
        let str = "";
        for (j = 0; j <= i; j++) {
            str += "*"
        }
        console.log(str);
    }

}