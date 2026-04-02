import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class entry_13958912 {

 public static class FastReader {
    private static final byte[] buffer = new byte[1 << 20]; // 1 MB buffer
    private int ptr = 0, len = 0;

    private int read() throws IOException {
        if (ptr >= len) {
            ptr = 0;
            len = System.in.read(buffer);
            if (len <= 0) return -1;
        }
        return buffer[ptr++] & 0xff;
    }

    public int nextInt() throws IOException {
        int c, x = 0;
        while ((c = read()) <= ' ')
            if (c < 0) return -1;
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            x = x * 10 + (c - '0');
        } while ((c = read()) >= '0' && c <= '9');
        return neg ? -x : x;
    }

    public long nextLong() throws IOException {
        int c;
        long x = 0;
        while ((c = read()) <= ' ')
            if (c < 0) return -1;
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            x = x * 10 + (c - '0');
        } while ((c = read()) >= '0' && c <= '9');
        return neg ? -x : x;
    }

    public String next() throws IOException {
        int c;
        while ((c = read()) <= ' ')
            if (c < 0) return null;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = read()) > ' ');
        return sb.toString();
    }

    public String nextLine() throws IOException {
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = read()) != -1 && c != '\n') {
            sb.append((char) c);
        }
        return sb.toString();
    }
}

    public static void main(String args[]) throws IOException {
        FastReader fast = new FastReader();
        tree = new ArrayList<>();
        final int n = fast.nextInt();
        tree.add(new ArrayList<>());        // Add extra index for 1 based indexing
        for(int i = 1; i <= n; i++)
            tree.add(new ArrayList<>());
        for(int j = 2; j <= n; j++)
            tree.get(fast.nextInt()).add(j);
        solve(n);
    }

    public static List<List<Integer>> tree;
    public static int ans[];

    public static void solve(final int n) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ans = new int[n+1];
        countSubtree(1);
        final StringBuilder output = new StringBuilder();
        for(int i = 1; i <= n; i++)
            output.append(ans[i]).append(" ");
        writer.write(output.toString().trim());
        writer.flush();
    }

    // Imp- Recursive, can blow for skewed trees 2 x 10^5
    public static int subtree(int root) {
        if(tree.get(root).isEmpty())
            return 0;
        for(int child : tree.get(root))
            ans[root] += 1 + subtree(child);        // Add sum from all nodes not just the last level
        return ans[root];
    }

    public static void countSubtree(int root) {
        Stack<Integer> dfs = new Stack<>(), postOrder = new Stack<>();
        dfs.push(root);     // start the dfs
        while(!dfs.isEmpty()) {
            int node = dfs.pop();
            // Imp- Append in post order (stack), in order (queue)
            postOrder.push(node);
            for(int child : tree.get(node))
                dfs.push(child);
        }
        while(!postOrder.isEmpty()) {
            int node = postOrder.pop();
            // For each node check its children and perform the computation (add, count, etc.)
            for(int child : tree.get(node))
                ans[node] += 1 + ans[child];
        }
    }
}