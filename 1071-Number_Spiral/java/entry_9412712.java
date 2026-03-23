import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Task1071 {
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      int t = Integer.parseInt(reader.readLine());
      while (t-- > 0) {
        String str = reader.readLine();
        String[] arr = str.split(" ");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        long a = x, b = y;
        long n = Math.max(x, y);
        if (n == 1) {
          System.out.println(1);
          continue;
        }
        long sum = (n - 1) * (n - 1);
        long p = 0;
        if (n % 2 == 0) {
          if (b == n) {
            p = a;
          } else {
            p = n + (n - b);
          }
        } else {
          if (a == n) {
            p = b;
          } else {
            p = n + (n - a);
          }
        }
        System.out.println(sum + p);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}