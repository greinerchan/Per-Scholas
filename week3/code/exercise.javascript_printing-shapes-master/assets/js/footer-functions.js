getLineTests();
getBoxTests();
getBottomLeftTriangleTests();
getUpperLeftTriangleTests();
getPyramidTests();
getCheckerboardTests();




function getLineTests() {
    testGetLine("*", 1);
    testGetLine("**", 2);
    testGetLine("***", 3);
}


function getBoxTests() {
    testGetBox("*\n", 1, 1);
    testGetBox("**\n**\n", 2, 2);
    testGetBox("***\n***\n***\n***\n", 3, 4);
}

function getBottomLeftTriangleTests() {
    testGetBottomLeftTriangle("*", 1);
    testGetBottomLeftTriangle("*\n**", 2);
    testGetBottomLeftTriangle("*\n**\n***", 3);
}

function getUpperLeftTriangleTests() {
    testGetUpperLeftTriangle("*", 1);
    testGetUpperLeftTriangle("**\n*", 2);
    testGetUpperLeftTriangle("***\n**\n*", 3);
}


function getPyramidTests() {
    testGetPyramid("*", 1);
    testGetPyramid(" * \n***", 2);
    testGetPyramid("  *  \n *** \n*****", 3);
}


function getCheckerboardTests() {
    testGetCheckerboard(" *\n* \n", 2, 2);
    testGetCheckerboard(" * \n* *\n * \n", 3, 3);
    testGetCheckerboard(" * \n* *\n * \n* *\n", 3, 4);
}