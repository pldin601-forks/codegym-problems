import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RunWith(Parameterized.class)
public class FindMaxNumberTest extends AbstractTest {

  static Set<String> classes = new HashSet<String>() {{
    add("FindMaxNumber");
  }};
  int[] input;
  int expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new FindMaxNumber().max(input);
      if (actual != expected) {
        Assert.assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public FindMaxNumberTest(int[] input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{1, 2, 5, 3}, 5},
        {new int[]{1, 2, -5, 3}, 3},
        {new int[]{-1, -2, -5, -3}, -1},
        {new int[]{Integer.MIN_VALUE}, Integer.MIN_VALUE},
        {new int[]{Integer.MAX_VALUE}, Integer.MAX_VALUE},
        {new int[]{20, Integer.MAX_VALUE, 10}, Integer.MAX_VALUE},
        {new int[]{0, 0, 0}, 0},
        {generate(1 << 25), (1 << 25) - 1}
    });
  }

  static int[] generate(int size) {
    int[] res = new int[size];
    for (int i = 0; i < res.length; i++) {
      res[i] = i;
    }
    return res;
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
        .append(Common.printArray(input))
        .append("\nExpected: ")
        .append(expected)
        .toString();
  }
}
