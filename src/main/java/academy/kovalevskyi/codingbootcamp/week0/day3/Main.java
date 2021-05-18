package academy.kovalevskyi.codingbootcamp.week0.day3;

import java.util.concurrent.ThreadLocalRandom;

import static academy.kovalevskyi.codingbootcamp.week2.day2.ProgressBar.timeLeft;
import static academy.kovalevskyi.codingbootcamp.week2.day2.ProgressBar.updateProgress;

/**
 * CodingBootcamp.
 */

public class Main {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Amount of arguments should be: at least 2");
      System.out.println("example: java -jar ... 2 3");
      return;
    }
//    if (!args.getClass().equals(Main.class)) {
//      System.out.println("all arguments should be int");
//      System.out.println("example: java -jar ... 2 3");
//    return;
//    }
    try {
      for (int i = 0; i < args.length; i++) {
        args[i].equals(Integer.parseInt(args[i]));
      }
    } catch (Exception e) {
      System.out.println("all arguments should be int");
      System.out.println("example: java -jar ... 2 3");
      //System.out.printf("incorrect argument: %s\n", args[i]);

    }
//    else {
//      String[] var2 = args;
//      int var3 = args.length;
//
//      for (int var4 = 0; var4 < var3; ++var4) {
//        String arg = var2[var4];
//        try {
//          Integer.valueOf(arg);// 18
//        } catch (Exception var24) {// 19
//          System.out.println("all arguments should be int");
//          System.out.println("example: java -jar ... 2 3");
//          System.out.printf("incorrect argument: %s\n", arg);
//          return;
//        }
//
//      }
//    }
    //System.out.println("Hello World");
    int random;//переменная задает рандомное время исполнения одного элемента
    int quantity = Integer.parseInt(args[0]); //колличество входящих строк
    int delayTime; //время задержки выполнения программы
    int count = 0;

    try {
      for (int i = 0; i < quantity + 1; i++) {
        if (args.length > 2) {
          random = ThreadLocalRandom.current().nextInt(1, args.length - 1);
          delayTime = Integer.parseInt(args[random]) * 1000;//время задержки исполнения прогр.
        } else {
          delayTime = Integer.parseInt(args[1]) * 1000;//время задержки исполнения прогр.
        }
        int percent = (count * 100) / quantity;//вычисление процента
        long time = timeLeft(percent);
        int seconds = (int) time % 60;
        long minutes = time / 60;
        long hour = (time / 60) / 60;

        updateProgress(percent, quantity, count, seconds, minutes, hour);
        count++;
        Thread.sleep(delayTime);

      }
    } catch (InterruptedException e) {
    }
  }
}
