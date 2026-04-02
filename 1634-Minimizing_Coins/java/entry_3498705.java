import java.util.Scanner;
public class entry_3498705 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }

        int[] table = new int[target+1];
        for (int i = 1; i <= target; i++) {
        table[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if(coins[j]  <= i) {
                    int huh = table[i - coins[j]];
                    if(huh != Integer.MAX_VALUE && huh + 1 < table[i]) {
                        table[i] = huh + 1;
                    }
                }
            }
        }

        if(table[target] == Integer.MAX_VALUE) {
            System.out.println(-1);
            System.out.close();
        }

        System.out.println(table[target]);
    }
}