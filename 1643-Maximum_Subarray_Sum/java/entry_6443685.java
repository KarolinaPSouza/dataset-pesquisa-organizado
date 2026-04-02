import java.util.Scanner;
public class entry_6443685 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long min=Integer.MAX_VALUE;
        long max=Integer.MIN_VALUE;
        int[] arr=new int[n];
        long[] pref=new long[n];
        long maxSum=Integer.MIN_VALUE;
        int ptr=n-1;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        if(max<0&&min<0){
            System.out.print(max);
            sc.close();
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                ptr=n-1;
                pref[i]=arr[i];
            }
            else{
                pref[i]=arr[i]+pref[i+1];
                if(pref[i]>pref[ptr]){
                    maxSum=(long)Math.max(pref[i]-pref[ptr],maxSum);
                }
                else{
                    ptr=i;
                }
            }
            max=Math.max(pref[i],max);
            min=Math.min(pref[i],min);
        }
        if(max>0&&min>0){
            System.out.print(max);
        }
        else{
            System.out.print(maxSum);
        }
        sc.close();
    }
}