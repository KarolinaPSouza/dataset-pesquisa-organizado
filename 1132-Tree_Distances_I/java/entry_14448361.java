import java.util.*;
import java.io.*;

class Tree{
 static int[] bfs(int i,List<List<Integer>> adj){
  int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
  Queue<Integer> q=new LinkedList<>();
  q.add(i);
  dist[i]=0;
  while(!q.isEmpty()){
   int x=q.poll();
   for(int ne:adj.get(x)){
    if(dist[ne]==-1){
     dist[ne]=dist[x]+1;
     q.add(ne);
    }
   }
  }
  return dist;
 }
 public static void main(String arga[]) throws IOException{
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  int n=Integer.parseInt(br.readLine());
  List<List<Integer>> adj=new ArrayList<>();
  for(int i=0;i<n;i++) adj.add(new ArrayList<>());
  for(int i=0;i<n-1;i++){
   StringTokenizer st=new StringTokenizer(br.readLine());
   int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
  }
  int first[]=bfs(0,adj);
  int A=0;
  for(int i=0;i<n;i++) if(first[A]<first[i]) A=i;
  int distA[]=bfs(A,adj);
  int B=A;
  for(int i=0;i<n;i++) if(distA[i]>distA[B]) B=i;
  int distB[]=bfs(B,adj);
  StringBuilder sb=new StringBuilder();
  for(int i=0;i<n;i++) sb.append(Math.max(distA[i],distB[i])).append(" ");
  PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  pw.println(sb.toString().trim());
  pw.flush();
 }
}