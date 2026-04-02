import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class entry_8712481 {

    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    static int mod =1000000007;

    public static void solve() {
        int n=in.nextInt();
        int x=in.nextInt();
        int[] c=in.nextIntArray(n);
        int[] dp=new int[x+1];
        dp[0]=1;
        for(int i=0;i<=x;i++){
            for(int j=0;j<n;j++){
                if(dp[i]>0 && i+c[j]<=x){
                    dp[i+c[j]]+=dp[i];
                    dp[i+c[j]]%=mod;
                }
            }
        }
        out.println(dp[x]);
        out.flush();
    }

    // removing duplicates
    public static ArrayList<Long> removeDuplicates(ArrayList<Long> list) {
        Set<Long> set = new HashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        Collections.sort(list);
        return list;
    }

    // swap
    public static long[] swap(long a,long b){return new long[]{b,a};};

    // Pair class
    static class Pair<F, S> {
        F f;
        S s;

        public Pair(F first, S second) {
            this.f = first;
            this.s = second;
        }

    }

    // output writer class
    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void println() {
            writer.println();
        }

        public void print(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(int[] array) {
            print(array);
            writer.println();
        }

        public void print(long[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(long[] array) {
            print(array);
            writer.println();
        }

        public <T> void print(List<T> array) {
            for (int i = 0; i < array.size(); i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array.get(i));
            }
        }

        public <T> void println(List<T> array) {
            print(array);
            writer.println();
        }

        public void separateLines(int[] array) {
            for (int i : array) {
                println(i);
            }
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }

    // input reader class
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder sum = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    sum.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return sum.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public String nextLine() {
            return readLine();
        }

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double sum = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return sum * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return sum * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    sum += (c - '0') * m;
                    c = read();
                }
            }
            return sum * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i)
                array[i] = nextInt();
            return array;
        }

        public int[] nextSortedIntArray(int n) {
            int array[] = nextIntArray(n);
            Arrays.sort(array);
            return array;
        }

        public int[] nextSumIntArray(int n) {
            int[] array = new int[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i)
                array[i] = array[i - 1] + nextInt();
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; ++i)
                array[i] = nextLong();
            return array;
        }

        public long[] nextSumLongArray(int n) {
            long[] array = new long[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i)
                array[i] = array[i - 1] + nextInt();
            return array;
        }

        public long[] nextSortedLongArray(int n) {
            long array[] = nextLongArray(n);
            Arrays.sort(array);
            return array;
        }

    }
}