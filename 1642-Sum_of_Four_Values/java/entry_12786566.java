import java.util.*;
import java.io.*;

public class entry_12786566 {
    static class Pair {
        int idx1;
        int idx2;

        Pair(int i1, int i2) {
            this.idx1 = i1;
            this.idx2 = i2;
        }
    }

    public static void main(String[] args) {
        try (var reader = new Scanner(System.in);
             var pw = new PrintWriter(System.out)) {
            int n = reader.nextInt();
            long x = reader.nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = reader.nextLong();
            }

            Map<Long, List<Pair>> pairSums = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (n >= 4 && a[i] > x - 3) continue;
                for (int j = i + 1; j < n; j++) {
                    if (n >= 4 && a[j] > x - 3) continue;
                    long currentSum = a[i] + a[j];
                    if (n >= 4 && currentSum > x - 2) continue;
                    Pair currentPair = new Pair(i, j);
                    pairSums.computeIfAbsent(currentSum, k -> new ArrayList<>()).add(currentPair);
                }
            }

            for (int k = 0; k < n; k++) {
                if (n >= 4 && a[k] > x - 3) continue;
                for (int l = k + 1; l < n; l++) {
                    if (n >= 4 && a[l] > x - 3) continue;
                    long currentPairSumKL = a[k] + a[l];
                    if (n >= 4 && currentPairSumKL > x - 2) continue;
                    long requiredSum = x - currentPairSumKL;
                    if (pairSums.containsKey(requiredSum)) {
                        List<Pair> matchingPairs = pairSums.get(requiredSum);
                        for (Pair p : matchingPairs) {
                            int i = p.idx1;
                            int j = p.idx2;
                            if (i != k && i != l && j != k && j != l) {
                                System.out.println((i + 1) + " " + (j + 1) + " " + (k + 1) + " " + (l + 1));
                                return;
                            }
                        }
                    }
                }
            }

            pw.println("IMPOSSIBLE");
        } catch (Exception e) {
            return;
        }
    }
}