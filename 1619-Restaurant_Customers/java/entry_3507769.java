import java.io.*;
import java.util.*;
public class entry_3507769 {
 static BufferedReader in;
 static StringTokenizer st;
 static int n;
 static ArrayList<pair> a;
 public static void main(String[] args) throws IOException {
  in = new BufferedReader(new InputStreamReader(System.in));
  init();
  solve();
  in.close();
 }

 static void init() throws IOException {
  n = Integer.parseInt(in.readLine());
  a = new ArrayList<pair>();

  for (int i = 0; i < n; i++) {
   st = new StringTokenizer(in.readLine());
   a.add(new pair(Integer.parseInt(st.nextToken()), 1));
   a.add(new pair(Integer.parseInt(st.nextToken()), -1));
  }
  Collections.sort(a);
 }

 static void solve() throws IOException {
  int ans = 0;
  int max = 0;
  for (pair p : a) {
   ans += p.status;
   max = Math.max(ans, max);
  }
  System.out.println(max);
 }

 static class pair implements Comparable<pair> {
  int time;
  int status;

  pair(int t, int s) {
   time = t;
   status = s;
  }

  public String toString() {
   return time + " " + status;
  }

  @Override
  public int compareTo(entry_3507769.pair o) {
   return this.time - o.time;
  }
 }
}