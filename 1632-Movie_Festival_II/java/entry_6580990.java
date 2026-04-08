import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class entry_6580990 {
    void solve(Reader s) throws Exception {
        int n = s.nextInt(), k = s.nextInt();
        List<Pair> movies = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            movies.add(new Pair(s.nextInt(), s.nextInt()));
        }
        movies.sort(Comparator.comparingInt(Pair::getB));

        int count = 0;
        TreeSet<Integer> tickets = new TreeSet<>();
        HashMap<Integer, Integer> endCounts = new HashMap<>();
        tickets.add(0);
        endCounts.put(0, k);
        for (int i = 0; i < n; i++) {
            Integer floor = tickets.floor(movies.get(i).getA());
            //            out.println(floor);
            if(floor != null) {
                endCounts.put(floor, endCounts.get(floor) - 1);
                if(endCounts.get(floor) == 0) tickets.remove(floor);
                if(!endCounts.containsKey(movies.get(i).getB())) {
                    tickets.add(movies.get(i).getB());
                    endCounts.put(movies.get(i).getB(), 1);
                } else {
                    endCounts.put(movies.get(i).getB(), endCounts.get(movies.get(i).getB()) + 1);
                }

                count++;
            }
        }
        System.out.println(count);
    }

    private static class Pair {
        private final int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    private static int scanInt() throws IOException {
        return parseInt(scanString());
    }

    private static long scanLong() throws IOException {
        return parseLong(scanString());
    }

    private static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tok;

    public static void main(String[] args) {
        try {
            Reader s = new Reader();
            entry_6580990 obj = new entry_6580990();
            obj.solve(s);
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}