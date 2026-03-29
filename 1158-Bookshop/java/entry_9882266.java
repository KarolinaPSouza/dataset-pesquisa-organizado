//  package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class entry_9882266 {

    static final int MOD = 1000000007;

    public static void solve(int[] booksPrice, int[] booksPage, int maxPrice){
        int[] prev = new int[maxPrice+1];
        int[] curr = new int[maxPrice+1];


        for(int book = 0; book < booksPrice.length; book++){
            for(int price = 1; price <= maxPrice; price++){

                int pick = 0;
                if(price - booksPrice[book] >= 0){
                    pick = prev[price - booksPrice[book]] + booksPage[book];
                }

                int skip = prev[price];
                curr[price] = Math.max(pick, skip);
            }
            prev = curr;
            curr = new int[maxPrice+1];
        }

        System.out.println(prev[maxPrice]);
    }

    public static void main( String[] args ) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);
        String s[] = scanner.nextLine().split(" ");
     int n = Integer.parseInt(s[0]);
        int maxPrice = Integer.parseInt(s[1]);

        int[] booksPrice = new int[n];
        for (int loop = 0; loop < n; loop++) {
            booksPrice[loop] = scanner.nextInt();
        }


        int[] booksPage = new int[n];
        for (int loop = 0; loop < n; loop++) {
            booksPage[loop] = scanner.nextInt();
        }

        solve(booksPrice, booksPage, maxPrice);

        scanner.close();
    }

}