import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class entry_9061959 {
    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int calculateSubordinates(int i, Map<Integer, List<Integer>> tree, int[] cache) {
        List<Integer> children = tree.get(i);
        if (children == null) {
            return 0;
        } else if (cache[i - 1] != 0) {
            return cache[i - 1];
        }

        int total = children.size();
        for (int child : children) {
            total += cache[child - 1] != 0 ? cache[child - 1] : calculateSubordinates(child, tree, cache);
        }

        cache[i - 1] = total;
        return total;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out= new PrintWriter(System.out);
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int n = sc.nextInt();
        int[] cache = new int[n];
        for (int i = 2; i <= n; ++i) {
            int parent = sc.nextInt();
            if (!tree.containsKey(parent)) {
                tree.put(parent, new ArrayList<>());
            }
            tree.get(parent).add(i);
        }

        calculateSubordinates(1, tree, cache);
        for (int x : cache) {
            out.print(x);
            out.print(" ");
        }

        out.flush();
    }
}