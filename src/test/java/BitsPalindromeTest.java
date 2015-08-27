import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BitsPalindromeTest extends AbstractTest {

  int input;
  boolean expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      boolean actual = new BitsPalindrome().isPalindrome(input);
      if (actual != expected) {
        Assert.assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {0b10000000000000000000000000000001, true},
        {0b01000000000000000000000000000001, false},
        {0b00000000000000000000000000000001, false},
        {0b10000000000000000000000000000000, false},
        {0b00000000000000010000000000000000, false},
        {0b00000000000000001000000000000000, false},
        {0b0000000000000001_1000000000000000, true},
        {0b00000000000000000000000000000000, true},
        {0b10101010101010100101010101010101, true},
        {0b0101010101010101_1010101010101010, true},
        {0b11111111111111100111111111111111, true},
        {0b11111111111111111111111111111111, true},
    });
  }

  public BitsPalindromeTest(int input, boolean expected) {
    super("BitsPalindrome");
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
        .append(input)
        .append(" (")
        .append(Common.toBinaryString(input))
        .append(")\nExpected: ")
        .append(expected)
    .toString();
  }
}
