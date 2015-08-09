import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinaryHeapTest extends AbstractTest {

  Runnable task = new Runnable() {

    @Override
    public void run() {
      BinaryHeap heap = new BinaryHeap(size);

      for (int i = 0; i < size; i++) {
        heap.insert(i);
      }

      for (int i = size - 1; i >= 0; i--) {

        int actual = heap.poll();

        if (i != actual) {
          assertEquals(error(String.valueOf(actual)), i, actual);
        }
      }
    }
  };
  private int size;

  public BinaryHeapTest(int size) {
    this.size = size;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {1 << 1},
        {1 << 2}, {1 << 3}, {1 << 5}, {1 << 10},
        {1 << 15}, {1 << 16}, {1 << 17}, {1 << 18}
    });
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected String lastInput() {
    return new StringBuffer()
        .append("BinaryHeap(")
        .append(size)
        .append(")\nInput: insert(0 .. ")
        .append(size)
        .append(") poll() all")
        .toString();
  }

  @Override
  protected Set<String> getTestClasses() {
    Set<String> classes = new HashSet<>();
    classes.add("BinaryHeap");
    return classes;
  }
}
