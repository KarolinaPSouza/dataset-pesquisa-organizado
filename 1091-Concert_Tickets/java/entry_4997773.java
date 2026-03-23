import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class entry_4997773 {

    public static void main(String[] args) throws IOException {
        Reader fs = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        int m = fs.nextInt();

        TreeMap<Integer, Integer> tx = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int f = fs.nextInt();
            tx.put(f, tx.getOrDefault(f, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            int next = fs.nextInt();
            Map.Entry<Integer, Integer> entry = tx.floorEntry(next);
            if (entry != null) {
                if (entry.getValue() == 1) {
                    tx.remove(entry.getKey());
                } else {
                    tx.put(entry.getKey(), entry.getValue() - 1);
                }
                out.println(entry.getKey());
            } else {
                out.println(-1);
            }
        }
        out.close();
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