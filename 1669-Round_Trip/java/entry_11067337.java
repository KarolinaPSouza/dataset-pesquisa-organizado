import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class entry_11067337 {
    public static int mod = (int)(1e9 + 7);
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while (t-- > 0)
            solve(sc, out);
        out.close();
    }
    static int [] prev;
    static int point;
    public static void solve(FastScanner sc, PrintWriter out) {
        int n = sc.nextInt();
        int edges = sc.nextInt();
        prev = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < edges; i++){
            int n1 = sc.nextInt()-1;
            int n2 = sc.nextInt()-1;

            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        boolean cycle = isCycle(n, adj);
        if(!cycle){
            out.println("IMPOSSIBLE");
            return;
        }
        List<Integer > list = new ArrayList<Integer>();
        int p = point;
        do{
            list.add(p+1);
            p = prev[p];
        }while(p != point);
        list.add(p+1);
        out.println(list.size());
        for(Integer ele : list){
            out.print(ele + " ");
        }


    }
    public static boolean detect(int root, List<List<Integer>> adj, int[] visited, int parent) {
        visited[root] = 1;

        for (int neighbor : adj.get(root)) {
            if (visited[neighbor] == 0) {
                prev[neighbor] = root;
                if (detect(neighbor, adj, visited, root)) {
                    return true; // A back edge was found, indicating a cycle.
                }
            } else if (neighbor != parent) {
                prev[neighbor] = root;
                point = root;
                return true; // This is a cross edge, indicating a cycle.
            }
        }
        return false;
    }

    public static boolean isCycle(int v, List<List<Integer>> adj) {
        int[] visited = new int[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                if (detect(i, adj, visited, -1)) {
                    return true; // If a cycle is detected in any component, return true.
                }
            }
        }
        return false; // No cycle was found in the graph.
    }
    public static class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Pair pair = (Pair) obj;

            if (first != pair.first) return false;
            return second == pair.second;
        }

        @Override
        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            return result;
        }
        @Override
        public int compareTo(Pair other) {
            if (this.first != other.first) {
                return Integer.compare(this.first, other.first); // Compare by 'first'
            } else {
                return Integer.compare(this.second, other.second); // If 'first' values are equal, compare by 'second'
            }
        }
    }
    private static long gcd(long a, long b){
        while(a != 0 && b != 0){
            if(a > b) a = a % b;
            else b =  b % a;
        }
        if(a == 0) return b;
        return a;
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
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
}