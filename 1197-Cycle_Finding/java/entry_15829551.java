// /******************************************************************************

// Welcome to GDB Online.
// GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
// C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
// Code, Compile, Run and Debug online from anywhere in world.

// *******************************************************************************/
// import java.util.*;

// public class entry_15829551 {
//   public static void main(String args[]) {
//       Scanner sc = new Scanner(System.in);
//       int n = sc.nextInt();
//       int m = sc.nextInt();

//       final int MAX = Integer.MAX_VALUE;

//       ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
//       int[][] dp = new int[n+1][n+1];

//       for(int i=0;i<n+1;i++){
//         //   adj.add(new ArrayList<>());
//           Arrays.fill(dp[i],MAX);
//         //   dp[i][i] = 0;
//       }

//       for(int i=0;i<m;i++){
//           int a = sc.nextInt();
//           int b = sc.nextInt();
//           int d = sc.nextInt();

//           dp[a][b] = (-1*d);

//         //   adj.get(a).add(new int[]{b,(-1*d)});
//       }

//       for(int i=1;i<=n;i++){
//           for(int x=1;x<=n;x++){
//               for(int y=1;y<=n;y++){
//                   if(dp[x][i] == MAX || dp[i][y] == MAX) continue;
//                   dp[x][y] = Math.min(dp[x][y], (dp[x][i] + dp[i][y]));
//                 //   System.out.println(dp[x][y]);
//               }
//           }
//       }

//      System.out.println((-1*dp[1][n]));
//   }
// }



import java.io.*;
import java.util.*;
class val {
 public int e,s;
 public long w;
 val(int s,int e, long w)
 {
  this.s = s;
  this.e = e;
  this.w = w;
 }
}

public class entry_15829551 {



 static class Reader
 {
  final private int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;
  public Reader()
  {
   din = new DataInputStream(System.in);
   buffer = new byte[BUFFER_SIZE];
   bufferPointer = bytesRead = 0;
  }

  public Reader(String file_name) throws IOException
  {
   din = new DataInputStream(new FileInputStream(file_name));
   buffer = new byte[BUFFER_SIZE];
   bufferPointer = bytesRead = 0;
  }

  public String readLine() throws IOException
  {
   byte[] buf = new byte[64]; // line length
   int cnt = 0, c;
   while ((c = read()) != -1)
   {
    if (c == '\n')
     break;
    buf[cnt++] = (byte) c;
   }
   return new String(buf, 0, cnt);
  }

  public int nextInt() throws IOException
  {
   int ret = 0;
   byte c = read();
   while (c <= ' ')
    c = read();
   boolean neg = (c == '-');
   if (neg)
    c = read();
   do
   {
    ret = ret * 10 + c - '0';
   }  while ((c = read()) >= '0' && c <= '9');

   if (neg)
    return -ret;
   return ret;
  }

  public long nextLong() throws IOException
  {
   long ret = 0;
   byte c = read();
   while (c <= ' ')
    c = read();
   boolean neg = (c == '-');
   if (neg)
    c = read();
   do {
    ret = ret * 10 + c - '0';
   }
   while ((c = read()) >= '0' && c <= '9');
   if (neg)
    return -ret;
   return ret;
  }

  public double nextDouble() throws IOException
  {
   double ret = 0, div = 1;
   byte c = read();
   while (c <= ' ')
    c = read();
   boolean neg = (c == '-');
   if (neg)
    c = read();

   do {
    ret = ret * 10 + c - '0';
   }
   while ((c = read()) >= '0' && c <= '9');

   if (c == '.')
   {
    while ((c = read()) >= '0' && c <= '9')
    {
     ret += (c - '0') / (div *= 10);
    }
   }

   if (neg)
    return -ret;
   return ret;
  }

  private void fillBuffer() throws IOException
  {
   bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
   if (bytesRead == -1)
    buffer[0] = -1;
  }

  private byte read() throws IOException
  {
   if (bufferPointer == bytesRead)
    fillBuffer();
   return buffer[bufferPointer++];
  }

  public void close() throws IOException
  {
   if (din == null)
    return;
   din.close();
  }
 }

 static class Edge implements Comparable<Edge> {
  int s, d;
  long dist;

  Edge(int s, int d, long dist) {
   this.s = s;
   this.d = d;
   this.dist = dist;
  }

  @Override
  public int compareTo(Edge o) {
   return Long.compare(this.dist, o.dist);
  }
 }

 static final long MAX = Long.MAX_VALUE;
 static boolean[] visited;
 static String solve(int n, int m, ArrayList<Edge> adj, long[] dist, int[] prev) {
  visited = new boolean[n];

  int cycleElement = -1;
  int v = n;
  boolean[] visited = new boolean[n+1];
//   for(int src=1; src<=n; src++) {
//    if(visited[src]) continue;
   v = n;
//    dist[src] = 0;
   while(v-->=0) {
    cycleElement = -1;
    for(Edge e: adj) {
     int a = e.s;
     int b = e.d;
     long dd = e.dist;
    //  System.out.println("A "+a+" "+b+" "+dist[a]); 
     if(dist[a] == MAX) continue;
     visited[a] = true;
     visited[b] = true;
    //  System.out.println("B "+a+" "+b+" "+dist[a]); 
     if(dist[b] > dd+dist[a]) {
      dist[b] = dd+dist[a];
      prev[b] = a;
      cycleElement = b;
     }


    }
    // if(cycleElement!=-1) break;
   }
//    if(cycleElement!=-1) break;
//   }

//   while(v-->=0) {
//    cycleElement = -1;
//    for(Edge e: adj) {
//     int a = e.s;
//     int b = e.d;
//     long dd = e.dist;
//     if(dist[a] == MAX) continue;
//     // visited[a] = true;
//     // visited[b] = true;
//     if(dist[b] > dd+dist[a]) {
//     //  dist[b] = dd+dist[a];
//     //  prev[b] = a;
//      cycleElement = b;
//     }

//    }
//   }

//   System.out.println(cycleElement);
  StringBuffer str = new StringBuffer("");

  if(cycleElement == -1) str.append("NO");
  else {
   for(int i=0; i<n; i++) {
    //   System.out.println(cycleElement+" "+prev[cycleElement]);
       cycleElement = prev[cycleElement];

   }

   int end = cycleElement;
   str.append("YES\n");
   HashSet<Integer> visi = new HashSet<>();
   String s = cycleElement+" ";
   while(true) {
    // if(v==1) System.out.println(end+" "+prev[end]);
    end = prev[end];
    s = end+" "+s;
    visi.add(end);
    if(end==cycleElement && visi.size()>0) break;
   }
   str.append(s);
  }
  return str.toString();

 }


 public static void main(String[] args) throws IOException {
  OutputStream outputStream = System.out;
  PrintWriter pw = new PrintWriter(outputStream);
  Reader s = new Reader();
  int n = s.nextInt();
  int m = s.nextInt();

  long[][] dp = new long[n+1][n+1];
  ArrayList<Edge> adj = new ArrayList<>();
  int[] prev = new int[n+1];

  Arrays.fill(prev,-1);
  long[] dist = new long[n+1];

  Arrays.fill(dist,MAX);
  for(int i=0; i<=n; i++) {
   Arrays.fill(dp[i],MAX);
  }
  boolean cycleDetected = false;
  int cycleElement = -1;
  for(int i=1; i<=m; i++) {
   int a = s.nextInt();
   int b = s.nextInt();
   long d = s.nextLong();

   adj.add(new Edge(a,b,d));
//    System.out.println(a+" "+b); .
   if(a == b && d < 0) {
    cycleDetected = true;
    cycleElement = a;
   }
   dist[b] = a;
  }
  String ans = "";
  if(!cycleDetected) ans = solve(n,m,adj, dist, prev);
  else ans = ("YES\n"+cycleElement+" "+cycleElement);
//   (int n, int m, ArrayList<Edge> adj,boolean[] visi, int[] prev) {
  // System.out.println(ans);
  pw.println(ans);
  pw.close();

 }

}






