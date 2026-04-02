import java.io.*;
import java.util.*;

public class entry_12142614 {

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }
  }

  public static void main(String[] args) {
    FastReader sc = new FastReader();

    // Read inputs
    int n = sc.nextInt();
    long[] arr = new long[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextLong();
    }

    // Kadane's Algorithm for Maximum Subarray Sum
    long maxSum = Long.MIN_VALUE, currentSum = 0;

    for (int i = 0; i < n; i++) {
      currentSum += arr[i];
      maxSum = Math.max(maxSum, currentSum);

      if (currentSum < 0) {
        currentSum = 0; // Reset the subarray if it becomes negative
      }
    }

    System.out.println(maxSum);
  }
}