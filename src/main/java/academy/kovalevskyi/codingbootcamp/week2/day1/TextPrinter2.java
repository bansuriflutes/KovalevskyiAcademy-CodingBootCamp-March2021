package academy.kovalevskyi.codingbootcamp.week2.day1;

import static academy.kovalevskyi.codingbootcamp.week2.day1.TextPrinter.arrayPrinter;
import static academy.kovalevskyi.codingbootcamp.week2.day1.TextPrinter.setText;

public class TextPrinter2 {
  public static void main(String[] args) {

    if (args.length != 2) {
      System.out.println("Please provide 2 input argument, current amount: " + args.length);
      return;
    }

    char ch = args[0].charAt(0);
    char angle1 = ch;
    char side = ch;
    String str = args[1];
    int width = str.length() + 4;
    int height = 3;


    char [][]symbol = new char[height][width];

    BoxGenerator.fillArray(symbol, ' ');
    BoxGenerator.makeAngle(symbol, angle1);
    BoxGenerator.makeSide(symbol, side);
    setText(symbol, str);
    arrayPrinter(symbol);


    /*Старая хардкорная реализация*/
    //        if (stringLength == 0){
    //            System.out.print(args[0]);
    //            System.out.print(args[0]);
    //            System.out.print(args[0]);
    //            System.out.println(args[0]);
    //
    //            System.out.print(args[0]);
    //            System.out.print(" ");
    //            System.out.print(" ");
    //            System.out.println(args[0]);
    //
    //            System.out.print(args[0]);
    //            System.out.print(args[0]);
    //            System.out.print(args[0]);
    //            System.out.println(args[0]);
    //            return;
    //
    //        }
    //        if (stringLength != 0) {
    //            for (int i = 0; i < width - 1; i++) {
    //                System.out.print(args[0]);
    //            }
    //            System.out.println(args[0]);
    //
    //            System.out.print(args[0]);
    //            System.out.print(" ");
    //            System.out.print(args[1]);
    //            System.out.print(" ");
    //            System.out.println(args[0]);
    //
    //            for (int i = 0; i < width - 1; i++) {
    //                System.out.print(args[0]);
    //            }
    //            System.out.println(args[0]);
    //            return;
    //        }

  }
}
