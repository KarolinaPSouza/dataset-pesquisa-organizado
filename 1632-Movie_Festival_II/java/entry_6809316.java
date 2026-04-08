import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class entry_6809316 {

final int INF = 1000000001;

 void solve()
 {
  int n = in.nextInt();
  int k = in.nextInt();
  long[] movies = new long[n];
  for(int i=0;i<n;i++)
  {
   int a = in.nextInt();
   int b = in.nextInt();
   movies[i] = (INF-1-a) + b * 1L * INF;
  }
  safeSort(movies);
  int rb = -INF;
  int cnt = 0;
  TreeSet<Info> freeTime = new TreeSet<>();
  for(int i=0;i<k;i++)
   freeTime.add(new Info(0, i));
  Info tempInfo = new Info();
  tempInfo.personId = n;
  for(int i=0;i<n;i++)
  {
   int a = INF-1-(int) (movies[i]%INF);
   int b = (int) (movies[i]/INF);
   tempInfo.endTime = a;
   Info x = freeTime.lower(tempInfo);
   if( x != null )
   {
    freeTime.remove(x);
    x.endTime = b;
    freeTime.add(x);
    cnt++;
   }
  }
  out.println(cnt);
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
 public entry_6809316(SuperQuickReader in, PrintWriter out) {
  this.in = in;
  this.out = out;
 }

 public static void main(String[] args) throws IOException {
  SuperQuickReader in = new SuperQuickReader(System.in);

  try(PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));)
  {
   new entry_6809316(in, out).solve();
  }
 }

}

class Info implements Comparable<Info>
{
 int endTime, personId;

 @Override
 public String toString() {
  return "Info [endTime=" + endTime + ", personId=" + personId + "]";
 }


 Info(int endTime, int personId) {
  super();
  this.endTime = endTime;
  this.personId = personId;
 }



 public Info() {
 }


 @Override
 public int compareTo(Info arg0) {
  if(endTime != arg0.endTime)
   return endTime - arg0.endTime;
  return personId - arg0.personId;
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

  boolean neg = false;
  if ( c == '-' )
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

  if(neg)
   res=-res;
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
