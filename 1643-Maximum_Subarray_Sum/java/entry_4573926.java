import java.io.*;
import java.util.*;

public class entry_4573926 {
 public static void main(String[] args) throws IOException {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int[] a = new int[n];
  int max = -1000000001;
  for(int i = 0; i < n; i++) {
   a[i] = sc.nextInt();
   if(a[i] > max)
    max = a[i];
  }
  long sum = 0;
  long tmp = 0;
  for(int i = 0; i < n; i++) {
   if(tmp + a[i] >= 0)
    tmp += a[i];
   else
    tmp = 0;
   if(tmp > sum)
    sum = tmp;
  }
  if(sum == 0)
   sum = max;
  System.out.print(sum);
 }

 static class Scanner {
  StringTokenizer st;
  BufferedReader br;
  public Scanner(InputStream s) {
   br = new BufferedReader(new InputStreamReader(s));
  }
  public Scanner(String file) throws FileNotFoundException {
   br = new BufferedReader(new FileReader(file));
  }
  public String next() throws IOException {
   while (st == null || !st.hasMoreTokens())
    st = new StringTokenizer(br.readLine());
   return st.nextToken();
  }
  public int nextInt() throws IOException {
   return Integer.parseInt(next());
  }
  public long nextLong() throws IOException {
   return Long.parseLong(next());
  }
  public String nextLine() throws IOException {
   return br.readLine();
  }
  public double nextDouble() throws IOException {
   return Double.parseDouble(next());
  }
  public boolean ready() throws IOException {
   return br.ready();
  }
 }
}