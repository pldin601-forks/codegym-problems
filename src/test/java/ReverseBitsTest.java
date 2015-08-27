import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReverseBitsTest extends AbstractTest {

  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new ReverseBits().reverse(input);
      if (actual != expected) {
        assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };
  private int input;
  private int expected;

  public ReverseBitsTest(int input, int expected) {
    super("ReverseBits");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {0b00000000000000000000000000000001, 0b10000000000000000000000000000000},
        {0b10000000000000000000000000000001, 0b10000000000000000000000000000001},
        {0b10000000000000000000000000000011, 0b11000000000000000000000000000001},
        {0b00000000000000001111111111111111, 0b11111111111111110000000000000000},
        {0b00000000000000001000000000000000, 0b00000000000000010000000000000000},
        {0b11111111111111111111111111111111, 0b11111111111111111111111111111111},
        {0, 0},
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
        .append(input)
        .append(" (")
        .append(Common.toBinaryString(input))
        .append(")\nExpected: ")
        .append(expected)
        .toString();
  }
}
