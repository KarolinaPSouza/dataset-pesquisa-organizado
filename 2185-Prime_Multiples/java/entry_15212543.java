import java.io.*;
import java.util.*;

public class entry_15212543 {
    public static void main(String[] args) throws IOException {
        FastInput in = new FastInput(System.in);
        PrintWriter out = new PrintWriter(System.out);

        Solver solver = new Solver();
        solver.run(in, out);

        out.flush();
        out.close();
    }

    static class Solver {
        public void run(FastInput in, PrintWriter out) throws IOException {
            long limit = in.nextLong();
            int count = in.nextInt();

            ArrayList<Long> factors = new ArrayList<>();
            HashSet<Long> seen = new HashSet<>();

            for (int i = 0; i < count; i++) {
                long value = in.nextLong();
                if (seen.add(value)) {
                    factors.add(value);
                }
            }

            count = factors.size();
            long total = 0;

            for (int mask = 1; mask < (1 << count); mask++) {
                int bits = 0;
                long product = 1;
                boolean valid = true;

                for (int j = 0; j < count; j++) {
                    if ((mask & (1 << j)) != 0) {
                        bits++;
                        long temp = product;
                        if ((temp * factors.get(j)) / factors.get(j) != temp) {
                            valid = false;
                            break;
                        }
                        product *= factors.get(j);
                    }
                }

                if (!valid) continue;

                long multiples = limit / product;
                if (bits % 2 == 1) total += multiples;
                else total -= multiples;
            }

            out.println(total);
        }
    }

    static class FastInput {
        private static final int BUFFER_SIZE = 1 << 20;
        private final DataInputStream din;
        private final byte[] buffer;
        private int pointer, bytesRead;

        public FastInput(InputStream input) {
            din = new DataInputStream(input);
            buffer = new byte[BUFFER_SIZE];
            pointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int num = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                num = num * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -num : num;
        }

        public long nextLong() throws IOException {
            long num = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                num = num * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -num : num;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
            pointer = 0;
        }

        private byte read() throws IOException {
            if (pointer == bytesRead) {
                fillBuffer();
            }
            return buffer[pointer++];
        }
    }
}