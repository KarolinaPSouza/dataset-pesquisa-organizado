import java.io.*;
import java.util.*;

class Main {

    FastReader in = new FastReader();
    StringBuilder out = new StringBuilder();

    class TreeNode {
        int id;
        List<TreeNode> children;
        public TreeNode(int id) {
            this.id = id;
            children = new ArrayList<>();
        }

        public void addChild(TreeNode child) {
            children.add(child);
        }
    }

    public void solve() throws Exception {
        int n = in.nextInt();

        TreeNode[] nodes = new TreeNode[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i);
        }

        for (int i = 1; i < n; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            nodes[a].addChild(nodes[b]);
            nodes[b].addChild(nodes[a]);
        }

        // post order traversal
        int[] farthest = bfs(nodes, nodes[0]);
        int[] diameter = bfs(nodes, nodes[farthest[0]]);

        out.append(diameter[1]);

        System.out.print(out);
    }

    public int[] bfs(TreeNode[] nodes, TreeNode startNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodes.length];
        queue.add(startNode);
        int depth = -1;
        TreeNode lastProcessedNode = startNode;
        while(!queue.isEmpty()) {
            int nodesAtDepth = queue.size();
            depth++;
            for(int i = 0; i < nodesAtDepth; i++) {
                TreeNode node = queue.poll();
                lastProcessedNode = node;
                visited[node.id] = true;
                for(TreeNode child: node.children) {
                    if(visited[child.id]) {continue;}
                    queue.add(child);
                }
            }
        }

        return new int[]{lastProcessedNode.id, depth};
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }

    // reusable fast input
    class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        double nextDouble() throws IOException { return Double.parseDouble(next()); }
        String nextLine() throws IOException { return br.readLine(); }
    }
}