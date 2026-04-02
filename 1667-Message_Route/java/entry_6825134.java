import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class entry_6825134 {

 public static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
 public static final char[] dFrom = {'D','U','R','L'};

 int[] par;

 int get(int x)
 {
  if(par[x] == x) return x;
  return par[x] = get(par[x]);
 }

 void unite(int a, int b)
 {
  par[get(a)] = get(b);
 }

 void solve()
 {
  int n = in.nextInt();
  int m = in.nextInt();

  int[] hd = new int[n];
  int[] to = new int[2*m];
  int[] nxt = new int[2*m];
  Arrays.fill(hd,  -1);

  for(int i=0;i<m;i++)
  {
   int a = in.nextInt()-1;
   int b = in.nextInt()-1;
   to[2*i] = b;
   nxt[2*i] = hd[a];
   hd[a] = 2*i;

   to[2*i+1] = a;
   nxt[2*i+1] = hd[b];
   hd[b] = 2*i+1;
  }

  Integer[] prev = new Integer[n];
  Arrays.fill(prev, Integer.MIN_VALUE);

  prev[0] = -1;
  Queue<Integer> q = new ArrayDeque<>();
  q.add(0);
  while(!q.isEmpty())
  {
   Integer x = q.poll();

   for(int e = hd[x]; e != -1; e = nxt[e])
   {
    if(prev[to[e]].equals( Integer.MIN_VALUE ) )
    {
     prev[to[e]] = x;
     q.add(to[e]);
    }
   }
  }

  if(prev[n-1] == Integer.MIN_VALUE)
   out.println("IMPOSSIBLE");
  else
  {
   ArrayList<Integer> path = new ArrayList<Integer>();
   Integer cur = n-1;
   while(cur != -1)
   {
    path.add(cur);
    cur = prev[cur];
   }
   out.println(path.size());
   for(int i=path.size()-1;i>=0;i--)
   {
    if(i!=path.size()-1)
     out.print(" "); 
    out.print(path.get(i)+1);
   }
  }
 }

 static class Edge
 {
  int a,b;

  Edge(int a, int b) {
   super();
   this.a = a;
   this.b = b;
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

 private QuickReader in;
 private PrintWriter out;
 public entry_6825134(QuickReader in, PrintWriter out) {
  this.in = in;
  this.out = out;
 }

 public static void main(String[] args) throws IOException {
  QuickReader in = new QuickReader(System.in);

  try(PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));)
  {
   new entry_6825134(in, out).solve();
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