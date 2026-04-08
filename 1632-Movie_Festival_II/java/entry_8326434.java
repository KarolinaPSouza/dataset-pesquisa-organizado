import java.io.*;
import java.util.*;

public class entry_8326434 {
    public static void main(String[] args) {
        FastIO fast = new FastIO();
        int n = fast.nextInt(), k = fast.nextInt();
        int[][] a = new int[n][2];
        for(int i = 0; i < n; ++i){
            a[i][0] = fast.nextInt();
            a[i][1] = fast.nextInt();
        }
        Arrays.sort(a, (ad, bd) -> ad[1] - bd[1]);

        TreeMap<Integer, Integer> ms = new TreeMap<>();
        int ans = 0, size = 0;
        for(int[] xy: a){
            final int x = -xy[0], y = -xy[1];
            if(ms.isEmpty()){
                ms.put(y, 1);
                ans += 1;
                ++size;
            } else{
                Integer e = ms.ceilingKey(x);
                if(e == null){
                    if(size < k){
                        ms.merge(y, 1, Integer::sum);
                        ans += 1;
                        ++size;
                    }
                } else{
                    ms.merge(e, -1, Integer::sum);
                    if(ms.get(e) == 0){ ms.remove(e); }
                    ms.merge(y, 1, Integer::sum);
                    ans += 1;
                }
            }
        }
        fast.println(ans);
        fast.close();
    }
}

class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar, numChars;

    // standard input
    public FastIO() { this(System.in, System.out); }
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
            } catch (IOException e) { throw new InputMismatchException(); }
            if (numChars == -1) return -1;  // end of file
        }
        return buf[curChar++];
    }

    // to read in entire lines, replace c <= ' '
    // with a function that checks whether c is a line break
    public String next() {
        int c;
        do { c = nextByte(); } while (c <= ' ');
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = nextByte();
        } while (c > ' ');
        return res.toString();
    }
    public int nextInt() {  // nextLong() would be implemented similarly
        int c;
        do { c = nextByte(); } while (c <= ' ');
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = nextByte();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }
    public double nextDouble() { return Double.parseDouble(next()); }
}