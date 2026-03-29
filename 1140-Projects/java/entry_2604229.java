import java.util.*;
import java.io.*;

class SortByEndTime implements Comparator<long[]>{
    public int compare(long[] a,long[] b){
        return (int)(a[1] - b[1]);
    }
}

public class entry_2604229 {
    public static int mod = 1000000007;
    public static long[] dp = new long[0];

    public static void main(String[] args) {
        int n = io.nextInt();
        ArrayList<long[]> arr = new ArrayList<long[]>();
        dp = new long[n];

        for(int i = 0; i < n; i++){
            arr.add(arrInput());
        }

        Collections.sort(arr, new SortByEndTime());

        dp[0] = arr.get(0)[2];

        for(int i = 1; i< n ; i++){
            long curr= arr.get(i)[2];
            long back = getBack(i-1, arr.get(i)[0], dp, arr);
            curr += back;
            dp[i] = Math.max(dp[i-1], curr);
        }

        System.out.println(dp[n-1]);
    }

    public static long getBack(int end, long el, long[] dp, ArrayList<long[]> arr){
        int left = 0;
        int right = end;
        long ans = 0;
        while(left <= right){
            int mid = left + right >> 1;
            if(el > arr.get(mid)[1]){
                ans = dp[mid];
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }

    public static long[] arrInput() {
        String[] input = io.nextLine().split(" ");
        int n = input.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        return arr;

    }

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static FastIO io = new FastIO();

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        // standard input
        public FastIO() {
            this(System.in, System.out);
        }

        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }

        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1; // end of file
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }

        public String nextLine() {
            int c;
            do {
                c = nextByte();
            } while (c < '\n');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > '\n');
            return res.toString();
        }

        public int nextInt() { // nextLong() would be implemented similarly
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}