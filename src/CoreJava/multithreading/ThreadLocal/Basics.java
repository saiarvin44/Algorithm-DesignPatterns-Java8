package CoreJava.multithreading.ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Basics {

  ThreadLocal<String> threadLocalSupplier =
      ThreadLocal.withInitial(() -> String.valueOf(System.currentTimeMillis()));

  private ThreadLocal threadLocal =
      new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
          return String.valueOf(System.currentTimeMillis());
        }
      };

  public static void main(String[] args) {
    ThreadLocal threadLocal = new ThreadLocal();
    threadLocal.set("Local thread value");
    String value = (String) threadLocal.get();
    System.out.print(value);
    threadLocal.remove();
  }
}

class MyDateFormatter {

  private ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<>();

  public String format(Date date) {
    SimpleDateFormat simpleDateFormat = getThreadLocalSimpleDateFormat();
    return simpleDateFormat.format(date);
  }

  private SimpleDateFormat getThreadLocalSimpleDateFormat() {
    SimpleDateFormat simpleDateFormat = simpleDateFormatThreadLocal.get();
    if (simpleDateFormat == null) {
      simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      simpleDateFormatThreadLocal.set(simpleDateFormat);
    }
    return simpleDateFormat;
  }
}
