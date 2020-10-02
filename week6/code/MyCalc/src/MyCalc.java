import java.util.Scanner;

@FunctionalInterface
interface Calculator<T> {
    public double compute(T num1, T num2, String operator);
}

public class MyCalc<T> {
    public static void main(String[] args) {
        Calculator<Integer> sum = ((num1, num2, operator) -> num1 + num2);
        Calculator<Integer> subtract = ((num1, num2, operator) -> num1 - num2);
        Calculator<Float> multiply = (num1, num2, operator) -> num1 * num2;
        Calculator<Float> divide = (num1, num2, operator) -> num1 / num2;

        Scanner sc = new Scanner(System.in);
        String str = new String();
        str = sc.nextLine();
        String[] splited = str.split("\\s+");
        System.out.println(splited.toString());
        switch(splited[2]) {
            case "+":
                System.out.println(sum.compute(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]), "+"));
                break;
            case "-":
                System.out.println(subtract.compute(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]), "-"));
                break;
            case "*":
                System.out.println(multiply.compute(Float.parseFloat(splited[0]), Float.parseFloat(splited[1]), "*"));
                break;
            case "/":
                System.out.println(divide.compute(Float.parseFloat(splited[0]), Float.parseFloat(splited[1]), "/"));
                break;
            default:
                System.out.println("not in operator");
        }
//        System.out.println("add= " + sum.compute(2,3,"+"));
//        System.out.println("subtract= " + subtract.compute(2,3,"-"));
//        System.out.println("multiply= " + multiply.compute(2f,3.2f,"*"));
//        System.out.println("divide (first two numbers) = " + divide.compute(2.3f,3.2f,"/"));

    }
}
