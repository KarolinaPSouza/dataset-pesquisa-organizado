import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class entry_6828974 {

 final long INF = 1000000000000000000L;

 void solve()
 {
  int n = in.nextInt();
  int m = in.nextInt();
  int q = in.nextInt();

  long[][] adj = new long[n][n];
  for(int i=0;i<n;i++)
   for(int j=0;j<n;j++)
    adj[i][j] = i==j?0L:INF;

  for(int i=0;i<m;i++)
  {
   int u = in.nextInt()-1;
   int v = in.nextInt()-1;
   int c = in.nextInt();
   adj[u][v]=adj[v][u] = Math.min(adj[u][v], c);
  }

  for(int k=0;k<n;k++)
   for(int i=0;i<n;i++)
    for(int j=0;j<n;j++)
     adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);

  for(int i=0;i<q;i++)
  {
   int u = in.nextInt()-1;
   int v = in.nextInt()-1;
   out.println((adj[u][v] == INF)?-1:adj[u][v]);


  }
 }

 static Random rand = new Random(); 
 public static void safeSort(int[] arr)
 {
  int n = arr.length;
  while(n>1)
  {
   int pos = rand.nextInt(n);
   int tmp = arr[pos];
   arr[pos] = arr[n-1];
   arr[n-1] = tmp;
   n--;
  }
  Arrays.sort(arr);
 }

 public static void safeSort(long[] arr)
 {
  int n = arr.length;
  while(n>1)
  {
   int pos = rand.nextInt(n);
   long tmp = arr[pos];
   arr[pos] = arr[n-1];
   arr[n-1] = tmp;
   n--;
  }
  Arrays.sort(arr);
 }

 private SuperQuickReader in;
 private PrintWriter out;
 public entry_6828974(SuperQuickReader in, PrintWriter out) {
  this.in = in;
  this.out = out;
 }

 public static void main(String[] args) throws IOException {
  SuperQuickReader in = new SuperQuickReader(System.in);

  try(PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));)
  {
   new entry_6828974(in, out).solve();
  }
 }

}

class QuickReader {
 BufferedReader in;
 StringTokenizer token;

 public QuickReader(InputStream ins) {
  in = new BufferedReader(new InputStreamReader(ins));
  token = new StringTokenizer("");
 }

 public boolean hasNext() {
  while (!token.hasMoreTokens()) {
   try {
    String s = in.readLine();
    if (s == null)
     return false;
    token = new StringTokenizer(s);
   } catch (IOException e) {
    throw new InputMismatchException();
   }
  }
  return true;
 }

 public String next() {
  hasNext();
  return token.nextToken();
 }

 public int nextInt() {
  return Integer.parseInt(next());
 }

 public int[] nextInts(int n) {
  int[] res = new int[n];
  for (int i = 0; i < n; i++)
   res[i] = nextInt();
  return res;
 }

 public long nextLong() {
  return Long.parseLong(next());
 }

 public long[] nextLongs(int n) {
  long[] res = new long[n];
  for (int i = 0; i < n; i++)
   res[i] = nextLong();
  return res;
 }

}

class SuperQuickReader
{
 final int BUFFER_SIZE = 4096;
 Reader in;

 char[] buf = new char[BUFFER_SIZE];
 int bufL, bufR;

 public SuperQuickReader(InputStream ins)
 {
  in=new InputStreamReader(ins);
 }

 public char nextChar()
 {
  try {
   while(bufR >= 0)
   {
    if(bufL < bufR)
    {
     char x = buf[bufL++];
     return x;
    }
    else
    {
     bufR = in.read(buf);
     bufL = 0;
    }
   }
  }
  catch(IOException e)
  {
   bufL = bufR = -1;
  }
  return 0;
 }

 public char nextNonSpaceChar()
 {
  char c;
  do
  {
   c = nextChar();
  }while(c == ' ' || c == '\n');
  return c;
 }

 public int nextInt()
 {
  int res = 0;
  char c;
  do
  {
   c = nextChar();
  }
  while(c==' ' || c=='\n');

  do
  {
   res = res * 10 + (c-'0');
   c = nextChar();
  }
  while(c!=' ' && c!='\n' && c!=0);

  return res;
 }

 public int[] nextInts(int n)
 {
  int[] res = new int[n];
  for (int i = 0; i < n; i++)
   res[i] = nextInt();
  return res;
 }

}