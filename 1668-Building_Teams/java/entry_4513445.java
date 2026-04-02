import java.io.*;
import java.util.*;
public class entry_4513445 {

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

    static boolean possible=true;
    static int[] teams;


    public static void main(String args[] ) throws Exception {
        Reader reader=new Reader();
        int n =reader.nextInt();
        int m =reader.nextInt();
        possible=true;
        Graph graph=new Graph(n+1);

        for (int i =0;i< m ;i++){
            int a=reader.nextInt();
            int b=reader.nextInt();

            graph.addEdge(a, b);

        }


        teams=new int[n+1];


        for (int i =1;i <=n ;i++){
            if(teams[i]==0)
                bfs(i  , graph);

        }

        if(!possible) {
            System.out.println("IMPOSSIBLE");
            return ;
        }

        for (int i =1;i< teams.length ;i++){
            System.out.print(teams[i]+" ");
        }

    }


    static void bfs(int u ,  Graph graph ){



        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{u , 1});
        teams[u]=1;


        while(!queue.isEmpty()){


            int[] arr= queue.poll();

            int v=arr[0];
            int parentColor=arr[1];

            for(int i: graph.adj[v]){

                int childColor=teams[i];

                if(childColor==parentColor) {
                    possible = false;
                    return ;

                }
                if(teams[i]!=0)
                    continue;

                teams[i]=(parentColor==1)?2:1;

                queue.add(new int[]{i, teams[i]});

            }

        }



    }
}
