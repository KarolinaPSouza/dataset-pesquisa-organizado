import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class entry_1206470 {

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }


    static FastReader f = new FastReader();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");
    private static int m = (int)1e9 + 7;
    static int MAX = 500005;
    static long[] fact;

    static int[] inputArray(int n) throws IOException {
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++) {
            a[i] = f.nextInt();
        }
        return a;
    }

    static int gcd(int a , int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b , a % b);
    }

    static long mult(long a, long b)
    {
        return (a * (long)b % m);
    }

    static long modPow(long a, int step)
    {
        long ans = 1;
        while(step != 0)
        {
            if((step & 1) != 0)
                ans = mult(ans , a);
            a = mult(a , a);
            step >>= 1;
        }
        return ans;
    }

    static long longModulus(long x , long m) {
        long d = x / m;
        return x - d * m;
    }

    public static void main(String[] args) throws IOException {
        int n = f.nextInt();
        int a[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = f.nextInt();
            a[i][1] = f.nextInt();
            a[i][2] = f.nextInt();
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //System.out.println(Arrays.deepToString(a));
        long[]dp = new long[n+1];
        int[] next = new int[n];
        Arrays.fill(next , n);
        for(int i = 0 ; i < n ; i++) {
            int low = i + 1 , high = n - 1;
            while(low <= high) {
                int mid = (low + high) / 2;
                if(a[mid][0] <= a[i][1]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                    next[i] = mid;
                }
            }
        }
        dp[n] = 0;
        for(int i = n - 1; i >= 0 ; i--) {
            dp[i] = Math.max(dp[i+1] , a[i][2] + dp[next[i]]);
        }
        //Arrays.fill(dp , -1);
        System.out.println(dp[0]);
        //System.out.println(Arrays.toString(dp));
    }

    private static long Code(int a[][] , int n , int i , long[] dp , int[] next) {
        if(i == n) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        //take it
        dp[i] = Math.max(Code(a , n , i + 1 , dp , next) , a[i][2] + Code(a , n , next[i] , dp , next));
        return dp[i];
    }
}
/*
2
6
1 2 2 3 4 5
9
1 1 1 2 2 2 3 3 3
 */