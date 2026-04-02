import java.io.*;
import java.util.*;

public class entry_6156486 {
    static PrintWriter ot = new PrintWriter(System.out);;
    static Reader br = new Reader();
    public static int[] take_arr(int n) throws IOException{
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = br.nextInt();

        return a;
    }
    public static List<Integer> take_list(int n) throws IOException{
        List<Integer> a = new ArrayList<>();

        for(int i = 0; i < n; i++)
            a.add(br.nextInt());

        return a;
    }
    public static void main (String[] args) throws IOException {

        int t = 1;
        pre();
        while(t-- > 0){
           solve();
        }
        ot.close();
    }
    static void solve() throws IOException{ 
        char s[] = br.readLine().trim().toCharArray();
        char t[] = br.readLine().trim().toCharArray();
        int n = s.length, m = t.length;
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++)
            dp[i][0] = i;
        for(int j = 1; j <= m; j++)
            dp[0][j] = j;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s[i - 1] == t[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i -1][j - 1]));
            }
        }
        ot.println(dp[n][m]);
    }

    static void solve(int n) throws IOException{

    }

    static void solve(int n, int m) throws IOException{

    }
    static long mod = (long)(1e9 + 7);
    static void pre() throws IOException {

    }  
}
class Reader {
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
            byte[] buf = new byte[5001]; // line length
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