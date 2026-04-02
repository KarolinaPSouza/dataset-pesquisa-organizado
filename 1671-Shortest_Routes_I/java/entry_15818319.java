import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class entry_15818319 {
    static int n, m;
    static ArrayList<ArrayList<int[]>> adj;
    static long[] dist;

    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b,c});
        }
        dist = new long[n+1];
        //vis = new boolean[n+1];
        parent = new int[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        q.add(new long[]{0,1});
        while(!q.isEmpty()){
            long[] cur = q.remove();
            long d = cur[0];
            int node = (int)(cur[1]);
            if(d>dist[node]) continue;

            for(int[] nei: adj.get(node)){
                int v = nei[0];
                int w = nei[1];
                if(dist[node]+w<dist[v]){
                    dist[v] = dist[node]+w;
                    parent[v] = node;
                    q.add(new long[]{dist[v], v});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb);
    }

}