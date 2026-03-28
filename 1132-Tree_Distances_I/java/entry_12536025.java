import java.io.*;
import java.util.*;

public class entry_12536025 {
    private static int mod = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        solve(sc);
        out.flush();
        out.close();
    }

    private static void solve(MyScanner sc) {
        int n = sc.nextInt();

        List<List<Integer>> tree = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        boolean[] visited = new boolean[tree.size()];

        int[] from1 = dfs(tree, visited, 1);
        int dA = from1[0];

        int[] fromFar = dfs(tree, visited, dA);
        int dB = fromFar[0];

        int[] fromB = dfs(tree, visited, dB);
        for (int i = 1; i <= n; i++) {
            out.print(Math.max(fromB[i], fromFar[i]));
            out.print(' ');
        }
    }

    private static int[] dfs(
            List<List<Integer>> tree,
            boolean[] visited,
            int v) {
        Arrays.fill(visited, false);
        int[] dist = new int[tree.size()];

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(v);
        while (!ll.isEmpty()) {
            int root = ll.removeFirst();
            if (!visited[root]) {
                visited[root] = true;
                for (int next : tree.get(root)) {
                    if (visited[next]) continue;
                    dist[next] = 1 + dist[root];
                    if (dist[next] > dist[dist[0]]) {
                        dist[0] = next;
                    }
                    ll.addFirst(next);
                }
            }
        }

        return dist;
    }


    private static boolean check(int[] arr, int u, double mid) {
        for (int i = 0; i < arr.length - 2; i++) {
            double total = (arr[i + 1] - arr[i]) / (1 - mid);

            if (total > u) continue;

            int l = i + 1;
            int r = arr.length;
            while (l + 1 != r) {
                int m = (l + r) / 2;
                if (arr[m] - arr[i] < total) {
                    l = m;
                    continue;
                }
                if (arr[m] - arr[i] > u) {
                    r = m;
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    private static int GCD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return Math.max(a, b);
    }

    private static int[] readIntArray(MyScanner sc, int size) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = sc.nextInt();
        }
        return res;
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() throws Exception {
//            br = new BufferedReader(new FileReader("./src/test_input.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
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

        long nextLong() {
            return Long.parseLong(next());
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