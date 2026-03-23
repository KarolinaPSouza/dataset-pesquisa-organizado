//package Searching_Sorting;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

 class FastScanner {

    private final InputStream in;
    private final byte[] buffer = new byte[1 << 16]; // 64 KB buffer
    private int ptr = 0, len = 0;

    public FastScanner(InputStream is) {
        this.in = (is instanceof BufferedInputStream) ? is : new BufferedInputStream(is);
    }

    private int read() throws IOException {
        if (ptr >= len) {
            len = in.read(buffer);
            ptr = 0;
            if (len <= 0) {
                return -1; // end of stream
            }
        }
        return buffer[ptr++];
    }

    private int skip() throws IOException {
        int c;
        while ((c = read()) != -1 && c <= ' ') { /* skip whitespace */ }
        return c;
    }

    public String next() throws IOException {
        int c = skip();
        if (c == -1) return null; // no more tokens

        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
            c = read();
        } while (c > ' ');
        return sb.toString();
    }

    public int nextInt() throws IOException {
        int c = skip();
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int val = 0;
        while (c > ' ') {
            val = val * 10 + c - '0';
            c = read();
        }
        return val * sign;
    }

    public long nextLong() throws IOException {
        int c = skip();
        long sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        long val = 0;
        while (c > ' ') {
            val = val * 10 + c - '0';
            c = read();
        }
        return val * sign;
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public String nextLine() throws IOException {
        int c = read();
        if (c == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (c != -1 && c != '\n') {
            if (c != '\r') {
                sb.append((char) c);
            }
            c = read();
        }
        return sb.toString();
    }
}

public class entry_15901433 {

 public static void main(String[] args) throws IOException {
  // TODO Auto-generated method stub

  FastScanner sc = new FastScanner(System.in);

  int n = sc.nextInt();
  int m = sc.nextInt();


  long k = sc.nextLong();

  long [] users = new long[n];
  long [] appartments = new long [m];

  for(int i=0; i<n; i++) users[i] = sc.nextLong();
  for(int i=0; i<m; i++) appartments[i] = sc.nextLong();


  Arrays.sort(users);
  Arrays.sort(appartments);
  int i=0, j=0;
  int ans = 0;
  while(i < n && j < m) {

   if(appartments[j] >= (users[i] - k) && appartments[j] <= (users[i] + k)) {
    ans ++;
    i++;
    j++;
   }
   else if(appartments[j] > (users[i] + k)) {
    i++;
   }
   else {
    j++;
   }

  }

  System.out.println(ans);










 }

}