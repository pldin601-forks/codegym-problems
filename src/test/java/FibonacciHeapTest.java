import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FibonacciHeapTest extends AbstractTest {

  int[] input;
  int expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      FibonacciHeap heap = new FibonacciHeap();

      for (int num : input) {
        heap.insert(num);
      }

      int actual = heap.min();
      if (actual != expected) {
        String str = heap.print();
        Common.fail(error(String.valueOf(actual) + str));

      }
    }
  };

  public FibonacciHeapTest(int[] input, int expected) {
    super("FibonacciHeap");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[] {1, 2, 3}, 1},
        {new int[] {100, 2, 3}, 2},
        {new int[] {10, 20, 3}, 3},
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
        .append(Common.printArray(input))
        .append("\nExpected: ")
        .append(expected)
        .toString();
  }
}
