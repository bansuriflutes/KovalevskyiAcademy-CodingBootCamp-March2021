package academy.kovalevskyi.codingbootcamp.week2.day1;


/**
 *В данном задании м реализуем простую программу,
 * которая рисует прямоугольник в соответствии с заданнми параметрами.
 * Пример прямоугольника:
 * Программа принимает на вход 4 аргумента:
 * Ширина
 * Длина
 * Символ, которй должен бть использован в качестве уголка
 * Символ, которй должен бть использован в качестве сторон
 * Соответственно, чтоб получить ровно такой же прямоугольник как
 * на картинке, нужно передать следующее входне аргумент: 6 4 - #
 * Если количество аргументов не равно 4, то программа должна ввести:
 * Please provide 4 arguments, current amount: %d
 * где %d — текущее количество аргументов, переданное программе.
 * Например, если бло передано: “2 3”, то программа напишет:
 * Please provide 4 arguments, current amount: 2
 * В случае, если какой-либо входной аргумент имеет неверную длину
 * или тип, программа должна кинуть IllegalArgumentException.
 * Сигнатура метода:
 */
public class BoxGenerator {

  public static void main(String[] args) {

    if (args.length != 4) {
      System.out.println("Please provide 4 input arguments, current amount: " + args.length);
      return;
    }
    if (Integer.parseInt(args[0]) < 0
            || Integer.parseInt(args[1]) < 0
            || args[2].length() > 1
            || args[3].length() > 1
            || args[0] == null
            || args[1] == null) {
      throw new IllegalArgumentException();
    }
    if (Integer.parseInt(args[0]) == 0 || Integer.parseInt(args[1]) == 0) {
      return;
    }

    char ch = args[3].charAt(0);
    char angle = ch;
    char side = args[2].charAt(0);
    int width = Integer.parseInt(args[0]);
    int height = Integer.parseInt(args[1]);

    char[][] symbol = new char[height][width];
    fillArray(symbol, ' ');
    makeAngle(symbol, angle);
    makeSide(symbol, side);
    TextPrinter.arrayPrinter(symbol);
  }

  /**
  * Создаем метод которй устанавливет !РАЗНЕ! символ по углам.
  * метод имеет 3 параметра: 2-мернй массив символов
  * 2 переменнх типа char для углов
  */
  public static void makeAngle(char[][] symbol, char angle1, char angle2) {
    int width = symbol[0].length; //задаем ширину рамки в соответствии с длиной 1 строки
    int height = symbol.length; //задаем всоту рамки в соответствии с длинной массива
    symbol[0][0] = angle1; //устанавливаем левый верхний угол
    symbol[0][width - 1] = angle2; //устанавливаем верхний правый угол
    symbol[height - 1][0] = angle2; //устанавливаем левй нижний угол
    symbol[height - 1][width - 1] = angle1; //устанавливаем нижний правй угол
  }

  /**
  * Переопределяем метод которй устанавливет !ОДИНАКОВЕ! символ по углам.
  * метод имеет 2 параметра: 2-мернй массив символов
  * 1 переменную типа char для углов
  */
  public static void makeAngle(char[][] symbol, char angle) {
    makeAngle(symbol, angle, angle);
  }

  /**
  * Создаем метод которй устанавливет сторон.
  * метод имеет 2 параметра: 2-мернй массив символов
  * 1 переменную типа char для сторон
  */
  public static void makeSide(char [][] symbol, char side) {
    int width = symbol[0].length;
    int height = symbol.length;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (i == 0 || i == height - 1) {
          if (j != 0 && j != width - 1) {
            symbol[i][j] = side;
          }
        } else {
          if (j == 0 || j == width - 1) {
            symbol[i][j] = side;
          }
        }
      }
    }
  }

  public static void fillArray(char[][] symbol, char space) {
    for (int i = 0; i < symbol.length; i++) {
      for (int j = 0; j < symbol[i].length; j++) {
        symbol[i][j] = space;
      }
    }
  }


}




/*Вторая хардкорная реализация вложеннми циклами*/

//        for (int row = 0; row < height; row++) {
//            for (int column = 0; column < width; column++) {
//                if (row == 0 && column == 0
//                || column == width - 1 && row == 0 || row == height - 1 && column == 0 ||
//                        row == height - 1 && column == width - 1) {
//                    System.out.print(angle);
//                    continue;
//                }
//                if (row == 0 || column == 0 || row == height - 1 || column == width - 1) {
//                    System.out.print(side);
//                    continue;
//                } else {
//                    System.out.print(' ');
//                }
//            }
//            System.out.println();
//        }


/*Первая хардкорная реализация ифами*/
//        if (args.length != 4) {
//            System.out.println("Please provide 4 input arguments,
//            current amount: " + args.length);
//            return;
//        }
//
//        if (Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[1]) < 0
//        || args[2].length() > 1 || args[3].length() > 1 || args[0] == null || args[1] == null) {
//            throw new IllegalArgumentException();
//        }
//
//        if (Integer.parseInt(args[0]) == 0 || Integer.parseInt(args[1]) == 0) {
//            return;
//        }
//
//        int width = Integer.parseInt(args[0]);
//        int height = Integer.parseInt(args[1]);
//        int angle = args[3].charAt(0);
//        int side = args[2].charAt(0);
//
//        for (int row = 0; row < height; row++) {
//          for (int column = 0; column < width; column++) {
//            if (row == 0 && column == 0 || column == width - 1 && row == 0
//            || row == height - 1 && column == 0 || row == height - 1 && column == width - 1) {
//                System.out.print(angle);
//                continue;
//            }
//            if (row == 0 || column == 0 || row == height - 1 || column == width - 1) {
//                System.out.print(side);
//                continue;
//            } else {
//                System.out.print(' ');
//            }
//          }
//          System.out.println();
//        }


