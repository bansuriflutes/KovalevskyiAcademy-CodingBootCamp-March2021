package academy.kovalevskyi.codingbootcamp.week2.day2;

import java.util.concurrent.ThreadLocalRandom;

public class ProgressBar {
    //метод создает динамический прогрессбар с аргументами: процентного выполнения программы слева
    //и с права - число которое указывает колличество элементов, число указывающее колличество секунд
    // которе прогрессбар должен ожидать. ETA - (Estimated time of arrival) — ожидаемое время прибытия
    //таймер обратного отсчета - чч:мм:сс, указывает затраченное время на заполнение шкалы прогрессбара
  public static void updateProgress(int percent, int quantity, int count,
                                    int seconds, long minutes, long hour) {
    final int width = 100;//размер прогрессбара
    //возвращение каретки
    System.out.print("\r" + percent + " %" + " [");
    int i = 0;
    for (; i <= percent; i++) {
      System.out.print("=");//основное тело шкалы прогрессбара
    }
    System.out.print(">");//стрелка в конце прогрессбара

    for (; i <= width; i++) {
      System.out.print(" ");//пустое/не заполненное пространство перед пробрессбаром
    }
    //выводит таймер обратного отсчета, колличество элементов и время в секундах на один элемент
    System.out.print("] " + count + "/" + quantity + ", ETA: "
              +  String.format("%02d:%02d:%02d", hour, minutes, seconds));
    }

    //метод формирует и возвращает оставшееся время
    public static int timeLeft (int percent) {
      int time = (100 - percent);
      return time;
    }

//    public static void main(String[] args) {
////      String[] args1 = {"15", "1", "5", "2", "1", "1", "1"};
//  if (args.length < 2) {
//    System.out.println("Amount of arguments should be: at least 2");
//    System.out.println("example: java -jar ... 2 3");
//    return;
//  } else {
//    String[] var2 = args;
//    int var3 = args.length;
//
//    for (int var4 = 0; var4 < var3; ++var4) {
//      String arg = var2[var4];
//
//      try {
//        Integer.valueOf(arg);// 18
//      } catch (Exception var24) {// 19
//        System.out.println("all arguments should be int");// 20
//        System.out.println("example: java -jar ... 2 3");// 21
//        System.out.printf("incorrect argument: %s\n", arg);// 22
//        return;// 23
//      }
//
//    }
//  }
//
//      int random;//переменная задает рандомное время исполнения одного элемента
//      int quantity = Integer.parseInt(args[0]); //колличество входящих строк
//      int delayTime; //время задержки выполнения программы
//      int count = 0;
//      try {
//        for (int i = 0; i < quantity + 1; i++) {
//          if (args.length > 2) {
//            random = ThreadLocalRandom.current().nextInt(1, args.length - 1);
//            delayTime = Integer.parseInt(args[random]) * 1000;//время задержки исполнения прогр.
//          } else {
//            delayTime = Integer.parseInt(args[1]) * 1000;//время задержки исполнения прогр.
//          }
//          int percent = (count * 100) / quantity;//вычисление процента
//          long time = timeLeft(percent);
//          int seconds = (int) time % 60;
//          long minutes = time / 60;
//          long hour = (time / 60) / 60;
//
//          updateProgress(percent, quantity, count, seconds, minutes, hour);
//          count++;
//          Thread.sleep(delayTime);
//        }
//      }
//      catch (InterruptedException e) {}
//  }
}
