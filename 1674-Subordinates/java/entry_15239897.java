import java.io.*;
import java.util.*;

public class entry_15239897 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            adj[boss].add(i);
        }

        int[] subCount = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> post = new ArrayDeque<>();

        stack.push(1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            post.push(node);
            for (int child : adj[node]) {
                stack.push(child);
            }
        }

        while (!post.isEmpty()) {
            int node = post.pop();
            int count = 0;
            for (int child : adj[node]) {
                count += 1 + subCount[child];
            }
            subCount[node] = count;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subCount[i]).append(" ");
        }
        System.out.println(sb);
    }
}