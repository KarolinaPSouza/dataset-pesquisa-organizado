import java.io.*;
import java.util.*;

public class entry_10995891 {

    static class Pair{
        int node; long dist;
        Pair(int node, long dist){
            this.node = node;
            this.dist = dist;
        }
    }

    static class Tuple {
        int u; int v; long w;
        Tuple(int u, int v, long w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static String cycleFinding(int n, ArrayList<ArrayList<Pair>> adj, ArrayList<Tuple> edges){
        long[] dist = new long[n];
        Arrays.fill(dist, (long) 1e18);
        dist[0] = 0;

        // Bellman-Ford Algorithm
        // relaxing the edges n times
        for(int i = 0; i <= n-1; i++){
            for(Tuple t: edges){
                if(dist[t.u] == (int) 1e18) continue;
                if(dist[t.v] > dist[t.u] + t.w){
                    dist[t.v] = dist[t.u] + t.w;
                }
            }
        }

        boolean flag = false;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        // again we try to relax edges for n times
        for(int i = 0; i <= n-1; i++){
            for(Tuple t: edges){
                if(dist[t.u] == (int) 1e18) continue;

                // if any edges gets relaxed then we have a negative cycle so we upd weight
                // and also save parent i.e who changed the node in an array so that we can get cycle
                if(dist[t.v] > dist[t.u] + t.w){
                    dist[t.v] = dist[t.u] + t.w;
                    parent[t.v] = t.u;
                    flag = true;
                }
            }
        }

        if(!flag) return "NO"; // if none edges gets relaxed then we have no -ve wt cycle

        ArrayList<Integer> cycle = new ArrayList<>();
        int node = 0; // finding the first node who have upd weight in 2nd bellman ford
        for(int i = 0; i < n; i++){
            if(parent[i] != -1){
                node = i;
                break;
            }
        }

        // from there we bakctrack until we reach to same node
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(node)){
            cycle.add(node);
            set.add(node);
            node = parent[node];
        }
        cycle.add(node); // completing the cycle by putting the cycle beginning node to end;

        Collections.reverse(cycle); // we reverse the cycle i.e we will start from back
        set.clear();

        // we will keep adding nodes until we get some nodes already visited this will be the 
        // same node at the last so we stop at that
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cycle.size(); i++){
            sb.append(cycle.get(i)+1 + " ");
            if(set.contains(cycle.get(i))){
               break;
            }
            set.add(cycle.get(i));
        }

        System.out.println("YES");
        return sb.toString();


    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] f = br.readLine().split(" ");
        int n = Integer.parseInt(f[0]);
        int e = Integer.parseInt(f[1]);

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        ArrayList<Tuple> edges = new ArrayList<>();

        for(int i = 0; i < e; i++){
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0])-1;
            int v = Integer.parseInt(s[1])-1;
            long d = Long.parseLong(s[2]);

            adj.get(u).add(new Pair(v, d));
            edges.add(new Tuple(u, v, d));

        }

        bw.write(cycleFinding(n, adj, edges));

        bw.flush();
        br.close();
        bw.close();
    }

}