public class ReverseBits {
  public int reverse(int input) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      if ((input & (1<< (31-i))) != 0) {
        res |= 1<< i;
      }
    }
    return res;
  }
}
