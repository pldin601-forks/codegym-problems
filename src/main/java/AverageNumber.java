/*
public class AverageNumber {
  public int average(int a, int b) {
    if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    if (a < 0 && b < 0) {
      int acc = (a == Integer.MIN_VALUE || b == Integer.MIN_VALUE) ? 1 : 0;

      a = (a == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -a;
      b = (b == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -b;
      return -((a + b + acc) >>> 1);
    }
    return (a + b) >>> 1;
  }
}
*/

public class AverageNumber {
  public int average(int a, int b) {

    int average=0;

    if(a>(Integer.MAX_VALUE/2) && b>(Integer.MAX_VALUE/2)){
      int c = a/2;
      int g = c;
      int e = c;
      int o = c;
      int d = b/2;
      int t = d;
      int y = d;
      int v = d;

      int average1 = (c+g)/2;
      int average2 = (d+t)/2;
      int average3 = (e+o)/2;
      int average4 = (y+v)/2;

      average = average1 + average2 + average3 + average4;

    }else{
      average = (a+b)/2;
      System.out.println(average);
    }
    return average;
  }
}
