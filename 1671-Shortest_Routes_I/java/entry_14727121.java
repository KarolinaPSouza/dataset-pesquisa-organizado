import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.*;

public class entry_14727121 {
 private static int n, m;
 private static List<List<List<Integer>>> adjList = new ArrayList<>();
 private static long[] dist;
 private static Set<Integer> visited = new HashSet<>();

 private static class DijkstraEntry implements Comparable<DijkstraEntry> {
  public int node;
  public long dist;

  public DijkstraEntry(int node, long dist) {
   this.node = node;
   this.dist = dist;
  }

  public int compareTo(DijkstraEntry a) {
   if (this.dist > a.dist) return 1;
   else if (this.dist < a.dist) return -1;
   else return 0;
  }
 }

 private static void traverse() {
  PriorityQueue<DijkstraEntry> pq = new PriorityQueue<>();

  pq.add(new DijkstraEntry(0, 0));

  while (pq.size() != 0) {
   int node = pq.peek().node;
   long depth = pq.poll().dist;

   if (visited.contains(node)) continue;
   visited.add(node);
   dist[node] = depth;

   for (List<Integer> neigh : adjList.get(node)) {
    if (visited.contains(neigh.get(0))) continue;
    pq.add(new DijkstraEntry(neigh.get(0), depth+neigh.get(1)));
   }
  }
 }

 private static void solve(FastScanner fs, PrintWriter pw) {
  n = fs.nextInt();
  m = fs.nextInt();

  for (int i = 0; i < n; i++) {
   adjList.add(new ArrayList<>());
  }

  for (int i = 0; i < m; i++) {
   int a = fs.nextInt()-1, b = fs.nextInt()-1, w = fs.nextInt();

   adjList.get(a).add(List.of(b, w));
  }

  dist = new long[n];
  Arrays.fill(dist, -1);
  traverse();

  for (int i = 0; i < n; i++) {
   pw.print(dist[i] + " ");
  }
 }

 private static void precompute() {

 }

    public static void main(String[] args) {
     FastScanner fs = new FastScanner();
  PrintWriter pw = new PrintWriter(System.out);

  precompute();
  int t = 1;
  // t = fs.nextInt();
  while (t-- > 0) {
   solve(fs, pw);
  }

  pw.flush();
    }

 static class FastScanner {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
   while (!st.hasMoreTokens())
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  int[] readIntArray(int n) {
   int[] a = new int[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }

  long[] readLongArray(int n) {
   long[] a = new long[n];
   for (int i = 0; i < n; i++)
    a[i] = nextLong();
   return a;
  }

  long nextLong() {
   return Long.parseLong(next());
  }
 }
}