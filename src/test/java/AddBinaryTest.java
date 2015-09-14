import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AddBinaryTest extends AbstractTest {

  final static String bits65K = generateBits(16);
  final static String bits1M = generateBits(20);
  String firstArg;
  String secondArg;
  String expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      String actual = new AddBinary().add(firstArg, secondArg);

      if (!expected.equals(actual)) {
        Common.assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public AddBinaryTest(
      String firstArg,
      String secondArg,
      String expected) {
    super("AddBinary");
    this.firstArg = firstArg;
    this.secondArg = secondArg;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"0", "0", "0"},
        {"0", "1", "1"},
        {"1", "0", "1"},
        {"1", "1", "10"},
        {"1", "11", "100"},
        {"101", "100", "1001"},
        {"1111111111111111111111111111111",
            "1111111111111111111111111111111",
            "11111111111111111111111111111110"},
        {"10000000000000000000000000000000",
            "10000000000000000000000000000000",
            "100000000000000000000000000000000"},
        {bits65K, bits65K, bits65K + '0'},
        {bits1M, bits1M, bits1M + '0'},
    });
  }

  static String generateBits(int size) {
    StringBuilder buf = new StringBuilder(1 << size).append('1');

    for (int i = 0; i < size; i++) {
      buf.append(buf);
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
        .append(firstArg).append("\", \"")
        .append(secondArg).append("\"")
        .append("\nExpected: \"")
        .append(expected)
        .append('"')
        .toString();
  }
}
