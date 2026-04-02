import java.util.*;
public class entry_15241817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }
        System.out.println(ans);
    }
}