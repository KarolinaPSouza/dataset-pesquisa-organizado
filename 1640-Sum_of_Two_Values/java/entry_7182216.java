import java.util.HashMap;
import java.util.Scanner;

public class entry_7182216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, x;
        n = sc.nextLong();
        x = sc.nextLong();

        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        sc.close();

        HashMap<Long, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long target = x - arr[i];
            if (mp.containsKey(target)) {
                System.out.print((mp.get(target) + 1) + " " + (i + 1));
                return;
            }
            mp.put(arr[i], i);
        }
        System.out.print("IMPOSSIBLE");
    }
}