import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class entry_8044661 {
    public static ArrayList<Integer>[] adj;
    public static int[] visited;
    public static int label = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(r.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        ArrayList<Pair<Integer, Integer>> ans = new ArrayList<>();
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (i != 0) {
                    ans.add(new Pair<>(i + 1, i));
                }
                label++;
                dfs(i);
            }
        }
        pw.println(label - 1);
        ans.parallelStream().forEach(pw::println);
        pw.close();
    }

    public static void dfs(int node) {
        visited[node] = label;
        for (int i = 0; i < adj[node].size(); i++) {
            int next = adj[node].get(i);
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }

    // Pair class cause Java doesn't have one for some reason :/
    public static class Pair<T, Q> {
        public T first;
        public Q second;

        public Pair(T first, Q second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            // return sorted by first, then second
            return first + " " + second;
        }
    }
}