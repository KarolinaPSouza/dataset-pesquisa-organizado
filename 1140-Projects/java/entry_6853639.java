import java.util.*;
import java.io.*;

class cses {
//    public static void main(String[] args) {
//        FastReader fs = new FastReader();
//        int t = fs.nextInt();
//        int k = t;
//        List<List<Long>> arr = new ArrayList<>();
//        while (k-- > 0) {
//            List<Long> tw = new ArrayList<>();
//            tw.add(fs.nextLong());
//            tw.add(fs.nextLong());
//            tw.add(fs.nextLong());
//            arr.add(tw);
//        }
//        arr.sort((a, b) -> Math.toIntExact(a.get(0) - b.get(0)));
//        System.out.println(maximizeTheProfit(t, arr));
//    }

    public static int binSearch(Proj arr[], int i) {
        int lo = 0, hi = i - 1;
        while (lo <= hi) {
            int m = (lo + hi) / 2;
            if (arr[m].e < arr[i].s) {
                if (arr[m + 1].e < arr[i].s) {
                    lo = m + 1;
                } else {
                    return m;
                }
            } else {
                hi = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = fr.nextInt();
        Proj arr[] = new Proj[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Proj();
            arr[i].s = fr.nextLong();
            arr[i].e = fr.nextLong();
            arr[i].p = fr.nextLong();
        }
        Arrays.sort(arr, (o1, o2) -> {
            return (int) o1.e - (int) o2.e;
        });

        long dp[] = new long[n];
        dp[0] = arr[0].p;//base case
        for (int i = 1; i < n; i++) {
            long incl = arr[i].p; // including alone
            int idx = binSearch(arr, i);
            if (idx != -1) {
                incl += dp[idx];
            }
            long excl = dp[i - 1];
            dp[i] = Math.max(incl, excl);
        }
        out.println(dp[n - 1]);
        out.close();

    }

    static class Proj {
        long s, e, p;
    }

//    public static long maximizeTheProfit(int n, List<List<Long>> offers) {
//        long[] dp = new long[n + 1];
//        for (int i = n; i >= 0; i--) {
//            if (i == n) {
//                dp[i] = 0;
//            } else {
//                dp[i] = dp[i + 1];
//                int nextIdx = lowerBound(offers, offers.get(i).get(1) + 1);
//                long take = offers.get(i).get(2) + dp[nextIdx];
//                dp[i] = Math.max(take, dp[i]);
//            }
//
//        }
//        return dp[0];
//    }
//
//    static int lowerBound(List<List<Long>> a, long x) {
//        int l = -1, r = a.size();
//        while (l + 1 < r) {
//            int m = (l + r) >>> 1;
//            if (a.get(m).get(1) > x) r = m;
//            else l = m;
//        }
//        return r;
//    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
