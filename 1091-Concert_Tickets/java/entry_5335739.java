import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class entry_5335739 {
    static TreeMap<Integer, Integer> tickets = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        Reader io = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        int ticketNum = io.nextInt();
        int customers = io.nextInt();


        for (int i = 0; i < ticketNum; i++) {
            add(io.nextInt());
        }
        add(-1);

        for (int i = 0; i < customers; i++) {
            int maxPrice = io.nextInt();
            int payment = tickets.lowerKey(maxPrice + 1);
            if (payment != -1) {
                remove(payment);
            }
            out.println(payment);
        }
        out.close();
    }
    static void add(int x){
        if (tickets.containsKey(x)) {
            tickets.put(x, tickets.get(x) + 1);
        }
        else {
            tickets.put(x, 1);
        }
    }

    static void remove(int x){
        if (tickets.get(x) == 1) {
            tickets.remove(x);
        }
        else {
            tickets.put(x, tickets.get(x) - 1);
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
}