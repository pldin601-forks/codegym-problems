public class JoinCharacters {
  public int join(char[] input) {
    int res = 0;
    for (int i = 0; i < input.length; i++) {
      res = res*10 + (input[i] - '0');
    }
    return res;
  }
}
