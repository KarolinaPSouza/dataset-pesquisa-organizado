import java.io.*;
import java.util.*;
public class entry_15422196 {
    static List<List<Integer>> adj;
    static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        adj=new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){
            String[] a=br.readLine().split(" ");
            int u=Integer.parseInt(a[0]),v=Integer.parseInt(a[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] dist1=dfs(1);
        int farA=1;
        for(int i=1;i<=n;i++){
            if(dist1[i]>dist1[farA])farA=i;
        }
        int[] distA=dfs(farA);
        int farB=farA;
        for(int i=1;i<=n;i++){
            if(distA[i]>distA[farB])farB=i;
        }
        int[] distB=dfs(farB);
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(Math.max(distA[i],distB[i])).append(" ");
        }
        System.out.println(sb);
    }
    public static int[] dfs(int start){
        int[] dist=new int[n+1];
        Arrays.fill(dist,-1);
        Queue<Integer> que=new ArrayDeque<>();
        dist[start]=0;
        que.add(start);
        while(!que.isEmpty()){
            int u=que.poll();
            for(int v:adj.get(u)){
                if(dist[v]==-1){
                    dist[v]=dist[u]+1;
                    que.add(v);
                }
            }
        }
        return dist;
    }
}