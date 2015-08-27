import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LonelyNumberTest extends AbstractTest {

  int[] input;
  int expected;

  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new LonelyNumber().find(input);
      if (Common.different(actual,expected)) {
        Common.assertEquals(error(String.valueOf(actual)), expected, input);
      }
    }
  };

  public LonelyNumberTest(int[] input, int expected) {
    super("LonelyNumber");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[] {0, 0, 0, 8, 0, 0}, 8},
        {new int[] {7, 7, 7, 7, 7, 5}, 5},
        {new int[] {7, 7, 7, 3, 7, 7, 5, 5, 5, 5, 5}, 3},
        {new int[] {-1, 7, -1, 7, 7, 8, -1, 7, 7, -1, 5, 5, -1, 5, 5, 5}, 8},
        {Common.repeatedRandomNumbers(50_000_001, 5, 50_000_007), 50_000_007},
    });
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
