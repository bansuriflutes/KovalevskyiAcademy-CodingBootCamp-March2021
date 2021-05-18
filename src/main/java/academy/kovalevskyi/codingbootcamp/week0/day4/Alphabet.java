package academy.kovalevskyi.codingbootcamp.week0.day4;

/**
 * {@summary Method's of this class generates and outputs the characters of the English alphabet}.
 * Here are some of its characteristics:
 * <ul>
 * <li>The method generateAlphabet does generate streight English alphabet.</li>
 * <li>The method generateReversedAlphabet does generate reversed English alphabet.</li>
 * </ul>
 */
public class Alphabet {
  /**
   * method generateAlphabet.
   */
  public static char[] generateAlphabet() {
    char[] ch = new char[26];
    for (int i = 0; i < ch.length; i++) {
      ch[i] = (char) (97 + i);
    }
    return ch;
  }

  /**
   * method generateReversedAlphabet.
   */
  public static char[] generateReversedAlphabet() {
    char[] revers = new char[26];
    for (int i = 0; i < revers.length; i++) {
      revers[i] = (char) (122 - i);
    }
    return revers;
  }
}



