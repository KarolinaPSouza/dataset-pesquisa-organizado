import java.io.*;
import java.util.*;

public class entry_14620302 {
 static BufferedReader br;
 static StringTokenizer st;
 static PrintWriter out;

 public static void main(String[] args) {
  try {
   boolean isOnlineJudge = System.getProperty("ONLINE_JUDGE") != null || System.getenv("ONLINE_JUDGE") != null;

   if (true) {
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

 static class Node {
  int id;
  Node parent;
  Node(int id, Node parent) {
   this.id = id;
   this.parent = parent;
  }
 }

 static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> gp, int node, int n) {
  boolean[] vis = new boolean[n];
  Queue<Node> qq = new LinkedList<>();
  Node head = new Node(node, null);
  qq.add(head);
  ArrayList<Integer> path = new ArrayList<>();
  vis[node] = true;
  while (!qq.isEmpty()) {
   Node curr = qq.poll();
   if (curr.id == n - 1) {
    while (curr != null) {
     path.add(curr.id + 1);
     curr = curr.parent;
    }
    Collections.reverse(path);
    return path;
   }
   for (int k : gp.get(curr.id)) {
    if (!vis[k]) {
     vis[k] = true;
     qq.add(new Node(k, curr));
    }
   }
  }
  return path;
 }

 static void solve() throws IOException {
  int n = nextInt();
  int m = nextInt();
  ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
  for (int i = 0; i < n; i++)
   gp.add(new ArrayList<>());
  for (int i = 0; i < m; i++) {
   int ff = nextInt();
   int ss = nextInt();
   ff--; ss--;
   gp.get(ff).add(ss);
   gp.get(ss).add(ff);
  }
  ArrayList<Integer> ans = bfs(gp, 0, n);
  if (ans.size() == 0)
   out.println("IMPOSSIBLE");
  else {
   out.println(ans.size());
   for (int k = 0; k < ans.size(); k++)
    out.print(ans.get(k) + " ");
  }
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