public class AbcNumber {
  public int convert(String num) {
    int res = 0;
    for (int i = 0; i < num.length(); i++) {
      res = res*10 + (num.charAt(i) - 'a');
    }
    return res;
  }
}
