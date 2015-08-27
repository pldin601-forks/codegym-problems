public class BitsPalindrome {

  public static void main(String[] args) {
    new BitsPalindrome().isPalindrome(1431612074);
  }
  public boolean isPalindrome(int input) {

    for (int i = 0; i < 16; i++) {
      int mask = 1 << i;
      boolean check1 = (input & mask) != 0;
      int mask2 = 1 << (31 - i);
      boolean check2 = (input & mask2) != 0;
      if (check1 != check2) {
        return false;
      }

    }
    return true;
  }
}
