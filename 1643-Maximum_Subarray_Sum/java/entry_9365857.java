import java.io.*;
import java.util.*;

public class entry_9365857 {
  void solve(FastIO io) {
    int n = io.nextInt();
    var nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = io.nextInt();
    }
    long globalMax = nums[0];
    long localMax = nums[0];
    for (int i = 1; i < n; i++) {
      localMax = Math.max(nums[i], localMax + nums[i]);
      globalMax = Math.max(globalMax, localMax);
    }
    io.printf("%d%n", globalMax);
  }

  public static void main(String[] args) {
    var m = new entry_9365857();
    var io = new FastIO();
    m.solve(io);
    io.close();
  }
}

/*@fmt:off*/
final class FastIO extends PrintWriter{InputStream stream;byte[]buf=new byte[1<<16];int curChar,numChars;
FastIO(){this(System.in,System.out);}FastIO(InputStream i,OutputStream o){super(o);stream=i;}
int nextByte() {if(numChars==-1){throw new InputMismatchException();}if(curChar >= numChars)
{curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}
if(numChars==-1){return -1;}}return buf[curChar++];}String next(){return next(' ');}
String nextLine(){return next('\n');}private String next(char l){int c;do{c=nextByte();}
while(c<=l);var res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>l);return res.toString();}
int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}
int res=0;do{if(c<'0'||c>'9'){throw new InputMismatchException();}res=10*res+c-'0';c=nextByte();}
while(c>' ');return res*sgn;}double nextDouble(){return Double.parseDouble(next());}
long nextLong(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}
long res=0;do{if(c<'0'||c>'9'){throw new InputMismatchException();}res=10*res+c-'0';c=nextByte();}
while(c>' ');return res*sgn;}}