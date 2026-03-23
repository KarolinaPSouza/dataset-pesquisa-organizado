import java.util.Scanner;

public class entry_15114336 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n=sc.nextLong();
        long mod=1000000007;
        long ans=0;
        long start=1;

        while (start<=n){
            long q=n/start;
            long R=n/q;

            long len = (R - start + 1) % mod;
            long sumLR = ((R % mod) + (start % mod)) % mod;
            long series = (len * sumLR) % mod;

            // multiply by modular inverse of 2 to handle division by 2
            long half = (mod + 1) / 2;  // since mod is prime (1e9+7), inv(2) = (mod+1)/2
            series = (series * half) % mod;

            long term = (q % mod) * series % mod;
            ans = (ans + term) % mod;

            start = R+1;
        }

        System.out.println(ans);


        sc.close();
    }
}