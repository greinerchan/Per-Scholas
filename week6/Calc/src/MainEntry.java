import java.util.Scanner;

interface Calc {
  public double compute(int[] array);
}


public class MainEntry {
  public static void main(String[] args) {
    Calc add = (array) -> {
      int sum = 0;
      for (int i : array) {
        sum += i;
      }
      return sum;
    };
    Calc subtract = (array) -> {
      int sum = 0;
      for (int i : array) {
        sum -= i;
      }
      return sum;
    };
    Calc multiply = (array) -> {
      int sum = 1;
      for (int i : array) {
        sum *= i;
      }
      return sum;
    };
    Calc divide = (array) -> {
      return (double)array[0]/(double)array[1];
    };

    Scanner input = new Scanner(System.in);

    int inputLength;
    do {
      System.out.println("Please input your number of values to compute (min. 2): ");
      inputLength = input.nextInt();
    }
    while (inputLength < 2);


//    while (inputLength < 2) {
//      System.out.println("Please input your number of values to compute (min. 2): ");
//    }
    System.out.println("Please input your values separated by spaces: ");
    int[] inputArray = new int[inputLength];

    for (int i =0 ; i < inputArray.length ; i++){
      inputArray[i] = input.nextInt();
    }

    // add switch statement

    System.out.println("add= " + add.compute(inputArray));
    System.out.println("subtract= " + subtract.compute(inputArray));
    System.out.println("multiply= " + multiply.compute(inputArray));
    System.out.println("divide (first two numbers) = " + divide.compute(inputArray));
  }
}
