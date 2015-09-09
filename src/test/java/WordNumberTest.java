import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class WordNumberTest extends AbstractTest {

  String input;
  int expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int actual = new WordNumber().count(input);
      if (actual != expected) {
        Common.assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public WordNumberTest(String input, int expected) {
    super("WordNumber");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"hi man", 2},
        {"", 0},
        {"... ... !", 0},
        {"red/green/blue", 3},
        {"hello. ...", 1},
        {"how AreYou?", 2},
        {"public int find(int num) { ", 5},
        {"one.two:three four\nfive(six)? ?:seven-eight", 8},
        {Common.generateSentence(1 << 20, 1 << 24), 1 << 20},
    });
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected String lastInput() {
    return new StringBuilder()
        .append("Input: [len: ")
        .append(input.length())
        .append("] \"")
        .append(Common.print(input))
        .append("\"\nExpected: ")
        .append(expected)
        .toString();
  }
}
