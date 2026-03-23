// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.StringTokenizer;

public class entry_15660683 {
 public static void main(String[] args) throws IOException {
  FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] pos = new int[2];
        long layer = 0;
        long nonLayer = 0;
        long area = 0;
        for (int i = 0; i < n; i++)
        {
            pos[0] = scanner.nextInt();
            pos[1] = scanner.nextInt();

            layer = Math.max(pos[0], pos[1]);

            area = layer * layer;
            long output = area;
            if (layer % 2 == 0) 
            {
                output -= pos[1] - 1;
                output -= layer - pos[0];
            }
            else
            {
                output -= pos[0] - 1;
                output -= layer - pos[1];
            }
            System.out.println(output);
        }
 }
    private static final class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= ' ') ;
            if (c == -1) return null;
            do {
                sb.append((char) c);
            } while ((c = readByte()) > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            while ((c = readByte()) <= ' ') ;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            while ((c = readByte()) <= ' ') ;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        boolean hasNext() throws IOException {
            int c;
            while ((c = readByte()) != -1) {
                if (c > ' ') {
                    ptr--; // step back one byte
                    return true;
                }
            }
            return false;
        }
    }
}