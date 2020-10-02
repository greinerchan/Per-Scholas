var input = "********##**####**#**######***";
BreakKeyWords(input);
function BreakKeyWords(input) {
    const len = input.length;
    let counter = 0;
    for (let i = 0; i < len; i++) {
        if (input[i] === '*'){
            continue;
        }
        if (input[i] === '#') {
            counter += 1;
        }
    }
    console.log("the number of # is " + counter);
}