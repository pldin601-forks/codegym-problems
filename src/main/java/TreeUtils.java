import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

  public static int findMaxHeight(RedBlackTree.Node root) {
    int res = 0;

    if (root != null) {
      List<RedBlackTree.Node> level = new ArrayList<>();
      level.add(root);

      while (!level.isEmpty()) {
        res++;
        List<RedBlackTree.Node> nextLevel = new ArrayList<>();
        for (RedBlackTree.Node node : level) {
          RedBlackTree.Node left = node.getLeft();
          RedBlackTree.Node right = node.getRight();
          if (left != null) {
            nextLevel.add(left);
          }
          if (right != null) {
            nextLevel.add(right);
          }
        }
        level = nextLevel;
      }
    }
    return res;
  }

  public static boolean isRBTree(RedBlackTree.Node root) {
    return false;
  }
}
