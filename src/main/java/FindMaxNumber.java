public class FindMaxNumber {
  public int max(int[] input) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < input.length; i++) {
      if (max < input[i]) {
        max = input[i];
      }
    }
    return max;
  }
}
