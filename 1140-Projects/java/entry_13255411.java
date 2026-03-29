import java.io.*;
import java.util.*;

public class entry_13255411 {
    public static void main(String[] args) {
        FastIO scanner = new FastIO();

        int n = Integer.parseInt(scanner.next());

        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int startDate = scanner.nextInt();
            int endDate = scanner.nextInt();
            int reward = scanner.nextInt();
            projects.add(new Project(startDate, endDate, reward));
        }

        // Ordenar por fecha final
        Collections.sort(projects, (p1, p2) -> Integer.compare(p1.endDate, p2.endDate));

        int[] startDates = new int[n];
        int[] endDates = new int[n];
        int[] rewards = new int[n];

        for (int i = 0; i < n; i++) {
            Project p = projects.get(i);
            startDates[i] = p.startDate;
            endDates[i] = p.endDate;
            rewards[i] = p.reward;
        }

        long[] maxMoney = new long[n];
        maxMoney[0] = rewards[0];

        for (int i = 1; i < n; i++) {
            int pos = binarySearch(endDates, startDates[i] - 1);
            if (pos != -1) {
                long val = maxMoney[pos] + rewards[i];
                maxMoney[i] = Math.max(val, maxMoney[i - 1]);
            } else {
                maxMoney[i] = Math.max(rewards[i], maxMoney[i - 1]);
            }
        }

        System.out.println(maxMoney[n - 1]);
    }

    // Retorna índice del mayor valor <= target o -1 si no existe
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static class Project {
        int startDate, endDate, reward;

        Project(int s, int e, int r) {
            this.startDate = s;
            this.endDate = e;
            this.reward = r;
        }
    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        public FastIO() {
            this(System.in, System.out);
        }

        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }

        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1;
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

        public int nextInt() {
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
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
    }
}
