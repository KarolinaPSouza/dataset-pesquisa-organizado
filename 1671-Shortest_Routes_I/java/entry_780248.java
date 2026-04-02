import java.io.*;
import java.util.*;

/*
10 20
8 5 1
9 10 2
7 9 8
9 8 8
10 9 9
7 8 10
8 9 2
7 10 10
4 5 8
5 6 1
4 2 1
5 3 6
10 7 3
3 5 2
5 4 7
1 2 9
2 3 2
6 7 5
3 4 10
3 2 10
*/
public class entry_780248 { 
    static Random random;

    /* public static void main(String[] args){
        new Thread(null, new entry_780248 (), "Main", 1<<26).start();
    } */

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        random = new Random();

        // long timeStamp = System.currentTimeMillis();
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
        // System.err.println("TIME: "+(System.currentTimeMillis()-timeStamp)+" ms");
    }

    /* ------------------------------------- START -------------------------------------------- */
    static class Solver {
        public void solve(FastScanner in, PrintWriter out) throws Exception {
            int n = in.nextInt(), m = in.nextInt();
            Node[] nodes = new Node[n+1];
            Arrays.setAll(nodes, i -> new Node());
            for(int i = 0; i<m; i++){
                new Edge(nodes[in.nextInt()], nodes[in.nextInt()], in.nextInt());
            }

            dijkstra(nodes[1]);

            for(int i = 1; i<=n; i++){
                out.print(nodes[i].dist);
                out.print(' ');
            }
            out.println();
        }

        private static void dijkstra(Node from) {
            from.dist = 0;
            class State {long d; Node n;}
            PriorityQueue<State> pq = new PriorityQueue<>((s, t) -> Long.compare(s.d, t.d));
            pq.add(new State(){{d = from.dist; n = from;}});

            while(!pq.isEmpty()){
                State cur = pq.poll();
                if(cur.d > cur.n.dist) continue;

                for(Edge e : cur.n.edges){
                    if(cur.d + e.cost < e.v.dist){
                        e.v.dist = cur.d + e.cost;
                        pq.add(new State(){{d = e.v.dist; n = e.v;}});
                    }
                }
            }
            return;
        }

        private static class Node {
            ArrayList<Edge> edges = new ArrayList<>();
            long dist = Long.MAX_VALUE;
        }

        private static class Edge {
            Node u, v;
            int cost;
            Edge(Node u, Node v, int c){
                this.u = u;
                this.v = v;
                this.cost = c;
                u.edges.add(this);
            }
        }
    }
    /* -------------------------------------- END --------------------------------------------- */

    /* Shuffle function to shuffle before Arrays.sort */
    static void shuffle(int[] arr){
        int swapTemp;
        for(int i = arr.length-1; i>= 1; i--){
            int pos = random.nextInt(i+1);
            if(pos == i) continue;
            {swapTemp = arr[i]; arr[i] = arr[pos]; arr[pos] = swapTemp;}
        }
    }

    /* Fast Input reader */
    static class FastScanner {
        BufferedReader reader;
        StreamTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StreamTokenizer(reader);
            tokenizer.resetSyntax();
            tokenizer.whitespaceChars(0, 32);
            tokenizer.wordChars(33, 126);
        }
        String next() throws Exception {
            tokenizer.nextToken();
            return tokenizer.sval;
        }
        int nextInt() throws Exception {
            tokenizer.nextToken();
            return Integer.parseInt(tokenizer.sval);
        }
        long nextLong() throws Exception {
            tokenizer.nextToken();
            return Long.parseLong(tokenizer.sval);
        }
        double nextDouble() throws Exception {
            tokenizer.nextToken();
            return Double.parseDouble(tokenizer.sval);
        }
        String nextLine() throws Exception {
            String string = reader.readLine();
            return string;
        }
    }
}