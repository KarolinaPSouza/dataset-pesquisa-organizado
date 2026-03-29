import java.io.*;
import java.util.*;

/*
 * Flight Discount
 * https://cses.fi/problemset/task/1195
 */
public class entry_9459376 {

  static Random rand;
  static Utils u;
  static FastReader f;
  static BuildAndRun br;

  public static void main(String[] args) {
    f = new FastReader();
    br = new BuildAndRun();
    rand = new Random();
    u = new Utils();

    int t = 1;

    while (t > 0) {
      int n = f.ni();
      int m = f.ni();
      List<int[]> e = f.buildEdges(m);
      br.run(n, m, e);
      t--;
    }
  }

  static class BuildAndRun {

    Map<Integer, List<int[]>> map;

    public void run(int n, int m, List<int[]> e) {
      StringBuilder sb = new StringBuilder();
      map = u.buildWeighDirAdjMap(e);
      // u.printAdjMap(map);

      // node, used or not, price
      boolean[][] vis = new boolean[n + 1][2];
      PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
        return a[2] < b[2] ? -1 : 1;
      });

      pq.add(new long[] { 1, 0, 0 });

      long ans = 0;
      // always mark visited while pop from PQ
      // optimal
      // not while putting
      while (!pq.isEmpty()) {
        long[] curr = pq.remove();
        int node = (int) curr[0];
        int used = (int) curr[1];
        long price = curr[2];

        if (vis[node][used]) {
          continue;
        }
        vis[node][used] = true;

        // u.prln(node + " " + used + " " + price);
        if (node == n) {
          ans = price;
          break;
        }

        for (int[] ne : map.getOrDefault(node, new ArrayList<>())) {
          int newNode = ne[0];
          long newPrice;

          if (used == 0) {
            newPrice = price + (ne[1] / 2);
            pq.add(new long[] { newNode, 1, newPrice });
            // u.prln("added1: " + newNode + " " + 1 + " " + newPrice);
          }

          newPrice = price + ne[1] * 1L;
          pq.add(new long[] { newNode, used, newPrice });
          // u.prln("added2: " + newNode + " " + used + " " + newPrice);

        }
      }

      sb.append(ans);
      u.prln(sb);
    }

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

    // build edges 2d
    public List<int[]> b2d(int n) {
      List<int[]> l = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        l.add(new int[] { this.ni(), this.ni() });
      }
      return l;
    }

    // build weighted edges 3d
    public List<int[]> buildEdges(int m) {
      List<int[]> edges = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        edges.add(new int[] { this.ni(), this.ni(), this.ni() });
      }
      return edges;
    }
  }

  static class Utils {
    public void pr(Object s) {
      System.out.print(s);
    }

    public void prln(Object s) {
      pr(s + "\n");
    }

    public void pa(int[] nums) {
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        pr(nums[i] + " ");
      }
      prln("");
    }

    public void pal(long[] nums) {
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        pr(nums[i] + " ");
      }
      prln("");
    }

    // unwighted undirected adjacency map
    public Map<Integer, List<Integer>> buildUndirAdjMap(List<int[]> edges) {
      HashMap<Integer, List<Integer>> map = new HashMap<>();

      for (int i = 0; i < edges.size(); i++) {
        int a = edges.get(i)[0];
        int b = edges.get(i)[1];

        map.putIfAbsent(a, new ArrayList<>());
        map.get(a).add(b);

        map.putIfAbsent(b, new ArrayList<>());
        map.get(b).add(a);
      }

      return map;
    }

    // weighted undirected Adjacency map
    // edges length 3
    public Map<Integer, List<int[]>> buildWeighUndirAdjMap(List<int[]> edges) {
      HashMap<Integer, List<int[]>> map = new HashMap<>();
      for (int i = 0; i < edges.size(); i++) {
        int a = edges.get(i)[0];
        int b = edges.get(i)[1];
        int c = edges.get(i)[2];

        List<int[]> l = map.getOrDefault(a, new ArrayList<>());
        l.add(new int[] { b, c });
        map.put(a, l);

        l = map.getOrDefault(b, new ArrayList<>());
        l.add(new int[] { a, c });
        map.put(b, l);
      }

      return map;
    }

    // Weighted directed adjacency map
    // edges 3
    public Map<Integer, List<int[]>> buildWeighDirAdjMap(List<int[]> edges) {
      HashMap<Integer, List<int[]>> map = new HashMap<>();
      for (int i = 0; i < edges.size(); i++) {
        int a = edges.get(i)[0];
        int b = edges.get(i)[1];
        int c = edges.get(i)[2];

        List<int[]> l = map.getOrDefault(a, new ArrayList<>());
        l.add(new int[] { b, c });
        map.put(a, l);
      }

      return map;
    }

    // Print Adjacency map
    public void printAdjMap(Map<Integer, List<int[]>> map) {
      for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
        int k = entry.getKey();
        List<int[]> v = entry.getValue();
        prln("k: " + k);
        for (int[] v1 : v) {
          pa(v1);
        }
      }
    }

    // print boolean answer YES / NO
    public void booleanAns(boolean res, StringBuilder sb) {
      if (res) {
        sb.append("YES");
      } else {
        sb.append("NO");
      }
    }

    // Print power 2 of a number with MOD
    public long[] pow2(int n, int mod) {
      long[] ans = new long[n];
      long curr = 1;
      for (int i = 0; i < n; i++) {
        ans[i] = curr;
        curr = (curr * 2) % mod;
      }
      return ans;
    }

    // get next greater for each elements in array
    public int[] nextGreater(int n, int[] a) {
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

    // get previous greater for each elements in array
    public int[] prevGreater(int n, int[] a) {
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

    // get random between 0 to n-1
    public int getRand(int n) {
      return rand.nextInt(n);
    }

    // reverse numeric decimal n
    public int reverse(int n) {
      int ans = 0;
      while (n > 0) {
        ans = ans * 10 + n % 10;
        n = n / 10;
      }
      return ans;
    }

    // return sum of array
    public long sumArray(int[] nums) {
      long sum = 0;
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        sum += Long.valueOf(nums[i]);
      }
      return sum;
    }

    // prefix sum of array
    public long[] prefixSum(int[] nums) {
      int n = nums.length;
      long[] ps = new long[n];
      ps[0] = nums[0];
      for (int i = 1; i < n; i++) {
        ps[i] = ps[i - 1] + Long.valueOf(nums[i]);
      }
      return ps;
    }
  }

  static class Pair {
    int k;
    int v;

    Pair(int k, int v) {
      this.k = k;
      this.v = v;
    }

    public String toString() {
      return "[" + k + "," + v + "]";
    }

    public int compareTo(Pair p) {
      if (this.k == p.k) {
        return this.v - p.v;
      }
      return this.k - p.k;
    }
  }
}