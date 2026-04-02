import java.util.*;
import java.io.*;
public class entry_3271198 {
   public static int N;
   public static int M;
   public static int head[];
   public static EdgeData edges[];
   public static int team[];
   public static int edgeCount=0;
   public static boolean impossible=false;
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s=new StringTokenizer(br.readLine());
      N=Integer.parseInt(s.nextToken());
      M=Integer.parseInt(s.nextToken());
      head=new int[N];
      edges=new EdgeData[2*M];
      team=new int[N];
      Arrays.fill(head,-1);
      for(int i=0;i<M;i++){
         s=new StringTokenizer(br.readLine());
         int a=Integer.parseInt(s.nextToken())-1;
         int b=Integer.parseInt(s.nextToken())-1;
         addEdge(a,b);
         addEdge(b,a);
      }
      for(int i=0;i<N;i++){
         if(team[i]==0){
            dfs(i,1);
            if(impossible){
               System.out.println("IMPOSSIBLE");
               break;
            }
         }
      }
      if(!impossible){
         for(int i=0;i<N;i++){
            System.out.print(team[i]+" ");
         }
      }
   }
   public static void addEdge(int from, int to){
      edges[edgeCount]=new EdgeData();
      edges[edgeCount].to=to;
      edges[edgeCount].next=head[from];
      head[from]=edgeCount;
      edgeCount++;
   }
   public static void dfs(int index, int color){
      if(impossible)return;
      if(team[index]>0){
         if(team[index]!=color){
            impossible=true;
         }
         return;
      }
      team[index]=color;
      for(int curEdgeIndex=head[index];curEdgeIndex!=-1;curEdgeIndex=edges[curEdgeIndex].next){
         int v=edges[curEdgeIndex].to;
         if(color==1)dfs(v,2);
         else dfs(v,1);
      }
   }
}
class EdgeData{
   int to, next;
}