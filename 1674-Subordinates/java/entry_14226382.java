import java.io.*;
import java.util.*;

public class entry_14226382 {
    static ArrayList<Integer>[] tree;
    static int[] count;

    public static void dfsIterative(int n) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> post = new Stack<>();

        stack.push(1); // start from director
        while (!stack.isEmpty()) {
            int u = stack.pop();
            post.push(u);
            for (int child : tree[u]) {
                stack.push(child);
            }
        }

        // post-order: children before parent
        while (!post.isEmpty()) {
            int u = post.pop();
            count[u] = 1; // include itself
            for (int child : tree[u]) {
                count[u] += count[child];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            int boss = Integer.parseInt(st.nextToken());
            tree[boss].add(i + 2); // boss → employee
        }

        count = new int[n + 1];
        dfsIterative(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(count[i] - 1).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}