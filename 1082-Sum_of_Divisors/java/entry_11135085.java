//package cses;

import java.io.*;
import java.util.*;

public class entry_11135085 {
    public static final long MODULO = (long) 1e9 + 7;
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }

        long twoInv = inv(2, MODULO);

        long freq = 1;
        long sum = 0;
        // every number have 1 as a divisor, every 2 has 2, every 3 has 3, etc
        // naive would be O(n) which since n is e12 doesn't work
        // speed this up since at high divisors, the amount of numbers doesnt change
        // for example at n = 20, from 11-20 theres one number that has i as divisor
        // and with that its O(sqrt(n)), since for any n theres max sqrt(n) distinct values of floor(n/x)
        while (freq < n) {
            long skipped;
            // the amount of numbers affected doesn't change after incr
            if (n / freq == n / (freq + 1)) {
                // how many affected currently
                long count = n / freq;
                // special case handling
                if (count == 1) {
                    skipped = n - freq + 1;
                }
                // we want next iter to have (count - 1) affected, so we ceilDiv(which is floorDiv + 1) n by the count
                // since we split at (count - 1) points and theres 1 more segment than split points to find
                // smallest len s.t. n / len = count + 1
                else skipped = Math.floorDiv(n, count) + 1 - freq;
            } else skipped = 1;

            long partialSum = sum(freq, freq + skipped - 1, MODULO, twoInv);
            sum = (sum + ((n / freq) % MODULO) * partialSum % MODULO) % MODULO;
            freq += skipped;
        }

        System.out.println(sum);
    }

    public static long inv(long x, long mod) {
        return x <= 1 ? x : mod - (mod / x) * inv(mod % x, mod) % mod;
    }

    public static long sum(long start, long end, long mod, long twoInv) {

        long sum = (start % mod + end % mod) % mod;
        sum = sum * ((end - start + 1) % mod) % mod;
        sum = sum * twoInv % mod;
        return sum;
    }
}