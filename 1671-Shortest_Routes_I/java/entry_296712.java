import  java.util.*;
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 

public class entry_296712 {
 static class pair{
  long fi;
  int se;
  public pair(long fi, int se){
   this.fi = fi;
   this.se = se;
  }
  public pair(pair old){
   this.fi = old.fi;
   this.se = old.se;
  }
 }

 static class PriorityQueue{
  pair[] data = new pair[200005];
  int sz = 0;

  private void swap(int i, int j){
   pair temp = new pair(data[i]);
   data[i] = new pair(data[j]);
   data[j] = temp;
  }

  private void shiftUp(int pos){
   int curr = pos;
   while(curr != 0){
    if(data[(curr - 1) / 2].fi > data[curr].fi){
     swap((curr - 1) / 2, curr);
     curr = (curr - 1) / 2;
    }
    else break;
   }
  }

  private void shiftDown(){
   int curr = 0;
   while(true){
    int nxt = curr;
    if(2 * curr + 1 < sz && data[2 * curr + 1].fi < data[curr].fi) nxt = 2 * curr + 1;
    if(2 * curr + 2 < sz && data[2 * curr + 2].fi < data[nxt].fi) nxt = 2 * curr + 2;
    if(nxt == curr) break;
    swap(curr, nxt);
    curr = nxt;
   }
  }

  public void add(pair el){
   data[sz++] = el;
   shiftUp(sz - 1);
  }

  public void rm(){
   data[0] = data[--sz];
   shiftDown();
  }

  public pair top(){
   return data[0];
  }

  public boolean empty(){
   return sz == 0;
  }
 }


 static ArrayList<pair>[] graph = new ArrayList[100005];

 public static void main(String[] args) throws IOException{
  Reader r = new Reader();
  int n = r.nextInt(), m = r.nextInt(), a, b, c;
  long dist[] = new long[n + 1];
  for(int i = 1; i <= n; i++){
   graph[i] = new ArrayList<pair>();
   dist[i] = Long.MAX_VALUE;
  }
  int last[] = new int[n + 1];
  for(int i = 0; i < m; i++){
   a = r.nextInt(); b = r.nextInt(); c = r.nextInt();
   graph[a].add(new pair(b, c));
  }

  PriorityQueue pq = new PriorityQueue();
  pq.add(new pair(0, 1));
  dist[1] = 0;
  while(!pq.empty()){
   pair v = pq.top();
   pq.rm();

   if(v.fi != dist[v.se]) continue;

   for(pair u : graph[v.se])
    if(dist[(int) u.fi] > dist[v.se] + u.se){
     dist[(int) u.fi] = dist[v.se] + u.se;
     pq.add(new pair(dist[(int) u.fi], (int) u.fi));
     last[(int) u.fi] = v.se;
    }  
  }

  for(int i = 1; i <= n; i++) System.out.print(dist[i] + " ");
  System.out.println();


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

        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
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
            } 
            while ((c = read()) >= '0' && c <= '9'); 
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
            } 
            while ((c = read()) >= '0' && c <= '9'); 

            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 

            if (neg) 
                return -ret; 
            return ret; 
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
    } 
}