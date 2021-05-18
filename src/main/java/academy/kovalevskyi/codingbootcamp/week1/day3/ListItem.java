package academy.kovalevskyi.codingbootcamp.week1.day3;



public class ListItem<T> {
  private ListItem<T> prev = null;
  private ListItem<T> next = null;
  private T value;
  private ListItem<T> head = null;
  private ListItem<T> tail = null;

  public ListItem(ListItem<T> prev, ListItem<T> next, T value) {
    this.prev = prev;
    this.next = next;
    this.value = value;
  }

  public ListItem(ListItem<T> prev, ListItem<T> next, T value, ListItem<T> head, ListItem<T> tail) {
    this(prev, next, value);
    this.head = head;
    this.tail = tail;
  }

  //метод назначает текущей ноде предидущую
  public void setPrev(ListItem<T> prev) {
    this.prev = prev;

  }

  //метод назначает текущей ноде следующую
  public void setNext(ListItem<T> next) {
    this.next = next;
  }

  public ListItem<T> getTail() {
    return tail;
  }

  public void setTail(ListItem<T> tail) {
    this.tail = tail;
  }

  public ListItem<T> getHead() {
    return this.head;
  }

  public void setHead(ListItem<T> head) {
    this.head = head;
  }

  //возвращает следующую ноду
  public ListItem<T> getNext() {
    return this.next;
  }

  //возвращает предидущую ноду
  public ListItem<T> getPrev() {
    return this.prev;
  }

  //возвращает значение которое хранит в себе нода
  public T getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return "Node{prevValue="
            + this.prev.getValue()
            + ", nextValue="
            + this.next.getValue()
            + ", thisValue="
            + this.getValue()
            + "}";
  }

}
