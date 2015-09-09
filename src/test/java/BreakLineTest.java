import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BreakLineTest extends AbstractTest {

  String input;
  int width;
  String expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      String actual = new BreakLine().format(input, width);
      if (!actual.equals(expected)) {
        Common.assertEquals(error(Common.print(actual)), expected, actual);
      }
    }
  };

  public BreakLineTest(String input, int width, String expected) {
    super("BreakLine");
    this.expected = expected;
    this.width = width;
    this.input = input;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"", 5, ""},
        {"abc w", 5, "abc w"},
        {"abc ab c w", 5, "abc\nab c\nw"},
        {"a a b cdc w w q", 4, "a a\nb\ncdc\nw w\nq"},
        {"a abcd c w", 5, "a\nabcd\nc w"},
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
        .append("\", width:")
        .append(width)
        .append("\nExpected: \"")
        .append(Common.print(expected))
        .append('"')
        .toString();
  }
}
