import java.util.*;
import java.io.*;

public class entry_13708358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n - 1];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++)
            arr[i] = Integer.parseInt(s[i]);

        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            tree[arr[i] - 1].add(i + 1);  
        }

        int[] dp = new int[n]; 
        boolean[] visited = new boolean[n];

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> post = new Stack<>();

        stack.push(0); 
        while (!stack.isEmpty()) {
            int node = stack.pop();
            post.push(node);
            for (int child : tree[node]) {
                stack.push(child);
            }
        }

        while (!post.isEmpty()) {
            int node = post.pop();
            dp[node] = 1;  
            for (int child : tree[node]) {
                dp[node] += dp[child];
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append((dp[i] - 1)).append(" ");  
        }
        System.out.println(ans);
    }
}
