package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week0.day4.Numbers1;

public class Numbers2 extends Numbers1 {

  public static void main(String[] args) {
    generateTriplets();
  }

  public static char[][] generateTriplets() {
    long startTime = System.nanoTime();
    char[][] arr = new char [120][3];
    char[] source = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    int n = 0;

    for (int a = 0; a < 8; a++) {
      for (int b = a + 1; b < 9; b++) {
        for (int c = b + 1; c < 10; c++) {
          if (a == b || a == c  || b == c) {
            continue;
          } else {
            //int current = (a * 100) + (b * 10) + c;
            //if ((a != b && a != c  && b != c)
            //&& current < (c * 100 + b * 10 + a)
            //&& current < (c * 100 + a * 10 + b)
            //&& current < (b * 100 + c * 10 + a)
            //&& current < (b * 100 + a * 10 + c)
            //&& current < (a * 100 + c * 10 + b)  ) {
            arr[n++] = new char[] {source[a], source[b], source[c]};
          }
        }
      }
    }
    long endTime = System.nanoTime();
    System.out.println(endTime - startTime);
    return arr;
  }
}
