package academy.kovalevskyi.codingbootcamp.week1.day2;


import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import  java.util.stream.IntStream;

public class StringUtils {

  public static boolean myMethod(char ch) {
    if (ch < 0 || ch > 255) {
      return true;
    }
    return false;
  }

  //Написать метод isAsciiUppercase(char ch), который принимает
  // на вход char и возвращает true, если символ —
  // это буква от A до Z (верхний регистр) и false —
  // любой другой ASCII символ. Ожидается,
  // что метод кинет IllegalArgumentException,
  // если входящий символ не является ASCII символом.
  //Пример:
  //isAsciiUppercase('A'); // → true;
  //isAsciiUppercase('d'); // → false;
  //isAsciiUppercase((char)257); // → IllegalArgumentException
  public static boolean isAsciiUppercase(char ch) {
    if (myMethod(ch)) {
      throw new IllegalArgumentException();
    }
    if (ch >= 'A' && ch <= 'Z') {
      return true;
    }
    return  false;

  }

  //Написать метод isAsciiLowercase(char ch), который принимает на вход
  // char и возвращает true, если символ — это буква от a до z
  // (нижний регистр) и false — любой другой ASCII символ.
  // Ожидается, что метод кинет IllegalArgumentException,
  // если входящий символ не является ASCII символом.
  //Пример:
  //isAsciiLowercase('A'); // → false
  //isAsciiLowercase('d'); // → true
  //isAsciiLowercase((char)257); // → IllegalArgumentException
  public static boolean isAsciiLowercase(char ch) {
    if (myMethod(ch)) {
      throw new IllegalArgumentException();
    }
    if (ch >= 'a' && ch <= 'z') {
      return true;
    }
    return  false;
  }

  //Написать метод isAsciiNumeric(char ch), который принимает на вход
  // char и возвращает true, если символ — это цифра от 0 до 9 и false
  // — любой другой ASCII символ. Ожидается,
  // что метод кинет IllegalArgumentException,
  // если входящий символ не является ASCII символом.
  //Пример:
  //isAsciiNumeric('Z'); // → false
  //isAsciiNumeric('1'); // → true
  //isAsciiNumeric((char)257); // → IllegalArgumentException
  public static boolean isAsciiNumeric(char ch) {
    if (myMethod(ch)) {
      throw new IllegalArgumentException();
    }
    if (ch >= '0' && ch <= '9') {
      return true;
    }

    return  false;
  }

  //Написать метод isAsciiAlphabetic(char ch), который принимает на вход
  // char и возвращает true, если символ — это буква от a до z (
  // нижний регистр) или от A до Z (верхний регистр) и
  // false — любой другой ASCII символ. Ожидается,
  // что метод кинет IllegalArgumentException,
  // если входящий символ не является ASCII символом.
  //Пример:
  //isAsciiAlphabetic('Z'); // → true
  //isAsciiAlphabetic('a'); // → true
  //isAsciiAlphabetic('1'); // → false
  //isAsciiAlphabetic((char)257); // → IllegalArgumentException
  public static boolean isAsciiAlphabetic(char ch) {
    if (myMethod(ch)) {
      throw new IllegalArgumentException();
    }
    if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
      return true;
    }
    return false;
  }



  //Написать метод toAsciiUppercase(char ch), который принимает на вход
  // char и возвращает символ в верхнем регистре. Ожидается, что метод
  // кинет IllegalArgumentException, если входящий символ не является
  // ASCII символом.
  //Пример:
  //toAsciiUppercase('a'); // → 'A'
  //toAsciiUppercase('B'); // → 'B'
  //toAsciiUppercase('1'); // → '1'
  //toAsciiUppercase('@'); // → '@'
  //toAsciiUppercase((char)257); // → IllegalArgumentException
  public static char toAsciiUppercase(char ch) {
    if (myMethod(ch)) {
      throw new IllegalArgumentException();
    } else {
      if (isAsciiLowercase(ch)) {
        ch = (char) (ch - 32);
      }
    }
    return  ch;
  }

  //Написать метод toAsciiLowercase(char ch), который принимает на вход
  // char и возвращает символ в нижнем регистре. Ожидается,
  // что метод кинет IllegalArgumentException, если входящий символ не
  // является ASCII символом.
  //Пример:
  //toAsciiLowercase('a'); // → 'a'
  //toAsciiLowercase('B'); // → 'b'
  //toAsciiLowercase('1'); // → '1'
  //toAsciiLowercase('@'); // → '@'
  //toAsciiLowercase((char)257); // → IllegalArgumentException
  public static char toAsciiLowercase(char ch) {
    if (ch >= 0 && ch <= 255) {
      if (isAsciiUppercase(ch)) {
        ch = (char) (ch + 32);
      }
    } else {
      throw new IllegalArgumentException();
    }
    return  ch;
  }

  //Написать метод makeUppercase(char[] input), который принимает на вход
  // массив символов и возвращает строку символов в верхнем регистре.
  // Ожидается, что метод кинет IllegalArgumentException, если хоть один
  // из входящих символов не является ASCII.
  //Пример:
  //makeUppercase({'h', 'e', 'l', 'L', 'o'}); // → "HELLO"
  //makeUppercase({'@','h', 'e', 'l', 'L', 'o', '1', '2'}); // → "@HELLO12"
  //makeUppercase({'h', 'e', 'l', 'L', 'o', (char)257}); // → IllegalArgumentException
  public static StringBuilder makeUppercase(char[] input) {
    char res = ' ';
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      str.append(toAsciiUppercase(input[i]));
    }
    return str;
  }


  //Написать метод makeLowercase(char[] input), который принимает на вход
  // массив символов и возвращает строку символов в нижнем регистре.
  // Ожидается, что метод кинет IllegalArgumentException, если хоть один
  // из входящих символов не является ASCII.
  //Пример:
  //makeLowercase({'h', 'e', 'l', 'L', 'o'}); // → "hello"
  //makeLowercase({'@','h', 'e', 'l', 'L', 'o', '1', '2'}); // → "@hello12"
  //makeLowercase({'h', 'e', 'l', 'L', 'o', (char)257}); // → IllegalArgumentException
  public static StringBuilder makeLowercase(char[] input) {
    char res = ' ';
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      str.append(toAsciiLowercase(input[i]));
    }
    return str;
  }


  //Написать метод makeCamel(char[] input), который принимает на вход
  // массив символов и возвращает строку символов в нижнем и ВЕРХНЕМ
  // регистре последовательно (начиная с нижнего). Ожидается, что метод
  // кинет IllegalArgumentException, если хоть один из входящих символов
  // не является ASCII.
  //Пример:
  //makeCamel({'h', 'e', 'l', 'L', 'o'}); // → "hЕlLo"
  //makeCamel({'@','h', 'e', 'l', 'L', 'o', '0', '1', '2'}); // → "@HeLlO012"
  //makeCamel({'h', 'e', 'l', 'L', 'o', (char)257}); // → IllegalArgumentExcep tion
  public static StringBuilder makeCamel(char[] input) {
    StringBuilder str = new StringBuilder();
    char ch = ' ';
    for (int i = 0; i < input.length; i++) {

      if (input[i] < 0 || input[i] > 255) {
        throw new IllegalArgumentException(input[i] + ": Symbol is not ASCII");
      }
      if (i == 0) {
        if (input[i] >= 'a' && input[i] <= 'z' || input[i] >= 32 && input[i] <= 64
                || input[i] >= 97 && input[i] <= 127) {
          ch = input[i];
        }
        if (input[i] >= 'A' && input[i] <= 'Z') {
          ch = (char) (input[i] + 32);
        }
        str.append(ch);
      }
      if (i != 0) {
        if (i % 2 != 0) {
          if (input[i] >= 'A' && input[i] <= 'Z' || input[i] >= 32 && input[i] <= 64
                  || input[i] >= 97 && input[i] <= 127) {
            ch = input[i];
          }
          if (input[i] >= 'a' && input[i] <= 'z') {
            ch = (char) (input[i] - 32);
          }
          str.append(ch);
        } else {
          if (input[i] >= 'a' && input[i] <= 'z' || input[i] >= 32 && input[i] <= 64
                  || input[i] >= 97 && input[i] <= 127) {
            ch = input[i];
          }
          if (input[i] >= 'A' && input[i] <= 'Z') {
            ch = (char) (input[i] + 32);
          }
          str.append(ch);
        }
      }
    }
    return str;
  }

  //    char res = ' ';
  //    StringBuilder str = new StringBuilder();
  //    for (int i = 0; i < input.length; i++) {
  //      if (i == 0) {
  //        if (isAsciiLowercase(input[i])) {
  //          res = input[i];
  //        } else if (isAsciiUppercase(input[i])){
  //          res = toAsciiLowercase(input[i]);
  //        }
  //        str.append(res);
  //      }
  //      if (i != 0) {
  //        if (i % 2 != 0) {
  //          if (isAsciiUppercase(input[i])) {
  //            res = input[i];
  //          } else {
  //            res = toAsciiUppercase(input[i]);
  //          }
  //          str.append(res);
  //        }
  //        if (i % 2 == 0) {
  //          if (isAsciiLowercase(input[i])) {
  //            res = input[i];
  //          } else {
  //            res = toAsciiLowercase(input[i]);
  //          }
  //          str.append(res);
  //        }
  //      }
  //    }
  //    return str;


  //Написать метод isStringAlphaNumerical(char[] input), который принимает
  // на вход массив символов и возвращает true, если все символы —
  // это буквы или цифры, или пробелы. Ожидается, что метод кинет
  // IllegalArgumentException, если хоть один из входящих символов
  // не является ASCII.
  //Пример:
  //isStringAlphaNumerical({'a', 'b', '1', ' '}); // → true
  //isStringAlphaNumerical({'a', ',', '1', ' '}); // → false
  //isStringAlphaNumerical({'a', (char)257, '1', ' '}); // → IllegalArgumentException
  public static boolean isStringAlphaNumerical(char[] input) {

    int count = input.length;
    for (int i = 0; i < input.length; i++) {
      if (isAsciiAlphabetic(input[i]) || isAsciiNumeric(input[i]) || input[i] == ' ') {
        count--;
      }
    }
    if (count == 0) {
      return true;
    }
    return false;
  }

  //Написать метод concatStrings(char[][] input), который принимает на
  // вход двумерный массив символов, соединяет их и возвращает новый
  // одномерный результирующий массив. Ожидается, что метод кинет
  // IllegalArgumentException, если хоть один из входящих символов не
  // является ASCII.
  //Пример:
  //concatStrings({'a', 'b'}, {'c', 'd'}); // → {'a', 'b', 'c', 'd'}
  //concatStrings({'a', 'b', (char)257}, {'c', 'd'}); // → IllegalArgumentException
  public static char[] concatStrings(char[][] input) {
    char[] res = new char[0];
    String tmp = "";
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        res = new char[input.length * input[j].length];
        if (input[i][j] < 0 || input[i][j] > 255) {
          throw new IllegalArgumentException();
        }
        tmp += input[i][j];
      }
    }
    for (int k = 0; k < tmp.length(); k++) {
      res[k] = tmp.charAt(k);
    }
    return  res;
  }

  //Написать метод toInt(char[] input), который принимает на вход массив
  // символов и возвращает число int. Ожидается, что метод кинет
  // IllegalArgumentException, если хоть один из входящих символов
  // не является ASCII.
  //Пример:
  //toInt({'1', '2'}); // → 12
  //toInt({'0'}); // → 0
  //toInt({'-', '1', '1'}); // → -11
  //toInt({(char)257, '2'}); // → IllegalArgumentException
  public static int toInt(char[] input) {
    int res;
    String len = "";
    for (int i = 0; i < input.length; i++) {
      if (myMethod(input[i])) {
        throw new IllegalArgumentException();
      }
      len += input[i];


    }
    res = Integer.parseInt(len);
    return res;
  }
}
