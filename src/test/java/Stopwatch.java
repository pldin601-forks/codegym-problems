public class Stopwatch {
  final long start;

  public Stopwatch() {
    start = System.nanoTime();
  }

  public long getTime() {
    long end = System.nanoTime();
    return end - start;
  }
}
