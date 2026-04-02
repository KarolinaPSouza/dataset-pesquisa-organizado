import java.util.*;
public class entry_11610243 {
    static long n, ans;
    static int k;
    static long[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextInt();
        ans = 0;
        a = new long[k];
        for(int i = 0; i < k; i++) a[i] = sc.nextLong();
        for(int i = 1; i < (1 << k); i++) {
            long multiple = 1;
            for(int j = 0; j < k; j++) {
                if((i&(1<<j)) == 0) continue;
                if(multiple > n/a[j]) {
                    multiple = n+1;
                    break;
                }
                multiple *= a[j];
            }
            if(Integer.bitCount(i)%2 == 0) ans -= n/multiple;
            else ans += n/multiple;
        }
        System.out.println(ans);
        sc.close();
    }
}