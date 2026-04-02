import java.util.*;
import java.io.*;

/**
 * Made by egor https://github.com/chermehdi/egor.
 * 
 * @author Azuz
 * 
 */
public class entry_1133592 {

    void solve(InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();

      ArrayList<Integer>[] g = new ArrayList[n + 1];
      int[] dist = new int[n + 1];
      int[] parent = new int[n + 1];
      for (int i = 0; i <= n; ++i) {
        dist[i] = Integer.MAX_VALUE;
        g[i] = new ArrayList<>();
        parent[i] = i;
      }

      for (int i = 0; i < m; ++i) {
        int u = in.nextInt();
        int v = in.nextInt();

        g[u].add(v);
        g[v].add(u);
      }

      ArrayDeque<State> q = new ArrayDeque<>();
      q.offer(new State(1, 1, 1));

      while (!q.isEmpty()) {
        int size = q.size();
        for (int i= 0; i < size; ++i) {
          State s = q.poll();
          int u = s.u;
          int p = s.p;
          int d = s.d;
          if (dist[u] <= d) {
            continue;
          }
          dist[u] = d;
          parent[u] = p;
          for (int v : g[u]) {
            q.offer(new State(v, u, d + 1));
          }
        }
      }

      if (dist[n] == Integer.MAX_VALUE) {
        out.println("IMPOSSIBLE");
      } else {

        out.println(dist[n]);
        Stack<Integer> stk = new Stack<>();
        int current = n;
        while (parent[current] != current) {
          stk.push(current);
          current = parent[current];
        } stk.push(current);

        while (!stk.isEmpty()) {
          out.print(stk.pop() + " ");
        } out.println();
      }


    }
    static class State {
      int u, p, d;

      public State(int u, int p, int d) {
        this.u = u;
        this.p = p;
        this.d = d;
      }
    }

    public static void main(String[] args) {
      InputReader in = new InputReader(System.in);
      PrintWriter out = new PrintWriter(System.out);
      new entry_1133592().solve(in, out);
      out.close();
    }


  static class InputReader {

    private InputStream stream;
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int EOF = -1;
    private byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (this.numChars == EOF) {
        throw new UnknownError();
      } else {
        if (this.curChar >= this.numChars) {
          this.curChar = 0;

          try {
            this.numChars = this.stream.read(this.buf);
          } catch (IOException ex) {
            throw new InputMismatchException();
          }

          if (this.numChars <= 0) {
            return EOF;
          }
        }

        return this.buf[this.curChar++];
      }
    }

    public int nextInt() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {
      }

      byte sgn = 1;
      if (c == 45) {
        sgn = -1;
        c = this.read();
      }

      int res = 0;

      while (c >= 48 && c <= 57) {
        res *= 10;
        res += c - 48;
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }

      throw new InputMismatchException();
    }

    public static boolean isSpaceChar(int c) {
      return c == 32 || c == 10 || c == 13 || c == 9 || c == EOF;
    }

  }
}