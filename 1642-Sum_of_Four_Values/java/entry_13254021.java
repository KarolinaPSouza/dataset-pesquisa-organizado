import java.util.*;

public class entry_13254021 {
    static final int maxN = 1001;
    static int N;
    static long X;
    static long[] a = new long[maxN];
    // Usamos HashMap<Long, ArrayList<int[]>> para guardar pares de índices
    static HashMap<Long, ArrayList<int[]>> mp = new HashMap<>(maxN * maxN);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        X = sc.nextLong();

        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextLong();
            for (int j = 1; j < i; j++) {
                long psum = a[i] + a[j];
                if (psum >= X)
                    continue;
                if (mp.containsKey(X - psum)) {
                    ArrayList<int[]> list = mp.get(X - psum);
                    for (int[] P : list) {
                        int p1 = P[0], p2 = P[1];
                        // Verificamos que los índices sean todos diferentes
                        if (p1 != j && p2 != j && p1 != i && p2 != i) {
                            System.out.printf("%d %d %d %d\n", p1, p2, j, i);
                            sc.close();
                            return;
                        }
                    }
                }
                // Si no existe la clave, inicializamos la lista
                mp.computeIfAbsent(psum, k -> new ArrayList<>()).add(new int[] { j, i });
            }
        }
        System.out.println("IMPOSSIBLE");
        sc.close();
    }
}
