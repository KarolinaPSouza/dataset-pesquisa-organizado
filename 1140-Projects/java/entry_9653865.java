// Working program with FastReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_9653865 {
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
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static long mod=1000000007;
    public static void main(String[] args) {
         FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        //Scanner sc=new Scanner(System.in);
        int mod=(int)(1e9+7);

        //
//        boolean[] prime = new boolean[(int)(1e6+ 3)];
//        Arrays.fill(prime, true);
//
//        for (int p = 2; p * p < prime.length; p++) {
//            if (prime[p]) {
//                for (int i = p * p; i < prime.length; i += p)
//                    prime[i] = false;
//            }
//        }
//
//        ArrayList<Integer> p=new ArrayList<>();
//        for (int i = 2; i < prime.length; i++) {
//            if (prime[i])
//                p.add(i);
//        }

        //
        int t=1;
        while (t>0){
            t--;
            int n=sc.nextInt();
            int[][] arr=new int[n][3];
            for (int i = 0; i < n; i++) {
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
                arr[i][2]=sc.nextInt();
            }

            Arrays.sort(arr,new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });

            long[] dp=new long[n+1];
            dp[1]=arr[0][2];
            for (int i = 1; i < n; i++) {
                int f=arr[i][0];

                int l=-1,h=i;
                while (h-l>1){
                    int mid=(h-l)/2+l;
                    if(arr[mid][1]<f) l=mid;
                    else h=mid;
                }

                    dp[i+1]=Math.max(arr[i][2]+dp[l+1],dp[i]);
            }

            pw.println(dp[n]);


            //
        }

        //flush
        pw.flush();

    }



    public static int helper(int[] arr,int z,int b,int zm,int ind,int[][] dp){
        int k=-1*ind+b-2*(zm-z);


        //  System.out.println(ind+" "+tmp+" "+b);
        if(ind==arr.length || k<0 || ind<0) return 0;
        if(dp[ind][z]!=-1) return dp[ind][z];
        int tr=0;
        int tl=0;
        // if(dp[ind][str]!=-1) return dp[ind][str];
        int scr=arr[ind];
        tr=helper(arr,z,b,zm,ind+1,dp);
        if(z>0) tl=helper(arr,z-1,b,zm,ind-1,dp);

        return dp[ind][z]=scr+Math.max(tr,tl);
    }


    public static boolean pred(int[][] arr,int mid,int[] val){
        int n= arr[0].length;
        int m= arr.length;

        for (int[] ints : arr) {
            int cnt = 0;
            int[] tmp = new int[n];
            System.arraycopy(val, 0, tmp, 0, n);
            for (int j = 0; j < n; j++) {
                if (ints[j] >= mid) {
                    cnt++;
                    tmp[j] = -1;
                }
            }
            if (cnt >= 2) {
                for (int j = 0; j < n; j++) {
                    if (tmp[j] >= mid) cnt++;
                }
            }

            if (cnt >= n) return true;
        }

        return  false;
    }



    public  static long binary(long[] arr,long t,int l){
        int r=arr.length;


        while (r-l>1){
            int m=(l+r)/2;
            if(arr[m]<=t) l=m;
            else r=m;
        }
        return l;
    }

    public static void sort(int[] arr) {
        shuffleArray(arr);
        Arrays.sort(arr);
    }
    public static void sort(char[] arr) {
        shuffleArray(arr);
        Arrays.sort(arr);
    }
    public static void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap arr[i] with arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void shuffleArray(char[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap arr[i] with arr[j]
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }



}