import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class JoinCharactersTest extends AbstractTest {

  static Set<String> classes = new HashSet<String>() {{
    add("JoinCharacters");
  }};
  char[] input;
  int expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new JoinCharacters().join(input);
      if (actual != expected) {
        assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new char[] {'1'}, 1},
        {new char[] {'0'}, 0},
        {new char[] {'1', '4', '2'}, 142},
        {new char[] {'0', '4', '2'}, 42},
        {new char[] {'0', '0', '0'}, 0},
        {new char[] {'2', '1', '4', '7', '4', '8', '3', '6', '4', '7'}, 2147483647},
    });
  }

  public JoinCharactersTest(char[] input, int expected) {
    this.input = input;
    this.expected = expected;
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
    StringBuilder buf = new StringBuilder()
        .append("Input: ");
    Common.printChars(input, buf);
    buf.append("\nExpected: ")
        .append(expected);

    return buf.toString();
  }
}
