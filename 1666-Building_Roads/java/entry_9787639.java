
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class entry_9787639 {
    static class IOHelper extends PrintWriter {
        BufferedReader br = null;
        StringTokenizer st = null;
        public IOHelper() throws IOException {
            super(System.out);
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public void close() {
            try {
                br.close();
            } catch (Exception e) {

            }
            super.close();
        }
    }

    static ArrayList<Integer>[] adjList;
    static boolean[] isVisited;

    static void dfs(int node) {
        isVisited[node] = true;
        for (int next: adjList[node]) {
            if (!isVisited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        IOHelper io = new IOHelper();
        int n = io.nextInt();
        int m = io.nextInt();
        isVisited = new boolean[n];
        adjList = new ArrayList[n];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            adjList[a].add(b);
            adjList[b].add(a);
        }
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) {
                continue;
            }
            dfs(i);
            data.add(i);
        }
        io.println(data.size() - 1);
        for (int i = 0; i < data.size() - 1; i++) {
            io.println((data.get(i) + 1) + " " + (data.get(i + 1) + 1));
        }
        io.close();
    }
}