import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class entry_14657068 {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }
    }

    static int vertex ;
    static int edges ;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static int[] teams;

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        vertex = sc.nextInt();
        edges = sc.nextInt();
        adj = new ArrayList<>();
        teams = new int[vertex+1];
        visited = new boolean[vertex+1];
        for(int i=0;i<=vertex;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int stud = 1 ; stud<=vertex ; stud++){
            if(visited[stud]) continue;

            Queue<Integer> q = new LinkedList<>();
            visited[stud] =true;
            teams[stud] = 1;
            q.offer(stud);

            while(!q.isEmpty()){
                int node = q.poll();
                for(int cur : adj.get(node)){
                    if(!visited[cur]){
                        visited[cur]=true;
                        teams[cur] = 3 - teams[node];
                        q.add(cur);
                    }else if(teams[cur]==teams[node]){
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<teams.length;i++){
            sb.append(teams[i]).append(" ");
        }
        System.out.println(sb);

    }

}