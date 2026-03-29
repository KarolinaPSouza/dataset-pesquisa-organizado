import java.util.*;
import java.io.*;

class CSES1140 {
 static BufferedReader br;
 static StringTokenizer st;
 static PrintWriter pw;

 static int ni() { 
  return Integer.parseInt(st.nextToken());
 }

 static class Project implements Comparable<Project> {
  int start , end , profit;

  public Project(int start , int end , int profit) {
   this.start = start;
   this.end = end;
   this.profit = profit;
  }

  public int compareTo(Project that) {
   return this.end - that.end;
  }
 }

 /*
   */

 public static void main(String args[])throws Exception {
  br = new BufferedReader(new InputStreamReader(System.in));
  st = new StringTokenizer(br.readLine());
  pw = new PrintWriter(System.out);

  int n = ni();
  Project p[] = new Project[n + 1];

  p[0] = new Project(0 , 0 , 0);

  for (int i = 1; i <= n; ++i) {
   st = new StringTokenizer(br.readLine());
   p[i] = new Project(ni() , ni() , ni());
  }

  Arrays.sort(p);

  long dp[] = new long[n + 1];
  dp[0] = 0;
  dp[1] = p[1].profit;
  long ans = dp[1];

  for (int i = 1; i <= n; ++i) {
   int lo = 0 , hi = i - 1;
   int max = -1;
   while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (p[mid].end < p[i].start) {
     max = Math.max(max , mid);
     lo = mid + 1;
    }
    else hi = mid - 1;
   }
   dp[i] = Math.max(dp[i - 1] , p[i].profit + dp[max]);
   ans = Math.max(ans , dp[i]);
  }

  pw.println(ans);

  pw.close();
  br.close();
 }
}