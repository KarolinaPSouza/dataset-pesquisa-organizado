import com.sun.tools.jconsole.JConsoleContext;

import java.io.*;
import java.util.*;
public class entry_4520301 {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
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

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        public void newLine() {
            bufferPointer++;

        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }


    }

    static class Graph{
        int V;
        List<Integer> adj[];

        public Graph(int V){
            this.V=V;
            adj=new ArrayList[V];

            for(int i =0;i<V;i++){

                adj[i]=new ArrayList<>();

            }

        }

        void addEdge(int u , int v){

            adj[u].add(v);
            adj[v].add(u);

        }

    }


    static boolean[] recStack;
    static boolean[] visited;
   static  List<Integer> cycle=new ArrayList<>();



    public static void main(String args[] ) throws Exception {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        recStack=new boolean[n+1];
        visited=new boolean[n+1];
        Arrays.fill(visited , false);
        Graph graph = new Graph(n + 1);

        for (int i = 0; i < m; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();

            graph.addEdge(a, b);

        }
        list=new ArrayList<>();


        for(int i=1;i<n;i++ ){
            List<Integer> finalAns=new ArrayList<>();

            if(!visited[i] && containsGraph(i , -1 , graph)){
                int check=list.get(list.size()-1);
                //System.out.println(list.size());

                finalAns.add(check);

                for(int j=list.size()-2 ; j>=0 ;j--){
                    finalAns.add(list.get(j));

                    if(list.get(j)==check) {
                        printAns (finalAns);
                        return;
                    }
                }
            }


        }



        System.out.println("IMPOSSIBLE");


    }
    static void printAns(List<Integer> list){

        System.out.println(list.size());
        for (int i :list){
            System.out.print(i+" ");
        }
    }
    static  List<Integer> list;
    static boolean containsGraph(int u , int parent,Graph graph) {

        visited[u] = true;
        list.add(u);

        for (int i : graph.adj[u]) {

            if(!visited[i]){
                if(containsGraph(i , u , graph))
                    return true;

            }else{
                if(i !=parent ){
                    list.add(i);

                    return true;
                }
            }

        }

        list.remove(list.size()-1);
        return false;
    }



}
