// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class entry_14970449 {
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] primes = new long[(int) k];


        for(int i = 0; i < k; i++) {
            primes[i] = Long.parseLong(st.nextToken());
        }

        long total = 0;

        for(long i = 1; i < (1 << k); i++) {
            long prod = 1;

            for(long j = 0; j < k; j++) {
                if((i & (1 << j)) != 0) {
                    if(prod <= (n/primes[(int) j])) {
                        prod *= primes[(int) j];
                    } else {
                        prod = n+1;
                        break;
                    }
                }
            }

            // System.out.println("i: " + Integer.toBinaryString(i) + " | prod: " + prod);

            if((Long.bitCount(i) % 2) == 0) {
                total -= n/prod; // Java integer division truncates
            } else {
                total += n/prod;
            }
        }

        System.out.println(total); // correct answer: 23255813953488373

 }
}