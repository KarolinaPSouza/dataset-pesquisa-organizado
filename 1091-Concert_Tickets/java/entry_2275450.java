import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class entry_2275450 {

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
    public static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.value == o.value) {
                return o.index - this.index;
            } else {
                return this.value - o.value;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        Reader br = new Reader();

        int numOfTickets = br.nextInt();
        int numOfCustomer = br.nextInt();
        TreeSet<Pair> ticketPrices = new TreeSet<>();
        for (int i = 0; i < numOfTickets; i++) {
            ticketPrices.add(new Pair(br.nextInt(), i));
        }

        List<Integer> maxPriceToPay = new ArrayList<>();
        for (int i = 0; i < numOfCustomer; i++) {
            maxPriceToPay.add(br.nextInt());
        }

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < maxPriceToPay.size(); i++) {
            Pair pair = ticketPrices.floor(new Pair(maxPriceToPay.get(i), 0));
            if (pair != null) {
                res.append(pair.value).append("\n");
                ticketPrices.remove(pair);
            } else {
                res.append("-1").append("\n");
            }

        }
        System.out.println(res);
    }


}