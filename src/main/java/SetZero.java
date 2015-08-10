public class SetZero {
  public int set(int input, int index) {
    int mask = ~(1<< (index-1));

    return input & mask;
  }
}
