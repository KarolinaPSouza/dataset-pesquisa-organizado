import java.io.*;
import java.util.*;

public class entry_15366817 {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();

        int n = in.nextInt();

        int[] events = new int[2 * n];

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            events[2 * i] = a * 2;
            events[2 * i + 1] = b * 2 + 1;
        }

        sort(events);

        int current = 0;
        int max = 0;

        for (int event : events) {
            if (event % 2 == 0) {
                current++;
                max = Math.max(max, current);
            } else {
                current--;
            }
        }

        System.out.println(max);
    }

    static void sort(int[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int j = rand.nextInt(a.length);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        Arrays.sort(a);
    }

    static class Reader {
        final int SIZE = 1 << 16;
        byte[] buffer = new byte[SIZE];
        int index, size;
        InputStream in = System.in;

        int nextInt() throws IOException {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);
            boolean neg = c == '-';
            if (neg) c = read();
            do n = n * 10 + c - '0'; while ((c = read()) > 32);
            return neg ? -n : n;
        }

        byte read() throws IOException {
            if (index == size) {
                size = in.read(buffer, 0, SIZE);
                index = 0;
            }
            return buffer[index++];
        }
    }
}