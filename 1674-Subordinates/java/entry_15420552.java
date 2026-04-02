import java.io.*;
import java.util.*;

public class entry_15420552 {

    static ArrayList<Integer>[] tree;
    static int[] subCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        String[] parts = br.readLine().split(" ");
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(parts[i - 2]);
            tree[boss].add(i);
        }

        subCount = new int[n + 1];

        // iterative postorder DFS
        iterativeDFS(1);

        for (int i = 1; i <= n; i++) {
            sb.append(subCount[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static void iterativeDFS(int root) {
        // Stack for (node, visitedFlag)
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{root, 0});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int node = cur[0];
            int visited = cur[1];

            if (visited == 1) {
                // After visiting children, calculate subordinates
                int count = 0;
                for (int child : tree[node]) {
                    count += 1 + subCount[child];
                }
                subCount[node] = count;
            } else {
                // Postorder traversal: process children first
                stack.push(new int[]{node, 1});
                for (int child : tree[node]) {
                    stack.push(new int[]{child, 0});
                }
            }
        }
    }
}