import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MatrixTraversalTest extends AbstractTest {

  int[][] input;
  int[] expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      int[] actual = new MatrixTraversal().print(input);
      if (!expected.equals(actual)) {
        Common.assertEquals(error(Common.printArray(actual)), expected, actual);
      }
    }
  };

  public MatrixTraversalTest(int[][] input, int[] expected) {
    super("MatrixTraversal");
    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[][]{{1}}, new int[]{1}},
        {new int[][]{{1, 2}, {3, 4}}, new int[]{1, 2, 4, 3}},
        {new int[][]{{}}, new int[]{}},
        {new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        }, new int[]{1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8}},
        {new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
        }, new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}},
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
        .append(Common.printMatrix(input))
        .append("\nExpected: ")
        .append(Common.printArray(expected))
        .toString();
  }
}
