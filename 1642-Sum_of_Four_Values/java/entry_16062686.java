import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
public class entry_16062686 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int x = fs.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0;i<n;i++){
            arr[i][0] = fs.nextInt();
            arr[i][1] = i+1;
        }
        Arrays.sort(arr,(a,b)->{
            return a[0] - b[0];
        });
        for(int i = 0;i<n-2;i++){
            for(int j = i+1;j<n-1;j++){
                int left = j+1;
                int right = n-1;
                while(left < right){
                    int sum = arr[i][0] + arr[j][0] + arr[left][0] + arr[right][0];
                    if(sum == x){
                        System.out.println(arr[i][1] + " "+arr[j][1] + " "+arr[left][1] + " "+arr[right][1]);
                        return;
                    }else if(sum > x){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    // Fast input
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        // -------- INT --------
        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        // -------- LONG --------
        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;

            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        // -------- DOUBLE --------
        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        // -------- FLOAT --------
        float nextFloat() throws IOException {
            return Float.parseFloat(next());
        }

        // -------- STRING (token) --------
        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            do {
                c = read();
            } while (c <= ' ');

            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }

        // -------- STRING (line) --------
        String nextLine() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) != -1 && c != '\n') {
                if (c != '\r') sb.append((char) c);
            }
            return sb.toString();
        }

        // -------- CHAR --------
        char nextChar() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');
            return (char) c;
        }

        // -------- BOOLEAN --------
        boolean nextBoolean() throws IOException {
            String s = next();
            return s.equalsIgnoreCase("true") || s.equals("1");
        }
    }

}