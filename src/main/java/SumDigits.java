public class SumDigits {

  public int sum(int number) {
    int res = 0;
    while (number != 0) {
      res += number%10;
      number /= 10;
    }
    return Math.abs(res);
  }
}
