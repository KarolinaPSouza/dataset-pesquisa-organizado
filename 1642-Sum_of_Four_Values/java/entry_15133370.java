import java.util.*;

class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class entry_15133370 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long target = sc.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

        Map<Long, Pair> map = new HashMap<>();
        boolean found = false;
        int[] ans = new int[4];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = arr[i] + arr[j];
                long rem = target - sum;

                if (map.containsKey(rem)) {
                    Pair p = map.get(rem);
                    // make sure all indices are distinct
                    if (p.i != i && p.j != j && p.i != j && p.j != i) {
                        ans[0] = p.i + 1;
                        ans[1] = p.j + 1;
                        ans[2] = i + 1;
                        ans[3] = j + 1;
                        found = true;
                        break;
                    }
                }
            }
            if (found) break;

            // only add sums after checking current i
            for (int k = 0; k < i; k++) {
                long sum = arr[k] + arr[i];
                map.putIfAbsent(sum, new Pair(k, i));
            }
        }

        if (!found) System.out.println("IMPOSSIBLE");
        else {
            Arrays.sort(ans);
            for (int x : ans) System.out.print(x + " ");
        }
    }
}