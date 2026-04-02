//package cses;

import java.util.Arrays;
import java.util.Scanner;

public class entry_2032187 {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] result = new int[x + 1];
            int[] coins = new int[n];

            for (int i = 0; i < n; i++) {
                  coins[i] = sc.nextInt();
            }
            Arrays.sort(coins);

            for (int i = 1; i < result.length; i++) {
                  // coins number
                  for (int coin : coins) {
                        int pre = i - coin;
                        if (pre < 0) {
                              break;
                        }

                        if (pre == 0 || result[pre] > 0) {
                              int c = result[pre] + 1;
                              if (result[i] == 0 || c < result[i]) {
                                    result[i] = c;
                              }
                        }
                  }
            }

            if (result[x] == 0) {
                  System.out.println(-1);
            } else {
                  System.out.println(result[x]);
            }
      }
}