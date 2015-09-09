import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AddNumberBase36Test extends AbstractTest {

  String inputOne;
  String inputTwo;
  String expected;

  Runnable task = new Runnable() {
    @Override
    public void run() {
      String actual = new AddNumberBase36().add(inputOne, inputTwo);
      if (Common.different(expected, actual)) {
        Common.assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public AddNumberBase36Test(String inputOne, String inputTwo, String expected) {
    super("AddNumberBase36");
    this.inputOne = inputOne;
    this.inputTwo = inputTwo;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"9", "1", "a"},
        {"9", "1", "a"},
        {"A", "1", "b"},
        {"z", "1", "10"},
        {"10", "z", "1z"},
        {"10", "a0", "b0"},
        {"vjz5", "q3N", "wa2s"},
        {"zjfghfhdsdfathjjhgjhghjfjfjhjhdsrreqqklhu456hfz5", "wsfgsgds56346263fgfhghfghfhgfsrr5476hjfgdhdhg3N", "10g7vy7xrkildxnlpkvzwxy0uzwyyzx6kiwixx24xahmjyw2s"},
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
        .append(inputOne)
        .append("\", \"")
        .append(inputTwo)
        .append("\"\nExpected: \"")
        .append(expected)
        .append('"')
        .toString();
  }
}
