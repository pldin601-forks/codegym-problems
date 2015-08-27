public class Alphabet {
  public boolean check(String input) {
    boolean[] used = new boolean[26];
    int chars = 0;

    for (int i = 0; i < input.length() && chars <= 26; i++) {
      int indexLow = input.charAt(i) - 'a';
      int indexUpper = input.charAt(i) - 'A';

      if (indexLow >= 0 && indexLow < 26 && !used[indexLow]) {
        used[indexLow] = true;
        chars++;
        continue;
      }

      if (indexUpper >= 0 && indexUpper < 26 && !used[indexUpper]) {
        used[indexUpper] = true;
        chars++;
        continue;
      }
    }
    return chars == 26;
  }
}
