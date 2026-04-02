/*
ID: krishpa2
LANG: JAVA
TASK: entry_1595621
*/

import java.util.*;
import java.io.*;

public class entry_1595621 {

    public static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for (int i = 0; i<N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adj[u].add(v); adj[v].add(u);
        }

        int comp = 0;
        boolean[] visited = new boolean[N];
        ArrayList<Integer> edges = new ArrayList<>();
        for (int i = 0; i<N; i++) {
            if (!visited[i]) {
                edges.add(i);
                comp++;

                Stack<Integer> s = new Stack<>();
                s.push(i);
                while (!s.isEmpty()) {
                    int node = s.pop();
                    visited[node] = true;
                    for (int u: adj[node]) {
                        if (!visited[u]) {
                            s.push(u);
                        }
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(comp-1).append("\n");
        for (int i = 0; i<comp-1; i++) {
            ans.append(edges.get(i)+1).append(" ").append(edges.get(i+1)+1).append("\n");
        }
        out.print(ans);

        in.close();
        out.close();
    }

}