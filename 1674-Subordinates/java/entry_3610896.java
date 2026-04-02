import javax.swing.text.Segment;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class entry_3610896 {
    private static class FastIO {
        private static class FastReader
        {
            BufferedReader br;
            StringTokenizer st;

            FastReader()
            {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            String next()
            {
                while (st == null || !st.hasMoreElements())
                {
                    try
                    {
                        st = new StringTokenizer(br.readLine());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }
            int nextInt() { return Integer.parseInt(next()); }
            long nextLong() { return Long.parseLong(next()); }
            double nextDouble() { return Double.parseDouble(next()); }
            String nextLine()
            {
                String str = "";
                try
                {
                    str = br.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return str;
            }
        }

        private static PrintWriter out = new PrintWriter(System.out);
        private static FastReader in = new FastReader();

        public void print(String s) {out.print(s);}

        public void println(String s) {out.println(s);}

        public void println() {
            println("");
        }

        public void print(int i) {out.print(i);}
        public void print(long i) {out.print(i);}
        public void print(char i) {out.print(i);}
        public void print(double i) {out.print(i);}

        public void println(int i) {out.println(i);}
        public void println(long i) {out.println(i);}
        public void println(char i) {out.println(i);}
        public void println(double i) {out.println(i);}

        public void printIntArrayWithoutSpaces(int[] a) {
            for(int i : a) {
                out.print(i);
            }
            out.println();
        }
        public void printIntArrayWithSpaces(int[] a) {
            for(int i : a) {
                out.print(i + " ");
            }
            out.println();
        }

        public int[] getIntArray(int n) {
            int[] res = new int[n];
            for(int i = 0; i < n; i++) {
                res[i] = in.nextInt();
            }
            return res;
        }
        public static List<Integer> getIntList(int n) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            return list;
        }

        public static void printKickstartCase(int i) {
            out.print("Case #" + i + ": ");
        }

        public String next() {return in.next();}
        int nextInt() { return in.nextInt(); }
        char nextChar() {return in.next().charAt(0);}
        long nextLong() { return in.nextLong(); }
        double nextDouble() { return in.nextDouble(); }
        String nextLine() {return in.nextLine();}

        public void close() {
            out.flush();
            out.close();
        }
    }
    private static final FastIO io = new FastIO();

    private static class MathUtil {

        public static final int MOD = 1000000007;

        public static int gcd(int a, int b) {
            if(b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        public static int gcd(int[] a) {
            if(a.length == 0) {
                return 0;
            }
            int res = a[0];
            for(int i = 1; i < a.length; i++) {
                res = gcd(res, a[i]);
            }
            return res;
        }

        public static int gcd(List<Integer> a) {
            if(a.size() == 0) {
                return 0;
            }
            int res = a.get(0);
            for(int i = 1; i < a.size(); i++) {
                res = gcd(res, a.get(i));
            }
            return res;
        }

        public static int modular_mult(int a, int b, int M) {
            long res = (long)a * b;
            return (int)(res % M);
        }
        public static int modular_mult(int a, int b) {
            return modular_mult(a, b, MOD);
        }

        public static int modular_add(int a, int b, int M) {
            long res = (long)a + b;
            return (int)(res % M);
        }
        public static int modular_add(int a, int b) {
            return modular_add(a, b, MOD);
        }

        public static int modular_sub(int a, int b, int M) {
            long res = ((long)a - b) + M;
            return (int)(res % M);
        }
        public static int modular_sub(int a, int b) {
            return modular_sub(a, b, MOD);
        }

        //public static int modular_div(int a, int b, int M) {}
        //public static int modular_div(int a, int b) {return modular_div(a, b, MOD);}

        public static int pow(int a, int b, int M) {
            int res = 1;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = modular_mult(res, a, M);
                }
                a = modular_mult(a, a, M);
                b = b >> 1;
            }
            return res;
        }

        public static int pow(int a, int b) {
            return pow(a, b, MOD);
        }

    /*public static int fact(int i, int M) {
     }
     public static int fact(int i) {
     }
     public static void preComputeFact(int i) {
     }
     public static int mod_mult_inverse(int den, int mod) {
     }
     public static void C(int n, int r) {
     }*/

    }

    private static final int M = 1000000007;
    private static final String yes = "YES";
    private static final String no = "NO";

    private static final int UNVISITED = 0;

    private static class Graph {
        int n;
        List<Set<Integer>> adj;
        Graph(int n) {
            this.n = n;
            adj = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                adj.add(new HashSet<>());
            }
        }

        public void addUndirectedEdge(int a, int b) {
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        public void addDirectedEdge(int a, int b) {
            adj.get(a).add(b);
        }

        public boolean hasEdgeConnecting(int a, int b) {
            return adj.get(a).contains(b);
        }

        public Set<Integer> getNeighbours(int a) {
            return adj.get(a);
        }
    }

    private static class Tree extends Graph {
        Tree(int n) {
            super(n);
        }
        @FunctionalInterface
        private static interface TreeTraversalPolicy {
            void updateValue(int parent, int child, int[] value);
        }

        private static class DfsNode {
            int parent;
            int child;
            boolean visited;
            DfsNode(int parent, int child) {
                this.parent = parent;
                this.child = child;
                visited = false;
            }

            public void setVisited() {
                visited = true;
            }

            public boolean isVisited() {
                return visited;
            }
        }

        public boolean isLeaf(int a, int root) {
            if(a == root) {
                return false;
            }
            return (getNeighbours(a).size() == 1);
        }

        public int[] postOrder(int root, TreeTraversalPolicy policy, int leaf_value) {
            int[] res = new int[n];
            Stack<DfsNode> stack = new Stack<>();

            stack.push(new DfsNode(-1, root));

            while(!stack.isEmpty()) {
                DfsNode node = stack.peek();
                if(isLeaf(node.child, root)) {
                    res[node.child] = leaf_value;
                    policy.updateValue(node.parent, node.child, res);
                    stack.pop();
                    continue;
                }
                if(node.isVisited()) {
                    if(node.parent != -1) {
                        policy.updateValue(node.parent, node.child, res);
                    }
                    stack.pop();
                    continue;
                }
                node.setVisited();
                Set<Integer> neighbours = getNeighbours(node.child);
                for(int neighbour : neighbours) {
                    if(neighbour == node.parent) {
                        continue;
                    }
                    stack.push(new DfsNode(node.child, neighbour));
                }
            }
            return res;
        }

        public int[] preOrder(int root, TreeTraversalPolicy policy, int root_value) {
            int[] res = new int[n];
            Stack<DfsNode> stack = new Stack<>();
            res[root] = root_value;
            stack.push(new DfsNode(-1, root));

            while(!stack.isEmpty()) {
                DfsNode node = stack.pop();
                Set<Integer> neighbours = getNeighbours(node.child);
                for(int neighbour : neighbours) {
                    if (neighbour == node.parent) {
                        continue;
                    }
                    policy.updateValue(node.child, neighbour, res);
                    stack.push(new DfsNode(node.child, neighbour));
                }
            }
            return res;
        }
    }

    public static void main(String[] args)
    {
        //long start = System.nanoTime();
        //int t = io.nextInt();
        int t = 1;
        for(int z = 0; z < t; z ++) {
            int n = io.nextInt();
            /*Tree tree = new Tree(n);
            for(int i = 1; i < n; i ++) {
                tree.addUndirectedEdge(i, io.nextInt() - 1);
            }
             int[] res = tree.postOrder(0, new Tree.TreeTraversalPolicy() {
                @Override
                public void updateValue(int parent, int child, int[] value) {
                    value[parent] += (1 + value[child]);
                }
            }, 0);
             //int[] res = tree.postOrder(0, (parent, child, value) -> {
                //value[parent] += (1 + value[child]);
            //}, 0);
             //Arrays.stream(res).forEach((i) -> io.print(i + " "));
            for(int i : res) {
                io.print(i + " ");
            }
            io.println();*/
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            for(int i = 1; i < n; i ++) {
                int a = i;
                int b = io.nextInt() - 1;
                list.get(a).add(b);
                list.get(b).add(a);
            }

            int[] res = new int[n];
            Stack<Tree.DfsNode> stack = new Stack<>();
            int root = 0;
            int leaf_value = 0;
            stack.push(new Tree.DfsNode(-1, root));

            while(!stack.isEmpty()) {
                Tree.DfsNode node = stack.peek();
                if(node.child != root && list.get(node.child).size() == 1) {
                    res[node.child] = leaf_value;
                    res[node.parent] += (1 + res[node.child]);
                    stack.pop();
                    continue;
                }
                if(node.isVisited()) {
                    if(node.parent != -1) {
                        res[node.parent] += (1 + res[node.child]);
                    }
                    stack.pop();
                    continue;
                }
                node.setVisited();
                List<Integer> neighbours = list.get(node.child);
                for(int neighbour : neighbours) {
                    if(neighbour == node.parent) {
                        continue;
                    }
                    stack.push(new Tree.DfsNode(node.child, neighbour));
                }
            }
            Arrays.stream(res).forEach((i) -> io.print(i + " "));
        }
        io.close();
    }
}