import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.concurrent.LinkedTransferQueue;
import java.util.*;

public class entry_11552611 {

    public static ArrayList<Integer>[] adjlist;
    public static int lastnode;
//    public static boolean[] visited;
    public static int[] distances;

    public static int[]answers;

    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader();
        int n = scanner.nextInt();
        adjlist = new ArrayList[n];
        distances=new int[n];
        answers=new int[n];
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            adjlist[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            adjlist[a].add(b);
            adjlist[b].add(a);
        }
        bfs(0);
//        System.out.println(lastnode);
        int firtsendpoint=lastnode;
        //so this "lastnode" is one of the endpoints of the diameter!!!
        bfs(lastnode);
        int secondendpoint=lastnode;
//        System.out.println("first end point is: "+firtsendpoint+" and second end point is: "+secondendpoint);
        //now just find ki dono mei se kaunsa is further from a given node
        //i.e do a bfs from first end point and then
        bfs1(firtsendpoint);
        bfs1(secondendpoint);
//        System.out.println(Arrays.toString(distances));
        for(int i=0;i<n;i++){
            sb.append(distances[i]).append(" ");
        }
        System.out.println(sb);
    }

   public static void bfs(int start){
        Queue<Integer>q=new ArrayDeque<>();
        q.add(start);
        int parent=-1;
        boolean[]visited=new boolean[adjlist.length];
        visited[start]=true;
        while(!q.isEmpty()){
//            System.out.println("Queue is: "+q);
            int pop=q.poll();
            lastnode=pop;
            visited[pop]=true;
            for(int child:adjlist[pop]){
                if(!visited[child]){
                    q.add(child);
                }
            }
        }
   }

   public static void bfs1(int start){
        Queue<Integer>q=new ArrayDeque<>();
        q.add(start);
        boolean[]visited=new boolean[adjlist.length];
        int[]dist=new int[adjlist.length];
        visited[start]=true;
        while(!q.isEmpty()){
            int pop=q.poll();
            visited[pop]=true;
            for(int child:adjlist[pop]){
                if(!visited[child]){
                    dist[child]=dist[pop]+1;
                    distances[child]=Math.max(dist[child],distances[child]);
                    q.add(child);
                }
            }
        }
   }
    /*
    i think diameter+ forest se kar sakta hai yaar omg so any node hai uska dfs ya bfs kar lo endpoints of diameter se i think
     */


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
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[10000000]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
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
            } while ((c = read()) >= '0' && c <= '9');
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

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
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

}