import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class SumDigitsTest extends AbstractTest {

  int input;
  int expected;
  Runnable task = new Runnable() {

    @Override
    public void run() {
      int actual = new SumDigits().sum(input);

      if (expected != actual) {
        String message = String
            .format("Input: %d,\nExpected: %d,\nActual: %d",
                input, expected, actual);
        assertEquals(Common.error(message), expected, actual);
      }
    }
  };

  public SumDigitsTest(int input, int expected) {
    super("SumDigits");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {123, 6},
        {1, 1},
        {91, 10},
        {2147483647, 46},
        {2000000000, 2},
        {-256, 13},
        {-2147483648, 47}
    });
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected String lastInput() {
    return new StringBuilder()
        .append("Timeout\nInput: ")
        .append(input)
        .toString();
  }

}
