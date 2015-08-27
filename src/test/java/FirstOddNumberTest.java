import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FirstOddNumberTest extends AbstractTest {

  int[] input;
  int expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new FirstOddNumber().find(input);
      if (actual != expected) {
        assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{3}, 0},
        {new int[] {2, 4, 4, 6, 8, 9, 4, 1}, 5},
        {new int[] {4, 44, 4, 2, 8, 4}, -1},
        {new int[] {}, -1},
        {new int[] {2}, -1},
        {generateArray(1<<25), (1<<25)-1}
    });
  }

  static int[] generateArray(int size) {
    int[] res = new int[size];
    int mask = (~0) << 1;

    for (int i = 0; i < res.length-1; i++) {
      int num = (int)(1000_000*Math.random());
      num &= mask;
      res[i] = num;
    }
    res[res.length-1] = 1;
    return res;
  }

  public FirstOddNumberTest(int[] input, int expected) {
    super("FirstOddNumber");
    this.input = input;
    this.expected = expected;
  }

  @Override
  protected Runnable getTask() {
    return task;
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
