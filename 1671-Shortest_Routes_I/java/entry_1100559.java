import java.io.*;
import java.util.*;

public class entry_1100559 extends PrintWriter {

    ArrayDeque<long[]>[] adj;


    private void solve()  {
        int n = sc.nextInt();
        int m = sc.nextInt();
        adj = new ArrayDeque[n];
        for(int u = 0; u < n; u++) adj[u] = new ArrayDeque<>();
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            long c = sc.nextLong();
            adj[u].add(new long[] {v,c});
        } 
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparing((long[] arr)->arr[1]));
        long[] d = new long[n];
        boolean[] done = new boolean[n];
        Arrays.fill(d, 1L<<60);
        d[0] = 0L;
        pq.add(new long[] {0, 0L});
        while(!pq.isEmpty()) {
            long[] uu = pq.remove();
            int u = (int)uu[0];
            if(done[u]) continue;
            done[u] = true;
            d[u] = uu[1];
            for(long[] vv : adj[u]) {
                int v = (int)vv[0];
                if(!done[v]) {
                    pq.add(new long[] {v,d[u]+vv[1]});
                }
            }
        }
        for(int u = 0; u < n; u++) println(d[u]);
    }




//  entry_1100559() throws FileNotFoundException { super(new File("output.txt")); }
//  InputReader sc = new InputReader(new FileInputStream("test_input.txt"));
  entry_1100559() { super(System.out); }
  InputReader sc = new InputReader(System.in);
  static class InputReader {
      InputReader(InputStream in) { this.in = in; } InputStream in;

      private byte[] buf = new byte[16384];
      private int    curChar;
      private int    numChars;


      public int read() {
          if (numChars == -1)
              throw new InputMismatchException();
          if (curChar >= numChars) {
              curChar = 0;
              try {
                  numChars = in.read(buf);
              } catch (IOException e) {
                  throw new InputMismatchException();
              }
              if (numChars <= 0)
                  return -1;
          }
          return buf[curChar++];
      }

      public String nextLine() {
          int c = read();
          while (isSpaceChar(c))
              c = read();
          StringBuilder res = new StringBuilder();
          do {
              res.appendCodePoint(c);
              c = read();
          } while (!isEndOfLine(c));
          return res.toString();
      }

      public String nextString() {
          int c = read();
          while (isSpaceChar(c))
              c = read();
          StringBuilder res = new StringBuilder();
          do {
              res.appendCodePoint(c);
              c = read();
          } while (!isSpaceChar(c));
          return res.toString();
      }

      public long nextLong() {
          int c = read();
          while (isSpaceChar(c))
              c = read();
          int sgn = 1;
          if (c == '-') {
              sgn = -1;
              c = read();
          }
          long res = 0;
          do {
              if (c < '0' || c > '9')
                  throw new InputMismatchException();
              res *= 10;
              res += c - '0';
              c = read();
          } while (!isSpaceChar(c));
          return res * sgn;
      }

      public int nextInt() {
          int c = read();
          while (isSpaceChar(c))
              c = read();
          int sgn = 1;
          if (c == '-') {
              sgn = -1;
              c = read();
          }
          int res = 0;
          do {
              if (c < '0' || c > '9')
                  throw new InputMismatchException();
              res *= 10;
              res += c - '0';
              c = read();
          } while (!isSpaceChar(c));
          return res * sgn;
      }

      private boolean isSpaceChar(int c) {
          return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
      }

      private boolean isEndOfLine(int c) {
          return c == '\n' || c == '\r' || c == -1;
      }
  }

    public static void main(String[] $) {
        new Thread(null, new Runnable() {
            public void run() {
                long start = System.nanoTime();
                try {entry_1100559 solution = new entry_1100559(); solution.solve(); solution.flush();} 
                catch (Exception e) {e.printStackTrace(); System.exit(1);}
                System.err.println((System.nanoTime()-start)/1E9);
            }
        }, "1", 1 << 27).start();

    }
}