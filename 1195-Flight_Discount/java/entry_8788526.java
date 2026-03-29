import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Edge{
    public int to;
    public long weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class entry_8788526 {
    static ArrayList<Edge>[] gr;
    static int N;
    static int M;
    static long[] distC;
    static long[] dist;
    static boolean[] vis;
    static PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(i -> i[0]));

    public static void initialize(int from){
        dist = new long[N+2];
        distC = new long[N+2];
        vis = new boolean[N+2];
        gr = new ArrayList[N+2];

        for(int i=0;i<N+2;i++){
            gr[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;
            distC[i] = Long.MAX_VALUE;
        }
        dist[from] = 0;
        distC[from] = 0;
    }
    public static long solve(){
        pq.add(new long[]{0, 0, 1});

        while(!pq.isEmpty()){
            long[] tp = pq.poll();

            if(tp[1] > dist[(int) tp[2]]) continue;


            for(Edge e:gr[(int) tp[2]]){
                long distXc = dist[(int) tp[2]] + e.weight;
                long distWc = Math.min(dist[(int) tp[2]] + (e.weight/2),distC[(int) tp[2]] + e.weight);

                if(distWc < distC[e.to] || distXc < dist[e.to]){
                    distC[e.to] = Math.min(distC[e.to],distWc);
                    dist[e.to] = Math.min(dist[e.to],distXc);
                    pq.add( new long[]{distWc,distXc,e.to});
                }
            }
        }
        return distC[N];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sp = bf.readLine().split(" ");
        N = Integer.parseInt(sp[0]);
        M = Integer.parseInt(sp[1]);

        initialize(1);

        for(int i=0;i<M;i++){
            sp = bf.readLine().split(" ");

            int from = Integer.parseInt(sp[0]);
            int to = Integer.parseInt(sp[1]);
            int cost = Integer.parseInt(sp[2]);

            gr[from].add(new Edge(to,cost));
        }

        System.out.println(solve());

    }
}