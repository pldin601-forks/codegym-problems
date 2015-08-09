import com.jayway.awaitility.core.ConditionTimeoutException;
import org.junit.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import static org.junit.Assert.fail;

public abstract class AbstractTest {

  @Test
  public void test() {
    try {
      await().atMost(1, TimeUnit.SECONDS).catchUncaughtExceptions().until(getTask());
    } catch (ConditionTimeoutException e) {

      String msg = e.toString();
      msg = Common.hasError(msg) ? msg : Common.error(msg);

      fail(msg);
    } catch (Throwable t) {
      //t.printStackTrace();
      StackTraceElement[] stackTrace = t.getStackTrace();
      Set<String> classes = getTestClasses();
      StringBuilder buf = new StringBuilder();

      buf.append(t.fillInStackTrace()).append('\n');

      for (StackTraceElement line : stackTrace) {
        if (classes.contains(line.getClassName())) {
          buf.append(line).append('\n');
        }
      }
      buf.append(lastInput());

      fail(Common.error(buf.toString()));
    }
  }

  protected abstract Runnable getTask();

  protected abstract Set<String> getTestClasses();

  protected abstract String lastInput();

  protected String error(String actual) {
    return new StringBuilder()
        .append(Common.START)
        .append(lastInput())
        .append("\nActual: \"")
        .append(actual)
        .append('"')
        .append(Common.END)
        .toString();
  }
}