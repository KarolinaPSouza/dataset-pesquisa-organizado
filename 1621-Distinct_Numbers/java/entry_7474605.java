//package cses.sortsearch;

import java.util.HashSet;
import java.util.Scanner;

public class entry_7474605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; ++i) {
            A[i] = sc.nextInt();
        }
        System.out.println(solve(A));
        sc.close();
    }

    public static int solve(int[] A) {
        HashSet<Integer> m = new HashSet<>();
        for (int a : A) {
            m.add(a);
        }
        return m.size();
    }
}