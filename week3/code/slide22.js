

square();

function square() {
    var counter = 0; var input;
    do {
        counter += 1;
        if (counter === 1){
            input = prompt("Please enter an integer");
        } else {
            input = prompt("Please re-enter:");
        }
    } while (input > 100 || input < 0);
    console.log(input * input);
}