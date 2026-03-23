//package org.example;

import java.io.IOException;
import java.io.InputStream;

public class entry_14345161 {

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
            do { c = read(); } while (c <= ' '); // skip spaces
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException { return (int) nextLong(); }
    }


    public static void main(String[] args) throws Exception {
        FastScanner fc = new FastScanner(System.in);
        int t= fc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- >0){
            long x =  fc.nextInt();
            long y = fc.nextInt();
            long out = 0;
            if(x>=y){
                if((x&1)==0){
                    out = x*x - y+1;
                } else{
                    out = (x-1)*(x-1)+y;
                }
            } else{
                if((y&1)==0){
                    out = (y-1)*(y-1)+x;
                } else{
                    out = y*y-x+1;
                }
            }
            sb.append(out).append('\n');
        }

        System.out.println(sb.toString());
    }
}