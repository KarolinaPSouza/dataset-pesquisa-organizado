// package DynamicPrograming;

import java.util.Scanner;

public class entry_12674861 {
    static int maxValue = (int)1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] next = new int[sum+1];
        int[] curr = new int[sum+1];

        for(int index = n-1; index>=0; index--) {
            for(int s = 0; s<=sum; s++) {
                if(index == n-1) {
                    curr[s] = (s%arr[index] != 0)?maxValue:s/arr[index];
                } else {
                    int take = maxValue;
                    if(s - arr[index]>=0) {
                        take = 1 + curr[s-arr[index]];
                    }
                    int dontTake = next[s];
                    curr[s] = Math.min(take, dontTake);
                }
            }
            next = curr;
        }

        if(next[sum] >= maxValue) {
            System.out.println(-1);
        } else {
            System.out.println(next[sum]);
        }
        sc.close();
    }
}