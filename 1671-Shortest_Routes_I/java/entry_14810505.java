import java.io.*;
import java.util.*;

public class entry_14810505 {
 static BufferedReader br;
 static StringTokenizer st;
 static PrintWriter out;

 public static void main(String[] args) {
  try {
   boolean isOnlineJudge = System.getProperty("ONLINE_JUDGE") != null || System.getenv("ONLINE_JUDGE") != null;

   if (!isOnlineJudge) {
    // Use standard I/O for Codeforces/online judges
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
   } else {
    // Use file I/O for local testing
    br = new BufferedReader(new FileReader("input.txt"));
    out = new PrintWriter(new FileWriter("output.txt"));
   }

   int t = 1;
   while (t-- > 0) {
    solve();
   }
   out.flush();
   out.close();
  } catch (Exception e) {
   System.err.println(e.getStackTrace()[0]);
   System.err.println(e);
  }
 }

 static class Pair {
  int d;
  long w;
  Pair(int d, long w) {
   this.d = d;
   this.w = w;
  }
 }

 // static long[] findShortestPath(ArrayList<ArrayList<Pair>> a, int n) {
 //  long[] dist = new long[n + 1];
 //  Arrays.fill(dist, Long.MAX_VALUE);
 //  PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(pair -> pair.w));
 //  dist[1] = 0;
 //  pq.add(new Pair(1, 0));
 //  while (!pq.isEmpty()) {
 //   Pair curr = pq.poll();
 //   if (curr.w != dist[curr.d]) continue;
 //   for (Pair p : a.get(curr.d)) {
 //    long nd = curr.w + p.w;
 //    if (nd < dist[p.d]) {
 //     dist[p.d] = nd;
 //     pq.add(new Pair(p.d, nd));
 //    }
 //   }
 //  }
 //  return dist;
 // }

 static long[] findShortestPath(ArrayList<ArrayList<Pair>> a, int n) {
  long[] dist = new long[n + 1];
  Arrays.fill(dist, Long.MAX_VALUE);

  PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(pair -> pair.w));
  dist[1] = 0;
  pq.add(new Pair(1, 0));

  while (!pq.isEmpty()) {
   Pair curr = pq.poll();
   if (curr.w > dist[curr.d]) continue; // ✅ skip outdated entries

   for (Pair p : a.get(curr.d)) {
    long nd = curr.w + p.w;
    if (nd < dist[p.d]) {
     dist[p.d] = nd;
     pq.add(new Pair(p.d, nd));
    }
   }
  }
  return dist;
 }

 // static long[] findShortestPath(ArrayList<ArrayList<Pair>> a, int n) {
 //  long[] dist = new long[n + 1];
 //  Arrays.fill(dist, Integer.MAX_VALUE);
 //  PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingLong(x -> dist[x]));
 //  pq.add(1);
 //  dist[1] = 0;
 //  while (!pq.isEmpty()) {
 //   int curr = pq.poll();
 //   for (Pair p : a.get(curr)) {
 //    if (dist[curr] + p.w < dist[p.d]) {
 //     dist[p.d] = dist[curr] + p.w;
 //     pq.add(p.d);
 //    }
 //   }
 //  }
 //  return dist;
 // }

 static void solve() throws IOException {
  int n = nextInt();
  int m = nextInt();
  ArrayList<ArrayList<Pair>> a = new ArrayList<>();
  for (int i = 0; i < n + 1; i++) a.add(new ArrayList<>());
  for (int i = 0; i < m; i++) {
   int x = nextInt();
   int y = nextInt();
   int z = nextInt();
   a.get(x).add(new Pair(y, z));
  }
  long[] dist = findShortestPath(a, n);
  for (int i = 1; i < n + 1; i++)
   out.print(dist[i] + " ");
 }

 static void getIntArray(int[] ar) throws IOException {
  for (int i = 0; i < ar.length; i++)
   ar[i] = nextInt();
 }
 static void getLongArray(long[] ar) throws IOException {
  for (int i = 0; i < ar.length; i++)
   ar[i] = nextInt();
 }
 static void printArray(int[] ar) throws IOException {
  for (int i = 0; i < ar.length; i++)
   out.print(ar[i] + " ");
  out.println();
 }
 static void printArray(long[] ar) throws IOException {
  for (int i = 0; i < ar.length; i++)
   out.print(ar[i] + " ");
  out.println();
 }
 static void printArray(char[] ar) throws IOException {
  for (int i = 0; i < ar.length; i++)
   out.print(ar[i] + " ");
  out.println();
 }

 static <T> void printArray(ArrayList<T> ar) throws IOException {
  for (T temp : ar)
   out.print(temp + " ");
  out.println();
 }

 static void reverseArray(int[] ar, int l, int r) {
  while (l < r) {
   int temp = ar[l];
   ar[l] = ar[r];
   ar[r] = temp;
   l++;
   r--;
  }
 }

 static int nextInt() throws IOException {
  return Integer.parseInt(next());
 }

 static long nextLong() throws IOException {
  return Long.parseLong(next());
 }

 static double nextDouble() throws IOException {
  return Double.parseDouble(next());
 }

 static String next() throws IOException {
  while (st == null || !st.hasMoreTokens()) {
   st = new StringTokenizer(br.readLine());
  }
  return st.nextToken();
 }

 static String nextLine() throws IOException {
  st = null;
  return br.readLine();
 }
}