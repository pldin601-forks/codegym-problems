import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE);

    for (int i = 0; i < 26; i++) {
      System.out.print((char)('A'+i));
    }
    new TreeMap<String, Integer>(Collections.reverseOrder());
    new ArrayList<String>(new HashSet<String>());
  }

}
