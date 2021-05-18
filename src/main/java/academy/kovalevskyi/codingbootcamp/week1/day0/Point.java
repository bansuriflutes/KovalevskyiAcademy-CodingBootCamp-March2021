package academy.kovalevskyi.codingbootcamp.week1.day0;

/**Class Point.*/
public class Point implements Comparable<Point> {
  private final int coordinateX;
  private final int coordinateY;



  public Point(final int coordinateX, final int coordinateY) {
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }



  public int getX() {
    return coordinateX;
  }

  public int getY() {
    return coordinateY;
  }


  /**Point.*/
  public Point sum(final Point a) {
    int sumNewPointX = this.coordinateX + a.coordinateX;
    int sumNewPointY = this.coordinateY + a.coordinateY;
    Point newPoint = new Point(sumNewPointX, sumNewPointY);
    return newPoint;
  }

  /*updateX*/
  public Point updateX(int newX) {
    Point newCoordinateX = new Point(newX, this.coordinateY);
    return newCoordinateX;
  }

  /*updateY*/
  public Point updateY(int newY) {
    Point newCoordinateY = new Point(this.coordinateX, newY);
    return newCoordinateY;
  }

  /*distanceTo*/
  /**distanceTo.*/
  public int distanceTo(Point that) {
    int distanceX = (coordinateX - that.getX()) * (coordinateX - that.getX());
    int distanceY = (coordinateY - that.getY()) * (coordinateY - that.getY());
    int distanceBetween = distanceX + distanceY;
    return distanceBetween;
  }

  /*hashCode*/
  @Override
  public int hashCode() {
    return this.coordinateX + this.coordinateY;
  }

  /*equals*/
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || o.getClass() != this.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return this.coordinateX == point.coordinateX && this.coordinateY == point.coordinateY;
  }

  /*toString*/
  @Override
  public String toString() {
    return "Point{"
            +
           "X: " + coordinateX
            +
           ", Y: " + coordinateY
           +
           '}';
  }

  /* compareTo*/
  @Override
  public int compareTo(Point that) {
    return hashCode() - that.hashCode();
  }
}
