import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class entry_5407128 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    System.out.println(Arrays.stream(scanner.nextLine().split(" "))
                           .map(e -> Integer.valueOf(e))
                           .collect(Collectors.toList())
                           .stream()
                           .distinct()
                           .count());
  }
}