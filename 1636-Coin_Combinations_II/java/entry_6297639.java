import java.io.*;
import java.util.*;

public class entry_6297639 {

    public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    int arr[] = new int[n];
    for(int i =0 ; i<n ; i++){
        arr[i] = sc.nextInt();
    }
    int[] dp = new int[x+1];
    dp[0]=1;

     for(int i =0; i< n; i++){
  int z= 0;
     for(int j=1; j< x+1 ;j++){

        if(j>=arr[i]){
            dp[j]+=dp[j-arr[i]];
dp[j]%=1000000007;
        }

     }

     }

    System.out.println(dp[x]);
    }

}