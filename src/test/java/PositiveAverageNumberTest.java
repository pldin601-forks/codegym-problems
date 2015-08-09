import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PositiveAverageNumberTest extends AbstractTest {

  static Set<String> classes = new HashSet<String>() {{
    add("PositiveAverageNumber");
  }};
  int firstArg, secondArg, expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new PositiveAverageNumber().average(firstArg, secondArg);
      if (actual != expected) {
        assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public PositiveAverageNumberTest(int firstArg, int secondArg, int expected) {
    this.firstArg = firstArg;
    this.secondArg = secondArg;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {4, 2, 3},
        {0, 0, 0},
        {1, 2, 1},
        {1 << 30, 1 << 30, 1 << 30},
        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
    });
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected Set<String> getTestClasses() {
    return classes;
  }

  @Override
  protected String lastInput() {
    return new StringBuilder()
        .append("Input: ")
        .append(firstArg)
        .append(", ")
        .append(secondArg)
        .append("\nExpected: ")
        .append(expected)
        .toString();
  }
}
