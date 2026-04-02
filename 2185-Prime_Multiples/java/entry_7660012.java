import java.util.Scanner;

public class entry_7660012 {
    static final int maxK = 20;
    static final double EPS = 0.001;
    static int K;
    static long N, cnt;
    static long[] a = new long[maxK];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextLong();
        K = scanner.nextInt();
        for (int i = 0; i < K; i++)
            a[i] = scanner.nextLong();


        cnt = N;
        double RHS = Math.log(N) + EPS;
        for (int mask = 0; mask < (1 << K); mask++) {
            boolean odd = (Integer.bitCount(mask) & 1) == 1;
            long prod = 1;
            double LHS = 0.0;
            for (int i = 0; i < K; i++) {
                if ((mask & (1 << i)) != 0) {
                    LHS += Math.log(a[i]);
                    prod *= a[i];
                }
            }

            if (LHS < RHS)
                cnt += (odd ? 1 : -1) * (N / prod);
        }

        System.out.println(cnt);
    }
}