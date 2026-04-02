import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class entry_452731 {
  public static void main(String[] args) throws IOException {
    FastReader in = new FastReader();
    PrintWriter out = new PrintWriter(System.out);

    Task solver = new Task();
    solver.solve(in, out);

    out.flush();
    out.close();
  }

  static class Task {

    // Consts
    final int MOD = (int)1e9+7;
    final int MAXN = (int)2e5+2;
    final int INF = 0x3f3f3f3f;

    // G & Funcs
    Pair a[] = new Pair[MAXN];

    class Pair implements Comparable<Pair> {
      int v, idx;

      public Pair(int v, int idx) {
        this.v = v;
        this.idx = idx;
      }

      @Override
      public int compareTo(Pair o) {
        return v - o.v;
      }
    }

    void solve(FastReader in, PrintWriter out) throws IOException {

      int n, x;

      n = in.nextInt();
      x = in.nextInt();

      for(int i=1;i<=n;++i)
        a[i] = new Pair(in.nextInt(), i);

      Arrays.sort(a, 1, n+1);

      for(int i=1, j=n;i<j;) {
        if(a[i].v + a[j].v == x) {
          out.println(a[i].idx+" "+a[j].idx);
          return;
        }
        else if(a[i].v + a[j].v > x) --j;
        else ++i;
      }

      out.println("IMPOSSIBLE");

    }
  }

  static class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader(InputStream is) {
      br = new BufferedReader(new InputStreamReader(is), 32768);
    }

    public FastReader() {
      this(System.in);
    }

    public String next() {
      if (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
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
      }
      return null;
    }

    public boolean hasNext() throws IOException {
      if (st != null && st.hasMoreTokens()) {
        return true;
      }
      String s = br.readLine();
      if (s == null || s.isEmpty()) {
        return false;
      }
      st = new StringTokenizer(s);
      return true;
    }
  }
}