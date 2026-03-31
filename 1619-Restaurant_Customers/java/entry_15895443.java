import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;





public class entry_15895443 {
    // Custom Reader class for fast input
    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        // Reads the next integer from input
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        // Reads the next byte from the buffer
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        // Fills the buffer with new data
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
    }

    static class  Interval implements Comparable<Interval>{
        private final int l, r;
        public Interval(int l, int r) {
            this.l = l;this.r = r;
        }
        public int l() {return l;}
        public int r() {return r;}
        public int compareTo(final Interval obj){
            return obj.l ==l ? obj.r-r: l - obj.l;
        }
    }
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        PrintWriter out=new PrintWriter(System.out);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n =  in.nextInt();

       Interval [] arr = new  Interval[n];
       for(int i=0;i<n;i++){
           arr[i] = new Interval(in.nextInt(),in.nextInt());
       }
        Arrays.sort(arr);
       int ans=0;
       for (int i=0;i<n;i++){
           while (!pq.isEmpty() && pq.peek() < arr[i].l()){
               pq.poll();
           }

           pq.add(arr[i].r());
           ans = Math.max(ans,pq.size());
       }

        out.print(ans+"\n");

       out.flush();
    }
}