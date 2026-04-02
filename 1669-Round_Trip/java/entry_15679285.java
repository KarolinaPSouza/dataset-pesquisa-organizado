import java.io.*;
import java.util.*;

public class entry_15679285 {

    // ==================== CONSTANTS ====================
    // Safe Long Infinity: ~4.6 * 10^18. Safe to add (INF + INF).
    static final long INF = Long.MAX_VALUE / 2;

    // Safe Int Infinity: ~10^9. Safe to add (INF_I + INF_I).
    static final int INF_I = Integer.MAX_VALUE / 2;

    // Standard Modulo
    static final long MOD = 1000000007;




    // ==================== FAST I/O ====================
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntArray(int n) {
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }

        long[] readLongArray(int n) {
            long[] arr = new long[n];
            for(int i = 0; i < n; i++) arr[i] = nextLong();
            return arr;
        }
    }

    // Use this instead of System.out.println
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    // ==================== MODULAR ARITHMETIC ====================
    static long add(long a, long b) { return ((a % MOD) + (b % MOD)) % MOD; }
    static long sub(long a, long b) { return ((a % MOD) - (b % MOD) + MOD) % MOD; }
    static long mul(long a, long b) { return ((a % MOD) * (b % MOD)) % MOD; }
    static long power(long base, long exp) {
        long result = 1;
        base %= MOD;
        while(exp > 0) {
            if(exp % 2 == 1) result = mul(result, base);
            base = mul(base, base);
            exp /= 2;
        }
        return result;
    }
    static long modInverse(long a) { return power(a, MOD - 2); }
    static long div(long a, long b) { return mul(a, modInverse(b)); }

    // ==================== PREDEFINED OUTPUT FUNCTIONS ====================

    // Prints an array separated by spaces
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        out.println();
    }

    static void printArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        out.println();
    }

    // Prints an ArrayList or generic List separated by spaces
    static <T> void printList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            out.print(list.get(i) + (i == list.size() - 1 ? "" : " "));
        }
        out.println();
    }

    // ============================================================

    static List<Integer> graph[];

    static boolean found = false;



    static boolean visited[];


    static int parentA[];

    static boolean DFS(int source,int parent){
        visited[source] = true;
        parentA[source] = parent;
        for(int ele : graph[source]){
            if(ele != parent && visited[ele]){
                List<Integer> path = new ArrayList<>();
                int a = source;
                path.add(a);
                while(a != ele){
                    a = parentA[a];
                    path.add(a);
                }
                path.add(source);
                Collections.reverse(path);
                out.println(path.size());
                printList(path);
                found = true;
                return true;
            }
            else if(!visited[ele]){
                if(DFS(ele, source)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        // --- YOUR CODE HERE ---

        int N = sc.nextInt(), M = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parentA = new int[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            int u = sc.nextInt(), v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i] ){
                if(DFS(i, -1)) break;
            }
        }
        if(!found){
            out.println("IMPOSSIBLE");
        }




        out.close();
    }
}