import java.io.*;
import java.util.*;
/// Not giving right output yet
public class entry_9472102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int road1 = Integer.parseInt(st.nextToken()) - 1;
            int road2 = Integer.parseInt(st.nextToken()) - 1;
            adj[road1].add(road2);
            adj[road2].add(road1);
        }

        boolean[] visited = new boolean[n];
        ArrayList<Integer> cityReps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            cityReps.add(i);
            ArrayDeque<Integer> todo = new ArrayDeque<>();
            todo.add(i);
            while (!todo.isEmpty()) {
                int curr = todo.poll();
                for (Integer next : adj[curr]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        todo.add(next);
                    }
                }

            }
        }

        pw.println(cityReps.size() - 1);
        for (int i = 0; i < cityReps.size() - 1; i++) {
            pw.print(cityReps.get(i) + 1);
            pw.print(" ");
            pw.println(cityReps.get(i + 1) + 1);
        }
        pw.flush();
        pw.close();
        br.close();

    }

}