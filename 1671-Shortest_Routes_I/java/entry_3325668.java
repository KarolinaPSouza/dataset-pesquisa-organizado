import java.io.*;
import java.util.*;

public class entry_3325668 {
 static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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

 public static void f(int n,ArrayList<ArrayList<int []>> adj) {
  long dist[]=new long[n+1];

  for(int i=1;i<=n;i++) {
   dist[i]=Long.MAX_VALUE;
  }
  dist[1]=0;
  PriorityQueue <long []> pq=new PriorityQueue<>(new C());
  long org[]= {0,1};
  pq.add(org);

  boolean visited[]=new boolean[n+1];
  for(int i=1;i<=n;i++) {
   //System.out.println(i);
   int curr=findMin(visited,pq);
   visited[curr]=true;

   ArrayList<int []> neigh=adj.get(curr);

   for(int elem[]:neigh) {
    if(elem[1]+dist[curr]<dist[elem[0]]) {
     long temp[]= {elem[1]+dist[curr],elem[0]};
     pq.add(temp);
     dist[elem[0]]=elem[1]+dist[curr];
    }
   }
  }
  for(int i=1;i<=n;i++) {
   System.out.print(dist[i]+" ");
  }
  System.out.println();
 }
 public static int findMin(boolean visited[],PriorityQueue <long []> pq) {
  while(visited[(int)pq.peek()[1]]) {
   pq.poll();
  }
  return (int)pq.poll()[1];
 }

 public static void main(String[] args) throws Exception {
  // TODO Auto-generated method stub

  Reader s=new Reader();
  int n=s.nextInt();
  int m=s.nextInt();

  ArrayList<ArrayList<int[]>> adj=new ArrayList<>();

  for(int i=0;i<=n;i++) {
   adj.add(new ArrayList<int []>());
  }
  for(int i=0;i<m;i++) {
   int a=s.nextInt();
   int b=s.nextInt();

   int w=s.nextInt();

   int a1[]= {b,w};

   adj.get(a).add(a1);

  }
  f(n,adj);



 }

}
class C implements Comparator<long []>{
 public int compare(long a[],long b[]) {
  return (int)(a[0]-b[0]);
 }
}





