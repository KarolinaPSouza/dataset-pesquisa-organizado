import java.io.*;
import java.util.*;

public class entry_15767867 {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static int maxi = 0;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[] { 1, -1, 0 });
        int[] h = new int[n + 1];

        while (!st.isEmpty()) {
            int[] curr = st.pop();
            int u = curr[0];
            int parent = curr[1];
            int state = curr[2];

            if (state == 0) {
                st.push(new int[] { u, parent, 1 });

                for (int v : adj.get(u))
                    if (v != parent)
                        st.push(new int[] { v, u, 0 });
            } else {
                int best1 = 0;
                int best2 = 0;

                for (int v : adj.get(u)) {
                    if(v==parent) continue;
                    int c = h[v];
                    if (c > best1) {
                        best2 = best1;
                        best1 = c;
                    } else if (c > best2) {
                        best2 = c;
                    }
                }


                maxi = Math.max(maxi, best1 + best2);
                h[u] = 1 + best1;
            }
        }
        System.out.println(maxi);
    }
}