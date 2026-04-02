import java.util.*;
import java.io.*;
public class entry_7074589 {
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
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();


        int n = io.nextInt();
        int x = io.nextInt(); //target sum
        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = io.nextInt();
            map.put(arr[i], i + 1); 
        }

        for(int i = 0; i < n; i++){
            if(map.containsKey(x-arr[i]) && i != map.get(x-arr[i])-1){
                io.println((i+1) + " " + map.get(x-arr[i]));
                break;
            }
        }

        io.println("IMPOSSIBLE");
        io.close();
    }
}