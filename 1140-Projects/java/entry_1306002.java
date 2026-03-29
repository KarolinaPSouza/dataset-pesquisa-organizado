import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class entry_1306002 {

 public static void main(String[] args) {
  Task task = new Task();
  task.solve();
 }

 public static class Task {
  static final long MOD = (long) 1e9 + 7;

  public void solve() {
   Scan sc = new Scan();
   int n = (int) sc.scanLong();
   Triplet[] arr = new Triplet[n + 1];
   arr[0] = new Triplet(0, 0, 0);
   for (int i = 1; i <= n; ++i) {
    arr[i] = new Triplet((int) sc.scanLong(), (int) sc.scanLong(), sc.scanLong());
   }
   Arrays.sort(arr);
   long curr_res = 0;
   long[] max = new long[n + 1];
   long res = 0;
   for (int i = 1; i <= n; ++i) {
    Triplet curr = arr[i];
    int startTime = curr.a;
    // bsearch here
    int left = 0;
    int right = i;
    while (left < right) {
     int mid = left + (right - left) / 2;
     Triplet midVal = arr[mid];
     if (midVal.b < startTime)
      left = mid + 1;
     else
      right = mid;
    }
    curr_res = max[left - 1] + curr.cost;
    max[i] = Math.max(curr_res, max[i - 1]);
    res = curr_res > res ? curr_res : res;
   }
   System.out.println(res);
  }

  private class Triplet implements Comparable<Triplet> {
   int a, b;
   long cost;

   Triplet(int a, int b, long cost) {
    this.a = a;
    this.b = b;
    this.cost = cost;
   }

   @Override
   public int compareTo(Triplet other) {
    if (this.b < other.b)
     return -1;
    if (this.b > other.b)
     return 1;
    if (this.a < other.a)
     return -1;
    if (this.a > other.a)
     return 1;
    if (this.cost < other.cost)
     return -1;
    if (this.cost > other.cost)
     return 1;
    return 0;
   }

   public String toString() {
    return "[" + a + "," + b + "," + cost + "]";
   }
  }
 }

 public static class Scan {
  private byte[] buf = new byte[1024];
  private int index;
  private InputStream in;
  private int total;

  public Scan() {
   in = System.in;
  }

  public int scan() {
   if (total < 0)
    throw new InputMismatchException();
   if (index >= total) {
    index = 0;
    try {
     total = in.read(buf);
    } catch (IOException e) {
     throw new RuntimeException(e);
    }
    if (total <= 0)
     return -1;
   }
   return buf[index++];
  }

  public long scanLong() {
   long integer = 0;
   int n = scan();
   while (isWhiteSpace(n))
    n = scan();
   int neg = 1;
   if (n == '-') {
    neg = -1;
    n = scan();
   }
   while (!isWhiteSpace(n)) {
    if (n >= '0' && n <= '9') {
     integer *= 10;
     integer += n - '0';
     n = scan();
    } else
     throw new InputMismatchException();
   }
   return neg * integer;
  }

  public double scanDouble() throws IOException {
   double doub = 0;
   int n = scan();
   while (isWhiteSpace(n))
    n = scan();
   int neg = 1;
   if (n == '-') {
    neg = -1;
    n = scan();
   }
   while (!isWhiteSpace(n) && n != '.') {
    if (n >= '0' && n <= '9') {
     doub *= 10;
     doub += n - '0';
     n = scan();
    } else
     throw new InputMismatchException();
   }
   if (n == '.') {
    n = scan();
    double temp = 1;
    while (!isWhiteSpace(n)) {
     if (n >= '0' && n <= '9') {
      temp /= 10;
      doub += (n - '0') * temp;
      n = scan();
     } else
      throw new InputMismatchException();
    }
   }
   return doub * neg;
  }

  public String scanString() {
   StringBuilder sb = new StringBuilder();
   int n = scan();
   while (isWhiteSpace(n))
    n = scan();
   while (!isWhiteSpace(n)) {
    sb.append((char) n);
    n = scan();
   }
   return sb.toString();
  }

  public char scanChar() {
   int n = scan();
   while (isWhiteSpace(n))
    n = scan();
   return (char) n;
  }

  private boolean isWhiteSpace(int n) {
   if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
    return true;
   return false;
  }
 }
}