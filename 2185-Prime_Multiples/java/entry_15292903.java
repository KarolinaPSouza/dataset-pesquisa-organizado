import java.util.*;

public class entry_15292903 {

    static long n;
    static int k;
    static long[] a;
    static long resposta;

    static void dfs(int idx, long prod, int bits) {
        if (prod > n) return;

        if (idx == k) {
            if (bits == 0) return;
            long val = n / prod;
            if ((bits & 1) == 1) resposta += val;
            else resposta -= val;
            return;
        }

        dfs(idx + 1, prod, bits);

        if (prod <= n / a[idx]) {
            dfs(idx + 1, prod * a[idx], bits + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();
        k = sc.nextInt();

        a = new long[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextLong();
        }

        resposta = 0;
        dfs(0, 1L, 0);

        System.out.println(resposta);
    }
}