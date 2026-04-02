import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class entry_13310039 {

    static List<List<Integer>> adj;
    static boolean[] visited ;
    static boolean found = false;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        visited = new boolean[n];



        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> path = new ArrayList<>();
                dfs(i, -1, path);
            }
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static void dfs(int curr, int par, List<Integer> path) {
        if(found) return;
        if(visited[curr]) {
            int cycleStart = path.indexOf(curr);
            if(path.size() - cycleStart >= 3) {
                found = true;
                System.out.println(path.size() - cycleStart + 1);
                for(int i = cycleStart; i < path.size(); i++) {
                    System.out.print((path.get(i) + 1) + " ");
                }
                System.out.println((curr + 1));
                return;
            }
            return;
        }
        visited[curr] = true;
        path.add(curr);
        for(int neigh: adj.get(curr)){
            if(neigh != par){
                dfs(neigh, curr, path);
            }
        }
        path.remove(path.size()-1);
    }

    // FastScanner unchanged
    static class FastScanner {
        InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return buflen > 0;
            }
        }

        private int readByte() {
            if (hasNextByte())
                return buffer[ptr++];
            else
                return -1;
        }

        private boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr]))
                ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) throw new NumberFormatException();
            while (true) {
                if ('0' <= b && b <= '9') {
                    n = n * 10 + b - '0';
                } else if (b == -1 || !isPrintableChar(b)) {
                    return minus ? -n : n;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
                throw new NumberFormatException();
            return (int) nl;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}