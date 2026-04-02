import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class entry_15306441 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }


        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int needed = x - a[i];
            if (map.containsKey(needed)) {
                System.out.println((map.get(needed) + 1) + " " + (i + 1));
                return;
            }
            map.put(a[i], i);
        }

        System.out.println("IMPOSSIBLE");
    }



    static class FastReader {

        // BufferedReader to read input
        BufferedReader b;

        // StringTokenizer to tokenize input
        StringTokenizer s;

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() {
            return Integer.parseInt(next());
        }

        // Method to read the next token as a long
        long nextLong() {
            return Long.parseLong(next());
        }

        // Method to read the next token as a double
        double nextDouble() {
            return Double.parseDouble(next());
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}