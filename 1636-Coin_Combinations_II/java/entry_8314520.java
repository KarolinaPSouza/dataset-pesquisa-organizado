
import java.util.*;
import java.io.*;
class FastIO {
    InputStream dis;
    byte[] buffer = new byte[1 << 17];
    int pointer = 0;

    public FastIO(String fileName) throws Exception {
        dis = new FileInputStream(fileName);
    }

    public FastIO(InputStream is) throws Exception {
        dis = is;
    }

    int nextInt() throws Exception {
        int ret = 0;

        byte b;
        do {
            b = nextByte();
        } while (b <= ' ');
        boolean negative = false;
        if (b == '-') {
            negative = true;
            b = nextByte();
        }
        while (b >= '0' && b <= '9') {
            ret = 10 * ret + b - '0';
            b = nextByte();
        }

        return (negative) ? -ret : ret;
    }

    long nextLong() throws Exception {
        long ret = 0;

        byte b;
        do {
            b = nextByte();
        } while (b <= ' ');
        boolean negative = false;
        if (b == '-') {
            negative = true;
            b = nextByte();
        }
        while (b >= '0' && b <= '9') {
            ret = 10 * ret + b - '0';
            b = nextByte();
        }

        return (negative) ? -ret : ret;
    }

    byte nextByte() throws Exception {
        if (pointer == buffer.length) {
            dis.read(buffer, 0, buffer.length);
            pointer = 0;
        }
        return buffer[pointer++];
    }

    String next() throws Exception {
        StringBuffer ret = new StringBuffer();

        byte b;
        do {
            b = nextByte();
        } while (b <= ' ');
        while (b > ' ') {
            ret.appendCodePoint(b);
            b = nextByte();
        }

        return ret.toString();
    }

}

public class entry_8314520 {
    //    static couldify couldify = new couldify();
//
//    public static void main(String[] args) {
//       int n = 8; // Number of threads
//        for (int i = 0; i < n; i++) {
//            Thread object
//                = new Thread(new couldify());
//            object.start();
//        }
////        couldify.fun1();
//
//    }
    public static void main(String[] args) throws Exception {
        FastIO fi = new FastIO(System.in);
        int n = fi.nextInt();
        int x = fi.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = fi.nextInt();
        }
        long[] dp = new long[x + 1];
        dp[0] = 1;
        for (int j : coins) {
        for (int i = 1; i <= x; i++) {

                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                    dp[i] %= 1000000007;
                }
            }
        }
        System.out.println(dp[x]);


    }



    public static int  minCoinSum(int[] arr, int n, int sum, int[] dp){
        if(sum<0)return Integer.MAX_VALUE;
        if(sum==0)return 0;
        if(dp[sum]!=-2)return dp[sum];
        int best = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int curr = minCoinSum(arr,n,sum-arr[i],dp);
            if(curr!= Integer.MAX_VALUE)
                best = Math.min(best,curr+1);
        }
        return dp[sum]=best;
    }



    static void comb(int n){
        long[] dp = new long[n+7];
        dp[1]=1;
        for (int i = 2; i <= n; i++)
            if (i<7) dp[i] = 2*dp[i-1];
            else dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4]+dp[i-5]+dp[i-6])%(1000000007);
        System.out.println(dp[n]%(1000000007));

    }

    public static long minRound(long arr[],int n){
        long pre=1;
        long count=0;
        for(int i=1;i<n;i++){
            if(pre>arr[i]){
                count++;
            }
            pre=arr[i];
        }
        return count;
    }
    public static int[] getTrucksForItems(int[] trucks, int[] items) {
        PriorityQueue<Truck> maxP = new PriorityQueue<>((a, b) -> {
            if(a.cap!=b.cap){
                return Integer.compare(a.cap, b.cap);
            }
            else{
                return Integer.compare(a.ind, b.ind);
            }
        });
        for(int i=0;i<trucks.length;i++){
            maxP.add(new Truck(trucks[i],i));
        }
        int ans[]=new int[items.length];
        for(int i=0;i<items.length;i++){
            int temp = -1;
            while(!maxP.isEmpty()&&items[i]>=maxP.peek().cap){
                maxP.poll();
            }
            if(!maxP.isEmpty()&&maxP.size()>0){
                temp=maxP.poll().ind;
            }
            ans[i]=temp;
        }
        return ans;
    }
    public static long Pipeline(long n, long k){
    long ans = Long.MAX_VALUE;
    long l = 0;
    long h=k-1;
    while(l<=h){
        long mid = l+(h-l)/2;

        if(isPossible(k,n-1,mid)){
            ans = Math.min(ans,mid);
            h=mid-1;
        }
        else{
            l=mid+1;
        }
    }
    return ans;
    }
    public static boolean isPossible(long k, long pipe,long m){
        return m/2*((2*m-k-1)*k)>=pipe;
    }
    public static int Nykka(int arr[]){
        int re[]=new int[arr.length];
        Arrays.fill(re,1);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                re[i]=re[i-1]+1;
            }
        }
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                re[i]=re[i+1]+1;
            }
        }
        int ans=0;
        for(int i:re)ans+=i;
        return ans;
    }
    public static int Amazon(int arr[],int k){
        int ans=0;
        int l=0;
        int r=0;
        int min=0;
        int max=0;
        while(l<=r&&r<arr.length){
            while(l<=r&&Math.abs(min-max)>k){
                l++;
//                min=Math.min(min,)
            }
        }

        return ans;
    }

}

class Truck{
    int cap;
    int ind;
    public Truck(int cap,int ind){
        this.cap=cap;
        this.ind=ind;
    }
}