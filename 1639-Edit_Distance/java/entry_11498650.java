import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class entry_11498650 {
    public static void main(String[] args) {
        int mod = (int) 1e9 + 7;

        MyScanner in = new MyScanner();
        char[] s = in.nextCharArr();
        char[] t = in.nextCharArr();
        int m = s.length;
        int n = t.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=n;i++){
            dp[m][i] = n-i;
        }
        for(int j=0;j<=m;j++){
            dp[j][n] = m-j;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s[i]==t[j]){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = 1+Math.min(Math.min(dp[i + 1][j], dp[i + 1][j + 1]),dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }

    public static class MyScanner {
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

        int[] nextIntArr(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        int[] nextIntArr(int n, int v) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt() + v;
            }
            return a;
        }

        long[] nextLongArr(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        long[] nextLongArr(int n, long v) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong() + v;
            }
            return a;
        }

        double[] nextDoubleArr(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextDouble();
            }
            return a;
        }

        double[] nextDoubleArr(int n, double v) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextDouble() + v;
            }
            return a;
        }

        char nextChar() {
            return next().charAt(0);
        }

        char[] nextCharArr() {
            return next().toCharArray();
        }

    }

}