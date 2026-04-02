import java.io.*;
import java.util.*;

public class entry_15804485 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            int boss = Integer.parseInt(st.nextToken()) - 1;
            adj.get(boss).add(i);
        }

        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> post = new Stack<>();

        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            post.push(node);
            for (int child : adj.get(node)) {
                stack.push(child);
            }
        }

        while (!post.isEmpty()) {
            int node = post.pop();
            for (int child : adj.get(node)) {
                ans[node] += ans[child] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : ans) sb.append(x).append(" ");
        System.out.print(sb);
    }
}