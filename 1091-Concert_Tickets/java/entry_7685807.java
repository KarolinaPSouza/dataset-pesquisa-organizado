import javax.imageio.ImageTranscoder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class entry_7685807 {
    static Reader s = new Reader();
    public static void main(String[] args) throws IOException {
//        int tt=s.nextInt();
        int tt=1;
        while (tt-- > 0) {
            solution();
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

    static int binSearch(TreeMap<Integer, Integer> arr, int x) {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr.get(m) == x)
                return m;
            if (arr.get(m) > x)
                r = m - 1;
            else
                l = m + 1;
        }
        return r;
    }
    static void solution() throws IOException {
        int n = s.nextInt();
        int m = s.nextInt();
        TreeMap<Integer, Integer> arr = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int b = s.nextInt();
            if (arr.containsKey(b))
                arr.put(b, arr.get(b)+1);
            else
                arr.put(b, 1);
        }
        StringBuffer res = new StringBuffer();
//        System.out.println(arr);
        for (int i = 0; i < m; i++) {
            int b = s.nextInt();
            Map.Entry<Integer, Integer> found = arr.lowerEntry(b+1);
            if (found == null) {
                res.append("-1\n");
            } else {
                res.append(found.getKey()).append('\n');
                if (found.getValue() == 1)
                    arr.remove(found.getKey());
                else
                    arr.put(found.getKey(),found.getValue()-1);
            }
        }
        System.out.println(res);
    }
}