import java.io.*;
import java.util.*;

public class entry_15039449 {

    static long mod = 1000000000l + 7;

    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = System.in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = readByte(); }
            for (; c >= '0' && c <= '9'; c = readByte()) val = val * 10 + (c - '0');
            return val * sign;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = fr.nextInt();
        int x = fr.nextInt();

        int arr[] = new int[n];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
            if (map.containsKey(x - arr[i])) {
                out.println(map.get(x - arr[i]) + " " + (i + 1));
                out.flush();
                return;
            }

            map.put(arr[i], i + 1);
        }
        out.println("IMPOSSIBLE");
        out.flush();
    }
}