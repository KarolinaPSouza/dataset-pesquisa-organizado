import java.io.*;
import java.util.*;

public class entry_11816378 {

    public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        FastIO in = new FastIO(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt();
        int m = in.nextInt();

        int[] step = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int[] from = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //print(adj);

        bfs(step, visited, from);

        if (!visited[n - 1]) {
            out.print("IMPOSSIBLE");
        } else {
            ArrayList<Integer> path = new ArrayList<>();

            int curr = n - 1;

            while (curr != 0) {
                path.add(curr);
                curr = from[curr];
            }

            path.add(curr);
            StringBuilder res = new StringBuilder(path.size() + "\n");
            for (int i = path.size() - 1; i >= 0; i--) {
                res.append(path.get(i) + 1).append(" ");
            }
            out.print(res);
        }

        out.flush();
    }

    public static void bfs(int[] step, boolean[] visited, int[] from) {
        visited[0] = true;
        step[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            Integer curr = q.poll();

            for (Integer next : adj.get(curr)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                step[next] = step[curr] + 1;
                from[next] = curr;
                q.add(next);
            }
        }
    }

    public static class FastIO {
        InputStream dis;
        byte[] buffer = new byte[1 << 16];
        int ptr = 0;
        public FastIO(InputStream istream) {
            dis = istream;
        }
        int nextInt() throws Exception {
            int num = 0;
            byte ch;
            do {
                ch = nextByte();
            } while(ch <= ' ');
            boolean negative = false;
            if (ch == '-') {
                negative = true;
                ch = nextByte();
            }
            while(ch >= '0' && ch <= '9') {
                num = (num << 1) + (num << 3) + (ch - '0');
                ch = nextByte();
            }
            return (negative ? -num : num);
        }
        byte nextByte() throws Exception {
            if (ptr == buffer.length) {
                dis.read(buffer, 0, buffer.length);
                ptr = 0;
            }
            return buffer[ptr++];
        }
        public void close() throws Exception {
            if (dis == null) {
                return;
            }
            dis.close();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> arr) {
        int idx = 0;
        for (ArrayList<Integer> v : arr) {
            System.out.print(idx + ": ");
            for (Integer x : v) {
                System.out.print(x + " ");
            }
            System.out.println();
            idx++;
        }
    }

}