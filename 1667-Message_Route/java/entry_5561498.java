///package Package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.PrintWriter;

public class entry_5561498 {
    static InputReader scanner;
    static PrintWriter output;

    static int abs(int a) {
        return Math.abs(a);
    }

    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static int max(int[] a) {
        int result = Integer.MIN_VALUE;
        for (int i : a) {
            result = Math.max(i, result);
        }
        return result;
    }

    static int min(int a, int b) {
        return Math.min(a, b);
    }

    static int min(int[] a) {
        int result = Integer.MAX_VALUE;
        for (int i : a) {
            result = Math.min(i, result);
        }
        return result;
    }

    static int cin() {
        return scanner.nextInt();
    }

    static void cout(Object o) {
        output.println(o);
    }

    static int[] readArray(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = scanner.nextInt();
        }
        return result;
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void close() {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) {
        scanner = new InputReader(System.in);
        output = new PrintWriter(System.out);
       /* int I = cin();
        MAIN: while (I-- > 0) {*/
            solve();
        //}
        scanner.close();
        output.close();
    }

    public static void solve() {
        List<List<Integer>> adj = new ArrayList<>();
        int n = scanner.nextInt(), m = scanner.nextInt();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++){
            int u = scanner.nextInt(), v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 1;

        int[] pred = new int[n + 1];
        Arrays.fill(pred, -1);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        if(!bfs(adj, dist, pred, visited, n)) {
            System.out.println("IMPOSSIBLE");
        }
        else{
            List<Integer> path = new ArrayList<>();
            int c = n;
            path.add(n);
            while (pred[c] != -1){
                path.add(pred[c]);
                c = pred[c];
            }

            cout(dist[n]);
            for (int i = path.size() - 1; i >= 0; i--)
                output.print(path.get(i) + " ");
        }

    }

    public static boolean bfs(List<List<Integer>> adj, int[] dist, int[] pred, boolean[] visited, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()){
            int node = q.poll();
            List<Integer> neib = adj.get(node);

            for (int ngb : neib){
                if(!visited[ngb]){
                    visited[ngb] = true;
                    dist[ngb] = dist[node] + 1;
                    pred[ngb] = node;

                    q.add(ngb);

                    if(ngb == n)
                        return true;
                }

            }
        }

        return false;
    }



    public static boolean check_out_of_bounds(int i, int j, char[][] v){
        if(i < 0 || j < 0 || i >= v.length || j >= v[i].length)
            return false;
        else
            return true;
    }

    public static char getString(int d){
        if(d == 0) return 'U';
        else if(d == 1) return 'D';
        else if(d == 2) return 'L';
        else if(d == 3) return 'R';
        else return '-';
    }

}
