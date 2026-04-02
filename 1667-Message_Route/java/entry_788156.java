import java.io.*;
import java.util.*;
class vec
{
 int i;
 int l;
 vec(int i,int l)
 {
  this.i=i;
  this.l=l;
 }
}
class InputReader { 

 private InputStream stream; 
 private byte[] buf = new byte[1024]; 
 private int curChar; 
 private int numChars; 
 private SpaceCharFilter filter; 

 public InputReader(InputStream stream) { 
  this.stream = stream; 
 } 

 public int read() { 
  if (numChars == -1) 
   throw new InputMismatchException(); 
  if (curChar >= numChars) { 
   curChar = 0; 
   try { 
    numChars = stream.read(buf); 
   } catch (IOException e) { 
    throw new InputMismatchException(); 
   } 
   if (numChars <= 0) 
    return -1; 
  } 
  return buf[curChar++]; 
 } 

 public int readInt() { 
  int c = read(); 
  while (isSpaceChar(c)) 
   c = read(); 
  int sgn = 1; 
  if (c == '-') { 
   sgn = -1; 
   c = read(); 
  } 
  int res = 0; 
  do { 
   if (c < '0' || c > '9') 
    throw new InputMismatchException(); 
   res *= 10; 
   res += c - '0'; 
   c = read(); 
  } while (!isSpaceChar(c)); 
  return res * sgn; 
 } 

 public String readString() { 
  int c = read(); 
  while (isSpaceChar(c)) 
   c = read(); 
  StringBuilder res = new StringBuilder(); 
  do { 
   res.appendCodePoint(c); 
   c = read(); 
  } while (!isSpaceChar(c)); 
  return res.toString(); 
 } 

 public boolean isSpaceChar(int c) { 
  if (filter != null) 
   return filter.isSpaceChar(c); 
  return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; 
 } 

 public String next() { 
  return readString(); 
 } 

 public interface SpaceCharFilter { 
  public boolean isSpaceChar(int ch); 
 } 
} 

class OutputWriter { 
 private final PrintWriter writer; 

 public OutputWriter(OutputStream outputStream) { 
  writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream))); 
 } 

 public OutputWriter(Writer writer) { 
  this.writer = new PrintWriter(writer); 
 } 

 public void print(Object...objects) { 
  for (int i = 0; i < objects.length; i++) { 
   if (i != 0) 
    writer.print(' '); 
   writer.print(objects[i]); 
  } 
 } 

 public void printLine(Object...objects) { 
  print(objects); 
  writer.println(); 
 } 

 public void close() { 
  writer.close(); 
 } 

 public void flush() { 
  writer.flush(); 
 } 

 } 

class IOUtils { 

 public static int[] readIntArray(InputReader in, int size) { 
  int[] array = new int[size]; 
  for (int i = 0; i < size; i++) 
   array[i] = in.readInt(); 
  return array; 
 } 

 } 
public class entry_788156 {
 public static void BFS(HashMap<Integer,HashSet<Integer>> g,int n,int[] prev) throws Exception
 {
  HashSet<Integer> visited=new HashSet<Integer>();
  Queue<vec> qu=new LinkedList<vec>();
  PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  qu.add(new vec(1,1));
  visited.add(1);
  prev[1]=0;
  int flag=0;
  int count=0;
  while(!qu.isEmpty())
  {
   vec u=qu.poll();
   if(u.i==n)
   {
    flag=1;
    count=u.l;
    break;
   }
   for(int v:g.get(u.i))
   {
    if(!visited.contains(v))
    {
     visited.add(v);
     qu.add(new vec(v,u.l+1));
     prev[v]=u.i;
    }
   }
  }
  if(flag==0)
  {
   out.append("IMPOSSIBLE");
//   out.newLine();
   out.flush();
   out.close();
  }
  else
  {
   ArrayList<Integer> path=new ArrayList<Integer>();
   //out.append(count+"");
   out.write(count+"\n");
//   out.newLine();
   StringBuffer bf=new StringBuffer();
   Stack<Integer> st=new Stack<Integer>();
   int i=n;
   st.push(i);
   while(i!=1)
   {
    i=prev[i];
    st.push(i);
   }
   //Collections.reverse(path);
   while(!st.isEmpty())
   {
    out.append(st.pop()+" ");
   }
//   out.newLine();
   out.flush();
   out.close();
   //System.out.println(bf.toString());
  }
 }
 public static void main(String[] args) throws Exception
 {
//  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  InputReader in=new InputReader(System.in);
  //String[] nm=br.readLine().trim().split(" ");
  //int n=Integer.parseInt(nm[0]);
  //int m=Integer.parseInt(nm[1]);
  int n=in.readInt();
  int m=in.readInt();
  String[] str;
  HashMap<Integer,HashSet<Integer>> g=new HashMap<Integer,HashSet<Integer>>();
  int[] prev=new int[n+1];
  for(int i=1;i<=n;i++)
  {
   g.put(i,new HashSet<Integer>());
   prev[i]=i;
  }
  for(int i=0;i<m;i++)
  {
   //str=br.readLine().trim().split(" ");
   int u=in.readInt();
   int v=in.readInt();
   g.get(u).add(v);
   g.get(v).add(u);
  }
  BFS(g,n,prev);
 }
}