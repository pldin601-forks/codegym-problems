public class AverageNumber {
  public int average(int a, int b) {
    if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    if (a < 0 && b < 0) {
      int acc = (a == Integer.MIN_VALUE || b == Integer.MIN_VALUE) ? 1 : 0;

      a = (a == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -a;
      b = (b == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -b;
      return -((a + b + acc) >>> 1);
    }
    return (a + b) >>> 1;
  }
}
