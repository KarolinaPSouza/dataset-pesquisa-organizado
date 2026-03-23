import java.util.*;
import java.io.*;
public class entry_9429911 {
// For fast input output
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
// end of fast i/o code
    public static void main(String[] args)throws IOException {
        Reader sc = new Reader();
        int n=sc.nextInt();
        int m=sc.nextInt();
        TreeMap<Integer,Integer> price=new TreeMap<>();
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            if(price.containsKey(x)){
                price.put(x,price.get(x)+1);
            }else price.put(x,1);
        }

        Map.Entry<Integer,Integer>  entry;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<m;i++){
            Integer temp=sc.nextInt();
            entry=price.lowerEntry(temp+1);
            if(entry==null)sb.append("-1\n");
            else{
                sb.append(entry.getKey()).append("\n");
                if(entry.getValue()==1){
                    price.remove(entry.getKey());
                }else price.put(entry.getKey(),entry.getValue()-1);
            }

        }
        System.out.println(sb);
    }
}