import java.io.*;
import java.util.*;

public class entry_15686408 {
    static IOHandler io;

    public static void main(String[] args) throws IOException {
        io = new IOHandler();
        int t = 1;
//        int t = io.nextInt();
        for(int i = 0; i < t; i++) solve();
        io.close();
    }

    public static void solve() throws IOException {
        int n = io.nextInt();
        int x = io.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            int a = io.nextInt();
            int d = x - a;
            if (map.containsKey(d)) {
                io.print(i + " " + map.get(d));
                return;
            }
            map.put(a, i);
        }
        io.println("IMPOSSIBLE");
    }
}

class IOHandler extends PrintWriter {
    private BufferedReader br;
    private StringTokenizer st;

    public IOHandler() {
        this(System.in, System.out);
    }

    public IOHandler(InputStream i, OutputStream o) {
        super(o);
        br = new BufferedReader(new InputStreamReader(i));
    }

    public IOHandler(String problemName) throws IOException {
        super(problemName + ".out");
        br = new BufferedReader(new FileReader(problemName + ".in"));
    }

    public String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        } catch (Exception e) {
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }
}