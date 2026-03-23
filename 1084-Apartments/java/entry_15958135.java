import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class entry_15958135 {

    static Reader reader = new Reader();

    static StringBuilder out = new StringBuilder();

    static int counter = 0;

    static byte[][] grid = new byte[9][9];

    static byte[] path = new byte[48];

    public static void main(String[] args) {
        try {
            solve();
        } catch (Exception e) {
            out.append("Runtime error...");
        }

        System.out.print(out.toString());

    }

    public static void solve() throws IOException {

        int n = reader.nextInt();
        int m = reader.nextInt();
        int k = reader.nextInt();

        int[] applicants = new int[n];

        int[] appartments = new int[m];

        for (int i = 0; i < n; i++) {
            applicants[i] = reader.nextInt();
        }

        for (int i = 0; i < m; i++) {
            appartments[i] = reader.nextInt();
        }

        Arrays.sort(applicants);
        Arrays.sort(appartments);

        int i = 0, j = 0, counter = 0;

        while (i < n && j < m) {

            int applicant = applicants[i];
            int appartment = appartments[j];

            if (applicant < appartment - k) {
                i++;

            } else if (applicant > appartment + k) {
                j++;

            } else {
                counter++;
                i++;
                j++;
            }
        }

        out.append(counter);

    }

}

class Reader {
    private final InputStream in;
    private final byte[] buffer = new byte[1 << 16];
    private int index, size;

    public Reader() {
        in = System.in;
    }

    private int getByte() throws IOException {
        if (index >= size) {
            index = 0;
            size = in.read(buffer);
            if (size < 0)
                return -1;
        }
        return buffer[index++];
    }

    public char nextChar() throws IOException {
        int c;
        while ((c = getByte()) != -1 && c <= ' ') {
        }
        return (char) c;
    }

    public int nextInt() throws IOException {
        int c, sign = 1, val = 0;
        while ((c = getByte()) <= ' ') {
            if (c == -1)
                return 0;
        }
        if (c == '-') {
            sign = -1;
            c = getByte();
        }
        while (c > ' ') {
            val = val * 10 + c - '0';
            c = getByte();
        }
        return val * sign;
    }

    public long nextLong() throws IOException {
        int c;
        long sign = 1, val = 0;
        while ((c = getByte()) <= ' ') {
            if (c == -1)
                return 0;
        }
        if (c == '-') {
            sign = -1;
            c = getByte();
        }
        while (c > ' ') {
            val = val * 10 + c - '0';
            c = getByte();
        }
        return val * sign;
    }

    public double nextDouble() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = getByte()) <= ' ') {
            if (c == -1)
                return 0.0;
        }
        do {
            sb.append((char) c);
            c = getByte();
        } while (c > ' ');

        return Double.parseDouble(sb.toString());
    }

    public String nextLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = getByte()) != -1 && c != '\n') {
            if (c != '\r')
                sb.append((char) c);
        }
        return sb.toString();
    }
}