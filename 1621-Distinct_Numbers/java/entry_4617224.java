import java.util.*;
import java.io.*;

public class entry_4617224 {
 public static FastReader obj=new FastReader();
 public static PrintWriter out = new PrintWriter(System.out);
 static class FastReader {
  BufferedReader br;
  StringTokenizer st;

  public FastReader() {
   br = new BufferedReader(new InputStreamReader(System.in));
  }

  String next() {
   while (st == null || !st.hasMoreElements()) {
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  long nextLong() {
   return Long.parseLong(next());
  }

  double nextDouble() {
   return Double.parseDouble(next());
  }

  String nextLine() {
   String str = "";
   try {
    if (st.hasMoreTokens()) {
     str = st.nextToken("\n");
    } else {
     str = br.readLine();
    }
   } catch (IOException e) {
    e.printStackTrace();
   }
   return str;
  }
 }

 public static void main(String[] args) {
  int n=obj.nextInt();
  HashSet<Long> h=new HashSet<>();
  for(int i=0;i<n;i++)h.add(obj.nextLong());
  out.println(h.size());
  out.flush();
 }
}