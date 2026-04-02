//package Package;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.PrintWriter;
import java.util.List;

public class entry_5654567 {
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
        int n = scanner.nextInt(), m = scanner.nextInt();

        List<Integer>[] adj = new ArrayList[n + 1];
        int[] visited = new int[n + 1];

        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++){
            int u = scanner.nextInt(), v = scanner.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;

        int[] path = new int[n + 1];
        path[1] = -1;

        while (!q.isEmpty()){
            int node = q.poll();

            for (int ngb : adj[node]){
                if(visited[ngb] != 1){
                    visited[ngb] = 1;
                    path[ngb] = node;
                    q.add(ngb);

                    if(ngb == n){
                        List<Integer> a = new ArrayList<>();
                        int curr = ngb;

                        while(curr != -1){
                            a.add(curr);
                            curr = path[curr];
                        }

                        System.out.println(a.size());
                        for (int i = a.size() - 1; i >= 0; i--)
                            System.out.print(a.get(i) + " ");

                        System.exit(0);
                    }
                }
            }
        }

        cout("IMPOSSIBLE");

    }

    public static void dfs(List<Integer>[] adj, int[] visited, int node){

    }

}
