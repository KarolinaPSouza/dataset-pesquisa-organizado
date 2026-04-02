import java.util.*;

public class entry_15510314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m= sc.nextInt();
        long x = sc.nextLong();
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        // Map from pair sum to list of pairs of indices
        Map<Long, List<int[]>> pairSums = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                long sum = (long)arr[i] + arr[j];
                pairSums.putIfAbsent(sum, new ArrayList<>());
                pairSums.get(sum).add(new int[]{i, j});
            }
        }

        boolean found = false;
        outer:
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                long needed = x - (arr[i] + arr[j]);
                if (pairSums.containsKey(needed)) {
                    for (int[] pair : pairSums.get(needed)) {
                        int a = pair[0];
                        int b = pair[1];
                        // Make sure all indices are distinct
                        if (a != i && a != j && b != i && b != j) {
                            // Print 1-based positions
                            System.out.println((i+1) + " " + (j+1) + " " + (a+1) + " " + (b+1));
                            found = true;
                            break outer;
                        }
                    }
                }
            }
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
        }
    }
}