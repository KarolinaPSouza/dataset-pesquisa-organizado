import java.io.*;
import java.util.*;

public class entry_13911682 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        // Example: Read a single integer
        int n = fr.nextInt();
        int m =fr.nextInt();
        // Example: Read array of integers
        int[][] e = new int[m][2];
        for (int i = 0; i < m; i++) {
            e[i][0] = fr.nextInt()-1;
            e[i][1] = fr.nextInt()-1;
        }
        solve(e,n,m);
    }
    public static void solve(int[][] e,int n,int m){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] ed : e){
            graph.get(ed[0]).add(ed[1]);
            graph.get(ed[1]).add(ed[0]);
        }
        int[] color=new int[n];
        Arrays.fill(color,-1);
        boolean flag=true;
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(color[i] != -1) continue;
            qu.offer(i);
            color[i]=0;
            while(!qu.isEmpty()){
                int u=qu.remove();
                for(int v : graph.get(u)){
                    if(color[v] == -1){
                        color[v]=1-color[u];
                        qu.offer(v);
                    }
                    if(color[v] == color[u]){
                        flag=false;
                        break;
                    }
                }
                if(!flag){
                    break;
                }
            }
        }
        if(flag){
            for(int i=0;i<n;i++){
                System.out.print(color[i]+1+" ");
            }
        }
        else{
            System.out.println("IMPOSSIBLE");
        }
        System.out.println();
    }
}

class FastReader {
    final private int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastReader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public FastReader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String nextLine() throws IOException {
        byte[] buf = new byte[64];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public String next() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = read()) > ' ');
        return sb.toString();
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return neg ? -ret : ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return neg ? -ret : ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }
        return neg ? -ret : ret;
    }

    public char nextChar() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();
        return (char) c;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }

    public void close() throws IOException {
        din.close();
    }
}