var input = "****###****##**#######**#**######***";
BreakKeyWords(input);
function BreakKeyWords(input) {
    const len = input.length;
    let counter = 0;
    for (let i = 0; i < len; i++) {
        while (input[i] === '#') {
            counter += 1;
            i++;
        }
        if (counter >= 4) {
            console.log("the first # equal/more than four is " + counter);
            break;
        } else if (counter < 4 && counter > 0) {
            console.log(0);
            counter = 0;
        }
    }
}

