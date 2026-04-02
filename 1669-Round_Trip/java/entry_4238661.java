import java.io.*;
import java.util.*;

public class entry_4238661 {
 static Scanner sc;
 static PrintWriter pw;
 static ArrayList<Integer>[] adjList;
 static boolean[] vis;

 public static void main(String[] args) throws IOException {
  sc = new Scanner(System.in);
  pw = new PrintWriter(System.out);
  int n = sc.nextInt();
  int m = sc.nextInt();
  adjList = new ArrayList[n + 1];
  vis = new boolean[n + 1];
  for (int i = 1; i <= n; i++)
   adjList[i] = new ArrayList<>();
  while (m-- > 0) {
   int a = sc.nextInt();
   int b = sc.nextInt();
   adjList[a].add(b);
   adjList[b].add(a);
  }
  boolean f = true;
  for (int i = 1; i <= n; i++) {
   if (!vis[i]) {
    ArrayList<Integer> cycle = dfs(i, 0);
    if (cycle != null) {
     f = false;
     StringBuilder sb = new StringBuilder();
     int c = 0;
     boolean ff = false;
     for (int j = cycle.size() - 1; j >= 0; j--) {
      if (cycle.get(j).equals(cycle.get(0)))
       ff = true;
      if (ff) {
       c++;
       sb.append(cycle.get(j) + " ");
      }
     }
     pw.println(c);
     pw.println(sb);
     break;
    }
   }
  }
  if (f)
   pw.println("IMPOSSIBLE");
  pw.close();
 }

 public static ArrayList<Integer> dfs(int curr, int parent) {
  if (vis[curr]) {
   ArrayList<Integer> res = new ArrayList<>();
   res.add(curr);
   return res;
  }
  vis[curr] = true;
  for (int x : adjList[curr]) {
   if (!vis[x] || vis[x] && x != parent) {
    ArrayList<Integer> res = dfs(x, curr);
    if (res != null) {
     res.add(curr);
     return res;
    }
   }
  }
  return null;
 }

 static class Pair {
  int x, y;

  public Pair(int x, int y) {
   this.x = x;
   this.y = y;
  }

  public String toString() {
   return "(" + x + "," + y + ")";
  }
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

  public String[] nextArray(int n) throws IOException {
   String[] a = new String[n];
   for (int i = 0; i < n; i++)
    a[i] = next();
   return a;
  }

  public boolean ready() throws IOException {
   return br.ready();
  }

 }
}