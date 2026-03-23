import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

class fastio {
    private final InputStream in;
    private final PrintWriter out;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, buflen = 0;

    public fastio() {
        in = System.in;
        out = new PrintWriter(System.out);
    }

    private int read() throws IOException {
        if (ptr >= buflen) {
            ptr = 0;
            buflen = in.read(buffer);
            if (buflen <= 0) return -1;
        }
        return buffer[ptr++];
    }

    public int nextInt() throws IOException {
        int c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        int x = 0;
        while (c >= '0' && c <= '9') {
            x = x * 10 + (c - '0');
            c = read();
        }
        return neg ? -x : x;
    }

    public long nextLong() throws IOException {
        int c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        long x = 0;
        while (c >= '0' && c <= '9') {
            x = x * 10 + (c - '0');
            c = read();
        }
        return neg ? -x : x;
    }

    public String next() throws IOException {
        int c = read();
        while (c <= ' ') c = read();
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
            c = read();
        } while (c > ' ');
        return sb.toString();
    }

    public String nextLine() throws IOException {
        int c;
        StringBuilder sb = new StringBuilder();
        while ((c = read()) != -1 && c != '\n') {
            sb.append((char) c);
        }
        return sb.toString();
    }

    public void print(Object o) {
        out.print(o);
    }

    public void println(Object o) {
        out.println(o);
    }

    public void flush() {
        out.flush();
    }

    public void close() {
        out.close();
    }

    public char nextChar() throws IOException {
        int c = read();
        while (c <= ' ') c = read(); // skip whitespace
        return (char) c;
    }

    public double nextDouble() throws IOException {
        int c = read();
        while (c <= ' ') c = read();

        boolean neg = false;
        if (c == '-') {
            neg = true;
            c = read();
        }

        double x = 0;
        while (c >= '0' && c <= '9') {
            x = x * 10 + (c - '0');
            c = read();
        }

        if (c == '.') {
            c = read();
            double frac = 1;
            while (c >= '0' && c <= '9') {
                frac /= 10;
                x += (c - '0') * frac;
                c = read();
            }
        }

        return neg ? -x : x;
    }
}

public class entry_13357978 {
    static long mod=1000000007;
    public static void main(String[] args) throws IOException{
        fastio io=new fastio();        

        long n=io.nextLong();
        long total=0;
        long count;
        long last;
        long sum;
        long inv2=modInverse(2, mod);
        for(long i=1;i<=n;)
        {
            long q=n/i;
            count=n/q-i+1;
            last=i+count-1;            

            sum=(modMul((modMul(i+last, count)),inv2));

            i+=count;
            total=(total+(modMul(q, sum)))%mod;
        }     

        io.print(total);
        io.flush();
    }

    static long modMul(long a, long b) {
        return ((a % mod) * (b % mod)) % mod;
    }

    static long power(long base, long exp, long mod)
    {
        long result=1;
        base%=mod;
        while(exp>0)
        {
            if((exp&1)==1)
            {
                result=(result*base)%mod; //as we have to compensate for an extra loss of power(eg:- 3/2=1)
            } 
            base=(base*base)%mod;   
            exp=exp/2;
        }
        return result;
    }

    static long modInverse(long a, long mod) 
    {
        return power(a, mod - 2, mod);  // Works when mod is prime
    }
}