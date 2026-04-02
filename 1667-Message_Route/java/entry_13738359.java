import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_13738359 {
    public static void main(String[] args) throws IOException{
        entry_13738359 solve = new entry_13738359();
        solve.solve();
    }

    public void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        // Multiple path solve. Time and space inefficient!
        // int[] path = bfsWpath(edges, 1, n);
        // if (path.length == 0) {
        //     out.println("IMPOSSIBLE");
        // } else {
        //     out.println(path.length);
        //     for (int i = 0; i < path.length; i++) {
        //         out.print(path[i] + " ");
        //     }
        // }

        List<Integer> path = bfsWbacktrack(edges, 1, n);
        if(path.isEmpty()) {
            out.println("IMPOSSIBLE");
        } else {
            out.println(path.size());
            for (int node : path) {
                out.print(node + " ");
            }
        }

        out.close();
        br.close();
    }

    public int[] bfsWpath(List<Integer>[] edges, int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[end+1];

        q.offer(new int[]{start});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] path = q.poll();
            int node = path[path.length - 1];

            if(node == end) {
                return path;
            }

            // Traverse and add unvisited nodes
            for (int i = 0; i < edges[node].size(); i++) {
                int neighbour = edges[node].get(i);
                if (!visited[neighbour]){
                    int[] new_path = Arrays.copyOf(path, path.length+1);
                    new_path[new_path.length - 1] = neighbour;
                    visited[neighbour] = true;
                    q.add(new_path);
                }
            }
        }
        return new int[]{};
    }

    public List<Integer> bfsWbacktrack(List<Integer>[] edges, int start, int end) {
        int[] parent = new int[end+1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[end+1];

        q.offer(start);
        parent[start] = -1;
        visited[start] = true;

        while(!q.isEmpty()) {
            int node = q.poll();

            if(node == end) {
                return backtrack(parent, start, end);
            }

            // Traverse and add unvisited nodes
            for (int i = 0; i < edges[node].size(); i++) {
                int neighbour = edges[node].get(i);
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                    parent[neighbour] = node;
                }
            }
        }

        return new ArrayList<>();
    }

    public List<Integer> backtrack(int[] parent, int start, int end) {
        List<Integer> path = new ArrayList<>();
        path.add(end);
        int current = end;

        while (current != start) {
            current = parent[current];
            path.add(current);
        }
        Collections.reverse(path);
        return path;
    }
}