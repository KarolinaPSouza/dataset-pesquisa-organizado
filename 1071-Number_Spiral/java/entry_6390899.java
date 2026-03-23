import java.util.*;
import java.io.*;
public class entry_6390899 {
    static class Kattio extends PrintWriter {
  private BufferedReader r;
  private StringTokenizer st;
  // standard input
  public Kattio() { this(System.in, System.out); }
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
    while (st == null || !st.hasMoreTokens())
     st = new StringTokenizer(r.readLine());
    return st.nextToken();
   } catch (Exception e) { }
   return null;
  }
  public int nextInt() { return Integer.parseInt(next()); }
  public double nextDouble() { return Double.parseDouble(next()); }
  public long nextLong() { return Long.parseLong(next()); }
 }
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int t = io.nextInt(); //number of tests
        long x;
        long y;


        for(int i = 0; i < t; i++) {
            y = io.nextLong();
            x = io.nextLong();
   if(x < y) {
    if(y % 2 == 0) {
     io.println(y * y - x + 1);
    } else {
     io.println(y * y + x - 2 * y + 1);
    }
   } else {
    if(x % 2 == 0){
     io.println(x * x + y - 2 * x + 1);
    } else {
     io.println(x * x - y + 1);
    }
   }
  }

        io.close();

    }
}