import java.io.*;
import java.util.*;
import java.util.ArrayList;

class Reader {
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
        char nextChar() { return next().charAt(0); }

        int[] readIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }

        long[] readLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = nextLong();
            return arr;
        }

        double[] readDoubleArray(int n) {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) arr[i] = nextDouble();
            return arr;
        }

        String[] readStringArray(int n) {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = next();
            return arr;
        }
    }
}

class BFS {
    public static int bfsTraversal(int V, ArrayList<ArrayList<Integer>> adj , boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[V] = true;
        queue.add(V);
        int last = V;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            last = node;
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return last;
    }
}
public class entry_14861441 {
    public static void main(String[] args) {
        Reader.FastReader sc = new Reader.FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            edges.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                ans++;
                temp.add(BFS.bfsTraversal(i, edges, visited));
            }
        }
        System.out.println(ans - 1);
        int i = 0;
        int j = 1;
        while(j < temp.size()) {
            System.out.println((temp.get(i) + 1) + " " + (temp.get(j) + 1));
            i++;
            j++;
        }
    }
}