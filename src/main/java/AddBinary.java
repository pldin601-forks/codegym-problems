public class AddBinary {
  public String add(String a, String b) {
    StringBuilder res = new StringBuilder();

    int i = a.length() - 1;
    int j = b.length() - 1;
    int acc = 0;

    while (i >= 0 || j >= 0) {
      int da = i >= 0 ? a.charAt(i--) - '0' : 0;
      int db = j >= 0 ? b.charAt(j--) - '0' : 0;

      int sum = acc + da + db;
      if (sum == 0) {
        res.append('0');
      } else if (sum == 1) {
        res.append('1');
        acc = 0;
      } else if (sum == 2) {
        res.append('0');
        acc = 1;
      } else {
        res.append('1');
        acc = 1;
      }
    }
    if (acc == 1) {
      res.append('1');
    }
    return res.reverse().toString();
  }
}
