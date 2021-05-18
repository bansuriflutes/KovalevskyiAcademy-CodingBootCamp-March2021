package academy.kovalevskyi.codingbootcamp.week2.day0;

import java.util.Scanner;



public class Calculator {


  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Please provide 3 input arguments, example: 2 + 3");
      return;
    }
    long num1 = Integer.parseInt(args[0]); //try catch!
    long num2 = Integer.parseInt(args[2]);
    if (num2 == 0) {
      System.out.println("Division by zero is impossible!");
      return;
    }
    String string = args[1];
    long result = calc(num1, num2, string);
    System.out.println("result: " + result);
  }


  public static long calc(long num1, long num2, String operation) {
    long res;
    switch (operation) {
      case "+":
        res = num1 + num2;
        break;
      case "-":
        res = num1 - num2;
        break;
      case "*":
        res = num1 * num2;
        break;
      case "/":
        res = num1 / num2;
        break;
      case "%":
        res = num1 % num2;
        break;
      default:
        throw new IllegalArgumentException();
    }
    return res;
  }
  //    private static void calc(int a, int b, String operator) {
  //        if (operator == "+") {
  //            System.out.println("result: " + (a + b));
  //        }
  //        if (operator == "-") {
  //            System.out.println("result: " + (a - b));
  //        }
  //        if (operator == "*") {
  //            System.out.println("result: " + (a * b));
  //        }
  //        if (operator == "/") {
  //            System.out.println("result: " + (a / b));
  //        }
  //        if (operator == "%") {
  //            System.out.println("result: " + (a % b));
  //        }
  //    }




}
