package academy.kovalevskyi.codingbootcamp.week1.day1;

import java.util.Comparator;

/**Class sorting.*/

public class Sorting {

  /**GenericSort.*/
  public static <T> void sort(T[] target, Comparator<T> comparator) {
    if (target == null || comparator == null) {
      throw new NullPointerException();
    }
    for (int i = 0; i < target.length; i++) {
      for (int j = 0; j < target.length - 1; j++) {
        if (comparator.compare(target[j], target[j + 1]) > 0) {
          T temp = target[j];
          target[j] = target[j + 1];
          target[j + 1] = temp;
        }
      }
    }
  }

  /**GenericReverseSort.*/
  public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {
    if (target == null || comparator == null) {
      throw new NullPointerException();
    }
    for (int i = 0; i < target.length; i++) {
      for (int j = 0; j < target.length - 1; j++) {
        if (comparator.compare(target[j], target[j + 1]) < 0) {
          T temp = target[j];
          target[j] = target[j + 1];
          target[j + 1] = temp;
        }
      }
    }
  }
}
