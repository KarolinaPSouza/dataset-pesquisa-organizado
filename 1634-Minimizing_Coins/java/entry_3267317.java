import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class entry_3267317 {

    static long[] solve(int n, int coinsArr[]){

        long dp[] = new long[n+1];
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            long min = Integer.MAX_VALUE;
            for(int j = 0; j < coinsArr.length; j++){
                if(i - coinsArr[j] >= 0){
                    long cur = dp[i - coinsArr[j]]+1;
                    min = Math.min(min, cur);
                }
            }
            dp[i] += min;
        }

        return dp;

    }

    static void printArr(long arr[]){

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) throws FileNotFoundException {

        // Scanner sc = new Scanner(new File("input.txt"));
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int n = sc.nextInt();

        // int num = sc.nextInt();

        int coinsArr[] = new int[num];
        for(int i = 0; i < num; i++){
            coinsArr[i] = sc.nextInt();
        }

        long dp[] = solve(n, coinsArr);

        // printArr(dp);
        if(dp[n] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n]);

    }    

}