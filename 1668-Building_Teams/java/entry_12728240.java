import java.io.*;
import java.util.*;

public class entry_12728240 {
    // four possible moves: up, down, left, right
    static final int[] dx = { -1, +1,  0,  0 };
    static final int[] dy = {  0,  0, -1, +1 };
    static final char[] dm = { 'U','D','L','R' };



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            u--;
            v--;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] c=new int[n];
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            if(c[i]==0){
                vis[i]=true;
                q.offer(i);
                c[i]=1;
            }
            while(!q.isEmpty()){
                int x=q.poll();
                for(int v:adj.get(x)){
                    if(!vis[v]) q.offer(v);
                    vis[v]=true;
                    if(c[v]==c[x]){
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                    else c[v]=3-c[x];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
          sb.append(c[i]).append(' ');
        }
        System.out.println(sb);



    }
}
