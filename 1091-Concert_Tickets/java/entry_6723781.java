import java.io.*;
import java.util.*;

public class entry_6723781 {
 public static void main(String[] args) throws IOException {
  Reader io = new Reader();
  PrintWriter pw = new PrintWriter(System.out);

  int ticketNum = io.nextLong();
  int peopleNum = io.nextLong();
  TreeMap<Long,Long> tm=new TreeMap<>();
        for(int i=0;i<ticketNum;i++){
            long ele=io.nextLong();
            if(tm.containsKey(ele))tm.put(ele,tm.get(ele)+1);
            else tm.put(ele,(long)1);
        }
  for(int i=0;i<peopleNum;i++){
            long demand=io.nextLong();
            if(tm.floorKey(demand)!=null){
                 long x=tm.floorKey(demand);
                 pw.println(x);
                 if(tm.get(x)!=1){
                    tm.put(x,tm.get(x)-1);
                 }else
                  tm.remove(x);

            }else{
                pw.println(-1);
            }
           }
  io.close();
  pw.close();
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
  public int nextLong() throws IOException {
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
 // EndCodeSnip{}
}