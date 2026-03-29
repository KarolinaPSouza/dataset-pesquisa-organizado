//package com.aakash.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_9967396 {
    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer s2
                = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(s2.nextToken());
        int m = Integer.parseInt(s2.nextToken());
        int[][] arr=new int[m][3];
        for(int i=0;i<m;i++) {
            StringTokenizer s3
                    = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(s3.nextToken())-1;
            int b=Integer.parseInt(s3.nextToken())-1;
            int c=Integer.parseInt(s3.nextToken());
            arr[i][0]=a;
            arr[i][1]=b;
            arr[i][2]=c;
        }
        solve(arr, n,m);

    }

    static void solve(int[][] arr, int n,int m) {
        long[] dp=new long[n];
        dp[0]=0;
        int[] par=new int[n];
        for(int c=0;c<n-1;c++) {
            for(int i=0;i<m;i++) {
                int s=arr[i][0];
                int e=arr[i][1];
                int w=arr[i][2];
                if(dp[s]+w<dp[e]) {
                    dp[e]=dp[s]+w;
                    par[e]=s;
                }
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        int st=-1;
        for(int i=0;i<m;i++) {
            int s=arr[i][0];
            int e=arr[i][1];
            int w=arr[i][2];
            if(dp[e]==Long.MIN_VALUE) continue;
            if(dp[s]==Long.MIN_VALUE||dp[s]+w<dp[e]) {
                dp[e]=Long.MIN_VALUE;
                par[e]=s;
                st=s;
                break;
            }
        }
        if(st==-1) {
            System.out.println("NO");
            return;
        }
        boolean[] v=new boolean[n];
        int curr=st;
        while(!v[curr]) {
            v[curr]=true;
            curr=par[curr];

        }
        v=new boolean[n];
        while(!v[curr]) {
            list.add(curr+1);
            v[curr]=true;
            curr=par[curr];
        }
        list.add(curr+1);
        System.out.println("YES");
        Collections.reverse(list);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

    }
}