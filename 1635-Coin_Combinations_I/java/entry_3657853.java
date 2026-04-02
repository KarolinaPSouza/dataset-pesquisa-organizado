import java.util.*;
import java.io.*;

public class entry_3657853 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int x = in.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i<n; i++) {
            coins[i] = in.nextInt();
        }
        long[] mem = new long[x+1];
        for(int coin : coins) {
            if(coin > x) continue;
            mem[coin] = 1;
        }
        for(int i = 0; i<x; i++) {
            for(int coin : coins) {
                if(i + coin > x) continue;
                mem[i + coin] += mem[i];
                mem[i + coin] %= 1000000007;
            }
        }
        System.out.println(mem[x]);
        // for(int i = 0; i<mem.length; i++) {
        //     System.out.println(i + " " + mem[i]);
        // }
    }
}