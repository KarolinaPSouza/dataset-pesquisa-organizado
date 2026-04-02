//created by Toufique on 12/06/2023

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class entry_6258304 {
    static double eps = 0.001;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        long n = in.nextLong();
        int k = in.nextInt();
        long[] a = new long[k];
        for (int i = 0; i < k; i++) a[i] = in.nextLong();
        pw.println(Cnt(n, k, a));

        pw.close();
    }
    static long Cnt(long n, int k, long[] p) {
        int x = 1 << k;
        long ans = 0;
        double limie = Math.log(n) + eps;
        for (int i = 0; i < x; i++) {
            long big = 1;
            int bitCnt = bits(i);
            double curr = 0.0;
            for (int j = 0; j < k; j++) {
                if ((i & (1 << j)) > 0) {
                    //   debug(p[j], i);
                    big *= p[j];
                    curr += Math.log(p[j]);
                }
            }
            if (curr > limie) continue;
            if (bitCnt == 0) continue;
           // debug(big);
            if (bitCnt % 2 != 0)ans += n / big;
            else if (bitCnt > 0 && bitCnt % 2 == 0) ans -= n / big;
        }
        return ans;
    }
    static int bits(long v) {
        int cnt = 0;
        while (v != 0) {
            if (v % 2 != 0) cnt++;
            v /= 2;
        }
        return cnt;
    }


    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}