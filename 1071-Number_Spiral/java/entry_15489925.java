import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class entry_15489925 {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Long.MIN_VALUE;
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }

    public static void main(String[] args) throws IOException {


        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        for(int j=1;j<=n;j++){
            long x=sc.nextLong();
            long y=sc.nextLong();

            long line = Math.max(x,y)*Math.max(x,y);


            if(x>y && x%2 == 0)
                System.out.println(line - y + 1);
            else if(x>y && x%2 == 1)
                System.out.println(line - 2*x + y+ 1);
            else if(x<y && y%2 == 1)
                System.out.println(line - x + 1);
            else if(x<y && y%2 == 0)
                System.out.println(line - 2*y + x+ 1);
            else
                System.out.println(x*x-x+1);
        }
    }
}