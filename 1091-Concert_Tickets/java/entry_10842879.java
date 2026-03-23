import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

/**
 * Concert_Tickets
 */
public class entry_10842879 {

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

    public static int lower_bound(int[] arr, int x){
        int l =0 ;
        int r = arr.length;
        int mid = l + (r-l)/2;
        int idx = -1;
        while(l <= r){
            if(arr[mid] > x){
                r = mid - 1;
            }
            else if (arr[mid] <= x){
                idx = mid;
                l = mid + 1;
            }
            mid = l + (r-l)/2;
        }
        if(idx == -1){
            return -1;
        }

        return arr[idx];
    }

    public static void main(String[] args)
        throws IOException
    {
        Reader sc = new Reader();
        int test = 1;
        Map.Entry<Integer,Integer> b;
        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Integer t[] = new Integer[n];
            int c[] = new int[m];
            StringBuffer res = new StringBuffer();
            TreeMap<Integer,Integer> tmp = new TreeMap<>();

            for(int i = 0; i < n;i++){
              int a = sc.nextInt();
              tmp.put(a, tmp.getOrDefault(a,0 )+1);
            }
            // Arrays.sort(t);
            for(int i = 0; i < m; i++){
                int a = sc.nextInt();
                b=  tmp.floorEntry(a);
               if(b == null){
                    // System.out.println(-1);
                    res.append("-1\n");
               }else{
                //  System.out.println(b.getKey());
                int temp = b.getKey();
                res.append(temp).append("\n");
                //  tmp.put(temp, tmp.getOrDefault(temp,0 )-1);

                 if(tmp.get(temp) == 1){
                    tmp.remove(temp);
                 }else{
                    tmp.put(temp,b.getValue()-1);
                 }
               }
            }
            System.out.println(res);

        }
    }
}