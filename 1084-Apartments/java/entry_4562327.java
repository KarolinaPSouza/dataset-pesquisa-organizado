import java.io.*;
import java.util.*;

public class entry_4562327 {
    private static MyScanner sc;
    private static PrintWriter out;

    public static void main(String[] args) {
        sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> A = new ArrayList<>(n+1);
        for (int i = 0; i < n; i++)
            A.add(sc.nextInt());
        Collections.sort(A);

        ArrayList<Integer> B = new ArrayList<>(m+1);
        for (int i = 0; i < m; i++)
            B.add(sc.nextInt());
        Collections.sort(B);

        int count = 0;
        for (int i = 0, j = 0; i < n && j < m;) {
            int d = A.get(i) - B.get(j);
            if (Math.abs(d) <= k) {
                i++;
                j++;
                count++;
            } else if (d > 0) {
                j++;
            } else {
                i++;
            }
        }

        out.println(count);

        // Stop
        out.close();
    }

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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