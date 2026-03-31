import java.io.*;
import java.util.*;

class Pair {
    int first, second;

    Pair(int a, int b) {
        first = a;
        second = b;
    }
}

public class entry_7730413 {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() { return Integer.parseInt(next()); } // reads in the next int
        public long nextLong() { return Long.parseLong(next()); } // reads in the next long
        public double nextDouble() { return Double.parseDouble(next()); } // reads in the next double
    }

    static InputReader f= new InputReader(System.in);
    static PrintWriter out= new PrintWriter(System.out);
    public static void main(String[] args) {
        // YOUR CODE HERE //! @ % & * () _ {} # ~ : < > ? "" | ^

        int n = f.nextInt();

        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int l, r;
            l = f.nextInt();
            r = f.nextInt();
            arr.add(new Pair(l, 1));
            arr.add(new Pair(r, -1));
        }

        Collections.sort(arr, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return Integer.compare(a.first, b.first);
            }
        });
        n = arr.size();
        int sum = 0, ans = 0;
        for (Pair p : arr) {
            sum += p.second;
            ans = Math.max(sum, ans);
        }

        out.println(ans);
        out.close(); // flushes the output once printing is done
    }
}