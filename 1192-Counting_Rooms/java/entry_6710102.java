//package com.company;

import java.util.*;
import java.io.*;
public class entry_6710102 {
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
    static class Readerr {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                        reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble( next() );
        }
    }
    static class Pair{
        int a;
        int b;
        public Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public static void dfs(char [][]a,int i,int j,int[][]vis){
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(i,j));
        vis[i][j]=1;
        while (!q.isEmpty()){
            int r=q.peek().a;
            int c=q.peek().b;
            q.poll();
            int []rr={1,-1,0,0};
            int []cc={0,0,-1,1};
            for (int k = 0; k < 4; k++) {
                int rrr=r+rr[k];
                int ccc=c+cc[k];
                if (rrr<a.length && ccc<a[0].length && rrr>=0 &&
                        ccc>=0 && vis[rrr][ccc]==0 && a[rrr][ccc]=='.' ){
                    vis[rrr][ccc]=1;
                    q.add(new Pair(rrr,ccc));
                }
            }
        }
    }
    public static void main(String[] args)throws IOException {
        Readerr sc = new Readerr();
        PrintWriter out=new PrintWriter(System.out);
        Readerr.init( System.in );
        int n= sc.nextInt();
        int m= sc.nextInt();
        char [][]a=new char[n][m];
        for (int i = 0; i < n; i++) {
           String q= sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j]=q.charAt(j);
            }
        }
        int ans=0;
        int [][]vis=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]==0 && a[i][j]=='.'){
                    ans++;
                    dfs(a,i,j,vis);
                }
            }
        }
        out.println(ans);
        out.flush();
    }
}