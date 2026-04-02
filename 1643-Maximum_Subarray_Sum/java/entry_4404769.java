import java.util.*;
import java.io.*;

public class entry_4404769 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n =  sc.nextInt();
        int[] arr = sc.nextIntArr(n);
        long sum=0;
        long tmp=0;
        long ans = (long) -1e18;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            ans=Math.max(ans,sum-tmp);
            tmp = Math.min(tmp,sum);
        }
        pw.println(ans);
        pw.close();
    }

//    static int dp(int idx1,int idx2){
//        if(idx1>=s1.length||idx2>=s2.length) return 0;
//        if(memo[idx1][idx2]!=-1) return memo[idx1][idx2];
//        int take = -1;
//        int leavea = dp(idx1,idx2+1);
//        int leaveb = dp(idx1+1,idx2);
//        if(s1[idx1]==s2[idx2])
//            take = 1 + dp(idx1+1,idx2+1);
//        return memo[idx1][idx2] = Math.max(Math.max(leavea,leaveb),take);
//    }
//
//    static void trace(int idx1, int idx2){
//        if(idx1>=s1.length||idx2>=s2.length) return;
//        int take = -1;
//        int leavea = dp(idx1,idx2+1);
//        int leaveb = dp(idx1+1,idx2);
//        if(s1[idx1]==s2[idx2])
//            take = 1 + dp(idx1+1,idx2+1);
//        int res = Math.max(Math.max(leavea,leaveb),take);
//        if(res==take) {
//            ans.add(s1[idx1]);
//            trace(idx1 + 1, idx2 + 1);
//        }
//        else if(res==leavea)
//            trace(idx1,idx2+1);
//        else if(res==leaveb)
//            trace(idx1+1,idx2);
//    }

//    static int dp(int rem){
//        if(rem<0)
//            return (int) 1e8;
//        if(memo[rem]!=-1) return memo[rem];
//        if(rem==0)
//            return 0;
//        int ans = (int) 1e9;
//        for(int i=0;i<n;i++){
//            int res = 1 + dp(rem-arr[i]);
//            if(res<ans) ans = res;
//        }
//        return memo[rem] = ans;
//    }

//    static int dp(int[] arr,int x) {
//        int[] memo = new int[x + 1];
//        for (int i : arr) {
//            if (i <= x)
//                memo[i] = 1;
//        }
//
//        for (int i = 0; i <= x; i++) {
//            if (memo[i] == 1) continue;
//            memo[i] = (int) 1e8;
//            for (int j = 0; j < arr.length; j++) {
//                if (i - arr[j] >= 0)
//                    memo[i] = Math.min(memo[i], 1 + memo[i - arr[j]]);
//            }
//        }
//        return memo[x] == (int) 1e8? -1 : memo[x];
//    }


//    static long dp(int rem){
//        if(rem==0) return 1;
//        if(rem<0) return 0;
//        if(memo[rem]!=-1) return memo[rem];
//        long ans = 0;
//        for(int i=0;i<n;i++){
//            ans+=dp(rem-arr[i]);
//        }
//        return ans%MOD;
//    }




    static int gcd ( int a, int b){
        return a == 0 ? b : gcd(b % a, a);
    }

    static int lcm ( int a, int b){
        return a * b / gcd(a, b);
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair p) {
            return x == p.x ? y - p.y : x - p.x;
        }

    }

    static class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        char c;

        Tuple(char c,int x,int y){
            this.c=c;
            this.x=x;
            this.y=y;
        }

        public int compareTo(Tuple t) {
            return x == t.x ? y - t.y : x - t.x;
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public long[] nextlongArr(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        public Long[] nextLongArr(int n) throws IOException {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        public int[] nextIntArr(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public Integer[] nextIntegerArr(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }



        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }

}