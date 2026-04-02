import java.util.*;
import java.io.*;

public class entry_4609932 {

 static Scanner sc;
 static PrintWriter pw;
 static int n, m, memo[][];
 static char[] s1, s2;

 public static int dp(int i, int j) {
  if(i == n && j == m)
   return 0;
  if(i == n)
   return m - j;
  if(j == m)
   return n - i;
  if (memo[i][j] != -1)
   return memo[i][j];
  if (s1[i] == s2[j])
   return memo[i][j] = dp(i + 1, j + 1);
  int replace = 1 + dp(i + 1, j + 1);
  int remove = 1 + dp(i + 1, j);
  int insert = 1 + dp(i, j + 1);
  return memo[i][j] = Math.min(replace, Math.min(remove, insert));
 }

 public static void main(String[] args) throws IOException {
  sc = new Scanner(System.in);
  pw = new PrintWriter(System.out);
  s1 = sc.next().toCharArray();
  n = s1.length;
  s2 = sc.next().toCharArray();
  m = s2.length;
  memo = new int[n][m];
  for (int[] a : memo)
   Arrays.fill(a, -1);
  pw.println(dp(0, 0));
  pw.close();
 }

 static class Scanner {
  StringTokenizer st;
  BufferedReader br;

  public Scanner(InputStream s) {
   br = new BufferedReader(new InputStreamReader(s));
  }

  public Scanner(FileReader r) {
   br = new BufferedReader(r);
  }

  public String readAllLines(BufferedReader reader) throws IOException {
   StringBuilder content = new StringBuilder();
   String line;

   while ((line = reader.readLine()) != null) {
    content.append(line);
    content.append(System.lineSeparator());
   }

   return content.toString();
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
   String x = next();
   StringBuilder sb = new StringBuilder("0");
   double res = 0, f = 1;
   boolean dec = false, neg = false;
   int start = 0;
   if (x.charAt(0) == '-') {
    neg = true;
    start++;
   }
   for (int i = start; i < x.length(); i++)
    if (x.charAt(i) == '.') {
     res = Long.parseLong(sb.toString());
     sb = new StringBuilder("0");
     dec = true;
    } else {
     sb.append(x.charAt(i));
     if (dec)
      f *= 10;
    }
   res += Long.parseLong(sb.toString()) / f;
   return res * (neg ? -1 : 1);
  }

  public long[] nextlongArray(int n) throws IOException {
   long[] a = new long[n];
   for (int i = 0; i < n; i++)
    a[i] = nextLong();
   return a;
  }

  public Long[] nextLongArray(int n) throws IOException {
   Long[] a = new Long[n];
   for (int i = 0; i < n; i++)
    a[i] = nextLong();
   return a;
  }

  public int[] nextIntArray(int n) throws IOException {
   int[] a = new int[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }

  public Integer[] nextIntegerArray(int n) throws IOException {
   Integer[] a = new Integer[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }

  public boolean ready() throws IOException {
   return br.ready();
  }

 }

}