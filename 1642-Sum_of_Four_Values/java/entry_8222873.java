import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class entry_8222873 {
    public static void main(String[] args) throws IOException {
        final int n = reader.nextInt();
        final int x = reader.nextInt();
        final int[] arr = new int[n+1];
        for (int i=1; i <= n; i++) arr[i] = reader.nextInt();

        final Map<Integer, String> twoSumToIndices = new HashMap<>();
        for (int i=1; i <= n; i++) {
            for (int j=i+1; j <= n; j++) {
                final int complementSum = x - arr[i] - arr[j];
                if (twoSumToIndices.containsKey(complementSum)) {
                    System.out.println(i + " " + j + " " + twoSumToIndices.get(complementSum));
                    return;
                }
            }

            for (int j=i-1; j >= 1; j--)
                twoSumToIndices.put(arr[i] + arr[j], i + " " + j);
        }

        System.out.println("IMPOSSIBLE");
    }

    final static Reader reader = new Reader();
    static class Reader {
        private final DataInputStream din = new DataInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int bufferPointer, bytesRead;

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                bytesRead = din.read(buffer, bufferPointer = 0, 1 << 16);
                if (bytesRead == -1) buffer[0] = -1;
            }
            return buffer[bufferPointer++];
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }
    }

}