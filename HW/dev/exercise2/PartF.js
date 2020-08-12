upsideTrapezoid(12, 5);
function upsideTrapezoid(width, height){
    if (width - (height - 1) * 2 <= 1 ) {
        console.log("impossible shape");
        return;
    }
    for (let i = 0; i < height; i++) {
        let str = "";
        for (let k = 0; k < i; k++) {
            str += " ";
        } 
        for (let j = i; j < (width - i); j++) {
            str += "*";
        } 
        for (let h = (width - i); h < width; h++) {
            str += " ";
        }
        console.log(str);
    }
}