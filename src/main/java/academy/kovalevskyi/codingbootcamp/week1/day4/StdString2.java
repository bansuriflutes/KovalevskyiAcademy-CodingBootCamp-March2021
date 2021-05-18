package academy.kovalevskyi.codingbootcamp.week1.day4;

import academy.kovalevskyi.codingbootcamp.week1.day2.StdString1;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;


public class StdString2 extends StdString1 {
  
  //chr[] chr;
  //Конструктор, который создает новую строку на базе переданного
  //масива символов
  public StdString2(char[] base) {
  //chr = new char[base.length];//for (int i = 0; i < base.length; i++) {
  //chr[i] = base[i];
  //}
    super(base);
  }

  //Пустой конструктор, который создает пустую строку
  public StdString2() {
    this(new char[0]);
  }

  //Конструктор, который создает копию входящей строки.
  public StdString2(StdString2 that) {
    super(that);
  }


  //public static boolean myMethod(char[] ch) {
  //ch = new char[ch.length];
  //for (int i = 0; i <= 255; i++) {
  //if (ch[i] < 0 || ch[i] > 255) {
  //return true;
  //}
  //}
  //return false;
  //}

  //Создает копию строки, в которй все символы нижнего регистра:
  //CaT12 -> cat12
  //Если символ не ASCII, то метод должен кинуть исключение IllegalArgumentException
  public StdString2 toAsciiLowerCase() {
    return new StdString2(StringUtils.makeLowercase
            (this.toCharArray()).toString().toCharArray());
  }

  //Создает копию строки, в которй все символы верхнего регистра:
  //CaT12 -> CAT12
  //Если символ не ASCII, то метод должен кинуть исключение IllegalArgumentException
  public StdString2 toAsciiUpperCase() {
    return new StdString2(StringUtils.
            makeUppercase(this.toCharArray()).toString().toCharArray());
  }

  //Возвращает подстроку, начиная с заданного индекса (включительно)
  //по заданный индекс (не включительно).
  public StdString2 subString(int from, int to) {
    if (from > to) {
      throw new IllegalArgumentException();
    }
    char[] tmp = new char[to - from];
    for (int i = from, count = 0; i < to; i++, count++) {
      tmp[count] = this.charAt(i);
    }
    return new StdString2(tmp);
  }


  //Метод создает новую строку, в которую входят все символы
  // текущей строки, а также все символы каждой строки, которая
  // была передана на вход
  public StdString2 concat(StdString2... that) {
    if (this == null) {
      throw new NullPointerException();
    }
    StringBuilder strb = new StringBuilder();
    strb.append(this.toCharArray());
    for (int i = 0; i < that.length; i++) {
      if (that[i] == null) {
        throw new NullPointerException();
      }
      strb.append(that[i].toCharArray());
    }
    char[] chr = new char[strb.length()];
    //StdString2 str = new StdString2(new char[strb.length()]);
    strb.getChars(0, strb.length(), chr, 0);
    return new StdString2(chr);
  }

  //Метод создает новую строку, которая похожа на текущую
  // но только без пробелов в начале и в конце строки
  // если они там вообще есть
  public StdString2 trim() {
    if (this.length() == 0) {
      return this;
    }
    int spaceLeft = 0;
    int spaceRight = 0;
    //define spaces on the left
    for (int i = 0; this.ch[i] == ' '; i++) {
      spaceLeft = i;
    }
    //define spaces on the right
    for (int i = this.length() - 1; this.ch[i] == ' '; i--) {
      spaceRight = i;
    }
    if (spaceLeft == 0 && spaceRight == 0) {
      return this;
    }
    return this.subString(spaceLeft + 1, spaceRight);
  }

  //Метод создает новую строку, которая равна текущей,
  //однако без определенного символа, который передан
  //на вход:
  //"new,1,2,3" ',' -> "new123"
  //"  1  2 ", ' ' -> "12"
  //"asdf123", '!' -> "asdf123"

  public StdString2 removeCharacter(char toRemove) {
    if (this.length() == 0) {
      return this;
    }
    //высчитываем колличество символов для удаления
    int count = 0;
    for (int i = 0; i < this.length(); i++) {
      count = (this.ch[i] == toRemove) ? ++count : count;
    }
    //создаем массив необходимой длины
    char[] res = new char[this.length() - count];
    //наполняем массив символами
    for (int i = 0, tempCount = 0; i < this.length(); i++) {
      if (this.ch[i] != toRemove) {
        res[tempCount++] = this.ch[i];
      }
    }
    return new StdString2(res);
  }


}
