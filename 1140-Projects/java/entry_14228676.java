//package CSES.dp;

import java.io.*;
import java.util.*;

// https://cses.fi/problemset/task/1140
public class entry_14228676 {

    static BufferedReader br;
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    // 1D dp + binary search
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        int events[][] = new int[n][3];
        int maxEnd = 0;
        for (int i = 0; i < n; i++) {
            events[i][0] = nextInt();
            events[i][1] = nextInt();
            events[i][2] = nextInt();
        }
        long dp[] = new long[n+1];
        Arrays.sort(events, Comparator.comparingInt((int[] a) -> a[1]));
        for (int i = 1; i <= n; i++) {
            long notTake = dp[i-1];
            int j = lastIndex(events,i-1); // find the largest end < start of i
            long take = events[i-1][2] + dp[j+1]; // as dp is 1 based not 0
            dp[i] = Math.max(notTake,take);
        }
        System.out.println(dp[n]);
    }

    private static int lastIndex(int[][] events, int i) {
        int l=-1,r=i;
        while(r-l>1){
            int mid= (l+r)/2;
            if(events[mid][1]<events[i][0]) l=mid;
            else r = mid;
        }
        return l;
    }

    // 2D dp
//    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        int n = nextInt();
//        int events[][] = new int[n][3];
//        int maxEnd = 0;
//        for (int i = 0; i < n; i++) {
//            events[i][0] = nextInt();
//            events[i][1] = nextInt();
//            events[i][2] = nextInt();
//            maxEnd = Math.max(maxEnd, events[i][1]);
//        }
//        int dp[][] = new int[n + 1][maxEnd + 1];
//        Arrays.sort(events, Comparator.comparingInt((int[] a) -> a[1]));
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= maxEnd; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (events[i - 1][1] <= j)
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][events[i - 1][0] - 1] + events[i - 1][2]);
//            }
//        }
//        System.out.println(dp[n][maxEnd]);
//    }
}