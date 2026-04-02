import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class entry_14704586 {

    // A more reliable Fast I/O implementation
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static List<List<Integer>> tree;
    static int[] subordinates;
    //took help from chatgpt/gemini
    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder ans = new StringBuilder();

        int n = fs.nextInt();
        tree = new ArrayList<>();
        subordinates = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            int boss = fs.nextInt();
            tree.get(boss).add(i);
        }

        //recursive dfs taking time
        //dfs(1);

        //iterative dfs
        Stack<Integer> traversalStack = new Stack<>();
        traversalStack.push(1);
        Stack<Integer> orderStack = new Stack<>();

        while(!traversalStack.isEmpty()) {
            int u = traversalStack.pop();
            orderStack.push(u);
            for(int child:tree.get(u)){
                traversalStack.push(child);
            }
        }

        while(!orderStack.isEmpty()) {
            int u=orderStack.pop();
            int count=0;
            for(int child:tree.get(u)) {
                count+=subordinates[child]+1;// Add the child itself plus its subordinates
            }
            subordinates[u]=count;
        }

        for (int i = 1; i <= n; i++) {
            ans.append(subordinates[i]).append(" ");
        }
        out.println(ans.toString().trim());
        out.flush();
        out.close();
    }

    public static int dfs(int node) {
        int size=1;
        List<Integer> children = tree.get(node);
        for(int child:children) {
            size+=dfs(child);
        }
        subordinates[node]=size-1;
        return size;
    }

}