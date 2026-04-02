import java.util.*;
import java.io.*;

public class entry_16116775 {
    static List<Integer>[] children;
    static int[] subordinates;
    static FastInput fi;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        fi = new FastInput();
        int n = fi.nextInt();

        @SuppressWarnings("unchecked")
        List<Integer>[] temp = new ArrayList[n + 1];
        children = temp;
        subordinates = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 2; i <= n; i++) {
            int boss = fi.nextInt();
            children[boss].add(i);
        }

        dfsIterative(1);

        for (int i = 1; i <= n; i++) {
            sb.append(subordinates[i]);
            if (i < n)
                sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    static void dfsIterative(int root) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[children.length];

        stack.push(root);

        while (!stack.isEmpty()) {
            int emp = stack.peek();

            if (visited[emp] == 0) {
                visited[emp] = 1;
                for (int i = children[emp].size() - 1; i >= 0; i--) {
                    stack.push(children[emp].get(i));
                }
            } else {
                stack.pop();
                int count = 0;
                for (int child : children[emp]) {
                    count += 1 + subordinates[child];
                }
                subordinates[emp] = count;
            }
        }
    }

    static class FastInput {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        StringTokenizer st = new StringTokenizer("");

        String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}