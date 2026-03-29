//package Dynamic_Programming;

import java.util.*;
import java.io.*;

public class entry_6341673 {
    // FCK SPEEDFORCES
    static FastRead sc = new FastRead(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    private static class FastRead {
        private final InputStream stream;private final byte[] buf = new byte[1<<18];private int curChar, numChars;public FastRead (InputStream stream) {this.stream = stream;}
        public FastRead (String file) throws IOException {this.stream = new FileInputStream (file);}
        void run() {try {PrintStream fs = new PrintStream("error.txt");System.setErr(fs);} catch (FileNotFoundException e) {e.printStackTrace();}} //error.txt handler
        public int cscan () throws IOException {
            if (curChar >= numChars) {curChar = 0;numChars = stream.read (buf);}if (numChars == -1) return numChars;return buf[curChar++];}
        public int nextInt () throws IOException {
            int c = cscan (), sgn = 1;while (space (c)) c = cscan ();if (c == '-') {sgn = -1;c = cscan ();}
            int res = 0;do {res = (res << 1) + (res << 3);res += c - '0';c = cscan ();} while (!space (c));return res * sgn;}
        public String nextString () throws IOException {
            int c = cscan ();while (space (c)) c = cscan ();StringBuilder res = new StringBuilder ();do {res.appendCodePoint (c);c = cscan ();} while (!space (c));
            return res.toString ();}
        public double nextDouble () throws IOException {
            int c = cscan (), sgn = 1;while (space (c)) c = cscan ();if (c == '-') {sgn = -1;c = cscan ();}double res = 0;
            while (!space (c) && c != '.') {if (c == 'e' || c == 'E') return res * exp(10, nextInt ()); res *= 10;res += c - '0';c = cscan ();}
            if (c == '.') {c = cscan ();double m = 1;while (!space (c)) {if (c == 'e' || c == 'E') return res * exp(10, nextInt ());m /= 10;res += (c - '0') * m;c = cscan ();}}
            return res * sgn;}
        public long nextLong () throws IOException {
            int c = cscan (), sgn = 1;while (space (c)) c = cscan ();if (c == '-') {sgn = -1;c = cscan ();}long res = 0;do {res = (res << 1) + (res << 3);res += c - '0';c = cscan ();}
            while (!space (c));return res * sgn;}
        public boolean space (int c) {return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;}
    }
    static final int mod = 1_000_000_007;
    static long mul(long a, long b) {return (a * b) % mod;}
    static long exp(long base, long exp) {if (exp == 0) return 1;long half = exp(base, exp / 2); if (exp % 2 == 0) return mul(half, half);return mul(half, mul(half, base));}
    static void debug(Object... o){if(o.length != 0) System.err.println(Arrays.deepToString(o));else System.err.println();}
    static long expMod(long base, long exp, long modulo){ // T.C: O(log exp)
        long res = 1; base = base % modulo;if (base == 0) return 0;while (exp > 0) {if ((exp & 1) != 0) res = (res * base) % modulo;exp = exp >> 1;base = (base * base) % modulo;}return res;}
    static long modInv(long a, long modulo){return expMod(a , modulo-2 , modulo);}
    static long mod_add(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (((a + b) % modulo) + modulo) % modulo;}
    static long mod_mult(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (((a * b) % modulo) + modulo) % modulo;}
    static long mod_sub(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (((a - b) % modulo) + modulo) % modulo;}
    static long mod_div(long a, long b, long modulo) {a = a % modulo; b = b % modulo; return (mod_mult(a, modInv(b, modulo), modulo) + modulo) % modulo;}
    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];
    static void preCompFacts() {
        powerUp = true;
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = mod_mult(factorials[i - 1], i,mod);
        invFactorials[factorials.length - 1] = modInv(factorials[factorials.length - 1],mod);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mod_mult(invFactorials[i + 1], i + 1,mod);
    }
    static boolean powerUp = false;
    static long nCk(int n, int k) {
        if(!powerUp) preCompFacts();
        return mod_mult(factorials[n], mod_mult(invFactorials[k], invFactorials[n - k],mod),mod);
    }
    static class Tuple{
        int st,ed,val;
        Tuple(int st,int e,int val){
            this.st=st;
            this.ed=e;
            this.val=val;
        }
    }
    static int closestLeft(int x,Tuple[] arr){
            // returns index position
            int mid,i=0,j=arr.length-1,pos=-1;
            while(i<=j){
                mid=i+((j-i)>>1);
                if(arr[mid].ed <= x){
                    pos=mid;
                    i=mid+1;
                }
                else j=mid-1;
            }
            return pos;
    }
    public static void main(String[] args)throws IOException {
        int n=sc.nextInt();
        Tuple[] a=new Tuple[n];
        int i;
        for(i=0;i<n;i++) {
            a[i] = new Tuple(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(a,(x,y)->{return x.ed-y.ed;});
        long[] dp =new long[n];
        dp[0] = 0;
        for(i=0;i<n;i++){
            int pos=closestLeft(a[i].st-1,a);
           dp[i] = Math.max(a[i].val+(pos!=-1?dp[pos]:0), i-1>=0?dp[i-1]:0);

        }
        out.println(dp[n-1]);
        out.flush();
    }
}