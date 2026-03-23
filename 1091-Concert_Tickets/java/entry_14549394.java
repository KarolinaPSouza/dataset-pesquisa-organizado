import java.io.*;
import java.util.*;

public class entry_14549394 {
    public static void main(String[] args) throws IOException {
        UltimateFastIO r = new UltimateFastIO();
        PrintWriter pw = new PrintWriter(System.out);

        int n = r.nextInt();
        int m = r.nextInt();

        // Read prices into TreeMap - this is actually the fastest for this problem
        TreeMap<Integer, Integer> prices = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int price = r.nextInt();
            prices.put(price, prices.getOrDefault(price, 0) + 1);
        }

        // Process each query immediately
        for (int i = 0; i < m; i++) {
            int maxPrice = r.nextInt();

            // Find largest price <= maxPrice
            Map.Entry<Integer, Integer> entry = prices.floorEntry(maxPrice);

            if (entry == null) {
                pw.println(-1);
            } else {
                int price = entry.getKey();
                int count = entry.getValue();

                pw.println(price);

                // Update count
                if (count == 1) {
                    prices.remove(price);
                } else {
                    prices.put(price, count - 1);
                }
            }
        }

        pw.flush();
        pw.close();
    }

    static class UltimateFastIO {
    private InputStream is = System.in;
    private byte[] buffer = new byte[1 << 20]; // 1MB buffer (larger than DataInputStream)
    private int bufferPointer = 0, bytesRead = 0;

    // Optimized integer parsing with bit shifts
    public int nextInt() throws IOException {
        int c = read();
        while (c <= 32) c = read();
        boolean neg = c == 45;
        if (neg) c = read();
        int res = 0;
        do {
            res = (res << 3) + (res << 1) + (c & 15); // res * 10 + digit
        } while ((c = read()) > 32);
        return neg ? -res : res;
    }

    public long nextLong() throws IOException {
        long c = read();
        while (c <= 32) c = read();
        boolean neg = c == 45;
        if (neg) c = read();
        long res = 0;
        do {
            res = (res << 3) + (res << 1) + (c & 15);
        } while ((c = read()) > 32);
        return neg ? -res : res;
    }

    // Even faster for positive integers only
    public int nextPositiveInt() throws IOException {
        int c = read();
        while (c <= 32) c = read();
        int res = 0;
        do {
            res = (res << 3) + (res << 1) + (c & 15);
        } while ((c = read()) > 32);
        return res;
    }

    private int read() throws IOException {
        if (bufferPointer == bytesRead) {
            bytesRead = is.read(buffer, bufferPointer = 0, buffer.length);
            if (bytesRead == -1) return -1;
        }
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        is.close();
    }
}
}