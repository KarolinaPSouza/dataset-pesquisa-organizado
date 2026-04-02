import java.util.*;
import java.io.*;

public class entry_3252445 {

 static BufferedReader in;
 static StringTokenizer st;
 static int n, x, a[];
 static HashMap<Integer, Integer> m;
 public static void main(String[] args) throws IOException {

  in = new BufferedReader(new InputStreamReader(System.in));

  init();
  solve();

  in.close();
 }

 static void init() throws IOException { 
  st = new StringTokenizer(in.readLine());
  n = Integer.parseInt(st.nextToken());
  x = Integer.parseInt(st.nextToken());

  a = new int[n];
  st = new StringTokenizer(in.readLine());
  for(int i=0; i<n; i++) 
   a[i] = Integer.parseInt(st.nextToken());

  m = new HashMap<Integer, Integer>();
 }

 static void solve() throws IOException {

  StringBuilder sb = new StringBuilder();
  for(int i=0; i<n; i++) {
   int val = x-a[i];
   if(m.containsKey(val)) {
    sb.append(m.get(val)).append(" ").append(i+1).append("\n");
   }
   else {
    m.put(a[i], i+1);
   }
  }
  if(sb.length()==0) System.out.println("IMPOSSIBLE");
  else System.out.print(sb.toString());
 }

}