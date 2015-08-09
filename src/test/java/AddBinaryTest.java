import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AddBinaryTest extends AbstractTest {

  final static String bits65K = generateBits(16);
  final static String bits1M = generateBits(20);
  String firstArg;
  String secondArg;
  String expectedResult;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      String actual = new AddBinary().add(firstArg, secondArg);

      if (!expectedResult.equals(actual)) {
        String message = format(
            "Input: [\"%s\", \"%s\"],\n Expected: \"%s\",\n Actual: \"%s\"",
            firstArg, secondArg, expectedResult, actual);
        message = Common.error(message);
        assertEquals(message, expectedResult, actual);
      }
    }
  };

  public AddBinaryTest(
      String firstArg,
      String secondArg,
      String expectedResult) {

    this.firstArg = firstArg;
    this.secondArg = secondArg;
    this.expectedResult = expectedResult;
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
  protected Set<String> getTestClasses() {
    Set<String> classes = new HashSet<>();
    classes.add("AddBinary");
    return classes;
  }

  @Override
  protected String lastInput() {
    return new StringBuilder()
        .append("TimeOutError\nInput: \"")
        .append(firstArg).append("\", \"")
        .append(secondArg).append("\"")
        .toString();
  }
}
