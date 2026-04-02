import java.lang.*;
import java.io.*;
import java.util.*;
public class entry_996151 {
    static int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        Reader br = new Reader();
        int n = br.nextInt(), x = br.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; ++i) coins[i] = br.nextInt();
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 1; i <= x; ++i) {
            long sum = dp[i];
            for (int c : coins) {
                if (i >= c && 0 != dp[i - c]) sum += dp[i - c];
            }
            dp[i] = (int) (sum % mod);
        }
        System.out.println(dp[x]);
    }
    static class Reader
    {
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
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
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
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
    }
}