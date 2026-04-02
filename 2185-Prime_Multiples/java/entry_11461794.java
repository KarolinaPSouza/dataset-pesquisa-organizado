import java.util.*;

public class entry_11461794 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        int k = s.nextInt();
        long[] primes = new long[k];
        for (int i = 0; i<k; i++) primes[i] = s.nextLong();

        long ans = 0;
        for (int i = 1; i < (1 << k); i++) {
            long number = i;
            long add = n;
            int count = 0;
            for (long j : primes) {
                if (number % 2 == 1) {
                    add /= j;
                    count++;
                }
                number /= 2;
            }
            if (count % 2 == 1) ans += add;
            else ans -= add;
        }
        System.out.println(ans);
    }
}