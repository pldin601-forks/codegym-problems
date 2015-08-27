import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BSTSearchTest extends AbstractTest {

  static Integer[][] tree1 = {
      {10},
      {5, 15},
      {2, 7, null, 20},
      {1, 3, 6, 9, 19},
      {null, null, null, 4, null, null, 8, null, 16},
      {null, null, null, null, null, 18},
      {17}};
  TreeNode root;
  int target;
  boolean expected;

  Runnable task = new Runnable() {
    @Override
    public void run() {
      boolean actual = new BSTSearch().exist(root, target);

      if (actual != expected) {
        Common.assertEquals(error(String.valueOf(actual)), expected, actual);
      }
    }
  };

  public BSTSearchTest(TreeNode root, int target, boolean expected) {
    super("BSTSearch");
    this.root = root;
    this.target = target;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {

    return Arrays.asList(new Object[][]{
        {TreeNode.construct(new Integer[][]{}), 0, false},
        {TreeNode.construct(new Integer[][]{{0}}), 0, true},
        {TreeNode.construct(tree1), 8, true},
        {TreeNode.construct(tree1), 17, true},
        {TreeNode.construct(tree1), 21, false},
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
        .append(TreeNode.print(root))
        .append(", target: ")
        .append(target)
        .append("\nExpected: ")
        .append(expected)
        .toString();
  }
}
