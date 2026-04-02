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
public class entry_780173 { 
    static Random random;

    /* public static void main(String[] args){
        new Thread(null, new entry_780173 (), "Main", 1<<26).start();
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
                int u = in.nextInt(), v = in.nextInt(), c = in.nextInt();
                nodes[u].addEdge(nodes[v], c);
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
            class State {
                long dist; Node node;
                State(long dist, Node node){
                    this.dist = dist;
                    this.node = node;
                }
            }
            PriorityQueue<State> pq = new PriorityQueue<>((s, t) -> Long.compare(s.dist, t.dist));
            pq.add(new State(from.dist, from));

            while(!pq.isEmpty()){
                State cur = pq.poll();
                if(cur.dist > cur.node.dist) continue;

                for(int i = 0; i<cur.node.adj.size(); i++){
                    Node to = cur.node.adj.get(i);
                    long cost = cur.node.costs.get(i);
                    if(cur.dist + cost < to.dist){
                        to.dist = cur.dist + cost;
                        pq.add(new State(to.dist, to));
                    }
                }
            }
            return;
        }

        private static class Node {
            ArrayList<Integer> costs = new ArrayList<>();
            ArrayList<Node> adj = new ArrayList<>();
            long dist = Long.MAX_VALUE;
            void addEdge(Node n, int cost){
                costs.add(cost);
                adj.add(n);
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