  /* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.math.BigInteger;

/* Name of the class has to be "Main" only if the class is public. */
public class entry_2114650 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

 public static void main (String[] args) throws java.lang.Exception
 {
  try {
   System.setIn(new FileInputStream("input.txt"));
   System.setOut(new PrintStream(new FileOutputStream("output.txt")));
  } catch (Exception e) {
   System.err.println("Error");
  }
  FastReader sc=new FastReader();
  int n=sc.nextInt();
  int b=sc.nextInt();
  int[] price=new int[n];
  int[] pages=new int[n];
  int[][] dp=new int[n+1][b+1];
  for(int i=0;i<n;i++)
   price[i]=sc.nextInt();
  for(int i=0;i<n;i++)
   pages[i]=sc.nextInt();
  for(int i=0;i<=n;i++)
   dp[i][0]=0;
  for(int i=0;i<=b;i++)
   dp[0][i]=0;
  for(int i=1;i<=n;i++)
  {
   for(int j=1;j<=b;j++)
   {
    if(j<price[i-1])
     dp[i][j]=dp[i-1][j];
    else if(j>=price[i-1])
    {
     dp[i][j]=Math.max(dp[i-1][j],pages[i-1]+dp[i-1][j-price[i-1]]);
    }

   }
  }
  System.out.println(dp[n][b]);

 }
}