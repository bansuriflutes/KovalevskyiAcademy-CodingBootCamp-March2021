package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;

/**PointWithLabel.*/

public class PointWithLabel extends PointWithValue<String> {

  public PointWithLabel(int coordinateX, int coordinateY, String value) {
    super(coordinateX, coordinateY, value);
  }
  
  /**String.*/
  public String getLabel() {
    return super.getValue();
  }

  /**compareTo.*/
  public int compareTo(Point that) {
    if (that instanceof PointWithLabel) {
      return this.getLabel().compareTo(((PointWithLabel) that).getLabel());
    }
    return super.compareTo(that);
  }

}
