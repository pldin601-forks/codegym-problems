import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FibonacciHeapExtractMinTest extends AbstractTest {

  int[] input;
  int expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      FibonacciHeapExtractMin heap = new FibonacciHeapExtractMin();

      for (int num : input) {
        heap.insert(num);
      }

      heap.extractMin();

      FibNode minNode = heap.getMinNode();
      if (minNode == null) {
        Common.fail(error("getMinNode() returns null."));
      }
      int actual = minNode.getKey();

      if (actual != expected) {
        String str = minNode.printNode();
        Common.fail(error(String.valueOf(actual) + " " + str));
      }
    }
  };

  public FibonacciHeapExtractMinTest(int[] input, int expected) {
    super("FibonacciHeapExtractMin", "FibNode");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{1, 2}, 2},
        {new int[]{1, 2, 3}, 2}, // returns minKey() after minNode was extracted
        {new int[]{100, 2, 3}, 3},
        {new int[]{10, 20, 3, 4, 1, 9}, 3},
    });
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected String lastInput() {
    return new StringBuilder()
        .append("\n")
        .append("Input: insert() each ")
        .append(Common.printArray(input))
        .append(", then extractMin()")
        .append("\nExpected Min Key: ")
        .append(expected)
        .toString();

  }
}