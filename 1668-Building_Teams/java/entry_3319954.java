import java.io.*;
import java.util.*;

public class entry_3319954 {
    // assign each person a color, r/b
    // given a person, assign it a color, and assign all its friends a different color.

    static int N, M;
    static int[] colors; // 1 or 2, 0 is unassigned
    static boolean[] visited;
    static int[][] edges;
    static int[] sizes;

    static boolean dfs(int i, int c) {
        visited[i] = true;
        if (colors[i] != 0 && colors[i] != c) {
            return false;
        } else if (colors[i] == 0) {
            colors[i] = c;
        }

        for (int j = 0; j < sizes[i]; j++) {
            int b = edges[i][j];
            if (!visited[b]) {
                if (!dfs(b, c == 1 ? 2 : 1)) {
                    return false;
                }
            } else {
                if (colors[b] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("data.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        colors = new int[N+1];
        visited = new boolean[N+1];
        edges = new int[N+1][];
        sizes = new int[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new int[200];
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (edges[a].length == sizes[a]) {
                edges[a] = Arrays.copyOf(edges[a], sizes[a]+200);
            }
            edges[a][sizes[a]] = b;
            sizes[a]++;
            if (edges[b].length == sizes[b]) {
                edges[b] = Arrays.copyOf(edges[b], sizes[b]+200);
            }
            edges[b][sizes[b]] = a;
            sizes[b]++;
        }
//        System.out.println("heads " + Arrays.toString(heads));
//        System.out.println("nexts " + Arrays.toString(nexts));
//        System.out.println("tos " + Arrays.toString(tos));

        boolean ok = true;
        for (int i = 1; ok && i <= N; i++) {
            if (!visited[i]) {
                ok = dfs(i, 1);
            }
        }

        if (!ok) {
            pw.println("IMPOSSIBLE");
        } else {
            for (int i = 1; i <= N; i++) {
                pw.println(colors[i]);
            }
        }
        pw.close();
        br.close();
    }
}

/*
public class entry_3319954 {
    // assign each person a color, r/b
    // given a person, assign it a color, and assign all its friends a different color.
     static int N, M;
    static int[] colors; // 1 or 2, 0 is unassigned
    static boolean[] visited;
     static int[] heads;
    static int[] nexts;
    static int[] tos;
     static boolean dfs(int i, int c) {
        visited[i] = true;
        if (colors[i] != 0 && colors[i] != c) {
            return false;
        } else if (colors[i] == 0) {
            colors[i] = c;
        }
         for (int e = heads[i]; e >= 0; e = nexts[e]) {
//            System.out.println("i " + i + " e " + e);
            int b = tos[e];
            if (!visited[b]) {
                if (!dfs(b, c == 1 ? 2 : 1)) {
                    return false;
                }
            } else {
                if (colors[b] == c) {
                    return false;
                }
            }
        }
        return true;
    }
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("data.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        colors = new int[N+1];
        visited = new boolean[N+1];
        heads = new int[N+1];
        Arrays.fill(heads, -1);
        nexts = new int[2*M];
        tos = new int[2*M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nexts[2*i] = heads[a];
            tos[2*i] = b;
            heads[a] = 2*i;
            nexts[2*i+1] = heads[b];
            tos[2*i+1] = a;
            heads[b] = 2*i+1;
        }
//        System.out.println("heads " + Arrays.toString(heads));
//        System.out.println("nexts " + Arrays.toString(nexts));
//        System.out.println("tos " + Arrays.toString(tos));
         boolean ok = true;
        for (int i = 1; ok && i <= N; i++) {
            if (!visited[i]) {
                ok = dfs(i, 1);
            }
        }
         if (!ok) {
            pw.println("IMPOSSIBLE");
        } else {
            for (int i = 1; i <= N; i++) {
                pw.println(colors[i]);
            }
        }
        pw.close();
        br.close();
    }
}
*/