import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class entry_5487228 {

 private static class Kattio extends PrintWriter {
     public Kattio(InputStream i) {
  super(new BufferedOutputStream(System.out));
  r = new BufferedReader(new InputStreamReader(i));
     }
     public Kattio(InputStream i, OutputStream o) {
  super(new BufferedOutputStream(o));
  r = new BufferedReader(new InputStreamReader(i));
     }

     public boolean hasMoreTokens() {
  return peekToken() != null;
     }

     public int getInt() {
  return Integer.parseInt(nextToken());
     }

     public double getDouble() { 
  return Double.parseDouble(nextToken());
     }

     public long getLong() {
  return Long.parseLong(nextToken());
     }

     public String getWord() {
  return nextToken();
     }



     private BufferedReader r;
     private String line;
     private StringTokenizer st;
     private String token;

     private String peekToken() {
  if (token == null) 
      try {
   while (st == null || !st.hasMoreTokens()) {
       line = r.readLine();
       if (line == null) return null;
       st = new StringTokenizer(line);
   }
   token = st.nextToken();
      } catch (IOException e) { }
  return token;
     }

     private String nextToken() {
  String ans = peekToken();
  token = null;
  return ans;
     }
 }

 private static class Path implements Comparable {
  private int dest;
  private long cost;
  Path(int d, long l) {
   dest = d;
   cost = l;
  }
  public int compareTo(Object other) {
   return Long.compare(cost, ((Path) other).cost);
  }
  public String toString() {
   return "Dest from start: " + dest + ". Cost: " + cost;
  }
 }

 private static class Node implements Comparable {
  private int ID;
  private ArrayList<Edge> neighbors;
  private boolean visited;
  private long cost;
  Node(int ID) {
   this.ID = ID;
   neighbors = new ArrayList<>();
   visited = false;
   cost = Long.MAX_VALUE;
  }
  void addEdge(Edge e) {
   neighbors.add(e);
  }
  public int compareTo(Object o) {
   return Long.compare(cost, ((Node) o).cost);
  }
 }

 private static class Edge {
  private int weight;
  private Node dest;
  Edge(int weight, Node dest) {
   this.weight = weight;
   this.dest = dest;
  }
 }

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  final long INF = (long) 1e12;
  Kattio k = new Kattio(System.in, System.out);
  int n = k.getInt();
  int m = k.getInt();
  int q = k.getInt();
  // create dmat
  long[][] dmat = new long[n][n];
  // initialize everything else to infinity, and set distance from a node to itself to 0
  for(int i = 0; i < n; i++) {
   for(int j = 0; j < n; j++) {
    if(i != j) dmat[i][j] = INF;
   }
  }
  // then fill in all the edges
  for(int i = 0; i < m; i++) {
   int a = k.getInt();
   int b = k.getInt();
   int cost = k.getInt();
   dmat[a - 1][b - 1] = Math.min(dmat[a-1][b-1], cost);
   dmat[b - 1][a - 1] = Math.min(dmat[a-1][b-1], cost);
  }
  for(int i = 0; i < n; i++) {
   for(int j = 0; j < n; j++) {
    for(int l = 0; l < n; l++) {
     if(dmat[j][l] > dmat[j][i] + dmat[i][l]) {
      dmat[j][l] = dmat[j][i] + dmat[i][l];
     }
    }
   }
  }

  for(int i = 0; i < q; i++) {
   int src = k.getInt();
   int dest = k.getInt();
   k.println(dmat[src - 1][dest - 1] != INF ? dmat[src-1][dest-1] : -1);
  }
  k.close();
 }

}