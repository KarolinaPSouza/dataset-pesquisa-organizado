import java.util.*;
import java.util.Arrays;
import java.io.InputStream;

public class entry_3552764 {

    public static void main(String args[]) {

        FastScanner sc = new FastScanner(System.in);
        int numNodes = sc.nextInt();
        int numEdges = sc.nextInt();

        int[] relaxants = new int[numNodes];
        List<connectionDistance> arr = new ArrayList<connectionDistance>(numEdges);
        long[] sol = new long[numNodes];

        connectionDistance newConnection = null;
        for (int i = 0; i < numNodes; i++) {
            sol[i] = 100000000;
        }
        for (int i = 0; i < numEdges; i++) {
            try {
                newConnection = new connectionDistance((sc.nextInt() - 1), (sc.nextInt() - 1),
                        (sc.nextInt()));
            } catch (Exception ex) {

            }
            arr.add(newConnection);
        }
        int x = 0;
        sol[0] = 0;
        for (int i = 0; i < numNodes; i++) {
            x = -1;
            for (int j = 0; j < numEdges; j++) {
                int first = arr.get(j).getStart();
                int second = arr.get(j).getFinish();
                int dist = arr.get(j).getDist();
                if (sol[first] + dist < sol[second]) {
                    sol[second] = sol[first] + dist;
                    relaxants[second] = first;
                    x = second;
                }
            }
        }
        if (x == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            ArrayList<Integer> cycle = new ArrayList<>();
            for (int i = 0; i < numNodes; i++)
                x = relaxants[x];
            for (int i = x;; i = relaxants[i]) {
                cycle.add(i);
                if (i == x && cycle.size() > 1)
                    break;
            }

            for (int i = cycle.size() - 1; i >= 0; i--) {

                System.out.print((cycle.get(i) + 1) + " ");

            }
            System.out.println();
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (Exception e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }

    public static class connectionComparator implements Comparator<connectionDistance> {
        public int compare(connectionDistance c1, connectionDistance c2) {
            if (c1.getDist() > c2.getDist())
                return 1;
            else if (c1.getDist() < c2.getDist())
                return -1;
            return 0;
        }
    }

    public static class startComparator implements Comparator<connectionDistance> {
        public int compare(connectionDistance c1, connectionDistance c2) {
            if (c1.getStart() > c2.getStart())
                return 1;
            else if (c1.getStart() < c2.getStart())
                return -1;
            return 0;
        }
    }

    public static class connectionDistance {
        public connectionDistance(int begin, int finish, int dist) {
            _beginn = begin;
            _finishh = finish;
            _distt = dist;
        }

        public connectionDistance() {

        }

        public int _beginn;
        public int _finishh;
        public int _distt;

        public int getStart() {
            return _beginn;
        }

        public int getFinish() {
            return _finishh;
        }

        public int getDist() {
            return _distt;
        }

        public void setDist(int dist) {
            _distt = dist;
        }

        public void setProperties(int start, int finish) {
            _beginn = start;
            _finishh = finish;
        }
    }
}