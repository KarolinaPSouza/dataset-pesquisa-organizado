import java.io.*;
import java.util.*;

public class entry_11030851 implements Runnable {
    static int count = 0;

    public static void main(String[] args) {
        new Thread(null, new entry_11030851(), "entry_11030851", 1 << 28).start();
    }

    @Override
    public void run() {
        FastReader fr = new FastReader(System.in);

        int n = fr.nextInt();
        int m = fr.nextInt();
        DSU_ dsu = new DSU_(n);
        for (int i = 0; i < m; i++) {
            dsu.union(fr.nextInt()-1, fr.nextInt()-1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(dsu.find(i)+1);
        }
        System.out.println(set.size()-1);
        Object[] arr = set.toArray();
        int size = set.size();
        for (int i = 0; i < size-1; i++) {
            System.out.println((arr[i])+" "+(arr[i+1]));
        }


    }


    public static  class DSU_ {
        private int[] parent;
        private int[] rank;


        // Time Complexity: O(n)
        // Space Complexity: O(n)
        public DSU_(int n) {
            parent = new int[n];  // Zero-based indexing
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // Find the root of the set containing x with path compression
        // Time Complexity: O(log n) (amortized)
        // Space Complexity: O(log n) (due to recursive stack)
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);  // Path compression
            }
            return parent[x];
        }

        // Union two sets by rank
        // Time Complexity: O(1) (amortized)
        // Space Complexity: O(1)
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                // Union by rank
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        // Check if two elements are in the same set
        // Time Complexity: O(log n) (amortized)
        // Space Complexity: O(1)
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        // Main method for testing

    }




    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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

        int nextInt() { return Integer.parseInt(next()); }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}