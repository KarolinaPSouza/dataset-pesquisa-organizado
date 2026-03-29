import java.io.*;
import java.util.*;

public class entry_15432637 {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        Project[] projects = new Project[n];

        for (int i = 0; i < n; i++) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            long p = fs.nextLong();
            projects[i] = new Project(a, b, p);
        }

        // Sort by ending day b
        Arrays.sort(projects, Comparator.comparingLong(o -> o.b));

        // DP lists
        ArrayList<Long> dpEnd = new ArrayList<>();
        ArrayList<Long> dpBest = new ArrayList<>();

        dpEnd.add(0L);
        dpBest.add(0L);

        for (Project pr : projects) {
            long a = pr.a;
            long b = pr.b;
            long p = pr.p;

            // Binary search dpEnd for last end < a
            int idx = upperBound(dpEnd, a - 1) - 1;
            long cur = dpBest.get(idx) + p;

            if (cur > dpBest.get(dpBest.size() - 1)) {
                dpEnd.add(b);
                dpBest.add(cur);
            }
        }

        System.out.println(dpBest.get(dpBest.size() - 1));
    }

    // upper_bound implementation (first element > val)
    static int upperBound(ArrayList<Long> list, long val) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (list.get(mid) <= val) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    // Fast scanner for competitive programming
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

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
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            long val = c - '0';
            while ((c = read()) > ' ') {
                val = val * 10 + (c - '0');
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    static class Project {
        long a, b, p;
        Project(long a, long b, long p) {
            this.a = a;
            this.b = b;
            this.p = p;
        }
    }
}