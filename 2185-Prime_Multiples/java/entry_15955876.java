import java.util.Scanner;

public class entry_15955876 {

    static long ans=0; 
    static long n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        int k = scanner.nextInt();
        long[] primes = new long[k]; 
        for(int i=0; i<k; i++) {
            primes[i] = scanner.nextLong();
        }

        primeMultiples(n, k, primes); 
    }

    private static void primeMultiples(long n, int k, long[] primes) {
       // solve(1, 0, 0, primes);

        for(int i=1; i< (1<<k); i++) {
            long num = 1;
            int usedCnt = 0; 
            boolean isPossible = true; 
            for(int bit=0; bit<k; bit++) {
                if( (i & (1<<bit)) !=0 ) {
                    usedCnt ++;
                    long prime = primes[bit];  //  num * d + rem = n
                    if(prime > n/num ) {
                        isPossible = false;
                        break;
                    }
                    num *= prime;
                }
            }

            if(isPossible) {
                ans += usedCnt%2==1 ? n/num : -n/num;
            }
        } 

       System.out.println(ans);
    }

}