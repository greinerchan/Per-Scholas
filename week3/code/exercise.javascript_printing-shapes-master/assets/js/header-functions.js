function testGetLine(expectedOutput, numberOfStars) {
    test(expectedOutput, getLine, numberOfStars);
}

function testGetBox(expectedOutput, width, height) {
    test(expectedOutput, getBox, width, height);
}


function testGetCheckerboard(expectedOutput, width, height) {
    test(expectedOutput, getCheckerboard, width, height);
}

function testGetPyramid(expectedOutput, numberOfStars) {
    test(expectedOutput, getPyramid, numberOfStars);
}

function testGetUpperLeftTriangle(expectedOutput, numberOfStars) {
    test(expectedOutput, getUpperLeftTriangle, numberOfStars);
}

function testGetBottomLeftTriangle(expectedOutput, numberOfStars) {
    test(expectedOutput, getBottomLeftTriangle, numberOfStars);
}