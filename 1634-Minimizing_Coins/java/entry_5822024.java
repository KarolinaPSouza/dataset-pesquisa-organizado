import java.io.*;
import java.util.*;

public class entry_5822024 {
    //static Scanner in = new Scanner(System.in);
   // static Reader in;

    /*static {
        try {
            in = new Reader("test.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    static FastScanner in = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {


        int t = 1;
        //int t = in.nextInt();
        while(t-- != 0)
            solve();

        out.close();
    }

    public static void solve() throws Exception {

        int n = in.nextInt(), x = in.nextInt();
        int[]a = in.readArray(n);
        int[]ans = new int[x+1];
        for(int i = 0; i<=x; i++)ans[i] = 1_000_000_000;
        ans[0] = 0;
        for(int i = 1; i<=x; i++){
            for(int j : a){
                if(i-j >= 0) ans[i] = Math.min(ans[i],ans[i-j]+1);
            }
        }
        out.println(ans[x] == 1_000_000_000 ? -1 : ans[x]);
    }
    public static int log2(int n){
        // FLOOR MINUS 31, CEIL MINUS 32
        return 32-Integer.numberOfLeadingZeros(n);
    }









    public static long gcd(long a, long b){
        return b == 0? a : gcd(b,a % b);
    }
    static class Pair implements Comparable<Pair> {
        int val;
        int ind;
        Pair(int a, int b){
            val = a;
            ind = b;
        }


        @Override
        public int compareTo(Pair o) {return Integer.compare(ind-val,o.ind-o.val);
        }
    }
    static class FastScanner {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
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
}