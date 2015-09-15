import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FirstUniqueCharacterTest extends AbstractTest {

  String input;
  Character expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      Character actual = new FirstUniqueCharacter().find(input);
      if (expected == null && actual == null) return;

      if (actual == null && expected != null
          || actual != null && expected == null
          || !actual.equals(expected)) {

        assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public FirstUniqueCharacterTest(String input, Character expected) {
    super("FirstUniqueCharacter");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"a", 'a'},
        {"aa", null},
        {"abdcba", 'd'},
        {"abcdefghijklmnopqrstuvwxyzabcdfghijklmnpqrtuvwxyz", 'e'},
        {generateWithSingle(1<<20, 'w', 'z'), 'w'},
        {generateWithSingle(1<<20), null},
    });
  }

  static String generateWithSingle(int size, char... chars) {
    Set<Character> dictSet = new HashSet<>();
    for (int i = 0; i < 26; i++) {
      dictSet.add((char) ('a' + i));
    }
    for (char c : chars) {
      dictSet.remove(c);
    }
    List<Character> dict = new ArrayList<>(dictSet);
    StringBuilder buf = new StringBuilder(size);
    for (int i = 0; i < size - dict.size(); i++) {
      buf.append(dict.get(i % dict.size()));
    }
    for (char c : chars) {
      buf.append(c);
    }
    return buf.toString();
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected String lastInput() {
    return new StringBuilder()
        .append("Input: \"")
        .append(Common.print(input))
        .append("\"\nExpected: \"")
        .append(expected)
        .append('"')
        .toString();
  }
}
