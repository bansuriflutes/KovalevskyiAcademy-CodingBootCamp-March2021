package academy.kovalevskyi.codingbootcamp.week0.day4;

/**Numbers1.*/
public class Numbers1 {
  /**function.*/
  public static int[] generateNumbers() {
    int[] num = new int[100];
    for (int i = 0; i <= num.length - 1; i++) {
      num[i] = i;
    }
    return num;
  }

  //Этот метод принимает на вход два целых числа и возвращает  большее из них
  /**findBiggest.*/
  public static int findBiggest(int left, int right) {
    int max = 0;
    if (left > right) {
      max = left;
    } else {
      max = right;
    }
    return max;
  }

  /**Принимает 3 целых числа и возвращает наибольшее.*/
  public static int findBiggest(int left, int mid, int right) {
    int biggest = 0;
    if (left > mid & left > right) {
      biggest = left;
    } else if (mid > left & mid > right) {
      biggest = mid;
    } else {
      biggest = right;
    }
    return biggest;
  }

  /**Вернуть натибольшее число из массива.*/
  public static int findBiggest(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException();
    }
    int max = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max = numbers[i];
      }
    }
    return max;
  }

  /**Найти индекс наибольшего числа в массиве.*/
  public static int findIndexOfBiggestNumber(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException();
    }
    int maxIndex = 0;
    int maxNum = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > maxNum) {
        maxNum = numbers[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  /**Число отрицательное?.*/
  public static boolean isNegative(int number) {
    //if (number < 0) {
    //  return true;
    //} else {
    //  return false;
    //}
    return number < 0;
  }

  /**Принимает целое число, а возвращает массив символов, из которых
   * состоит это число, число может оказаться отрицательным.
   */
  public static char[] convertToCharArray(int number) {
    if (number == 0) {
      return new char[]{'0'};
      //char[] exception = new char[1];
      //exception[0] = '0';
      //throw new NullPointerException();
    }
    int length = 0;
    int fix = number;
    int y = 0;
    if (number < 0) {
      length = length + 1;
      number = number * (-1);
      y = 1;
    }

    while (number > 0) {
      number = number / 10;
      length++;
    }

    char[] result = new char[length];
    if (fix < 0) {
      fix *= -1;
      result[0] = '-';
    }
    for (int i = result.length - 1; i >= y; i--) {
      char tmp = (char) (fix % 10 + '0');
      result[i] = tmp;
      fix /= 10;
    }
    return result;
  }
}

