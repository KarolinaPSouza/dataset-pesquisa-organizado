import java.io.*;
import java.util.TreeMap;

public class entry_4781295 {

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

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
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

        public int nextInt() throws IOException {
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
    }

    public static void main(String[] args) throws IOException {
        var r = new Reader();
        var out = new PrintWriter(System.out);
        int n = r.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            map.put(r.nextInt(), 1);
            map.put(r.nextInt(), - 1);
        }


        int ans = 0;
        int currCustomer = 0;
        for(int value : map.values()) {
            currCustomer += value;
            ans = Math.max(ans, currCustomer);
        }
        out.println(ans);
        out.close();
        r.close();
    }
}