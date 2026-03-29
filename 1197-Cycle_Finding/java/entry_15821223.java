import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
public class entry_15821223 {
    static class Edge{
        int s;
        int end;
        int w;
        Edge(int s, int e, int w){
            this.s=s;
            this.end=e;
            this.w=w;
        }
    }
    static int n , m;
    static Edge[] edges;
    static long[] dist;
    static int cycleEnd;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge[m];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, w);
        }
        dist = new long[n+1];
        parent = new int[n+1];
        Arrays.fill(parent, -1);
        //Arrays.fill(dist, Long.MAX_VALUE);
        //dist[1] = 0;

        for(int i=0;i<n-1;i++){
            for(Edge e:edges){
                if (dist[e.s] + e.w < dist[e.end]) {
                    dist[e.end] = dist[e.s] + e.w;
                    parent[e.end] = e.s;
                }


            }
        }
        for(Edge e:edges){
            if(dist[e.end]>Math.min(dist[e.end], dist[e.s]+e.w)){
                parent[e.end] = e.s;
                cycleEnd = e.end;
                System.out.println("YES");
                construct();

                return;
            }
        }
        System.out.println("NO");

    }
    private static void construct(){
        int cur = cycleEnd;
        for(int i=0;i<n;i++){
            cur=parent[cur];
        }
        int v = cur;
        ArrayList<Integer> path = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(cur).append(" ");
        path.add(cur);
        cur = parent[cur];
        while(cur!=v){
            path.add(cur);
            //sb.append(cur).append(" ");
            cur = parent[cur];
        }
        //sb.append(path.get(path.size()-1)).append(" ");
        //sb.append(v);
        for(int i=path.size()-1;i>=0;i--){
            sb.append(path.get(i)).append(" ");
        }
        //sb.append(path.get(0));
        System.out.println(sb);
        //System.out.println(path);
    }
}