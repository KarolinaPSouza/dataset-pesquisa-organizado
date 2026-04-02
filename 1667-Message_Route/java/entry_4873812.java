import java.util.*;
import java.io.*;

public class entry_4873812 {

    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        FastScanner s = new FastScanner();

        int n = s.nextInt();  // computers
        int m = s.nextInt();  // connections

        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] path = traverse(graph, n);


        if (path[n] == -1) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            StringBuilder sb = new StringBuilder();
            int previous = n;
            //sb.append(n);

            int count = 1;
            List<Integer> list = new ArrayList<>();
            list.add(n);
            while (previous != 1) {
                list.add(path[previous]);
                previous = path[previous];
                count++;
            }

            sb.append(count);
            sb.append('\n');
            for (int i=list.size()-1; i>=0; i--) {
                sb.append(list.get(i));
                sb.append(' ');
            }
            System.out.println(sb.toString());
        }

    }

    private static int[] traverse(List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n+1];
        int[] previousNode = new int[n+1];
        Arrays.fill(previousNode, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == n) {
                // found return from here
                return previousNode;
            }
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    queue.add(next);
                    previousNode[next] = node;
                    visited[next] = true;
                }
            }
        }

        return previousNode;

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in), 32768);
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        int[] intArray(int N) {
            int[] ret = new int[N];
            for (int i = 0; i < N; i++)
                ret[i] = nextInt();
            return ret;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long[] longArray(int N) {
            long[] ret = new long[N];
            for (int i = 0; i < N; i++)
                ret[i] = nextLong();
            return ret;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
