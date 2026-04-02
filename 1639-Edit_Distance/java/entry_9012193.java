import java.io.*;
import java.util.*;

/*
 * https://cses.fi/problemset/task/1639
 * Edit Distance
 */
public class entry_9012193 {

  public static void main(String[] args) {
    FastReader s = new FastReader();
    int t = 1;

    while (t > 0) {
      String a = s.nx();
      String b = s.nx();
      String sb = run(a, b);
      prln(sb);
      t--;
    }
  }

  public static String run(String a, String b) {
    StringBuilder sb = new StringBuilder();
    // int ans = dfsR(a, b);
    int ans = dfsI(a, b);
    sb.append(ans);
    return sb.toString();
  }

  public static int dfsI(String a, String b) {
    int n = a.length();
    int m = b.length();
    int[][] dp = new int[n + 1][m + 1];

    for (int c = n; c >= 0; c--) {
      for (int k = m; k >= 0; k--) {
        int ans = 0;
        if (c == n && k == m) {
          dp[c][k] = 0;
          continue;
        }

        if (c == n) {
          dp[c][k] = m - k;
          continue;
        } else if (k == m) {
          dp[c][k] = n - c;
          continue;
        }

        if (a.charAt(c) == b.charAt(k)) {
          dp[c][k] = dp[c + 1][k + 1];
        } else {
          ans = Integer.MAX_VALUE;
          int r1 = 1 + dp[c][k + 1];
          int r2 = 1 + dp[c + 1][k];
          int r3 = 1 + dp[c + 1][k + 1];
          ans = Math.min(ans, r1);
          ans = Math.min(ans, r2);
          ans = Math.min(ans, r3);
          dp[c][k] = ans;
        }
      }
    }

    int ans = dp[0][0];
    return ans;
  }

  public static int dfsR(String a, String b) {
    int n = a.length();
    int m = b.length();
    int[][] dp = new int[n][m];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    int ans = dfs(0, 0, n, m, a, b, dp);
    return ans;
  }

  public static int dfs(int c, int k, int n, int m, String a, String b, int[][] dp) {
    int ans = 0;
    if (c == n && k == m) {
      return 0;
    }

    if (c == n) {
      return m - k;
    } else if (k == m) {
      return n - c;
    }

    if (dp[c][k] != -1) {
      return dp[c][k];
    }

    if (a.charAt(c) == b.charAt(k)) {
      ans = dfs(c + 1, k + 1, n, m, a, b, dp);
    } else {
      ans = Integer.MAX_VALUE;
      int r1 = 1 + dfs(c, k + 1, n, m, a, b, dp);
      int r2 = 1 + dfs(c + 1, k, n, m, a, b, dp);
      int r3 = 1 + dfs(c + 1, k + 1, n, m, a, b, dp);
      ans = Math.min(ans, r1);
      ans = Math.min(ans, r2);
      ans = Math.min(ans, r3);
    }
    dp[c][k] = ans;
    return ans;
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(
          new InputStreamReader(System.in));
    }

    String nx() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int ni() {
      return Integer.parseInt(nx());
    }

    long nlg() {
      return Long.parseLong(nx());
    }

    double nd() {
      return Double.parseDouble(nx());
    }

    String nl() {
      String str = "";
      try {
        if (st.hasMoreTokens()) {
          str = st.nextToken("\n");
        } else {
          str = br.readLine();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }

    public int[] ba(int n) {
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = this.ni();
      }
      return a;
    }

    public List<String> bsl(int n) {
      List<String> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        list.add(this.nl());
      }
      return list;
    }

    public List<int[]> b2d(int n) {
      List<int[]> l = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        l.add(new int[] { this.ni(), this.ni() });
      }
      return l;
    }

    public List<int[]> build_edges(int m) {
      List<int[]> edges = new ArrayList<int[]>();
      for (int i = 0; i < m; i++) {
        edges.add(new int[] { this.ni(), this.ni(), this.ni() });
      }
      return edges;
    }
  }

  public static void pr(String s) {
    System.out.print(s);
  }

  public static void prln(String s) {
    pr(s + "\n");
  }

  public static void pa(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      pr(nums[i] + " ");
    }
    prln("");
  }

  public static void pal(long[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      pr(nums[i] + " ");
    }
    prln("");
  }

  public static HashMap<Integer, List<int[]>> build_adjMap_undir(List<int[]> edges) {
    HashMap<Integer, List<int[]>> map = new HashMap<>();
    for (int i = 0; i < edges.size(); i++) {
      int a = edges.get(i)[0];
      int b = edges.get(i)[1];
      int c = edges.get(i)[2];

      List<int[]> l = map.getOrDefault(a, new ArrayList());
      l.add(new int[] { b, c });
      map.put(a, l);

      l = map.getOrDefault(b, new ArrayList());
      l.add(new int[] { a, c });
      map.put(b, l);
    }

    return map;
  }

  public static HashMap<Integer, List<int[]>> build_adjMap_dir(List<int[]> edges) {
    HashMap<Integer, List<int[]>> map = new HashMap<>();
    for (int i = 0; i < edges.size(); i++) {
      int a = edges.get(i)[0];
      int b = edges.get(i)[1];
      int c = edges.get(i)[2];

      List<int[]> l = map.getOrDefault(a, new ArrayList());
      l.add(new int[] { b, c });
      map.put(a, l);
    }

    return map;
  }

  public static void printAdjMap(HashMap<Integer, List<int[]>> map) {
    for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
      int k = entry.getKey();
      List<int[]> v = entry.getValue();
      prln("k: " + k);
      for (int[] v1 : v) {
        pa(v1);
      }
    }
  }

  public static void boolean_ans(boolean res, StringBuilder sb) {
    if (res) {
      sb.append("YES");
    } else {
      sb.append("NO");
    }
  }

  public static int[] pow_2(int n, int MOD) {
    int[] ans = new int[n];
    int curr = 1;
    for (int i = 0; i < n; i++) {
      ans[i] = curr;
      curr = (curr * 2) % MOD;
    }
    return ans;
  }

  public static int[] next_greater(int n, int[] a) {
    int[] ans = new int[n];
    Stack<Integer> st = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && a[i] > a[st.peek()]) {
        st.pop();
      }

      if (st.isEmpty()) {
        ans[i] = n;
      } else {
        ans[i] = st.peek();
      }
      st.push(i);
    }
    return ans;
  }

  public static int[] prev_greater(int n, int[] a) {
    int[] ans = new int[n];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && a[i] > a[st.peek()]) {
        st.pop();
      }

      if (st.isEmpty()) {
        ans[i] = -1;
      } else {
        ans[i] = st.peek();
      }
      st.push(i);
    }
    return ans;
  }

  public static int get_rand(int n) {
    return (int) (Math.random() * n);
  }

  public static int reverse(int n) {
    int ans = 0;
    while (n > 0) {
      ans = ans * 10 + n % 10;
      n = n / 10;
    }
    return ans;
  }

  public static int sum_array(int[] nums) {
    int sum = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
    }
    return sum;
  }

  public static int[] prefix_sum(int[] nums) {
    int n = nums.length;
    int[] ps = new int[n];
    ps[0] = nums[0];
    for (int i = 1; i < n; i++) {
      ps[i] = ps[i - 1] + nums[i];
    }
    return ps;
  }
}