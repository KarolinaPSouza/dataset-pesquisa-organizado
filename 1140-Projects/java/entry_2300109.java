
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class entry_2300109 {
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 

        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }

     public static long[] randomize(long arr[])
    {
        Random rand = new Random();
for (int i = 0; i < arr.length; ++i) {
   int index = rand.nextInt(arr.length - i);
   long tmp = arr[arr.length - 1 - i];
   arr[arr.length - 1 - i] = arr[index];
   arr[index] = tmp;
}

return arr;
    } 
    static long mod = 1000000007;



    public static void main (String[] args) throws java.lang.Exception
    {
        FastReader sc = new FastReader();

        int test=sc.nextInt();
        long job[][] = new long[test][3];
       for(int i=0;i<test;i++)
       {
        for(int j=0;j<3;j++)
        {
            job[i][j]=sc.nextLong();
        }
       }



       Arrays.sort(job, (a,b)->((int)a[1]-(int)b[1]));
int n = test;
       long dp[] = new long[test];
       dp[0]=job[0][2];

       for(int i=1;i<n;i++)
       {

        long pa1 = job[i][2];

        int idx = bs(0,i-1,job,job[i][0]);

        long pa2 = 0;

        if(idx!=-1)
        pa2 = job[i][2]+dp[idx];

        dp[i] = pa1>pa2?pa1:pa2;

        dp[i] = dp[i]>dp[i-1]?dp[i]:dp[i-1];

       }

       System.out.println(dp[n-1]);


    }



    public static int bs(int start,int end, long a[][], long val)
    {
      //  System.out.println(start+" "+end+" "+val);
        int m = start +(-start+end)/2;

        while(start<=end)
        {

            m = start +(-start+end)/2;
            if(a[m][1]<val)
            {
                if(a[m+1][1]>=val)
                    return m;
                else
                    start = m+1;
            }
            else
                end= m-1;

         //   System.out.println("91");

        }

        return -1;
    }



}