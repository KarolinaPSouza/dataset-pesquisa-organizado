import java.util.*;
import java.io.*;

public class entry_15739644 {
    public static long[] s;
    public static ArrayList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        for (int a = 0; a <= n; a++) {
            adjList[a] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            adjList[Integer.parseInt(st.nextToken())].add(i);
        }

        s = new long[n + 1];

        Deque<Integer> dfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        dfs.add(1);

        while (!dfs.isEmpty()) {
            int curr = dfs.peekLast();
            long total = 0L;
            boolean found = false;
            if (!adjList[curr].isEmpty()) {
                for (int next : adjList[curr]) {
                    if (!visited.contains(next)) {
                        found = true;
                        dfs.add(next);
                    } else if (!found) {
                        total += s[next];
                    }
                }
            }
            if (!found) {
                dfs.pollLast();
                s[curr] = adjList[curr].size() + total;
                visited.add(curr);
            }

        }
        pw.print(s[1]);
        for (int e = 2; e <= n; e++) {
            pw.print(" " + s[e]);
        }
        pw.println();
        pw.close();
    }
}