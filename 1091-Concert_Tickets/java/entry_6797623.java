import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class entry_6797623 {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        NavigableMap<Integer, Integer> multiset = new TreeMap<>();
        Map.Entry<Integer, Integer> val;
        int tickets = in.nextInt();
        int maxprice = in.nextInt();
        for(int i = 0; i<tickets; i++){
            int c = in.nextInt();
            if(multiset.containsKey(c)){
                multiset.put(c, multiset.get(c)+1);
            }
            else{
                multiset.put(c, 1);
            }
        }
        for(int i = 0; i<maxprice; i++){
            int k = in.nextInt();
            val = multiset.lowerEntry(k+1);
            if(val != null){
                out.println(val.getKey());
                if(val.getValue() == 1){
                    multiset.remove(val.getKey());
                }
                else{
                    multiset.put(val.getKey(), val.getValue()-1);
                }
            }
            else{
                out.println(-1);
            }
        }
        out.close();
        in.close();
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