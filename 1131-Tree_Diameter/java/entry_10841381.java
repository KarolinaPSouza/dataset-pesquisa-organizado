import java.io.*;
import java.util.*;



class Main {

    static class Reader { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 

        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream( 
                new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) { 
                if (c == '\n') { 
                    if (cnt != 0) { 
                        break; 
                    } 
                    else { 
                        continue; 
                    } 
                } 
                buf[cnt++] = (byte)c; 
            } 
            return new String(buf, 0, cnt); 
        } 

        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') { 
                c = read(); 
            } 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 

            if (neg) 
                return -ret; 
            return ret; 
        } 

        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 

        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 

            do { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 

            if (c == '.') { 
                while ((c = read()) >= '0' && c <= '9') { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 

            if (neg) 
                return -ret; 
            return ret; 
        } 

        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, 
                                 BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 

        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 

        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }


    // static ArrayList<Integer>[] adj = new ArrayList<Integer>[200005];

    static class Graph {
        int n;
        ArrayList<Integer>[] adj = new ArrayList[200005];

        Graph(int N) {
            n=N;
            for(int i=0; i<=N+1; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        // returns farthest node from u
        ArrayList<Integer> bfs(int u) {
            ArrayList<Integer> farthest = new ArrayList<>();

            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.addLast(u);
            boolean[] vis = new boolean[n+1];
            vis[u] = true;
            int front=-1;
            int dist=-1;

            while(!queue.isEmpty()) {
                int removed = 0;
                int qsz = queue.size();
                while(removed != qsz) {
                    front = queue.removeFirst();
                    removed++;
                    for(int v: adj[front]) {
                        if(!vis[v]) {
                            vis[v] = true;
                            queue.addLast(v);
                        }
                    }
                }
                dist++;
            }
            farthest.add(front);
            farthest.add(dist);
            return farthest;
        }
    }

    public static void main(String args[]) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Reader r = new Reader();
        int n = r.nextInt();
        Graph graph = new Graph(n);

        for(int i=0; i<n-1; i++) {
            int u = r.nextInt();
            int v = r.nextInt();
            graph.addEdge(u, v);
        }
        ArrayList<Integer> diamEnd1 = graph.bfs(1);
        // System.out.println(diamEnd1.get(1) + ","+diamEnd1.get(1));
        ArrayList<Integer> diamEnd2 = graph.bfs(diamEnd1.get(0));
        System.out.println(diamEnd2.get(1));

    }

}