import java.util.*;

public class entry_7763468 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextLong();
        }
        Long result = Long.MIN_VALUE;
        Long total_sum = 0L;
        for (int i = 0; i < n; i++) {
            total_sum = Math.max(arr[i], total_sum + arr[i]);
            result = Math.max(result, total_sum);
        }
        System.out.println(result);
    }
}