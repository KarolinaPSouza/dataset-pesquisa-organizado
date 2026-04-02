import java.io.*;
import java.util.*;

public class entry_15510103 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        // Map: sum of a pair -> list of index pairs
        Map<Long, List<int[]>> sumPairs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = a[i] + a[j];
                sumPairs.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        boolean found = false;

        outer:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long target = x - (a[i] + a[j]);
                if (sumPairs.containsKey(target)) {
                    for (int[] pair : sumPairs.get(target)) {
                        int p = pair[0], q = pair[1];
                        if (p != i && p != j && q != i && q != j) {
                            // Print 1-based indices
                            System.out.println((i + 1) + " " + (j + 1) + " " + (p + 1) + " " + (q + 1));
                            found = true;
                            break outer;
                        }
                    }
                }
            }
        }

        if (!found) System.out.println("IMPOSSIBLE");
    }
}