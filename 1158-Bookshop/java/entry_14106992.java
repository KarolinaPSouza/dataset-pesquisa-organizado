import java.io.*;
import java.util.*;

public class entry_14106992 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

    public static void main(String[] args) {

        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        // int T = in.nextInt();
        int T = 1;

        while (T-- > 0) {

            int n = in.nextInt();
            //String s = in.next();
            int x = in.nextInt();
            // int arr[] = new int[n];
            // for (int i = 0; i < n; i++) {
            //     arr[i] = in.nextInt();
            // }
            int pr[] = new int[n];
            for (int i = 0; i < n; i++) {
                pr[i] = in.nextInt();
            }
            int pg[] = new int[n];
            for (int i = 0; i < n; i++) {
                pg[i] = in.nextInt();
            }
            long curr[] = new long[x + 1];
            long prev[] = new long[x + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= x; j++) {

                    if (pr[i - 1] <= j){
                        curr[j] = Math.max(
                        pg[i-1]+prev[j-pr[i-1]],
                        prev[j]    
                        );

                    } 
                    else {
                        curr[j] = prev[j];
                    }
                }
                prev = curr.clone();
            }

            out.println(prev[x]);

        }

        out.flush();
        out.close();
    }

}