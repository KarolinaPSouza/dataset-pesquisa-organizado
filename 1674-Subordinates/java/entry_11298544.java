import java.io.*;
import java.util.*;

public class entry_11298544 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution() throws IOException {
        // Read number of employees
        int n = Integer.parseInt(br.readLine());

        // Create adjacency list to represent the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        // Read boss for each employee and build the tree
        String[] bosses = br.readLine().split(" ");
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(bosses[i - 2]);
            tree.get(boss).add(i);
        }

        // Array to store number of subordinates for each employee
        int[] subordinatesCount = new int[n + 1];
        Arrays.fill(subordinatesCount, -1); // Initialize with -1 (uncomputed)

        // Compute subordinates count using iterative DFS
        computeSubordinatesIteratively(tree, subordinatesCount);

        // Write the results
        for (int i = 1; i <= n; i++) {
            bw.write(subordinatesCount[i] + " ");
        }
        bw.newLine();
        bw.flush();
    }

    // Iterative method to count subordinates
    private static void computeSubordinatesIteratively(List<List<Integer>> tree, int[] subordinatesCount) {
        int n = tree.size() - 1;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];
        int[] tempCount = new int[n + 1]; // Temporary count storage for post-order traversal

        // Start DFS from every unvisited node (in this case, from node 1)
        stack.push(1);
        while (!stack.isEmpty()) {
            int current = stack.peek();

            if (!visited[current]) {
                visited[current] = true;

                // Add all subordinates to the stack
                for (int subordinate : tree.get(current)) {
                    stack.push(subordinate);
                }
            } else {
                // Post-order processing: compute subordinate count
                stack.pop();
                int count = 0;
                for (int subordinate : tree.get(current)) {
                    count += 1 + tempCount[subordinate]; // 1 (direct subordinate) + subordinates of the subordinate
                }
                tempCount[current] = count;
                subordinatesCount[current] = count;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
