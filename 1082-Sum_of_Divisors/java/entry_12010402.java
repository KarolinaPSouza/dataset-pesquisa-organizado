import java.io.*;
import java.util.*;

class FastIO extends PrintWriter{
    private InputStream stream;private byte[]buf=new byte[1<<16];
    private int curChar,numChars;public FastIO(){this(System.in,System.out);}
    public FastIO(InputStream i,OutputStream o){super(o);stream=i;}
    public FastIO(String i,String o)throws IOException{super(new FileWriter(o));stream=new FileInputStream(i);}
    private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return -1;}return buf[curChar++];}
    public String nextLine(){int c;do{c=nextByte();}while(c<='\n');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>'\n');return res.toString();}
    public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}
    public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public long nextLong(){int c;do{c=nextByte();}while(c<=' ');long sgn=1;if(c=='-'){sgn=-1;c=nextByte();}long res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public double nextDouble(){return Double.parseDouble(next());
    }
}

public class entry_12010402 {
    static FastIO sc = new FastIO();
    static final int MOD = 1000000007; 

    public static void main(String args[]) {
        long n = sc.nextLong();
        long sum = 0;
        long num = n;

        while (num > 0) {
            long q = n / num;
            long nextNum = n / (q + 1);

            sum = (sum + findSumInRange(nextNum, num) * q % MOD) % MOD;

            num = nextNum;
        }

        sc.print(sum);
        sc.flush();
    }

    public static long findSumInRange(long nextNum, long num) {
        // Compute sum of numbers in the range [nextNum+1, num] using safe modular arithmetic
        long inv2 = 500000004L;  // Modular inverse of 2 modulo MOD

        long a = num % MOD;
        long b = (num + 1) % MOD;
        long sum1 = (a * b) % MOD;
        sum1 = (sum1 * inv2) % MOD;

        long c = nextNum % MOD;
        long d = (nextNum + 1) % MOD;
        long sum2 = (c * d) % MOD;
        sum2 = (sum2 * inv2) % MOD;

        return (sum1 - sum2 + MOD) % MOD; // Ensure non-negative result
    }

}