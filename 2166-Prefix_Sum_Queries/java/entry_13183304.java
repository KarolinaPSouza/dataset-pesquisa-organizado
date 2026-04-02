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

public class entry_13183304 {
    static long[][]tree;
    static int offset;
    public static void main(String[] args) throws IOException{
        fastio io=new fastio();
        StringBuilder sb=new StringBuilder();
        int n=io.nextInt();
        int q=io.nextInt();

        int size = 1;
        while (size < n) 
        {
            size <<= 1;
        }
        int newN = 2 * size;

        tree=new long[newN+1][2];     //newN represents size of tree array, tree is 1-based
        offset=size-1;
        int i=offset+1;
        while(i-1-offset<n)
        {
            int z=io.nextInt();
            tree[i][0]=z;
            tree[i][1]=z;            
            i++;
        }

        // Build internal nodes
        for (i = offset; i > 0; i--) 
        {
            long lsum=tree[2 * i][0];
            tree[i][0]=lsum+ tree[2 * i + 1][0];
            tree[i][1] = Math.max(tree[2 * i][1], lsum+tree[2 * i + 1][1]);
        }

        while(q-->0)
        {
            int check=io.nextInt();
            int a=io.nextInt();
            int b=io.nextInt();
            if(check==1)
            {
                update(a, b);
            }
            else
            {
                sb.append(sum(a, b)).append("\n");
            }
        }

        io.print(sb);
        io.flush();
    }

    static void update(int k, long x) 
    { 
        k += offset; 
        tree[k][0]= x; 
        tree[k][1]=tree[k][0];

        for (k /= 2; k >= 1; k /= 2) 
        { 
            long lsum=tree[2 * k][0];
            tree[k][0] = lsum+tree[2*k+1][0]; 
            tree[k][1] = Math.max(tree[2 * k][1], lsum+tree[2 * k + 1][1]);
        } 
    }

    static long sum(int a, int b) 
    { 
        a += offset; 
        b += offset; 
        long lmax = 0,rmax=0; 
        long lsum=0,rsum=0;
        while (a <= b)
        { 
            if (a%2 == 1)  //if a is right, and bcoz it is going up, it means we are going away from b and including unwanted members
            {
                lmax=Math.max(lmax, tree[a][1]+lsum);
                lsum+=tree[a][0];
                a++;                
            }            
            if (b%2 == 0) //same logic here
            {
                rmax=Math.max(tree[b][0]+rmax, tree[b][1]);
                rsum+=tree[b][0];
                b--;    
            }

            a /= 2; 
            b /= 2; 
        } 
        return Math.max(Math.max(lsum+rmax, lmax),0); 
    }
}