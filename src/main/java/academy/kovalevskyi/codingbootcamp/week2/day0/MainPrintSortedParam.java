package academy.kovalevskyi.codingbootcamp.week2.day0;

import java.lang.String;

/**
 * Единственный метод этого класса принимает неопределенное
 * количество аргументов, во время запуска программы,
 * сортирует их и выводит на экран поочередно.
 */

public class MainPrintSortedParam {

  public static void main(String[] args) {
    String max = "";
    if (args.length == 0) {
      System.out.println("Please specify at least one argument!");
    } else {
      for (int i = 0; i < args.length; i++) {
        for (int j = 0; j < args.length - 1; j++) {
          if (args[j].compareTo(args[j + 1]) > 0) {
            max = args[j];
            args[j + 1] = args[j];
            args[j] = max;
          }
        }
      }
    }
    for (int k = 0; k < args.length; k++) {
      System.out.println(args[k]);
    }
  }
}
