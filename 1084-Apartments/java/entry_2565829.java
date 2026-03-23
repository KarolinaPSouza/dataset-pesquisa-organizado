import java.io.*;
import java.util.*;

public class entry_2565829 {
  static class Reader 
  {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            if (System.getProperty("ONLINE_JUDGE") == null) 
            {
            try 
            {
                System.setOut(new PrintStream(new FileOutputStream("output.txt")));
                din = new DataInputStream(new FileInputStream("input.txt"));
            }
              catch (Exception e) {
            }
        }
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


    public static void main(String[] args) throws IOException
    {
     Reader read = new Reader();
        int applicants = read.nextInt();
        int apartments = read.nextInt();
        long k = read.nextLong();

        //long required[] = new long[applicants];
        PriorityQueue<Long> size = new PriorityQueue<>();
        PriorityQueue<Long> required = new PriorityQueue<>();

        for(int i = 0; i<applicants; i++)
         required.add(read.nextLong());
        for(int i= 0; i<apartments; i++)
         size.add(read.nextLong());

        //Arrays.sort(required);
        //Arrays.sort(size);

        int satisfied = 0;
        while(required.size() > 0 && size.size() > 0)
        {
         long diff = size.peek() - required.peek();
         if(diff >= -k && diff <= k)
         {
          size.poll();
          required.poll();
          satisfied++;
          continue;
         }
         if(diff>k)
         {
          required.poll();
         }
         else
          size.poll();
        }

        System.out.println(satisfied);
    }

}