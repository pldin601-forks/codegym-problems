public class MathPow {
  public int pow(int base, int exp) {
    int res = base;

    for (int i = 1; i < exp; i++) {
      res*= base;
    }
    return res;
  }
}
