import java.io.*;
import java.util.*;

public class entry_12712797 {
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

    public static void main(String[] args) throws IOException {



        Reader bf = new Reader();

        int n=bf.nextInt();
        int m=bf.nextInt();


        int preu;
        int nElements;




        TreeMap<Integer, Integer> tickets = new TreeMap<>();
        for(int i=0; i<n; i++){
            preu = bf.nextInt();
            nElements = tickets.getOrDefault(preu, 0);
            tickets.put(preu, nElements + 1);
        }



        StringBuilder sortida = new StringBuilder();

        Map.Entry<Integer, Integer> millorPreu;
        for(int i=0; i<m; i++){
          millorPreu = tickets.floorEntry(bf.nextInt());
          if (millorPreu == null){
              sortida.append("-1\n");
              //System.out.println(-1);
          } else {
              int clau = millorPreu.getKey();
              int valor = millorPreu.getValue();
              sortida.append(clau).append("\n");
              //System.out.println(clau);
              if (valor==1){
                  tickets.remove(clau);
              } else {
                  tickets.replace(clau, valor -1);
              }
          }

        }


        System.out.println(sortida);

    }
}