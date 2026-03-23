import java.util.*;
import java.io.*;

public class entry_5307710 {
    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 PrintWriter out = new PrintWriter(System.out);
 int n = scanner.nextInt();
 for (int i = 0; i < n; i++) {
     out.println(find(scanner.nextLong(), scanner.nextLong()));
 }
 out.flush();
    }

    private static long find(long y, long x) {
 long max = Math.max(y, x);
 long min = Math.min(y, x);
 long corner = (max * max - (max - 1));
 if (y == x) return corner;
 long diff = max - min;
 if (max % 2 == 0) {
     if (x < y) {
  return corner + diff;
     }
     else return corner - diff;
 } else {
     if (x < y) {
  return corner - diff;
     } else {
  return corner + diff;
     }
 }
    }
}