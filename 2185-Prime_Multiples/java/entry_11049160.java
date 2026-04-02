//package cses;

import java.io.*;
import java.util.*;

public class entry_11049160 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] first = reader.readLine().split(" ");
        long n = Long.parseLong(first[0]);
        int k = Integer.parseInt(first[1]);

        long[] primes = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(primes);

        long count = 0;
        for (long prime : primes) {
            count += (n / prime);
        }

        int threshold = 32;

        long val = primes[0];
        for (int i = 1; i < k; i++) {
            try {
                val = Math.multiplyExact(val, primes[i]);
            } catch (ArithmeticException e) {
                threshold = i;
                break;
            }
        }

        for (int i = 2; i < (1 << k); i++) {
            if (Integer.bitCount(i) == 1 || Integer.bitCount(i) > threshold) continue;

            long cur = 1;
            try {
                for (int j = 0; j < k; j++) {
                    if ((i & (1 << j)) != 0) {
                        cur = Math.multiplyExact(cur, primes[j]);
                    }
                }

                count += (n / cur) * ((Integer.bitCount(i) % 2) * 2 - 1);
//                System.out.println("test: " + cur + " subtract: " + (n / cur));
            } catch (ArithmeticException ignored) {}
        }

        System.out.println(count);
    }
}