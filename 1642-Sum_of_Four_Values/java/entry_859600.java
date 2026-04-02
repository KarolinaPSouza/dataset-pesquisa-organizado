import java.util.*;
import java.io.*;
import java.math.*;
public class entry_859600 {
 static boolean check(int entry_859600,int b,int c,int d){
  Set<Integer> set=new HashSet<>();
  set.add(entry_859600);set.add(b);
  set.add(c);set.add(d);
  return set.size()==4;
 }

 public static void main( String [] args) throws IOException{
  FastScanner sc=new FastScanner();
  int n=sc.nextInt();
  long x=sc.nextInt();
  long [] entry_859600=sc.nextLongArray(n);

  Map<Long,List<long[]>> map=new HashMap<>();

  for(int i=0;i<n;i++)for(int j=i+1;j<n;j++){
   long sum=entry_859600[i]+entry_859600[j];
   if(map.get(sum)==null)map.put(sum,new ArrayList<>());
      map.get(sum).add(new long []{i+1,j+1});
  }

  boolean found=false;

  for(int i=0;i<n && !found;i++){

   for(int j=i+1;j<n && !found;j++){

    long sum=entry_859600[i]+entry_859600[j];

    if(map.containsKey(x-sum)){

     for(long [] y : map.get(x-sum)){

      if(check(i+1,j+1,(int)y[0],(int)y[1])){

       found=true;
       int [] b={i+1,j+1,(int)y[0],(int)y[1]};
       Arrays.sort(b);
       System.out.println(b[0]+" "+b[1]+" "+b[2]+" "+b[3]);
       break;
      }
     }
    }
   }
  }

  if(!found)System.out.println("IMPOSSIBLE");


 } 

  }































































































class FastScanner{ 
  private int BUFFER_SIZE = 1 << 16;

 private  DataInputStream din;

 private  byte[] buffer;

 private int bufferPointer, bytesRead;

 public FastScanner() {
  din = new DataInputStream(System.in);
  buffer = new byte[BUFFER_SIZE];
  bufferPointer = bytesRead = 0;
 }

 public FastScanner( String file_name) throws IOException {
  din = new DataInputStream(new FileInputStream(file_name));
  buffer = new byte[BUFFER_SIZE];
  bufferPointer = bytesRead = 0;
    }

 public String readLine() throws IOException {
   byte[] buf = new byte[64];
  int cnt = 0, c;
  while ((c = read()) != -1) {
   if (c == '\n')
    break;
   buf[cnt++] = (byte) c;
  }
  return new String(buf, 0, cnt);
 }

    public String next() throws IOException{

  byte c = read();
  while(Character.isWhitespace(c)){
   c = read();
  }

   StringBuilder builder = new StringBuilder();
  builder.append((char)c);
  c = read();
  while(!Character.isWhitespace(c)){
   builder.append((char)c);
   c = read();
  }

  return builder.toString();
 }

 public int nextInt() throws IOException {
  int ret = 0;
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

 public int[] nextIntArray( int n) throws IOException {
   int arr[] = new int[n];
  for(int i = 0; i < n; i++){
   arr[i] = nextInt();
  }
  return arr;
 }

 public long nextLong() throws IOException {
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

 public long[] nextLongArray( int n) throws IOException {
   long arr[] = new long[n];
  for(int i = 0; i < n; i++){
   arr[i] = nextLong();
  }
  return arr;
 }

 public char nextChar() throws IOException{
  byte c = read();
  while(Character.isWhitespace(c)){
   c = read();
  }
  return (char) c; 
 }

 public double nextDouble() throws IOException {
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

 public double[] nextDoubleArray( int n) throws IOException {
   double arr[] = new double[n];
  for(int i = 0; i < n; i++){
   arr[i] = nextDouble();
  }
  return arr;
 }

 private void fillBuffer() throws IOException {
  bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
  if (bytesRead == -1)
   buffer[0] = -1;
 }

 private byte read() throws IOException {
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

