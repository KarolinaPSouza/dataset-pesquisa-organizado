import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_14306396 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        long sum = 0;
        long min = 0;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += fs.nextInt();
            ans = Math.max(ans, sum  - min);
            min = Math.min(min, sum);

        }
        System.out.println(ans);
    }
}