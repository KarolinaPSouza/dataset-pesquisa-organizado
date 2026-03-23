import java.util.*;
import java.io.*;
public class entry_15532576 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        ArrayList<Integer> a[]=new ArrayList[n+1];
        for(int i=1;i<a.length;i++){
            a[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
             int u=Integer.parseInt(st.nextToken());
             int v=Integer.parseInt(st.nextToken());
             a[u].add(v);
             a[v].add(u);
        }
        long dis[]=new long[n+1];
        boolean b[]=new boolean[n+1];
        bfs(a,dis,b,1);
        long max=0;
        int node=0;
        for(int i=1;i<dis.length;i++){
            // System.out.print(dis[i]+" ");
            if(max<=dis[i]){
                max=dis[i];
                node=i;
            }
        }
        // System.out.println(node);
        long dis1[]=new long[n+1];
        boolean b1[]=new boolean[n+1];
        bfs(a,dis1,b1,node);
        long max1=0;
        for(int i=1;i<dis1.length;i++){
              if(max1<=dis1[i]){
                max1=dis1[i];
            }
        }
        System.out.println(max1);
    }
    static void bfs(ArrayList<Integer> a[],long dis[],boolean b[],int node){
          Queue<Integer> q=new ArrayDeque<>();
          q.add(node);
          dis[node]=0;
          while(!q.isEmpty()){
             int x=q.poll();
             b[x]=true;
             for(int i:a[x]){
                if(!b[i]){
                   q.add(i);
                   dis[i]=dis[x]+1;
                }
             }
          }
        }
    }