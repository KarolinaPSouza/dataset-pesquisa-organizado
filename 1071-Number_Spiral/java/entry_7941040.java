import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class entry_7941040 {
 public static void main(String[] args) throws IOException {
  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  int t = Integer.parseInt(bufferedReader.readLine().trim());
  while (t-- > 0) {
   String[] input = bufferedReader.readLine().split(" ");
   value(Long.parseLong(input[0]), Long.parseLong(input[1]));
  }
  System.out.println();
  bufferedReader.close();
 }

 private static void value(long x, long y) {
  long val;
  if (y > x) {
   val = y % 2 == 0 ? ((y - 1) * (y - 1)) + 1 + (x - 1) : (y * y) - (x - 1);
  } else {
            val = x % 2 == 0 ? ((x - 1) * (x - 1)) + 1 +(x - 1) + (x - y) : (x * x) - (x - 1) - (x - y);
        }
  System.out.println(val);
 }
}