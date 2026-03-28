import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class entry_6876070 {

 final static int MOD = 1000000007;
 final static long INF = 1000000000000000000L;

 int n;
 int[] hd;
 int[] to, nxt;

 int[] distance;

 void solve()
 {
  n  = in.nextInt();

  int V = n;
  int E = 2*(n-1);

  hd = new int[V];
  to = new int[E];
  nxt = new int[E];
  Arrays.fill(hd, -1);
  for(int i=0;i<n-1;i++)
  {
   int a = in.nextInt()-1;
   int b = in.nextInt()-1;
   to[2*i] = a;
   nxt[2*i] = hd[b];
   hd[b] = 2*i;
   to[2*i+1] = b;
   nxt[2*i+1] = hd[a];
   hd[a] = 2*i+1;
  }

  distance = new int[n];
  fillDistance(0, -1);
  int k = 0;
  for(int i=1;i<n;i++)
   if(distance[i] > distance[k])
    k = i;
  fillDistance(k, -1);
  int k1 = 0;
  for(int i=1;i<n;i++)
   if(distance[i] > distance[k1])
    k1 = i;

  int[] d1 = distance.clone();
  fillDistance(k1, -1);
  int[] d2 = distance;

  for(int i=0;i<n;i++)
   if(d2[i] < d1[i])
    d2[i] = d1[i];
  printlnArray(d2);
 }

 int[] stack;
 int stackTop;
 private void fillDistance(int cur, int par) {
  if(stack == null)
   stack = new int[n];
  stackTop = 0;

  stack[stackTop++] = cur;
  Arrays.fill(distance, Integer.MAX_VALUE);
  distance[cur] = 0;
  while(stackTop>0)
  {
   cur = stack[--stackTop];
   for(int e = hd[cur]; e!=-1; e=nxt[e])
   {
    int t = to[e];
    if(distance[t] == Integer.MAX_VALUE)
    {
     distance[t] = distance[cur]+1;
     stack[stackTop++] = t;
    }
   }
  }
 }

 public void printlnArray(int[] array)
 {
  for(int i=0;i<array.length;i++)
  {
   if(i!=0)
    out.print(" ");
   out.print(array[i]);
  }
  out.println();
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


 public entry_6876070(SuperQuickReader in, PrintWriter out) {
  this.in = in;
  this.out = out;
 }

 public static void main(String[] args) throws IOException {
  SuperQuickReader in = new SuperQuickReader(System.in);

  try(PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));)
  {
   new entry_6876070(in, out).solve();
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
  boolean neg = false;
  do
  {
   c = nextChar();
  }
  while(c==' ' || c=='\n');
  if(c == '-')
  {
   neg = true;
   c = nextChar();
  }

  do
  {
   res = res * 10 + (c-'0');
   c = nextChar();
  }
  while(c!=' ' && c!='\n' && c!=0);
  if(neg) res = -res;
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