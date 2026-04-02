import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class entry_6807871 {

 void solve()
 {
  int n = in.nextInt();
  int x = in.nextInt();
  long[] a = new long[n];
  for(int i=0;i<n;i++)
   a[i] = in.nextInt() * 1L * n + i;
  safeSort(a);
  int[] pos = new int[n];
  for(int i=0;i<n;i++)
  {
   pos[i] = (int) (a[i]%n)+1;
   a[i] /=n;
  }

  int[] sum2 = new int[n*(n-1)/2];
  int top = 0;
  for(int i=0;i<n-1;i++)
   for(int j=i+1;j<n;j++)
    sum2[top++] = (int) (a[i] + a[j]);
  safeSort(sum2);

  top=1;
  for(int i=1;i<sum2.length;i++)
   if(sum2[top-1] != sum2[i] )
    sum2[top++] = sum2[i];

  int[] pos1 = new int[top];
  int[] pos2 = new int[top];
  Arrays.fill(pos1, -1);
  Arrays.fill(pos2, -1);

  for(int mid = 2; mid < n-1; mid++)
  {
   for(int i=0;i<mid-1;i++)
   {
    int y = (int) (a[i] + a[mid-1]);
    int at = Arrays.binarySearch(sum2, 0, top, y);
    pos1[at] = pos[i];
    pos2[at] = pos[mid-1];
   }
   for(int j=mid+1;j<n;j++)
   {
    int z = (int) (a[mid] + a[j]);
    int rem = x - z;
    int at = Arrays.binarySearch(sum2, 0, top, rem);
    if ( at >= 0 && pos1[at] >=0 )
    {
     out.printf("%d %d %d %d\n", pos1[at], pos2[at], pos[mid], pos[j]);
     return;
    }
   }
  }

  out.println("IMPOSSIBLE");
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
 private PrintWriter out;
 public entry_6807871(SuperQuickReader in, PrintWriter out) {
  this.in = in;
  this.out = out;
 }

 public static void main(String[] args) throws IOException {
  SuperQuickReader in = new SuperQuickReader(System.in);

  try(PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));)
  {
   new entry_6807871(in, out).solve();
  }
 }

}

class Task implements Comparable<Task>
{
 int a,d;

 Task(int a, int d) {
  super();
  this.a = a;
  this.d = d;
 }

 @Override
 public String toString() {
  return "Task [a=" + a + ", d=" + d + "]";
 }

 @Override
 public int compareTo(Task arg0) {
  return a - arg0.a;
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
  do
  {
   c = nextChar();
  }
  while(c==' ' || c=='\n');

  do
  {
   res = res * 10 + (c-'0');
   c = nextChar();
  }
  while(c!=' ' && c!='\n' && c!=0);

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
