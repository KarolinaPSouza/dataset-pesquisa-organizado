import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;

// TLE - Hence switching to C++
public class entry_6629677 {

    private static void knapsack01(int n, int bagSize, int[] weight, int[] value) throws IOException {
        // writer
        OutputStream ws = new BufferedOutputStream(System.out);

        // Initialize dp array
        int[][] dp = new int[n+1][bagSize+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= bagSize; j++) {
                // case: we dont pick jth item
                dp[i][j] = dp[i-1][j];
                // case: we pick jth item
                if (j >= weight[i-1]) {
                    // jth item weight should be smaller or equal to bagSize
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                }
            }
        }

        // print the result
        ws.write((dp[n][bagSize] + "").getBytes());
        ws.flush();

    }

    public static void main(String[] args) throws IOException {
        // Initializing Reader for taking inputs
        Reader read = new Reader();

        // no. of books
        int n = read.nextInt();

        // max bag amount
        int maxAmount = read.nextInt();

        // price of each book
        int[] booksPrices = new int[n];
        for (int i = 0; i < n; i++) {
            booksPrices[i] = read.nextInt();
        }

        // pages of each book
        int[] booksPages = new int[n];
        for (int i = 0; i < n; i++) {
            booksPages[i] = read.nextInt();
        }

        // solve
        knapsack01(n, maxAmount, booksPrices, booksPages);

        return;

    }

    public static class Reader {
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