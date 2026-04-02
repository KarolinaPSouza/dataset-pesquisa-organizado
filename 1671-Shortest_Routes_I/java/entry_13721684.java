import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_13721684 {
    static int MOD = (int) 1e9 + 7;
    static FastScanner in = new FastScanner();
    //    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int n = in.nextInt(), m = in.nextInt();

        List<int[]>[] graph = new List[n+1];
        for(int i=1;i<=n;i++) graph[i] = new ArrayList<>();

        while(m-->0){
            int a = in.nextInt(), b = in.nextInt(), w = in.nextInt();
            graph[a].add(new int[]{b,w});
        }

        long[] dist = new long[n+1];
        long INF = Long.MAX_VALUE;
        Arrays.fill(dist, INF);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> {
           if(a[1] < b[1]) return -1;
           return a[1] == b[1] ? 0 : 1;
        });

        pq.add(new long[]{1,0});
        while(!pq.isEmpty()){
            var it = pq.poll();

            if(dist[(int)it[0]] <= it[1]) continue;
            dist[(int)it[0]] = it[1];
            for(var edge : graph[(int)it[0]]){
                pq.add(new long[]{edge[0], it[1] + edge[1]});
            }
        }

        for(int i=1;i<=n;i++){
           out.print(dist[i] + " ");
        }
        out.println();

        out.flush();
        out.close();

    }

    static long min(long a, long b) {
        return Math.min(a, b);
    }

    static long max(long a, long b) {
        return Math.max(a, b);
    }

    static long mod_pow(long a, long b, long p) {
        long mul = a;
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                ans = mod_mul(ans, mul, p);

            b >>= 1;
            mul = mod_mul(mul, mul, p);
        }
        return ans % p;
    }

    static long mod_mul(long a, long b, long p) {
        return ((a % p) * (b % p)) % p;
    }

    static long mod_add(long a, long b, long p) {
        return ((a % p) + (b % p)) % p;
    }

    static long mod_sub(long a, long b, long p) {
        return ((a % p) - (b % p)) % p;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
    }
}
