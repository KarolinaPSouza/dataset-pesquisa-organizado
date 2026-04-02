import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import static java.lang.Math.max;


public class entry_2988547 {
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

        void close() throws IOException {
            br.close();
        }
    }
        public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        long a[] = new long[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextLong();
        }

        // basic kadane's algo

        long s = Long.MIN_VALUE, cs = 0, mx = Long.MIN_VALUE;
        for(int i = 0; i < n; i++){
            cs = max(cs + a[i], 0);
            s = max(cs, s);
            mx = max(mx, a[i]);
        }

        if(s != 0)
            System.out.println(s);
        else
            System.out.println(mx);
    }
}