import java.io.*;
import java.util.*;
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 


public class entry_3546665 {



 static int ans=0;
 public static void main(String[] args) throws NumberFormatException, IOException 
 {
  Reader s=new Reader();
  BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
  int n=s.nextInt();
  if(n==1)
  {
   System.out.println("0");
   return;
  }
     ArrayList<Integer> tree[]=new ArrayList[n+1];
     for(int i=1;i<=n;i++) tree[i]=new ArrayList<>();
     for(int i=2;i<=n;i++)
     {
      int f=s.nextInt();
      int t=s.nextInt();
      tree[f].add(t);
      tree[t].add(f);
     }
     int ar[]=new int[n+1];
     int g1=-1;
     Queue<node> que=new LinkedList<>();
     que.add(new node(1,0));
     while(que.size()!=0)
     {
      node temp=que.poll();
      int curr=temp.x;
      int par=temp.par;
      g1=curr;
      for(int i:tree[curr]) if(i!=par) que.add(new node(i,curr));
     }
     int g2=-1;
     que.add(new node(g1,0));
     int dis=1;
     int finalar[]=new int[n+1];
     while(que.size()!=0)
     {
      int size=que.size();
      for(int i=0;i<size;i++)
      {
       node temp=que.poll();
       int curr=g2=temp.x;
       int par=temp.par;
       for(int child:tree[curr]) if(child!=par)
       {
        finalar[child]=dis;
        que.add(new node(child,curr));
       }
      }
      dis++;
     }
     que.add(new node(g2,0));
     dis=1;
     //int finalar[]=new int[n+1];
     while(que.size()!=0)
     {
      int size=que.size();
      for(int i=0;i<size;i++)
      {
       node temp=que.poll();
       int curr=temp.x;
       int par=temp.par;
       for(int child:tree[curr]) if(child!=par)
       {
        finalar[child]=Math.max(finalar[child], dis);
        que.add(new node(child,curr));
       }
      }
      dis++;
     }
     for(int i=1;i<=n;i++) bw.write(finalar[i]+" ");
     bw.flush();

 }




}
class node{
 int x;
 int par;
 node(int i,int j)
 {
  x=i;
  par=j;
 }
}

class Reader { 
    final private int BUFFER_SIZE = 1 << 16; 
    private DataInputStream din; 
    private byte[] buffer; 
    private int bufferPointer, bytesRead; 

    public Reader() { 
        din = new DataInputStream(System.in); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0; 
    } 

    public Reader(String file_name) throws IOException{ 
        din = new DataInputStream(new FileInputStream(file_name)); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0; 
    } 

    public String readLine() throws IOException{ 
        byte[] buf = new byte[64]; // line length 
        int cnt = 0, c; 
        while ((c = read()) != -1) { 
            if (c == '\n') 
                break; 
            buf[cnt++] = (byte) c; 
        } 
        return new String(buf, 0, cnt); 
    } 

    public int nextInt() throws IOException { 
        int ret = 0; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) c = read(); 
        do{ 
            ret = ret * 10 + c - '0'; 
        }  while ((c = read()) >= '0' && c <= '9'); 

        if (neg) return -ret; 
        return ret; 
    } 

    public long nextLong() throws IOException  { 
        long ret = 0; 
        byte c = read(); 
        while (c <= ' ') c = read(); 
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

    public double nextDouble() throws IOException { 
        double ret = 0, div = 1; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) c = read(); 

        do { 
            ret = ret * 10 + c - '0'; 
        } 
        while ((c = read()) >= '0' && c <= '9'); 
        if (c == '.') { 
            while ((c = read()) >= '0' && c <= '9') { 
                ret += (c - '0') / (div *= 10); 
            } 
        } 

        if (neg) return -ret; 
        return ret; 
    } 

    private void fillBuffer() throws IOException{ 
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
        if (bytesRead == -1) 
            buffer[0] = -1; 
    } 

    private byte read() throws IOException  { 
        if (bufferPointer == bytesRead) 
            fillBuffer(); 
        return buffer[bufferPointer++]; 
    } 

    public void close() throws IOException { 
        if (din == null) 
            return; 
        din.close(); 
    } 
} 
