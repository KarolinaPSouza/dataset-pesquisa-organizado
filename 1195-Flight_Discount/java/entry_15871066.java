import java.io.*;
import java.util.*;

class Edge{
    int to;
    long weight;
    Edge(int to, long weight){
        this.to = to;
        this.weight = weight;
    }
}

class State{
    int node, used;
    long price;
    State(int node, int used, long price){
        this.node = node;
        this.used = used;
        this.price = price;
    }
}

class Solution{
    public void solve(List<List<Edge>> graph, long[][] price){
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.price));
        pq.add(new State(1, 0, 0L));
        price[1][0] = 0; 

        while(!pq.isEmpty()){
            State current = pq.poll();
            int u = current.node;
            int used = current.used;

            // System.out.println(u + " " + used);
            if(price[u][used] < current.price) continue;

            for(Edge e: graph.get(u)){
                if(price[e.to][used] > e.weight + current.price){
                    pq.add(new State(e.to, used, e.weight + current.price));
                    price[e.to][used] = e.weight + current.price;
                }

                if(used == 0){
                    long discounted = e.weight / 2  + current.price;
                    if(discounted < price[e.to][1]){
                        pq.add(new State(e.to, 1, e.weight / 2  + current.price));
                        price[e.to][1] = e.weight / 2  + current.price;
                    }
                }   
            }
        }   
    }
};

public class entry_15871066 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        long[][] price = new long[n + 1][2];
        for(int i=1;i<=n;i++){
            Arrays.fill(price[i], Long.MAX_VALUE);
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, weight));
        }

        Solution s = new Solution();
        s.solve(graph, price);

        System.out.println(price[n][1]);
    }       
}