import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AlphabetTest extends AbstractTest {

  String input;
  boolean expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      boolean actual = new Alphabet().check(input);
      if (actual != expected) {
        Common.assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public AlphabetTest(String input, boolean expected) {
    super("Alphabet");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"", false},
        {"abcdefghijklmnopqrstuvwxyz", true},
        {"abcdeFghijKlmnopqrstuvwxyz", true},
        {"abcdefghijklmnopqrstuvwxyy", false},
        {"a1234   bcdefghi  jklmnopqrstuvwxyy", false},
        {"a1234   bcdefghi z jklmnopqrstuvwxy", true},
        {Common.generateFrom("abcdefghijklmnopqrstuvwxy", 1<<25), false},
        {Common.generateFrom("abcdefghijklmnopqrstuvwxyz", 1<<25), true},
    });
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
        .append("\"\nExpected: ")
        .append(expected)
        .toString();
  }
}
