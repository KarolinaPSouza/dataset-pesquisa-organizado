// Problem Link: https://cses.fi/problemset/task/2185/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class entry_10306567 {

  long solve(long n, int k, long[] primes) {
    long ans = 0;
    int nax = 1 << k;

    for (int bit = 1; bit < nax; bit++) {
      long longVal = 1;
      int on = 0;
      for (int i = 0; i < k; i++) {
        if (((bit >> i) & 1) > 0) {
          on++;
          if (longVal > n / primes[i]) {
            longVal = n + 1;
            break;
          }
          longVal *= primes[i];
        }
      }
      if (on % 2 == 1) {
        ans += n / longVal;
      } else {
        ans -= n / longVal;
      }
    }

    return ans;
  }

  long brute(long n, int k, long[] primes) {
    long ans = 0;

    for (long i = 1; i <= n; i++) {
      for (long p : primes) {
        if (i % p == 0) {
          ans++;
          break;
        }
      }
    }

    return ans;
  }

  boolean isPrime(int x) {
    if (x == 2)
      return true;
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0)
        return false;
    }
    return true;
  }

  int randPrime() {
    do {
      int x = (int) ((Math.random() * 1000) + 1);
      if (isPrime(x))
        return x;
    } while (true);
  }

  void randTest() {
    while (true) {
      long n = 200;
      int k = 7;
      long[] primes = new long[k];
      Set<Long> seen = new HashSet<>();
      for (int i = 0; i < k; i++) {
        long p;
        do {
          p = randPrime();
        } while (seen.contains(p));
        seen.add(p);
        primes[i] = p;
      }
      System.out.println(n + " " + k);
      System.out.println(Arrays.toString(primes));
      long actual = solve(n, k, primes);
      long expect = brute(n, k, primes);
      System.out.println(actual + " " + expect);
      if (actual != expect) {
        System.exit(-1);
      }
    }
  }

  void readInput() {
    // randTest();
    long n = io.nextLong();
    int k = io.nextInt();
    long[] primes = new long[k];
    for (int i = 0; i < k; i++) {
      primes[i] = io.nextLong();
    }
    // long ans = brute(n, k, primes);
    long ans = solve(n, k, primes);
    io.println(ans);
  }

  /* Just I/O Template from here until the end */
  static boolean multiple = false;
  static String task = "";
  static Kattio io;

  public static void main(String[] args) throws IOException {
    if (!task.isEmpty()) {
      io = new Kattio(task);
    } else {
      io = new Kattio();
    }
    int t = 1;
    if (multiple) {
      t = io.nextInt();
    }
    for (int i = 0; i < t; i++) {
      new entry_10306567().readInput();
    }
    io.close();
  }

  static class Kattio extends PrintWriter {

    private BufferedReader r;
    private StringTokenizer st;

    // standard input
    public Kattio() {
      this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
      super(o);
      r = new BufferedReader(new InputStreamReader(i));
    }

    // USACO-style file input
    public Kattio(String problemName) throws IOException {
      super(problemName + ".out");
      r = new BufferedReader(new FileReader(problemName + ".in"));
    }

    // returns null if no more input
    public String next() {
      try {
        while (st == null || !st.hasMoreTokens()) {
          st = new StringTokenizer(r.readLine());
        }
        return st.nextToken();
      } catch (Exception e) {
      }
      return null;
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }
  }
}