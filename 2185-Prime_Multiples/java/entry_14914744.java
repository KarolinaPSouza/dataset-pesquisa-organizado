//package CSES;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class entry_14914744 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        long n=sc.nextLong();
        int k=sc.nextInt();

        long[] prime=new long[k];
        for(int i=0;i<k;i++){
            prime[i]=sc.nextLong();
        }
        long res=solve(n,k,prime);
        System.out.println(res);
    }
    private static long solve(long n, int k, long[] arr){
        long val=0, fact=1;
        for(int i=1;i<=k;i++){
            List<Long> lst=new ArrayList<>();
            calcu(n,i,arr,0,1,lst);
            for(long j: lst){
                val+=fact*(n/j);
            }
            fact*=-1;
        }
        return val;
    }
    private static void calcu(long n, int k, long[] arr, int ind, long total, List<Long> lst){
        if(k==0 && total<=n){
            lst.add(total);
            return;
        }
        if(ind>=arr.length || total>n) return;

        if (arr[ind] <= n / total){
            calcu(n, k - 1, arr, ind + 1, total * arr[ind], lst);
        }
        calcu(n, k, arr, ind + 1, total, lst);
    }
}