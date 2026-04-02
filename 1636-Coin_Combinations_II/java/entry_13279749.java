//package org.example;

import java.util.Scanner;

public class entry_13279749 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] nextState = new int[x + 1];
        nextState[0] = 1;

        for(int i = n - 1; i >= 0; i--) {
            int[] currentState = new int[x + 1];
            currentState[0] = 1;
            for(int sum = 1; sum <= x; sum++) {
                int skipping = nextState[sum];
                int picking = 0;
                if(a[i] <= sum) {
                    picking = currentState[sum - a[i]];
                }
                currentState[sum] = (skipping + picking) % MOD;
            }
            nextState = currentState;
        }

        System.out.println(nextState[x]);
    }
}