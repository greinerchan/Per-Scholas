# Printing Shapes

* **Objective** - To create a shape-printer using `console.log`.
* **Purpose** - To establish familiarity with basic Javascript.
* **Description**
    * You are provided with a file located at `./assets/js/shapes.js`
    * Edit the file by defining each of the respective function-stubs.
    * The objective is to create a program which will return Strings representative of particular shapes with dimensions dependent on user-input.



## Part 1 - Clone the project

* Begin by _forking_ this project into a personal repository.
   * To do this, click the `Fork` button located at the top right of this page.
* Navigate to your github profile to find the _newly forked repository_.
* Clone the repository from **your account** into the `~/dev` directory.
* Open the newly cloned project in a code editor (Visual Studio Code, for example).


## Part 2 - Printing line
* Complete definition of the `getLine` function-stub located in `./assets/js/shapes.js`.
	* The function should ask user to input `length`print a solid line of the requested `length` using asterisks.
* Test the function by _calling_ it from `./assets/js/header-functions.js`, then opening the **insepctor-tool** on the `./index.html` document.

### Example:


```
Input length: 7

Shape:
*******

```




## Part 3 - Printing box
* Finish defining the `getBox` function-stub located in `./assets/js/shapes.js`.
	* The function should ask user to input `width` and `height` and prints a solid rectangular box of the requested size using asterisks.
* Test the function by _calling_ it from `./assets/js/header-functions.js`, then opening the **insepctor-tool** on the `./index.html` document.

### Example:

```
Input width: 7
Input height: 4

Shape:
*******
*******
*******
*******
```


## Part 4 - Checkerboard
* Finish defining the `getCheckerboard` function-stub located in `./assets/js/shapes.js`.
	* The function should ask user to input `width` and `height` and prints a rectangular checkerboard of the requested size using asterisks and spaces (alternating)
* Test the function by _calling_ it from `./assets/js/header-functions.js`, then opening the **insepctor-tool** on the `./index.html` document.

### Example:

```
Example:
Input width: 11
Input height: 6

Shape:
* * * * * *
 * * * * * 
* * * * * *
 * * * * *
* * * * * *
 * * * * *
```












## Part 5 - Cross
* Finish defining the `getCross` function-stub located in `./assets/js/shapes.js`.
	* The function should require input for a `length`, and print a diagonal cross of that dimension.
* Test the function by _calling_ it from `./assets/js/header-functions.js`, then opening the **insepctor-tool** on the `./index.html` document.

### Example:

```
Example:
Input length: 8

Shape:
*      *
 *    *
  *  *
   **
   **
  *  *
 *    *
*      *
```







## Part 6 - Lower Triangle
* Finish defining the `getLowerTriangle` function-stub located in `./assets/js/shapes.js`.
	* The function should require input for a `length`, and print the bottom-left half of a square, given the side length.
* Test the function by _calling_ it from `./assets/js/header-functions.js`, then opening the **insepctor-tool** on the `./index.html` document.

### Example:

```
Example:
Input length: 6

Shape:
*
**
***
****
*****
******
```






## Part 7 - Upper Triangle
* Finish defining the `getUpperTriangle` function-stub located in `./assets/js/shapes.js`.
	* The function should require input for a `length`, and print the top-right half of a square, given the side length.
* Test the function by _calling_ it from `./assets/js/header-functions.js`, then opening the **insepctor-tool** on the `./index.html` document.

### Example:

```
Example:
Input length: 5

Shape:
*****
 ****
  ***
   **
    *
```







## Part 8 - Upside Down Trapezoid
* Finish defining the `getUpsideDownTrapezoid` function-stub located in `./assets/js/shapes.js`.
	* The function should require input for a `width`and `height`, and print an upside-down trapezoid of given width and height.
	* If the input `height` is impossibly large for the given `width`, then the program should report, `Impossible shape!`

* Test the function by _calling_ it from `./assets/js/header-functions.js`, then opening the **insepctor-tool** on the `./index.html` document.

### Example:

```
Example 1:
Input width: 12
Input height: 5

Shape:
************
 **********
  ********
   ******
    ****
```


```
Example 2:
Input width: 12
Input height: 7

Impossible shape!

```





