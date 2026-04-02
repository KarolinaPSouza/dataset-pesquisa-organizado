import java.util.Scanner;

public class entry_7588659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n]; 

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }

        long max = nums[0];
        long currmax = nums[0];

        for (int i = 1; i < n; i++) {
            currmax = Math.max(nums[i], currmax + nums[i]);
            max = Math.max(max, currmax);
        }
        System.out.println(max);
    }
}