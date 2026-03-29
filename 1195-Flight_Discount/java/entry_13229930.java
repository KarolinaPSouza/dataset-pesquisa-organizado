import java.util.*;
import java.io.*;
public class entry_13229930 {
    public static class Node implements Comparable<Node>{
        int des;
        long path;
        int state;
        public Node(int des,long path,int state) {
            this.des = des;
            this.path = path;
            this.state = state;
        }
        @Override
        public int compareTo(Node n2){
            return Long.compare(this.path, n2.path);
        }
    }
    public static void main(String args[]) throws Exception {
        _BufferedReader br = new _BufferedReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Node> list[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c= Integer.parseInt(st.nextToken());
            a--;b--;
            list[a].add(new Node(b,c,0));
        }
        long dist[][] = new long[n][2];
        for(int i= 1; i < n; i++){
            Arrays.fill(dist[i],(long)1e17);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean vis[][] = new boolean[n][2];
        pq.add(new Node(0,0,0));
        pq.add(new Node(0,0,1));

        // vis[0][0] = true;
        // vis[0][1] = true;

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int e = curr.des;
            long path = curr.path;

            int state = curr.state;
            if (vis[e][state]) continue; // Already processed
            vis[e][state] = true;
            for(Node x : list[e]){

                int xn = x.des;
                if(state == 1 ){ 
                    long d0 = dist[e][1] + x.path;
                    if((dist[xn][1] > d0 )){  
                        dist[xn][1] = d0;
                        if(!vis[xn][1])pq.add(new Node(xn,d0,1));

                    }

                }
                else {
                    long d0  = (dist[e][0] + x.path);
                    if((dist[xn][0] > d0) ){
                        dist[xn][0] = d0;
                        if(!vis[xn][0])pq.add(new Node(xn,d0,0));

                    }
                    long d1 = (dist[e][0] + x.path/2);
                    if((dist[xn][1] > d1)){
                        dist[xn][1] = d1;
                        if(!vis[xn][1])pq.add(new Node(xn,d1,1));

                    }
                }
            }  
        }
        pw.println(Math.min(dist[n-1][1],dist[n-1][0]));//just like that
        pw.flush();;
    }
    static class _BufferedReader {
        private final InputStream is;
        private final byte[] buf = new byte[1 << 16];
        private int idx, total;
        private final StringBuilder sb = new StringBuilder();

        public _BufferedReader(InputStream is) {
            this.is = is;
        }

        private byte read() throws IOException {
            if (idx == total) {
                total = is.read(buf);
                idx = 0;
                if (total == -1) return -1;
            }
            return buf[idx++];
        }

        public String readLine() throws IOException {
            sb.setLength(0);
            byte c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                if (c == '\r') continue;
                sb.append((char) c);
            }
            return sb.length() == 0 && c == -1 ? null : sb.toString();
        }
    }

}