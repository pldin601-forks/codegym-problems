import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MatrixSnakeTraversalTest extends AbstractTest {


  int[][] input;
  int[] expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int[] actual = new MatrixSnakeTraversal().print(input);
      if (!expected.equals(actual)) {
        Common.assertEquals(error(Common.printArray(actual)), expected, actual);
      }
    }
  };

  public MatrixSnakeTraversalTest(int[][] input, int[] expected) {
    super("MatrixSnakeTraversal");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[][]{
            {1, 2},
            {3, 4}
        }, new int[]{1, 3, 4, 2}},
        {new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12},
        }, new int[]{1, 4, 7, 10, 11, 8, 5, 2, 3, 6, 9, 12}},
        {new int[][]{{1}, {2}, {3}}, new int[]{1, 2, 3}},
        {new int[][]{{1, 2, 3}}, new int[]{1, 2, 3}},
    });
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected String lastInput() {
    StringBuilder buf = new StringBuilder().append("Input: ");
    Common.printMatrix(input, buf);
    buf.append("\nExpected: ");
    Common.printArray(expected, buf);

    return buf.toString();
  }
}
