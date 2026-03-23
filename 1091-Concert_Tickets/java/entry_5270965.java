import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class entry_5270965 {

 //Global Declarations
 final static Random random = new Random();
 final static FastReader in = new FastReader();
 final static PrintWriter out = new PrintWriter(System.out);


 public static int[] solve(List<Integer> ls, int key) {

  int n=ls.size(),l=-1,r=n,m;

  while(r-l > 1){
   m = l+ ((r-l)/2); 

   if(ls.get(m) <= key)
    l = m;
   else
    r = m;
  }

  if(l != -1)
   return new int[] {ls.get(l),l};

  return new int[] {-1,-1};
 }

 public static void main(String[] args) throws IOException{

  int n = in.nextInt();
  int m = in.nextInt();

  int i;

  NavigableMap<Integer,Integer> mp = new TreeMap<>(); 

  for(i=0;i<n;++i){
   int ele = in.nextInt();
   mp.put(ele, mp.getOrDefault(ele,0) + 1);
  }

  for(i=0;i<m;++i){

   int key = in.nextInt(); 
   Entry<Integer,Integer> lowerEntrySet = mp.lowerEntry(key+1);

   if(lowerEntrySet != null){
    Integer lowerKey = lowerEntrySet.getKey();
    Integer lowerValue = lowerEntrySet.getValue();

    out.println(lowerKey);

    if(lowerValue - 1 == 0)
     mp.remove((Object) lowerKey);

    else
     mp.put(lowerKey, lowerValue - 1);
   }

   else
    out.println(-1);


  }

  out.close();
 }

static class FastReader extends PrintWriter {
 private InputStream stream;
 private byte[] buf = new byte[1 << 16];
 private int curChar;
 private int numChars;

 // standard input
 public FastReader() { this(System.in, System.out); }

 public FastReader(InputStream i, OutputStream o) {
  super(o);
  stream = i;
 }

 // file input
 public FastReader(String i, String o) throws IOException {
  super(new FileWriter(o));
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

 public double nextDouble() { 
  return Double.parseDouble(next()); 
 }
 }
}



