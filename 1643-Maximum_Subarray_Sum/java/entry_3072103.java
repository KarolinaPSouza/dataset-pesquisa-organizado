import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class entry_3072103 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        int n = sc.nextInt();
        long maxSoFar = Long.MIN_VALUE;
        long maxEndingHere = 0;
        for (int i = 0; i < n; i++) {
            maxEndingHere += sc.nextInt();
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        writer.write(maxSoFar + "\n");
        writer.flush();
        writer.close();
    }

    static void shuffleArray(int[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}