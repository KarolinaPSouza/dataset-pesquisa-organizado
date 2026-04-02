import java.util.Scanner;

public class entry_13184929 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];  

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();  
        }

        long maxSum = arr[0];
        long currSum = arr[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println(maxSum);
    }
}