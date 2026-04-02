import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;

import static java.util.Arrays.setAll;
import static java.util.Arrays.sort;


public class entry_11151037 {
    static FastReader scan = new FastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static long[] dp;
    static int n;
    static long[] res;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        int ttt= 1;
        for(int eee=0;eee<ttt;eee++){
            solve();
        }
        out.close();
    }

    static ArrayList<List<Pair>> graph;

    public static void solve() throws IOException {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int q=scan.nextInt();
        long[][] dist = new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dist[i],1000000000000l);
        }
        for(int i=0;i<=n;i++){
            dist[i][i]=0L;
        }
        for(int i=0;i<m;i++){
            int u=scan.nextInt();
            int v=scan.nextInt();
            long w=scan.nextLong();
            dist[u][u]=0;
            dist[v][v]=0;
            dist[u][v]=Math.min(dist[u][v],w);
            dist[v][u]=Math.min(dist[v][u],w);
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        for(int i=0;i<q;i++){
            int u=scan.nextInt();
            int v=scan.nextInt();
            out.println(dist[u][v]==1000000000000l?-1:dist[u][v]);
        }


    }
//    static void dfs2(int v,int pre){
//        res[v]=dp[v];
//        for(int u:list[v]){
//            if(u==pre) continue;
//            dp[v]-=Math.max(0,dp[u]);
//            dp[u]+=Math.max(0,dp[v]);
//            dfs2(u,v);
//            dp[u]-=Math.max(dp[v],0);
//            dp[v]+=Math.max(dp[u],0);
//
//        }
//    }
//static void dfs(int v,int pre){
//        dp[v]=arr[v];
//        for(int u:list[v]){
//            if(u==pre)continue;
//            dfs(u,v);
//            dp[v]+=Math.max(dp[u],0);
//        }
//}


    static class Pair{
        // int index;
        int first;
        long second;
        Pair(int x, long y){
            // this.index=a;
            this.first=x;
            this.second=y;
        }


    }

    static class FastReader {
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) {
            in = is;
        }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        int[] nextArrInt(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] nextArrLong(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }

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
            byte[] buf = new byte[64]; // line length
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

        public void printarray(int arr[]) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}