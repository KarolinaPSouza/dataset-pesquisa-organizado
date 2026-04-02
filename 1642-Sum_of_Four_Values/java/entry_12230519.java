import java.io.*;
import java.util.*;

public class entry_12230519 {
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


    public static void main(String[] args) throws IOException {
     Reader fs = new Reader();
     int n=fs.nextInt();
  long t= fs.nextInt();

  long[] arr=new long[n];

  for(int i=0;i<n;i++) arr[i]=fs.nextInt();

  Map<Long , List<int[]>> map=new HashMap<>();



  for( int i=0;i<n;i++ ) {
   for(int j=i+1;j<n;j++) {
    long sum = arr[i]+arr[j];

    //  req = t - sum
    // for {0 - n} left - 

    for( int x[] : map.getOrDefault(t-sum, new ArrayList<>()) ) {
     if( x[0] != i && x[0] != j && x[1] != j && x[1] != i ) {
      System.out.println(  (1+x[0]) +" "+(1+x[1]) + " " + (i+1)+" " +(j+1) );
      return ;
     }
    }

    if( !map.containsKey(sum) ) {
     map.put(sum, new ArrayList<>() );
    }

    map.get(sum).add(new int[] { i , j });

   }
  }




  System.out.println("IMPOSSIBLE");






    }
}

class Pair {
    int f;
    int s;
    int i;


    @Override
 public String toString() {
  return "Pair [f=" + f + ", s=" + s + ", i=" + i + "]";
 }



    Pair(int f, int s, int i) {
        this.f = f;
        this.s = s;
        this.i = i;
    }


}