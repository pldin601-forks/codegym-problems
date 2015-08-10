public class CountBits {
  public int count(int input) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      if ((input & (1<<i)) != 0) {
        res++;
      }
    }
    return res;
  }
}
