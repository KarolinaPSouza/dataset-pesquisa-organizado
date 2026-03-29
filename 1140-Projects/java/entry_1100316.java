import java.io.*;
import java.util.*;

public class entry_1100316 extends PrintWriter {

    private void solve()  {
        int n = sc.nextInt();
        long[][] p = new long[n][3];
        for(int i = 0; i < n; i++) {
            p[i] = new long[] {sc.nextInt(),sc.nextInt(),sc.nextInt()};
        }
        sort(p, 0, n-1);
        TreeMap<Long, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) map.put(p[i][1], i);
        long dp = 0L;
        long[] max = new long[n];
        long ans = 0L;
        for(int i = 0; i < n; i++) {
            Map.Entry<Long, Integer> entry = map.lowerEntry(p[i][0]);
            if(entry == null) dp = p[i][2];
            else dp = max[entry.getValue()] + p[i][2];
            ans = Math.max(ans, dp);
            max[i] = ans;
        }
        println(ans);
    }

    void sort(long[][] arr, int l, int r) {
        if(l == r) return;
        else {
            int mid = (l+r)/2;
            sort(arr, l, mid);
            sort(arr, mid+1, r);
            long[][] temp = new long[r-l+1][];
            int idx = 0;
            int i = l;
            int j = mid+1;
            while(i <= mid && j <= r) {
                if(arr[i][1] <= arr[j][1]) {
                    temp[idx++] = arr[i++];
                } else {
                    temp[idx++] = arr[j++];
                }
            }
            while(i <= mid) {
                temp[idx++] = arr[i++];
            }
            while(j <= r) {
                temp[idx++] = arr[j++];
            }
            for(i = l; i <= r; i++) {
                arr[i] = temp[i-l];
            }
        }
    }

//  entry_1100316() throws FileNotFoundException { super(new File("output.txt")); }
//  InputReader sc = new InputReader(new FileInputStream("test_input.txt"));
  entry_1100316() { super(System.out); }
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
                try {entry_1100316 solution = new entry_1100316(); solution.solve(); solution.flush();} 
                catch (Exception e) {e.printStackTrace(); System.exit(1);}
                System.err.println((System.nanoTime()-start)/1E9);
            }
        }, "1", 1 << 27).start();

    }
}