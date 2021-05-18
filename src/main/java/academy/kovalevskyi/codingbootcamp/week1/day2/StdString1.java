package academy.kovalevskyi.codingbootcamp.week1.day2;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**StdString.*/

public class StdString1 implements Iterable<Character> {

  public char[] ch;

  //Создаем конструктор, который создает строку из
  // входного массива символов.
  public StdString1(char[] base) {
    ch = new char[base.length];
    for (int i = 0; i < base.length; i++) {
      ch[i] = base[i];
    }
  }

  //Пустой конструктор, который создает пустую строку
  // длиной 0
  public StdString1() {
    this(new char[0]);
  }

  //Конструктор, который создает копию входящей строки. 
  //Новая строка должна быть создана из точно таких же символов, как и входящая.
  public StdString1(StdString1 stdString1) {
    //char[] copy = new char[this.length()];
    //for (int i = 0; i < ch.length; i++) {
    //copy[i] = stdString1.ch[i];
    //}
    this(stdString1.ch);
  }

  //Написать метод, который возвращает количество символов в строке. 
  //Например, “cat ” вернет 3, “cat in the box” вернет 14.

  public int length() {

    return this.ch.length;
  }

  //Написать метод, который принимает строку, добавляет ее
  // к текущей строке и возвращает сформированную новую строку.
  // Например, если есть строка “cat” и другая строка “dog”,
  // ваш метод должен вернуть новую строку “catdog”.
  // Если на вход передают NULL, кинуть NullPointerException.
  public StdString1 append(StdString1 that) {
    if (that == null) {
      throw new NullPointerException();
    }
    int count = 0;
    char[] res = new char[that.length() + this.length()];
    for (int i = 0; i < this.length(); i++) {
      res[count] = this.ch[i];
      count++;
    }
    for (int i = 0; i < that.length(); i++) {
      res[count] = that.ch[i];
      count++;
    }
    return new StdString1(res);
  }

  //Написать метод, который возвращает массив символов из
  // текущей строки.
  public char[] toCharArray() {
    return this.ch;
  }

  //Написать метод, который возвращает символ по
  // определенному  индексу. Например, в строке “cat”,
  // на позиции “0” находится символ “с”, в строке “dog”,
  // на позиции “2” находится символ “g”,
  // а в строке “dogcat”, на позиции “7” нет символа —
  // indexOutOfBoundsException.
  public char charAt(int index) {
    if (index >= ch.length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    return this.ch[index];
  }
  
  //Написать метод, который находит первый нужный символ в
  // строке и возвращает его индекс. Если такого
  // символа нет, вернуть -1. Например, в строке “cat”
  // индекс символа  “t” →  2, в строке “dog” индекс
  // символа “c” → (-1),  а в строке “catanddog” индекс
  // символа “a” → 1.
  public int indexOf(char target) {
    for (int i = 0; i < this.length(); i++) {
      if (this.ch[i] == target) {
        return i;
      }
    }
    return -1;
  }

  //Написать метод, который  сравнивает каждый символ
  // текущей строки с каждым символом входящей строки.
  // Вернуть true, если строки равные и false, если нет.

  @Override
  public boolean equals(Object otherObj) {
    if (this == otherObj) {
      return true;
    }
    if (otherObj == null || getClass() != otherObj.getClass()) {
      return false;
    }
    StdString1 that = (StdString1) otherObj;
    return Arrays.equals(ch, that.ch);
  }

  //Написать мд, который возвращает хеш код строки.
  // Хеш код подсчитывается путем суммирования целочисленных представлений
  // каждого символа в строке.
  // “Cat” → C: 67 a: 97 t: 116 → 67 + 97 + 116 = 280. Если строка нулевой
  // длины — вернуть 0.
  @Override
  public int hashCode() {
    int sum = 0;
    for (char c : this) {
      sum += c;
    }
    return sum;
  }

  // Написать метод, который конвертирует объект StdString1 в объект String.
  // Тут позволено использовать java.lang.String.
  @Override
  public String toString() {
    return new String(this.ch);
  }


  //Написать метод iterator(), который работает точно так же,
  // как и оригинальный Iterator из документации
  // (придется импортировать этот интерфейс и класс исключение).
  @Override
  public Iterator<Character> iterator() {
    return new Iterator<>() {
      int count = 0;
      @Override
      public boolean hasNext() {
        return count < ch.length;
      }

      @Override
      public Character next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return ch[count++];
      }
    };
  }

  //Написать метод forEach(), который проходит по каждому
  // символу в строке и применяет к нему action.
  // Тут тоже придется импортировать один интерфейс
  @Override
  public void forEach(final Consumer<? super Character> action) {
    if (action == null) {
      throw new NullPointerException();
    }
    for (char index : this) {
      action.accept(index);
    }

  }

}
