import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CSVParserTest extends AbstractTest {

  String input;
  List<List<String>> expected;
  Runnable task = new Runnable() {
    @Override
    public void run() {
      List<List<String>> actual = new CSVParser().parse(input);
      Common.assertCondition(actual != null, error("null"));

      if (!expected.equals(actual)) {
        Common.fail(error(Common.print(actual.toString())));
      }
    }
  };

  public CSVParserTest(String input, List<List<String>> expected) {
    super("CSVParser");

    this.input = input;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"one,two", Common.list(Common.list("one", "two"))},
        {"one,two\nthree,", Common.list(Common.list("one", "two"), Common.list("three", ""))},
        {"one,\"tw\"o\"\nthree,", Common.list(Common.list("one", "tw\"o"), Common.list("three", ""))},
        {"one,\"tw\"o\"\n\"thr,ee\",", Common.list(Common.list("one", "tw\"o"), Common.list("thr,ee", ""))},
        {"\"o\nne\",\"tw\"o\"\n\"thr,ee\",", Common.list(Common.list("o\nne", "tw\"o"), Common.list("thr,ee", ""))},
        {"\"o\nne\",\"tw\"o\"\n\"thr,ee\",\"fo\"\"ur\"", Common.list(Common.list("o\nne", "tw\"o"), Common.list("thr,ee", "fo\"ur"))},
        {"one,two,\n,,\n,three,", Common.list(
            Common.list("one", "two", ""),
            Common.list("", "", ""),
            Common.list("", "three", ""))},
    });
  }

  @Override
  protected Runnable getTask() {
    return task;
  }

  @Override
  protected String lastInput() {
    return new StringBuilder()
        .append("Input: ")
        .append(Common.print(input))
        .append("\nExpected: ")
        .append(Common.print(expected.toString()))
        .toString();
  }
}
