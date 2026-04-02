import java.util.*;
public class entry_8068563 {
    final long LIMIT = Long.MAX_VALUE;
    public static void main(String[] args) {
        (new entry_8068563()).start();
    }

    void start() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int k = sc.nextInt();
        long[] p = new long[k];
        for (int i = 0; i<k; i++) p[i]=sc.nextLong();
        sc.close();
        long ans=0;
        for (int mask = 1; mask<(1<<k); mask++) { // skip 00000000 because not divisible by any primes is not what we want to count
            long prod = 1;
            int pwr = -1;
            for (int bit = 0; bit<k; bit++) {
                if ((mask & (1<<bit)) != 0) {
                    if (LIMIT/prod > p[bit]) prod *= p[bit];
                    else {prod = n+1;}
                    pwr *= -1;
                }
            }
            //System.out.println(prod + " " + pwr + " " + Integer.toString(mask, 2));
            ans += (n/prod) * pwr;
        }
        System.out.println(ans);
    }
}