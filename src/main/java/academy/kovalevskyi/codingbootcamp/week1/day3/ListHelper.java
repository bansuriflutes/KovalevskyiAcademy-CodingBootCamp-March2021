package academy.kovalevskyi.codingbootcamp.week1.day3;

import java.util.List;
import java.util.function.Function;

public class ListHelper {

  public static <T> int length(ListItem<T> someItem) {
    int size = 0;
    ListItem<T> newList = someItem;
    //перемещается в начало листа
    while (newList.getPrev() != null) {
      newList = newList.getPrev();
    }
    // с начала считает длину листа до конца
    while (newList.getNext() != null) {
      newList = newList.getNext();
      size++;
    }
    return  ++size;
  }

  //Создает новый объект со значением value
  public static <T> ListItem<T> createOne(T value) {
    ListItem<T> newValue = new ListItem<>(null, null, value);
    newValue.setHead(newValue);
    newValue.setTail(newValue);
    return newValue;
  }

  //этот метод создает ноdую ноду на основе вход. значения, добавляет ее в конец списка,
  // к которому принадлежит входящая нода
  public static <T> ListItem<T> addToEnd(ListItem<T> someItem, T newValue) {
    //создаем копию входящего листа
    ListItem<T> newList = someItem;
    //создаем новую ноду
    ListItem<T> newNode = createOne(newValue);
    //итерируем условный лист чтобы найти последний элемемнт
    while (newList.getNext() != null) {
      newList = newList.getNext();
    }
    //указатель некст последней ноды нацеливаем на новую ноду
    newNode.setPrev(newList);
    //приклепляем новую ноду к последнему элементу листа/ноды
    newList.setNext(newNode);
    return newNode;
  }

  //этот метод создает ноdую ноду на основе вход. значения, добавляет ее в начало списка,
  // к которому принадлежит входящая нода
  public static <T> ListItem<T> addToStart(ListItem<T> someItem, T newValue) {
    //создаем копию входящего листа
    ListItem<T> newList = someItem;
    //создаем новую ноду
    ListItem<T> newNode = createOne(newValue);
    //итерируем условный лист чтобы найти последний элемемнт
    while (newList.getPrev() != null) {
      newList = newList.getPrev();
    }
    //указатель некст последней ноды нацеливаем на новую ноду
    newNode.setNext(newList);
    //приклепляем новую ноду к последнему элементу листа/ноды
    newList.setPrev(newNode);
    return newNode;
  }

  public static <T> boolean contains(ListItem<T> someItem, T value) {
    ListItem<T> newList = someItem;
    while (newList.getPrev() != null) {
      if (newList.getPrev().getValue().equals(value)) {
        return true;
      }
      newList = newList.getPrev();
    }
    while (newList.getNext() != null) {
      if (newList.getNext().getValue().equals(value)) {
        return true;
      }
      newList = newList.getNext();
    }
    return false;
  }

  //метод принимает на вход:
  //-ноду, которая может быть как связана с другими так и не связана;
  //-функцию
  //Метод применяет к value, каждой ноды в цепочке, функцию.
  //Что эта функция делает - неизвестно
  //Результатом работы метода map() должна стать новая цепочка нод,
  // над значениями которых поработала входящая функция.
  // Возможно придется почитать про функциональный интерфейс Function<T, R>
  public static <T, R> ListItem<R> map(ListItem<T> someItem, Function<T, R> mapFunction) {
    ListItem<T> newNode = someItem;
    while (newNode.getPrev() != null) {
      newNode = newNode.getPrev();
    }
    //заносим значение в 1 индекс
    //ListItem<R> newListR = new ListItem<>(null, null, mapFunction.apply(newNode.getValue()));
    ListItem<R> newListR = createOne(mapFunction.apply(newNode.getValue()));
    //сдвигаем каретку на 2 индекс чтобы продолжить дальнейшее преобразование value
    newNode = newNode.getNext();
    while (newNode.getNext() != null) {
      //записываем результат mapFunction в пременную newValue
      R newValue = mapFunction.apply(newNode.getValue());
      addToEnd(newListR, newValue);
      newNode = newNode.getNext();

    }
    return addToEnd(newListR, mapFunction.apply(newNode.getValue()));

  }

  //Связывает текущий элемент листа с входящим to
  public static <T> void connect(ListItem<T> someItem, ListItem<T> to) {
    someItem.setNext(to);
    to.setPrev(someItem);
  }

  //Возвращает этот метод новосозданную ноду
  public static <T> ListItem<T> insertAfter(ListItem<T> prev, T newValue) {
    ListItem<T> thisList = prev;
    ListItem<T> thisNext = thisList.getNext();
    ListItem<T> newList = createOne(newValue);
    thisList.setNext(newList);
    newList.setPrev(thisList);
    newList.setNext(thisNext);
    if (thisNext != null) {
      thisNext.setPrev(newList);
    }
    return newList;
  }

  public static <T> void insertAfter(ListItem<T> prev, T[] newValue) {
    for (int i = 0; i < newValue.length; i++) {
      prev = insertAfter(prev, newValue[i]);
    }
  }

  //Удаляет текущий элемент листа, отделяя его от остальных элементов списка
  public static <T> void delete(ListItem<T> current) {
    if (current.getPrev() == null) {
      current.getNext().setPrev(null);
      return;
    }
    if (current.getNext() == null) {
      current.getPrev().setNext(null);
      return;
    }
    current.getPrev().setNext(current.getNext());
    current.getNext().setPrev(current.getPrev());
  }
}
