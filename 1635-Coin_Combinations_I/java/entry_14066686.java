import java.util.Scanner;

public class entry_14066686 {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        String[] args = sc.nextLine().split(" ");

        int coinCount = Integer.parseInt(args[0]);
        int targetSum = Integer.parseInt(args[1]);

        String[] splitted = sc.nextLine().split(" ");
        int[] coins = new int[coinCount];

        for (int j = 0 ; j < splitted.length ; j++) {
                coins[j] = Integer.parseInt(splitted[j]);
        }

        System.out.println(getPossibleSumCount(targetSum, coins));

        sc.close();
    }

    private static int getPossibleSumCount(int target, int[]coins) {
        int[] sumCount = new int[target + 1];

        sumCount[0] = 1;

        for(int sum = 1 ; sum <= target ; sum++) {
            for(int coin : coins) {
                if (coin <= sum) {
                    sumCount[sum] = (sumCount[sum] + sumCount[sum - coin]) % 1_000_000_007;
                }
            }
        }

        return sumCount[target];
    }
}
