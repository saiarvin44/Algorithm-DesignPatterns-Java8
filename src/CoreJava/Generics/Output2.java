package CoreJava.Generics;

import java.util.Optional;

public class Output2 {
  Optional<String> bookName;

  public Output2(Optional<String> name) {
    bookName = name;
  }

  public static void main(String[] args) {
    Output2 nullBook = new Output2(Optional.ofNullable(null));
    Optional<String> name = nullBook.getName();
    // name.ifPresent(System.out::println).orElse("Empty");
  }

  public Optional<String> getName() {
    return bookName;
  }
}
