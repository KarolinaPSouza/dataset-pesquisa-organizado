// 18:15:46 14-07-2024
// Flight Discount
// https://cses.fi/problemset/task/1195
// 1000 ms

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.util.stream.Collectors;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

public class entry_9856594 {
    static In in = new FastIn();
    static Out out = new Out(false , false);
    static final long inf = 0x1fffffffffffffffL;
    static final int iinf = 0x3fffffff;
    static final double eps = 1e-9;
    static long mod = 998244353;

    void solve() {
     int n = inp();
     int m = inp();

     List<List<Pair>> edges = new ArrayList<>();

     for(int i = 0 ; i < n ; i++) edges.add(new ArrayList<>());
     for(int i = 0 ; i < m ; i++){
      int a = inp(), b = inp(), c = inp();
      a--; b--;
      edges.get(a).add(new Pair(b , c));
     }

     long[][] dp = new long[n][2];

     for(long[] x : dp) Arrays.fill(x , inf);
     dp[0][0] = 0;
     dp[0][1] = 0;

     PriorityQueue<IntPair> pq = new PriorityQueue<>((A , B) -> {
      if(A.second != B.second) return A.second - B.second;
      return Long.compare(A.dis , B.dis);
     });

     pq.offer(new IntPair(0 , 0 , 0));

     while(!pq.isEmpty()){
      IntPair x = pq.remove();

      int node = x.first;
      int type = x.second;
      long dis = x.dis;

      if(dp[node][type] < dis){
       continue;
      }

      for(Pair it : edges.get(node)){
       int nextNode = it.first;
       int val = it.second;

       if(type == 0){
        if(dp[nextNode][0] > x.dis + val){
         dp[nextNode][0] = x.dis + val;
         pq.offer(new IntPair(nextNode , 0 , dp[nextNode][0]));
        }

        if(dp[nextNode][1] > x.dis + (val/2)){
         dp[nextNode][1] = x.dis + (val/2);
         pq.offer(new IntPair(nextNode , 1 , dp[nextNode][1]));
        }
       }
       else{
        if(dp[nextNode][1] > x.dis + val){
         dp[nextNode][1] = x.dis + val;
         pq.offer(new IntPair(nextNode , 1 , dp[nextNode][1]));
        }
       }
      }
     }

     out.println(dp[n-1][1]);
    }

    class IntPair{
     int first;
     int second;
     long dis;

     IntPair(int first , int second , long dis){
      this.first = first;
      this.second = second;
      this.dis = dis;
     }
    }

    class Pair{
     int first;
     int second;

     Pair(int first , int second){
      this.first = first;
      this.second = second;
     }
    }

    public static void main(String... args) {
        int ntc = 1;

        // ntc = in.nextInt();
        for(int i = 1 ; i <= ntc ; i++)
        new entry_9856594().solve();
        out.flush();
    }

    int inp(){
     return in.nextInt();
    }
}

class FastIn extends In {
    private final BufferedInputStream reader = new BufferedInputStream(System.in);
    private final byte[] buffer = new byte[0x10000];
    private int i = 0;
    private int length = 0;

    public int read() {
        if (i == length) {
            i = 0;
            try {
                length = reader.read(buffer);
            } catch (IOException ignored) {
            }
            if (length == -1) {
                return 0;
            }
        }
        if (length <= i) {
            throw new RuntimeException();
        }
        return buffer[i++];
    }

    String next() {
        StringBuilder builder = new StringBuilder();
        int b = read();
        while (b < '!' || '~' < b) {
            b = read();
        }
        while ('!' <= b && b <= '~') {
            builder.appendCodePoint(b);
            b = read();
        }
        return builder.toString();
    }

    String nextLine() {
        StringBuilder builder = new StringBuilder();
        int b = read();
        while (b != 0 && b != '\r' && b != '\n') {
            builder.appendCodePoint(b);
            b = read();
        }
        if (b == '\r') {
            read();
        }
        return builder.toString();
    }

    int nextInt() {
        long val = nextLong();
        if ((int)val != val) {
            throw new NumberFormatException();
        }
        return (int)val;
    }

    long nextLong() {
        int b = read();
        while (b < '!' || '~' < b) {
            b = read();
        }
        boolean neg = false;
        if (b == '-') {
            neg = true;
            b = read();
        }
        long n = 0;
        int c = 0;
        while ('0' <= b && b <= '9') {
            n = n * 10 + b - '0';
            b = read();
            c++;
        }
        if (c == 0 || c >= 2 && n == 0) {
            throw new NumberFormatException();
        }
        return neg ? -n : n;
    }
}

class In {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 0x10000);
    private StringTokenizer tokenizer;

    String next() {
        try {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        } catch (IOException ignored) {
        }
        return tokenizer.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    char[] nextCharArray() {
        return next().toCharArray();
    }

    String[] nextStringArray(int n) {
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = next();
        }
        return s;
    }

    char[][] nextCharGrid(int n, int m) {
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
        }
        return a;
    }

    int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    int[] nextIntArray(int n, IntUnaryOperator op) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = op.applyAsInt(nextInt());
        }
        return a;
    }

    int[][] nextIntMatrix(int h, int w) {
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            a[i] = nextIntArray(w);
        }
        return a;
    }

    long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }
        return a;
    }

    long[] nextLongArray(int n, LongUnaryOperator op) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = op.applyAsLong(nextLong());
        }
        return a;
    }

    long[][] nextLongMatrix(int h, int w) {
        long[][] a = new long[h][w];
        for (int i = 0; i < h; i++) {
            a[i] = nextLongArray(w);
        }
        return a;
    }

    List<List<Integer>> nextEdges(int n, int m, boolean directed) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            res.get(u).add(v);
            if (!directed) {
                res.get(v).add(u);
            }
        }
        return res;
    }
}

class Out {
    private final PrintWriter out = new PrintWriter(System.out);
    private final PrintWriter err = new PrintWriter(System.err);
    boolean autoFlush;
    boolean enableDebug;

    Out(boolean enableDebug , boolean autoFlush) {
        this.enableDebug = enableDebug;
        this.autoFlush = autoFlush;
    }

    void println(Object... args) {
        if (args == null || args.getClass() != Object[].class) {
            args = new Object[] {args};
        }
        out.println(Arrays.stream(args).map(obj -> {
            Class<?> clazz = obj == null ? null : obj.getClass();
            return clazz == Double.class ? String.format("%.10f", obj) :
                   clazz == byte[].class ? Arrays.toString((byte[])obj) :
                   clazz == short[].class ? Arrays.toString((short[])obj) :
                   clazz == int[].class ? Arrays.toString((int[])obj) :
                   clazz == long[].class ? Arrays.toString((long[])obj) :
                   clazz == char[].class ? Arrays.toString((char[])obj) :
                   clazz == float[].class ? Arrays.toString((float[])obj) :
                   clazz == double[].class ? Arrays.toString((double[])obj) :
                   clazz == boolean[].class ? Arrays.toString((boolean[])obj) :
                   obj instanceof Object[] ? Arrays.deepToString((Object[])obj) :
                   String.valueOf(obj);
        }).collect(Collectors.joining(" ")));
        if (autoFlush) {
            out.flush();
        }
    }

    void debug(Object... args) {
        if (!enableDebug) {
            return;
        }
        if (args == null || args.getClass() != Object[].class) {
            args = new Object[] {args};
        }
        err.println(Arrays.stream(args).map(obj -> {
            Class<?> clazz = obj == null ? null : obj.getClass();
            return clazz == Double.class ? String.format("%.10f", obj) :
                   clazz == byte[].class ? Arrays.toString((byte[])obj) :
                   clazz == short[].class ? Arrays.toString((short[])obj) :
                   clazz == int[].class ? Arrays.toString((int[])obj) :
                   clazz == long[].class ? Arrays.toString((long[])obj) :
                   clazz == char[].class ? Arrays.toString((char[])obj) :
                   clazz == float[].class ? Arrays.toString((float[])obj) :
                   clazz == double[].class ? Arrays.toString((double[])obj) :
                   clazz == boolean[].class ? Arrays.toString((boolean[])obj) :
                   obj instanceof Object[] ? Arrays.deepToString((Object[])obj) :
                   String.valueOf(obj);
        }).collect(Collectors.joining(" ")));
        err.flush();
    }

    void println(char a) {
        out.println(a);
        if (autoFlush) {
            out.flush();
        }
    }

    void println(int a) {
        out.println(a);
        if (autoFlush) {
            out.flush();
        }
    }

    void println(long a) {
        out.println(a);
        if (autoFlush) {
            out.flush();
        }
    }

    void println(double a) {
        out.println(String.format("%.10f", a));
        if (autoFlush) {
            out.flush();
        }
    }

    void println(String s) {
        out.println(s);
        if (autoFlush) {
            out.flush();
        }
    }

    void println(char[] s) {
        out.println(String.valueOf(s));
        if (autoFlush) {
            out.flush();
        }
    }

    void println(int[] a) {
        StringJoiner joiner = new StringJoiner(" ");
        for (int i : a) {
            joiner.add(Integer.toString(i));
        }
        out.println(joiner);
        if (autoFlush) {
            out.flush();
        }
    }

    void println(long[] a) {
        StringJoiner joiner = new StringJoiner(" ");
        for (long i : a) {
            joiner.add(Long.toString(i));
        }
        out.println(joiner);
        if (autoFlush) {
            out.flush();
        }
    }

    void flush() {
        err.flush();
        out.flush();
    }
}
// template - Yu_212