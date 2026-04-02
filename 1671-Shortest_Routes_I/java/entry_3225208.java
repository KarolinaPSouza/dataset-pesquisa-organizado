import java.io.*;
import java.util.*;

// :eyes:

public class entry_3225208 {
    // region Data Structures
    private static <T> PriorityQueue<T> pqg() {
        return new PriorityQueue<>(Collections.reverseOrder());
    }
    private static class Pair<T extends Comparable<T>, V extends Comparable<V>> implements Comparable<Pair<T, V>> {
        T f;
        V s;

        Pair(T f, V s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public int compareTo(Pair<T, V> o) {
            if(this.f != o.f) return this.f.compareTo(o.f);
            else return this.s.compareTo(o.s);
        }
    }
    // endregion

    // region Input
    static InputStream in = System.in;
 static byte[] i_bf = new byte[1 << 24];
 static int l_bf = 0, p_bf = 0;

 static int readByte() {
  if (l_bf == -1)
   throw new InputMismatchException();
  if (p_bf >= l_bf) {
   p_bf = 0;
   try {
    l_bf = in.read(i_bf);
   } catch (IOException e) {
    throw new InputMismatchException();
   }
   if (l_bf <= 0)
    return -1;
  }
  return i_bf[p_bf++];
 }

 static boolean iS(int c) {
  return !(c >= 33 && c <= 126);
 }

 static int skip() {
  int b;
  while ((b = readByte()) != -1 && iS(b));
  return b;
 }

 static double nd() {
  return Double.parseDouble(ns());
 }

 static char nc() {
  return (char) skip();
 }

 static String ns() {
  int b = skip();
  StringBuilder sb = new StringBuilder();
  while (!(iS(b))) {
   sb.appendCodePoint(b);
   b = readByte();
  }
  return sb.toString();
 }

 static char[] ns(int n) {
  char[] buf = new char[n];
  int b = skip(), p = 0;
  while (p < n && !(iS(b))) {
   buf[p++] = (char) b;
   b = readByte();
  }
  return n == p ? buf : Arrays.copyOf(buf, p);
 }

 static int ni() {
  int num = 0, b;
  boolean minus = false;
  while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
   ;
  if (b == '-') {
   minus = true;
   b = readByte();
  }
  while (true) {
   if (b >= '0' && b <= '9') {
    num = num * 10 + (b - '0');
   } else {
    return minus ? -num : num;
   }
   b = readByte();
  }
 }

 static long nl() {
  long num = 0;
  int b;
  boolean minus = false;
  while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
   ;
  if (b == '-') {
   minus = true;
   b = readByte();
  }
  while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    //    Basic
    private static int re(int a) {
        return ni();
    }

    private static int re(Integer a) {
        return ni();
    }

    private static long re(long a) {
        return nl();
    }

    private static Long re(Long a) {
        return nl();
    }

    private static String re(String a) {
        return ns();
    }

    private static String rel() {
        char c;
        StringBuilder s = new StringBuilder();
        do {
           c = nc();
           if (c == '\n')
              break;
           s.append(c);
        } while (true);

        return s.toString();
    }

    //    Arrays
    private static void re(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = re(a[i]);
        }
    }

    private static void re(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = re(a[i]);
        }
    }

    private static void re(long[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = re(a[i]);
        }
    }

    private static void re(Long[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = re(a[i]);
        }
    }

    private static void re(String[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = re(a[i]);
        }
    }
    // endregion

    // region Constants
    private static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    private final long MOD = (long) 1e9 + 7;
    private static final long INF = (long) 1e18;
    private final double PI = Math.PI;
    // endregion

    // region Operations
    long cdiv(long a, long b) {
        return (a + b - 1) / b;
    } // divide a by b rounded up

    private interface BinarySearchHelper {
        boolean f(long x);
    }

    long fstTrue(long lo, long hi, BinarySearchHelper f) {
        hi++;
        assert (lo <= hi);
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (f.f(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    long lstTrue(long lo, long hi, BinarySearchHelper f) {
        lo--;
        assert (lo <= hi);
        while (lo < hi) {
            long mid = lo + (hi - lo + 1) / 2;
            if (f.f(mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    // endregion

    // region Output
    private static final PrintWriter out = new PrintWriter(System.out);
    private static <T> void ps(List<T> l) {
        for (int i = 0; i < l.size(); i++) {
            out.print(l.get(i).toString());
            if (i != l.size() - 1) out.print(" ");
        }
        out.println();
    }

    private static <T> void ps(T[] l) {
        for (int i = 0; i < l.length; i++) {
            out.print(l[i].toString());
            if (i != l.length - 1) out.print(" ");
        }
        out.println();
    }

    // endregion

    private static class Dijkstra {
        private final List<Pair<Integer, Long>>[] adj;
        private final long[] dist;
        boolean directed;

        @SuppressWarnings("unchecked")
        public Dijkstra(int n, boolean directed) {
            adj = new List[n];
            dist = new long[n];
            this.directed = directed;
            for(int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void ae(int a, int b, Long cost) {
            adj[a].add(new Pair<>(b, cost));
            if(!directed) adj[b].add(new Pair<>(a, cost));
        }

        void gen(int st) {
//            dist.assign(SZ, numeric_limits<C>::max ());
            Arrays.fill(this.dist, INF);
            PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>();
            dist[st] = 0L;
            pq.add(new Pair<>(0L, st));

            while (!pq.isEmpty()) {
                Pair<Long, Integer> x = pq.poll();
                long cdist = x.f; int node = x.s;
                if(cdist != dist[node]) continue;
                for (Pair<Integer, Long> i : adj[x.s]) {
                    if(cdist + i.s < dist[i.f]) {
                        dist[i.f] = cdist + i.s;
                        pq.add(new Pair<>(dist[i.f], i.f));
                    }
                }
            }
        }
    }

    private static void solve(int tc) {
        int n = ni(), m = ni();
        Dijkstra d = new Dijkstra(n + 1, true);
        for(int i = 0; i < m; i++) {
            int a = ni(), b = ni(); long c = ni();
            d.ae(a, b, c);
        }

        d.gen(1);

        for(int i = 1; i <= n; i++) {
            out.print(d.dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 1;
//        n = re(n);
        for (int i = 1; i <= n; i++) {
//          out.println("Test Case: " + i);
            solve(i);
        }

        out.close();
    }

}