import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class entry_6908033 {

 final int MOD = 1000000007;

 void solve()
 {
  long n = in.nextLong();
  long res = 0;
  long top = n;
  for(long k=1;k*k<=n;k++)
  {
   long nxt = n/(k+1);
   long cnt = top-nxt;
   if(cnt%2==0)
    res += k * ( (top+nxt+1)%MOD * ((cnt/2)%MOD)%MOD )%MOD;
   else
    res += k * ( (top+nxt+1)/2%MOD * (cnt%MOD)%MOD )%MOD;
   res %= MOD;
   top = nxt;
  }
  while(top>0)
  {
   res += n/top * top%MOD;
   res %= MOD;
   top--;
  }
  out.printLong(res).println();
 }


 public void printlnArray(int[] array)
 {
  for(int i=0;i<array.length;i++)
  {
   if(i!=0)
    out.print(' ');
   out.printInt(array[i]);
  }
  out.println();
 }
// 
 public void printlnArray(long[] array)
 {
  for(int i=0;i<array.length;i++)
  {
   if(i!=0)
    out.print(' ');
   out.printLong(array[i]);
  }
  out.println();
 }

 static Random rand = new Random(); 
 public static void safeSort(int[] arr)
 {
  int n = arr.length;
  while(n>1)
  {
   int pos = rand.nextInt(n);
   int tmp = arr[pos];
   arr[pos] = arr[n-1];
   arr[n-1] = tmp;
   n--;
  }
  Arrays.sort(arr);
 }

 public static void safeSort(long[] arr)
 {
  int n = arr.length;
  while(n>1)
  {
   int pos = rand.nextInt(n);
   long tmp = arr[pos];
   arr[pos] = arr[n-1];
   arr[n-1] = tmp;
   n--;
  }
  Arrays.sort(arr);
 }

 private SuperQuickReader in;
 private SuperQuickWriter out;
 public entry_6908033(SuperQuickReader in, SuperQuickWriter out) {
  this.in = in;
  this.out = out;
 }

 public static void main(String[] args) throws IOException {
  SuperQuickReader in = new SuperQuickReader(System.in);

  try(SuperQuickWriter out = new SuperQuickWriter(System.out);)
  {
   new entry_6908033(in, out).solve();
  }
 }

}

class QuickReader {
 BufferedReader in;
 StringTokenizer token;

 public QuickReader(InputStream ins) {
  in = new BufferedReader(new InputStreamReader(ins));
  token = new StringTokenizer("");
 }

 public boolean hasNext() {
  while (!token.hasMoreTokens()) {
   try {
    String s = in.readLine();
    if (s == null)
     return false;
    token = new StringTokenizer(s);
   } catch (IOException e) {
    throw new InputMismatchException();
   }
  }
  return true;
 }

 public String next() {
  hasNext();
  return token.nextToken();
 }

 public int nextInt() {
  return Integer.parseInt(next());
 }

 public int[] nextInts(int n) {
  int[] res = new int[n];
  for (int i = 0; i < n; i++)
   res[i] = nextInt();
  return res;
 }

 public long nextLong() {
  return Long.parseLong(next());
 }

 public long[] nextLongs(int n) {
  long[] res = new long[n];
  for (int i = 0; i < n; i++)
   res[i] = nextLong();
  return res;
 }

}

class SuperQuickReader
{
 final int BUFFER_SIZE = 4096;
 Reader in;

 char[] buf = new char[BUFFER_SIZE];
 int bufL, bufR;

 public SuperQuickReader(InputStream ins)
 {
  in=new InputStreamReader(ins);
 }

 public char nextChar()
 {
  try {
   while(bufR >= 0)
   {
    if(bufL < bufR)
    {
     char x = buf[bufL++];
     return x;
    }
    else
    {
     bufR = in.read(buf);
     bufL = 0;
    }
   }
  }
  catch(IOException e)
  {
   bufL = bufR = -1;
  }
  return 0;
 }

 public char nextNonSpaceChar()
 {
  char c;
  do
  {
   c = nextChar();
  }while(c == ' ' || c == '\n');
  return c;
 }

 public int nextInt()
 {
  int res = 0;
  char c;
  boolean neg = false;
  do
  {
   c = nextChar();
  }
  while(c==' ' || c=='\n');
  if(c == '-')
  {
   neg = true;
   c = nextChar();
  }

  do
  {
   res = res * 10 + (c-'0');
   c = nextChar();
  }
  while(c!=' ' && c!='\n' && c!=0);
  if(neg) res = -res;
  return res;
 }

 public long nextLong()
 {
  long res = 0;
  char c;
  boolean neg = false;
  do
  {
   c = nextChar();
  }
  while(c==' ' || c=='\n');
  if(c == '-')
  {
   neg = true;
   c = nextChar();
  }

  do
  {
   res = res * 10 + (c-'0');
   c = nextChar();
  }
  while(c!=' ' && c!='\n' && c!=0);
  if(neg) res = -res;
  return res;
 }

 public int[] nextInts(int n)
 {
  int[] res = new int[n];
  for (int i = 0; i < n; i++)
   res[i] = nextInt();
  return res;
 }

}

class SuperQuickWriter implements Closeable
{
 static final int BUFFER_SIZE = 4*4096;
 static final int SMALL_BUFFER_SIZE = 64;
 Writer out;
 char[] buf = new char[BUFFER_SIZE];
 char[] smallBuf = new char[SMALL_BUFFER_SIZE];
 int bufTop;
 public SuperQuickWriter(OutputStream out)
 {
  this.out = new OutputStreamWriter(out);
 }

 public SuperQuickWriter print(char c)
 {
  try {
  if(bufTop == BUFFER_SIZE)
  {
   out.write(buf);
   bufTop = 0;
  }
  buf[bufTop++] = c;
  }
  catch(IOException e)
  {
   e.printStackTrace();
  }
  return this;
 }

 public SuperQuickWriter printInt(int x)
 {
  int top = 0;
  if ( x < 0 )
  {
   print('-');
   x = -x;
  }
  do
  {
   smallBuf[top++]=(char) (x%10+'0');
   x/=10;
  }
  while(x!=0);

  while(top>0)
   print(smallBuf[--top]);

  return this;
 }

 public SuperQuickWriter printLong(long x) {
  int top = 0;
  if ( x < 0 )
  {
   print('-');
   x = -x;
  }
  do
  {
   smallBuf[top++]=(char) (x%10+'0');
   x/=10;
  }
  while(x!=0);

  while(top>0)
   print(smallBuf[--top]);
  return this;
 }

 public SuperQuickWriter println()
 {
  print('\n');
  return this;
 }

 public void flush() {
  try {
   out.write(buf, 0, bufTop);
   out.flush();
   bufTop = 0;
  }
  catch(IOException e)
  {
   e.printStackTrace();
  }
 }

 @Override
 public void close() throws IOException {
  flush();
  out.close();
 }


}