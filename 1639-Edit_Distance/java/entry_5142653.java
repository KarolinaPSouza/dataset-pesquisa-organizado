import java.io.*;
import java.util.*;

public class entry_5142653 {

    public static void main(String[] args) {

        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }




        FastReader scn = new FastReader();
        String a = scn.next();
        String b = scn.next();
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = i;

        }
        for (int i = 0; i <= b.length(); i++) {
            dp[0][i] = i;

        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                dp[i][j] = a.length() + b.length();
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j] , dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j] , 1 + dp[i - 1][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j] , 1 + dp[i][j - 1]);

                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);

    }

    static int answer(String a, String b , int i , int j, Integer[][] dp) {
        if (i < 0 && j < 0) {
            return 0;
        }
        if (i < 0 || j < 0) {
            return Math.max(i + 1, j + 1);
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int one = a.length() + b.length();
        int two = b.length() + b.length();
        int three = a.length() + b.length();
        if (a.charAt(i) == b.charAt(j)) {

            one = 0 + answer(a, b, i - 1, j - 1, dp);
        } else {
            one = 1 + answer(a, b, i - 1, j, dp);
            two = 1 + answer(a, b, i, j - 1, dp);
            three = 1 + answer(a, b, i - 1, j - 1, dp);
        }
        dp[i][j] = Math.min(one, Math.min(two, three));
        return Math.min(one, Math.min(two, three));


    }

    static int mod = (int)10e8 + 7;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                new InputStreamReader(System.in));
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

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

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


