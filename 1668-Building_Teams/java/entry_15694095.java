import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.IntUnaryOperator;

public class entry_15694095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] friendships = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            friendships[i][0] = Integer.parseInt(st.nextToken());
            friendships[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] teams = dividePupils(n, friendships);
        if (teams.length == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int t : teams) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }

    public static int[] dividePupils(int n, int[][] friendships) {
        int m = friendships.length;

        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        int[] parity = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] f : friendships) {
            if (!union(f[0], f[1], parent, rank, parity)) {
                return new int[]{};
            }
        }

        int[] teams = new int[n];
        for (int i = 1; i <= n; i++) {
            int pi = find(i, parent, parity);
            teams[i - 1] = teams[pi - 1] ^ parity[i];
        }

        for (int i = 1; i <= n; i++) {
            teams[i - 1] += 1;
        }

        return teams;
    }

    public static boolean union(int a, int b, int[] parent, int[] rank, int[] parity) {
        int pa = find(a, parent, parity);
        int pb = find(b, parent, parity);

        // if a and b are in the same connected component, their parity should be different
        if (pa == pb) {
            return (parity[a] ^ parity[b]) == 1;
        }

        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
            parity[pb] = parity[a] ^ parity[b] ^ 1;
        } else if (rank[pb] > rank[pa]) {
            parent[pa] = pb;
            parity[pa] = parity[a] ^ parity[b] ^ 1;
        } else {
            parent[pa] = pb;
            parity[pa] = parity[a] ^ parity[b] ^ 1;
            rank[pb]++;
        }

        return true;
    }

    public static int find(int x, int[] parent, int[] parity) {
        if (x != parent[x]) {
            int origParent = parent[x];
            parent[x] = find(parent[x], parent, parity);
            parity[x] = parity[x] ^ parity[origParent];
        }
        return parent[x];
    }

//    public static int[] dividePupils(int n, int[][] friendships) {
//        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
//        for (int i = 1; i <= n; i++)
//            adjList.put(i, new ArrayList<>());
//
//        for (int[] f : friendships) {
//            adjList.get(f[0]).add(f[1]);
//            adjList.get(f[1]).add(f[0]);
//        }
//
//        int[] color = new int[n];
//        boolean[] vis = new boolean[n + 1];
//
//        IntUnaryOperator swapColor = c -> (c == 1) ? 2 : 1;
//
//        for (int i = 1; i <= n; i++) {
//            if (vis[i]) continue;
//
//            Queue<Integer> bfs = new LinkedList<>();
//            bfs.add(i);
//            vis[i] = true;
//            color[i - 1] = 1;
//            while (!bfs.isEmpty()) {
//                int x = bfs.remove();
//                for (int y : adjList.get(x)) {
//                    if (color[x - 1] == color[y - 1]) return new int[]{};
//                    if (vis[y]) continue;
//
//                    bfs.add(y);
//                    vis[y] = true;
//                    color[y - 1] = swapColor.applyAsInt(color[x - 1]);
//                }
//            }
//        }
//
//        return color;
//    }
}