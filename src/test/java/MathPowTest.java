import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MathPowTest extends AbstractTest {
  private static Set<String> classes = new HashSet<>();

  static {
    classes.add("MathPow");
  }

  int base;
  int exp;
  int expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new MathPow().pow(base, exp);
      if (actual != expected) {
        assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public MathPowTest(int base, int exp, int expected) {
    this.base = base;
    this.exp = exp;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {1, 1, 1},
        {3, 17, 129140163},
        {2, 30, 1073741824},
        {17, 7, 410338673},
        {1, Integer.MAX_VALUE, 1},
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
        .append(base)
        .append(", ")
        .append(exp)
        .append("\nExpected: ")
        .append(expected)
        .toString();
  }
}
