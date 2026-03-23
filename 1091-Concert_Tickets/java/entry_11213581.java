import java.util.*;
import java.io.*;

public class entry_11213581 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException{
                int inputs = 1;
                for(int i=0 ; i<inputs ; i++){
                           solve();
                }
    }
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
    public static void solve()throws IOException{

       Reader br = new Reader();

       int n = br.nextInt(), m = br.nextInt();

       TreeMap<Integer,Integer> price = new TreeMap<>();
       StringBuilder sb = new StringBuilder();
       for(int i=0; i<n ; i++){
            int val = br.nextInt();
            if(!price.containsKey(val))
                price.put(val,1);
            else
                price.put(val, price.get(val)+1);
       }

       for(int i=0; i<m ; i++){
            int bet = br.nextInt();
            Map.Entry<Integer,Integer> l = price.lowerEntry(bet+1);

            if(l==null)
                sb.append("-1\n");
            else{
                sb.append(l.getKey()+"\n");
                if(l.getValue()==1){
                    price.remove(l.getKey());
                }
                else
                    price.put(l.getKey(), l.getValue()-1);
            }
       }
       System.out.println(sb);
}
}