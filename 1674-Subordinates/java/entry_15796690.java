import java.io.*;
import java.util.*;

public class entry_15796690 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] children = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            children[parent].add(i);
        }

        int[] sub = new int[n + 1];

        // iterative postorder DFS
        int[] stack = new int[n];
        int[] idx = new int[n + 1]; // child index per node
        int top = 0;

        stack[top++] = 1;

        while (top > 0) {
            int u = stack[top - 1];

            if (idx[u] < children[u].size()) {
                int v = children[u].get(idx[u]++);
                stack[top++] = v;
            } else {
                // all children processed
                top--;
                for (int v : children[u]) {
                    sub[u] += sub[v] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sub[i]).append(' ');
        }
        System.out.println(sb);
    }
}