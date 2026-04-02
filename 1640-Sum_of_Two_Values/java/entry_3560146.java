import java.util.*;
import java.io.*;
public class entry_3560146 {

 public static void main(String[] args) {
  Kattio in = new Kattio ();
  int N = in.nextInt();
  int X = in.nextInt();
  int count = 0;
  HashMap <Integer, Integer> arr = new HashMap <> ();
  for (int a = 0; a < N; a++) {
   int num = in.nextInt();
   if (arr.containsKey(X - num)) {
    System.out.println(arr.get(X - num) + " " + (a + 1));
    count++;
    break;
   }

   arr.put(num, a + 1);
  }

  if (count == 0) {
   System.out.println("IMPOSSIBLE");
  }
  in.close();
 }

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

}