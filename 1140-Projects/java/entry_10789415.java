import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

public class entry_10789415 {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        ArrayList<pair> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            int f=fs.nextInt();
            int s=fs.nextInt();
            int t=fs.nextInt();
            arr.add(new pair(f,s,t));
        }
        Collections.sort(arr);
        long dp[]=new long[n+1];
        for(int i=1;i<=n;i++){
            long notpick=dp[i-1];
            long pick=arr.get(i-1).third;
            int low=0;
            int high=i-2;
            int starttime=arr.get(i-1).first;
            long ans=0;
            while(low<=high){
//                System.out.println("djkna");
                int mid=(low+high)/2;
                int prev_endtime=arr.get(mid).second;
                if(starttime>prev_endtime){
                    ans=dp[mid+1];
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            pick+=ans;

            dp[i]=max(pick,notpick);
        }

//        for(pair p:arr)
//            System.out.println(p.first+" "+p.second+" "+p.third);
//
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);
    }
    static class pair implements Comparable<pair>{
        int first;
        int second;
        int third;
        pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
        public int compareTo(pair p){
            return this.second-p.second;
        }
    }
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static final int mod = (int)1e9+7;


    static long add(long a, long b) {
        return (a%mod + b%mod) % mod;
    }

    static long sub(long a, long b) {
        return ((a%mod - b%mod) % mod + mod) % mod;
    }

    static long mul(long a, long b) {
        return (a%mod * b%mod) % mod;
    }

    static long exp(long base, long exp) {
        if (exp == 0)
            return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0)
            return mul(half, half);
        return mul(half, mul(half, base));
    }
    static long inverse(long b) {   /// Fermats little theorem b^(-1)=b^(mod-2)  % mod;
        return exp(b,mod-2);
    }

    static long div(long a,long b) {    /// a*inverse(b)
        long inv=inverse(b);
        return mul(a,inv);
    }

//    static long[] factorials = new long[2_000_001];
//    static long[] invFactorials = new long[2_000_001];
//
//    static void precompFacts() {
//        factorials[0] = invFactorials[0] = 1;
//        for (int i = 1; i < factorials.length; i++)
//            factorials[i] = mul(factorials[i - 1], i);
//        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
//        for (int i = invFactorials.length - 2; i >= 0; i--)
//            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
//    }
//
//    static long nCk(int n, int k) {
//        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
//    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    public static boolean[] Seive(int n){ //O(nlog(logn))
        boolean prime[]=new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0]=false;
        for(int i=2;i*i<=n;i++){
            if(prime[i]==false)continue;
            for(int j=i*i;j<=n;j=j+i){
                prime[j]=false;
            }
        }
        return prime;
    }
    public static int mex(List<Integer> a) {
        int n = a.size();
        boolean[] found = new boolean[n + 1];

        // Mark the numbers that are present in the array
        for (int num : a) {
            if (num <= n) {
                found[num] = true;
            }
        }

        // Find the smallest missing number
        int mex = 0;
        while (mex <= n && found[mex]) {
            mex++;
        }
        return mex;
    }
}