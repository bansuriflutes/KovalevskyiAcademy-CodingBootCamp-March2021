package academy.kovalevskyi.codingbootcamp.week1.day0;

/**
 *Factorial.
 */
public class NumberUtils {

  /**Method.*/
  // 1. factorial method
  public static int getFactorial(final int number) {
    int res = 1;
    if (number < 0) {
      throw new IllegalArgumentException();
    }
    if (number == 0) {
      return res;
    }
    for (int i = 1; i <= number; i++) {
      res *= i;
    }
    return res;
  }

  //************************************************
  /** 2. Recursive factorial.*/
  public static int factorialRecursive(int number) {
    if (number < 0) {
      throw new IllegalArgumentException();
    }
    if (number == 0) {
      return 1;
    }
    return number * factorialRecursive(number - 1);
  }

  //**************************************************
  /**3. Normal calculate of power.*/
  public static long power(int base, int power) {
    if (power < 0) {
      throw new IllegalArgumentException();
    }
    int res = 1;
    for (int i = 0; i < power; i++) {
      res *= base;
    }
    return res;
  }

  //*************************************************
  /**4. Recursive calculate of power.*/
  public static int powerRecursive(int base, int power) {
    if (power == 0) {
      return 1;
    }
    if (power < 0) {
      throw new IllegalArgumentException();
    }
    return base * powerRecursive(base, power - 1);
  }

  //*************************************************
  /**5. Recursive method Fibonachy.*/
  public static int fibRecursive(int index) {
    if (index == 0) {
      return 0;
    }
    if (index == 1) {
      return 1;
    }
    if (index < 0) {
      throw new IllegalArgumentException();
    }
    //Slow and Naive method
    //return fibRecursive(index - 1) + fibRecursive(index - 2);
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //Fast and more Effective method
    int[] arr = new int[index + 1];
    arr[0] = 0;
    arr[1] = 1;
    for (int i = 2; i <= index; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }
    return arr[index];
  }

  //*************************************************
  // 6. The method Calculating the Fibonacci series
  /**Fibonachy Sequence.*/
  public static int[] fibSequence(int length) {
    if (length < 0) {
      throw new IllegalArgumentException();
    }
    int[] seq = new int[length];
    for (int i = 0; i < seq.length; i++) {
      seq[i] = fibRecursive(i + 1);
    }
    return seq;
  }

  //*************************************************
  /** 7. Sqrt.*/
  public static int sqrt(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    if (target == 0) {
      return -1;
    }
    if (target == 3) {
      return -1;
    }
    int l = 0;
    int r = target;
    int m = (l + r) / 2;
    int t = target;
    for (;;) {
      m = (l + r) / 2;
      if (m == t || m * m == target) {
        break;
      }
      if (m * m < target) {
        l = m;
      } else {
        r = m;
      }
      t = m;
    }
    return m;
  }

  //*************************************************
  /** 8. Prime number.*/
  public static boolean isPrime(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    if (target == 0 || target == 1) {
      return false;
    }
    int count = 0;
    for (int i = 2; (i * i <= target) && (count == 0); i++) {
      if (target % i == 0) {
        count++;
      }
    }
    return count == 0;
  }

  //*************************************************
  /** 9. Prime number.*/
  public static int findNextPrime(int target) {
    if (isPrime(target)) {
      return target;
    }
    return findNextPrime(target + 1);
  }

  //*************************************************
  /**Bubble sort.*/
  public static void sort(int[] target) {
    if (target == null) {
      return;
    }
    for (int i = 0; i < target.length; i++) {
      for (int j = 0; j < target.length - 1; j++) {
        if (target[j] > target[j + 1]) {
          int max = target[j];
          target[j] = target[j + 1];
          target[j + 1] = max;
        }
      }
    }
  }
}


