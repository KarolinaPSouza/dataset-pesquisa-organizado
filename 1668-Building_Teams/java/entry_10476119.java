//package lecture.graph;

import java.io.*;
import java.util.*;

public class entry_10476119 {

    private static List<Integer>[] adj;

    private static int n;

    public static void main(String[] args) throws Exception {
        init();
        check();
    }

    private static void init() throws Exception {
        FastScanner s = new FastScanner();
        n = s.nextInt();
        int m = s.nextInt();

        adj = new ArrayList[n + 1];
        team = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    private static void solve() {
        int[] team = new int[n + 1];

        for (int i = 1; i < team.length; i++) {
            if (team[i] == 0) {
                dfs(i, team);
            }
        }
        System.out.println(Arrays.toString(team));
    }

    private static void brute() {
        int[] team = new int[n + 1];

        for (int i = 1; i < adj.length; i++) {
            if (team[i] == 0) {
                team[i] = 1;
                for (int j = 0; j < adj[i].size(); j++) {
                    team[adj[i].get(j)] = 2;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < team.length; i++) {
            sb.append(team[i]).append(" ");
        }
        System.out.println(sb);
        System.out.println(isValid(1, new boolean[n + 1], team));
    }

    private static boolean isValid(int s, boolean[] visited, int[] team) {
        boolean is = true;
        visited[s] = true;
        for (int i : adj[s]) {
            if (team[i] == s) {
                return false;
            }
            else if (!visited[i]) {
                is = isValid(i, visited, team);
            }
        }
        return is;
    }

    private static void dfs(int s, int[] team) {
        dfs(s,1, new boolean[n + 1], team);
    }

    private static void dfs(int s, int v, boolean[] visited, int[] team) {
        visited[s] = true;
        team[s] = v;
        for (int i : adj[s]) {
            if (!visited[i]) {
                if (v == 1) {
                    v = 2;
                } else {
                    v = 1;
                }
                dfs(i, v, visited, team);
            }
        }
    }


    static int[] team;
    static boolean isIMPossible = false;
    private static void check() {
        for (int i = 1; i < n; i++) {
            if (team[i] == 0) {
                bfs(i);
                if (isIMPossible) {
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < team.length; i++) {
            sb.append(team[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        team[s] = 1;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            int v = team[currNode];

            for (int i : adj[currNode]) {
                if (team[i] == 0) {
                    queue.add(i);
                    if (v == 1) {
                        team[i] = 2;
                    } else {
                        team[i] = 1;
                    }
                }
                if (v == team[i]) {
                    System.out.println("IMPOSSIBLE");
                    isIMPossible = true;
                    return;
                }
            }
        }
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }



}
/*
In the end check also if its correct or not.
 */
