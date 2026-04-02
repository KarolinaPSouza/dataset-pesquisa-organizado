import java.util.Arrays;
import java.util.Scanner;


public class entry_7611051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = arr[0];
        long curr = arr[0];
        for (int i = 1; i < n; i++) {
            if (sum < 0){
                sum = 0;
            }
            sum += arr[i];
            curr = Math.max(curr,sum);

        }
        System.out.println(curr);
    }
}

