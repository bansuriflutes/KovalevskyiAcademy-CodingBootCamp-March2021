package academy.kovalevskyi.codingbootcamp.week1.day1;

import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    PointWithValue<Integer> point1 = new PointWithValue<>(1, 2, 10);
    Function<Integer, String> convert = x -> String.valueOf(x) + " neighbours";
    System.out.println("Orignal Point: " + point1);
    System.out.println("New Mapped Point: " + point1.mapPoint(convert));
  }
}
