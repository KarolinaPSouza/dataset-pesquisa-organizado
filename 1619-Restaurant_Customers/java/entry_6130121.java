import java.util.*;
import java.io.*;

public class entry_6130121 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int a = io.nextInt(), b = io.nextInt();
            mp.put(a, 1);
            mp.put(b, -1);
        }
        int currMax = 0, ans = 0;
        for (int i : mp.values()) {
            currMax += i;
            ans = Math.max(currMax, ans);
        }
        io.println(ans);
        io.close();
    }

    private static class Kattio extends PrintWriter {
        private BufferedReader br;
        private StringTokenizer st;

        private String line, token;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            br = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public String next() {
            return nextToken();
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

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = br.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
}