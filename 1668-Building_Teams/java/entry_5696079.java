import java.io.*;
import java.util.*;

public class entry_5696079 {

    static ArrayList<Integer>[] adjList;
    static boolean works = true;
    static boolean[] teams;
    static boolean[] visited;

    public static void dfs(int cur, boolean color) {
        if (visited[cur]) {
            if (color!=teams[cur]) works=false;
            return;
        }
        visited[cur] = true;
        teams[cur] = color;
        for (int node : adjList[cur]) {
            dfs(node, !color);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        teams = new boolean[N];
        visited = new boolean[N];
        for (int i=0; i<N; i++) adjList[i] = new ArrayList<>();

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(r.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            adjList[start].add(end);
            adjList[end].add(start);
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) dfs(i, false);
        }

        if (!works) pw.println("IMPOSSIBLE");
        else {
            for (int i=0; i<N; i++) pw.print((teams[i]?2:1) + " ");
        }

        pw.close();
    }

}