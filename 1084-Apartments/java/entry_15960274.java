// The problem is asking to find Maximum number of applicants that can get the apartment. 
// There are many ways in which apartments can be assigned and one of them will be the optimal one, so this is an optimisation problem.
// Let's check the feasibility that we can give X applicants the apartments.
// Still need to check all the choices to find the feasibility of X, so feasibility is not determinitic so we cannot go with value based Optimisation therefore we need to go with choice based approach. 
// Choice based
// The choice is constrained, that means if we choose one value other choices will be affected. 
// Choosing the smallest apartment, always leaves maximum chance of assigning apartments to others, so invariant is after every choice there will be maximum number of apartments that can be assigned to others. Greedy is optimal here. 

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class entry_15960274 {

    static class FastScanner {

        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') {
                if (c == -1) {
                    return -1;
                }
            }
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String args[]) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        List<Integer> desiredSize = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            desiredSize.add(fs.nextInt());
        }
        Collections.sort(desiredSize);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < m; i++) {
            pq.add(fs.nextInt());
        }

        int result = 0;

        int index = 0;
        while (!pq.isEmpty()) {
            int top = pq.peek();
            if (index >= n) {
                break;
            }
            if (desiredSize.get(index) - k > top) {
                pq.poll();
                continue;
            }

            if (desiredSize.get(index) + k < top) {
                index += 1;
                continue;
            }

            result += 1;
            index += 1;
            pq.poll();
        }

        System.out.println(result);
    }
}