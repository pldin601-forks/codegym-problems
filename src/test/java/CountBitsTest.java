import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountBitsTest extends AbstractTest {

  static Set<String> classes = new HashSet<>();

  static {
    classes.add("CountBits");
  }

  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new CountBits().count(input);
      if (actual != expected) {
        assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };
  private int input;
  private int expected;

  public CountBitsTest(int input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {0, 0},
        {1, 1},
        {0b10, 1},
        {0b11, 2},
        {0b10101, 3},
        {0b01111111111111111111111111111111, 31},
        {0b01000000000000000001000000001001, 4},
        {0b10000000000000000000000000000001, 2},
        {0b10000000000000000000000000001001, 3},
        {0b11111111111111111111111111111111, 32},
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
        .append(input)
        .append("\nExpected: ")
        .append(expected)
        .toString();
  }
}
