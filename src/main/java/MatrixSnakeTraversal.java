public class MatrixSnakeTraversal {
  public int[] print(int[][] input) {
    int[] out = new int[input.length*input[0].length];
    int k = 0;

    for (int j = 0; j < input[0].length; j++) {
      if (j % 2 == 0) {
        for (int i = 0; i < input.length; i++) {
          out[k++] = input[i][j];
        }
      } else {
        for (int i = input.length-1; i >= 0; i--) {
          out[k++] = input[i][j];
        }
      }



    }
    return out;
  }
}