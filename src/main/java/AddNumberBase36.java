import java.util.HashMap;
import java.util.Map;

public class AddNumberBase36 {

  public String add(String a, String b) {
    a = a.toLowerCase();
    b = b.toLowerCase();
    Map<Character, Integer> digits = new HashMap<>();

    for (int i = 0; i <= 9; i++) {
      digits.put((char) ('0' + i), i);
    }
    for (char c = 'a'; c <= 'z'; c++) {
      digits.put(c, c-'a'+10);
    }

    StringBuilder res = new StringBuilder();
    int ai = a.length() - 1, bi = b.length() - 1;
    int acc = 0;

    while (ai >= 0 || bi >= 0) {
      int ad = (ai >= 0) ? digits.get(a.charAt(ai--)) : 0;
      int bd = (bi >= 0) ? digits.get(b.charAt(bi--)) : 0;
      int sum = ad + bd + acc;
      acc = sum/36;
      sum %= 36;
      char d = (sum < 10) ? (char)('0'+sum) : (char)('a' + (sum-10));
      res.append(d);
    }
    if (acc > 0) {
      res.append(acc);
    }
    return res.reverse().toString();
  }
}
