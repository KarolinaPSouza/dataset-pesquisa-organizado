import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class entry_10230822 {

    private static final long MOD = (int) 1e9 + 7;
    private Reader reader;
    private OutputWriter writer;
    private MathUtils mathUtils;

    private void solve() throws IOException {
        int n  = reader.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            set.add(num);
        }
        writer.println(set.size());
    }

    public static void main(String[] args) throws Exception {

        entry_10230822 test = new entry_10230822();

        // console input output
        test.reader = new Reader();
        test.writer = new OutputWriter();

        // File input output
        // test.reader = new Reader("input.txt");
        // test.writer=new OutputWriter("output.txt");

        test.mathUtils = new MathUtils();

        test.solve();
        test.reader.close();
        test.writer.flush();
        test.writer.close();
    }

    static class MathUtils {

        public long gcd(long a, long b) {
            if (b == 0)
                return a;
            return gcd(b, a % b);
        }

        public long gcd(long... values) {
            long ans = gcd(values[0], values[1]);
            for (long value : values) {
                ans = gcd(ans, value);
            }
            return ans;
        }

        public long min(long... values) {
            long min = values[0];
            for (long value : values) {
                if (min > value) {
                    min = value;
                }
            }
            return min;
        }

        public long max(long... values) {
            long max = values[0];
            for (long value : values) {
                if (max < value) {
                    max = value;
                }
            }
            return max;
        }

        public boolean isEven(long value) {
            return (value & 1) == 0;
        }

        public boolean isOdd(long value) {
            return (value & 1) == 1;
        }

        public long powerMod(long num, long pow, long mod) {
            if (pow == 0 || num == 1)
                return 1;
            if (num == 0 || pow == 1)
                return num;

            long ans = powerMod(num, pow / 2, mod) % mod;

            ans = (ans * ans) % mod;

            if (pow % 2 != 0) {
                ans = (ans * num) % mod;
            }

            return ans;
        }

        public boolean[] SieveOfEratosthenes() {
            int n = (int) 1e7 + 7;
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            return isPrime;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream dataInputStream;
        private int bufferPointer, bytesRead;
        private byte[] buffer;

        public Reader() {
            this(System.in);
        }

        public Reader(String fileName) throws FileNotFoundException {
            this(new FileInputStream(fileName));
        }

        public Reader(InputStream inputStream) {
            this.dataInputStream = new DataInputStream(inputStream);
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = 0;
            this.bytesRead = 0;
        }

        public String nextToken() throws IOException {
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

        public int nextInt() throws IOException {
            return (int) readLong();
        }

        public long nextLong() throws IOException {
            return (long) readLong();
        }

        public float nextFloat() throws IOException {
            return (float) readDouble();
        }

        public double nextDouble() throws IOException {
            return readDouble();
        }

        private long readLong() throws IOException {
            long result = 0;
            boolean isNegative = false;
            byte b = nextByte();
            if (b == '-') {
                isNegative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                result = result * 10 + (b - '0');
                b = nextByte();
            }
            return isNegative ? -result : result;
        }

        private double readDouble() throws IOException {
            double result = 0, div = 1;
            boolean isNegative = false;
            byte b = nextByte();
            if (b == '-') {
                isNegative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                result = result * 10 + (b - '0');
                b = nextByte();
            }

            if (b == '.') {
                while ((b = nextByte()) >= '0' && b <= '9') {
                    result += (b - '0') / (div *= 10);
                }
            }

            if (isNegative) {
                result *= -1;
            }

            return result;
        }

        private byte nextByte() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = dataInputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        public void close() throws IOException {
            if (dataInputStream == null) {
                return;
            }
            dataInputStream.close();
        }
    }

    static class OutputWriter {
        private final PrintWriter printWriter;

        public OutputWriter() {
            this(System.out);
        }

        public OutputWriter(String fileName) throws FileNotFoundException {
            this(new FileOutputStream(fileName));
        }

        public OutputWriter(OutputStream outputStream) {
            printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    printWriter.print(' ');
                printWriter.print(objects[i]);
            }
        }

        public void print(List<? extends Object> objects) {
            for (int i = 0; i < objects.size(); i++) {
                if (i != 0)
                    printWriter.print(' ');
                printWriter.print(objects.get(i));
            }
        }

        // In case od interactive programs we can use flush to flush the output at that moment
        public void println(Object... objects) {
            print(objects);
            printWriter.println();
            printWriter.flush();
        }

        public void println(List<? extends Object> objects) {
            print(objects);
            printWriter.println();
            // printWriter.flush();
        }

        public void flush() {
            printWriter.flush();
        }

        public void close() {
            if (printWriter != null) {
                return;
            }
            printWriter.close();
        }
    }
}