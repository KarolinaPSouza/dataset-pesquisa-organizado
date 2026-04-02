import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class entry_14827362 {
    public static class FastReader {
        static BufferedReader br;
        static StringTokenizer st;

        static {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public static String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public static int nextInt() {
            return Integer.parseInt(next());
        }

        public static long nextLong() {
            return Long.parseLong(next());
        }

        public static double nextDouble() {
            return Double.parseDouble(next());
        }

        public static String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<List<int[]>> g=new ArrayList<>();
        for(int i=0;i<=n;i++) g.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            g.get(a).add(new int[]{b,c});
        }
        long[] dist=new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{1,0});//node,cost
        dist[1]=0;
        while(!pq.isEmpty()){
            var it=pq.poll();
            int node=(int)it[0];
            long cost=it[1];
            if(cost>dist[node]) continue;
            for(var nbr:g.get(node)) {
                int nnode = nbr[0];
                long ncost = nbr[1];
                if (ncost + cost < dist[nnode]) {
                    dist[nnode] = ncost + cost;
                    pq.add(new long[]{nnode, dist[nnode]});
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<dist.length;i++){
            if(dist[i]==Long.MAX_VALUE) continue;
            sb.append(dist[i]).append((i==dist.length-1)?"":" ");
        }
        System.out.println(sb);
    }
}