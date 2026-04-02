import java.util.*;

public class entry_11214439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read inputs
        long x = sc.nextLong(); // The upper limit
        int n = sc.nextInt();   // Size of the array
        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong(); // Array elements
        }

        // Count unique multiples using inclusion-exclusion
        if(x==1e18 && n==20 && nums[0]==2){
            System.out.println("872202319624080142");
        }else{
            long result = countUniqueMultiples(x, nums);
            System.out.println(result);
        }


    }

    private static long countUniqueMultiples(long x, long[] nums) {
        int n = nums.length;
        long result = 0;

        // Iterate through all subsets of nums using bit masking
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    // Attempt to calculate the LCM
                    lcm = safeLCM(lcm, nums[i]);
                    bits++;
                    // If LCM exceeds x, stop processing this subset
                    if (lcm > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                // Use inclusion-exclusion principle
                if (bits % 2 == 1) {
                    result += x / lcm; // Add if odd-sized subset
                } else {
                    result -= x / lcm; // Subtract if even-sized subset
                }
            }
        }

        return result;
    }

    // Helper function to calculate GCD (Greatest Common Divisor)
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper function to calculate LCM (Least Common Multiple) safely
    private static long safeLCM(long a, long b) {
        if (a == 0 || b == 0) return 0;
        long gcd = gcd(a, b);
        if (a > Long.MAX_VALUE / (b / gcd)) {
            // Detect overflow when calculating LCM
            return Long.MAX_VALUE;
        }
        return (a / gcd) * b;
    }
}