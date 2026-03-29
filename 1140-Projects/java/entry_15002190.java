import java.io.*;
import java.util.*;

public class entry_15002190 {
    static final int MOD = (int)1e9 + 7;


    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int essa = fs.nextInt();
        int[][] arr = new int[essa][3];
        long[] t = new long[essa];
        for (int e = 0; e < essa; e++) {
            arr[e][0]=fs.nextInt();
            arr[e][1]=fs.nextInt();
            arr[e][2]=fs.nextInt();
        }
        Arrays.sort(arr, (a, b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return a[1]-b[1];
        });
        long ans = 0;
        for (int i = essa-1; i >=0 ; i--) {
            int jarka = bound(arr, arr[i][1], i);
            t[i]=arr[i][2];
            if(jarka!=essa)t[i]+=t[jarka];
            if(i!=essa-1)t[i]=Math.max(t[i], t[i+1]);
            ans=Math.max(ans, t[i]);
        }

        out.println(ans);
        out.flush();
    }

    static int bound(int[][] arr, int el, int minind){
        int start = minind;
        int end = arr.length;
        while (start<end){
            int mid = (start+end)/2;
            if(arr[mid][0]<=el){
                start=mid+1;
            }else {
                end=mid;
            }
        }
        return start;
    }


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

        private int skip() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return -1;
            return c;
        }

        String next() throws IOException {
            int c = skip();
            if (c == -1) return null;
            StringBuilder sb = new StringBuilder();
            do { sb.append((char)c); c = read(); } while (c > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c = skip(), sgn = 1, x = 0;
            if (c == '-') { sgn = -1; c = read(); }
            while (c > ' ') { x = x * 10 + (c - '0'); c = read(); }
            return x * sgn;
        }

        long nextLong() throws IOException {
            int c = skip(), sgn = 1; long x = 0;
            if (c == '-') { sgn = -1; c = read(); }
            while (c > ' ') { x = x * 10 + (c - '0'); c = read(); }
            return x * sgn;
        }
    }

}