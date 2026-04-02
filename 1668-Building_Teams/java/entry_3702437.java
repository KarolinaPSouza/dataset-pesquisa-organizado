import java.util.*;
import java.io.*;
import java.text.*;
public class entry_3702437
{
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



 public static void main(String[] args) throws Exception {
  Reader sc=new Reader();
  PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));

  int t=1;
  int hh=0;

  while(hh++<t)
  {
   int n,m;
   n=sc.nextInt();
   m=sc.nextInt();

   ArrayList<ArrayList<Integer>> adl=new ArrayList<>();

   int i;
   for(i=0; i<=n; i++)
    adl.add(new ArrayList<>());

   for(i=0; i<m; i++)
   {
    int u,v;
    u=sc.nextInt();
    v=sc.nextInt();

    adl.get(u).add(v);
    adl.get(v).add(u);

   }

   ArrayList<HashSet<Integer>> set=new ArrayList<>();

   set.add(new HashSet<>()); //0
   set.add(new HashSet<>()); //1

   Stack<Integer> st=new Stack<>();

   boolean marked[]=new boolean[n+1];

   boolean flag=true;

   xx:for(i=1; i<=n; i++)
   {
    if(marked[i])
     continue;
    st.add(i);
    set.get(0).add(i);
    while(!st.isEmpty())
    {
     int val=st.pop();
     marked[val]=true;

     for(int x:adl.get(val))
     {
      if(marked[x])
       continue;
      int ind = findSet(set, val);

      if(!set.get(ind).contains(x))
      {
       set.get(ind^1).add(x);
       st.add(x);
      }
      else
      {
       flag=false;
       break xx;
      }

     }
    }
   }

   if(!flag)
   {
    out.println("IMPOSSIBLE");
   }
   else
   {
    for(i=1; i<=n; i++)
    {
     out.print(findSet(set,i)+1+" ");
    }
   }


  }
  out.flush();
 }

  public static int findSet(ArrayList<HashSet<Integer>> set, int v)
  {
   if(set.get(0).contains(v))
    return 0;
   return 1;
  }

}
