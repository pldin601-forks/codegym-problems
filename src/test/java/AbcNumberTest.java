import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AbcNumberTest extends AbstractTest {

  String input;
  int expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new AbcNumber().convert(input);
      if (actual != expected) {
        Common.assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public AbcNumberTest(String input, int expected) {
    super("AbcNumber");
    this.input = input;
    this.expected = expected;
  }

  //abcdefghij
  //0123456789
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"d", 3},
        {"abc", 12},
        {"bjij", 1989},
        {"hh", 77},
        {"aaaaaaaaaaaaaaaaaaaa", 0},
        {"hgb", 761},
        {"cbeheidgeh", 2147483647},
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
        .append(input)
        .append("\"\nExpected: ")
        .append(expected)
        .toString();
  }
}
