import java.io.*;
import java.util.*;
public class entry_9243027 {
    public static void main(String[] args) throws IOException{
        Reader io = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = io.nextInt();
        int[][] times = new int[n][2];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            times[i][0] = io.nextInt();
            times[i][1] = io.nextInt();
        }
        Arrays.sort(times, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] time: times){
            while(pq.peek() != null && pq.peek()[1] <= time[0]){
                pq.poll();
            }
            pq.add(time);
            max = Math.max(max, pq.size());
        }
        pw.println(max);
        pw.close();
        io.close();
    }
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

            if (bytesRead == -1) buffer[0] = -1;

        }


        private byte read() throws IOException {

            if (bufferPointer == bytesRead) fillBuffer();

            return buffer[bufferPointer++];

        }


        public void close() throws IOException {

            if (din == null) return;

            din.close();

        }

        public int nextInt() throws IOException {

            int ret = 0;

            byte c = read();

            while (c <= ' ') c = read();

            boolean neg = (c == '-');

            if (neg) c = read();

            do {

                ret = ret * 10 + c - '0';

            } while ((c = read()) >= '0' && c <= '9');


            if (neg) return -ret;

            return ret;

        }

    }
}