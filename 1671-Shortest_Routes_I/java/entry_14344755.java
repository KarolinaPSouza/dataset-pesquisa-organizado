import java.io.*;
import java.util.*;

public class entry_14344755 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        // Constructor for file input
        public FastReader(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
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
        FastReader fr = new FastReader();
//        FastReader fr = new FastReader("src/graph/input.txt");
        int n = fr.nextInt();
        int m = fr.nextInt();
        List<Long[]>[] adjList = new List[n+1];
        for(int i=1;i<=n;i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0;i<m;i++) {
            int a = fr.nextInt();
            long b = fr.nextLong();
            long c = fr.nextLong();
            adjList[a].add(new Long[]{b,c});
        }
        solve(adjList, n+1);
    }

    private static void solve(List<Long[]>[] adjList, int n) {
        long[] distance = new long[n];
        Arrays.fill(distance, (long) 10E+17);
        distance[1]=0;
        dijkstra(distance,adjList,1);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<n;i++) {
            sb.append(distance[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void dijkstra(long[] distance, List<Long[]>[] adjList, long v) {
        PriorityQueue<Long[]> pq = new PriorityQueue<>((o1, o2) -> {
                return Long.compare(o1[1],o2[1]);
        });
        pq.add(new Long[]{v,0l});
        while (!pq.isEmpty()) {
            Long[] node = pq.poll();
            if (distance[Math.toIntExact(node[0])]<node[1]) continue;
            for(Long[] neighbour : adjList[Math.toIntExact(node[0])]) {
                int u = Math.toIntExact(neighbour[0]);
                long d = neighbour[1];
                long minLength = Math.min(distance[u], distance[Math.toIntExact(node[0])]+d);
                if (minLength < distance[u]) {
                    pq.add(new Long[]{(long) u,minLength});
                    distance[u] = minLength;
                }
            }
        }
    }
}