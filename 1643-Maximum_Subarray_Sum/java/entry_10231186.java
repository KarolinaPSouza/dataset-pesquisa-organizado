import java.util.*;
import java.io.*;

public class entry_10231186 {
 static class FastReader {
  BufferedReader br;
  StringTokenizer st;
  public FastReader() {
   br = new BufferedReader(new InputStreamReader(System.in));
  }
  String next() {
   while (st == null || !st.hasMoreTokens()) {
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
    str = br.readLine().trim();
   } catch (Exception e) {
    e.printStackTrace();
   }
   return str;
  }
 }
 static class FastWriter {
  private final StringBuilder sb;
  public FastWriter() {
   this.sb = new StringBuilder();
  }
  public void print(Object object) {
   sb.append(object);
  }
  public void println(Object object) {
   sb.append(object).append("\n");
  }
  public void close() throws IOException {
   System.out.print(sb);
  }
 }
 public static void main(String[] args) {
  try {
   FastReader sc = new FastReader();
   FastWriter out = new FastWriter();
   int n = sc.nextInt();

   long sum = 0;
   long maxi = Integer.MIN_VALUE;
   for(int i = 0; i < n; i++) {
    int val = sc.nextInt();
    sum += val;
    maxi = Math.max(maxi,sum);
    if(sum < 0) {
     sum = 0;
    }

   }

   out.println(maxi);
   out.close();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}