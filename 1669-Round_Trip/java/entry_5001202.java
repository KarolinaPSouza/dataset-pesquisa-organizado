import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class entry_5001202 {
    List<List<Integer>> roadMap;
    boolean[] visited;
    int n;
    int m;
    int startCity = -1;
    boolean stop = false;
    int cnt = -1;
    LinkedList<Integer> re = new LinkedList();

    public entry_5001202(List<List<Integer>> roadMap, int n, int m) {
        this.roadMap = roadMap;
        this.n = n;
        this.m = m;
        visited = new boolean[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n<3) {
            pw.println("IMPOSSIBLE");
            pw.close();
            return;
        }

        List<List<Integer>> roadMap = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            List<Integer> neighnors = new ArrayList<>();
            roadMap.add(neighnors);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int s1 = Integer.parseInt(st.nextToken()) - 1;
            int s2 = Integer.parseInt(st.nextToken()) - 1;
            roadMap.get(s1).add(s2);
            roadMap.get(s2).add(s1);
        }

        entry_5001202 s = new entry_5001202(roadMap, n, m);
        int result = s.getRoute();
        if (result == -1) {
            pw.println("IMPOSSIBLE");
        } else {
            pw.println(s.cnt);
            for (Integer i:s.re)
            pw.print(i + " ");
        }
        pw.close();
    }

    int getRoute() {
        for (int i=0;i<n;++i) {
            if (!visited[i]) {
                boolean[] onRoute = new boolean[n];
                int r = dfs(i, onRoute, -1);
                if (r == 1) {
                    return 1;
                }
            }
        }
        return -1;
    }
    int dfs(int curr, boolean[] onRoute, int previous) {
        visited[curr] = true;
        if (onRoute[curr]) {
            startCity = curr + 1;
            cnt = 1;
            re.addFirst(curr + 1);
            //result.addLast(curr + 1);
            return 1;
        }

        onRoute[curr] = true;
//        result.addLast(curr + 1);
        for (Integer i : roadMap.get(curr)) {
            if (i == previous) {
                continue;
            }
            int r = dfs(i, onRoute, curr);
            if (r == 1) {
                if (!stop) {
                    cnt++;
                    re.addFirst(curr + 1);
                }
                if ((curr+1) ==  startCity) {
                    stop = true;
                }
                return 1;
            } 
        }
        return -1;
    }
}