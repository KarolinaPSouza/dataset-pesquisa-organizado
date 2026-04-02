import java.util.*;
import java.io.*;

public class entry_3015519 {   
    public static void main(String[] args) throws IOException
    {
        InputOutput io = new InputOutput(); 

  Map<Integer, Integer> set = new HashMap<Integer, Integer>();
  final int N = io.nextInt();
        final int SUM = io.nextInt();

  boolean found = false;
  // Make the keys the numbers, and their value their indexes
  for(int i = 1; i <= N; i++) {
   int num = io.nextInt();
   if(set.containsKey(SUM-num)) {
    System.out.println(set.get(SUM-num) + " " + i);
    found = true;
    break;
   }
   else set.put(num, i);
  }

  if(!found) System.out.println("IMPOSSIBLE");

  //io.close();
 } 
}

class InputOutput extends PrintWriter {
 private BufferedReader reader;
 private StringTokenizer st;

 public InputOutput() { this(System.in, System.out); }

 public InputOutput(String name) throws IOException {
  super(new FileWriter(name + ".out"));
  reader = new BufferedReader(new FileReader(name + ".in"));
 }

 public InputOutput(InputStream input, OutputStream output) {
  super(output);
  reader = new BufferedReader(new InputStreamReader(input));
 }

 public String next() {
  try {
   while (st == null || !st.hasMoreTokens())
    st = new StringTokenizer(reader.readLine());
   return st.nextToken();
  } catch (Exception e) { }
  return null;
 }

 public int nextInt() { return Integer.parseInt(next()); }
 public long nextLong() { return Long.parseLong(next()); }
 public double nextDouble() { return Double.parseDouble(next()); }
}
