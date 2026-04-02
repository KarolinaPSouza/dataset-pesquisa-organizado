// import java.util.*;
// class Pair{
//     int node ;
//     long weight;
//     Pair(int n,long d){
//         this.node=n;
//         this.weight=d;
//     }
// }

// public class entry_14794560 {
//     public static void main(String[] args){
//         Scanner s=new Scanner(System.in);
//         int n=s.nextInt();
//         int m=s.nextInt();
//         int[][] arr=new int[m][3];

//         for(int i=0;i<m;i++){
//             arr[i][0]=s.nextInt();
//             arr[i][1]=s.nextInt();
//             arr[i][2]=s.nextInt();
//         } 
//         ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
//         for(int i=0;i<=n;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<m;i++){
//             int u=arr[i][0];
//             int v=arr[i][1];
//             int wgt=arr[i][2];
//             adj.get(u).add(new Pair(v,wgt));
//         }
//         long[] dis=new long[n+1];
//         Arrays.fill(dis,Long.MAX_VALUE);
//         dis[1]=0;
//         PriorityQueue<Pair> q=new PriorityQueue<>((x,y)->Long.compare(x.weight,y.weight));
//         q.add(new Pair(1,0));
//         while(!q.isEmpty()){
//             int curr=q.peek().node;
//             long dist=q.peek().weight;
//              q.poll();
//              if (dist > dis[curr]) continue; 

//             for(int i=0;i<adj.get(curr).size();i++){
//                 long edgeweight=adj.get(curr).get(i).weight;
//                 int adjnode=adj.get(curr).get(i).node;
//                 if(dis[adjnode]>dis[curr]+edgeweight){
//                     dis[adjnode]=dis[curr]+edgeweight;
//                     q.add(new Pair(adjnode,dis[adjnode]));
//                 }
//             }
//         }
//         for(int i=1;i<dis.length;i++){
//             System.out.print(dis[i]+" ");
//         }System.out.println();

//     }
// }
import java.io.*;
import java.util.*;

class Pair {
    int node;
    long weight;
    Pair(int n, long d) {
        this.node = n;
        this.weight = d;
    }
}

public class entry_14794560 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();

        ArrayList<Pair>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int w = fs.nextInt();
            adj[u].add(new Pair(v, w));
        }

        long[] dis = new long[n + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int node = top.node;
            long d = top.weight;

            if (d > dis[node]) continue;

            for (Pair edge : adj[node]) {
                int next = edge.node;
                long newDist = d + edge.weight;
                if (newDist < dis[next]) {
                    dis[next] = newDist;
                    pq.add(new Pair(next, newDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dis[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}