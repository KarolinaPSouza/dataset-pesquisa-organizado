import java.io.*;
import java.util.*;
public class entry_4405527 {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        //String[] read = in.readLine().trim().split("\\s");
        int n = in.nextInt();
        int m = in.nextInt();
        TreeMap<Integer, Integer> prices = new TreeMap<>();
        prices.put(-1, 1);
        for (int i = 0; i < n; i++) {
            int p = in.nextInt();//Integer.parseInt(in.readLine().trim());
            if (prices.containsKey(p)) {
                prices.replace(p, prices.get(p) + 1);
            } else {
                prices.put(p, 1);
            }
        }
        //StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int c = in.nextInt();//Integer.parseInt(in.readLine().trim());
            int p = prices.floorKey(c);
            if (p == -1) {
                out.write(-1 + "\n");
                //ans.append("-1\n");
            } else {
                //ans.append(p + "\n");
                out.write(p + "\n");
                update(prices, p);
            }
        }
        //out.write(ans.toString());
        out.close();
        //System.out.println(ans);
    }
    public static void update(TreeMap<Integer, Integer> prices, int p) {
        prices.replace(p, prices.get(p) - 1);
        if (prices.get(p) == 0) {
            prices.remove(p);
        }
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