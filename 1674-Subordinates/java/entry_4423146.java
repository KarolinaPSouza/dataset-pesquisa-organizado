import java.util.*;
import java.io.*;

public class entry_4423146 extends Helper {
    private static SuperFastReader sc = new SuperFastReader();
    // private static final FastReader sc = new FastReader();
    // private static final Scanner sc = new Scanner(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    private static final int MOD = (int) (1e9) + 7;// ((a + b) % MOD + MOD) % MOD
    // static {
    // try {
    // sc = new SuperFastReader("input.txt");
    // out = new PrintWriter("output.txt");
    // } catch (Exception e) {
    // debug(e);
    // }
    // }

    public static void main(String[] args) throws IOException {
        // int t = sc.Int();
        // for (int i = 1; i <= t; ++i) {
        //     // System.out.print("Case #" + i + ": ");
        //     solve();
        // }
        solve();
        sc.close();
        out.close();
    }

    public static void solve() throws IOException {
        int n = sc.Int();
        int a[] = new int[n + 1];
        int ans[] = new int[n + 1];
        int deg[] = new int[n + 1];
        for(int i = 2;i <= n;i++){
            a[i] = sc.Int();
            deg[a[i]]++;
        }
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 2;i <= n;i++){
            if(deg[i] == 0){
                q.push(i);
            }
        }
        for(;!q.isEmpty();){
            int t = q.pop();
            ans[a[t]] += ans[t] + 1;
            deg[a[t]]--;
            if(deg[a[t]] == 0){
                q.push(a[t]);
            }
        }
        for(int i = 1;i <= n;i++){
            print(ans[i] + " ");
        }
        println();
    }

    public static <T> void debug(T data) {
        System.out.println(data);
    }

    public static <T> void print(T data) {
        out.print(data);
    }

    public static <T> void println(T data) {
        out.println(data);
    }

    public static void println() {
        out.println();
    }

    public static void read(int arr[]) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.Int();
        }
    }

    public static void read(long arr[]) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.Long();
        }
    }

    public static void read(String arr[]) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
    }

    public static void read(int mat[][]) throws IOException {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.Int();
            }
        }
    }

    public static void read(long mat[][]) throws IOException {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.Long();
            }
        }
    }

}

class Pair<K, V> {
    public K key;
    public V value;

    Pair(K k, V v) {
        key = k;
        value = v;
    }
}

class SuperFastReader {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar, numChars;

    // standard input
    public SuperFastReader() {
        stream = System.in;
    }

    // file input
    public SuperFastReader(String file) throws IOException {
        stream = new FileInputStream(file);
    }

    private int nextByte() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars == -1)
                return -1; // end of file
        }
        return buf[curChar++];
    }

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
        return res.toString().trim(); // .trim() used to remove '\n' from either ends
    }

    public int Int() {
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

    public long Long() {
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = nextByte();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public double Double() {
        return Double.parseDouble(next());
    }

    public char Char() {
        return next().charAt(0);
    }

    public void close() throws IOException {
        stream.close();
    }
}

class Helper {

}