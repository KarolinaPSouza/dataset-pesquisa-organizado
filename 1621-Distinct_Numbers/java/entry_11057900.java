import java.io.*;
import java.util.*;

public class entry_11057900 {

 public static void main(String[] args) throws Exception {
  Kattio io = new Kattio();

  int n = io.nextInt();

  Set<Integer> InSet = new HashSet<Integer>(); 

  for (int i = 0; i < n; i++){
   int net = io.nextInt();
   InSet.add(net);
  }

  io.println(InSet.size());
  io.close();

 }


 static class Kattio extends PrintWriter {
  private BufferedReader r;
  private StringTokenizer st;
  public Kattio() { this(System.in, System.out); }
  public Kattio(InputStream i, OutputStream o) {
   super(o);
   r = new BufferedReader(new InputStreamReader(i));
  }
  public Kattio(String problemName) throws IOException {
   super(problemName + ".out");
   r = new BufferedReader(new FileReader(problemName + ".in"));
  }
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