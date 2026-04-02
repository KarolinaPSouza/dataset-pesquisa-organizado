import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

class DataCP  implements Comparator<DataCP>
{
 long value;
 int index;

 DataCP()
 {}

 DataCP(long value, int index)
 {
  this.value = value;
  this.index = index;
 }

 @Override
 public int compare(DataCP o1, DataCP o2) {
  // TODO Auto-generated method stub
  return Long.compare(o1.value, o2.value);
 }

 public String toString()
    {
        return this.value + " " + this.index;
    }
}
public class entry_1318768 {

 /**
  * @param args
  */
 /**
  * @param args
  */


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

 public static void main(String args[]) throws IOException
 {
  Reader sc=new Reader();

  //Reader sc=new Reader("C:\\Users\\shsingha\\Documents\\workspace-spring-tool-suite-4-4.4.0.RELEASErestart_New\\testemail\\src\\test_input (3).txt");

  PrintWriter out = new PrintWriter(System.out); 

  int n = sc.nextInt();
  long x = sc.nextLong();
  ArrayList<DataCP> input = new ArrayList<>();

  for(int i=0;i<n;i++)
  {
   DataCP in = new DataCP(sc.nextLong(), i);
   input.add(in);
  }

  Collections.sort(input, new DataCP());

  int i=0;
  int j=n-1;
  while(i<j)
  {
   if(input.get(i).value+input.get(j).value == x)
   {
    break;
   }
   else if(input.get(i).value+input.get(j).value < x)
    i++;
   else
    j--;
  }

  if(i<j)
  {
   out.print(input.get(i).index+1);
   out.print(" ");
   out.println(input.get(j).index+1);
  }

  else
  {
   out.println("IMPOSSIBLE");
  }

  out.flush();



 }


}