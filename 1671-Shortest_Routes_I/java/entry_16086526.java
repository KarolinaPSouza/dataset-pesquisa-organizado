import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class entry_16086526 {

 static class FastScanner {
     BufferedReader br;
     StringTokenizer st;
     FastScanner(InputStream in) {
         br = new BufferedReader(new InputStreamReader(in));
     }
     String next() throws IOException {
         while (st == null || !st.hasMoreTokens())
             st = new StringTokenizer(br.readLine());
         return st.nextToken();
     }
     int nextInt() throws IOException {
         return Integer.parseInt(next());
     }
     long nextLong() throws IOException {
         return Long.parseLong(next());
     }
     String nextLine() throws IOException {
         return br.readLine();
     }
 }
 public static void main(String...strings) throws IOException{
  FastScanner sc=new FastScanner(System.in);
  int n=sc.nextInt();
  int m=sc.nextInt();
  List<List<int[]>> list=new ArrayList<>();
  long[] dist_mat=new long[n+1];
  boolean[] visited=new boolean[n+1];
  for(int i=0;i<=n;i++) {
   list.add(new ArrayList<int[]>());
   dist_mat[i]=(long)1e18;
  }
  while(m-->0) {
   int strt=sc.nextInt();
   int dest=sc.nextInt();
   int weight=sc.nextInt();
   list.get(strt).add(new int[] {dest,weight});
  }
  PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

  pq.add(new long[] {1,0});
  dist_mat[1]=0;
  while(!pq.isEmpty()) {
   long[] cell=pq.poll();
   long node=cell[0];
   long distance=cell[1];
   if(visited[(int)node])continue;
   visited[(int) node]=true;
   if(distance>dist_mat[(int)node]) continue;
   for(int i=0;i<list.get((int) node).size();i++) {
    int adj_node=list.get((int) node).get(i)[0];
    int dist=list.get((int) node).get(i)[1];
    long ans=distance+dist;
    if(ans<dist_mat[adj_node]) {
//     if(dist_mat[adj_node]!=(long)1e18) {
//      pq.remove(new long[] {adj_node,dist_mat[(int)adj_node]});
//     }
     dist_mat[adj_node]=ans;
     pq.add(new long[] {adj_node,ans});
    }
   }
  }
  StringBuilder sb=new StringBuilder();
  for(int i=1;i<=n;i++) sb.append(dist_mat[i]+" ");
  System.out.println(sb.toString());
 }
}