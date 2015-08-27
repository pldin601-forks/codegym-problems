import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class EncodingTest extends AbstractTest {

  byte[] input;
  byte[] expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      byte[] actual = new Encoding().encode(input);

      if (!Arrays.equals(actual, expected)) {
        String msg = Common.printBits(actual);
        assertArrayEquals(error(msg), expected, actual);
      }
    }
  };

  protected EncodingTest() {
    super("Encoding");
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected String lastInput() {
    return null;
  }
}
