import java.io.*;
import java.util.*;

public class entry_6557049 {
 public static void main(String[] args) throws IOException {
  //had to use fast reader from usaco guide
  Reader io = new Reader();

  //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);
  //BufferedReader br = new BufferedReader(new FileReader(".in"));
  //PrintWriter pw = new PrintWriter(new FileWriter(".out"));

  int n = io.nextInt();
  int m = io.nextInt();

  TreeMap<Integer, Integer> tickets = new TreeMap<Integer, Integer>();

  for(int i=0; i<n; i++){
   int num = io.nextInt();

   if(!tickets.containsKey(num)) tickets.put(num, 0);
   tickets.put(num, tickets.get(num) + 1);
  }

  Map.Entry<Integer, Integer> val;

  for(int i=0; i<m; i++){
   int num = io.nextInt() + 1;
   val = tickets.lowerEntry(num);

   if(val != null){
    pw.println(val.getKey());

    if(val.getValue() == 1) {
     tickets.remove(val.getKey());
    }else{
     tickets.put(val.getKey(), val.getValue() - 1);
    }
   }else{
    pw.println(-1);
   }
  }

  pw.close();
 }

 //copied and pasted from usaco guide

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



