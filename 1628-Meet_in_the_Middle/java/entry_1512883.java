import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
 
public class entry_1512883 {
    private static long[] tt;
 
    static long[] build(int[] aa, int l, int r) {
        long[] ss = new long[1 << r - l];
        for (int k = 1; l < r; l++, k <<= 1) {
            int a = aa[l];
            for (int h = 0; h < k; h++) {
                tt[h] = ss[h];
                tt[h + k] = ss[h] + a;
            }
            int p = 0, q = k, q_ = k + k, h = 0;
            while (p < k && q < q_)
                if (tt[p] < tt[q])
                    ss[h++] = tt[p++];
                else
                    ss[h++] = tt[q++];
            while (p < k)
                ss[h++] = tt[p++];
            while (q < q_)
                ss[h++] = tt[q++];
        }
        return ss;
    }
 
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
 
        int n = fr.nextInt();
        int x = fr.nextInt();
 
        int[] aa = new int[n];
        for (int i = 0; i < n; i++)
            aa[i] = fr.nextInt();
        int k0 = n / 2, k1 = n - k0, n0 = 1 << k0, n1 = 1 << k1;
        tt = new long[1 << k1];
        long[] a0 = build(aa, 0, k0);
        long[] a1 = build(aa, k0, n);
        long ans = 0;
        for (int i = 0, p = n1 - 1, q = p; i < n0; i++) {
            long y = 0;
            while (q >= 0 && (y = a0[i] + a1[q]) > x)
                q--;
            if (q < 0)
                break;
            if (y == x) {
                if (p > q)
                    p = q;
                while (p > 0 && a1[p - 1] == a1[q])
                    p--;
                ans += q - p + 1;
            }
        }
        fr.close();
 
        pw.println(ans);
        pw.close();
    }
 
    private static class FastReader {
        final private int BUFFER_SIZE = 1 << 24;
        private final DataInputStream dis;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public FastReader() {
            dis = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        private int nextInt() throws IOException {
            int ret = 0;
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
 
        private void fillBuffer() throws IOException {
            bytesRead = dis.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        private void close() throws IOException {
            dis.close();
        }
    }
}