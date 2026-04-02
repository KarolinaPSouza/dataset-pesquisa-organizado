import java.io.*;
import java.util.*;

public class entry_11602852 {
    static StringBuilder sbAns = new StringBuilder("");
    static void solve() throws IOException {
        long max = Long.MAX_VALUE;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        long dist[][] = new long[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                dist[i][j] = max;
            dist[i][i] = 0;
        }

        while(m-->0) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            long c = sc.nextLong();
            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = dist[a][b];
        }

        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(dist[i][k]!=max && dist[k][j]!=max)
                        dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
                }
            }
        }

        while(q-->0) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            sbAns.append(dist[a][b] == max?-1:dist[a][b]).append('\n');
        }
        out.println(sbAns.toString());

    }

    // static void dfs(int i, boolean visited[], List<Integer> adj[]) {
    //     if(flag) return;
    //     for(int nbr: adj[i]) {
    //         if(flag) return;
    //         if(!visited[nbr]) {
    //             visited[nbr] = true;
    //             parent[nbr] = i;
    //             dfs(nbr, visited, adj);
    //         }
    //         else {
    //             if(parent[nbr] == i || parent[i] == nbr)
    //                 continue;
    //             flag = true;
    //             ans.append(nbr).append(' ').append(i).append(' ');
    //             while(i!=nbr) {
    //                 counter++;
    //                 i = parent[i];
    //                 ans.append(i).append(' ');
    //             }

    //         }
    //     }

    // }













    static int stringBufferLength = 1001;
    static Reader sc;
    static PrintWriter out;
    //static Scanner sc;
    //static BufferedReader br;

    public static void main(String args[]) throws IOException {


        //br =  new BufferedReader(new InputStreamReader(System.in));
        //sc = new Scanner(System.in);
        //sc = new Scanner(Paths.get("/Users/kshitiz/IdeaProjects/MyAlgorithms/src/io/AaaaaInput.txt"));

        out = new PrintWriter(System.out);


        sc = new Reader();
        solve();


        // long c = System.currentTimeMillis();
        // sc = new Reader("/Users/kshitiz/Complete folder/AaaaaInput.txt");
        // solve();
        // String s = "time--"+ (System.currentTimeMillis() - c);

        // try{
        //     Thread.sleep(1000);
        // }
        // catch(Exception e) {

        // }
        // out.println(s);



        //br.close();
        out.close();

    }

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
            byte[] buf = new byte[stringBufferLength]; // line length
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

    static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void print(int arr[]) {
        StringBuilder st = new StringBuilder();
        for(int i=0;i<arr.length;i++)
            st.append(arr[i]+ " ");
        out.println(st.toString());
    }


    // static int get(int i, int j) {
    //     int N = n+2, M = m+2;
    //     return i*M + j;
    // }

    // static int[] get(int X) {
    //     int ans[] = new int[2];
    //     ans[0] = X/M;
    //     ans[1] = X%M;
    // }

    static void print(int arr[][]) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                out.print(arr[i][j]+" :: ");
            }
            out.println();
        }
    }

}