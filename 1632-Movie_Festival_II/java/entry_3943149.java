import java.util.*;
import java.io.*;
public class entry_3943149 {
 // @formatter:off
 static long mod=(int)(1e9)+7;
 static FastScanner in;
 static PrintWriter out=new PrintWriter(System.out);
 static class FastScanner{
  private InputStream stream;
  private byte[] buf = new byte[1 << 16];
  private int curChar;
  private int numChars;

  // standard input
  public FastScanner() { this(System.in); }

  public FastScanner(InputStream i) {
   stream = i;
  }

  // file input
  public FastScanner(String i) throws IOException {
   stream = new FileInputStream(i);
  }

  // throws InputMismatchException() if previously detected end of file
  private int nextByte() {
   if (numChars == -1) {
    throw new InputMismatchException();
   }
   if (curChar >= numChars) {
    curChar = 0;
    try {
     numChars = stream.read(buf);
    } catch (IOException e) {
     throw new InputMismatchException();
    }
    if (numChars == -1) {
     return -1;  // end of file
    }
   }
   return buf[curChar++];
  }

  // to read in entire lines, replace c <= ' '
  // with a function that checks whether c is a line break
  public String next() {
   int c;
   do {
    c = nextByte();
   } while (c <= ' ');

   StringBuilder res = new StringBuilder();
   do {
    res.appendCodePoint(c);
    c = nextByte();
   } while (c > ' ');
   return res.toString();
  }

  public int nextInt() {  // nextLong() would be implemented similarly
   int c;
   do {
    c = nextByte();
   } while (c <= ' ');

   int sgn = 1;
   if (c == '-') { 
    sgn = -1;
    c = nextByte(); 
   }

   int res = 0;
   do {
    if (c < '0' || c > '9') {
     throw new InputMismatchException();
    }
    res = 10 * res + c - '0';
    c = nextByte();
   } while (c > ' ');
   return res * sgn;
  }

  public long nextLong() {  
   int c;
   do {
    c = nextByte();
   } while (c <= ' ');

   int sgn = 1;
   if (c == '-') { 
    sgn = -1;
    c = nextByte(); 
   }

   long res = 0;
   do {
    if (c < '0' || c > '9') {
     throw new InputMismatchException();
    }
    res = 10 * res + c - '0';
    c = nextByte();
   } while (c > ' ');
   return res * sgn;
  }
  public double nextDouble() { return Double.parseDouble(next()); }
 }
 static void setIO() {try {in=new FastScanner("entry_3943149.in");}catch(Exception e) {in=new FastScanner(System.in);}}
 public static void main(String[] args)throws Exception {
  int ret=solve();
  System.out.println(ret);
 }
 static int solve() throws Exception {
  setIO();
  int n=in.nextInt(),k=in.nextInt();
  // point = id, x value
  int[][]a=new int[n][2];
  for(int i=0;i<n;i++) a[i]=new int[] {in.nextInt(),in.nextInt(),i};
  TreeSet<int[]>s=new TreeSet<>((x,y)->{
   if(x[1]==y[1]) return x[2]-y[2];
   return x[1]-y[1];
  });
  Arrays.sort(a,(x,y)->x[0]-y[0]);
  int ret=0;
  for(int[]p:a) {
   int start=p[0];
   while(s.size()>0&&s.first()[1]<=start) s.remove(s.first());
   if(s.size()<k) ret++;
   s.add(p);
   if(s.size()>k) s.remove(s.last());
  }
  return ret;
 }
 static class MultiSet<T>{
  TreeMap<T,Integer> mp;
  int size=0;
  MultiSet(){
   mp=new TreeMap<>();
  }
  // constructor that allows the set to be sorted in different ways
  MultiSet(Comparator<T> c){
   mp=new TreeMap<>(c);
  }
  // adds a value to the set
  void add(T x) {
   if(mp.get(x)==null) mp.put(x, 0);
   mp.put(x, mp.get(x)+1); size++;
  }
  // removes a value from the set
  void remove(T x) {
   if(mp.get(x)==null) return;
   mp.put(x, mp.get(x)-1);
   if(mp.get(x)==0) mp.remove(x);
   size--;
  }
  // return true/false whether this set contains the given key
  boolean contains(T x) {
   return mp.containsKey(x);
  }
  // returns the freq of the given key
  int freq(T x) {
   if(mp.get(x)==0) return 0;
   return mp.get(x);
  }
  // returns the least value in set, null if not possible
  T first() {
   return mp.firstKey();
  }
  // returns the largest value in set, null if not possible
  T last() {
   return mp.lastKey();
  }
  // returns the least value greater than or equal to the given value, null if not possible
  T ceiling(T key) {
   return mp.ceilingKey(key);
  }
  // returns the greatest value less than or equal to the given value, null if not possible
  T floor(T key) {
   return mp.floorKey(key);
  }
  // returns the least value strictly greater than the given value, null if not possible
  T higher(T key) {
   return mp.higherKey(key);
  }
  // returns the greatest value strictly less than the given value, null if not possible
  T lower(T key) {
   return mp.lowerKey(key);
  }
  // returns the size of the set
  int size() {
   return size;
  }
  @Override
  public String toString() {
   return mp.toString();
  }
 }
}