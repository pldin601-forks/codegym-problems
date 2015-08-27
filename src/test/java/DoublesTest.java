import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DoublesTest extends AbstractTest {

  String input;
  Double expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      Double actual = new Doubles().parse(input);
      if (actual == null && expected == null) {
        return;
      }
      if (actual == null
          || expected == null
          || Math.abs(expected - actual) > delta) {
        assertEquals(error(String.valueOf(actual)), expected, actual, delta);
      }
    }
  };
  private double delta = 0.000001d;

  public DoublesTest(String input, Double expected) {
    super("Doubles");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"1", 1d},
        {"-1", -1d},
        {"-2.3", -2.3d},
        {"-0.", 0d},
        {"-.0", 0d},
        {"-.", null},
        {".e10", null},
        {"2.", 2d},
        {"2.e2", 2e2d},
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
        .append("\"Expected: \"")
        .append(expected)
        .append('"')
        .toString();
  }
}
