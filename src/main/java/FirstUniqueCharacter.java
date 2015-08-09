import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

  public Character find(String s) {
    Map<Character, Integer> chars = new LinkedHashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      Integer count = chars.get(c);
      chars.put(c, count == null ? 1: count + 1);
    }

    for (Character c : chars.keySet()) {
      if (chars.get(c) == 1) return c;
    }
    return null;
  }
}
