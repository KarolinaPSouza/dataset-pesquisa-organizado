/*
https://www.spoj.com/problems/INOUTEST/                               TIME = 0.75         120MB
*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_2827251 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(input.readLine());
  int n = Integer.parseInt(st1.nextToken()), x = Integer.parseInt(st1.nextToken());

  StringTokenizer st2 = new StringTokenizer(input.readLine());
  int arr[]= new int[n];

  for (int i = 0; i < n; i++) {
   arr[i] = Integer.parseInt(st2.nextToken());
  }

  input.close();

        /*
  String s1=input.readLine().trim();
        String sarr[]=s1.split(" ");
        int n=Integer.parseInt(sarr[0]);
        int x=Integer.parseInt(sarr[1]);
          String s2=input.readLine().trim();
        String sarr2[]=s2.split(" ");
                int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(sarr2[i]);
        }
        */
        /*
        mem=new int[x+1];
        int res=solve(x);
        */
        int res=solve(arr,x);
        if(res==Integer.MAX_VALUE) res=-1;
     output.write(res+"\n");
        output.flush();
    }

    static int solve(int arr[], int amount){
        int dp[]=new int[amount+1];
        for(int rem=0;rem<=amount;rem++){
            if(rem==0){
                dp[rem]=0;
                continue;
            }
            int mincoins=Integer.MAX_VALUE;
            for(int i=0;i<arr.length;i++){
                if(rem-arr[i]>=0){
                    int r=dp[rem-arr[i]];
                    if(r!=Integer.MAX_VALUE){
                        if(r<mincoins){
                            mincoins=1+r;
                        }
                    }
                }
            }
            dp[rem]=mincoins;
        }
        return dp[dp.length-1];
    }

}