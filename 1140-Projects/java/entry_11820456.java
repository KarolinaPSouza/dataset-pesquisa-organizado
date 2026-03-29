import java.util.*;
import java.io.*;

public class entry_11820456 {

    static void solve() throws IOException {
        int n = sc.nextInt();
        long x[][] = new long[n][3];
        for(int i=0;i<n;i++){
            x[i][0] = sc.nextLong();
            x[i][1] = sc.nextLong();
            x[i][2] = sc.nextLong();
        }   

        Arrays.sort(x, (a, b)-> {
            if(a[1] == b[1])
               return Long.compare(a[2], b[2]);
            return Long.compare(a[1], b[1]);
        });
        // out.println();
        // for(int i=0;i<n;i++)
        //     print(x[i]);
        // out.println();

        TreeMap<Long, Long> map = new TreeMap();

        long maxReward = Long.MIN_VALUE;
        for(int i=0;i<n;i++) {
            long st = x[i][0], end = x[i][1], reward = x[i][2];
            Long prev = map.lowerKey(st);
            if(prev == null) {
                Long lKey = map.floorKey(end);
                if(lKey == null)
                    map.put(end, reward);
                else
                    map.put(end, Math.max(map.get(lKey), reward));
                maxReward = Math.max(maxReward, reward);
            }
            else {
                long val = map.get(prev) + reward;
                Long lKey = map.floorKey(end);
                map.put(end, Math.max(map.get(lKey), val));
                maxReward = Math.max(maxReward, val);
            }
            //out.println(map);

        }

        out.println(maxReward);



    }














    static int stringBufferLength = 5000;
    static Reader sc;
    static PrintWriter out;
    //static Scanner sc;
    static BufferedReader br;

    public static void main(String args[]) throws IOException {


        out = new PrintWriter(System.out);
        br =  new BufferedReader(new InputStreamReader(System.in));

        sc = new Reader();
        //sc = new Reader("/Users/kshitiz/IdeaProjects/MyAlgorithms/src/io/AaaaaInput.txt");
        //sc = new Scanner(System.in);
        //sc = new Scanner(Paths.get("/Users/kshitiz/IdeaProjects/MyAlgorithms/src/io/AaaaaInput.txt"));

        solve();
        //System.out.println("time--"+ (System.currentTimeMillis() - c));
        br.close();
        out.close();

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
            byte[] buf = new byte[stringBufferLength]; // line length
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

    static void print(int arr[]) {
        //out.println(arr.length);
        for(int i=0;i<arr.length;i++)
            out.print(arr[i]+" ");
        out.println();
    }

    static void print(long arr[]) {
        for(int i=0;i<arr.length;i++)
            out.print(arr[i]+" ");
        out.println();
    }

    static void print(int arr[][]) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                out.print(arr[i][j]+" ");
            }
            out.println();
        }
    }




    // static int get(int i, int j) {
    //     int N = n+2, M = m+2;
    //     return i*M + j;
    // }

    // static int[] get(int X) {
    //     int ans[] = new int[2];
    //     ans[0] = X/M;
    //     ans[1] = X%M;
    // }

}