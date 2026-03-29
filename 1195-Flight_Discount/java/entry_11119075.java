import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_11119075 {

    static BufferedReader r;
    static PrintWriter pw;
    static StringTokenizer st;

    static class Pair<K, V> {
        public K a;
        public V b;

        public Pair(K a, V b){
            this.a = a;
            this.b = b;
        }
    }

    static class Coupon {
        int position;
        long cost;
        int used;

        public Coupon(int position, long cost, int used){
            this.position = position;
            this.cost = cost;
            this.used = used;
            // 0 = false
            // 1 = true
        }
    }
    static int n, m;

    public static void main(String[] args) throws IOException {
        r = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        st = new StringTokenizer(readLine());

        n = readInt();
        m = readInt();
        List<Pair<Integer, Integer>>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            int a = readInt() - 1;
            int b = readInt() - 1;
            int c = readInt();
            adj[a].add(new Pair<>(b, c));
        }

        long[][] distance = new long[n][2];
        for(long[] row : distance){
            Arrays.fill(row, Long.MAX_VALUE - 1000);
        }
        distance[0][0] = 0;
        PriorityQueue<Coupon> pq = new PriorityQueue<>(Comparator.comparingLong(i -> i.cost));

        Coupon temp = new Coupon(0, 0, 0);
        pq.add(temp);
        while (!pq.isEmpty()) {
            Coupon curr = pq.poll();
            long cur_cost = distance[curr.position][curr.used];
            if (cur_cost != curr.cost) { continue; }
            if(curr.position == n - 1){ break; }
            for (Pair<Integer, Integer> i : adj[curr.position]) {
                if(curr.used == 0){
                    long new_cost = cur_cost + i.b / 2;
                    if(new_cost < distance[i.a][1]){
                        distance[i.a][1] = new_cost;
                        pq.add(new Coupon(i.a, new_cost, 1));
                    }
                }
                if(cur_cost + i.b < distance[i.a][curr.used]){
                    distance[i.a][curr.used] = cur_cost + i.b;
                    pq.add(new Coupon(i.a, cur_cost + i.b, curr.used));
                }
            }
        }

        pw.println(distance[n-1][1]);

        pw.close();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(r.readLine());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return r.readLine().trim();
    }
}