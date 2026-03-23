import java.io.IOException;

public class entry_15975153 {

    static Reader reader;

    static StringBuilder out = new StringBuilder();

    static int[] tickets;

    static int[] indexes;

    public static void main(String[] args) {
        try {
            reader = new Reader();
            solve();
        } catch (Exception e) {
            out.append(e.getMessage());
        }

        System.out.print(out.toString());
    }

    public static int findLowerIndex(int floor, int ceil, int target) {

        if (tickets[floor] > target) {
            return -1;
        }

        if (tickets[ceil] <= target) {
            return ceil;
        }

        if (ceil - floor == 1) {
            return floor;
        }

        int middle = (ceil + floor) / 2;

        if (tickets[middle] > target) {
            return findLowerIndex(floor, middle, target);
        } else {
            return findLowerIndex(middle, ceil, target);
        }
    }

    public static int[] findIndexValuePair(int i) {

        if (indexes[i] == Integer.MIN_VALUE) {
            int[] pair = { i, -1 };
            return pair;

        }

        if (indexes[i] == -1) {
            if (i == 0) {
                indexes[0] = Integer.MIN_VALUE;
            } else {
                indexes[i] = i - 1;
            }

            int[] pair = { i, tickets[i] };
            return pair;
        }

        int[] pair = findIndexValuePair(indexes[i]);

        indexes[i] = pair[0];

        return pair;
    }

    public static void solve() throws IOException {

        int t = reader.nextInt();

        int c = reader.nextInt();

        indexes = new int[t];

        tickets = new int[t];

        for (int i = 0; i < t; i++) {
            indexes[i] = -1;
            tickets[i] = reader.nextInt();
        }

        Radix.sort(tickets);

        for (int i = 0; i < c; i++) {
            int customer = reader.nextInt();
            int index = findLowerIndex(0, t - 1, customer);
            if (index == -1) {
                out.append(-1);
            } else {
                int[] indexValue = findIndexValuePair(index);
                out.append(indexValue[1]);
            }

            out.append('\n');
        }

    }

}

class Reader {
    private final byte[] buffer;
    private int pos;

    public Reader() throws IOException {

        buffer = new byte[System.in.available() + 1];
        buffer[buffer.length - 1] = '\n';
        System.in.read(buffer);
        pos = 0;
    }

    private byte getByte() {
        return buffer[pos++];
    }

    public char nextChar() {
        int c;
        while ((c = getByte()) <= ' ') {
        }
        return (char) c;
    }

    public int nextInt() {
        int c;
        int sign = 1;
        int val = 0;

        // Pula espaços
        while ((c = getByte()) <= ' ') {
        }

        // Verifica sinal negativo
        if (c == '-') {
            sign = -1;
            c = getByte();
        }

        // Lê dígitos
        while (c > ' ') {
            val = val * 10 + c - '0';
            c = getByte();
        }

        return val * sign;
    }

    public long nextLong() {
        int c;
        long sign = 1;
        long val = 0;

        while ((c = getByte()) <= ' ') {
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

    public double nextDouble() {
        StringBuilder sb = new StringBuilder();
        int c;

        while ((c = getByte()) <= ' ') {
        }

        do {
            sb.append((char) c);
            c = getByte();
        } while (c > ' ');

        return Double.parseDouble(sb.toString());
    }

    public String nextLine() {
        StringBuilder sb = new StringBuilder();
        int c;

        while ((c = getByte()) != '\n') {
            if (c != '\r')
                sb.append((char) c);
        }

        return sb.toString();
    }
}

class Radix {

    public static void sort(int[] a) {
        if (a == null || a.length <= 1)
            return;

        int n = a.length;
        int[] aux = new int[n];
        int[] count = new int[256];

        int[] from = a;
        int[] to = aux;

        for (int shift = 0; shift < 32; shift += 8) {

            for (int i = 0; i < 256; i++)
                count[i] = 0;

            for (int v : from) {
                count[(v >> shift) & 0xFF]++;
            }

            for (int i = 1; i < 256; i++) {
                count[i] += count[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int b = (from[i] >> shift) & 0xFF;
                to[--count[b]] = from[i];
            }

            int[] tmp = from;
            from = to;
            to = tmp;
        }

        if (from != a) {
            System.arraycopy(from, 0, a, 0, n);
        }
    }

    public static void sort(long[] a) {
        if (a == null || a.length <= 1)
            return;

        int n = a.length;
        long[] aux = new long[n];
        int[] count = new int[256];

        long[] from = a;
        long[] to = aux;

        for (int shift = 0; shift < 64; shift += 8) {
            for (int i = 0; i < 256; i++)
                count[i] = 0;

            for (long v : from) {
                count[(int) ((v >> shift) & 0xFF)]++;
            }

            for (int i = 1; i < 256; i++) {
                count[i] += count[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int b = (int) ((from[i] >> shift) & 0xFF);
                to[--count[b]] = from[i];
            }

            long[] tmp = from;
            from = to;
            to = tmp;
        }

        if (from != a) {
            System.arraycopy(from, 0, a, 0, n);
        }
    }
}