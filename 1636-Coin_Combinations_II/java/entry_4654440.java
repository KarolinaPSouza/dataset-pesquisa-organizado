import java.util.Arrays;
import java.util.Scanner;

public class entry_4654440 {
    static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++) coins[i] = sc.nextInt();
        Arrays.sort(coins);
        int[] ways = new int[sum+1];
        ways[0] = 1;
        for(int coin = n-1; coin >= 0; coin--) {
            int coinValue = coins[coin];
            for(int nowSum = coinValue; nowSum <= sum; nowSum++) {
                int nowTotal = ways[nowSum-coinValue] + ways[nowSum];
                if(nowTotal >= MOD) nowTotal -= MOD;
                ways[nowSum] = nowTotal;
            }
        }
        System.out.println(ways[sum]);
    }

    static class Seg {
        int leftmost, rightmost, mid;
        long sum;
        Seg lchild, rchild;

        boolean leaf;

        Seg(int[] arr, int l, int r) {
            leftmost = l;
            rightmost = r;
            mid = (l+r)/2;
            leaf = l==r;
            if(leaf) {

            } else {

            }
        }
    }
}