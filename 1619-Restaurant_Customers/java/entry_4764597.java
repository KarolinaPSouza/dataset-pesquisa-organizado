//package com.company;
import java.util.*;
import java.io.*;


public class entry_4764597 {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void prlong(Object object) throws IOException {

            bw.append("" + object);
        }

        public void prlongln(Object object) throws IOException {
            prlong(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }


    static long fun(long n, long x)
    {
        if(x>n)
            return x;
        n = n + x/2;
        n = n - (n%x);
        return n;
    }


    static int lower_bound(int array[], int key,int low ,int high)
    {
        // Initialize starting index and
        // ending index

        int mid;


        while (low < high) {

            mid = low + (high - low) / 2;


            if (key <= array[mid]) {
                high = mid;
            }

            else {

                low = mid + 1;
            }
        }


        if (low < array.length && array[low] < key) {
            low++;
        }

        return low;
    }

    static int upper_bound(int arr[], int key,int low ,int high)
    {
        int mid, N = arr.length;

        // Initialise starting index and
        // ending index


        // Till low is less than high
        while (low < high && low != N) {
            // Find the index of the middle element
            mid = low + (high - low) / 2;

            // If key is greater than or equal
            // to arr[mid], then find in
            // right subarray
            if (key >= arr[mid]) {
                low = mid + 1;
            }

            // If key is less than arr[mid]
            // then find in left subarray
            else {
                high = mid;
            }
        }

        // If key is greater than last element which is
        // array[n-1] then upper bound
        // does not exists in the array
        if (low == N ) {

            return -1;
        }

        return low;
    }



    static int  help(int grid[][],int i,int j ,int n ,int dp[][])
    {
        if(i==2-1&&j==n-1)
            return grid[i][j];

        if(i>=2||j>=n)
            return 100000;
        if(dp[i][j]!=-1)
            return dp[i][j];

        int op1 =grid[i][j]+help(grid,i+1,j,n,dp);
        int op2 =grid[i][j]+help(grid,i,j+1,n,dp);
        if(op1<op2)
            grid[i+1][j]=0;
        else grid[i][j+1]=0;

        return dp[i][j]=Math.min(op1,op2);






    }
    static int  help1(int grid[][],int i,int j ,int n ,int dp[][])
    {
        if(i==2-1&&j==n-1)
            return 0;

        if(i>=2||j>=n)
            return -1000000;
        if(dp[i][j]!=-1)
            return dp[i][j];

        int op1 =grid[i][j]+help(grid,i+1,j,n,dp);
        int op2 =grid[i][j]+help(grid,i,j+1,n,dp);


        return dp[i][j]=Math.max(op1,op2);






    }
    static  int ans ;
    static  void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {

                ans++;
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
    static void computeLPSArray(String pat, int M, int lps[])
    {

        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();

            long testCases=1;

            while(testCases-- > 0) {


                int n =in.nextInt();
 int ar[]=new int[n];
 int dep[]=new int[n];
 for(int i =0;i<n;i++)
 {
     ar[i]=in.nextInt();
     dep[i]=in.nextInt();
 }
     Arrays.sort(ar);
 Arrays.sort(dep);

 int i =1;int j =0;int need=1;int ans =1;
 while(i<n&&j<n)
 {
     if(ar[i]>dep[j])
     {
         j++;
         need--;
     }
     else {
         i++;
         need++;
     }
ans =Math.max(ans,need);
 }

                System.out.println(ans);






            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}