
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class entry_11352557 {

    public static void dfs(int node, List<Integer>[] adj, int[] countArr) {

        Stack<Integer> stack = new Stack<>();
        boolean vis [] = new boolean[countArr.length];
        stack.add(node);

        while (!(stack.isEmpty())) {
            int n = stack.peek();
            if (!vis[n]) {
                vis[n] = true;
                for (int subNode : adj[n]) {
                    stack.add(subNode);
                }
            } else {
                n = stack.pop();
                int size = 0;
                for (int subNode : adj[n]) {
                    size +=  1 + countArr[subNode];
                }
                countArr[n] = size;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            adj[boss].add(i);
        }

        int [] subtree = new int[n+1];
        dfs(1,adj,subtree);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subtree[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}