import java.util.*;
import java.io.*;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.Math.log;

public class entry_15784219 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {


        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void println() throws IOException {
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }

        public void printLongArr(long[] arr) throws IOException {
            for (long ele : arr) {
                print(ele + " ");
            }
            println();
        }

        public void printIntArr(int[] arr) throws IOException {
            for (int ele : arr) {
                print(ele + " ");
            }
            println();
        }
    }

    public static int dfsslow(int node, int parent, List<List<Integer>> adjList, int[] dp) {
        int count = 0;
        for (int child : adjList.get(node)) {
            if (child == parent) continue;
            dfs(child, node, adjList, dp);
            count += dp[child] + 1;
        }
        return dp[node] = count;
    }

    public static int dfs(int node, int parent, List<List<Integer>> adjList, int[] dp) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{node, 0, parent}); // {node, state, parent} state: 0=enter,1=exit

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int v = cur[0];
            int state = cur[1];
            int par = cur[2];

            if (state == 0) {
                stack.push(new int[]{v, 1, par});
                for (int child : adjList.get(v)) {
                    if (child == par) continue;
                    stack.push(new int[]{child, 0, v});
                }
            } else {
                int count = 0;
                for (int child : adjList.get(v)) {
                    if (child == par) continue;
                    count += dp[child] + 1;
                }
                dp[v] = count;
            }
        }

        return dp[node];
    }

    public static void main(String[] args) {
        try {
            FastReader fin = new FastReader();
            FastWriter fout = new FastWriter();
            int n = fin.nextInt();
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 2; i <= n; i++) {
                adjList.get(fin.nextInt()).add(i);

            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            dfs(1, 0, adjList, dp);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(dp[i]).append(" ");
            }
            fout.print(sb.toString());
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }


}