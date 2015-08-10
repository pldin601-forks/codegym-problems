import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class SetZeroTest extends AbstractTest {

  static Set<String> classes = new HashSet<>();

  static {
    classes.add("SetZero");
  }

  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new SetZero().set(input, index);
      if (expected != actual) {
        assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };
  private int input;
  private int index;
  private int expected;

  public SetZeroTest(int input, int index, int expected) {
    this.input = input;
    this.index = index;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {0b1, 1, 0},
        {0b11, 1, 0b10},
        {0b11, 2, 0b01},
        {0b11, 5, 0b11},
        {0b101, 2, 0b101},
        {0b101, 3, 0b001},
        {0b110101101, 8, 0b100101101},
        {0b11111111111111111111111111111111, 31, 0b10111111111111111111111111111111},
        {0b11111111111111111111111111111111, 32, 0b01111111111111111111111111111111},
        {0b01111111111111111111111111111111, 31, 0b00111111111111111111111111111111},
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
