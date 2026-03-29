

import java.io.*;
import java.util.*;

public class entry_5586475 {

 // needed class
 static class Edge {
  int u;
  int v;
  long c;

  public Edge(int u, int v, long c) {
   this.u = u;
   this.v = v;
   this.c = c;
  }

  public String toString() {
   return "{" + this.u + ", " + this.v + ", " + this.c + "}";
  }
 }

 static final long INF = (long)1e18 ;

 //input
 static int n; // no. of nodes
 static int m; // no. of edges
 static ArrayList<Edge> edgeL; // edgeList (list  of all edges of the graph)

 //output

 static long[] dist; // after BellmanFord finishes, the min distance from src to
       // all nodes will be here
 static int[] par; // will be used to retrieve the shortest path itself
 static boolean hasNegCycle; //will be true if there is a negative Cycle reachable
        //from src

 // Note that the nodes are 0-indexed (0, n-1) both inclusive

 public static void bellmanFord(){  //O(n.m)
  dist = new long[n];
  par = new int[n];
  Arrays.fill(dist, 0);

  boolean modified = true;
  for(int i=0 ; i<n-1 && modified; i++){
   modified = false;
   for(int j=0 ; j<m ; j++){
    int u = edgeL.get(j).u;
    int v = edgeL.get(j).v;
    long c = edgeL.get(j).c;
    if(Long.compare(dist[u], INF)<0){
     if(Long.compare(dist[u]+c, dist[v])<0){
      dist[v] = dist[u] + c;
      par[v] = u;
      modified = true;
     }
    }
   }
  }


  //optional 1
  //to check if there is a Neg Cycle reachable from src
  int node = -1;
  hasNegCycle = false;
  for(int j=0 ; j<m ; j++){
   int u = edgeL.get(j).u;
   int v = edgeL.get(j).v;
   long c = edgeL.get(j).c;
   if(Long.compare(dist[u], INF)<0){
    if(Long.compare(dist[u]+c, dist[v])<0){     
     par[v] = u;
     node = u;
     hasNegCycle = true;
     break;
    }
   }
  }


  //optional 2
  //to get a Neg Cycle reachable from src if exists
  if(hasNegCycle){
   pw.println("YES");
   LinkedList<Integer> negCycle = getNegCycle(node);
   for(int x : negCycle)
    pw.print((x+1)+" ");
  }
  else{
   pw.println("NO");
  }



 }

 public static LinkedList<Integer> getNegCycle(int node){
  LinkedList<Integer> negCycle = new LinkedList<>();

  //to make sure that node is in the negCycle
  for(int i=0 ; i<n ; i++){
   node = par[node];
  }
  int y = node;
  do{    
   negCycle.addFirst(node);
   node = par[node];
  }
  while(node != y);

  negCycle.addFirst(y);
  return negCycle;
 }



 public static void doJob() throws Exception {

  // select between doJob and doJobT

  n = sc.nextInt();
  m = sc.nextInt();
  edgeL = new ArrayList<>();
  for(int i=0 ; i<m ; i++)
   edgeL.add(new Edge(sc.nextInt()-1, sc.nextInt()-1, sc.nextLong()));
  bellmanFord();

 }

 public static void doJobT() throws Exception {
  int t = sc.nextInt();
  while (t-- > 0) {
   doJob();
  }
 }

 public static void main(String[] args) throws Exception {
  sc = new Scanner(System.in);
  pw = new PrintWriter(System.out);

  doJob();
  // doJobT();

  pw.flush();
  pw.close();
 }

 /*-----------------------------------------Helpers--------------------------------------------*/

 static Scanner sc;
 static PrintWriter pw;

 static class Scanner {
  StringTokenizer st;
  BufferedReader br;

  public Scanner(InputStream s) {
   br = new BufferedReader(new InputStreamReader(s));
  }

  public Scanner(String r) throws Exception {
   br = new BufferedReader(new FileReader(new File(r)));
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

 // for descending order
 static Comparator<PairI> cI = (p1, p2) -> (p1.x == p2.x) ? p2.y - p1.y
   : p2.x - p1.x;
 static Comparator<PairL> cL = (p1, p2) -> (p1.x == p2.x) ? Long.compare(
   p2.y, p1.y) : Long.compare(p2.x, p1.x);

 // ascending (by default)
 static class PairI implements Comparable<PairI> {
  int x;
  int y;

  public PairI(int xx, int yy) {
   x = xx;
   y = yy;
  }

  public String toString() {
   return "(" + x + " " + y + ")";
  }

  @Override
  public int hashCode() {
   final int prime = 31;
   int result = 1;
   result = prime * result + x;
   result = prime * result + y;
   return result;
  }

  @Override
  public boolean equals(Object obj) {
   if (this == obj)
    return true;
   if (obj == null)
    return false;
   if (getClass() != obj.getClass())
    return false;
   PairI other = (PairI) obj;
   if (x != other.x)
    return false;
   if (y != other.y)
    return false;
   return true;
  }

  @Override
  public int compareTo(PairI other) {
   // TODO Auto-generated method stub
   return (this.x == other.x) ? this.y - other.y : this.x - other.x;
  }

 }

 static class PairL implements Comparable<PairL> {
  long x;
  long y;

  public PairL(long x, long y) {
   this.x = x;
   this.y = y;
  }

  public String toString() {
   return "(" + x + " " + y + ")";
  }

  @Override
  public int hashCode() {
   final int prime = 31;
   int result = 1;
   result = prime * result + (int) (x ^ (x >>> 32));
   result = prime * result + (int) (y ^ (y >>> 32));
   return result;
  }

  @Override
  public boolean equals(Object obj) {
   if (this == obj)
    return true;
   if (obj == null)
    return false;
   if (getClass() != obj.getClass())
    return false;
   PairL other = (PairL) obj;
   if (x != other.x)
    return false;
   if (y != other.y)
    return false;
   return true;
  }

  @Override
  public int compareTo(PairL other) {
   // TODO Auto-generated method stub
   if (this.x == other.x) {
    return Long.compare(this.y, other.y);
   }
   return Long.compare(this.x, other.x);
  }

 }

}





