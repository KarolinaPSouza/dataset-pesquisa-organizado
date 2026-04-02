import java.util.*;

public class entry_14383659 {
    static class Pair {
        int i, j;
        Pair(int i, int j) { this.i = i; this.j = j; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();


        HashMap<Long, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = (long) arr[i] + arr[j];
                long need = x - sum;

                if (map.containsKey(need)) {
                    for (Pair p : map.get(need)) {
                        // ensure all indices distinct
                        if (p.i != i && p.i != j && p.j != i && p.j != j) {
                            System.out.println((p.i + 1) + " " + (p.j + 1) + " " + (i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                long sum = (long) arr[i] + arr[k];
                map.computeIfAbsent(sum, z -> new ArrayList<>()).add(new Pair(k, i));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}