import java.io.*;
import java.util.*;

public class entry_2726048 {
  static PrintWriter out = new PrintWriter((System.out));
  static Reader sc = new Reader();
  static int MOD = (int) Math.pow(10, 9) + 7;

  public static void main(String args[]) throws IOException {

    // int t = sc.nextInt();
    // while (t-- > 0) {
    solve();
    // }
    out.close();
  }

  public static class Pair implements Comparable<Pair> {
    int start;
    int end;
    int reward;

    public Pair(int start, int end, int reward) {
      this.start = start;
      this.end = end;
      this.reward = reward;
    }

    @Override
    public int compareTo(Pair o) {
      return this.end - o.end;
    }

  }

  public static int binarySearch(Pair[] arr, int n) {
    int start = 0;
    int end = n;
    int index = n + 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid].end < arr[index].start) {
        if (arr[mid + 1].end < arr[index].start) {
          start = mid + 1;
        } else {
          return mid;
        }
      } else {
        end = mid - 1;
      }
    }
    return -1;

  }

  public static void solve() {
    int n = sc.nextInt();
    Pair[] arr = new Pair[n];
    for (int i = 0; i < n; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int reward = sc.nextInt();
      arr[i] = new Pair(start, end, reward);
    }
    Arrays.sort(arr);
    long[] dp = new long[n];
    dp[0] = arr[0].reward;
    for (int i = 1; i < n; i++) {
      int index = binarySearch(arr, i - 1);
      long money = arr[i].reward;
      if (index != -1) {
        money += dp[index];
      }
      dp[i] = Math.max(dp[i - 1], money);
    }

    out.println(dp[n - 1]);
  }

  static class Reader {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    public String next() {
      while (!st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public String nextLine() {
      try {
        return br.readLine();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }

    public boolean hasNext() {
      String next = null;
      try {
        next = br.readLine();
      } catch (Exception e) {
      }
      if (next == null) {
        return false;
      }
      st = new StringTokenizer(next);
      return true;
    }
  }
}